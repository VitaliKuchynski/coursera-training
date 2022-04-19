package InterviewCamp.queue;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Level: Medium
// You are given stock prices and the corresponding day of each stock price.For example:(32, 1), (45, 1), (37,2), (42,3),
//  ..Here, 32 is the price and 1 is the day of the price.
// Say you are given these prices as an input stream. You should provide a function for the user to input a stock price and day.
// Your system should be able to tell the maximum stock price in the last 3 days.
public class StockPriceWithTimeSlidingWindow {

    Queue<Price> q;
    int window;

    public StockPriceWithTimeSlidingWindow(int windowDays) {
        this.q = new LinkedList<>();
        this.window = windowDays;
    }

    public static void main(String[] args) {

        StockPriceWithTimeSlidingWindow st = new StockPriceWithTimeSlidingWindow(3);

        st.addPrice(32 ,2);
        st.addPrice(32 ,1);
        st.addPrice(45 ,1);
        st.addPrice(37 ,8);

        System.out.println(st.getMax());
    }

    public void addPrice(int price, int day) {

        while (!q.isEmpty() && q.peek().getDay() < (day - window + 1)) {
            q.remove();
        }
        q.add(new Price(price, day));
    }


    //return max price in last 3 days
    public int getMax() {
        int maxPrice = 0;
        Iterator<Price> iter = q.iterator();

        while (iter.hasNext()) {
            int price = iter.next().getPrice();
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    class Price{

        int price;
        int day;

        public Price(int price, int day) {
            this.price = price;
            this.day = day;
        }

        public int getPrice() {
            return price;
        }

        public int getDay() {
            return day;
        }
    }
}
