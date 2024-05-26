package dimensions.mars;
import cel.space.celutis;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import utis.TripleInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cel.space.celutis.randomrange;

public class MarsPop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {



        int amount = random.nextInt(5) + 1;
        for (int i = 1; i < amount; i++) {
            int X = random.nextInt(15);
            int Z = random.nextInt(15);
            int Y = 1;
            for (Y = world.getMaxHeight() - 1; Y > 0; Y--) {
                if ((Y + 2) > 320) {
                    break;
                }
                if (chunk.getBlock(X, Y, Z).getType() == Material.RED_SAND) {
                    chunk.getBlock(X, Y + 1, Z).setType(Material.RED_SANDSTONE);

                    break;
                }
            }
        }
        if (random.nextBoolean()) {
            amount = random.nextInt(4) + 1;
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y = 1;
                for (Y = world.getMaxHeight() - 1; Y > 0; Y--) {
                    if ((Y + 2) > 320) {
                        break;
                    }
                    if (chunk.getBlock(X, Y, Z).getType() == Material.RED_SAND) {

                        chunk.getBlock(X, Y + 1, Z).setType(Material.RED_SAND);
                        chunk.getBlock(X, Y + 2, Z).setType(Material.RED_SAND);

                        break;
                    }
                }
            }
        }


        //Einschläge

        int finY = 100;

        for (int y = world.getMaxHeight() - 1; y > 0; y--) {

            if (chunk.getBlock(8, y, 8).getType() == Material.RED_SAND) {
                finY = y;
                break;
            }
        }

        if (randomrange(0, 15) == 1) {


            int sphereRad = randomrange(1, 7);

            int lx = 8;
            int ly = finY;
            int lz = 8;

            for (int x = lx - sphereRad; x <= lx + sphereRad; x++) {
                for (int y = ly - sphereRad; y <= ly + sphereRad; y++) {
                    for (int z = lz - sphereRad; z <= lz + sphereRad; z++) {

                        if (Math.pow(x - lx, 2) + Math.pow(y - ly, 2) + Math.pow(z - lz, 2) <= Math.pow(sphereRad, 2)) {
                            chunk.getBlock(x, y, z).setType(Material.AIR);
                            if (chunk.getBlock(x, y - 1, z).getType() == Material.RED_SAND) {
                                chunk.getBlock(x, y - 1, z).setType(Material.RED_SANDSTONE);
                            }
                        }
                    }
                }
            }


        } else if (randomrange(0, 15) == 1) {
            {
                int sphereRad = randomrange(1, 7);

                int lx = 8;
                int ly = finY;
                int lz = 8;

                for (int x = lx - sphereRad; x <= lx + sphereRad; x++) {
                    for (int y = ly - sphereRad; y <= ly + sphereRad; y++) {
                        for (int z = lz - sphereRad; z <= lz + sphereRad; z++) {

                            if (Math.pow(x - lx, 2) + Math.pow(y - ly, 2) + Math.pow(z - lz, 2) <= Math.pow(sphereRad, 2)) {
                                chunk.getBlock(x, y, z).setType(Material.RED_SANDSTONE);
                            }
                        }
                    }
                }

                chunk.getBlock(lx, finY, lz).setType(Material.COAL_BLOCK);
            }


        }

        //---------------------------EINSCHLÄGE ENDE----------------------------------

        //EIS
        if (randomrange(0, 4) == 1) {

            int lx = 8;
            int lz = 8;
            int ly = (celutis.getHighestNonAirBlockLocation(Bukkit.getWorld("mars"), chunk.getX() * 8 + lx, chunk.getZ() * 8 + lz).getBlockY()) / 2;

            lx += randomrange(-7, 7);
            ly += randomrange(-7, 7);
            lz += randomrange(-7, 7);

            TripleInt ti = new TripleInt(lx, ly, lz);

            List<TripleInt> targets = new ArrayList<>();
            targets.add(ti.returnCopy());

            for (int x = 0; x <= randomrange(3, 15); x++) {
                ti.add(randomrange(-1, 1), randomrange(-1, 1), randomrange(-1, 1));
                targets.add(ti);
            }

            for (TripleInt target : targets) {
                target.enforceRange(0, 15);

                if (!(chunk.getBlock(target.getA(), target.getB(), target.getC()).getType() == Material.BEDROCK)) {
                    chunk.getBlock(target.getA(), target.getB(), target.getC()).setType(Material.ICE);
                }
            }

        }
    }
}
