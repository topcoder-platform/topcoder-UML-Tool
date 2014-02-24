/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core;

import java.util.*;

import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface GeneralizableElement extends com.topcoder.uml.model.core.ModelElement {

    /**
     * Mock method.
     *
     * @param isRoot
     */
    public void setRoot(boolean isRoot);

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isRoot();

    /**
     * Mock method.
     *
     * @param isLeaf
     */
    public void setLeaf(boolean isLeaf);

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isLeaf();

    /**
     * Mock method.
     *
     * @param isAbstract
     */
    public void setAbstract(boolean isAbstract);

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isAbstract();

    /**
     * Mock method.
     *
     * @param generalization
     */
    public void addGeneralization(Generalization generalization);

    /**
     * Mock method.
     *
     * @param generalization
     * @return
     */
    public boolean removeGeneralization(Generalization generalization);

    /**
     * Mock method.
     *
     */
    public void clearGeneralizations();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Generalization> getGeneralizations();

    /**
     * Mock method.
     *
     * @param generalization
     * @return
     */
    public boolean containsGeneralization(Generalization generalization);

    /**
     * Mock method.
     *
     * @return
     */
    public int countGeneralizations();

    /**
     * Mock method.
     *
     * @param specialization
     */
    public void addSpecialization(Generalization specialization);

    /**
     * Mock method.
     *
     * @param specialization
     * @return
     */
    public boolean removeSpecialization(Generalization specialization);

    /**
     * Mock method.
     *
     */
    public void clearSpecializations();

    /**
     * Mock method.
     *
     * @return
     */
    public Collection<Generalization> getSpecializations();

    /**
     * Mock method.
     *
     * @param specialization
     * @return
     */
    public boolean containsSpecialization(Generalization specialization);

    /**
     * Mock method.
     *
     * @return
     */
    public int countSpecializations();
}