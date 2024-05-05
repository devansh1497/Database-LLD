
import enums.ColumnType;
import enums.FilterOperator;
import exceptions.ConstraintViolationException;
import model.Column;
import validators.UniqueConstraint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ConstraintViolationException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Database db = Database.getInstance();
        db.createDatabase("test");
        db.chooseDb("test");


        List<Column> cols = new ArrayList<>();
        Column c1 = new Column("id", ColumnType.INTEGER, Arrays.asList(new UniqueConstraint()));
        Column c2 = new Column("name", ColumnType.STRING, new ArrayList<>());
        cols.add(c1);
        cols.add(c2);
        db.createTable("student", cols);

        List<List<Object>> data = new ArrayList<>();
        List<Object> d1 = new ArrayList<>();
        d1.add(102);
        d1.add("Devansh");

        List<Object> d2 = new ArrayList<>();
        d2.add(10);
        d2.add("Bunny");

        data.add(d1);
        data.add(d2);

        db.insert("student", data);

        db.printTable("student", c2, "Devansh", FilterOperator.NOT_EQUAL);


    }
}