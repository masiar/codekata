import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {

        int result = 0;
        String delimiter = ","; // default delimiter
        String regexInvalidArguments = "(\n" + delimiter + "|" + delimiter + "\n)|(\\-\\d)";

        if (!numbers.isEmpty()) {

            if (numbers.startsWith("//")) {
                delimiter = numbers.substring(2, 3);
                numbers = numbers.substring(4, numbers.length());
            }

            validate(regexInvalidArguments, numbers);

            String[] split = numbers.split("(\n|\\" + delimiter + ")");
            if (split.length > 0) {
                for (String eachNumber : split) {
                    result = result + Integer.parseInt(eachNumber);
                }
            } else {
                result = Integer.parseInt(numbers);
            }

            return result;
        } else {
            return 0;
        }
    }

    private void validate(String regexp, String numbers) {
        String sd = "";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            matcher = pattern.matcher(numbers);
            while (matcher.find()) {
                sd = sd + matcher.group();
            }
            if (sd.contains("-")) {
                numbers = sd;
            }
            throw new IllegalArgumentException(numbers);
        }
    }
}
