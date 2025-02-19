package dimensions.common.structure;

import jdk.jfr.Description;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

/*
    TEst
     */
public class SimpleBlock {

    private int x,y,z;

    private Material material;

    /**
    TEst
     */
    public SimpleBlock(int x, int y, int z, Material material) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.material = material;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
