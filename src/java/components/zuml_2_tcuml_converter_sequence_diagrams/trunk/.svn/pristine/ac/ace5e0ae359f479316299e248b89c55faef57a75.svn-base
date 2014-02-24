/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * This interface represents &lt;UML2:EventOccurrence&gt; element. It is the model class for
 * an event occurrence in Sequence Diagram in ZUML file (UML2). It extends ModelElement interface.
 * This interface is not a complete model for UML2, it is just used to transform to TCUML Object.
 * So the &lt;UML2:InteractionFragment.covered&gt;, &lt;UML2:MessageEnd.sendMessage&gt;, and
 * &lt;UML2:MessageEnd.receiveMessage&gt; are ignored.
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
public interface EventOccurrence extends ModelElement {
    /**
     * <p>
     * Set the startExec property of eventOccurrence. startExec is the execution occurrence has
     * the start event with this event occurrence. It can be null.
     * </p>
     *
     * @param startExec the startExec property to set
     */
    public void setStartExec(ExecutionOccurrence startExec);

    /**
     * <p>
     * Get the startExec property of this event occurrence, startExec is the execution
     * occurrence has the start event with this event occurrence. It can be null.
     * </p>
     *
     * @return  the startExec property of this event occurrence
     */
    public ExecutionOccurrence getStartExec();

    /**
     * <p>
     * Set the finishExec property of eventOccurrence, finishExec is the execution occurrence
     * has the end event with this event occurrence. It can be null.
     * </p>
     *
     * @param finishExec the finishExec property to set
     */
    public void setFinishExec(ExecutionOccurrence finishExec);

    /**
     * <p>
     * Get the finishExec property of this event occurrence, finishExec is the execution occurrence
     * has the end event with this event occurrence. It can be null.
     * </p>
     *
     * @return  the finishExec property of this event occurrence
     */
    public ExecutionOccurrence getFinishExec();
}
