package validators;

public class NonNullValidator implements Validator {
    @Override
    public void validate(Object object) {
        if(object == null) {
            throw new IllegalArgumentException("Received null value for non null column");
        }
    }
}
