package dimensions.common.structure.object;

import org.bukkit.Material;

public class ProbabilityItem {

    private int maxCount;
    private float probability;
    private Material item;

    public ProbabilityItem(int maxCount, float probability, Material item) {
        this.maxCount = maxCount;
        this.probability = probability;
        this.item = item;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public float getPropability() {
        return probability;
    }

    public void setPropability(float popability) {
        this.probability = popability;
    }

    public Material getItem() {
        return item;
    }

    public void setItem(Material item) {
        this.item = item;
    }
}
