package InterviewCamp.recursion;

public class PowerFunction {

    public static void main(String[] args) {

        System.out.println(power(3,-7));

    }

    public static float power(int x, int power) {

        if (x==0 && power <= 0) {
            throw new ArithmeticException( "undefined" );
        }
        float result = positivePower(Math.abs(x), Math.abs(power));

        //handle negative power
        if (power < 0) {
            result = 1 / result;
        }

        //handle negative x
        if (x < 0 && power % 2 !=0) {
             result = - 1 * result;
        }

        return result;
    }

    public static int positivePower(int x, int power) {

        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return x;
        }

        int halfPower = positivePower(x, power/2);

        if (power % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return  x * halfPower * halfPower;
        }
    }
}
