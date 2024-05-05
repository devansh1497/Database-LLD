package validators;

public class StringValidator implements Validator {
    @Override
    public void validate(Object object) {
        if(!(object instanceof String) || ((String)object).length() > 20) {
            throw new IllegalArgumentException("String validation failed");
        }
        String val = (String) object;
        if(val.length() > 20) {
            throw new IllegalArgumentException("Too long value for string data type: " +val);
        }
    }
}
