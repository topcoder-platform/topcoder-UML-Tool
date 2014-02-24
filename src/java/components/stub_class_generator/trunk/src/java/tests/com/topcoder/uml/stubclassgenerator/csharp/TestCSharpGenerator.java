/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.csharp;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
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
 * Unit tests for the class {@link CSharpGenerator}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCSharpGenerator extends AbstractGeneratorTestCase {
    /**
     * The uut's name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * The unit under test.
     */
    private CSharpGenerator uut;

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
        this.uut = new CSharpGenerator(NAMESPACE);
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
     * <b>Failure test</b> for method CSharpGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCSharpGeneratorStringFailureNullNamespace()
        throws Exception {
        try {
            new CSharpGenerator(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method CSharpGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = &quot;  &quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testCSharpGeneratorStringFailureEmptyNamespace()
        throws Exception {
        try {
            new CSharpGenerator("   ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public static Type attribName;
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildAttributeAccuracy1() throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PUBLIC);
        attribute.setOwnerScope(ScopeKind.CLASSIFIER);
        attribute.setChangeability(ChangeableKind.CHANGEABLE);
        attribute.setName("attribName");
        attribute.setType(this.createClass("Type", "System.foo"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});

        assertEquals("code", "public static Type attribName;", result.toString().trim());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  private const int attribName = 123;
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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

        this.assertText("private const int attribName = 123;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  protected internal const int attribName = 123;
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildAttributeAccuracy3() throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setName("attribName");

        this.addStereotype(attribute, "protected internal_");

        attribute.setType(this.createPrimitive("int"));

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});
        this.assertText("protected internal const int attribName = 123;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildAttribute(Attribute).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  new readonly protected internal const int attribName = 123;
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildAttributeAccuracy4() throws Exception {
        Attribute attribute = new AttributeImpl();
        attribute.setVisibility(VisibilityKind.PRIVATE);
        attribute.setOwnerScope(ScopeKind.INSTANCE);
        attribute.setChangeability(ChangeableKind.FROZEN);
        attribute.setName("attribName");

        this.addStereotype(attribute, "new_");
        this.addStereotype(attribute, "readonly_");
        this.addStereotype(attribute, "protected internal_");

        attribute.setType(this.createPrimitive("int"));

        this.setInitialValue(attribute, "123");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildAttribute", new Class[] {Attribute.class, StringBuilder.class},
            new Object[] {attribute, result});
        this.assertText("new readonly protected internal const int attribName = 123;", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  private class Class
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass1()
        throws Exception {
        ClassImpl classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setLeaf(true);
        classifier.setName("Class");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});
        this.assertText("private class Class", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  private abstract class Class : Class1, Interface1
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass2()
        throws Exception {
        ClassImpl classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setAbstract(true);
        classifier.setName("Class");

        this.addGeneralization(classifier, this.createClass("Class1", "com.topcoder"));
        this.addGeneralization(classifier, this.createInterface("Interface1", "com.topcoder"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("private abstract class Class : Class1, Interface1", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  private abstract class Class : Class1, Interface1, Interface2
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyClass3()
        throws Exception {
        ClassImpl classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PRIVATE);
        classifier.setAbstract(true);
        classifier.setName("Class");

        this.addGeneralization(classifier, this.createClass("Class1", "com.topcoder"));
        this.addGeneralization(classifier, this.createInterface("Interface1", "com.topcoder"));
        this.addGeneralization(classifier, this.createInterface("Interface2", "com.topcoder"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("private abstract class Class : Class1, Interface1, Interface2", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public interface Interface
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyInterface1()
        throws Exception {
        Interface classifier = new InterfaceImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Interface");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("public interface Interface", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public interface Interface : Interface1
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyInterface2()
        throws Exception {
        Interface classifier = new InterfaceImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Interface");

        this.addGeneralization(classifier, this.createInterface("Interface1", "com.topcoder"));

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("public interface Interface : Interface1", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildClassifierHeader(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a classifier
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public enumeration Enumeration
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildClassifierHeaderAccuracyEnumeration1()
        throws Exception {
        Enumeration classifier = new EnumerationImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("Enumeration");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildClassifierHeader",
            new Class[] {Classifier.class, StringBuilder.class}, new Object[] {classifier, result});

        this.assertText("public enum Enumeration", result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  an operation
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public abstract void test(String s) {
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  an operation
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  protected const static double test(String s, int i) {
     *      return 0;
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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
        expected.append("protected const static double test(String s, int i) {\n");
        expected.append("    return 0;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  an operation
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  protected const static String test(String s, int i) {
     *      return null;
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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
        expected.append("protected const static String test(String s, int i) {\n");
        expected.append("    return null;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  an operation
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  protected const static boolean test(String s, int i) {
     *      return false;
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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
        this.addParameter(operation, "", this.createPrimitive("bool"), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("protected const static bool test(String s, int i) {\n");
        expected.append("    return false;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  an operation
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  new virtual protected const static MyEnum test(String s, int i) {
     *      return false;
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildOperationAccuracy5() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(false);
        operation.setVisibility(VisibilityKind.PROTECTED);
        operation.setLeaf(true);
        operation.setOwnerScope(ScopeKind.CLASSIFIER);
        operation.setConcurrency(CallConcurrencyKind.GUARDED);
        operation.setName("test");

        this.addParameter(operation, "s", this.createClass("String", "java.lang"), "");
        this.addStereotype(operation, "new_");
        this.addStereotype(operation, "virtual_");
        this.addParameter(operation, "i", this.createPrimitive("int"), "");
        this.addParameter(operation, "", this.createEnumeration("MyEnum"), "").setKind(ParameterDirectionKind.RETURN);

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("new virtual protected const static MyEnum test(String s, int i) {\n");
        expected.append("    return 0;\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a property
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public int test {
     *  set{};
     *  get{};
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildOperationAccuracyProperty1() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(true);
        operation.setVisibility(VisibilityKind.PUBLIC);
        operation.setName("test");

        this.addParameter(operation, "", this.createPrimitive("int"), "").setKind(ParameterDirectionKind.RETURN);
        this.addStereotype(operation, "property_");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public int test {\n");
        expected.append("    set {}\n");
        expected.append("    get {\n");
        expected.append("        return 0;\n");
        expected.append("    }\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a property
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public int test {
     *  get{};
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildOperationAccuracyProperty2() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(true);
        operation.setVisibility(VisibilityKind.PUBLIC);
        operation.setName("test");

        this.addParameter(operation, "", this.createPrimitive("int"), "").setKind(ParameterDirectionKind.RETURN);
        this.addStereotype(operation, "property_get_");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public int test {\n");
        expected.append("    get {\n");
        expected.append("        return 0;\n");
        expected.append("}\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildOperation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a property
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public int test {
     *  set{};
     *  }
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildOperationAccuracyProperty3() throws Exception {
        Operation operation = new OperationImpl();
        operation.setAbstract(true);
        operation.setVisibility(VisibilityKind.PUBLIC);
        operation.setName("test");

        this.addParameter(operation, "", this.createPrimitive("int"), "").setKind(ParameterDirectionKind.RETURN);
        this.addStereotype(operation, "property_set_");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildOperation", new Class[] {Operation.class, StringBuilder.class},
            new Object[] {operation, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public int test {\n");
        expected.append("    set {}\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Accuracy test</b> for method buildDelegate(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a delegate
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  public delegate int test(String s);
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testbuildDelegateAccuracy() throws Exception {
        Classifier classifier = new ClassImpl();
        classifier.setVisibility(VisibilityKind.PUBLIC);
        classifier.setName("test");

        this.addStereotype(classifier, "delegate_");

        Operation op = this.addOperation(classifier, "test", null);
        op.clearParameters();
        this.addParameter(op, "", this.createPrimitive("int"), "").setKind(ParameterDirectionKind.RETURN);
        this.addParameter(op, "s", this.createClass("String", ""), "");

        StringBuilder result = new StringBuilder();
        TestHelper.callPrivateMethod(this.uut, "buildDelegate", new Class[] {Classifier.class, StringBuilder.class},
            new Object[] {classifier, result});

        StringBuilder expected = new StringBuilder();
        expected.append("public delegate int test(String s);\n");

        this.assertText(expected.toString(), result.toString());
    }

    /**
     * <b>Failure test</b> for method createClassifierCode(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  classifier = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateClassifierCodeClassifierFailureNullClassifier()
        throws Exception {
        try {
            this.uut.createClassifierCode(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a class
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  using this.is.my.package;
     *  *** an empty class
     *  *** &lt;author&gt;
     *  *** TCSDEVELOPER
     *  *** &lt;/author&gt;
     *  *** &lt;version&gt;
     *  *** 1.0
     *  *** &lt;/version&gt;
     *  namespace this.is.my.package {
     *      public class Foo {
     *      }
     *  }
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
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
        expected.append("/// an empty class\n");
        expected.append("/// <author>\n");
        expected.append("/// TCSDEVELOPER\n");
        expected.append("/// </author>\n");
        expected.append("/// <version>\n");
        expected.append("/// 1.0\n");
        expected.append("/// </version>\n");
        expected.append("namespace this.is.my.package {\n");
        expected.append("    public class Foo{\n");
        expected.append("    }\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result);
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a class
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  using this.is.my.package;
     *  *** an empty class
     *  *** &lt;author&gt;
     *  *** TCSDEVELOPER
     *  *** &lt;/author&gt;
     *  *** &lt;version&gt;
     *  *** 1.0
     *  *** &lt;/version&gt;
     *      public class Foo {
     *      }
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateClassifierCodeAccuracyEmptyClassNoPackage()
        throws Exception {
        Classifier classifier = this.createClass("Foo", "");
        classifier.setVisibility(VisibilityKind.PUBLIC);

        this.setGeneralDocumentation(classifier, "an empty class");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        String result = this.uut.createClassifierCode(classifier);

        StringBuilder expected = new StringBuilder();
        expected.append("/// an empty class\n");
        expected.append("/// <author>\n");
        expected.append("/// TCSDEVELOPER\n");
        expected.append("/// </author>\n");
        expected.append("/// <version>\n");
        expected.append("/// 1.0\n");
        expected.append("/// </version>\n");
        expected.append("    public class Foo{\n");
        expected.append("    }\n");

        this.assertText(expected.toString(), result);
    }

    /**
     * <b>Accuracy test</b> for method createClassifierCode(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  a class
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  using this.is.my.package;
     *  *** an empty class
     *  *** &lt;author&gt;
     *  *** TCSDEVELOPER
     *  *** &lt;/author&gt;
     *  *** &lt;version&gt;
     *  *** 1.0
     *  *** &lt;/version&gt;
     *  namespace this.is.my.package {
     *      public class Foo {
     *      }
     *  }
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateClassifierCodeAccuracy() throws Exception {
        Classifier classifier = this.createClass("Foo", "this.is.my.package");
        classifier.setVisibility(VisibilityKind.PUBLIC);

        this.setGeneralDocumentation(classifier, "an empty class");
        this.addTaggedDocumentation(classifier, "author", "TCSDEVELOPER");
        this.addTaggedDocumentation(classifier, "version", "1.0");

        String result = this.uut.createClassifierCode(classifier);

        StringBuilder expected = new StringBuilder();
        expected.append("/// an empty class\n");
        expected.append("/// <author>\n");
        expected.append("/// TCSDEVELOPER\n");
        expected.append("/// </author>\n");
        expected.append("/// <version>\n");
        expected.append("/// 1.0\n");
        expected.append("/// </version>\n");
        expected.append("namespace this.is.my.package {\n");
        expected.append("    public class Foo{\n");
        expected.append("    }\n");
        expected.append("}\n");

        this.assertText(expected.toString(), result);
    }
}
