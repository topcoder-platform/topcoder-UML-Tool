/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

/**
 * <p>
 * This helper class contains the methods for this component to check
 * the arguments.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public final class DocumentPanelHelper {

    /**
     * <p>
     * Prefix before tag name.
     * </p>
     */
    private static final String TAG_PREFIX = "@";

    /**
     * <p>
     * Private constructor to prevent this class being instantiated.
     * </p>
     */
    private DocumentPanelHelper() {
        // does nothing
    }

    /**
     * <p>
     * Validates whether the given Object is not null.
     * If the given Object is null, <code>IllegalArgumentException</code>
     * is thrown.
     * </p>
     *
     * @param obj the object to check
     * @param name the name what the object is intent to represent
     *
     * @throws IllegalArgumentException if the given Object(obj) is null
     */
    public static void validateNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Check whether given string is not empty(trimmed).
     * </p>
     *
     * <p>
     * If given string is null, it's considered to be empty.
     * That is, false is returned.
     * </p>
     *
     * @param str to check.
     *
     * @return true if given string is not empty(trimmed);
     *         false otherwise.
     */
    public static boolean checkNotEmpty(String str) {
        if (str != null && str.trim().length() > 0) {
            return true;
        }
        return false;
    }
    /**
     * <p>
     * Validates whether the given String is not null and not empty(trimmed).
     * If the given <code>String</code> is either null or empty(trimmed),
     * <code>IllegalArgumentException</code> is thrown.
     * </p>
     *
     * @param str the String to check
     * @param name the name what the String is intent to represent
     *
     * @throws IllegalArgumentException if the given string is null or empty string (trimmed)
     */
    public static void validateString(String str, String name) {
        validateNotNull(str, name);

        if (str.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Validates whether previous document and the current document
     * are both null or empty after trimming. If they are both invalid,
     * <code>IllegalArgumentException</code> is thrown.
     * </p>
     *
     * @param preDoc the previous documentation to validate
     * @param currDoc the current documentation to validate
     *
     * @throws IllegalArgumentException if both preDoc and currDoc
     *         are null or empty after trimming.
     */
    public static void validatePreDocAndCurrDoc(String preDoc, String currDoc) {
        if (checkNotEmpty(preDoc)) {
            return;
        }

        if (checkNotEmpty(currDoc)) {
            return;
        }

        throw new IllegalArgumentException(
            "Both previous document and current document are not valid(null or trimmed empty).");
    }

    /**
     * <p>
     * Check whether the given row index is within range of rows' size.
     * </p>
     *
     * <p>
     *  <strong>Example:</strong>
     *   Given rows with size of 2,
     *   <ul>
     *    <li>checkRange(2, -1) results false;</li>
     *    <li>checkRange(2, 0) results true;</li>
     *    <li>checkRange(2, 1) results true;</li>
     *    <li>checkRange(2, 2) results false.</li>
     *   </ul>
     * </p>
     *
     * @param rowSize the size of rows
     * @param rowIndex the row index to check
     *
     * @return true If given value is in range; false otherwise.
     *
     * @throws IllegalArgumentException If rowSize is negative.
     */
    public static boolean checkRowRange(int rowSize, int rowIndex) {
        if (rowSize < 0) {
            throw new IllegalArgumentException(
                    "Size of rows should not be negative.");
        }
        if (rowIndex >= 0 && rowIndex < rowSize) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * For a tag table, the column index must be either 0 or 1.
     * </p>
     *
     * @param columnIndex the column index to check
     *
     * @return true If columnIndex is either 0 or 1; false otherwise.
     */
    public static boolean checkColumnRange(int columnIndex) {
        if (columnIndex != 0 && columnIndex != 1) {
            return false;
        }
        return true;
    }
    /**
     * <p>
     * Check whether <code>TaggedValue</code> is with desired tag type.
     * </p>
     *
     * <p>
     *  <ul>
     *   <li>If passed in isMainDoc is true, this method checks
     *       whether <code>TagDefinition</code>'s tagType equals
     *       passed in desired type;</li>
     *   <li>Else this method checks whether <code>TagDefinition</code>'s
     *       tagType starts with passed in desired type.</li>
     *  </ul>
     * </p>
     *
     * @param tv <code>TaggedValue</code> to check.
     * @param desiredType desired tag type. Should not be null.
     *        Generally in this component, it either be "documentation"
     *        for main documentation or "documentation#" for tag documentation.
     * @param isMainDoc indicate whether the <code>TaggedValue</code>
     *        is for main documentation or tag documentation.
     *
     * @return true if tag is of desired type; false otherwise.
     *
     * @throws IllegalArgumentException if desired tag type is null.
     */
    public static boolean checkTagType(TaggedValue tv, String desiredType,
            boolean isMainDoc) {
        validateNotNull(desiredType, "Desired tag type");
        if (tv != null && tv.getType() != null) {
            String tagType = tv.getType().getTagType();
            if (tagType == null) {
                return false;
            } else if (isMainDoc) {
                boolean match = tagType.equals(desiredType);

                if (!match) {
                    if (tagType.equals("String")) {
                        tagType = tv.getType().getName();
                    }

                    match = tagType.equals(desiredType);
                }

                return match;
            }
            return tagType.startsWith(desiredType);
        }
        return false;
    }
    /**
     * <p>
     * Prefix a "@" before given tag name.
     * </p>
     *
     * <p>
     * If given tag name is already prefixed
     * with "@", simply return it.
     * </p>
     *
     * @param tagName tag name to prefix. Should not be null.
     *
     * @return tagName with prefix "@"
     *
     * @throws IllegalArgumentException if passed in tag name is null.
     */
    public static String getTagNameWithPrefix(String tagName) {
        validateNotNull(tagName, "Tag name");
        return tagName.startsWith(TAG_PREFIX) ? tagName : TAG_PREFIX + tagName;
    }
}
