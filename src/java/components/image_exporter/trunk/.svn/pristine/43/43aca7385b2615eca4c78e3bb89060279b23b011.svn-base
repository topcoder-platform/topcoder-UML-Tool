/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.sun.media.jai.codec.ImageEncodeParam;

import com.topcoder.util.image.manipulation.Image;
import com.topcoder.util.image.manipulation.ImageEncoder;
import com.topcoder.util.image.manipulation.ImageEncodingException;

import java.io.IOException;
import java.io.OutputStream;


/**
 * Mock implementation of ImageEncoder used in test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockImageEncoder implements ImageEncoder {
    /**
     * Ignore this method.
     *
     * @param arg0 Ignored
     * @param arg1 Ignored
     * @param arg2 Ignored
     */
    public void encode(Image arg0, String arg1, ImageEncodeParam arg2) {
    }

    /**
     * Writes "MockImageEncoder" into OutputStream.
     *
     * @param arg0 Ignored
     * @param arg1 OutputStream
     * @param arg2 Ignored
     * @throws ImageEncodingException if write error
     */
    public void encode(Image arg0, OutputStream arg1, ImageEncodeParam arg2)
        throws ImageEncodingException {
        try {
            arg1.write("MockImageEncoder".getBytes());
        } catch (IOException e) {
            throw new ImageEncodingException("error", e);
        }
    }
}
