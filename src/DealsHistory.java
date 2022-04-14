import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.Date;
import java.util.Objects;

public class DealsHistory {
    DealsHistory(int deals_container_size){
        dealsContainer = new BaseDeal[deals_container_size];
    }

    DealsHistory(){
        dealsContainer = new BaseDeal[DEALS_CONTAINER_SIZE];
    }

    private static final int DEALS_CONTAINER_SIZE = 3;
    private BaseDeal[] dealsContainer;


    public BaseDeal getDealByIndex(int index){
        return dealsContainer[index];
    }

    public BaseDeal getDealByUUID(String uuid){
        int index = 0;
        while ((index < dealsContainer.length) && Objects.nonNull(dealsContainer[index]) && !dealsContainer[index].uuid.equals(uuid))
            index++;
        if (index < dealsContainer.length) return dealsContainer[index];
        else return null;
    }

    public void addDealToContainer(BaseDeal deal){

        int c = 0;

        while ((c < dealsContainer.length) && Objects.nonNull(dealsContainer[c]) && !dealsContainer[c].uuid.equals(deal.uuid))
            c++;
        if (c < dealsContainer.length) dealsContainer[c] = deal;
        else System.out.println("dealsContainer is full");
    }

    public void deleteDealFromContainer(BaseDeal deal){
        this.deleteDealFromContainer(deal.uuid);
    }

    public void deleteDealFromContainer(String uuid){
        int c = 0;
        boolean isDealFound = false;

        while ((c < dealsContainer.length) && !isDealFound && (dealsContainer[c] != null)){
            if (dealsContainer[c].uuid.equals(uuid)) //== сравнивает нам ссылки, а uuid это строка, а не значение
            {
                dealsContainer[c] = null;
                isDealFound = true;
                while ((c < dealsContainer.length - 1) && (dealsContainer[c + 1] != null)) {
                    dealsContainer[c] = dealsContainer[c + 1];
                    c++;
                }
            }
            c++;
        }

        if (!isDealFound) System.out.println("dealsContainer doesn't contain specified deal");
    }

    public int getCapacity(){
        return dealsContainer.length;
    }

}
