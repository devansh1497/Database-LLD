package validators;

import enums.ColumnType;
import validators.IntValidator;
import validators.StringValidator;
import validators.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidatorFactory {

    public static List<Validator> validators(ColumnType type) {
        if(type == ColumnType.INTEGER) {
            return Arrays.asList(new IntValidator());
        } else if(type == ColumnType.STRING) {
            return Arrays.asList(new StringValidator());
        } return new ArrayList<>();
    }
}
