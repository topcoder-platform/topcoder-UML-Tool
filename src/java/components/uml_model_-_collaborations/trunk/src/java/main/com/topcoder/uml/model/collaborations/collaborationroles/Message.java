/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ Message.java
 */

package com.topcoder.uml.model.collaborations.collaborationroles;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes from the Core
 * Requirements component. A message defines a particular communication between instances that is
 * specified in an interaction.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public interface Message extends ModelElement {
    /**
     * Gets the Stimulus conformingStimulus field value. Could be null.
     *
     * @return conformingStimulus field value
     */
    public Stimulus getConformingStimulus();

    /**
     * Sets the Stimulus conformingStimulus field value. Null is allowed.
     *
     * @param conformingStimulus conformingStimulus field value
     */
    public void setConformingStimulus(Stimulus conformingStimulus);
}


