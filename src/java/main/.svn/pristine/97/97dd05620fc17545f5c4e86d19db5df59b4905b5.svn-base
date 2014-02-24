/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Point;

/**
 * <p>
 * JPopupMenu with overrided show function. Holding point where popupmenu was onvoked on component.
 * </p>
 *
 * @author kanarinios
 * @version 1.0
 */
public class SpecialJPopupMenu extends JPopupMenu {
    /**
     * <p>
     * Holds where popupmenu event was invoked
     * </p>
     */
    private Point location = null;

    /**
     * <p>
     * Point where popupmenu click was invoked on source component
     * </p>
     *
     * @return location where popupmenu where show
     */
    public Point getLocationOnComponent() {
        return location;
    }

    /**
     * <p>
     * This overrides the show to store location on invoker before showing popupmenu.
     * </p>
     *
     * @param invoker
     *            component where show popupmenu
     * @param x
     *            x position on invoker where show popupmenu
     * @param y
     *            y position on invoker where show popupmenu
     */
    public void show(Component invoker, int x, int y) {
        location = new Point(x, y);
        super.show(invoker, x, y);
    }
}
