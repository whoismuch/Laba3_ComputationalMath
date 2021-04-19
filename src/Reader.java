import java.util.Scanner;

public class Reader {

    private Scanner scanner;
    private String[] functions;
    private UserChoice choice;

    public UserChoice getChoice ( ) {
        return choice;
    }

    public void setChoice (UserChoice choice) {
        this.choice = choice;
    }

    public Reader (Scanner scanner, String[] functions) {
        this.scanner = scanner;
        this.functions = functions;
    }

    public String[] getFunctions ( ) {
        return functions;
    }

    public Reader (Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner ( ) {
        return scanner;
    }

    public void read() {
        ReaderFromConsole readerFromConsole = new ReaderFromConsole(scanner, this);
        readerFromConsole.readFromConsole( );
    }


}
