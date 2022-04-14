import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.AssertionFailure;
import java.util.Date;
import java.util.Objects;

public class DealsHistoryTest{

    @Test
    public void testDealNotFoundInHistory() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory();
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertNotNull(test_deal_2, "Deal not found in history");
    }

    @Test
    public void testFoundDealIsEqual() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory();
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertEquals(test_deal, test_deal_2, "deals are not equal");
    }

    @Test
    public void testAddDeals() throws AssertionFailure {
        DealsHistory test_history_container = new DealsHistory();
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
    public void testLastDealNotChangedByAddingNewDeal(){
        DealsHistory test_history_container = new DealsHistory(3);
        CfdDeal test_deal_0 = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "1", 2, 1.23D, 1.35D);
        CfdDeal test_deal_1 = new CfdDeal(Trend.Up, 20L, new Date(), "Gold", "2", 2, 1.23D, 1.35D);
        CfdDeal test_deal_2 = new CfdDeal(Trend.Up, 30L, new Date(), "Gold", "3", 2, 1.23D, 1.35D);
        CfdDeal test_deal_3 = new CfdDeal(Trend.Up, 40L, new Date(), "Gold", "4", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal_0);
        test_history_container.addDealToContainer(test_deal_1);
        test_history_container.addDealToContainer(test_deal_2);
        test_history_container.addDealToContainer(test_deal_3);
        int last_deal_index = test_history_container.getCapacity()-1;
        assertEquals(test_history_container.getDealByIndex(last_deal_index), test_deal_2, "Last deal was unexpectedly replaced");
    }

    @Test
    public void testDeletedDealFromHistoryNotFound(){
        DealsHistory test_history_container = new DealsHistory(4);
        CfdDeal test_deal_0 = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "1", 2, 1.23D, 1.35D);
        CfdDeal test_deal_1 = new CfdDeal(Trend.Up, 20L, new Date(), "Gold", "2", 2, 1.23D, 1.35D);
        CfdDeal test_deal_2 = new CfdDeal(Trend.Up, 30L, new Date(), "Gold", "3", 2, 1.23D, 1.35D);
        CfdDeal test_deal_3 = new CfdDeal(Trend.Up, 40L, new Date(), "Gold", "4", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal_0);
        test_history_container.addDealToContainer(test_deal_1);
        test_history_container.addDealToContainer(test_deal_2);
        test_history_container.addDealToContainer(test_deal_3);

        test_history_container.deleteDealFromContainer("2");
        assertEquals(null, test_history_container.getDealByUUID("2"), "Deleted deal still found in history");
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
