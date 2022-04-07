import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.Date;

public class DealsHistoryTest{

    private static void testDealNotFoundInHistory() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory();
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertNotNull(test_deal_2, "Deal not found in history");
    }

    private static void testFoundDealIsEqual() throws AssertionFailure{
        DealsHistory test_history_container = new DealsHistory();
        CfdDeal test_deal = new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23D, 1.35D);
        test_history_container.addDealToContainer(test_deal);
        BaseDeal test_deal_2 = test_history_container.getDealByUUID("12345");
        assertEquals(test_deal, test_deal_2, "deals are not equal");
    }

    private static void testAddDeals() throws AssertionFailure {
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

    private static void testLastDealNotChangedByAddingNewDeal(){
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

    public static void assertEquals(Object expected, Object actual, String message) throws AssertionFailure{
        if (!expected.equals(actual)) throw new AssertionFailure(message);
    }

    public static void assertNotNull(Object actual, String message) throws AssertionFailure{
        if (actual == null) throw new AssertionFailure(message);
    }

    public static void main(String[] arc) throws AssertionFailure {
        testAddDeals();
        testDealNotFoundInHistory();
        testFoundDealIsEqual();
        testLastDealNotChangedByAddingNewDeal();
    }
}
