package console.commends;

import console.BadCommandException;
import methods.MethodVolatility;
import one_line_of_data.DataForOneMinute;
import one_line_of_data.MyDate;
import one_line_of_data.MyTime;
import org.apache.log4j.Logger;

import java.util.List;

public class VolatilityForConsole extends DateAndTimeConverter {

    Logger logger = Logger.getLogger(VolatilityForConsole.class);

    public void calculateVolatility(List<DataForOneMinute> listOfData, String[] type) throws BadCommandException {

        MyDate myDate = dateToTerminal(type[1]);
        if (type.length == 2) {

            logger.info(MethodVolatility.volatilityForDay(listOfData, myDate.getDay(),
                    myDate.getMonth(), myDate.getYear()));

        } else if (type.length == 3) {
            if (patternHour.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminalOnlyHour(type[2]);

                logger.info(MethodVolatility.volatilityForHour(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour()));

            } else if (patternMinute.matcher(type[2]).matches()) {
                MyTime myTime = timeToTerminal(type[2]);

                logger.info(MethodVolatility.volatilityForMinute(listOfData, myDate.getDay(),
                        myDate.getMonth(), myDate.getYear(), myTime.getHour(), myTime.getMinute()));
            }
        }
    }
}
