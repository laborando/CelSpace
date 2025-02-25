package dimensions.common.structure;

import dimensions.common.structure.object.CustomLoottable;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.logging.Logger;

public class LootDirectory {

    private static final HashMap<String, CustomLoottable> clt = preInnit();

    public static void innitLoottables(){




        //TODO: INNIT LOOTTABLES!

    }

    public static HashMap<String, CustomLoottable> preInnit(){
        HashMap<String, CustomLoottable> tmp =  new HashMap<>();
        tmp.put("celspace:fallback", new CustomLoottable(Material.DIRT));
        return tmp;
    }

    public static CustomLoottable getLootTable(String id){


        CustomLoottable ret = clt.get(id);

        if(ret == null){
            Logger.getGlobal().warning("A non-existing CustomLootTable was requested, falling back! " + id);
            ret = clt.get("celspace:fallback");
        }

        return ret;

    }

}
