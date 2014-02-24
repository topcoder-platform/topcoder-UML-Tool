/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.xmi.writer.transformers.model.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.xmi.writer.TransformerType;

/**
 * <p>
 * This class is just define for the accuracy test. It is inherited from the ModelElementAbstractImpl and contains fields
 * of types string, boolean enum and collection which are used to test the function transform of Model2XMITransformer.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class MockModelElement extends ModelElementAbstractImpl {

    /**
     * <p>
     * Represents a string field.
     * </p>
     */
    private String body = "";

    /**
     * <p>
     * Represents a enum field.
     * </p>
     */
    private TransformerType transformerType = TransformerType.Diagram;

    /**
     * <p>
     * Represents a boolean object.
     * </p>
     */
    private boolean isBooleanForTest = true;

    /**
     * <p>
     * Represents a collection field.
     * </p>
     */
    private final Collection<ModelElement> children = new ArrayList<ModelElement>();

    /**
     * <p>
     * Represents father field.
     * </p>
     */
    private MockModelElement father;

    /**
     * <p>
     * Create instance without parameter.
     * </p>
     */
    public MockModelElement() {

    }

    /**
     * Gets the father field value.
     * 
     * @return father field value
     */
    public MockModelElement getFather() {
        return father;
    }

    /**
     * Sets the father value. Null/empty is allowed.
     * 
     * @param father
     *        father field value
     */
    public void setFather(MockModelElement father) {
        this.father = father;
    }

    /**
     * Gets the String body field value.
     * 
     * @return body field value
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the String body field value. Null/empty is allowed.
     * 
     * @param body
     *        body field value
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the boolean body field value.
     * 
     * @return body field value
     */
    public boolean isBooleanForTest() {
        return isBooleanForTest;
    }

    /**
     * Sets the boolean type field value. Null/empty is allowed.
     * 
     * @param isBooleanForTest
     *        type field value
     */
    public void setIsBooleanForTest(boolean isBooleanForTest) {
        this.isBooleanForTest = isBooleanForTest;
    }

    /**
     * Gets the enum body field value.
     * 
     * @return body field value
     */
    public TransformerType getTransformerType() {
        return transformerType;
    }

    /**
     * Sets the transform type field value.
     * 
     * @param type
     *        type field value
     */
    public void setTransformerType(TransformerType type) {
        transformerType = type;
    }

    /**
     * Adds the ModelElement into the children collection.
     * 
     * @param child
     *        The ModelElement to add to this collection
     * @throws IllegalArgumentException
     *         if annotatedElement is null
     */
    public void addChild(ModelElement child) {
        children.add(child);
    }

    /**
     * Returns a shallow copy of the children collection.
     * 
     * @return the children collection
     */
    public Collection<ModelElement> getChildren() {
        return children;
    }
}
