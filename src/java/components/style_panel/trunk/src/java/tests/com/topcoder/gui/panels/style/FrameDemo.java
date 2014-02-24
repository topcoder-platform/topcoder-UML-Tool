/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

/**
 * <p>
 * This is a demo frame for using the functionalities provided by this swing component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FrameDemo extends JFrame {
    /**
     * <p>
     * The content panel of this frame.
     * </p>
     */
    private JPanel jContentPane;

    /**
     * <p>
     * The style panel to be used in this frame.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * The check box to be used in this frame.
     * </p>
     *
     * <p>
     * When checked, one GrahEdgeStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     */
    private JCheckBox graphEdgeCheckbox;

    /**
     * <p>
     * The check box to be used in this frame.
     * </p>
     *
     * <p>
     * When checked, one GrahNodeStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     */
    private JCheckBox graphNodeCheckbox;

    /**
     * <p>
     * The check box to be used in this frame.
     * </p>
     *
     * <p>
     * When checked, one PolylineStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     */
    private JCheckBox polylineCheckbox;

    /**
     * <p>
     * This is the default constructor.
     * </p>
     */
    public FrameDemo() {
        initialize();
    }

    /**
     * <p>
     * This method initializes the widgets in this frame.
     * </p>
     */
    public void initialize() {
        this.setContentPane(getJContentPane());
        this.setTitle("Frame Demo");
    }

    /**
     * <p>
     * This method initializes jContentPane.
     * </p>
     *
     * @return the content panel for this frame.
     */
    public JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BoxLayout(jContentPane, BoxLayout.Y_AXIS));

            StylePanel panel = getStylePanel();

            jContentPane.add(getGraphEdgeCheckbox());
            jContentPane.add(getGraphNodeCheckbox());
            jContentPane.add(getPolylineCheckbox());

            JButton button = new JButton("OK");
            button.addActionListener(new UpdateStylePanelAction());

            jContentPane.add(button);

            jContentPane.add(new JSeparator());

            jContentPane.add(panel);
        }
        return jContentPane;
    }

    /**
     * <p>
     * This method initializes StylePanel.
     * </p>
     *
     * @return the style panel.
     */
    public StylePanel getStylePanel() {
        if (stylePanel == null) {
            stylePanel = new StylePanel();
        }

        return stylePanel;
    }

    /**
     * <p>
     * This method initializes the check box for graph edge.
     * </p>
     *
     * <p>
     * When checked, one GrahEdgeStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     *
     * @return the check box for graph edge.
     */
    private JCheckBox getGraphEdgeCheckbox() {
        if (graphEdgeCheckbox == null) {
            graphEdgeCheckbox = new JCheckBox("GraphEdge");
        }

        return graphEdgeCheckbox;
    }

    /**
     * <p>
     * This method initializes the check box for graph node.
     * </p>
     *
     * <p>
     * When checked, one GrahNodeStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     *
     * @return the check box for graph node.
     */
    private JCheckBox getGraphNodeCheckbox() {
        if (graphNodeCheckbox == null) {
            graphNodeCheckbox = new JCheckBox("GraphNode");
        }

        return graphNodeCheckbox;
    }

    /**
     * <p>
     * This method initializes the check box for polyline.
     * </p>
     *
     * <p>
     * When checked, one PolylineStyleObjectAdapter instance will be created and set the
     * style panel if the user presses ok button.
     * </p>
     *
     * @return the check box for polyline.
     */
    private JCheckBox getPolylineCheckbox() {
        if (polylineCheckbox == null) {
            polylineCheckbox = new JCheckBox("Polyline");
        }

        return polylineCheckbox;
    }

    /**
     * <p>
     * This class implements the ActionListener and used for update the style object list
     * for style panel.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class UpdateStylePanelAction implements ActionListener {
        /**
         * <p>
         * This method handles the button-click event for ok button.
         * </p>
         *
         * <p>
         * When the button is clicked, the style object list of the style panel is updated.
         * </p>
         *
         * @param e an action event that indicates the button is clicked
         */
        public void actionPerformed(ActionEvent e) {
            List<StyleObject> styleObjects = new ArrayList<StyleObject>();
            if (getGraphNodeCheckbox().isSelected()) {
                styleObjects.add(new GraphNodeStyleObjectAdapter(new GraphNode()));
            }

            if (getGraphEdgeCheckbox().isSelected()) {
                styleObjects.add(new GraphEdgeStyleObjectAdapter(new GraphEdge()));
            }

            if (getPolylineCheckbox().isSelected()) {
                styleObjects.add(new PolylineStyleObjectAdapter(new Polyline()));
            }

            stylePanel.setStyleObjectList(styleObjects);
        }

    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        FrameDemo frameDemo = new FrameDemo();
        frameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDemo.pack();
        frameDemo.setVisible(true);
    }
}
