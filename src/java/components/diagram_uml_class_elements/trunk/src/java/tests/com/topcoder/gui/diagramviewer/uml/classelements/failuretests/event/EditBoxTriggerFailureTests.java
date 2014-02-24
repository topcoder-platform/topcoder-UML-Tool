package com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event;

import com.topcoder.gui.diagramviewer.uml.classelements.event.EditBoxTrigger;

import junit.framework.TestCase;

/**
 * Failure tests for EditBoxTrigger class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class EditBoxTriggerFailureTests extends TestCase {
    /**
     * Tests the constructor EditBoxTrigger(TextField) with null textField, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullTextField() throws Exception {
        try {
            new EditBoxTrigger(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
