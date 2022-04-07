import java.util.Date;

public class FttDeal extends BaseDeal{
    public final Double paymentRate; //доходность

    FttDeal(Trend trend, Long investment, Date createdAt, Double openRate, String assetRic, String uuid, Double paymentRate){
        super(trend, investment, createdAt, openRate, assetRic, uuid);
        this.paymentRate = paymentRate;
    }

    @Override
    boolean isWon(Double currentRate){
        return ((currentRate > openRate && trend == Trend.Up) || (currentRate < openRate && trend == Trend.Down));
    }

    @Override
    Long income(Double currentRate) {
        if (openRate.equals(currentRate)) return investment;
        else if ((currentRate > openRate && trend == Trend.Up) || (currentRate < openRate && trend == Trend.Down))
                return (long) Math.floor(paymentRate*investment/100); // округление в меньшую
        else
            return 0L;
    }


}
