/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.handlers;

import com.topcoder.umltool.xmiconverters.poseidon5.Helper;

import com.topcoder.xmi.reader.DefaultXMIHandler;

import org.xml.sax.Attributes;


/**
 * <p>
 * This handler is used to handle the &lt;XMI.header&gt; element and extract the version in
 * &lt;XMI.metaModelVersion&gt; element to compare it to the configured acceptable versions,
 * if the version is not contained by acceptable versions, UnsupportedVersionException will be thrown.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable and not thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class ZUMLHeaderHandler extends DefaultXMIHandler {
    /**
     * <p>The qname of version element.</p>
     */
    private static final String VERSION_QNAME = "XMI.metaModelVersion";

    /**
     * <p>
     * The acceptable versions of zuml file this component can handle. It is initialized in
     * the constructor and never be changed. It can not be null, can be empty, the element
     * can not be null or empty. It can be retrieved by the getter.
     * </p>
     */
    private final String[] acceptableVersions;

    /**
     * <p>
     * This field represents whether it's now in the &lt;XMI.metaModelVersion&gt; element
     * processing. It is initially false and is mutable. It can be changed by the startElement
     * and endElement methods.
     * </p>
     */
    private boolean inMetaModelVersionElement = false;

    /**
     * <p>
     * Construct this class with acceptable versions.
     * </p>
     *
     * @param acceptableVersions the acceptable versions this component handle
     * @throws IllegalArgumentException if the argument is null or the array contains null or empty element
     */
    public ZUMLHeaderHandler(String[] acceptableVersions) {
        Helper.checkArray(acceptableVersions, "acceptableVersions");

        this.acceptableVersions = acceptableVersions;
    }

    /**
     * <p>
     * This method will be called when the elements in &lt;XMI.header&gt; start as this handler
     * will be registered to the &lt;XMI.header&gt; element. In this method, it will set
     * the inMetaModelVersionElement to true if the qName is "XMI.metaModelVersion".
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified name (with prefix), or the empty string if qualified names are not available
     * @param attrs
     *        the attributes attached to the element. If there are no attributes, it shall
     *        be an empty Attributes object. The value of this object after startElement returns is undefined
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs) {
        if (VERSION_QNAME.equals(qName)) {
            this.inMetaModelVersionElement = true;
        }
    }

    /**
     * <p>
     * This method will be called when the elements in &lt;XMI.header&gt; end as this handler
     * will be registered to the &lt;XMI.header&gt; element. In this method, it will set
     * the inMetaModelVersionElement to false if the qName is "XMI.metaModelVersion".
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified name (with prefix), or the empty string if qualified names are not available
     */
    public void endElement(String uri, String localName, String qName) {
        if (VERSION_QNAME.equals(qName)) {
            this.inMetaModelVersionElement = false;
        }
    }

    /**
     * <p>
     * This method will be called when the SAX parser reports each chunk of character data in
     * the elements in &lt;XMI.header&gt; as this handler will be registered to the
     * &lt;XMI.header&gt; element.&nbsp; In this method, it will check whether the inMetaModelVersionElement
     * is true. if true, it will extract the version info in the ch array and compare the versiont
     * to acceptableVersions array, it is not contained, UnsupportedVersionException will be thrown.
     * </p>
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     *
     * @throws UnsupportedVersionException if the version is not acceptable
     */
    public void characters(char[] ch, int start, int length)
        throws UnsupportedVersionException {
        if (inMetaModelVersionElement) {
            String currentVersion = new String(ch, start, length);

            for (String version : acceptableVersions) {
                if (version.equals(currentVersion)) {
                    return;
                }
            }

            throw new UnsupportedVersionException(currentVersion,
                acceptableVersions);
        }
    }

    /**
     * <p>Get the array of acceptable versions.</p>
     *
     * @return the accepableVersion variable
     */
    public String[] getAcceptableVersions() {
        return acceptableVersions;
    }
}
