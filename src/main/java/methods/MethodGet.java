package methods;

import one_line_of_data.DataForOneMinute;
import one_line_of_data.MyValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MethodGet {

    public static List<DataForOneMinute> getForDay(List<DataForOneMinute> list, int day, int month, int year) {
        return list.stream()
                .filter(x -> x.getDate().getYear() == year)
                .filter(x -> x.getDate().getMonth() == month)
                .filter(x -> x.getDate().getDay() == day)
                .collect(Collectors.toList());
    }

    public static List<DataForOneMinute> getForHour(List<DataForOneMinute> list, int day, int month, int year, int hour) {
        return getForDay(list, day, month, year).stream()
                .filter(x -> x.getTime().getHour() == hour)
                .collect(Collectors.toList());
    }

    public static List<DataForOneMinute> getForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute) {
        return getForHour(list, day, month, year, hour).stream()
                .filter(x -> x.getTime().getMinute() == minute)
                .collect(Collectors.toList());
    }

    public static BigDecimal getTypeForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute, String type) {
        list = getForMinute(list, day, month, year, hour, minute);
        return getType(list, type);
    }

    public static BigDecimal getTypeForHour(List<DataForOneMinute> list, int day, int month, int year, int hour, String type) {
        list = getForHour(list, day, month, year, hour);
        return getType(list, type);
    }

    public static BigDecimal getTypeForDay(List<DataForOneMinute> list, int day, int month, int year, String type) {
        list = getForDay(list, day, month, year);
        return getType(list, type);
    }

    private static BigDecimal getType(List<DataForOneMinute> list, String type) {
        switch (type) {
            case "open":
                return openValueForPeriodTime(list);
            case "high":
                return highForTimePeriod(list);
            case "low":
                return lowForTimePeriod(list);
            case "close":
                return closeForTimePeriod(list);
            default:
                return BigDecimal.ZERO;
        }
    }

    private static BigDecimal lowForTimePeriod(List<DataForOneMinute> list) {
        return list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getLow)
                .sorted()
                .collect(Collectors.toList())
                .get(0);
    }

    private static BigDecimal highForTimePeriod(List<DataForOneMinute> list) {
        return list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getHigh)
                .sorted()
                .collect(Collectors.toList())
                .get(list.size() - 1);
    }

    private static BigDecimal closeForTimePeriod(List<DataForOneMinute> list) {
        return list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getClose)
                .collect(Collectors.toList())
                .get(list.size() - 1);
    }

    private static BigDecimal openValueForPeriodTime(List<DataForOneMinute> list) {
        return list.stream()
                .map(DataForOneMinute::getValue)
                .map(MyValue::getOpen)
                .collect(Collectors.toList())
                .get(0);
    }
}

