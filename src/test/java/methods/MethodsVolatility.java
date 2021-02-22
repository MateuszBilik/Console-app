package methods;

import ListForTest.FileTest;
import one_line_of_data.DataForOneMinute;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

class MethodsVolatility {


    private static final Integer YEAR = 2020;
    private static final Integer MONTH = 11;
    private static final Integer DAY = 01;
    private static final Integer MINUTE = 27;
    private static final Integer HOUR = 23;
    List<DataForOneMinute> listOfData = new FileTest().getList();

    MethodsVolatility() throws IOException {
    }

    @Test
    void volatilityForDayHourMinute_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        //given
        BigDecimal valueForDayExpected = BigDecimal.valueOf(0.00203);
        BigDecimal valueForHourExpected = BigDecimal.valueOf(0.00104);
        BigDecimal valueForMinuteExpected = BigDecimal.valueOf(0.00004);
        //when
        BigDecimal valueForDay = MethodVolatility.volatilityForDay(listOfData, DAY, MONTH, YEAR);
        BigDecimal valueForHour = MethodVolatility.volatilityForHour(listOfData, DAY, MONTH, YEAR, HOUR);
        BigDecimal valueForMinute = MethodVolatility.volatilityForMinute(listOfData, DAY, MONTH, YEAR, HOUR, MINUTE);
        //then
        assert (valueForDayExpected.compareTo(valueForDay) == 0);
        assert (valueForHourExpected.compareTo(valueForHour) == 0);
        assert (valueForMinuteExpected.compareTo(valueForMinute) == 0);
    }

    @Test
    void isMostVolatileDayCorrect() {
        //given
        BigDecimal expectedValue = BigDecimal.valueOf(0.01678);
        //when
        BigDecimal mostVolatileDay = MethodVolatility.mostVolatileDay(listOfData);
        //then
        assert (expectedValue.compareTo(mostVolatileDay) == 0);
    }

    @Test
    void isMostVolatileHourCorrect() {
        //given
        BigDecimal expectedValue = BigDecimal.valueOf(0.00832);
        //when
        BigDecimal mostVolatileHour = MethodVolatility.mostVolatileHour(listOfData);
        //then
        assert (expectedValue.compareTo(mostVolatileHour) == 0);
    }

    @Test
    void isAverageMinutelyVolatilityCorrect() {
        //given
        BigDecimal expectedValue = BigDecimal.valueOf(0.00016);
        //when
        BigDecimal averageMinutelyVolatility = MethodVolatility.averageMinutelyVolatility(listOfData);
        //then
        assert (expectedValue.compareTo(averageMinutelyVolatility) == 0);
    }

    @Test
    void isAverageHourlyVolatilityCorrect() {
        //given
        BigDecimal expectedValue = BigDecimal.valueOf(0.00144);
        //when
        BigDecimal averageHourlyVolatility = MethodVolatility.averageHourlyVolatility(listOfData);
        //then
        assert (expectedValue.compareTo(averageHourlyVolatility) == 0);
    }
    @Test
    void isAverageDailyVolatilityCorrect() {
        //given
        BigDecimal expectedValue = BigDecimal.valueOf(0.00648);
        //when
        BigDecimal averageDailyVolatility = MethodVolatility.averageDailyVolatility(listOfData);
        //then
        assert (expectedValue.compareTo(averageDailyVolatility) == 0);
    }
}