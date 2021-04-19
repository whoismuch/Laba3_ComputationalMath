import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        String[] functions = {"5sin(x)/x", "2x^3-3x^2+x-1", "e^x-6", "3/x^(1/2)", "cos(x)+2^x", "1/x"};
        HashMap<Integer, FunctionCalculator> functionValueCalculatorHashMap = new HashMap<>( );
        functionValueCalculatorHashMap.put(1, new FunctionCalculator1( ));
        functionValueCalculatorHashMap.put(2, new FunctionCalculator2( ));
        functionValueCalculatorHashMap.put(3, new FunctionCalculator3( ));
        functionValueCalculatorHashMap.put(4, new FunctionCalculator4( ));
        functionValueCalculatorHashMap.put(5, new FunctionCalculator5( ));
        functionValueCalculatorHashMap.put(6, new FunctionCalculator6( ));

        //Считываем данные
        Reader reader = new Reader(new Scanner(System.in), functions);
        reader.read( );


        SolvingIntegralByTrapezoid solvingIntegralByTrapezoid = new SolvingIntegralByTrapezoid(reader.getChoice( ));
        solvingIntegralByTrapezoid.solve(functionValueCalculatorHashMap.get(reader.getChoice( ).getNumber( )));

        Writer writer = new Writer( );
        writer.writeAnswer(solvingIntegralByTrapezoid);
    }
}
