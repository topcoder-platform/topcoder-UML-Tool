/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>ExtendUtil</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestExtendUtil extends TestCase {
    /** The <code>ExtendUtil</code> instance used to test against. */
    private ExtendUtil extendUtil;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        extendUtil = new ExtendUtil();
    }

    /**
     * Test the constructor <code>ExtendUtil()</code>.
     */
    public void testConstructor() {
        ExtendUtil util = new ExtendUtil();
        assertNotNull("Instance of ExtendUtil should be created.", util);
    }

    /**
     * Test the method <code>addElementToModel(ModelElement, Namespace)</code>.
     */
    public void testAddElementToModelWhenNoCommonNamespace() {
        ModelElement extend = new ExtendImpl();
        Namespace namespace = new MockNamespaceImpl();
        extendUtil.addElementToModel(extend, namespace);

        assertTrue("Namespace should be set.", extend.getNamespace().equals(namespace));
        assertTrue("Owned element should be set.", namespace.getOwnedElements().contains(extend));
    }

    /**
     * Test the method <code>addElementToModel(ModelElement, Namespace)</code>.
     */
    public void testAddElementToModelWhenCommonNamespace() {
        Extend extend = new ExtendImpl();
        extend.setBase(new UseCaseImpl());
        extend.getBase().setNamespace(new MockNamespaceImpl());
        extend.getBase().getNamespace().setName("abc");
        extend.getBase().getNamespace().setNamespace(new MockNamespaceImpl());
        extend.getBase().getNamespace().getNamespace().setName("topcoder");
        extend.setExtension(new UseCaseImpl());
        extend.getExtension().setNamespace(new MockNamespaceImpl());
        extend.getExtension().getNamespace().setName("dbf");
        extend.getExtension().getNamespace().setNamespace(new MockNamespaceImpl());
        extend.getExtension().getNamespace().getNamespace().setName("topcoder");

        Namespace namespace = new MockNamespaceImpl();
        extendUtil.addElementToModel(extend, namespace);

        assertFalse("Calculated namespace should be used.", extend.getNamespace().equals(namespace));
        assertFalse("Calculated namespace should be used.", namespace.getOwnedElements().contains(extend));
        assertTrue("Calculated namespace should be 'topcoder'.", extend.getNamespace().getName().equals("topcoder"));
    }

    /**
     * Test the method <code>removeElementFromModel(ModelElement)</code>.
     */
    public void testRemoveElementFromModel() {
        Extend extend = new ExtendImpl();
        UseCase base = new UseCaseImpl();
        UseCase extension = new UseCaseImpl();
        extend.setBase(base);
        extend.setExtension(extension);
        base.addExtender(extend);
        extension.addExtend(extend);

        Namespace namespace = new MockNamespaceImpl();
        assertFalse("False should be returned.", extendUtil.removeElementFromModel(extend));
        extendUtil.addElementToModel(extend, namespace);

        assertTrue("True should be returned.", extendUtil.removeElementFromModel(extend));
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(extend));
        assertFalse("False should be returned.", extendUtil.removeElementFromModel(extend));
        assertFalse("The extend relation should be removed.", base.getExtenders().contains(extend));
        assertFalse("The extend relation should be removed.", extension.getExtends().contains(extend));
    }

    /**
     * Test the method <code>addElementToClipboard(ModelElement, Clipboard)</code>.
     */
    public void testAddElementToClipboard() {
        ModelElement extend = new ExtendImpl();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        extendUtil.addElementToClipboard(extend, clipboard);

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.EXTEND_FLAVOR));
    }

    /**
     * Test the method <code>copyElement(ModelElement)</code>.
     */
    public void testCopyElement() {
        ModelElement extend = new ExtendImpl();
        extend.setName("name");

        ModelElement ret = extendUtil.copyElement(extend);
        assertTrue("The returned ModelElement should be an Extend.", ret instanceof ExtendImpl);
        assertTrue("The name of returned Extend should be correct.", ret.getName().equals("name"));
    }
}
