/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import org.xml.sax.SAXException;


/**
 * <p>
 * This exception extends SAXException and is thrown when the version of parsed ZUML file is not acceptable.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This exception is immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class UnsupportedVersionException extends SAXException {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = 6799551853062268926L;

    /**
    * <p>
    * The current version in zuml file, which is not acceptable. It is initialized in the
    * constructor and never be changed. It can be null or empty. It can be retrieved by
    * the getter.
    * </p>
    */
    private final String currentVersion;

    /**
     * <p>
     * The acceptable versions of zuml file this component can handle. It is initialized
     * in the constructor and never be changed. It can be null or empty, the element can
     * be null or empty. It can be retrieved by the getter.
     * </p>
     */
    private final String[] acceptableVersions;

    /**
     * <p
     * >Construct the exception with current version of zuml file and the configured acceptable versions.
     * </p>
     *
     * @param currentVersion the current version of the zuml file
     * @param acceptableVersions the acceptable versions
     */
    public UnsupportedVersionException(String currentVersion,
        String[] acceptableVersions) {
        super("The version " + currentVersion + " is not acceptable");

        this.currentVersion = currentVersion;
        this.acceptableVersions = acceptableVersions;
    }

    /**
     * <p>Get the current version of the zuml file.</p>
     *
     * @return the  currentVersion variable
     */
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * <p>Get the acceptable versions.</p>
     *
     * @return the acceptableVersions variable
     */
    public String[] getAcceptableVersions() {
        return acceptableVersions;
    }
}
