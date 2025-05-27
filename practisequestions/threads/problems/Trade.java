package practisequestions.threads.problems;

import java.util.Random;

public class Trade {
    private long id;
    private String symbol;
    private int quantity;
    private double price;
    private long timeStamp;

    protected static final String[] tickerSymbols = {"AAPL", "GOOG", "TSLA", "CCPL"};


    public Trade(long id, String symbol, int quantity, double price, long timeStamp) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public static Trade generateRandomTrade() {
        final Random random = new Random();
        long id = random.nextInt(1000);
        String symbol = tickerSymbols[random.nextInt(tickerSymbols.length)];
        int quantity = random.nextInt(100) + 1;
        double price = (random.nextDouble() + 1) * 1000;
        long timeStamp = System.currentTimeMillis();
        return new Trade(id, symbol, quantity, price, timeStamp);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", timeStamp=" + timeStamp +
                '}';
    }
}