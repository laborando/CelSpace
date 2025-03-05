package dimensions.systems.solar.pluto;

import cel.space.celutis;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import utis.TripleInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlutoPop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {



        //Einschläge


        if (celutis.randomrange(0, 15) == 1) {


            int sphereRad = celutis.randomrange(1, 20);

            int lx = celutis.randomrange(0, 16);
            int lz = celutis.randomrange(0, 16);

            int ly = this.getHighestNonAirBlockLocation(world, lx, lz).getBlockY();

            for (int x = lx - sphereRad; x <= lx + sphereRad; x++) {
                for (int y = ly - sphereRad; y <= ly + sphereRad; y++) {
                    for (int z = lz - sphereRad; z <= lz + sphereRad; z++) {

                        if (Math.pow(x - lx, 2) + Math.pow(y - ly, 2) + Math.pow(z - lz, 2) <= Math.pow(sphereRad, 2)) {
                            world.getBlockAt(chunk.getX()*16 + x, y, chunk.getZ()*16 + z).setType(Material.AIR);

                        }
                    }
                }
            }



        }

}


    /***
     *
     * @param world
     * @param x
     * @param z
     * @return Highest Block w/o Air but only works with Pluto, bc there are no caves
     */
    private Location getHighestNonAirBlockLocation(final World world, final int x, final int z) {
        int low = world.getMinHeight();
        int high = world.getMaxHeight() - 1; //Wichtig, bei Max H = VOID_AIR und nicht AIR, weil eig. außerhalb der Welt

        int lastValidY = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            Block block = world.getBlockAt(x, mid, z);
            if (block.getType() != Material.AIR) {
                lastValidY = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (lastValidY != -1) {
            return new Location(world, x, lastValidY, z);
        } else {
            return null;
        }
    }



}