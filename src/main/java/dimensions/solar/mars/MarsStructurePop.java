package dimensions.solar.mars;

import dimensions.common.structure.StructureParser;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

import static cel.space.celutis.randomrange;

public class MarsStructurePop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        if(randomrange(0, 1000) == 0){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/mars/smallRuin.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(randomrange(0, 10000) == 0){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/mars/bigRuin.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(randomrange(0, 20) == 0){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/mars/brokenBridge.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(randomrange(0, 20) == 0){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/mars/smallHouse.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(randomrange(0, 20) == 0){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/mars/research.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }



    }
}
