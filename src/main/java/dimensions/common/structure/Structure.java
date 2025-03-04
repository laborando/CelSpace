package dimensions.common.structure;

import dimensions.common.structure.object.CustomLoottable;
import dimensions.common.structure.object.SimpleBlock;
import dimensions.common.structure.object.SimpleEntity;

import java.util.ArrayList;
import java.util.List;

public class Structure {

    private float spawnChance = 0.0f;

    private int x,y,z;

    private List<SimpleBlock> blocks;
    private List<SimpleEntity> entities;

    private String lootDir = null;

    private CustomLoottable clt = null;

    public List<String> worlds;

    public void setBlocks(List<SimpleBlock> blocks) {
        this.blocks = blocks;
    }

    public List<SimpleBlock> getBlocks() {
        return blocks;
    }

    private boolean isRelative = false;

    public Structure(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        blocks = new ArrayList<>();
        entities = new ArrayList<>();
        worlds = new ArrayList<>();
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

    public float getSpawnChance() {
        return spawnChance;
    }

    public void setSpawnChance(float spawnChance) {
        this.spawnChance = spawnChance;
    }

    public List<SimpleEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity> entities) {
        this.entities = entities;
    }

    public void addEntity(SimpleEntity entity){
        entities.add(entity);
    }

    public List<String> getWorlds() {
        return worlds;
    }

    public void setWorlds(List<String> worlds) {
        this.worlds = worlds;
    }

    public void addWorld(String world){
        worlds.add(world);
    }
}
