import java.util.Scanner;

public class ReaderFromConsole extends Reader {
    private Reader reader;

    public ReaderFromConsole (Scanner scanner, Reader reader) {
        super(scanner);
        this.reader = reader;
    }

    public void readFromConsole() {
        int numberOfFunction = readNumber(reader.getFunctions(),
                "Выберите одну из предложенных функций, которую хотите проинтегрировать (введите номер понравившейся)",
                "Ну вы чего, функции под таким номером нет",
                "Номер должен быть целым числом"
        );


        double[] integrationLimits = readLimits(numberOfFunction);
        double accuracyOfIntegration = readAccuracy();

        UserChoice choice = new UserChoice(numberOfFunction, accuracyOfIntegration, integrationLimits[0], integrationLimits[1]);
        reader.setChoice(choice);

    }

    private double readAccuracy () {
        double accuracy = 0;
        System.out.println("Введите предпочитаемую точность вычисления значения интеграла:");
        while (true) {
            try {
                String strDecision = getScanner( ).nextLine( );
                accuracy = Double.parseDouble(strDecision);
                if (accuracy <= 0) {
                    System.out.println("Точность должна быть положительной");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Точность - это число");
                continue;
            }
        }

        return accuracy;
    }

    private double[] readLimits (int numberOfFunctions) {
        double left = 0;
        System.out.println("Введите левый предел интегрирования");
        while (true) {
            try {
                String strDecision = getScanner( ).nextLine( );
                left = Double.parseDouble(strDecision);
                if (numberOfFunctions == 4 && left < 0) {
                    System.out.println("Функция не определена при этом пределе интегрирования");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Предел интегрирования - это число");
                continue;
            }
        }

        double right = 0;
        System.out.println("Введите правый предел интегрирования");
        while (true) {
            try {
                String strDecision = getScanner( ).nextLine( );
                right = Double.parseDouble(strDecision);
                if (numberOfFunctions == 4 && right < 0) {
                    System.out.println("Функция не определена при этом пределе интегрирования");
                    continue;
                }
                if (numberOfFunctions == 6 && right*-1 != left) {
                    System.out.println("Отрезок должен быть симметричным");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Предел интегрирования - это число");
                continue;
            }
        }

        double[] result = {left, right};

        return result;
    }

    public int readNumber(String[] array, String startMessage, String boundaryError, String formatError) {
        int decision = 0;

        System.out.println(startMessage);
        for (Integer i=1; i<=array.length; i++) {
            System.out.println(i + ") " + array[i-1]);
        }
        while (true) {
            try {
                String strDecision = getScanner( ).nextLine( );
                decision = Integer.parseInt(strDecision);
                if (decision < 1 || decision > array.length) {
                    System.out.println(boundaryError);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(formatError);
                continue;
            }
        }

        return decision;
    }
}
