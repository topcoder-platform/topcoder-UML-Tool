/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * This interface represents &lt;UML2:Lifeline&gt; element. It is the model class for a lifeline
 * in Sequence Diagram in ZUML file (UML2). It extends ModelElement interface. It also extends
 * ZUML2TCUMLTransformer&lt;Object&gt; interface so that it will be transformed to
 * com.topcoder.uml.model.commonbehavior.instances.Object. This interface is not a complete model
 * for UML2, it is just used to transform to TCUML Object. So the &lt;UML2:Lifeline.coveredBy&gt;
 * is ignored.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public interface Lifeline extends ZUML2TCUMLTransformer<Object>, ModelElement {
    /**
     * <p>
     * Set the represents property of lifeline, it means which class or interface this lifeline represents.
     * </p>
     *
     * @param represents the represents property to set
     */
    public void setRepresents(Attribute represents);

    /**
     * <p>
     * Return the represents property, it means which class or interface this lifeline represents.
     * </p>
     *
     * @return the represents property
     */
    public Attribute getRepresents();
}
