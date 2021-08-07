package fa.training.util;

import fa.training.dao.ContentDao;
import fa.training.dao.MemberDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    MemberDao memberDao;
    ContentDao contentDao;

    public ValidatorUtil() {

    }

    public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
    public static final String PHONE_REGEX = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
