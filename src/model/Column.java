package model;

import enums.ColumnType;
import validators.ValidatorFactory;
import validators.Constraints;
import validators.Validator;

import java.util.List;

public class Column {
    private String name;
    private ColumnType type;
    private List<Validator> validators;

    private List<Constraints> constraints;

    public Column(String name, ColumnType type, List<Constraints> constraints) {
        this.name = name;
        this.type = type;
        this.validators = ValidatorFactory.validators(type);
        this.constraints = constraints;
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public List<Constraints> getConstraints() {
        return constraints;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                '}';
    }
}
