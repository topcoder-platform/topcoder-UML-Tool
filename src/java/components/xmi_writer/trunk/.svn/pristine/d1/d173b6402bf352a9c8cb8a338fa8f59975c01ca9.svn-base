/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * <p>
 * Helper class used for testing purpose.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public final class TestHelper {

    /**
     * <p>
     * private constructor that preventing instantiation.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Get the field value of an object.
     * </p>
     *
     * @param obj
     *            the object where to get the field value.
     * @param fieldName
     *            the name of the field.
     * @return the field value
     * @throws Exception
     *             any exception occurs.
     */
    public static Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    /**
     * <p>
     * Create a map of transformers which contains the mandatory transformers to be used.
     * </p>
     *
     * @return the map of transformers
     */
    public static Map<TransformerType, XMITransformer> createMandatoryTransformers() {
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
        transformers.put(TransformerType.Model, new MockXMITransformer());
        transformers.put(TransformerType.Diagram, new MockXMITransformer());
        transformers.put(TransformerType.ActivityGraph, new MockXMITransformer());

        return transformers;
    }

    /**
     * <p>
     * read the content of a file and convert it to a string.
     * </p>
     *
     * @param file
     *            the file to read from.
     * @return the content string.
     * @throws IOException
     *             If any I/O error occurs.
     */
    public static String readFileAsString(File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fis = new FileInputStream(file);
        try {
            int c;
            while ((c = fis.read()) != -1) {
                stringBuffer.append((char) c);
            }
            return stringBuffer.toString();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // ignore.
                }
            }
        }
    }

    /**
     * <p>
     * read the content of an entry of the zip file and convert it to a string.
     * </p>
     *
     * @param zipFile
     *            the zip file to read content from.
     * @return the content strong.
     * @throws IOException
     *             If any I/O error occurs.
     */
    public static String readFromZipFileAsString(File zipFile) throws IOException {
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFile));

        // remove the extension if found
        String baseName = zipFile.getName();
        int period = baseName.lastIndexOf('.');
        if (period > -1) {
            baseName = baseName.substring(0, period);
        }
        try {
            // get entry in the zip file
            ZipEntry zipEntry = null;
            while ((zipEntry = zipInput.getNextEntry()) != null) {
                if (zipEntry.getName().equals(baseName + ".xmi")) {
                    break;
                }
            }

            if (zipEntry == null) {
                throw new IOException("entry not found.");
            }

            // read the content
            StringBuffer stringBuffer = new StringBuffer();
            int c;
            while ((c = zipInput.read()) != -1) {
                stringBuffer.append((char) c);
            }

            return stringBuffer.toString();
        } finally {
            if (zipInput != null) {
                try {
                    zipInput.close();
                } catch (IOException e) {
                    // ignore.
                }
            }
        }
    }
}
