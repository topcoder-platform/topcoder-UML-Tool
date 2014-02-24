/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * DemoTest contains the demo program.
 * It stands on user side, and tests the overall behavior of the component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTest extends TestCase {
   /**
     * <p>
     * Test suite of <code>DemoTest</code>.
     * </p>
     *
     * @return Test suite of <code>DemoTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DemoTest.class);
    }

    /**
     * <p>
     * Test the demo program. It creates some instance of sample entity : <code>CallOperationActionImpl</code>
     * and tests the functionality provided by this class.
     * </p>
     */
    public void testDemo() {
        // create an instance of CallOperationActionImpl.
        CallOperationAction callOperationAction = new CallOperationActionImpl();

        // create a new instance of Operation.
        Operation operation = new OperationImpl();

        // use setter to set the operation to this action.
        callOperationAction.setOperation(operation);

        // use getter to get the operation that will be invoked by this action.
        // the retrievedOperation will be the same as the original operation.
        Operation retrievedOperation = callOperationAction.getOperation();

        // set the asychronous flag to true, so the operation of this action will be called asynchronously.
        callOperationAction.setAsynchronous(true);

        // we can also get the info about the asychronous flag.
        // the result will be : true.
        boolean result = callOperationAction.isAsynchronous();

        // create a new instance of Procedure.
        Procedure procedure = new ProcedureImpl();
        // use setter to set the procedure to this action.
        callOperationAction.setProcedure(procedure);
        // use getter to get the procedure that belongs to this action.
        // the retrievedProcedure will be the same as the original procedure.
        Procedure retrievedProcedure = callOperationAction.getProcedure();
    }
}