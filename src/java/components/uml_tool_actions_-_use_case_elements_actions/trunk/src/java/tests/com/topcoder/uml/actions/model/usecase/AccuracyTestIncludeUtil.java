/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>IncludeUtil</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestIncludeUtil extends TestCase {
    /** The <code>IncludeUtil</code> instance used to test against. */
    private IncludeUtil includeUtil;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        includeUtil = new IncludeUtil();
    }

    /**
     * Test the constructor <code>IncludeUtil()</code>.
     */
    public void testConstructor() {
        IncludeUtil util = new IncludeUtil();
        assertNotNull("Instance of IncludeUtil should be created.", util);
    }

    /**
     * Test the method <code>addElementToModel(ModelElement, Namespace)</code>.
     */
    public void testAddElementToModelWhenNoCommonNamespace() {
        ModelElement include = new IncludeImpl();
        Namespace namespace = new MockNamespaceImpl();
        includeUtil.addElementToModel(include, namespace);

        assertTrue("Namespace should be set.", include.getNamespace().equals(namespace));
        assertTrue("Owned element should be set.", namespace.getOwnedElements().contains(include));
    }

    /**
     * Test the method <code>addElementToModel(ModelElement, Namespace)</code>.
     */
    public void testAddElementToModelWhenCommonNamespace() {
        Include include = new IncludeImpl();
        include.setBase(new UseCaseImpl());
        include.getBase().setNamespace(new MockNamespaceImpl());
        include.getBase().getNamespace().setName("abc");
        include.getBase().getNamespace().setNamespace(new MockNamespaceImpl());
        include.getBase().getNamespace().getNamespace().setName("topcoder");
        include.setAddition(new UseCaseImpl());
        include.getAddition().setNamespace(new MockNamespaceImpl());
        include.getAddition().getNamespace().setName("dbf");
        include.getAddition().getNamespace().setNamespace(new MockNamespaceImpl());
        include.getAddition().getNamespace().getNamespace().setName("topcoder");

        Namespace namespace = new MockNamespaceImpl();
        includeUtil.addElementToModel(include, namespace);

        assertFalse("Calculated namespace should be used.", include.getNamespace().equals(namespace));
        assertFalse("Calculated namespace should be used.", namespace.getOwnedElements().contains(include));
        assertTrue("Calculated namespace should be 'topcoder'.", include.getNamespace().getName().equals("topcoder"));
    }

    /**
     * Test the method <code>removeElementFromModel(ModelElement)</code>.
     */
    public void testRemoveElementFromModel() {
        Include include = new IncludeImpl();
        UseCase base = new UseCaseImpl();
        UseCase extension = new UseCaseImpl();
        include.setBase(base);
        include.setAddition(extension);
        base.addInclude(include);
        extension.addIncluder(include);

        Namespace namespace = new MockNamespaceImpl();
        assertFalse("False should be returned.", includeUtil.removeElementFromModel(include));
        includeUtil.addElementToModel(include, namespace);

        assertTrue("True should be returned.", includeUtil.removeElementFromModel(include));
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(include));
        assertFalse("False should be returned.", includeUtil.removeElementFromModel(include));
        assertFalse("The include relation should be removed.", base.getIncludes().contains(include));
        assertFalse("The include relation should be removed.", extension.getIncluders().contains(include));
    }

    /**
     * Test the method <code>addElementToClipboard(ModelElement, Clipboard)</code>.
     */
    public void testAddElementToClipboard() {
        ModelElement include = new IncludeImpl();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        includeUtil.addElementToClipboard(include, clipboard);

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.INCLUDE_FLAVOR));
    }

    /**
     * Test the method <code>copyElement(ModelElement)</code>.
     */
    public void testCopyElement() {
        ModelElement include = new IncludeImpl();
        include.setName("name");

        ModelElement ret = includeUtil.copyElement(include);
        assertTrue("The returned ModelElement should be an Include.", ret instanceof IncludeImpl);
        assertTrue("The name of returned Include should be correct.", ret.getName().equals("name"));
    }
}
