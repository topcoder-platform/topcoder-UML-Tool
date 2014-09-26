/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ MessageImpl.java
 */

package com.topcoder.uml.model.collaborations.collaborationroles;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * <p> <code>MessageImpl</code> provides a default implementation of <code>Message</code> interface
 * and extends <code>ModelElementAbstractImpl</code> from the Core Requirements component. As such,
 * all methods in Message are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class MessageImpl extends ModelElementAbstractImpl implements Message {
    /**
     * <p>Represents the collection of Stimuli that conforms to the Message.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     */
    private Stimulus conformingStimulus = null;

    /**
     * <p>Empty constructor.</p>
     */
    public  MessageImpl() {
    }

    /**
     * Gets the Stimulus conformingStimulus field value. Could be null.
     *
     * @return conformingStimulus field value
     */
    public Stimulus getConformingStimulus() {
        return conformingStimulus;
    }

    /**
     * Sets the Stimulus conformingStimulus field value. Null is allowed.
     *
     * @param conformingStimulus conformingStimulus field value
     */
    public void setConformingStimulus(Stimulus conformingStimulus) {
        this.conformingStimulus = conformingStimulus;
    }
}
