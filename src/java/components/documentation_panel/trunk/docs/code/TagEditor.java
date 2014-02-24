import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class TagEditor extends JPanel{
    protected TagEditor(){
    }

    public void setSelectedElement(Object element){
    }

    protected void fireTagCreated(String tagName, String current){
        // would send to all listeners
        System.out.println("Tag [Create] #"+tagName+" is now: \"" + current + "\"\n");
    }

    protected void fireTagUpdated(String tagName, String previous, String current){
        // would send to all listeners
        System.out.println("Tag [Update] #"+tagName+" was: \"" + previous +
                           "\" and is now: \"" + current + "\"\n");
    }

    protected void fireTagDeleted(String tagName, String previous){
        // would send to all listeners
        System.out.println("Tag [Delete] #"+tagName+" was: \"" + previous + "\"\n");
    }

}