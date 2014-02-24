/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.java;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.stubclassgenerator.AbstractGeneratorTestCase;
import com.topcoder.uml.stubclassgenerator.MyLogger;
import com.topcoder.uml.stubclassgenerator.TestHelper;
import com.topcoder.util.config.ConfigManager;


/**
 * Unit tests for the class {@link JavaGenerator}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestJavaGenerator extends AbstractGeneratorTestCase {
    /**
     * The uut's name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * The unit under test.
     */
    private JavaGenerator uut;

    /**
     * Set up the fixture.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.clearConfigManager();
        ConfigManager.getInstance().add("config.xml");
        this.uut = new JavaGenerator(NAMESPACE);
        MyLogger.clear();
    }

    /**
     * Clears the config manager.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfigManager();
    }

    /**
     * <b>Failure test</b> for method createClassifierCode(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * **************************** Faulty input **********************************
     * ****************************************************************************
     * classifier = null
     *
     * ****************************************************************************
     * *************************** Expected behaviour *****************************
     * ****************************************************************************
     * * IllegalArgumentException should be thrown
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testcreateClassifierCodeClassifierFailureNullClassifier()
        throws Exception {
        Classifier classifier = null;

        try {
            this.uut.createClassifierCode(classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public static String attribName;
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildAttributeAccuracy1() throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PUBLIC);
        attribute.setOwnerScope(ScopeKind.CLASSIFIER);
        attribute.setChangeability(ChangeableKind.CHANGEABLE);
        attribute.setName("attribName");
        attribute.setType(this.createClass("String", "java.lang"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        this.assertText("public static String attribName;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private final int attribName = 123;
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildAttributeAccuracy2() throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setName("attribName");
        attribute.setType(this.createPrimitive("int"));

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        this.assertText("private final int attribName = 123;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private final attribName = 123;
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildAttributeAccuracyMissingTypeName()
        throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setName("attribName");
        attribute.setType(this.createPrimitive(null));

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        this.assertText("private final attribName = 123;", result.toString());
        assertEquals("number of logs", 1, MyLogger.getLogs().size());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private final int = 123;
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildAttributeAccuracyMissingAtributeName()
        throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setType(this.createPrimitive("int"));

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        this.assertText("private final int  = 123;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private final attribName = 123;
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildAttributeAccuracyMissingType()
        throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setName("attribName");

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        this.assertText("private final attribName = 123;", result.toString());
        assertEquals("number of logs", 1, MyLogger.getLogs().size());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * an operation
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public abstract void test(String s) {
     * }
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildOperationAccuracy1() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(true);
        operation.setVisibility(VisibilityKind.PUBLIC);
        operation.setLeaf(false);
        operation.setConcurrency(null);
        operation.setName("test");

        this.addParameter(operation, "s", this.createClass("String", ""), "");
        this.addParameter(operation, "", this.createPrimitive("void"), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public abstract void test(String s) {\n");
        expected.append("}\n");
        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * an operation
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * protected final static synchronized double test(String s, int i) {
     *     return 0;
     * }
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildOperationAccuracy2() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(false);
        operation.setVisibility(VisibilityKind.PROTECTED);
        operation.setLeaf(true);
        operation.setOwnerScope(ScopeKind.CLASSIFIER);
        operation.setConcurrency(CallConcurrencyKind.GUARDED);
        operation.setName("test");

        this.addParameter(operation, "s", this.createClass("String", ""), "");
        this.addParameter(operation, "i", this.createPrimitive("int"), "");
        this.addParameter(operation, "", this.createPrimitive("double"), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("protected final static synchronized double test(String s, int i) {\n");
        expected.append("    return 0;\n");
        expected.append("}\n");
        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * an operation
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * protected final static synchronized String test(String s, int i) {
     *     return null;
     * }
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildOperationAccuracy3() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(false);
        operation.setVisibility(VisibilityKind.PROTECTED);
        operation.setLeaf(true);
        operation.setOwnerScope(ScopeKind.CLASSIFIER);
        operation.setConcurrency(CallConcurrencyKind.GUARDED);
        operation.setName("test");

        this.addParameter(operation, "s", this.createClass("String", ""), "");
        this.addParameter(operation, "i", this.createPrimitive("int"), "");
        this.addParameter(operation, "", this.createClass("String", ""), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("protected final static synchronized String test(String s, int i) {\n");
        expected.append("    return null;\n");
        expected.append("}\n");
        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * an operation
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * protected final static synchronized boolean test(String s, int i) {
     *     return false;
     * }
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildOperationAccuracy4() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(false);
        operation.setVisibility(VisibilityKind.PROTECTED);
        operation.setLeaf(true);
        operation.setOwnerScope(ScopeKind.CLASSIFIER);
        operation.setConcurrency(CallConcurrencyKind.GUARDED);
        operation.setName("test");

        this.addParameter(operation, "s", this.createClass("String", ""), "");
        this.addParameter(operation, "i", this.createPrimitive("int"), "");
        this.addParameter(operation, "", this.createPrimitive("boolean"), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("protected final static synchronized boolean test(String s, int i) {\n");
        expected.append("    return false;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * an operation
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public Foo(String s) {
     * }
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildOperationAccuracyConstructor()
        throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(false);
        operation.setVisibility(VisibilityKind.PUBLIC);
        operation.setConcurrency(null);
        operation.setName("Foo");

        this.addParameter(operation, "s", this.createClass("String", "java.lang"), "");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public Foo(String s) {\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private final class Class
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass1()
        throws Exception {
        Classifier classifier = this.createClass("Class", "");
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setLeaf(true);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("private final class Class", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private abstract class Class extends Class1 implements Interface1
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass2()
        throws Exception {
        Classifier classifier = this.createClass("Class", "");
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setAbstract(true);

        this.addGeneralization(classifier, this.createClass("Class1", "com.topcoder"));
        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        this.addGeneralization(classifier, this.createInterface("Interface1", "com.topcoder"));
        this.addInterface(classifier, this.createInterface("Interface1", "com.topcoder"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        assertEquals("code line", "private abstract class Class extends Class1 implements Interface1",
                result.toString());
    }

    /**
     * <p>
     * Adds an interface to given classifier.
     * </p>
     * @param classifier
     *            {@link Classifier} to add the {@link Interface} to
     * @param interface
     *            the interf {@link Interface}
     */
    private void addInterface(Classifier classifier, Interface interf) {
        Abstraction abstraction = new AbstractionImpl();
        abstraction.addSupplier(interf);
        abstraction.addClient(classifier);
        classifier.addClientDependency(abstraction);
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * private abstract class Class extends Class1 implements Interface1, Interface2
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass3()
        throws Exception {
        Classifier classifier = this.createClass("Class", "");
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setAbstract(true);

        this.addGeneralization(classifier, this.createClass("Class1", "com.topcoder"));
        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        this.addGeneralization(classifier, this.createInterface("Interface1", "com.topcoder"));
//        this.addGeneralization(classifier, this.createInterface("Interface2", "com.topcoder"));
        this.addInterface(classifier, this.createInterface("Interface1", "com.topcoder"));
        this.addInterface(classifier, this.createInterface("Interface2", "com.topcoder"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        assertEquals("code line", "private abstract class Class extends Class1 implements Interface1, Interface2",
            result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public interface Interface
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyInterface1()
        throws Exception {
        Interface classifier = new InterfaceImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Interface");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        assertEquals("code line", "public interface Interface", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public interface Interface extends Interface1
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyInterface2()
        throws Exception {
        Classifier classifier = this.createInterface("Interface", "");
        classifier.setVisibility(VisibilityKind.PUBLIC);

        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        Generalization interface1 = new GeneralizationImpl();
//        interface1.setParent(this.createInterface("Interface1", ""));
//        classifier.addGeneralization(interface1);
        this.addInterface(classifier, this.createInterface("Interface1", ""));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        assertEquals("code line", "public interface Interface extends Interface1", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a classifier
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * public enumeration Enumeration
     *
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyEnumeration1()
        throws Exception {
        Enumeration classifier = this.createEnumeration("Enumeration");
        classifier.setVisibility(VisibilityKind.PUBLIC);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        assertEquals("code line", "public enum Enumeration", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierStructure(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * an empty class
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierStructureAccuracyEmptyClass()
        throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "an empty class");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierStructure",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        StringBuilder expected = new StringBuilder();
        expected.append("/**\n");
        expected.append(" * an empty class\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierStructure(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * One attribute.
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * **
     * A boolean value.
     * **
     * private boolean bool;
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierStructureAccuracyOneAttribute()
        throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "One attribute.");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        Attribute att = this.addAttribute(classifier, "bool", VisibilityKind.PRIVATE, "boolean");
        this.setGeneralDocumentation(att, "A boolean value.");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierStructure",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        StringBuilder expected = new StringBuilder();
        expected.append("/**\n");
        expected.append(" * One attribute.\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("/**\n");
        expected.append(" * A boolean value.\n");
        expected.append("*/\n");
        expected.append("private boolean bool;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierStructure(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * A class with one method.
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * **
     * Some method.
     * *param s a String
     * **
     * public void foo(String s) {
     * }
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierStructureAccuracyOneMethod()
        throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "A class with one method.");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        Operation op = this.addOperation(classifier, "foo", VisibilityKind.PUBLIC);
        this.addParameter(op, "s", this.createClass("String", "java.lang"), "a String")
                .setKind(ParameterDirectionKind.IN);
        this.setGeneralDocumentation(op, "Some method.");

        StringBuilder result = new StringBuilder();

        TestHelper.callPrivateMethod(this.uut, "buildClassifierStructure",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        StringBuilder expected = new StringBuilder();
        expected.append("/**\n");
        expected.append(" * A class with one method.\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("/**\n");
        expected.append(" * Some method.\n");
        expected.append(" * @param s a String\n");
        expected.append("*/\n");
        expected.append("public void foo(String s) {\n");
        expected.append("}\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierStructure(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * With inner class.
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * **
     * Inner class.
     * **
     * private class InnerFoo {
     * }
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testbuildClassifierStructureAccuracyInnerClass()
        throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "With inner class.");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        Classifier innerClass = this.createInnerClass("InnerFoo", classifier);
        innerClass.setVisibility(VisibilityKind.PRIVATE);
        this.setGeneralDocumentation(innerClass, "Inner class.");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierStructure",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        StringBuilder expected = new StringBuilder();
        expected.append("/**\n");
        expected.append(" * With inner class.\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("/**\n");
        expected.append(" * Inner class.\n");
        expected.append("*/\n");
        expected.append("private class InnerFoo{\n");
        expected.append("}\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * an empty class
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testcreateClassifierCodeAccuracyEmptyClass()
        throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "an empty class");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        String result = this.uut.createClassifierCode(classifier);

        StringBuilder expected = new StringBuilder();
        expected.append("/**\n");
        expected.append(" * an empty class\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result);
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * package this.is.my.package;
     * **
     * an empty class
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testcreateClassifierCodeAccuracyEmptyClassInPackage()
        throws Exception {
        Classifier classifier = this.createClass("Foo", "this.is.my.package");
        classifier.setVisibility(VisibilityKind.PUBLIC);

        this.setGeneralDocumentation(classifier, "an empty class");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        String result = this.uut.createClassifierCode(classifier);

        StringBuilder expected = new StringBuilder();
        expected.append("package this.is.my.package;\n");
        expected.append("/**\n");
        expected.append(" * an empty class\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result);
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     * <pre>
     * ****************************************************************************
     * ******************************* input **************************************
     * ****************************************************************************
     * a class
     *
     * ****************************************************************************
     * *************************** Expected output ********************************
     * ****************************************************************************
     * **
     * One attribute.
     * *author TCSDEVELOPER
     * *version 1.0
     * **
     * public class Foo {
     * **
     * A value.
     * **
     * private Type bool;
     * }
     * </pre>
     * @throws Exception to JUnit.
     */
    public void testcreateClassifierCodeAccuracyOneAttribute()
        throws Exception {
        Classifier classifier = this.createClass("Foo", "");
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Foo");

        this.setGeneralDocumentation(classifier, "One attribute.");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        Attribute att = this.addAttribute(classifier, "bool", VisibilityKind.PRIVATE, "");
        att.setType(this.createClass("Type", "type.package"));
        this.setGeneralDocumentation(att, "A value.");

        String result = this.uut.createClassifierCode(classifier);

        StringBuilder expected = new StringBuilder();
        expected.append("import type.package.*;\n");
        expected.append("/**\n");
        expected.append(" * One attribute.\n");
        expected.append(" * @author TCSDEVELOPER\n");
        expected.append(" * @version 1.0\n");
        expected.append("*/\n");
        expected.append("public class Foo{\n");
        expected.append("/**\n");
        expected.append(" * A value.\n");
        expected.append("*/\n");
        expected.append("private Type bool;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result);
    }
}
