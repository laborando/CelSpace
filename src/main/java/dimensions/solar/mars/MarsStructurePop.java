package dimensions.solar.mars;

import cel.space.celutis;
import dimensions.common.structure.StructureParser;
import dimensions.common.structure.object.SimpleBlock;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class MarsStructurePop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        if(celutis.randomrange(0, 100) == 0){
            System.out.println("Structure generated! " + chunk.getX() + "|" + chunk.getZ());

            StructureParser.parse("source/structure/mars/testcircle.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(b.getX(), b.getY(), b.getZ()).setType(b.getMaterial());
            });

        }



    }
}
