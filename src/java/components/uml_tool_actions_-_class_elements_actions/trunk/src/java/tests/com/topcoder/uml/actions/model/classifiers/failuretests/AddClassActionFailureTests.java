/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddClassAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddClassAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddClassActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for
     * <code>{@link AddClassAction#AddClassAction(com.topcoder.uml.model.core.classifiers.Class, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullClass() {
        assertConstructorException(AddClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, UMLModelManager.class}, new Object[] {null,
            new UMLModelManager()}, IllegalArgumentException.class,
            "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddClassAction#AddClassAction(Class, UMLModelManager)}</code> constructor.
     * </p>
     */
    public void testCtor_1_NullUMLModelManager() {
        assertConstructorException(AddClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, UMLModelManager.class}, new Object[] {new ClassImpl(),
            null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddClassAction#AddClassAction(com.topcoder.uml.model.core.classifiers.Class, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullClass() {
        assertConstructorException(AddClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, UMLModelManager.class, Namespace.class}, new Object[] {
            null, new UMLModelManager(), new PackageImpl()}, IllegalArgumentException.class,
            "If the class is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddClassAction#AddClassAction(com.topcoder.uml.model.core.classifiers.Class, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullUMLModelManager() {
        assertConstructorException(AddClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, UMLModelManager.class, Namespace.class}, new Object[] {
            new ClassImpl(), null, new PackageImpl()}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddClassAction#AddClassAction(com.topcoder.uml.model.core.classifiers.Class, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullNamespace() {
        assertConstructorException(AddClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, UMLModelManager.class, Namespace.class}, new Object[] {
            new ClassImpl(), new UMLModelManager(), null}, IllegalArgumentException.class,
            "If the namespace is null, should throw IllegalArgumentException");
    }
}
