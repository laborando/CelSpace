package dimensions.common.structure.object;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CustomLoottable {

    private List<ProbabilityItem> pil;

    public CustomLoottable(List<ProbabilityItem> pil){
        this.pil = pil;
    }

    public CustomLoottable(){
        pil = new ArrayList<>();
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

    public void addPi(ProbabilityItem pi){
        pil.add(pi);
    }

    public ItemStack[] getNextInv() {

        ItemStack[] items = this.getNextInvPure();

        List<ItemStack> itemList = new ArrayList<>();
        for (ItemStack item : items) {
            if (item != null) {
                itemList.add(item);
            }
        }

        Collections.shuffle(itemList);

        ItemStack[] randomizedInventory = new ItemStack[26]; //<- Chest Size

        for (ItemStack item : itemList) {
            int slot;
            do {
                slot = (int) (Math.random() * 26);
            } while (randomizedInventory[slot] != null);

            randomizedInventory[slot] = item;
        }

        return randomizedInventory;
    }

    public ItemStack[] getNextInvPure(){
        ItemStack[] isp = new ItemStack[26];

        int i = 0;

        for(ProbabilityItem pi : pil){
            if(i > 26)
                break;

            isp[i] = new ItemStack(pi.getItem(), getAmount(1, pi.getPropability(), pi.getMaxCount()));

            i++;
        }

        return isp;

    }

    Random r = new Random();
    private int getAmount(int minCount, float propability, int maxCount) {

        if(maxCount <= minCount)
            return minCount;

        if(r.nextFloat() < propability){
            return getAmount(minCount + 1, propability, maxCount);
        }else{
            return minCount;
        }

    }

}
