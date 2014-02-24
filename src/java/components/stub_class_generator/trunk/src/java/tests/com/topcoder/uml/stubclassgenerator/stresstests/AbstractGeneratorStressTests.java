/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.stresstests;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.stubclassgenerator.AbstractGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for the AbstractGenerator class.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class AbstractGeneratorStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 10000;

    /**
     * <p>
     * This static member of class represents default value of namespace for ConfigurationManager.
     * It is needed for proper default configuration. This is immutable, only one possible value
     * &quot;com.topcoder.uml.stubclassgenerator&quot;.
     * </p>
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.uml.stubclassgenerator";

    /**
     * Represents the AbstractGeneratorMock instance used for tests.
     */
    private AbstractGeneratorMock testAbstractGenerator;

    /**
     * Represents the Classifier of TestClassA instance used for tests.
     */
    private Classifier testClassifierA;

    /**
     * Represents the Classifier of TestClassB instance used for tests.
     */
    private Classifier testClassifierB;

    /**
     * Represents the Package1 instance used for tests.
     */
    private Package testPackage1;

    /**
     * Represents the Package2 instance used for tests.
     */
    private Package testPackage2;

    /**
     * Represents the add operation instance used for tests.
     */
    private Operation add;

    /**
     * Represents the class documentation used for tests.
     */
    private String testDocumentation;

    /**
     * <p>
     * Mock class of AbstractGenerator, used for test.
     * </p>
     */
    private class AbstractGeneratorMock extends AbstractGenerator {
        /**
         * <p>
         * Constructor, used to test base constructor.
         * </p>
         *
         * @param namespace
         *            String with namespace of configuration file, non null non empty
         * @throws GeneratorConfigurationException
         *             appears problems in configuration process
         */
        public AbstractGeneratorMock(String namespace) throws GeneratorConfigurationException {
            super(namespace);
        }

        /**
         * <p>
         * Provides creates full code for Classifier and return it, do nothing here.
         * </p>
         *
         * @param classifier
         *            Classifier instance, null impossible
         * @return null.
         */
        public String createClassifierCode(Classifier classifier) {
            return null;
        }
    }

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             appears problems in set up process
     */
    protected void setUp() throws Exception {
        StressTestsHelper.loadConfig();

        // create a class TestClassA which contains a method
        // TestClassB add(TestClassB a, TestClassB b);
        testAbstractGenerator = new AbstractGeneratorMock(DEFAULT_NAMESPACE);
        Model model = new ModelImpl();

        testPackage1 = new PackageImpl();
        testPackage1.setName("com");
        testPackage1.setNamespace(model);
        model.addOwnedElement(testPackage1);

        testPackage2 = new PackageImpl();
        testPackage2.setName("topcoder");

        testPackage2.setNamespace(testPackage1);
        testPackage1.addOwnedElement(testPackage1);

        testClassifierA = new ClassImpl();
        testClassifierA.setName("TestClassA");
        testClassifierA.setNamespace(testPackage2);
        testPackage2.addOwnedElement(testClassifierA);

        testClassifierB = new ClassImpl();
        testClassifierA.setName("TestClassB");
        testClassifierB.setNamespace(testPackage2);
        testPackage2.addOwnedElement(testClassifierB);

        // add general documentation
        testDocumentation = "Test class a contains method add(TestClassB a, TestClassB b)";
        TaggedValue docTag = new TaggedValueImpl();
        docTag.setDataValue(testDocumentation);
        TagDefinition docDef = new TagDefinitionImpl();
        docDef.setTagType("documentation");
        docTag.setType(docDef);
        testClassifierA.addTaggedValue(docTag);

        // add @author tag
        TaggedValue authorTag = new TaggedValueImpl();
        authorTag.setDataValue("TCSDEVELOPER");
        TagDefinition tagDocDef = new TagDefinitionImpl();
        tagDocDef.setTagType("documentation#author");
        authorTag.setType(tagDocDef);
        testClassifierA.addTaggedValue(authorTag);

        // add method TestClassB add(TestClassB a, TestClassB b);
        add = new OperationImpl();
        add.setName("add");
        add.setVisibility(VisibilityKind.PUBLIC);
        TaggedValue addDocumentation = new TaggedValueImpl();
        addDocumentation.setType(docDef);
        addDocumentation.setDataValue("Return the sum of two TestClass.");

        // return parameter
        Parameter rt = new ParameterImpl();
        rt.setKind(ParameterDirectionKind.RETURN);
        rt.setName("sum");
        TaggedValue rtDoc = new TaggedValueImpl();
        rtDoc.setDataValue("Sum of two TestClassB.");
        rtDoc.setType(docDef);
        rt.addTaggedValue(rtDoc);
        rt.setType(testClassifierB);
        add.addParameter(rt);

        // parameter a
        Parameter a = new ParameterImpl();
        a.setKind(ParameterDirectionKind.IN);
        a.setName("a");
        TaggedValue aDoc = new TaggedValueImpl();
        aDoc.setDataValue("TestClassB a to add.");
        aDoc.setType(docDef);
        a.addTaggedValue(aDoc);
        a.setType(testClassifierB);
        add.addParameter(a);

        // parameter b
        Parameter b = new ParameterImpl();
        b.setKind(ParameterDirectionKind.IN);
        b.setName("b");
        TaggedValue bDoc = new TaggedValueImpl();
        bDoc.setDataValue("TestClassB b to add.");
        bDoc.setType(docDef);
        b.addTaggedValue(bDoc);
        b.setType(testClassifierB);
        add.addParameter(b);
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
     * <p>
     * Stress test the method of <code>checkClassifier(Classifier)</code>.
     * </p>
     */
    public void testCheckClassifier() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testAbstractGenerator.checkClassifier(new ClassImpl());
            testAbstractGenerator.checkClassifier(new InterfaceImpl());
            testAbstractGenerator.checkClassifier(new EnumerationImpl());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "checkClassifier(Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Stress test the method of <code>getPackage(Classifier)</code>.
     * </p>
     */
    public void testGetPackageClassifier() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testAbstractGenerator.getPackage(testClassifierA);
            testAbstractGenerator.getPackage(testClassifierB);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "getPackage(Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Stress test the method of <code>getPackage(Package)</code>.
     * </p>
     */
    public void testGetPackagePackage() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testAbstractGenerator.getPackage(testPackage2);
            testAbstractGenerator.getPackage(testPackage1);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "getPackage(Package) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }
}