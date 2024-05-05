package model;

public class ColumnData {

    Object data;
    Column column;

    public ColumnData(Object data, Column column) {
        this.data = data;
        this.column = column;
    }

    public Object getData() {
        return data;
    }

    public Column getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "ColumnData{" +
                "data=" + data +
                '}';
    }
}
