/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.model;

import com.topcoder.gui.sectionlayout.Helper;

/**
 * <p>
 * The default implementation of the <code>SectionModel</code> in this component.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultSectionModel implements SectionModel {

    /**
     * <p>
     * Whether this section is floating. Default to false.
     * Accessed/Set in Getter/Setter.
     * </p>
     */
    private boolean floating = false;

    /**
     * <p>
     * Whether the section is expanded. Default to true.
     * Accessed/Set in Getter/Setter.
     * </p>
     */
    private boolean expanded = true;

    /**
     * <p>
     * The title of the section. Default to empty string, can't be null, can be empty.
     * Accessed/Set in Getter/Setter.
     * </p>
     */
    private String title = "";

    /**
     * <p>
     * Whether this section is vertical. Default to true.
     * Accessed/Set in Getter/Setter.
     * </p>
     */
    private boolean vertical = true;

    /**
     * <p>
     * Whether this section expands to fill the remaining empty space in the container. Default to false.
     * Accessed/Set in Getter/Setter.
     * </p>
     */
    private boolean expandToFill = false;

    /**
     * <p>
     * Constructs a DefaultSectionModel instance.
     * </p>
     */
    public DefaultSectionModel() {
        // empty
    }

    /**
     * <p>
     * Getter of the floating property of this section model.
     * Default to false.
     * </p>
     *
     * @return True, the section is floating now
     */
    public boolean isFloating() {
        return floating;
    }

    /**
     * <p>
     * Setter of the floating property of this section model.
     * </p>
     *
     * @param floating
     *        True, the section is floating now
     */
    public void setFloating(boolean floating) {
        this.floating = floating;
    }

    /**
     * <p>
     * Getter of the expanded property of this section model.
     * Default to true.
     * </p>
     *
     * @return whether the section is expanded
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     * <p>
     * Setter of the expanded property of this section model.
     * </p>
     *
     * @param expanded
     *        whether the section is expanded
     */
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    /**
     * <p>
     * Getter of the title property of this section model.
     * Default to empty string.
     * </p>
     *
     * @return the title of the section
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>
     * Setter of the title property of this section model.
     * </p>
     *
     * @param title
     *        the title of the section
     * @throws IllegalArgumentException
     *         if the title is null
     */
    public void setTitle(String title) {
        Helper.checkNull(title, "title");
        this.title = title;
    }

    /**
     * <p>
     * Getter of the vertical property of this section model.
     * Default to true.
     * </p>
     *
     * @return whether this section is vertical
     */
    public boolean isVertical() {
        return this.vertical;
    }

    /**
     * <p>
     * Setter of the vertical property of this section model.
     * </p>
     *
     * @param vertical
     *        whether this section is vertical
     */
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    /**
     * <p>
     * Getter of the expandToFill property of this section model.
     * Default to false.
     * </p>
     *
     * @return whether this section expands to fill the remaining empty space in the container
     */
    public boolean isExpandToFill() {
        return expandToFill;
    }

    /**
     * <p>
     * Setter of the expandToFill property of this section model.
     * </p>
     *
     * @param expandToFill
     *        whether this section expands to fill the remaining empty space in the container
     */
    public void setExpandToFill(boolean expandToFill) {
        this.expandToFill = expandToFill;
    }
}
