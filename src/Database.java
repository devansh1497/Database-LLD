import enums.FilterOperator;
import exceptions.ConstraintViolationException;
import filter.Filter;
import filter.OperatorFunctionFactory;
import model.Column;
import model.Row;
import model.Table;

import java.util.*;

public class Database {

    private static Database INSTANCE;

    private Database() {}

    public static Database getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    Map<String, List<Table>> database = new HashMap<>();
    List<Table> tables;

    public void chooseDb(String db) {
        if(!database.containsKey(db)) {
            throw new IllegalArgumentException("INvalid db");
        }
        tables = database.get(db);
    }

    public void createDatabase(String name) {
        if(database.containsKey(name)) {
            throw new IllegalArgumentException("DB already exists");
        }
        database.put(name, new ArrayList<>());
    }

    public void createTable( String name, List<Column> columns) {
        //Add validation
        tables.add(new Table(name, columns));

    }

    public int insert(String tableName, List<List<Object>> data) throws ConstraintViolationException {
        Table table = tables.stream().filter(t -> t.getName().equals(tableName)).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Invalid table"));
        table.insert(data);
        return data.size();
    }

    public void printTable(String name) {
        Table table = tables.stream().filter(t -> t.getName().equals(name)).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Invalid table"));
        table.getColumns().forEach(System.out::print);
        System.out.println();
        table.getRows().stream().map(Row::getColumnData).forEach(System.out::println);
    }

    public List<Row> getData(String name ) {
        Table table = tables.stream().filter(t -> t.getName().equals(name)).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Invalid table"));
        return table.getRows();
    }

    public void printTable(String name, Column column, Object target, FilterOperator operator) {
        Table table = tables.stream().filter(t -> t.getName().equals(name)).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Invalid table"));
        List<Row> data = table.getRows();
        Filter filter = new Filter(column, target);
        filter.filter(data, OperatorFunctionFactory.get(operator)).forEach(System.out::println);
    }

}
