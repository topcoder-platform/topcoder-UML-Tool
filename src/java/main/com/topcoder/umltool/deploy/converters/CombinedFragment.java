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
 * This class extends ModelElementAbstractImpl, it represents &lt;UML2:CombinedFragment&gt; element in ZUML file. This
 * class will be configured to XMI Reader Model Plugin component so that the XML2ModelHandler can read the element from
 * file into the model.
 * </p>
 * <p>
 * <strong>Thread safety:</strong> This class is mutable.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CombinedFragment extends ModelElementAbstractImpl {

    /**
     * <p>
     * The covered collection in this fragment. It is initially to empty ModelElement array list, and never changed
     * later. It can't be null, can be empty, can't contain null message instance. It is used in addCovered,
     * removeCovered, clearCovereds and getCovereds methods.
     * </p>
     */
    private final Collection<ModelElement> covereds = new ArrayList<ModelElement>();

    /**
     * <p>
     * The operand property of the fragment. It is initially null, mutable. It can be null. It can be accessed by the
     * setter and getter.
     * </p>
     */
    private InteractionOperand operand;

    /**
     * <p>
     * Empty constructor as a placeholder for future use.
     * </p>
     */
    public CombinedFragment() {
    }

    /**
     * <p>
     * Clear all the covereds in this CombinedFragment instance.
     * </p>
     */
    public void clearCovereds() {
        covereds.clear();
    }

    /**
     * <p>
     * Remove a covered from this CombinedFragment instance. If no covered is found, do nothing, if duplicate covereds
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
     * Add a covered to this CombinedFragment instance. Duplicate covereds are acceptable.
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
     * Return all the covereds in this CombinedFragment, a shallow copy of covereds will be returned.
     * </p>
     * @return all the covereds in this CombinedFragment
     */
    public Collection<ModelElement> getCovereds() {
        return new ArrayList<ModelElement>(covereds);
    }

    /**
     * <p>
     * Return the operand property..
     * </p>
     * @return the operand property
     */
    public InteractionOperand getOperand() {
        return this.operand;
    }

    /**
     * <p>
     * Set the operand property of CombinedFragment.
     * </p>
     * @param represents
     *            the represents property to set
     */
    public void setOperand(InteractionOperand operand) {
        DeployHelper.checkNotNull(operand, "operand");

        this.operand = operand;
    }
}
