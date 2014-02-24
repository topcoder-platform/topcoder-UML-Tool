/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * This class represents an Image and extends LeafElements. It references a file containing an image of a
 * specific mimeType.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class Image extends LeafElement {

    /**
     * <p>
     * Represents the uri of the Image. Can be null. Can be empty. Default to null.
     * </p>
     */
    private String uri;

    /**
     * <p>
     * Represents the mime type of this Image. Can be null. Can be empty. Default to null.
     * </p>
     */
    private String mimeType;

    /**
     * <p>
     * Creates an instance of Image.
     * </p>
     */
    public Image() {
        super();
    }

    /**
     * <p>
     * Gets the uri of the Image.
     * </p>
     *
     * @return the uri of the Image
     */
    public String getUri() {
        return uri;
    }

    /**
     * <p>
     * Sets the uri of the Image. Can be null. Can be empty.
     * </p>
     *
     * @param uri the new uri of the Image
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * <p>
     * Gets the mime type of this Image.
     * </p>
     *
     * @return the mime type of this Image
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * <p>
     * Sets the mime type of this Image. Can be null. Can be empty.
     * </p>
     *
     * @param mimeType the new mime type of the Image
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}