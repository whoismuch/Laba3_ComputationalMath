public class FunctionCalculator4 implements FunctionCalculator {

    @Override
    public double getValueOfFunction (double x, double accuracy) {
        double result = 3 / (Math.sqrt(x));
        if (Double.isNaN(result)|| Double.isInfinite(result)) {
            x = x + accuracy;
            return 3 / Math.sqrt(x);
        } else return result;
    }

}
