package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Object stringToValue(String text) throws ParseException {
        return df.parse(text);
    }
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return df.format(cal.getTime());
        }
        return "";
    }
}

