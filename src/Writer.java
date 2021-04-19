public class Writer {

    public void writeAnswer(SolvingIntegral solvingIntegral) {
        double accuracy = solvingIntegral.getAccuracy();
        String[] splitter = String.valueOf(accuracy).split("\\.");
        Integer i = splitter[1].length( );
        i += 2;
        System.out.printf("Значение интеграла: %." + i.toString( ) + "f %n", solvingIntegral.getResult());
        System.out.println("Количество разбиений: " + solvingIntegral.getNumberOfSplits() + "\r");
        System.out.printf("Погрешность: %." + i.toString( ) + "f %n", solvingIntegral.getError());
    }
}
