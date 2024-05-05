package model;

import java.util.List;

public class Row {
    int number;
    private List<ColumnData> columnData;

    public Row(int number, List<ColumnData> columnData) {
        this.number = number;
        this.columnData = columnData;
    }

    public int getNumber() {
        return number;
    }

    public List<ColumnData> getColumnData() {
        return columnData;
    }

    @Override
    public String toString() {
        return "Row{" +
                "columnData=" + columnData +
                '}';
    }
}
