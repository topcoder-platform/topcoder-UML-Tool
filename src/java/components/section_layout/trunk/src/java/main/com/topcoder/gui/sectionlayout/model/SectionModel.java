/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.model;

/**
 * <p>
 * The model of the <code>Section</code> component.
 * It contains the state of the <code>Section</code>.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface SectionModel {

    /**
     * <p>
     * Getter of the floating property of this section model.
     * </p>
     *
     * @return True, the section is floating now
     */
    public boolean isFloating();

    /**
     * <p>
     * Setter of the floating property of this section model.
     * </p>
     *
     * @param floating
     *        True, the section is floating now
     */
    public void setFloating(boolean floating);

    /**
     * <p>
     * Getter of the expanded property of this section model.
     * </p>
     *
     * @return whether the section is expanded
     */
    public boolean isExpanded();

    /**
     * <p>
     * Setter of the expanded property of this section model.
     * </p>
     *
     * @param expanded
     *        whether the section is expanded
     */
    public void setExpanded(boolean expanded);

    /**
     * <p>
     * Getter of the title property of this section model.
     * </p>
     *
     * @return the title of the section
     */
    public String getTitle();

    /**
     * <p>
     * Setter of the title property of this section model.
     * </p>
     *
     * @param title
     *        the title of the section
     */
    public void setTitle(String title);

    /**
     * <p>
     * Getter of the vertical property of this section model.
     * </p>
     *
     * @return whether this section is vertical
     */
    public boolean isVertical();

    /**
     * <p>
     * Setter of the vertical property of this section model.
     * </p>
     *
     * @param vertical
     *        whether this section is vertical
     */
    public void setVertical(boolean vertical);

    /**
     * <p>
     * Getter of the expandToFill property of this section model.
     * </p>
     *
     * @return whether this section expands to fill the remaining empty space in the container
     */
    public boolean isExpandToFill();

    /**
     * <p>
     * Setter of the expandToFill property of this section model.
     * </p>
     *
     * @param expandToFill
     *        whether this section expands to fill the remaining empty space in the container
     */
    public void setExpandToFill(boolean expandToFill);
}
