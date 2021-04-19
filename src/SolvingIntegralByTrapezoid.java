public class SolvingIntegralByTrapezoid implements SolvingIntegral {

    private double accuracy;
    private double a;
    private double b;
    private long n;
    private Double result;
    private Double error;
    private static int BASIC_N = 5;


    @Override
    public void solve (FunctionCalculator functionCalculator) {
        int condition = 1;
        if (a >= b) {
            double tmp = a;
            a = b;
            b = tmp;
            condition = -1;
        }

        if ((functionCalculator.getValueOfFunction(a, accuracy) == -1 * functionCalculator.getValueOfFunction(b, accuracy)) && Double.isInfinite(functionCalculator.getValueOfFunction(0, accuracy))) {
            result = 0d;
            n = 0;
            error = 0d;
        } else {
            Double result1 = computeIntegral(BASIC_N, functionCalculator);
            solveRecursive(result1, BASIC_N, functionCalculator);
            result *= condition;
        }
    }

    private void solveRecursive (Double result1, long n, FunctionCalculator functionCalculator) throws StackOverflowError {
        n = 2 * n;
        Double result2 = computeIntegral(n, functionCalculator);

        if (Math.abs(result1 - result2) < accuracy) {
            result = result2;
            error = Math.abs((result1 - result2) / 3);
            this.n = n;
        } else solveRecursive(result2, n, functionCalculator);
    }

    private double computeIntegral (long n, FunctionCalculator functionCalculator) throws StackOverflowError {
        double h = (b - a) / n;
        double x = a + h;
        double sumOfY = 0;
        for (long i = 1; i <= n - 1; i++) {
            sumOfY += functionCalculator.getValueOfFunction(x, accuracy);
            x += h;
        }
        return h * ((functionCalculator.getValueOfFunction(a, accuracy) + functionCalculator.getValueOfFunction(b, accuracy)) / 2 + sumOfY);
    }

    public SolvingIntegralByTrapezoid (UserChoice choice) {
        this.accuracy = choice.getAccuracy( );
        this.a = choice.getIntegrationLeftLimit( );
        this.b = choice.getIntegrationRightLimit( );
    }


    @Override
    public Double getResult ( ) {
        return result;
    }

    @Override
    public Double getAccuracy ( ) {
        return accuracy;
    }

    @Override
    public long getNumberOfSplits ( ) {
        return n;
    }

    public Double getError ( ) {
        return error;
    }

}
