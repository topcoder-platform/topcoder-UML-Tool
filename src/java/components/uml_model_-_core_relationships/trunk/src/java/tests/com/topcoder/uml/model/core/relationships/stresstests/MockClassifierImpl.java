/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.stresstests;

import java.util.Random;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;

/**
 * <p>
 * This is the mock implementation of the Classifier interface. It contains ID property to identify. It is created for
 * testing.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class MockClassifierImpl extends ClassifierAbstractImpl {
    /** To identify. */
    private final String id;

    /**
     * Creates a new ClassifierImpl object.
     */
    public MockClassifierImpl() {
        super();

        // we create a random ID
        Random random = new Random();
        this.id = "ID " + random.nextInt();
    }

    /**
     * Creates a new ClassifierImpl object.
     * 
     * @param id
     *        The ID of this classifier.
     */
    public MockClassifierImpl(String id) {
        super();

        this.id = id;
    }

    /**
     * Return the ID of this classifier.
     * 
     * @return The ID.
     */
    public String getId() {
        return this.id;
    }
}
