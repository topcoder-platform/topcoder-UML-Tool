/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CopyObjectAction;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * Accuracy test for <code>{@link CopyObjectAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CopyObjectActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>CopyObjectAction</code> instance used in tests.
     * </p>
     */
    private CopyObjectAction copyObjectAction;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyObjectAction#CopyObjectAction(Object)}</code>
     * constructor.
     * </p>
     */
    public void testCopyObjectActionAccuracy1() {
        copyObjectAction = new CopyObjectAction(new ObjectImpl());
        assertNotNull(copyObjectAction);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyObjectAction#CopyObjectAction(Object, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCopyObjectActionAccuracy2() {
        copyObjectAction = new CopyObjectAction(new ObjectImpl(), Toolkit.getDefaultToolkit().getSystemClipboard());
        assertNotNull(copyObjectAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CopyObjectAction#execute()}</code>
     * method.
     * </p>
     */
    public void testExecuteAccuracy() {
        copyObjectAction = new CopyObjectAction(new ObjectImpl());
        copyObjectAction.execute();
    }
}
