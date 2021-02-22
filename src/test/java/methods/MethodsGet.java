package methods;

import ListForTest.FileTest;
import one_line_of_data.DataForOneMinute;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


class MethodsGet {

    private static final Integer YEAR = 2020;
    private static final Integer MONTH = 11;
    private static final Integer DAY = 01;
    private static final  Integer MINUTE = 27;
    private static final  Integer HOUR = 23;
    List<DataForOneMinute> listOfData = new FileTest().getList();

    MethodsGet() throws IOException {
    }

    @Test
    void getTypeForDay_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = BigDecimal.valueOf(1.16503);
        BigDecimal expectedValueLow = BigDecimal.valueOf(1.163);
        BigDecimal expectedValueOpen = BigDecimal.valueOf(1.16498);
        BigDecimal expectedValueClose = BigDecimal.valueOf(1.1631);

        // when
        BigDecimal valueHigh = MethodGet.getTypeForDay(listOfData, DAY, MONTH, YEAR, "high");
        BigDecimal valueLow = MethodGet.getTypeForDay(listOfData, DAY, MONTH, YEAR, "low");
        BigDecimal valueOpen = MethodGet.getTypeForDay(listOfData, DAY, MONTH, YEAR, "open");
        BigDecimal valueClose = MethodGet.getTypeForDay(listOfData, DAY, MONTH, YEAR, "close");
        // then
        assert (expectedValueHigh).equals(valueHigh);
        assert (expectedValueLow).equals(valueLow);
        assert (expectedValueOpen).equals(valueOpen);
        assert (expectedValueClose).equals(valueClose);
    }

    @Test
    void getTypeForHour_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = BigDecimal.valueOf(1.16404);
        BigDecimal expectedValueLow = BigDecimal.valueOf(1.16300);
        BigDecimal expectedValueOpen = BigDecimal.valueOf(1.16404);
        BigDecimal expectedValueClose = BigDecimal.valueOf(1.1631);

        // when
        BigDecimal valueHigh = MethodGet.getTypeForHour(listOfData, DAY, MONTH, YEAR, HOUR, "high");
        BigDecimal valueLow = MethodGet.getTypeForHour(listOfData, DAY, MONTH, YEAR, HOUR, "low");
        BigDecimal valueOpen = MethodGet.getTypeForHour(listOfData, DAY, MONTH, YEAR, HOUR, "open");
        BigDecimal valueClose = MethodGet.getTypeForHour(listOfData, DAY, MONTH, YEAR, HOUR, "close");
        // then
        assert (expectedValueHigh).equals(valueHigh);
        assert (expectedValueLow).equals(valueLow);
        assert (expectedValueOpen).equals(valueOpen);
        assert (expectedValueClose).equals(valueClose);
    }

    @Test
    void getTypeMinute_compareSomeExamplesParameterFromFileWithCorrectAnswer() throws IOException {
        // given
        BigDecimal expectedValueHigh = BigDecimal.valueOf(1.16352);
        BigDecimal expectedValueLow = BigDecimal.valueOf(1.16348);
        BigDecimal expectedValueOpen = BigDecimal.valueOf(1.16348);
        BigDecimal expectedValueClose = BigDecimal.valueOf(1.16351);
        // when
        BigDecimal valueHigh = MethodGet.getTypeForMinute(listOfData, DAY, MONTH, YEAR, HOUR, MINUTE, "high");
        BigDecimal valueLow = MethodGet.getTypeForMinute(listOfData, DAY, MONTH, YEAR, HOUR, MINUTE, "low");
        BigDecimal valueOpen = MethodGet.getTypeForMinute(listOfData, DAY, MONTH, YEAR, HOUR, MINUTE, "open");
        BigDecimal valueClose = MethodGet.getTypeForMinute(listOfData, DAY, MONTH, YEAR, HOUR, MINUTE, "close");
        // then
        assert (expectedValueHigh).equals(valueHigh);
        assert (expectedValueLow).equals(valueLow);
        assert (expectedValueOpen).equals(valueOpen);
        assert (expectedValueClose).equals(valueClose);
    }
}