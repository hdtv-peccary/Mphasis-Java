public class XchangeWorker {
    private Market market;
    private Event event;

    public XchangeWorker(){

    }

    public XchangeWorker(Market market, Event event) {
        this.market = market;
        this.event = event;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "XchangeWorker{" +
                "market=" + market +
                ", event=" + event +
                '}';
    }

    public void run(){

    }

}
