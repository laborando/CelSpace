package dimensions.common.structure.object;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class SimpleEntity {

    private int x, y, z;

    private boolean relativeY;
    private String name;
    private EntityType eType;

    /**
     * new SEntity, x,y,z Coords, isRelative to highest Y Block, Type
     */
    public SimpleEntity(int x, int y, int z, boolean isRelativeY, EntityType eType, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.relativeY = isRelativeY;
        this.eType = eType;
        this.name = name;
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


    public void setRelativeY(boolean relativeY) {
        this.relativeY = relativeY;
    }

    public boolean isRelativeY() {
        return relativeY;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityType getEType() {
        return eType;
    }

    public void setEType(EntityType eType) {
        this.eType = eType;
    }
}
