package fa.training.utils;

import fa.training.entities.Book;
import fa.training.entities.Warehouse;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidatorUtil {
    public static final String PHONE_REGEX = "0[0-9]{9}";
    public static boolean validate(Book book) throws IllegalArgumentException{
        boolean check = true;
        if(book.getYear() < 1950 || book.getYear() > LocalDate.now().getYear()){
            check = false;
            throw new IllegalArgumentException("Year Invalid");
        }
        return check;
    }
    public static boolean validate(Warehouse warehouse) throws IllegalArgumentException{
        boolean check = true;
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        if(!pattern.matcher(warehouse.getPhone()).matches()){
            check = false;
            throw new IllegalArgumentException("Phone Number Invalid");
        }
        return check;
    }
}
