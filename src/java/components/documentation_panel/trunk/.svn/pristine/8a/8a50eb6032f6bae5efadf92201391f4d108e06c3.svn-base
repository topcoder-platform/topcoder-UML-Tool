import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class DocumentationEditor extends JPanel{
    protected DocumentationEditor(){
    }

    public void setSelectedElement(Object element){
    }

    protected void fireDocumentationCreated(String current){
        // would send to all listeners
        System.out.println("Doc [Create] is now: \"" + current + "\"\n");
    }

    protected void fireDocumentationUpdated(String previous, String current){
        // would send to all listeners
        System.out.println("Doc [Update] was: \"" + previous +
                           "\" and is now: \"" + current + "\"\n");
    }

    protected void fireDocumentationDeleted(String previous){
        // would send to all listeners
        System.out.println("Doc [Delete] was: \"" + previous + "\"\n");
    }

}