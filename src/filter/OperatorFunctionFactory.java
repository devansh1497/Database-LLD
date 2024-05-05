package filter;

import enums.FilterOperator;

import java.util.Objects;
import java.util.function.BiFunction;

public class OperatorFunctionFactory {

    public static BiFunction<Object, Object, Boolean> get(FilterOperator operator){
            if(operator == FilterOperator.EQUAL) {
                return Objects::equals;
            } else if(operator == FilterOperator.NOT_EQUAL) {
                return (x,y) -> !Objects.equals(x,y);
            } else{
                throw new IllegalArgumentException("Invalid operator");
            }
    }

}
