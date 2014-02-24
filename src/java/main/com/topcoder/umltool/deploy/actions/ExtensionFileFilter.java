/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * <p>
 * Extended file filter.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ExtensionFileFilter extends FileFilter {
    /**
     * <p>
     * Description string.
     * <p>
     */
    private final String description;

    /**
     * <p>
     * Extension string.
     * <p>
     */
    private final String extension;

    /**
     * <p>
     * Constructs an instance of ExtensionFileFilter.
     * </p>
     * @param description
     *            description string
     * @param extension
     *            extension string
     */
    public ExtensionFileFilter(String description, String extension) {
        this.description = description;
        this.extension = extension.toLowerCase();
    }

    /**
     * <p>
     * Gets the description string.
     * <p>
     * @return description string
     */
    public String getDescription() {
        return description + "(*." + extension + ")";
    }

    /**
     * <p>
     * Check if the given file is acceptable.
     * <p>
     * @param f
     *            file to check
     * @return true if the extension is acceptable, otherwise false
     */
    public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }
            String ext = getExtension(f);
            if (extension != null && extension.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Gets the extension.
     * <p>
     * @param f
     *            file to get extention
     * @return extension string
     */
    public String getExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }
}
