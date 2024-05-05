package validators;

public class IntValidator implements Validator {
    @Override
    public void validate(Object object) {
        if(!(object instanceof Integer)) {
            throw new IllegalArgumentException("Integer validation failed");
        }
        int val = (Integer) object;
        if(val < -1024 || val > 1024) {
            throw new IllegalArgumentException("Invalid value for integer type: "+val);
        }
    }
}
