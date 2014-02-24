import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DefaultDocumentationEditor extends DocumentationEditor implements FocusListener{
    JTextArea content;
    String previousDocumentation = "";

    public DefaultDocumentationEditor(String namespace){
        setLayout(new BorderLayout());

        content = new JTextArea();
        content.setLineWrap(true);
        content.setWrapStyleWord(true);
        content.addFocusListener(this);

        JScrollPane scroller = new JScrollPane(content,
                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scroller);
    }

    public void setSelectedElement(Object element){
        // instead it should be loaded from the element
        previousDocumentation = "";
    }


    public void focusGained(FocusEvent e){
    }

    public void focusLost(FocusEvent e){
        if(e.getComponent() == content && e.getID() == FocusEvent.FOCUS_LOST){

            String previous = previousDocumentation;
            String current = content.getText();

            previous = previous.trim();
            current = current.trim();

            if(previous.equals(current))
                {}
            else if(previous.equals(""))
                fireDocumentationCreated(current);
            else if(current.equals(""))
                fireDocumentationDeleted(previous);
            else
                fireDocumentationUpdated(previous, current);

            // this would not be set directly on the element, though is simulated here.
            previousDocumentation = current;
        }
    }
}