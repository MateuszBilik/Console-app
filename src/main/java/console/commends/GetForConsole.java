package console.commends;

import console.BadCommandException;
import methods.MethodGet;
import one_line_of_data.DataForOneMinute;
import one_line_of_data.MyDate;
import one_line_of_data.MyTime;
import org.apache.log4j.Logger;

import java.util.List;

public class GetForConsole extends DateAndTimeConverter {

    Logger logger = Logger.getLogger(GetForConsole.class);

    public void doGet(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {

        if (type[1].equals("close") || type[1].equals("open") || type[1].equals("low") || type[1].equals("high")) {
            getWithType(listOfData, type);
        } else {
            getWithoutType(listOfData, type);
        }
    }

    public void getWithoutType(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {
        MyDate myDate = dateToTerminal(type[1]);
        if (type.length == 2) {
            logger.info(MethodGet.getForDay(listOfData, myDate.getDay(),
                    myDate.getMonth(), myDate.getYear()));
        } else if (type.length == 3) {
            if (patternHour.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminalOnlyHour(type[2]);
                logger.info(MethodGet.getForHour(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour()));
            } else if (patternMinute.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminal(type[2]);
                logger.info(MethodGet.getForMinute(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute()));
            }
        }
    }

    public void getWithType(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {
        MyDate myDate = dateToTerminal(type[2]);
        if (type.length == 3) {
            logger.info(MethodGet.getTypeForDay(listOfData, myDate.getDay(),
                    myDate.getMonth(), myDate.getYear(), type[1]));
        } else if (type.length == 4) {
            if (patternHour.matcher(type[3]).matches()) {
                MyTime myTime = timeToTerminalOnlyHour(type[3]);
                logger.info(MethodGet.getTypeForHour(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), type[1]));
            } else if (patternMinute.matcher(type[3]).matches()) {
                MyTime myTime = timeToTerminal(type[3]);
                logger.info(MethodGet.getTypeForMinute(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute(), type[1]));
            }
        }
    }
}
