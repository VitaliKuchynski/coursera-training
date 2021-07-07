package InterviewCamp;

import java.util.Arrays;

public class RedWhiteBlue {

    //Level: Medium

    // You're given a list of Marbles. Each marble can have one of 3 colors (Red, White or Blue).
    // Arrange the marbles in order of the colors (Red -> White -> Blue).
    // Colors are represented as follows:0 - Red 1 - White 2 - Blue

    public static void main(String[] args) {

        Marble marble = new Marble(Color.BLUE, 2);
        Marble marble1 = new Marble(Color.WHITE, 1);
        Marble marble2 = new Marble(Color.RED, 0);

        Marble[] marbles = {marble, marble1, marble2, marble, marble, marble1, marble, marble2};

        System.out.println(Arrays.toString(arrangeColors(marbles)));
    }

    public static Marble[] arrangeColors(Marble[] marbles) {

        int lowBoundary = 0, highBoundary = marbles.length - 1;

        int i = 0;

        while (i <= highBoundary) {
            Color color = marbles[i].getColor();
            if(color == Color.RED){
                Marble temp = marbles[lowBoundary];
                marbles[lowBoundary] = marbles[i];
                marbles[i] = temp;
                i++;
                lowBoundary++;
            } else if (color == Color.BLUE) {
                Marble temp = marbles[highBoundary];
                marbles[highBoundary] = marbles[i];
                marbles[i] = temp;
                highBoundary--;
            } else if (color == Color.WHITE){
                i++;

            }
        }
        return marbles;
    }
    /***** Helper Code *****//* Ask the interviewer if you need to implement this. */
    public static enum Color {
        RED(0),
        WHITE(1),
        BLUE(2);

        private final int colorId;

        Color(int colorId){
            this.colorId = colorId;
        }
        public int getValue() {
            return colorId;
        }
    }

    public static class Marble {
        Color color;
        int data;

        public Marble(Color color) {
            super();
            this.color = color;
            this.data = 0;
        }

        public Marble(Color color, int data) {
            super();
            this.color = color;
            this.data = data;
        }

            public Color getColor() {
            return color;
        }
            public int getData() {
            return data;
        }
            public String toString() {
            return color.toString() + ": " + data;
    }}
}
