/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Demo test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * The Class instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class classElement = new ClassImpl();

    /**
     * The Class instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class classElement1 = new ClassImpl();

    /**
     * The Namespace instance used for test.
     */
    private final Namespace namespace = new ModelImpl();

    /**
     * The UMLModelManager instance used for test.
     */
    private final UMLModelManager manager = new UMLModelManager();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig("test_files/config.xml");
        ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager(manager,
                ProjectConfigurationManager.class.getName());
        manager.setProjectConfigurationManager(projectConfigurationManager);
        manager.setProjectLanguage("Java");
        classElement1.setNamespace(namespace);
        namespace.addOwnedElement(classElement1);
    }

    /**
     * Teardown routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * Demo test.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testDemoTransform() throws Exception {
        // let's create first add action without namespace
        // Note that it was just creation and actor don't added to model
        AddClassAction addClass = new AddClassAction(classElement, manager);

        // After execution classElement was add to model
        addClass.execute();

        // Now we can use undo and redo actions
        // As a result classElement was deleted from model
        addClass.undo();

        // As a result classElement was added to model again
        addClass.redo();

        // Now let copy actor to namespace, for this target we should create
        // copy action and execute it.
        CopyClassAction copyClass = new CopyClassAction(classElement, clipboard);
        copyClass.execute();

        /*
         * Now actor is in clipboard and we need to paste it in needed
         * namespace. Paste action has such requirement that it can't get class
         * from clipboard directly. It just get Transferable instance and only
         * than put class to model(it wait for some action from graphical part).
         * For now image that user click paste and we get transferable from
         * clipboard. For example, user may click copy but than don't click
         * paste. He can copy some next model element that is why impossible
         * directly connect copy and paste action. Application may use
         * ClassElementsTransfer to check if clipboard contain right element For
         * now image that user click paste and we get transferable from
         * clipboard Component may define which paste action should be created
         * by using methods of transferable
         */
        Transferable trans = clipboard.getContents(null);
        if (trans.isDataFlavorSupported(ClassElementsTransfer.CLASS_FLAVOR)) {
            PasteClassAction pasteClass = new PasteClassAction(trans, namespace);
            pasteClass.execute();
        } else {
            // Provide some exception logic
        }

        // As a result classElement was deleted from model
        addClass.undo();

        // As a result classElement was added to model again
        addClass.redo();

        /*
         * For now we actually create second classElement let it be:
         * classElement1. Component may just receive it for making some action.
         * It doesn't have reference to it Then let provide deleting cutting and
         * pasting classElement as was mentioned in scenario. Note now we have
         * two classes
         */
        RemoveClassAction removeClass = new RemoveClassAction(classElement1);

        // we just deletes classElement1.
        removeClass.execute();

        CutClassAction cutClass = new CutClassAction(classElement);

        // the classElement was cut from the namespace.
        cutClass.execute();
        // For the addClass lost the owner of the clipboard, a warn log will be
        // given: Clipboard System contains Class

        // For classElement was already cut from the namespace, a warn log will
        // be given: Given element doesn't exist in the namespace.
        addClass.undo();

        // As a result classElement was added to model again
        addClass.redo();

        PasteClassAction pasteClass = new PasteClassAction(trans, namespace);

        // the classElement was added to the namespace again.
        pasteClass.execute();
        // For the addClass lost the owner of the clipboard, a warn log will be
        // given: Clipboard System contains Class

        // As a result classElement was deleted from model
        addClass.undo();

        // As a result classElement was added to model again
        addClass.redo();

        // after this operation we has only classElement and it is in given
        // namespace
    }
}