/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * This class represents a TextElement and extends LeafElement. It can be used for the text part of a model
 * element.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class TextElement extends LeafElement {

    /**
     * <p>
     * Represents the text of this TextElement. Can be null. Can be empty. Default to null.
     * </p>
     */
    private String text;

    /**
     * <p>
     * Creates an instance of TextElement.
     * </p>
     */
    public TextElement() {
        super();
    }

    /**
     * <p>
     * Gets the text of this TextElement.
     * </p>
     *
     * @return the text of this TextElement
     */
    public String getText() {
        return text;
    }

    /**
     * <p>
     * Sets the text of this TextElement. Can be null. Can be empty.
     * </p>
     *
     * @param text the text of this TextElement
     */
    public void setText(String text) {
        this.text = text;
    }
}