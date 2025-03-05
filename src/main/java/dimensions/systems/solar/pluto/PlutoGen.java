
package dimensions.systems.solar.pluto;

import dimensions.systems.solar.common.CommonSolarStructurePop;
import libs.FastNoiseLite;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.List;
import java.util.Random;

import static cel.space.celutis.randomrange;
import static cel.space.celutis.randomrangeSecure;

public class PlutoGen extends ChunkGenerator {
    int currentHeight;

    public PlutoGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return List.of(new PlutoPop(), new CommonSolarStructurePop());

    }

    private boolean isInnited = false;
    SimplexOctaveGenerator generator;
    SimplexOctaveGenerator gen2;
    FastNoiseLite fnl;
    FastNoiseLite fnl2;

    private void innit(World world){
        generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        final SimplexOctaveGenerator gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);

        fnl = new FastNoiseLite();
        fnl.SetSeed((int) world.getSeed());
        fnl.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        fnl.SetFrequency(0.004f);

        fnl2 = new FastNoiseLite();
        fnl2.SetSeed((int) world.getSeed());
        fnl2.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        fnl2.SetFrequency(0.0004f);
    }

    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {

        if(!isInnited){
            innit(world);
        }

        final ChunkData chunk = this.createChunkData(world);

        int[][] currH = new int[16][16];

        generator.setScale(0.0015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 7.0 + 145);

                currentHeight += (int) (Math.tanh(fnl.GetNoise(chunkX * 16 + X, chunkZ * 16 + Z) * 1.7f) * 15);

                currentHeight += (int) (Math.tanh(fnl2.GetNoise(chunkX, chunkZ) * 1.7f) * 7);


                currH[X][Z] = currentHeight;

                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }


                //STONE & ORES
                for (int i = this.currentHeight; i > 140; --i) {

                    chunk.setBlock(X, i, Z, Material.BLUE_ICE);

                }

                for (int i = Math.min(140, this.currentHeight); i > 100; --i) {

                    chunk.setBlock(X, i, Z, Material.PACKED_ICE);

                }

                for (int i = Math.min(100, this.currentHeight); i > world.getMinHeight()+10; --i) {

                    chunk.setBlock(X, i, Z, Material.ICE);

                }

                for (int i = world.getMinHeight()+10; i > world.getMinHeight()+1; --i) {

                    chunk.setBlock(X, i, Z, Material.WATER);

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
