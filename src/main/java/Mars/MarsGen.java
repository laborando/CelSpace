
package Mars;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MarsGen extends ChunkGenerator {
    int currentHeight;

    public MarsGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return Arrays.asList(new MarsPop());

    }


    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {
        final SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        final SimplexOctaveGenerator gen2 = new SimplexOctaveGenerator(new Random(world.getSeed() * -1), 8);
        final ChunkData chunk = this.createChunkData(world);

        generator.setScale(0.015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                this.currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.1, 0.1) * 7.0 + 50.0);


                if (currentHeight > world.getMaxHeight() || currentHeight < 0) {
                    currentHeight = world.getMaxHeight() - 1;
                }

                chunk.setBlock(X, currentHeight, Z, Material.RED_SAND);

                //Oberster Layer
                chunk.setBlock(X, this.currentHeight - 1, Z, Material.RED_SAND);


                //STONE & ORES
                for (int i = this.currentHeight - 2; i > 0; --i) {

                    chunk.setBlock(X, i, Z, Material.RED_SAND);

                }


                chunk.setBlock(X, 0, Z, Material.BEDROCK);

            }
        }


        return chunk;
    }

    private static int randomrange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min!");
        }
        final Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    @Override
    public boolean shouldGenerateMobs(){
        return false;
    }

}
