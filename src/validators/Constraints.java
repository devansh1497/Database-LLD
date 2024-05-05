package validators;

import exceptions.ConstraintViolationException;
import model.Column;
import model.Table;

public interface Constraints {

    void validate(Table table, Column column, Object x) throws ConstraintViolationException;
}
