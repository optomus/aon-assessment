package au.com.aon.domain;

import java.math.BigDecimal;

/**
 *
 */
public class Utils {
    public static boolean isGreater(BigDecimal first, BigDecimal second) {
        if (first != null && second != null) {
            return first.compareTo(second) == -1;
        }
        return false;
    }

}
