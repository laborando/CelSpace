package dimensions.common.structure;

import dimensions.common.structure.object.CustomLoottable;
import dimensions.common.structure.object.ProbabilityItem;
import org.bukkit.Material;

public class LoottableBuilder {

    CustomLoottable clt = new CustomLoottable();

    public  synchronized void executeInstruction(String instruction) {

        String[] parts = instruction.split(",");

        ProbabilityItem pb = new ProbabilityItem(Integer.parseInt(parts[2]), Float.parseFloat(parts[1]), Material.valueOf(parts[0]));

        clt.addPi(pb);
    }

    public synchronized CustomLoottable getClt(){
        return clt;
    }
}
