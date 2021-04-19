public class FunctionCalculator5 implements FunctionCalculator {

    @Override
    public double getValueOfFunction (double x, double accuracy) {
        double result = Math.cos(x) + Math.pow(2, x);
        if (Double.isNaN(result)) {
            x = x + accuracy;
            return Math.cos(x) + Math.pow(2, x);
        } else return result;
    }
}
