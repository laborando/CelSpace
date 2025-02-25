package dimensions.common.structure;

import dimensions.common.structure.object.CustomLoottable;
import dimensions.common.structure.object.SimpleBlock;

import java.util.ArrayList;
import java.util.List;

public class Structure {

    private int x,y,z;

    private List<SimpleBlock> blocks;

    private String lootDir = null;

    private CustomLoottable clt = null;

    public List<SimpleBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<SimpleBlock> blocks) {
        this.blocks = blocks;
    }

    private boolean isRelative = false;

    public Structure(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        blocks = new ArrayList<>();
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

    public boolean isRelative() {
        return isRelative;
    }

    public void setRelative(boolean relative) {
        isRelative = relative;
    }

    public void addBlock(SimpleBlock sb){
        blocks.add(sb);
    }

    public String getLootDir() {
        return lootDir;
    }

    public void setLootDir(String lootDir) {
        this.lootDir = lootDir;
    }

    public CustomLoottable getClt() {
        return clt;
    }

    public void setClt(CustomLoottable clt) {
        this.clt = clt;
    }
}
