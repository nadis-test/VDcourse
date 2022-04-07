import jdk.nashorn.internal.runtime.JSType;

import java.util.Date;

public class CfdDeal extends BaseDeal{
    public final Integer multiplier;
    public final Double openAsk;
    public final Double openBid;

    CfdDeal(Trend trend, Long investment, Date createdAt, String assetRic, String uuid, Integer multiplier, Double openAsk, Double openBid){
        super(trend, investment, createdAt, (trend == Trend.Up)?openAsk:openBid, assetRic, uuid);
        this.multiplier = multiplier;
        this.openAsk = openAsk;
        this.openBid = openBid;
    }

    @Override
    boolean isWon(Double currentRate) {
        return (investment < income(currentRate));
    }

    @Override
    Long income(Double currentRate) {
        if (trend == Trend.Up) return (long) Math.floor((currentRate / openAsk - 1) * multiplier * investment);
        else return (long) Math.floor((1 - currentRate / openBid) * multiplier * investment);
    }

}
