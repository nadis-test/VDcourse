import java.util.Date;

public abstract class BaseDeal {
    Trend trend;
    Long investment; // long для длинных валют
    Date createdAt;
    Date closedAt;
    Double openRate;
    Double closedRate;
    String assetRic;
    String uuid;

    protected BaseDeal(Trend trend, Long investment, Date createdAt, Double openRate, String assetRic, String uuid){
        this.trend = trend;
        this.assetRic = assetRic;
        this.investment = investment;
        this.openRate = openRate;
        this.uuid = uuid;
        this.createdAt = createdAt;
    };

    public void closeDeal(Date closedAt, Double closedRate){
        this.closedAt = closedAt;
        this.closedRate = closedRate;
    }


    public boolean isWon(){
        return isWon(closedRate);
    }

    abstract boolean isWon(Double currentRate); // переопределяем для разных механик


    public Long income(){
        return income(closedRate);
    }  // переопределяем для разных механик для дохода по closed rate

    abstract Long income(Double currentRate);  // переопределяем для разных механик
}

enum Trend{
    Up,
    Down;
}

