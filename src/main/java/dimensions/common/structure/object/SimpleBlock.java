package dimensions.common.structure.object;

import org.bukkit.Material;

public class SimpleBlock {

    private int x,y,z;

    private boolean relativeY;

    private Material material;

    /**
    new SBlock, x,y,z Coords, isRelative to highest Y Block, Material
     */
    public SimpleBlock(int x, int y, int z, boolean isRelativeY, Material material) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.relativeY = isRelativeY;
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
