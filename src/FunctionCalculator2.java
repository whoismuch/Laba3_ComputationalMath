public class FunctionCalculator2 implements FunctionCalculator {

    @Override
    public double getValueOfFunction (double x, double accuracy) {

        double result = 2 * Math.pow(x, 3) - 3 * Math.pow(x, 2) + x - 1;
        if (Double.isNaN(result)) {
            x = x + accuracy;
            return 2 * Math.pow(x, 3) - 3 * Math.pow(x, 2) + x - 1;
        } else return result;
    }

}
