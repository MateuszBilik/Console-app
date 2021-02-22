import console.Console;
import one_line_of_data.DataForOneMinute;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        List<DataForOneMinute> listOfData = console.initialize();
        console.runTerminalWithMethods(listOfData);
    }
}

