package console;

import java.util.Scanner;

public class CommandReader {

    Scanner scanner = new Scanner(System.in);

    public String getNextCommand() {
        return scanner.nextLine();
    }
}
