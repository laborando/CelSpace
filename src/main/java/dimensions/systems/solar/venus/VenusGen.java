
package dimensions.systems.solar.venus;

import cel.space.celutis;
import dimensions.shared.populators.SimpleCavePopulator;
import dimensions.systems.solar.common.CommonSolarStructurePop;
import libs.FastNoiseLite;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.List;
import java.util.Random;

public class VenusGen extends ChunkGenerator {
    int currentHeight;


    public VenusGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return List.of(new VenusPop(), new CommonSolarStructurePop(), new SimpleCavePopulator());

    }


    private boolean isInnited = false;
    SimplexOctaveGenerator generator;
    SimplexOctaveGenerator gen2;
    FastNoiseLite fnl;

    private void innit(World world){
        generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);

        fnl = new FastNoiseLite();
        fnl.SetSeed((int) world.getSeed());
        fnl.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        fnl.SetFrequency(0.004f);
    }

    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {

        if(!isInnited){
            innit(world);
        }



        final ChunkData chunk = this.createChunkData(world);

        generator.setScale(0.0015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 7.0 + 75.0);

                int currdif = (int) (gen2.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 0.1);

                currentHeight += currdif;

                currentHeight += (int) (Math.tanh(fnl.GetNoise(chunkX * 16 + X, chunkZ * 16 + Z) * 1.7f) * 30);

                if(celutis.randomrange(0,3) == 0){
                    currentHeight -= 1;
                }

                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }


                if(celutis.randomrange(0, 3) == 0){
                    chunk.setBlock(X, currentHeight, Z, Material.COBBLESTONE);
                }else if(celutis.randomrange(0, 9) < 3) {
                    chunk.setBlock(X, currentHeight, Z, Material.BASALT);
                }else{
                    chunk.setBlock(X, currentHeight, Z, Material.STONE);
                }



                //Oberster Layer
                chunk.setBlock(X, this.currentHeight - 1, Z, Material.STONE);


                //STONE & ORES
                for (int i = this.currentHeight - 2; i > world.getMinHeight()+1; --i) {


                    if(celutis.randomrange(0, 9) == 0){
                        chunk.setBlock(X, i, Z, Material.COBBLESTONE);
                    }else if(celutis.randomrange(0, 9) > 1) {
                        chunk.setBlock(X, i, Z, Material.BASALT);
                    }else{
                        chunk.setBlock(X, i, Z, Material.STONE);
                    }


                }


                chunk.setBlock(X, world.getMinHeight()+1, Z, Material.BEDROCK);

            }
        }


        return chunk;
    }
    @Override
    public boolean shouldGenerateMobs(){
        return false;
    }

}
