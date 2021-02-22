package one_line_of_data;

public class MyDate {

    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    @Override
    public String toString() {
        return year +
                "." + month +
                "." + day;
    }
}
