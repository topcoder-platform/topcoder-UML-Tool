/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.EventOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.ExecutionOccurrence;


/**
 * <p>
 * This class extends ModelElementAbstractImpl and implements EventOccurrence interface,
 * it represents &lt;UML2:EventOccurrence&gt; element in ZUML file. This class will be
 * configured to XMI Reader Model Plugin component so that the XML2ModelHandler can read
 * the corresponding elements from file into the model.
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
public class EventOccurrenceImpl extends ModelElementAbstractImpl
    implements EventOccurrence {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = -3427016782208988901L;

    /**
    * <p>
    * The startExec property of the event occurrence, startExec is the execution
    * occurrence has the start event with this event occurrence. It is initially
    * null, mutable. It can be null. It can be accessed by the setter and getter.
    * </p>
    */
    private ExecutionOccurrence startExec;

    /**
     * <p>
     * The finishExec property of the event occurrence, finishExec is the execution
     * occurrence has the end event with this event occurrence. It is initially null,
     * mutable. It can be null. It can be accessed by the setter and getter.
     * </p>
     */
    private ExecutionOccurrence finishExec;

    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    public EventOccurrenceImpl() {
    }

    /**
     * <p>
     * Get the startExec property of this event occurrence, startExec is the execution
     * occurrence has the start event with this event occurrence. It can be null.
     * </p>
     *
     * @return  the startExec property of this event occurrence
     */
    public ExecutionOccurrence getStartExec() {
        return startExec;
    }

    /**
     * <p>
     * Set the startExec property of eventOccurrence. startExec is the execution occurrence
     * has the start event with this event occurrence. It can be null.
     * </p>
     *
     * @param startExec the startExec property to set
     */
    public void setStartExec(ExecutionOccurrence startExec) {
        this.startExec = startExec;
    }

    /**
     * <p>
     * Get the finishExec property of this event occurrence, finishExec is the execution
     * occurrence has the end event with this event occurrence. It can be null.
     * </p>
     *
     * @return  the finishExec property of this event occurrence
     */
    public ExecutionOccurrence getFinishExec() {
        return finishExec;
    }

    /**
     * <p>
     * Set the finishExec property of eventOccurrence, finishExec is the execution occurrence
     * has the end event with this event occurrence. It can be null.
     * </p>
     *
     * @param finishExec the finishExec property to set
     */
    public void setFinishExec(ExecutionOccurrence finishExec) {
        this.finishExec = finishExec;
    }
}
