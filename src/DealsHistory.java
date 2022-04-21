import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DealsHistory {
    DealsHistory(int deals_container_size) {
        dealsContainer = new ArrayList<BaseDeal>(deals_container_size);
    }

    DealsHistory() {
        dealsContainer = new ArrayList<BaseDeal>(DEALS_CONTAINER_SIZE);
    }

    private static final int DEALS_CONTAINER_SIZE = 3;
    private List<BaseDeal> dealsContainer;


    public BaseDeal getDealByIndex(int index) {
        return dealsContainer.get(index);
    }

    private int getIndexDealByUUID(String uuid) {
        int index = 0;
        while (index < dealsContainer.size() && !dealsContainer.get(index).uuid.equals(uuid))
            index++;
        return index < dealsContainer.size() ? index : -1;
    }

    public BaseDeal getDealByUUID(String uuid) {
        int index = getIndexDealByUUID(uuid);
        if (index != -1) return dealsContainer.get(index);
        else return null;
    }

    public void addDealToContainer(BaseDeal deal) {
        int index = getIndexDealByUUID(deal.uuid);
        if (index != -1) dealsContainer.set(index, deal);
        else dealsContainer.add(deal);
    }

    public void deleteDealFromContainer(BaseDeal deal) {
        this.deleteDealFromContainer(deal.uuid);
    }

    public boolean deleteDealFromContainer(String uuid) {
        int index = getIndexDealByUUID(uuid);
        if (index != -1) {
            dealsContainer.remove(index);
            return true;
        } else return false;
    }


}
