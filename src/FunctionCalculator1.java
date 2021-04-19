public class FunctionCalculator1 implements FunctionCalculator {

    @Override
    public double getValueOfFunction (double x, double accuracy) {
        double result = 5 * Math.sin(x) / x;
        if (Double.isNaN(result)) {
            x = x + accuracy;
            return 5 * Math.sin(x) / x;
        } else return result;
    }

}
