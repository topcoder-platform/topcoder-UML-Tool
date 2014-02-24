/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;

import java.util.List;


/**
 * The Helper class which will check the given object whether is null, or given String whether is null or empty. It
 * also has a help method to calculate the target namespace.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {
    /**
     * Check whether the given object is null.
     *
     * @param name the given object's name
     * @param value the given object need to be checked
     *
     * @throws IllegalArgumentException if the given object is null
     */
    public static void checkNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException("the " + name + " should not be null.");
        }
    }

    /**
     * Check whether the given String is null or empty.
     *
     * @param name the given object's name
     * @param value the given object need to be checked
     *
     * @throws IllegalArgumentException if the given String is null or empty
     */
    public static void checkNullOrEmpty(String name, String value) {
        checkNull(name, value);

        if (value.trim().length() == 0) {
            throw new IllegalArgumentException("the " + name + " should not be empty.");
        }
    }

    /**
     * According to the given lists, calculate the target namespace.
     *
     * @param baseList the base list.
     * @param list the extension or additional list.
     *
     * @return the target namespace.
     */
    public static Namespace calculatedNamespace(List<Namespace> baseList, List<Namespace> list) {
        if ((baseList == null) || (list == null)) {
            return null;
        }

        Namespace resultNamespace = null;

        if (baseList.size() > 0) {
            //reverse lists to get the result namespace
            resultNamespace = baseList.get(baseList.size() - 1);

            for (int i = baseList.size() - 1; i >= 0; i--) {
                if (list.size() < i) {
                    break;
                } else {
                    Namespace base = (Namespace) baseList.get(i);
                    Namespace extension = (Namespace) list.get(i);

                    if ((base != null) && (base.getName() != null) && (extension != null)
                            && (extension.getName() != null) && base.getName().equals(extension.getName())) {
                        resultNamespace = baseList.get(i);
                    } else {
                        break;
                    }
                }
            }
        }

        return resultNamespace;
    }
}
