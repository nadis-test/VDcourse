
import java.util.*;

public class DealsHistory {
    DealsHistory() {
        dealsContainer = new HashMap();
    }

    private Map<String, BaseDeal> dealsContainer;


    public BaseDeal getDealByUUID(String uuid) {
        return dealsContainer.get(uuid);
    }

    public void addDealToContainer(BaseDeal deal) {
        dealsContainer.put(deal.uuid, deal);
    }

    public void deleteDealFromContainer(BaseDeal deal) {
        this.deleteDealFromContainer(deal.uuid);
    }

    public boolean deleteDealFromContainer(String uuid) {
        return (dealsContainer.remove(uuid) != null);
    }


}
