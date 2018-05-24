import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Logic {

    private static final String NUMBER_STRING = "(0|-?[1-9]\\d*)(\\.\\d+)?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_STRING);

    public static Model processParameters(String param1, String param2) {
        if (param1 == null || param2 == null) {
            return new Model(ResponseType.MISSING_PARAMETER);
        }
        if((param1 = param1.trim()).isEmpty() || (param2 = param2.trim()).isEmpty()) {
            return new Model(ResponseType.MISSING_PARAMETER);
        }
        if (!NUMBER_PATTERN.matcher(param1).matches() || !NUMBER_PATTERN.matcher(param2).matches()) {
            return new Model(ResponseType.NAN_PARAMETER);
        }
        Model resultModel = new Model(ResponseType.OK);
        resultModel.setResult(new BigDecimal(param1).add(new BigDecimal(param2)));
        return resultModel;
    }

}
