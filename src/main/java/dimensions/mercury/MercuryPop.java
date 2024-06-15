package dimensions.mercury;

import cel.space.celutis;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import utis.TripleInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MercuryPop extends BlockPopulator {

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
                if (chunk.getBlock(X, Y, Z).getType() == Material.STONE) {
                    chunk.getBlock(X, Y + 1, Z).setType(Material.STONE);

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
                    if (chunk.getBlock(X, Y, Z).getType() == Material.STONE) {

                        chunk.getBlock(X, Y + 1, Z).setType(Material.STONE);
                        chunk.getBlock(X, Y + 2, Z).setType(Material.STONE);

                        break;
                    }
                }
            }
        }


        //Einschläge

        int finY = 100;

        for (int y = world.getMaxHeight() - 1; y > 0; y--) {

            if (chunk.getBlock(8, y, 8).getType() == Material.STONE) {
                finY = y;
                break;
            }
        }

        if (celutis.randomrange(0, 15) == 1) {


            int sphereRad = celutis.randomrange(1, 7);

            int lx = 8;
            int ly = finY;
            int lz = 8;

            for (int x = lx - sphereRad; x <= lx + sphereRad; x++) {
                for (int y = ly - sphereRad; y <= ly + sphereRad; y++) {
                    for (int z = lz - sphereRad; z <= lz + sphereRad; z++) {

                        if (Math.pow(x - lx, 2) + Math.pow(y - ly, 2) + Math.pow(z - lz, 2) <= Math.pow(sphereRad, 2)) {
                            chunk.getBlock(x, y, z).setType(Material.AIR);
                        }
                    }
                }
            }



        } else if (celutis.randomrange(0, 15) == 1) {
            {
                int sphereRad = celutis.randomrange(1, 7);

                int lx = 8;
                int ly = finY;
                int lz = 8;

                for (int x = lx - sphereRad; x <= lx + sphereRad; x++) {
                    for (int y = ly - sphereRad; y <= ly + sphereRad; y++) {
                        for (int z = lz - sphereRad; z <= lz + sphereRad; z++) {

                            if (Math.pow(x - lx, 2) + Math.pow(y - ly, 2) + Math.pow(z - lz, 2) <= Math.pow(sphereRad, 2)) {
                                chunk.getBlock(x, y, z).setType(Material.STONE);
                            }
                        }
                    }
                }

                chunk.getBlock(lx, finY, lz).setType(Material.COAL_BLOCK);
            }


        }

        //---------------------------EINSCHLÄGE ENDE----------------------------------

       //EIS
        if(celutis.randomrange(0, 4) == 1){

            int lx = 8;
            int lz = 8;
            int ly = 200;
            try {
                ly = (celutis.getHighestNonAirBlockLocation(Bukkit.getWorld("moon"), chunk.getX() * 8 + lx, chunk.getZ() * 8 + lz).getBlockY()) / 2;
            }catch (NullPointerException ignored){
            }

            lx += celutis.randomrange(-7, 7);
            ly += celutis.randomrange(-7, 7);
            lz += celutis.randomrange(-7, 7);

            TripleInt ti = new TripleInt(lx, ly, lz);

            List<TripleInt> targets = new ArrayList<>();
            targets.add(ti.returnCopy());

            for (int x = 0; x <= celutis.randomrange(3, 15); x++) {
                ti.add(celutis.randomrange(-1, 1), celutis.randomrange(-1, 1), celutis.randomrange(-1, 1));
                targets.add(ti);
            }

            for (TripleInt target : targets) {
                target.enforceRange(0, 15);

                if(!(chunk.getBlock(target.getA(), target.getB(), target.getC()).getType()==Material.BEDROCK)){
                    chunk.getBlock(target.getA(), target.getB(), target.getC()).setType(Material.ICE);
                }
            }

        }




    //------------------------EIS ENDE-------------------------
    //HÖHLEN

}


}