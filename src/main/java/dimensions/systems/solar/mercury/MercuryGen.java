
package dimensions.systems.solar.mercury;

import dimensions.systems.solar.common.CommonSolarStructurePop;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.List;
import java.util.Random;

import static cel.space.celutis.randomrange;
import static cel.space.celutis.randomrangeSecure;

public class MercuryGen extends ChunkGenerator {
    int currentHeight;

    public MercuryGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return List.of(new MercuryPop(), new CommonSolarStructurePop());

    }


    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {
        final SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        final SimplexOctaveGenerator gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);
        final ChunkData chunk = this.createChunkData(world);

        int[][] currH = new int[16][16];

        generator.setScale(0.0015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 7.0 + 50.0);

                currH[X][Z] = currentHeight;

                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }

                chunk.setBlock(X, currentHeight, Z, Material.STONE);

                //Oberster Layer
                chunk.setBlock(X, this.currentHeight - 1, Z, Material.STONE);


                //STONE & ORES
                for (int i = this.currentHeight - 2; i > world.getMinHeight()+1; --i) {

                    chunk.setBlock(X, i, Z, Material.STONE);

                }


                chunk.setBlock(X, world.getMinHeight()+1, Z, Material.BEDROCK);

            }
        }

        
//ERZE
        for (int i = 0; i < 50; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-3, 1), z, Material.IRON_ORE);
        }
        for (int i = 0; i < 7; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-10, 1), z, Material.GOLD_ORE);
        }
        for (int i = 0; i < 1; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-20, 1), z, Material.DIAMOND_ORE);
        }
        for (int i = 0; i < 30; i++) {
            int x = randomrange(0, 15);
            int z = randomrange(0, 15);
            int th = currH[x][z];
            chunk.setBlock(x , randomrangeSecure(1, th-20, 1), z, Material.COAL_ORE);
        }
        //ENDE ERZE

        return chunk;
    }
    @Override
    public boolean shouldGenerateMobs(){
        return false;
    }

}
