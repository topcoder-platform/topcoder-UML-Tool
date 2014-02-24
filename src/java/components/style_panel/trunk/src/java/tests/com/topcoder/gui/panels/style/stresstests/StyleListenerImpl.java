/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.stresstests;

import java.util.ArrayList;
import java.util.List;
import com.topcoder.gui.panels.style.StyleListener;
import com.topcoder.gui.panels.style.StyleEvent;

/**
 * <p>
 * This class implements StyleListener interface.
 * It is only used for testing.
 * </p>
 *
 * @author cmax
 * @version 1.0
 */
public class StyleListenerImpl implements StyleListener {
    /**
     * <p>
     * Represents the style event list that received from the style panel.
     * </p>
     */
    private List<StyleEvent> styleEvents = new ArrayList<StyleEvent>();

    /**
     * <p>
     * Implements the styleChanged(StyleEvent) method in StyleListener interface.
     * </p>
     *
     * <p>
     * The StyleEvent instance is added to a list.
     * </p>
     *
     * @param styleEvent the style event
     */
    public void styleChanged(StyleEvent styleEvent) {
        this.styleEvents.add(styleEvent);
    }

    /**
     * <p>
     * Gets all the style event list that received from the style panel.
     * </p>
     *
     * @return all the style event list that received from the style panel.
     */
    public List<StyleEvent> getStyleEvents() {
        return styleEvents;
    }

    /**
     * <p>
     * Clears the style event list.
     * </p>
     */
    public void clear() {
        this.styleEvents.clear();
    }
}
