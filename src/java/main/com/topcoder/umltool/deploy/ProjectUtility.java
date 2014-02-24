/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.io.File;

/**
 * <p>
 * Utilities of project related operations.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ProjectUtility {
    /**
     * <p>
     * Singleton instance.
     * </p>
     */
    private static ProjectUtility instance = null;

    /**
     * <p>
     * Represents the project file.
     * </p>
     */
    private File projectFile = null;

    /**
     * <p>
     * Private constructor.
     * </p>
     */
    private ProjectUtility() {
    }

    /**
     * <p>
     * Creates an instance of project utility.
     * </p>
     * @return the instance of project utility
     */
    public static ProjectUtility getInstance() {
        if (instance == null) {
            instance = new ProjectUtility();
        }
        return instance;
    }

    /**
     * <p>
     * Gets the project file.
     * </p>
     * @return the project file
     */
    public File getProjectFile() {
        return projectFile;
    }

    /**
     * <p>
     * Sets the project file.
     * </p>
     * @param projectFile
     *            the project file
     */
    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }
}
