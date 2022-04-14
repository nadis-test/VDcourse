import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DealsHistory {
    DealsHistory(int deals_container_size){
        dealsContainer = new ArrayList<BaseDeal>(deals_container_size);
    }

    DealsHistory(){
        dealsContainer = new ArrayList<BaseDeal>(DEALS_CONTAINER_SIZE);
    }

    private static final int DEALS_CONTAINER_SIZE = 3;
    private List<BaseDeal> dealsContainer;


    public BaseDeal getDealByIndex(int index){
        return dealsContainer.get(index);
    }

    public BaseDeal getDealByUUID(String uuid){
        int index = 0;
        while ((index < dealsContainer.size()) && Objects.nonNull(dealsContainer.get(index)) && !dealsContainer.get(index).uuid.equals(uuid))
            index++;
        if (index < dealsContainer.size()) return dealsContainer.get(index);
        else return null;
    }

    public void addDealToContainer(BaseDeal deal){

        int c = 0;

        while ((c < dealsContainer.size()) && Objects.nonNull(dealsContainer.get(c)) && !dealsContainer.get(c).uuid.equals(deal.uuid))
            c++;
        if (c < dealsContainer.size()) dealsContainer.set(c, deal);
        else System.out.println("dealsContainer is full");
    }

    public void deleteDealFromContainer(BaseDeal deal){
        this.deleteDealFromContainer(deal.uuid);
    }

    public boolean deleteDealFromContainer(String uuid){

        for (int c =0; c < dealsContainer.size(); c++) {
            if (dealsContainer.get(c).uuid.equals(uuid)) //== сравнивает нам ссылки, а uuid это строка, а не значение
            {
                dealsContainer.remove(c);
                return true;
            }
        }
        return false;
    }

    public int getCapacity(){
        return dealsContainer.size();
    }

}
