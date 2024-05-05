package model;

import exceptions.ConstraintViolationException;
import validators.Constraints;
import validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;
    private List<Row> rows;

    public Table(String name, List<Column> columns) {
        this.name = name;
        //validate that atleast 1 column should exist
        this.columns = columns;
        this.rows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public int insert(List<List<Object>> data) throws ConstraintViolationException {
        List<Column> columns = getColumns();
        int currentSize = getRows().size();
        int idx = 0;
        try {
            List<Row> row = new ArrayList<>();
            for (List<Object> d : data) {
                idx++;
                if(d.size() != columns.size()) {
                    throw new RuntimeException("Given data and column size dont match");
                }
                int rowNo = currentSize+idx+1;
                List<ColumnData> columnData = new ArrayList<>();
                for (int i = 0; i < columns.size(); i++) {
                    Column column = columns.get(i);
                    for (Validator validator : column.getValidators()) {
                        validator.validate(d.get(i));
                    }
                    for (Constraints constraint : column.getConstraints()) {
                        constraint.validate(this, column, d.get(i));
                    }
                    columnData.add(new ColumnData(d.get(i), columns.get(i)));
                }
                row.add(new Row(rowNo, columnData));
                setRows(row);
            }
            return data.size();
        } catch (Exception e) {
            setRows(getRows().subList(0, Math.min(0,currentSize+1)));
            throw e;
        }
    }
}
