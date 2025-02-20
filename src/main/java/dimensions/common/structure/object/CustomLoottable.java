package dimensions.common.structure.object;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class CustomLoottable {

    private List<ProbabilityItem> pil;

    public CustomLoottable(List<ProbabilityItem> pil){
        this.pil = pil;
    }

    public CustomLoottable(ProbabilityItem pi){
        pil = new ArrayList<>();
        pil.add(pi);
    }

    public CustomLoottable(Material m){

        pil = new ArrayList<>();
        pil.add(new ProbabilityItem(1, 1f, m));
    }

    public List<ProbabilityItem> getPil() {
        return pil;
    }

    public void setPil(List<ProbabilityItem> pil) {
        this.pil = pil;
    }
}
