package console.commends;
import console.BadCommandException;
import one_line_of_data.MyDate;
import one_line_of_data.MyTime;
import java.util.regex.Pattern;

public class DateAndTimeConverter {

    public static final int NUMBER_OF_HOURS = 24;
    public static final int NUMBER_DAY_IN_MONTHS = 31;
    public static final int NUMBER_OF_MONTHS = 12;
    public static final int NUMBER_OF_MINUTES = 60;

    Pattern patternHour = Pattern.compile("\\d{2}");
    Pattern patternMinute = Pattern.compile("\\d{2}\\:\\d{2}");
    Pattern patternDate = Pattern.compile("\\d{4}\\.\\d{2}\\.\\d{2}");

    MyDate dateToTerminal(String date) throws BadCommandException {
        if (patternDate.matcher(date).matches()) {
            String[] listOfDate = date.split("\\.");
            if (isNumberMonthsAndDaysCorrect(listOfDate)) {
                return new MyDate(Integer.valueOf(listOfDate[0]),
                        Integer.valueOf(listOfDate[1]), Integer.valueOf(listOfDate[2]));
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    MyTime timeToTerminal(String time) throws BadCommandException {
        if (patternMinute.matcher(time).matches()) {
            String[] listOfDate = time.split(":");
            if (isHourAndMinutesCorrect(listOfDate)) {
                return new MyTime(Integer.parseInt(listOfDate[0]), Integer.parseInt(listOfDate[1]));
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    MyTime timeToTerminalOnlyHour(String time) throws BadCommandException {
        if (patternHour.matcher(time).matches()) {
            if (isHourCorrect(time)) {
                return new MyTime(Integer.parseInt(time), 0);
            } else {
                throw new BadCommandException();
            }
        } else {
            throw new BadCommandException();
        }
    }

    private boolean isHourCorrect(String time) {
        return Integer.parseInt(time) < NUMBER_OF_HOURS
                && 0 <= Integer.parseInt(time);
    }

    private boolean isNumberMonthsAndDaysCorrect(String[] listOfDate) {
        return Integer.parseInt(listOfDate[1]) <= NUMBER_OF_MONTHS
                && Integer.parseInt(listOfDate[2]) <= NUMBER_DAY_IN_MONTHS
                && 0 < Integer.parseInt(listOfDate[1])
                && 0 < Integer.parseInt(listOfDate[2]);
    }

    private boolean isHourAndMinutesCorrect(String[] listOfDate) {
        return Integer.parseInt(listOfDate[0]) < NUMBER_OF_HOURS
                && Integer.parseInt(listOfDate[1]) < NUMBER_OF_MINUTES
                && 0 <= Integer.parseInt(listOfDate[0])
                && 0 <= Integer.parseInt(listOfDate[1]);
    }
}
