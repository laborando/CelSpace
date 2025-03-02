package dimensions.systems.solar.common;

import dimensions.common.structure.StructureParser;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

import static cel.space.celutis.randomrange;

public class CommonSolarStructurePop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        int rInt = randomrange(0, 2000);

        if (rInt == 0) {
            Location l = new Location(null, chunk.getX() * 16 + randomrange(0, 15), 0, chunk.getZ() * 16 + randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/sCommon/monolyth.cst", true).getBlocks().forEach(b -> {
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }
    }
}
