import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PanelDriver implements ActionListener{
    JPanel mainPane = new JPanel();
    DocumentationPanel bottom;

    //Specify the look and feel to use.  Valid values:
    //null (use the default), "Metal", "System", "Motif", "GTK+"
    final static String LOOKANDFEEL = "System";

    public JButton makeButton(String name){
        JButton ret = new JButton(name);
        ret.setActionCommand(name);
        ret.addActionListener(this);
        return ret;
    }

    public PanelDriver(){
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));

        JPanel top = new JPanel();
        top.add(makeButton("Hide Tag Panel"));
        top.add(makeButton("Show Tag Panel"));
        top.add(makeButton("Hide whole panel"));
        top.add(makeButton("Show whole panel"));



        bottom = new DocumentationPanel("configstuff");

        mainPane.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, top, bottom));
        mainPane.add(Box.createGlue());
    }

    public void actionPerformed(ActionEvent e) {
        String type = e.getActionCommand();
        if ("Hide Tag Panel".equals(type)) {
            bottom.showTagPanel(false);
        } else if("Show Tag Panel".equals(type)){
            bottom.showTagPanel(true);
        } else if("Hide whole panel".equals(type)){
            bottom.showPane(false);
        } else if("Show whole panel".equals(type)){
            bottom.showPane(true);
        }
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        initLookAndFeel();

        //Create and set up the window.
        JFrame frame = new JFrame("Documentation Panel Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        PanelDriver driver = new PanelDriver();
        driver.mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(driver.mainPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static void initLookAndFeel() {
        String lookAndFeel = null;

        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                                   + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}