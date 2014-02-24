/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * <p>
 * This class extends AbstractColorChooserPanel abstract class.
 * </p>
 *
 * <p>
 * This class is responsible for creating a color selector panel (The panel that will be
 * displayed in the JColorChooser).
 * This panel will replace the default color chooser provided by JColorChooser.
 * </p>
 *
 * <p>
 * Note, The color string displayed in the color text field is in the form of #RRGGBB.
 * </p>
 *
 * <p>
 * The instance of this class' scope is kept as long as the application is shown.
 * </p>
 *
 * <p>
 * Thread safety: this class is not thread safe. But since this will only be accessed
 * by EDT and if it only applied to one JColorChooser, there will be no thread problem.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class ColorChooserPanel extends AbstractColorChooserPanel {
    /**
     * <p>
     * Represents the width percent of the color button.
     * </p>
     *
     * <p>
     * Note, the sum of COLOR_BUTTON_PERCENT and COLOR_TEXT_FIELD_PERCENT should less than 1.
     * </p>
     */
    private static final double COLOR_BUTTON_PERCENT = 0.6;

    /**
     * <p>
     * Represents the width percent of the color text field.
     * </p>
     *
     * <p>
     * Note, the sum of COLOR_BUTTON_PERCENT and COLOR_TEXT_FIELD_PERCENT should less than 1.
     * </p>
     */
    private static final double COLOR_TEXT_FIELD_PERCENT = 0.3;

    /**
     * <p>
     * Represents the color palettes used to choose the color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private ColorPalettePanel palette;

    // added
    /**
     * <p>
     * Represents the frequently used color palettes used to choose the color.
     * </p>
     */
    private CommonColorPanel commonPalette;

    /**
     * <p>
     * Represents the color button that shows the most recent color selected by its background color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JButton colorButton;

    /**
     * <p>
     * Represents the color text field that shows the most recent color selected in form of #RRGGBB.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JTextField colorTextField;

    /**
     * <p>
     * Represents the JColorChooser where this panel located.
     * </p>
     *
     * <p>
     * This variable is set in installChooserPanel() method and reset in uninstallChooserPanel()
     * method.
     * </p>
     */
    private JColorChooser colorChooser;

    /**
     * <p>
     * Represents the JColorChooser where this panel located.
     * </p>
     *
     * <p>
     * This variable is set in buildChooser() method and reset in uninstallChooserPanel()
     * method.
     * </p>
     */
    private MainSwatchListener mainSwatchListener;

    // added
    /**
     * <p>
     * Represents the mouse listener for the common color panel.
     * </p>
     */
    private CommonSwatchListener commonSwatchListener;

    /**
     * <p>
     * Represents the namespace to config the color chooser panel.
     * </p>
     *
     * <p>
     * It may be null if the default constructor is used.
     * </p>
     *
     * <p>
     * Is immutable, can be null but can not be empty string.
     * </p>
     */
    private final String namespace;

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public ColorChooserPanel() {
        namespace = null;
    }

    /**
     * <p>
     * Constructs a ColorChooserPanel with namespace specified.
     * </p>
     *
     * <p>
     * Note, the namespace is mainly used to construct ColorPalettePanel instance with namespace.
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if namespace is null or empty
     */
    public ColorChooserPanel(String namespace) {
        Util.checkString(namespace, "namespace");

        this.namespace = namespace;
    }

    /**
     * <p>
     * Returns &quot;ColorChooserPanel&quot; as the display name.
     * </p>
     *
     * @return "ColorChooserPanel" as the display name
     */
    public String getDisplayName() {
        return "ColorChooserPanel";
    }

    /**
     * <p>
     * Returns null.
     * </p>
     *
     * @return null
     */
    public Icon getSmallDisplayIcon() {
        return null;
    }

    /**
     * <p>
     * Returns null.
     * </p>
     *
     * @return null.
     */
    public Icon getLargeDisplayIcon() {
        return null;
    }

    /**
     * <p>
     * Install the panel to JColorChooser.
     * </p>
     *
     * <p>
     * A change listener will be added to the ColorSelectoModel of the color chooser,
     * so once the color is updated, the color button and color text filed will
     * be update as well
     * </p>
     *
     * @param enclosingChooser the panel to be added
     *
     * @throws RuntimeException if the chooser panel has already been installed
     */
    public void installChooserPanel(JColorChooser enclosingChooser) {
        super.installChooserPanel(enclosingChooser);
        colorChooser = enclosingChooser;
        if (colorChooser != null && colorChooser.getColorModel() != null) {
            // install the change listener for the ColorSelectoModel of the color chooser,
            // so once the color is updated, the color button and color text filed will
            // be update as well
            colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
                /**
                 * <p>
                 * Handles the state changed event.
                 * </p>
                 *
                 * <p>
                 * When the color of the color chooser is changed, this event will be sent
                 * out and this method updates the color button and color text field
                 * according to the new color.
                 * </p>
                 *
                 * @param e an event that is used to notify interested parties that state has
                 * changed in the event source
                 */
                public void stateChanged(ChangeEvent e) {
                    getColorTextField().setText(Util.convertColor(colorChooser.getColor()));
                    getColorButton().setBackground(colorChooser.getColor());
                }
            });
        }
    }

    /**
     * <p>
     * Prepare the content of the color chooser.
     * </p>
     *
     * <p>
     * Mouse listener (for press event) and mouse motion listener (for move event) will be added to the palette
     * for updating the color button and color text field.
     * </p>
     *
     * @throws StylePanelConfigurationException if fails to create palette field with namespace specified
     */
    public void buildChooser() {
        JPanel superHolder = new JPanel(new BorderLayout());

        if (this.namespace != null) {
            palette = new ColorPalettePanel(namespace);
        } else {
            palette = new ColorPalettePanel();
        }

        palette.getAccessibleContext().setAccessibleName(getDisplayName());

        // Add the mouse listener (for press event) and mouse motion listener (for move event)
        mainSwatchListener = new MainSwatchListener();
        palette.addMouseListener(mainSwatchListener);
        palette.addMouseMotionListener(mainSwatchListener);

        // Initialize the recent pallete and add mouse listener and mouse motion listener
        commonPalette = new CommonColorPanel();
        commonSwatchListener = new CommonSwatchListener();
        commonPalette.addMouseListener(commonSwatchListener);
        commonPalette.addMouseMotionListener(commonSwatchListener);

        // add the palette as the CENTER in the BorderLayout
        JPanel mainHolder = new JPanel(new BorderLayout());
        Border border = new CompoundBorder(new LineBorder(Color.black), new LineBorder(Color.white));
        mainHolder.setBorder(border);
        mainHolder.add(palette, BorderLayout.CENTER);

        // Add the palette as the CENTER in the BorderLayout
        JPanel recentHolder = new JPanel(new BorderLayout());
        Border recentBorder = new CompoundBorder(new LineBorder(Color.black), new LineBorder(Color.white));
        recentHolder.setBorder(recentBorder);
        recentHolder.add(commonPalette, BorderLayout.CENTER);

        JPanel northPanel = new JPanel(new FlowLayout());

        JButton button = getColorButton();
        JTextField textField = getColorTextField();

        // size for palette
        Dimension size = palette.getPreferredSize();

        // original size for color button
        Dimension buttonSize = button.getPreferredSize();

        // original size for color text field
        Dimension textFieldSize = textField.getPreferredSize();

        // get the height of text field
        double height = textFieldSize.getHeight();

        // calculate the width for the color button
        double buttonWidth = Math.max(size.getWidth() * COLOR_BUTTON_PERCENT, buttonSize.getWidth());

        // calculate the width for the color text field
        double textFieldWidth = Math.max(size.getWidth() * COLOR_TEXT_FIELD_PERCENT, textFieldSize.getWidth());

        // update the button size according to the palette and text field
        button.setPreferredSize(createDimension(buttonWidth, height));

        // update the text field size according to the palette
        textField.setPreferredSize(createDimension(textFieldWidth, height));

        northPanel.add(button);
        northPanel.add(textField);

        superHolder.add(northPanel, BorderLayout.NORTH);
        superHolder.add(recentHolder, BorderLayout.CENTER);
        superHolder.add(mainHolder, BorderLayout.SOUTH);

        add(superHolder);
    }

    /**
     * <p>
     * Uninstall the panel to JColorChooser.
     * </p>
     *
     * <p>
     * The mouse listener (for press event) and mouse motion listener (for move event) will be removed from the palette.
     * </p>
     *
     * <p>
     * Note, all the components for this panel will be removed as well.
     * </p>
     *
     * @param enclosingChooser the panel to be removed
     */
    public void uninstallChooserPanel(JColorChooser enclosingChooser) {
        super.uninstallChooserPanel(enclosingChooser);

        colorChooser = null;
        palette.removeMouseListener(mainSwatchListener);
        palette.removeMouseMotionListener(mainSwatchListener);
        palette = null;
        mainSwatchListener = null;

        commonPalette.removeMouseListener(commonSwatchListener);
        commonPalette.removeMouseMotionListener(commonSwatchListener);
        commonPalette = null;
        commonSwatchListener = null;

        removeAll();
    }

    /**
     * <p>
     * This method implement the abstract method updateChooser() in AbstractColorChooserPanel.
     * </p>
     *
     * <p>
     * Does nothing.
     * </p>
     */
    public void updateChooser() {
        // empty
    }

    /**
     * <p>
     * Returns the color Button.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and the returned.
     * </p>
     *
     * @return the color button.
     */
    private JButton getColorButton() {
        if (colorButton == null) {
            colorButton = new JButton();
            colorButton.setBackground(getColorFromModel());
        }

        return colorButton;
    }

    /**
     * <p>
     * Returns the color text field.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and the returned.
     * </p>
     *
     * @return the color text field.
     */
    private JTextField getColorTextField() {
        if (colorTextField == null) {
            colorTextField = new JTextField();
            colorTextField.setEditable(false);
            colorTextField.setText(Util.convertColor(getColorFromModel()));
        }

        return colorTextField;
    }

    /**
     * <p>
     * This is the listener for color chooser panel.
     * </p>
     *
     * <p>
     * It implements MouseMotionListener and extends MouseAdapter.
     * </p>
     *
     * <p>
     * Basically, there will be two mouse actions:
     * <ul>
     * <li>mouse pressed - which will set the color model to the color that is selected, and close the
     * frame where the panel is located</li>
     * <li>mouse moved - which will set the color button's background and color text field's text</li>
     * </ul>
     *
     * <p>
     * Thread Safety : The super class is mutable and so this class is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class MainSwatchListener extends MouseAdapter implements MouseMotionListener {
        /**
         * <p>
         * Handles the case when mouse pressed event detected.
         * </p>
         *
         * <p>
         * The color for the color chooser will be set and the color chooser frame will be
         * closed in this method.
         * </p>
         *
         * @param e An event which indicates that a mouse action occurred in a component.
         */
        public void mousePressed(MouseEvent e) {
            Color color = palette.getColorForLocation(e.getX(), e.getY());
            getColorSelectionModel().setSelectedColor(color);

            // hide the color chooser frame
            Container container = ColorChooserPanel.this.getTopLevelAncestor();
            if (container != null) {
                container.setVisible(false);
            }
        }

        /**
         * <p>
         * Handles the case when mouse moved event detected.
         * </p>
         *
         * <p>
         * The color button and color text field will be updated in this method.
         * </p>
         *
         * @param e An event which indicates that a mouse action occurred in a component.
         */
        public void mouseMoved(MouseEvent e) {
            Color color = palette.getColorForLocation(e.getX(), e.getY());
            getColorTextField().setText(Util.convertColor(color));
            getColorButton().setBackground(color);
        }

        /**
         * <p>
         * Handles the case when mouse dragged event detected.
         * </p>
         *
         * <p>
         * It does nothing in the current implementation.
         * </p>
         *
         * @param e An event which indicates that a mouse action occurred in a component.
         */
        public void mouseDragged(MouseEvent e) {
            // empty
        }
    }

    // class added
    /**
     * <p>
     * This is the listener for common color chooser panel.
     * </p>
     * <p>
     * It implements MouseMotionListener and extends MouseAdapter.
     * </p>
     * <p>
     * Basically, there will be two mouse actions:
     * <ul>
     * <li>mouse pressed - which will set the color model to the color that is selected, and close the frame where the
     * panel is located</li>
     * <li>mouse moved - which will set the color button's background and color text field's text</li>
     * </ul>
     * <p>
     * Thread Safety : The super class is mutable and so this class is not thread safe.
     * </p>
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class CommonSwatchListener extends MouseAdapter implements MouseMotionListener {
        /**
         * <p>
         * Handles the case when mouse pressed event detected.
         * </p>
         * <p>
         * The color for the color chooser will be set and the color chooser frame will be closed in this method.
         * </p>
         * @param e
         *            An event which indicates that a mouse action occurred in a component.
         */
        public void mousePressed(MouseEvent e) {
            Color color = commonPalette.getColorForLocation(e.getX(), e.getY());
            getColorSelectionModel().setSelectedColor(color);

            // hide the color chooser frame
            Container container = ColorChooserPanel.this.getTopLevelAncestor();
            if (container != null) {
                container.setVisible(false);
            }
        }

        /**
         * <p>
         * Handles the case when mouse moved event detected.
         * </p>
         * <p>
         * The color button and color text field will be updated in this method.
         * </p>
         * @param e
         *            An event which indicates that a mouse action occurred in a component.
         */
        public void mouseMoved(MouseEvent e) {
            Color color = commonPalette.getColorForLocation(e.getX(), e.getY());
            if (color != null) {
                getColorTextField().setText(Util.convertColor(color));
                getColorButton().setBackground(color);
            }
        }

        /**
         * <p>
         * Handles the case when mouse dragged event detected.
         * </p>
         * <p>
         * It does nothing in the current implementation.
         * </p>
         * @param e
         *            An event which indicates that a mouse action occurred in a component.
         */
        public void mouseDragged(MouseEvent e) {
            // empty
        }
    }

    /**
     * <p>
     * Creates a Dimension with width and height given.
     * </p>
     *
     * @param width the width of the dimension
     * @param height the height of the dimension
     *
     * @return a Dimension instance with the given width and height
     */
    private Dimension createDimension(double width, double height) {
        return new Dimension((int) width, (int) height);
    }
}
