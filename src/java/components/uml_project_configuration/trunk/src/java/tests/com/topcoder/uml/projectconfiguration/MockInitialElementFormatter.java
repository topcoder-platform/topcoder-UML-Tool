/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * This is a mock implementation of InitialElementFormatter interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockInitialElementFormatter implements InitialElementFormatter {
    /**
     * <p>
     * Implements the format(DiagramElement) method.
     * </p>
     *
     * @param element the model element
     * @return true always.
     *
     * @throws ProjectConfigurationException if the value of system property
     * &quot;exception&quot; is &quot;ProjectConfigurationException&quot;
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        if ("ProjectConfigurationException".equals(System.getProperty("exception"))) {
            throw new ProjectConfigurationException("exception.");
        }

        //add a comment to the model element to identify it has been formatted.
        Comment comment = new CommentImpl();
        comment.setName("Modified by MockInitialElementFormatter");
        element.addComment(comment);

        return true;
    }

}
