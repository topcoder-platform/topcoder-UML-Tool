/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * <p>
 * This abstract class describes an XMI node. As convention, node can be attribute or element.
 * It contains two attributes, a String respresenting node name,
 * and a java.lang.reflect.Method representing the method whose returned value will be used as node value.
 * Besides that, it also defines a getValue method which uses reflection to retrieve node value.
 * </p>
 *
 * <p>
 * This class is immutable, thus thread-safe.
 * </p>
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class NodeDescription {
    /**
     * Represents the name of the this node.
     * <p>
     * It is initialized in the constructor and never changed later.
     * It can be accessed by getter.
     * It can be any non-null, non-empty string.
     * </p>
     *
     */
    private final String name;

    /**
     * Represents the method used to retrieve node value.
     * <p>
     * It is initialized in the constructor and can't be changed later.
     * It can be accessed by getter.
     * It should be non-null, and it should contain no parameter.
     * </p>
     *
     */
    private final Method method;

    /**
     * Constructor with the name and Method.
     *
     * @param name the node name
     * @param method the method to retrieve node value.
     * @throws IllegalArgumentException if any arg is null, or name is an empty string after trimmed,
     * or method contains some parameter.
     */
    protected NodeDescription(String name, Method method) {
        Helper.checkEmptyAndNullString(name, "name");
        Helper.checkNull(method, "method");

        if (method.getParameterTypes().length > 0) {
            throw new IllegalArgumentException(
                "The method should not contains any parameter.");
        }

        this.name = name;
        this.method = method;
    }

    /**
     * Get the name of the node description.
     *
     * @return the node name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the method of the node description.
     *
     * @return the method used to retrieve node value.
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Get the node value via reflection.
     *
     * @return the value of the specified node.
     * @param element the element instance to retrieve value from
     * @throws IllegalArgumentException if the element is null
     * @throws NodeValueRetrievalException if any error occurs while invoking the method.
     */
    public Object getValue(Object element) throws NodeValueRetrievalException {
        Helper.checkNull(element, "element");

        try {
            return method.invoke(element, new Object[] {});
        } catch (IllegalArgumentException e) {
            throw new NodeValueRetrievalException("IllegalArgumentException occurs when using refect to get the value.",
                e);
        } catch (IllegalAccessException e) {
            throw new NodeValueRetrievalException("IllegalAccessException occurs when using refect to get the value.",
                e);
        } catch (InvocationTargetException e) {
            throw new NodeValueRetrievalException(
                    "InvocationTargetException occurs when using refect to get the value.", e);
        }
    }
}
