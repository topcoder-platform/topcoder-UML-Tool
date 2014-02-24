import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DocumentationPanel extends JPanel{
    private DocumentationEditor docEditor;
    private TagEditor           tagEditor;
    private int lastDividerLocation = -1;

    public DocumentationPanel(String namespace){
        // TODO: load the Document editor and tab panel from config

        setLayout(new BorderLayout());

        docEditor = new DefaultDocumentationEditor(namespace);
        tagEditor = new DefaultTagEditor(namespace);

        // add the two sections
        JSplitPane divider = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                                                        docEditor, tagEditor);
        divider.setResizeWeight(0.5);
        add(divider);
    }


    void showTagPanel(boolean show){
        tagEditor.setVisible(show);

        JSplitPane pane = (JSplitPane)getComponent(0);
        if(show){
            if(lastDividerLocation != -1){
                pane.setDividerLocation(lastDividerLocation);
                lastDividerLocation = -1;
            }
        } else {
            if(lastDividerLocation == -1){
                lastDividerLocation = pane.getDividerLocation();
            }
        }

        pane.updateUI();
        docEditor.updateUI();
        tagEditor.updateUI();
    }

    void showPane(boolean show){
        JSplitPane pane = (JSplitPane)getComponent(0);

        if(show){
            pane.setLeftComponent(docEditor);
            pane.setRightComponent(tagEditor);
        } else {
            JPanel blank = new JPanel();
            pane.setLeftComponent(blank);
            pane.setRightComponent(blank);
        }

        pane.updateUI();
        docEditor.updateUI();
        tagEditor.updateUI();
    }
}