package dimensions.shared.populators;


import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

public class SimpleCavePopulator extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        SimplexOctaveGenerator noiseGen = new SimplexOctaveGenerator(world.getSeed(), 8);
        noiseGen.setScale(0.09);

        boolean[][][] caveMap = new boolean[16][world.getMaxHeight()][16];

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 5; y < world.getMaxHeight() - 10; y++) {
                    double noise = noiseGen.noise(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z, 0.5, 0.5);
                    if (noise > 0.5) {
                        caveMap[x][y][z] = true;
                    }
                }
            }
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 5; y < world.getMaxHeight() - 10; y++) {
                    if (caveMap[x][y][z]) {
                        chunk.getBlock(x, y, z).setType(Material.AIR, false); // Super Wichtig: false = Verhindert Block-Updates! Sonst -> Too many neighbouring chain updates -> Crash /!\
                    }
                }
            }
        }
    }
}

