/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.stubclassgenerator.stresstests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
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
import com.topcoder.uml.stubclassgenerator.CodeGenerationException;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for the CodeGenerator class.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class CodeGeneratorStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 100;

    /**
     * Represents the AbstractGeneratorMock instance used for tests.
     */
    private CodeGenerator testCodeGenerator;

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
     * Represents the sum attribute instance used for tests.
     */
    private Attribute sum;

    /**
     * Represents the class documentation used for tests.
     */
    private String testDocumentation;

    /**
     * Represents classifiers used for tests.
     */
    private List<Classifier> testClassifiers;

    /**
     * Represents packages used for tests.
     */
    private List<Package> testPackages;

    /**
     * Represents the location where code were be generated.
     */
    private String theLocation = "test_files\\stresstests\\";

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             appears problems in set up process
     */
    protected void setUp() throws Exception {
        StressTestsHelper.loadConfig();

        testCodeGenerator = new CodeGenerator();
        // create a class TestClassA which contains a method
        // TestClassB add(TestClassB a, TestClassB b);
        Model model = new ModelImpl();

        testPackage1 = new PackageImpl();
        testPackage1.setName("com");
        testPackage1.setNamespace(model);
        model.addOwnedElement(testPackage1);

        testPackage2 = new PackageImpl();
        testPackage2.setName("topcoder");

        Package testPackage3 = new PackageImpl();
        testPackage3.setName("google");

        testPackage2.setNamespace(testPackage1);
        testPackage1.addOwnedElement(testPackage2);

        testPackage3.setNamespace(testPackage1);
        testPackage1.addOwnedElement(testPackage3);

        testClassifierA = new ClassImpl();
        testClassifierA.setVisibility(VisibilityKind.PUBLIC);
        testClassifierA.setName("TestClassA");
        testClassifierA.setNamespace(testPackage2);
        testPackage2.addOwnedElement(testClassifierA);

        TagDefinition docDef = new TagDefinitionImpl();
        docDef.setTagType("documentation");

        testClassifierB = new ClassImpl();
        testClassifierB.setVisibility(VisibilityKind.PUBLIC);
        testClassifierB.setName("TestClassB");
        testClassifierB.setNamespace(testPackage3);
        TaggedValue bDocTag = new TaggedValueImpl();
        bDocTag.setDataValue("ClassB used to add.");
        bDocTag.setType(docDef);
        testClassifierB.addTaggedValue(bDocTag);
        testPackage3.addOwnedElement(testClassifierB);

        // add general documentation to class a
        testDocumentation = "Test class a contains method add(TestClassB a, TestClassB b)";
        TaggedValue aDocTag = new TaggedValueImpl();
        aDocTag.setDataValue(testDocumentation);
        aDocTag.setType(docDef);
        testClassifierA.addTaggedValue(aDocTag);

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
        add.setOwner(testClassifierA);
        TaggedValue addDocumentation = new TaggedValueImpl();
        addDocumentation.setType(docDef);
        addDocumentation.setDataValue("Return the sum of two TestClass.");
        add.addTaggedValue(addDocumentation);

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

        sum = new AttributeImpl();
        sum.setName("lastSum");
        sum.setVisibility(VisibilityKind.PRIVATE);
        sum.setType(testClassifierB);
        TaggedValue sumDocumentation = new TaggedValueImpl();
        sumDocumentation.setType(docDef);
        sumDocumentation.setDataValue("sum of last add operation.");
        sum.addTaggedValue(sumDocumentation);

        testClassifierA.setLeaf(true);
        testClassifierA.addFeature(sum);
        testClassifierA.addFeature(add);

        testClassifiers = new ArrayList<Classifier>();
        testClassifiers.add(testClassifierA);

        testPackages = new ArrayList<Package>();
        testPackages.add(testPackage1);
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
     * Stress test the <code>GenerateCode(String, String, Classifier)</code>.
     * </p>
     *
     * @throws CodeGenerationException
     *             when appears problems with writing files or appears configuration exception
     */
    public void testGenerateCodeStringStringClassifier() throws CodeGenerationException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testCodeGenerator.generateCode("java", theLocation, testClassifierA);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "GenerateCode(String, String, Classifier) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        File file = new File(theLocation + "com\\topcoder\\TestClassA.java");
        assertTrue("Generator classifier incorrectly.", file.exists());
    }

    /**
     * <p>
     * Stress test the <code>GenerateCode(String, String, List)</code>.
     * </p>
     *
     * @throws CodeGenerationException
     *             when appears problems with writing files or appears configuration exception
     */
    public void testGenerateCodeForClassifiers() throws CodeGenerationException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testCodeGenerator.generateCodeForClassifiers("c#", theLocation, testClassifiers);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "GenerateCode(String, String, List) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        File file = new File(theLocation + "com\\topcoder\\TestClassA.cs");
        assertTrue("Generator classifier incorrectly.", file.exists());
    }

    /**
     * <p>
     * Stress test the <code>GenerateCode(String, String, Package)</code>.
     *</p>
     *
     * @throws CodeGenerationException
     *             when appears problems with writing files or appears configuration exception
     */
    public void testGenerateCodeStringStringPackage() throws CodeGenerationException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testCodeGenerator.generateCode("java", theLocation, testPackage1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "GenerateCode(String, String, Package) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        File fileA = new File(theLocation + "com\\topcoder\\TestClassA.java");
        assertTrue("Generator classifier incorrectly.", fileA.exists());
        File fileB = new File(theLocation + "com\\google\\TestClassB.java");
        assertTrue("Generator classifier incorrectly.", fileB.exists());
        StressTestsHelper.printFile(fileA);
        StressTestsHelper.printFile(fileB);
    }



    /**
     * <p>
     * Stress test the <code>GenerateCode(String, String, List)</code>.
     * </p>
     *
     * @throws CodeGenerationException
     *             when appears problems with writing files or appears configuration exception
     */
    public void testGenerateCodeForPackages() throws CodeGenerationException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            testCodeGenerator.generateCodeForPackages("c#", theLocation, testPackages);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "GenerateCode(String, String, List) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        File fileA = new File(theLocation + "com\\topcoder\\TestClassA.cs");
        assertTrue("Generator classifier incorrectly.", fileA.exists());
        File fileB = new File(theLocation + "com\\google\\TestClassB.cs");
        assertTrue("Generator classifier incorrectly.", fileB.exists());
        StressTestsHelper.printFile(fileA);
        StressTestsHelper.printFile(fileB);
    }
}
