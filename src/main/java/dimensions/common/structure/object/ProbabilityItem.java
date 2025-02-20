package dimensions.common.structure.object;

import org.bukkit.Material;

public class ProbabilityItem {

    private int maxCount = 2;
    private float popability = 0.5f;
    private Material item = Material.AIR;

    public ProbabilityItem(int maxCount, float popability, Material item) {
        this.maxCount = maxCount;
        this.popability = popability;
        this.item = item;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public float getPopability() {
        return popability;
    }

    public void setPopability(float popability) {
        this.popability = popability;
    }

    public Material getItem() {
        return item;
    }

    public void setItem(Material item) {
        this.item = item;
    }
}
