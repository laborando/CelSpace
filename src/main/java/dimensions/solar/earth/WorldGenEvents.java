package dimensions.solar.earth;

import cel.space.celutis;
import dimensions.common.structure.StructureParser;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.w3c.dom.events.Event;

import static cel.space.celutis.randomrange;

public class WorldGenEvents implements Listener {

    @EventHandler
    public void event(ChunkPopulateEvent e) {

        if(e.getWorld().getName().equalsIgnoreCase("world")){

            if(celutis.randomrange(0, 2000) == 0){
                Chunk chunk = e.getChunk();
                World world = e.getWorld();
                Location l = new Location(null, chunk.getX() * 16 + randomrange(0, 15), 0, chunk.getZ() * 16 + randomrange(0, 15));

                int dy = world.getHighestBlockAt(l.getBlockX(), l.getBlockZ()).getY();

                StructureParser.parse("source/structure/solar/sCommon/monolyth.cst", true).getBlocks().forEach(b -> {
                    world.getBlockAt(l.getBlockX() + b.getX(), dy + b.getY(), l.getBlockZ() + b.getZ()).setType(b.getMaterial());
                });
            }

        }else{
            return;
        }

    }
}
