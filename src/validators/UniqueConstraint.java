package validators;

import enums.ColumnType;
import exceptions.ConstraintViolationException;
import model.Column;
import model.ColumnData;
import model.Row;
import model.Table;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UniqueConstraint implements Constraints {
    @Override
    public void validate(Table table, Column column, Object x) throws ConstraintViolationException {
        List<ColumnData> columnData =
                table.getRows().stream().map(Row::getColumnData).flatMap(Collection::stream).
                        filter(data -> data.getColumn().getName().equals(column.getName())).toList();

        for (ColumnData cd : columnData) {
            if (Objects.equals(cd.getData(), x)) {
                throw new ConstraintViolationException("Unique constraint violation!");
            }
        }
    }
}
