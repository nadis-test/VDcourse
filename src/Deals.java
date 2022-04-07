import java.util.Date;

public class Deals {
    private final CfdDeal[] cfdDeals;
    private final FttDeal[] fttDeals;

    Deals(){
        cfdDeals = new CfdDeal[]{new CfdDeal(Trend.Up, 10L, new Date(), "Gold", "12345", 2, 1.23, 1.35),
                new CfdDeal(Trend.Down, 20L, new Date(), "Twitter", "54321", 3, 5.23, 3.35)};

    fttDeals = new FttDeal[]{new FttDeal(Trend.Up, 100000L, new Date(), 1.222333, "ZAR/OST", "223344", 1.444555),
            new FttDeal(Trend.Down, 70000L, new Date(), 5.556677, "ZAS/PAD", "223345", 2.666555)};
    }

    void updateRate(Double rate)
    {
        System.out.println(cfdDeals[0].income(rate));
        System.out.println(cfdDeals[0].isWon(rate));
    }

    void closeDeal(Double rate, Date time)
    {
        cfdDeals[0].closeDeal(time, rate);
        System.out.println(cfdDeals[0].income());
        System.out.println(cfdDeals[0].isWon());
    }

    public static void main(String[] arc){
        Deals deals = new Deals();
        deals.updateRate(2.456788);
        deals.closeDeal(100.456799, new Date(System.currentTimeMillis()+10000));
    }

}


//дз - вывести статус всех сделок, cfd и ftt
//идея - история сделок дз (циклы, коллекции), отдельный класс = хранилище сделок



