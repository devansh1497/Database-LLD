package filter;

import enums.FilterOperator;
import model.Column;
import model.ColumnData;
import model.Row;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter {

    private Column column;
    private Object target;

    public Filter(Column column, Object target) {
        this.column = column;
        this.target = target;
    }


    public List<Row> filter(List<Row> rows, BiFunction<Object, Object, Boolean> logic) {
        List<Row> ans = new ArrayList<>();
        for (Row row : rows) {
            boolean include = false;
            for (ColumnData columnDatum : row.getColumnData()) {
                if (columnDatum.getColumn().getName().equals(column.getName()) && logic.apply(columnDatum.getData(),
                        target)) {
                    include = true;
                    break;
                }
            }
            if (include) {
                ans.add(row);
            }
        }
        return ans;
    }
}
