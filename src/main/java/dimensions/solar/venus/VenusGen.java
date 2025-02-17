
package dimensions.solar.venus;

import Libs.FastNoiseLite;
import cel.space.celutis;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VenusGen extends ChunkGenerator {
    int currentHeight;



    public VenusGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return Arrays.asList(new VenusPop());

    }


    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {


        final SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        final SimplexOctaveGenerator gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);

        final FastNoiseLite fnl = new FastNoiseLite();
        fnl.SetSeed((int) world.getSeed());
        fnl.SetNoiseType(FastNoiseLite.NoiseType.Cellular);


        final ChunkData chunk = this.createChunkData(world);

        generator.setScale(0.0015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 7.0 + 50.0);

                int currdif = (int) (gen2.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 0.1);

                currentHeight += currdif;

                if(celutis.randomrange(0,3) == 0){
                    currentHeight -= 1;
                }

                /*
                float chdiff = ((int) Math.pow(50, -1f * fnl.GetNoise(chunkX * 16 + X, chunkZ * 16 + Z))) / 10f;
                currentHeight += Math.max(-25, Math.min(25, (int) Math.pow(chdiff, 5) / 5000));

                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }
                */

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
