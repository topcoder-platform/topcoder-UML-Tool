/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 * <p>
 * A runnable demo for this side menu component.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
public class Demo {
    /**
     * An empty/private ctor.
     */
    private Demo() {

    }

    /**
     * This main method show a frame with all of examples.
     *
     * @param args
     *            the main argument(not used)
     */
    public static void main(String[] args) {
        // the show example frame
        final JFrame frame = new JFrame("Side Menu Demo");

        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        final JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        final JPanel rightContentPanel = new JPanel();
        // set content
        rightContentPanel.setBackground(Color.CYAN);
        rightContentPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        rightPanel.add(rightContentPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        JComponent content = new JPanel();
        // set content
        for (int i = 0; i < 10; i++) {
            content.add(new JLabel("I'am the content"));
        }
        content.setBackground(Color.DARK_GRAY);
        content.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        // /////////////////////set side menu panel////////////////
        String title = "Side Menu";
        Icon expandIcon = TestHelper.EXPAND_ICON;
        Icon collapseIcon = TestHelper.COLLAPSE_ICON;
        Icon pinIcon = TestHelper.PIN_ICON;
        final SideMenuPanel sideMenuPanel = new SideMenuPanel(title, content, expandIcon,
                collapseIcon, pinIcon);
        SideMenuModel model = sideMenuPanel.getSideMenuModel();
        sideMenuPanel.getCollapsedComponent()
                .setBorder(
                        BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                                new EtchedBorder()));
        ((DefaultCollapsedSideMenuPanel) sideMenuPanel.getCollapsedComponent()).getTextLabel()
                .setBorder(
                        BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                                new EtchedBorder()));
        ((DefaultCollapsedSideMenuPanel) sideMenuPanel.getCollapsedComponent())
                .setClickToExpand(true);
        sideMenuPanel.getExpandedComponent()
                .setBorder(
                        BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                                new EtchedBorder()));
         sideMenuPanel.setAbsoluteWidth(300);

        // ////////////set CONTROL panel////////
        JPanel controlPanel = new JPanel();
        setControlPanel(sideMenuPanel, controlPanel, contentPane);

        // add component
        contentPane.add(rightPanel, new GridBagConstraints(1, 0, 1, 1, 2, 2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(sideMenuPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(controlPanel, new GridBagConstraints(0, 1, 2, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        // add window listener
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // pack and show frame
        frame.pack();
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    /**
     * This method set control panel.
     *
     * @param sideMenuPanel
     *            the sideMenu panel
     * @param controlPanel
     *            the control panel
     * @param contentPane
     *            the content panel
     */
    private static void setControlPanel(final SideMenuPanel sideMenuPanel, JPanel controlPanel,
            final Container contentPane) {
        // set expand button
        final JButton expandButton = new JButton("expand:"
                + sideMenuPanel.getSideMenuModel().isExpanded());
        expandButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sideMenuPanel.setExpanded(!sideMenuPanel.isExpanded());
                expandButton.setText("expand:" + sideMenuPanel.isExpanded());
            }
        });
        controlPanel.add(expandButton);

        // set floating button
        final JButton floatingButton = new JButton("floating:" + sideMenuPanel.isFloating());
        floatingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sideMenuPanel.setFloating(!sideMenuPanel.isFloating());
                floatingButton.setText("floating:" + sideMenuPanel.isFloating());
            }
        });
        controlPanel.add(floatingButton);

        // set width text field and button
        final JTextField tf = new JTextField("" + sideMenuPanel.getAbsoluteWidth());
        controlPanel.add(tf);
        final JButton widthButton = new JButton("width");
        widthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sideMenuPanel.setAbsoluteWidth(new Integer(tf.getText()));
                    widthButton.setText("" + sideMenuPanel.getAbsoluteWidth());
                } catch (NumberFormatException nfe) {
                    // ignore
                }
            }
        });
        controlPanel.add(widthButton);

        // set title text field and button
        final JTextField titleFiled = new JTextField("title:" + sideMenuPanel.getTitle());
        controlPanel.add(titleFiled);
        final JButton titleButton = new JButton("title");
        titleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sideMenuPanel.setTitle(titleFiled.getText());
                titleButton.setText("title:" + sideMenuPanel.getTitle());
            }
        });
        controlPanel.add(titleButton);

        // set new model value field and button
        final JCheckBox toggle = new JCheckBox("set null");
        controlPanel.add(toggle);
        final JButton newModelButton1 = new JButton("new model1");
        newModelButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultSideMenuModel model = null;
                if (!toggle.isSelected()) {
                    model = new DefaultSideMenuModel("new Model1");
                    model.setExpanded(true);
                    model.setFloating(false);
                    model.setAbsoluteWidth(777);
                    model.addPropertyChangeListener(new PropertyChangeListener() {
                        public void propertyChange(PropertyChangeEvent evt) {
                            System.out.println("new Model, old:" + evt.getOldValue() + " new:"
                                    + evt.getNewValue() + " property:" + evt.getPropertyName());
                            contentPane.validate();
                        }
                    });
                }
                sideMenuPanel.setSideMenuModel(model);
            }
        });
        controlPanel.add(newModelButton1);

        // add listener to make sure the main panel is relayout
        sideMenuPanel.getSideMenuModel().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("old:" + evt.getOldValue() + " new:" + evt.getNewValue()
                        + " property:" + evt.getPropertyName());
                expandButton.setText("expand:" + sideMenuPanel.isExpanded());
                floatingButton.setText("floating:" + sideMenuPanel.isFloating());
                widthButton.setText("" + sideMenuPanel.getAbsoluteWidth());
                titleButton.setText("title:" + sideMenuPanel.getTitle());
                contentPane.validate();
            }
        });
    }
}
