import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;


public class DefaultTagTableModel extends AbstractTableModel {
    private static String[] COLUMN_NAMES     = {"Tag", "Documentation"};
    private static String   NEW_TAG_PROMPT   = "Insert new tag...";
    private static String   NEW_VALUE_PROMPT = "new value";

    private List<List<String>> values        = new ArrayList<List<String>>();
    private DefaultTagEditor   parent        = null;

    public DefaultTagTableModel(DefaultTagEditor parent){
        this.parent = parent;
    }

    public DefaultTagTableModel(DefaultTagEditor parent, String[] columnNames,
                                       String tagPrompt, String   valuePrompt){

        this.parent               = parent;

        if(columnNames != null)
            this.COLUMN_NAMES     = columnNames;
        if(tagPrompt   != null)
            this.NEW_TAG_PROMPT   = tagPrompt;
        if(valuePrompt != null)
            this.NEW_VALUE_PROMPT = valuePrompt;
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return values.size() + 1;
    }

    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    public Class getColumnClass(int col) {
        return COLUMN_NAMES[col].getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return row == getRowCount() - 1 ? col == 0  // only drop-down editable in last row
                                        : col == 1; // only documentation editable in non-last row
    }

    public Object getValueAt(int row, int col) {
        if(row == values.size())
            return col == 0 ? NEW_TAG_PROMPT : "";
        return values.get(row).get(col);
    }

    public void setValueAt(Object value, int row, int col) {
        String message = ((String)value).trim();

        // CREATE
        if(row == values.size()){
            ArrayList<String> newRow = new ArrayList<String>();
            newRow.add(message);
            newRow.add(NEW_VALUE_PROMPT);
            values.add(newRow);
            parent.fireTagCreated(message, NEW_VALUE_PROMPT);

        // DELETE
        } else if(message.length() == 0) {
            String tagName = values.get(row).get(0);
            String prev = values.get(row).get(1);
            values.remove(row);
            parent.fireTagDeleted(tagName, prev);

        // UPDATE
        } else {
            String prev = values.get(row).get(1);
            values.get(row).set(1, message);
            parent.fireTagUpdated(values.get(row).get(0), prev, message);
        }

        parent.refresh();
    }


    public void updateValues(List<List<String>> values){
        this.values = values;
    }
}
