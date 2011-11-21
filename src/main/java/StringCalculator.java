import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int result = 0;
    String regexBreaks = "(\n|,)";
    String regexDisallowed = "(,\n|\n,)";
    Pattern pattern = Pattern.compile(regexDisallowed);

    public int add(String numbers) {
        if (!numbers.equals("")) {
            Matcher matcher = pattern.matcher(numbers);
            if (matcher.find()) {
                throw new IllegalArgumentException(numbers);
            }

            String[] split = numbers.split(regexBreaks);
            if (split.length > 1) {
                for (String x : split) {
                    result = result + Integer.parseInt(x);
                }
            } else {
                result = Integer.parseInt(numbers);
            }

            return result;
        } else {
            return 0;
        }
    }
}
