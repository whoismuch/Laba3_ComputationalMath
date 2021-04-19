public interface SolvingIntegral {

    void solve(FunctionCalculator functionCalculator);

    Double getResult();

    Double getAccuracy();

    long getNumberOfSplits();

    Double getError();
}
