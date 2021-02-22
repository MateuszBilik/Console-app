package one_line_of_data;

import lombok.Getter;

@Getter
public class DataForOneMinute {

    private MyDate date;
    private MyTime time;
    private MyValue value;

    public DataForOneMinute(MyDate date, MyTime time, MyValue value) {
        this.date = date;
        this.time = time;
        this.value = value;
    }

    @Override
    public String toString() {
        return "\nData for " + date +
                " " + time +
                "\n" + value
                + "\n=====================";
    }
}
