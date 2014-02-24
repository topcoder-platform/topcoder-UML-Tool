/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class utility for look and feel.
 *
 * @author enefem21
 * @version 1.0
 */
public class LookAndFeelUtil {

    /**
     * Sets look and feel.
     *
     * @param look
     *            the look
     * @throws IllegalArgumentException
     *             in case of the setting of look and feel is failed
     */
    static void setLookAndFeel(String look) {
        try {
            UIManager.setLookAndFeel(look);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class " + look + " is not found", e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Instantiation problem when setting look and feel", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Security problem when setting look and feel", e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new IllegalArgumentException("Unsupported look and feel is used", e);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Class " + look + " is not a look and feel class", e);
        }
    }
}
