
package dimensions.solar.mars;

import dimensions.shared.populators.SimpleCavePopulator;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static cel.space.celutis.randomrange;
import static cel.space.celutis.randomrangeSecure;

public class MarsGen extends ChunkGenerator {
    int currentHeight;

    boolean innit = false;

    static SimplexOctaveGenerator generator;
    static SimplexOctaveGenerator gen2;
    static SimplexOctaveGenerator gen3;

    public MarsGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return Arrays.asList(new MarsTerrainPop(), new SimpleCavePopulator(), new MarsStructurePop());

    }


    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {

        final ChunkData chunk = this.createChunkData(world);

        if(!innit){

            generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
            gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);
            gen3 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);

            generator.setScale(0.015);
            gen2.setScale(0.015);
            gen3.setScale(0.015);

            innit = true;
        }

        int[][] currH = new int[16][16];

        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.2) * 7.0 + 150.0);

                int currdif = (int) (gen2.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.2) * 7.0);

                currentHeight += currdif;

                currdif = (int) (gen3.noise(chunkX, chunkZ, 0.1, 0.2) * 7.0);

                currentHeight += currdif;

                currH[X][Z] = currentHeight;

                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }

                chunk.setBlock(X, currentHeight, Z, Material.RED_SAND);

                //Oberster Layer
                chunk.setBlock(X, this.currentHeight - 1, Z, Material.RED_SAND);


                //STONE & ORES
                for (int i = this.currentHeight - 2; i > 0; --i) {

                    chunk.setBlock(X, i, Z, Material.RED_SANDSTONE);

                }


                chunk.setBlock(X, 0, Z, Material.BEDROCK);

            }
        }

        //ERZE
        for (int i = 0; i < 30; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-3, 1), z, Material.IRON_ORE);
        }
        for (int i = 0; i < 15; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-10, 1), z, Material.GOLD_ORE);
        }
        for (int i = 0; i < 4; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-20, 1), z, Material.DIAMOND_ORE);
        }
        //ENDE ERZE

        return chunk;
    }

    @Override
    public boolean shouldGenerateMobs(){
        return false;
    }

}
