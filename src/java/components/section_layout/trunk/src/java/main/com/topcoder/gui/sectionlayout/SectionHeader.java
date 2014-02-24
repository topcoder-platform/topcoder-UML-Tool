/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.UIManager;

import com.topcoder.gui.sectionlayout.model.SectionModel;
import com.topcoder.gui.sectionlayout.ui.SectionHeaderUI;

/**
 * <p>
 * The custom component represents the header of the <code>Section</code> control.
 * It use MVC pattern, with the model <code>SectionModel</code> and the View <code>SectionHeaderUI</code>.
 * It also listen to the <code>Section</code> to know if the properties is changed,
 * if the "expanded", "floating", "title" property changed, repaint the header.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It extends <code>JComponent</code> so it is not thread-safe as <code>JComponent</code> is not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class SectionHeader extends JComponent implements PropertyChangeListener {

    /**
     * <p>
     * Represents the model of this section.
     * It is initialized in constructor, and never changed later. Can't be null.
     * </p>
     */
    private final SectionModel model;

    /**
     * <p>
     * Represents the section of this section header
     * It is initialized in constructor, and never changed later. Can't be null.
     * </p>
     */
    private final Section section;

    /**
     * <p>
     * Constructs a SectionHeader instance with section and model instance.
     * </p>
     *
     * @param section
     *        the section this header belongs to
     * @param model
     *        the model in section
     * @throws IllegalArgumentException
     *         if any argument is null
     */
    public SectionHeader(Section section, SectionModel model) {
        Helper.checkNull(section, "section");
        Helper.checkNull(model, "model");

        this.model = model;
        this.section = section;
        // monitor these properties
        section.addPropertyChangeListener("expaned", this);
        section.addPropertyChangeListener("floating", this);
        section.addPropertyChangeListener("title", this);
        updateUI();
    }

    /**
     * <p>
     * Return the model of this section.
     * </p>
     *
     * @return the model of this section
     */
    public SectionModel getModel() {
        return model;
    }

    /**
     * <p>
     * Return the section of this header.
     * </p>
     *
     * @return the section of this header
     */
    public Section getSection() {
        return section;
    }

    /**
     * <p>
     * Resets the UI property to a value from the current look and feel.
     * </p>
     */
    public void updateUI() {
        setUI((SectionHeaderUI) UIManager.getUI(this));
        invalidate();
    }

    /**
     * <p>
     * Return the UI class ID.
     * </p>
     *
     * @return the UI class ID
     */
    public String getUIClassID() {
        return "SectionHeaderUI";
    }

    /**
     * <p>
     * This section header also implements ProepertyChangeListener interface
     * to monitor section on the property "expanded", "floating" and "title".
     * So this method is invoked when those properties are changed.
     * </p>
     *
     * @param event
     *        the property change event
     */
    public void propertyChange(PropertyChangeEvent event) {
        invalidate();
        repaint();
    }
}
