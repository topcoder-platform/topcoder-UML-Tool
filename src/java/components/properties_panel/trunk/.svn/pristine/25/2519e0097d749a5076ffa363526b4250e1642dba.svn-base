/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * This class provides wrapper over <code>Stereotype</code> class so that it can easily be
 * displayed in a <code>JList</code> while maintaining the ease of retrieval of the corresponding
 * <code>Stereotype</code> instance.
 * </p>
 *
 * <p>
 * Thread-safety: This class is immutable, therefore it is thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
class StereotypeItem {
    /**
     * <p>
     * The wrapped <code>Stereotype</code> instance.
     * </p>
     *
     * <p>
     * Set in the constructor and will not be changed afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Stereotype stereotype;

    /**
     * <p>
     * The text to be displayed in the <code>JList</code>.
     * </p>
     *
     * <p>
     * Set in the constructor and will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Creates a new <code>StereotypeItem</code> to wrap the given <code>Stereotype</code> instance.
     * </p>
     *
     * @param stereotype the stereotype to be wrapped
     * @throws IllegalArgumentException if stereotype is null
     */
    StereotypeItem(Stereotype stereotype) {
        Util.checkNull(stereotype, "stereotype");

        this.stereotype = stereotype;
        this.presentationName = stereotype.getName();
    }

    /**
     * <p>
     * Retrieves the wrapped <code>Stereotype</code> object.
     * </p>
     *
     * @return the wrapped <code>Stereotype</code> object
     */
    Stereotype getStereotype() {
        return stereotype;
    }

    /**
     * <p>
     * Returns the string representation of the wrapped <code>Stereotype</code>.
     * </p>
     *
     * @return the string representation of the wrapped <code>Stereotype</code>.
     */
    public String toString() {
        return presentationName;
    }
}
