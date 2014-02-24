import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class DefaultTagEditor extends TagEditor {
    JTable tagTable;
    TableModel tagModel;

    public DefaultTagEditor(String namespace){
        // TODO: load from config
        setLayout(new BorderLayout());

        tagModel = new DefaultTagTableModel(this);

        tagTable = new JTable(tagModel);
        tagTable.getTableHeader().setReorderingAllowed(false);
        tagTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // TODO: use tag option manager, this is used instead as no configuration is available
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("see");
        comboBox.addItem("since");
        comboBox.addItem("deprecated");
        comboBox.addItem("throws");
        comboBox.addItem("exception");

        tagTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));

        JScrollPane scroller = new JScrollPane(tagTable,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroller);
    }


    public void setSelectedElement(){
    }


    public void refresh(){
        tagTable.updateUI();
    }
}