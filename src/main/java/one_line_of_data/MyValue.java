package one_line_of_data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
@Getter
public class MyValue {

    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;

    @Override
    public String toString() {
        return  "open = " + open +
                ", high = " + high +
                ", low = " + low +
                ", close = " + close;
    }
}
