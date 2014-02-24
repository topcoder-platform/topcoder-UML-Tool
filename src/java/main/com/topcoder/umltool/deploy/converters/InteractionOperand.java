/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.converters;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class extends ModelElementAbstractImpl, it represents &lt;UML2:InteractionOperand&gt; element in ZUML file. This
 * class will be configured to XMI Reader Model Plugin component so that the XML2ModelHandler can read the element from
 * file into the model.
 * </p>
 * <p>
 * <strong>Thread safety:</strong> This class is mutable.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InteractionOperand extends ModelElementAbstractImpl {

    /**
     * <p>
     * The covered collection in this operand. It is initially to empty ModelElement array list, and never changed
     * later. It can't be null, can be empty, can't contain null message instance. It is used in addCovered,
     * removeCovered, clearCovereds and getCovereds methods.
     * </p>
     */
    private final Collection<ModelElement> covereds = new ArrayList<ModelElement>();

    /**
     * <p>
     * The fragment collection in this operand. It is initially to empty ModelElement array list, and never changed
     * later. It can't be null, can be empty, can't contain null message instance. It is used in addCovered,
     * removeCovered, clearCovereds and getCovereds methods.
     * </p>
     */
    private final Collection<ModelElement> fragments = new ArrayList<ModelElement>();

    /**
     * <p>
     * Empty constructor as a placeholder for future use.
     * </p>
     */
    public InteractionOperand() {
    }

    /**
     * <p>
     * Clear all the covereds in this InteractionOperand instance.
     * </p>
     */
    public void clearCovereds() {
        covereds.clear();
    }

    /**
     * <p>
     * Remove a covered from this InteractionOperand instance. If no covered is found, do nothing, if duplicate covereds
     * are found, which one will be removed is undefined.
     * </p>
     * @param Covered
     *            the covered to be removed
     * @throws IllegalArgumentException
     *             if covered is null
     */
    public void removeCovered(ModelElement covered) {
        DeployHelper.checkNotNull(covered, "covered");

        covereds.remove(covered);
    }

    /**
     * <p>
     * Add a covered to this InteractionOperand instance. Duplicate covereds are acceptable.
     * </p>
     * @param covered
     *            the covered to be added
     * @throws IllegalArgumentException
     *             if Covered is null
     */
    public void addCovered(ModelElement covered) {
        DeployHelper.checkNotNull(covered, "covered");

        covereds.add(covered);
    }

    /**
     * <p>
     * Return all the covereds in this InteractionOperand, a shallow copy of covereds will be returned.
     * </p>
     * @return all the covereds in this InteractionOperand
     */
    public Collection<ModelElement> getCovereds() {
        return new ArrayList<ModelElement>(covereds);
    }

    /**
     * <p>
     * Clear all the fragments in this InteractionOperand instance.
     * </p>
     */
    public void clearFragments() {
        fragments.clear();
    }

    /**
     * <p>
     * Remove a fragment from this InteractionOperand instance. If no fragment is found, do nothing, if duplicate
     * fragments are found, which one will be removed is undefined.
     * </p>
     * @param Fragment
     *            the fragment to be removed
     * @throws IllegalArgumentException
     *             if fragment is null
     */
    public void removeFragment(ModelElement fragment) {
        DeployHelper.checkNotNull(fragment, "fragment");

        fragments.remove(fragment);
    }

    /**
     * <p>
     * Add a fragment to this InteractionOperand instance. Duplicate fragments are acceptable.
     * </p>
     * @param fragment
     *            the fragment to be added
     * @throws IllegalArgumentException
     *             if Fragment is null
     */
    public void addFragment(ModelElement fragment) {
        DeployHelper.checkNotNull(fragment, "fragment");

        fragments.add(fragment);
    }

    /**
     * <p>
     * Return all the fragments in this InteractionOperand, a shallow copy of fragments will be returned.
     * </p>
     * @return all the fragments in this InteractionOperand
     */
    public Collection<ModelElement> getFragments() {
        return new ArrayList<ModelElement>(fragments);
    }
}
