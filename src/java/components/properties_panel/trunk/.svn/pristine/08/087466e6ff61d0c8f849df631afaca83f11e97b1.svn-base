/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.topcoder.gui.panels.properties.propertypanel.AbstractPropertyPanel;
import com.topcoder.uml.model.core.ModelElement;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.Util;

/**
 * <p>
 * This abstract class provides a base class for all the <code>PropertyPanel</code> concrete
 * implementation that takes the form that provides a link to another <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * In addition to basic functionalities provided by <code>AbstractPropertyPanel</code>, this
 * class also provides a common GUI.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> with a <code>JLabel</code> that shows the property name and another
 * <code>JLabel</code> that acts as a link to the properties of the property value (which is a
 * <code>ModelElement</code>).
 * </p>
 *
 * <p>
 * Note, all the PropertyPanel#refreshPanel() concrete implementation <b>MUST</b> check that
 * PropertyPanel#isVisible() returns true before performing anything else.
 * If PropertyPanel#isVisible() returns false, return immediately.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe since the super class is mutable and it
 * contains mutable members.
 * </p>
 * <p>
 * V1.1 Change Note: the new label color is used as the prototype.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public abstract class AbstractLinkPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * This <code>JLabel</code> provides a link to the prescribed <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be changed afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JLabel labelLink;

    /**
     * <p>
     * The <code>ModelElement</code> linked by this instance.
     * </p>
     *+
     * <p>
     * Set by setter.
     * </p>
     *
     * <p>
     * May be null.
     * </p>
     */
    private ModelElement linkedModelElement;

    /**
     * <p>
     * Creates a new <code>AbstractLinkPropertyPanel</code>.
     * </p>
     * <p>
   * V1.1 Change Note: the new label color is used as the prototype.
   * </p>
   *
     * @param properties the supported PropertyKind
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @param labelText the property name to be displayed
     *
     * @throws IllegalArgumentException if any argument is null, or properties is empty or
     * contains null element, or labelText is empty string
     */
    protected AbstractLinkPropertyPanel(List<PropertyKind> properties, PropertiesPanel propertiesPanel,
        String labelText) {
        super(properties, propertiesPanel);

        Util.checkString(labelText, "labelText");

        JPanel panel = retrievePanel();

        labelLink = new JLabel(labelText);
        labelLink.setForeground(new Color(4, 87, 162));
        labelLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Creates an MouseListener instance and assign it to the label
        labelLink.addMouseListener(new MouseAdapter() {
            /**
             * <p>
             * Invoked when the mouse has been clicked on a component.
             * </p>
             *
             * <p>
             * When the <code>JLabel</code> is clicked, this method will be invoked
             * </p>
             *
             * @param e an event which indicates that a mouse action occurred in a component
             */
            public void mouseClicked(MouseEvent e) {
                execute();
            }
        });

        panel.add(labelLink);
    }

    /**
     * <p>
     * Executes the logic of the link panel.
     * </p>
     *
     * <p>
     * The logic is to configure the <code>PropertiesPanel</code> to the linked ModelElement and
     * notify PropertiesPanel's listeners that the configured <code>ModelElement</code> has changed.
     * </p>
     */
    public void execute() {
        if (isConfigured() && linkedModelElement != null) {
            getPropertiesPanel().configurePanel(linkedModelElement);
            getPropertiesPanel().fireSelectionChangeEvent(linkedModelElement);
        }
    }

    /**
     * <p>
     * Sets the <code>ModelElement</code> linked by this panel instance.
     * </p>
     *
     * @param linkedModelElement the ModelElement linked by this instance
     */
    protected void setLinkedModelElement(ModelElement linkedModelElement) {
        this.linkedModelElement = linkedModelElement;
        this.labelLink.setText(linkedModelElement == null ? "" : linkedModelElement.getName());
    }
}
