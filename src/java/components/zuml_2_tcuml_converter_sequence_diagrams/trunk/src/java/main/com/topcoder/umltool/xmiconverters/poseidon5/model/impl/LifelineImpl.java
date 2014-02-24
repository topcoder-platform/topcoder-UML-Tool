/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;


/**
 * <p>
 * This class extends ModelElementAbstractImpl and implements Lifeline interface, it represents
 * &lt;UML2:Lifeline&gt; element in ZUML file. It also provides the functionality to transform
 * it to the com.topcoder.uml.model.commonbehavior.instances.Object instance. the transformed
 * instance will be stored to transformedObject variable, so that if that variable is not null,
 * the variable is returned directly in toTCUMLElement method. This class will be configured to
 * XMI Reader Model Plugin component so that the XML2ModelHandler can read the corresponding
 * elements from file into the model.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public class LifelineImpl extends ModelElementAbstractImpl implements Lifeline {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = 8240054136304885785L;

    /**
     * <p>
     * The represents property of the lifeline, it means which class or interface this lifeline
     * represents. It is initially null, mutable. It can be null. It can be accessed by the
     * setter and getter.
     * </p>
     */
    private Attribute represents;

    /**
     * <p>
     * The transformed object instance, if this lifeline is never transformed, this variable
     * is null, if it is not null, it will be returned directly in toTCUMLElement method. It
     * is initially null, is used in toTCUMLElement method. It can be null.
     * </p>
     */
    private Object transformedObject;

    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    public LifelineImpl() {
    }

    /**
     * <p>
     * Transform this lifeline to TCUML Object instance. The name of the lifelien will be the
     * name of object, the represents attribute's classifier will be the classifier for object.
     * </p>
     *
     * @return the transformed object[TCUML model] instance
     */
    public Object toTCUMLElement() {
        if (transformedObject == null) {
            transformedObject = new ObjectImpl();
            transformedObject.setName(this.getName());

            //In real zuml, represents can be null, or if represents is null, do nothing here
            if (represents != null) {
                transformedObject.setClassifier(represents.getType());
            }
        }

        return transformedObject;
    }

    /**
     * <p>
     * Set the represents property of lifeline. It means which class or interface this lifeline represents.
     * </p>
     *
     * @param represents the represents property to set
     */
    public void setRepresents(Attribute represents) {
        this.represents = represents;
    }

    /**
     * <p>
     * Return the represents property. It means which class or interface this lifeline represents.
     * </p>
     *
     * @return the represents property
     */
    public Attribute getRepresents() {
        return represents;
    }
}
