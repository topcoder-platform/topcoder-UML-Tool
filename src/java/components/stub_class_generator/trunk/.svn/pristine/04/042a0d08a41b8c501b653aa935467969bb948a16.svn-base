/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.stubclassgenerator.stresstests;

import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.stubclassgenerator.java.JavaGenerator;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for the JavaGenerator class.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class JavaGeneratorStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 1000;

    /**
     * A place holder for JavaGenerator.
     */
    private JavaGenerator test;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             appears problems in set up process
     */
    protected void setUp() throws Exception {
        StressTestsHelper.loadConfig();
        test = new JavaGenerator(StressTestsHelper.NAMESPACE);
    }

    /**
     * Tear down test environment.
     *
     * @throws Exception any error occur when tear down test environment
     */
    protected void tearDown() throws Exception {
        StressTestsHelper.tearDownTest();
    }

    /**
     * Stress tests createClassifierCode. Tests that class header is printed correctly. Expected: public enum TestClass.
     */
    public void testCreateClassifierCodeWriteClassHeader() {
        Enumeration class1 = new EnumerationImpl();
        class1.setName("TestClass");
        class1.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("TestClass class doc."));
        class1.setVisibility(VisibilityKind.PUBLIC);

        Class classExtend = new ClassImpl();
        classExtend.setName("ClassExtend");
        StressTestsHelper.addClassifierToPackage(classExtend);
        Generalization generalization1 = new GeneralizationImpl();
        generalization1.setParent(classExtend);
        class1.addGeneralization(generalization1);

        Interface classImplement1 = new InterfaceImpl();
        classImplement1.setName("InterfaceImplement1");
        StressTestsHelper.addClassifierToPackage(classImplement1);
        Generalization generalization2 = new GeneralizationImpl();
        generalization2.setParent(classImplement1);
        class1.addGeneralization(generalization2);

        StressTestsHelper.addClassifierToPackage(class1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            test.createClassifierCode(class1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "createClassifierCode(Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

    }

    /**
     * Stress tests createClassifierCode. Tests that method docs is printed correctly.
     */
    public void testCreateClassifierCodeWriteMethodDoc() {
        Class class1 = StressTestsHelper.generateClass();
        Operation opr1 = new OperationImpl();
        opr1.setName("method1");
        opr1.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("Method doc."));
        opr1.setVisibility(VisibilityKind.PUBLIC);
        opr1.setOwnerScope(ScopeKind.CLASSIFIER);
        Parameter ret = new ParameterImpl();
        ret.setType(class1);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("return doc"));
        opr1.addParameter(ret);
        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(class1);
        param1.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("param1 doc"));
        opr1.addParameter(param1);
        Parameter param2 = new ParameterImpl();
        param2.setName("param2");
        param2.setType(class1);
        param2.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("param2 doc"));
        opr1.addParameter(param2);
        opr1.addTaggedValue(StressTestsHelper.createTagDocumentationTaggedValue("see", "SomeClass"));
        class1.addFeature(opr1);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            test.createClassifierCode(class1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "createClassifierCode(Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }
    /**
     * Stress tests createClassifierCode method. Tests that 'import ...' is generated correctly.
     */
    public void testCreateClassifierCodeWriteImport() {
        Class class1 = StressTestsHelper.generateClass();

        Class linkedList = new ClassImpl();
        linkedList.setName("LinkedList");
        linkedList.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("java.util");
        StressTestsHelper.addModelElementToNamespace(pkg, model);
        StressTestsHelper.addModelElementToNamespace(linkedList, pkg);

        Operation opr1 = new OperationImpl();
        opr1.setName("method1");
        opr1.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("Method doc."));
        opr1.setVisibility(VisibilityKind.PUBLIC);
        opr1.setLeaf(true);
        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(linkedList);
        param1.addTaggedValue(StressTestsHelper.createDocumentationTaggedValue("param1 doc"));
        opr1.addParameter(param1);
        class1.addFeature(opr1);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            test.createClassifierCode(class1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "createClassifierCode(Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }
}
