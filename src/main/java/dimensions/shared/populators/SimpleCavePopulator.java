package dimensions.shared.populators;


import libs.FastNoiseLite;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class SimpleCavePopulator extends BlockPopulator {

    static FastNoiseLite noiseGen;
    static boolean innited = false;

    public static void innitFNL(){

        noiseGen = new FastNoiseLite();

        noiseGen.SetFractalType(FastNoiseLite.FractalType.PingPong);

        noiseGen.SetFractalPingPongStrength(1f);

        noiseGen.SetNoiseType(FastNoiseLite.NoiseType.Perlin);

        noiseGen.SetFrequency(0.01f);

        innited = true;
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        if(!innited)
            innitFNL();

        noiseGen.SetSeed((int) world.getSeed());


        boolean[][][] caveMap = new boolean[16][world.getMaxHeight()][16];

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 5; y < world.getMaxHeight() - 10; y++) {
                    double noise = noiseGen.GetNoise(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z);
                    if (noise > 0.9) {
                        caveMap[x][y][z] = true;
                    }
                }
            }
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 5; y < world.getMaxHeight() - 10; y++) {
                    if (caveMap[x][y][z]) {


                         if(y > 10) {


                            chunk.getBlock(x, y, z).setType(Material.AIR, false); // Super Wichtig: false = Verhindert Block-Updates! Sonst -> Too many neighbouring chain updates -> Crash /!\
                        }
//                        }else if(celutis.randomrange(0,2) == 0){
//
//                            System.out.println("2: " + y);
//                            chunk.getBlock(x, y, z).setType(Material.AIR, false); // Super Wichtig: false = Verhindert Block-Updates! Sonst -> Too many neighbouring chain updates -> Crash /!\
//
//                        }

                    }
                }
            }
        }
    }
}

