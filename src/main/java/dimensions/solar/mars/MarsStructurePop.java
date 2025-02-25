package dimensions.solar.mars;

import dimensions.common.structure.Structure;
import dimensions.common.structure.StructureParser;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

import static cel.space.celutis.randomrange;

public class MarsStructurePop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        int rInt = randomrange(0, 2000);

        if(rInt < 10){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/mars/smallRuin.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(rInt < 15 ){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/mars/bigRuin.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(rInt < 17){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/mars/brokenBridge.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(rInt < 20){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/mars/smallHouse.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(rInt < 21){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            StructureParser.parse("source/structure/solar/mars/research.cst", true).getBlocks().forEach(b ->{
                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
            });

        }else if(rInt < 100){
            Location l = new Location(null, chunk.getX()*16 + randomrange(0, 15), 0, chunk.getZ()*16 +  randomrange(0, 15));

            int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

            Structure s = StructureParser.parse("source/structure/solar/mars/undergroundRuins.cst", true);

            s.getBlocks().forEach(b ->{

                world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());

                if(b.getMaterial().equals(Material.CHEST)){
                    Block block = world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ());

                    Chest chest = (Chest) block.getState();



                    chest.getBlockInventory().setContents(s.getClt().getNextInv());

                }


            });

        }



    }
}
