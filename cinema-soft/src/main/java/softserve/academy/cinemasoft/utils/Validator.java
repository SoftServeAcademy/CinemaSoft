package softserve.academy.cinemasoft.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator  {

    public boolean isValid(String time){
        Pattern pattern;
        Matcher matcher;
        String time12HOURS_PATTERN = "([0|1]?[0-9]|2[0-3]):[0-5][0-9]";
        pattern = Pattern.compile(time12HOURS_PATTERN);
        matcher = pattern.matcher(time);
        return matcher.matches();
    }
}

