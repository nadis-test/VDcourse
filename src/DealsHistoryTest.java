import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.AssertionFailure;
import java.util.Date;
import java.util.Objects;

public class DealsHistoryTest{

    @Test
    public void testDealNotFoundInHistory() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory(5);
        fillHistoryContainer(test_history_container);
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertNotNull(test_deal_2, "Deal not found in history");
    }

    @Test
    public void testFoundDealIsEqual() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory(5);
        fillHistoryContainer(test_history_container);
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertEquals(test_deal, test_deal_2, "deals are not equal");
    }



    @Test
    public void testAddDeals() throws AssertionFailure {
        DealsHistory test_history_container = new DealsHistory(4);
        CfdDeal test_deal_0 = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "1", 2, 1.23D, 1.35D);
        CfdDeal test_deal_1 = new CfdDeal(Trend.Up, 20L, new Date(), "Gold", "2", 2, 1.23D, 1.35D);
        CfdDeal test_deal_2 = new CfdDeal(Trend.Up, 30L, new Date(), "Gold", "3", 2, 1.23D, 1.35D);
        CfdDeal test_deal_3 = new CfdDeal(Trend.Up, 40L, new Date(), "Gold", "4", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal_0);
        test_history_container.addDealToContainer(test_deal_1);
        test_history_container.addDealToContainer(test_deal_2);
        try {
            test_history_container.addDealToContainer(test_deal_3);
        }
         catch (Throwable t){throw new AssertionFailure("Unexpected error when adding deal to the full history collection"); }
    }

    @Test
    public void testDeletedDealFromHistoryByUUIDNotFound(){
        DealsHistory test_history_container = new DealsHistory(4);
        fillHistoryContainer(test_history_container);

        test_history_container.deleteDealFromContainer("2");
        assertEquals(null, test_history_container.getDealByUUID("2"), "Deleted deal still found in history");
    }

    @Test
    public void testDeletedDealFromHistoryByDealNotFound(){
        DealsHistory test_history_container = new DealsHistory(5);
        fillHistoryContainer(test_history_container);
        CfdDeal test_deal_4 = new CfdDeal(Trend.Up, 40L, new Date(), "Gold", "5", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal_4);

        test_history_container.deleteDealFromContainer(test_deal_4);
        assertEquals(null, test_history_container.getDealByUUID("5"), "Deleted deal still found in history");
    }

    @Test
    public void testDeletedNonExistentDeal(){
        DealsHistory test_history_container = new DealsHistory(4);
        fillHistoryContainer(test_history_container);

      Assertions.assertFalse(test_history_container.deleteDealFromContainer("5"), "Trying to delete unexistent deal");
    }

    public static void fillHistoryContainer(DealsHistory test_history_container){
        CfdDeal test_deal_0 = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "1", 2, 1.23D, 1.35D);
        CfdDeal test_deal_1 = new CfdDeal(Trend.Up, 20L, new Date(), "Gold", "2", 2, 1.23D, 1.35D);
        CfdDeal test_deal_2 = new CfdDeal(Trend.Up, 30L, new Date(), "Gold", "3", 2, 1.23D, 1.35D);
        CfdDeal test_deal_3 = new CfdDeal(Trend.Up, 40L, new Date(), "Gold", "4", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal_0);
        test_history_container.addDealToContainer(test_deal_1);
        test_history_container.addDealToContainer(test_deal_2);
        test_history_container.addDealToContainer(test_deal_3);
    }

    public static void assertEquals(Object expected, Object actual, String message) throws AssertionFailure{
        if (!Objects.equals(expected,actual)) throw new AssertionFailure(message);
    }

    public static void assertNotNull(Object actual, String message) throws AssertionFailure{
        if (actual == null) throw new AssertionFailure(message);
    }

    /*
    public static void main(String[] arg) throws AssertionFailure {

        testDeletedDealFromHistoryNotFound();
        testAddDeals();
        testDealNotFoundInHistory();
        testFoundDealIsEqual();
        testLastDealNotChangedByAddingNewDeal();

    }

     */
}
