package dimensions.common.structure;

import jdk.jfr.Description;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.List;

public class Structure {

    private int x,y,z;

    private List<SimpleBlock> blocks;

    public List<SimpleBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<SimpleBlock> blocks) {
        this.blocks = blocks;
    }

    public Structure(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
}
