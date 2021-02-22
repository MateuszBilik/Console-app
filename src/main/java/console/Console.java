package console;

import console.commends.GetForConsole;
import console.commends.VolatilityForConsole;
import methods.MethodVolatility;
import one_line_of_data.DataForOneMinute;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

public class Console {

    Logger logger = Logger.getLogger(Console.class);

    public void runTerminalWithMethods(List<DataForOneMinute> listOfData) {
        logger.info("""
                What do you want to do with file?
                If you don't know, write \"help\"
                """);
        while (true) {
            startTerminal(listOfData);
        }
    }

    public List<DataForOneMinute> initialize() {
        new ConfigurationLogger().configuration();
        greetings();
        BufferedReader myFile = new FileLoader().loadFile();
        Converter converter = new Converter();
        return converter.createListWithDataForOneMinutesLines(myFile);
    }

    private void startTerminal(List<DataForOneMinute> listOfData) {
        String inputText = new Scanner(System.in).nextLine()
                .toLowerCase().replaceAll("\\s+", " ");
        String[] listToMethod = inputText.split(" ");
        logger.info(inputText);

        switch (listToMethod[0]) {
            case "exit":
                goodbye();
                System.exit(0);
            case "help":
                help();
            case "most_volatile_day":
                logger.info(MethodVolatility.mostVolatileDay(listOfData));
                break;
            case "most_volatile_hour":
                logger.info(MethodVolatility.mostVolatileHour(listOfData));
                break;
            case "average_minutely_volatility":
                logger.info(MethodVolatility.averageMinutelyVolatility(listOfData));
                break;
            case "average_hourly_volatility":
                logger.info(MethodVolatility.averageHourlyVolatility(listOfData));
                break;
            case "average_daily_volatility":
                logger.info(MethodVolatility.averageDailyVolatility(listOfData));
                break;
            case "get":
                try {
                   new GetForConsole().doGet(listOfData, listToMethod);
                } catch (IndexOutOfBoundsException|BadCommandException e) {
                    logger.info("You tried to use method \"get\" but something was wrong, try again." +
                            "\nCheck your date or time. Another option can be to lack data for this time in this file");
                }
                break;
            case "volatility":
                try {
                    new VolatilityForConsole().calculateVolatility(listOfData, listToMethod);
                } catch (BadCommandException|IndexOutOfBoundsException e) {
                    logger.info("You tried to use method \"volatility\" but something was wrong, try again." +
                            "\nCheck your date or time. Another option can be to lack data for this time in this file");
                }
                break;
            default:
                logger.info("There isn't this method, try again or check out using \"help\"");
        }
    }

    void goodbye() {
        logger.info("""
                Thank you for using our app.
                See you soon!
                """);
    }

    private void greetings() {
        logger.info("""
                Hello,
                Welcome in this app!
                You can always quit the app by writing "exit".
                Please, give your file name which you would like to work with:
                """);
    }
    private void help() {
        logger.info("""
                List of commends:
                 - get <high/low/open/close> yyyy.mm.dd hh:mm (choose one type)
                 - get <high/low/open/close> yyyy.mm.dd hh (choose one type)
                 - get <high/low/open/close> yyyy.mm.dd (choose one type)
                 - get yyyy.mm.dd hh:mm
                 - get yyyy.mm.dd hh
                 - get yyyy.mm.dd
                 - volatility yyyy.mm.dd hh:mm
                 - volatility yyyy.mm.dd hh
                 - volatility yyyy.mm.dd
                 - most_volatile_day
                 - most_volatile_hour
                 - average_minutely_volatility
                 - average_hourly_volatility
                 - average_daily_volatility
                 
                 for example: get 2020.11.02 13:55 
                 for example: get low 2020.11.02 13:55
                 """);
    }
}
