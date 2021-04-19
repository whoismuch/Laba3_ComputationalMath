public class FunctionCalculator3 implements FunctionCalculator {

    @Override
    public double getValueOfFunction (double x, double accuracy) {
        double result = Math.exp(x)-6;
        if (Double.isNaN(result)) {
            x = x + accuracy;
            return Math.exp(x)-6;
        } else return result;
    }

}
