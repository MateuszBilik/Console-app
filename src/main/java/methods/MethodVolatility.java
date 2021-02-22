package methods;

import one_line_of_data.DataForOneMinute;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MethodVolatility {

    public static BigDecimal volatilityForDay(List<DataForOneMinute> list, int day, int month, int year) {

        return MethodGet.getTypeForDay(list, day, month, year, "high")
                .subtract(MethodGet.getTypeForDay(list, day, month, year, "low"));
    }

    public static BigDecimal volatilityForHour(List<DataForOneMinute> list, int day, int month, int year, int hour) {

        return MethodGet.getTypeForHour(list, day, month, year, hour, "high")
                .subtract(MethodGet.getTypeForHour(list, day, month, year, hour, "low"));
    }

    public static BigDecimal volatilityForMinute(List<DataForOneMinute> list, int day, int month, int year, int hour, int minute) {

        return MethodGet.getTypeForMinute(list, day, month, year, hour, minute, "high")
                .subtract(MethodGet.getTypeForMinute(list, day, month, year, hour, minute, "low"));
    }


    public static BigDecimal mostVolatileHour(List<DataForOneMinute> list) {

        BigDecimal mostVolatileForHour = BigDecimal.ZERO;
        Integer hour = 25; //hour which doesn't exist

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getTime().getHour() != hour) {
                hour = list.get(i).getTime().getHour();

                BigDecimal volatileForHour = volatilityForHour(
                        list,
                        list.get(i).getDate().getDay(),
                        list.get(i).getDate().getMonth(),
                        list.get(i).getDate().getYear(),
                        hour);

                if (volatileForHour.compareTo(mostVolatileForHour) == 1) {
                    mostVolatileForHour = volatileForHour;
                }
            }
        }
        return mostVolatileForHour;
    }

    public static BigDecimal mostVolatileDay(List<DataForOneMinute> list) {

        BigDecimal mostVolatileForDay = BigDecimal.ZERO;
        Integer Day = 32; //day which doesn't exist

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getDate().getDay() != Day) {
                Day = list.get(i).getDate().getDay();

                BigDecimal volatileForDay = volatilityForDay(
                        list,
                        list.get(i).getDate().getDay(),
                        list.get(i).getDate().getMonth(),
                        list.get(i).getDate().getYear());

                if (volatileForDay.compareTo(mostVolatileForDay) == 1) {
                    mostVolatileForDay = volatileForDay;
                }
            }
        }
        return mostVolatileForDay;
    }

    public static BigDecimal averageMinutelyVolatility(List<DataForOneMinute> list) {

        BigDecimal sumOfElements = BigDecimal.ZERO;
        BigDecimal numberOfElements = BigDecimal.valueOf(list.size());

        for (int i = 0; i < list.size() - 1; i++) {
            sumOfElements = sumOfElements.add(list.get(i).getValue().getHigh()
                    .subtract(list.get(i).getValue().getLow()));
        }
        return sumOfElements.divide(numberOfElements, RoundingMode.valueOf(4));
    }

    public static BigDecimal averageHourlyVolatility(List<DataForOneMinute> list) {

        BigDecimal sumOfElements = BigDecimal.ZERO;
        BigDecimal numberOfElements = BigDecimal.ZERO;
        Integer hour = 25; //hour which doesn't exist

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getTime().getHour() != hour) {
                hour = list.get(i).getTime().getHour();
                numberOfElements = numberOfElements.add(BigDecimal.ONE);

                sumOfElements = sumOfElements.add(volatilityForHour(
                        list,
                        list.get(i).getDate().getDay(),
                        list.get(i).getDate().getMonth(),
                        list.get(i).getDate().getYear(),
                        hour));
            }
        }
        return sumOfElements.divide(numberOfElements, RoundingMode.valueOf(4));
    }

    public static BigDecimal averageDailyVolatility(List<DataForOneMinute> list) {

        BigDecimal sumOfElements = BigDecimal.ZERO;
        BigDecimal numberOfElements = BigDecimal.ZERO;
        Integer Day = 32; //day which doesn't exist

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getDate().getDay() != Day) {
                Day = list.get(i).getDate().getDay();
                numberOfElements = numberOfElements.add(BigDecimal.ONE);

                sumOfElements = sumOfElements.add(volatilityForDay(
                        list,
                        list.get(i).getDate().getDay(),
                        list.get(i).getDate().getMonth(),
                        list.get(i).getDate().getYear()));
            }
        }
        return sumOfElements.divide(numberOfElements, RoundingMode.valueOf(4));
    }
}
