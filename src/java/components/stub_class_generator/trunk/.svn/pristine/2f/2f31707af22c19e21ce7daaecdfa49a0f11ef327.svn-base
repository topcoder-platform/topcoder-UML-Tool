/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.stubclassgenerator.accuracytests;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
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
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import com.topcoder.uml.stubclassgenerator.csharp.CSharpGenerator;

import com.topcoder.util.config.ConfigManager;

import java.util.Iterator;

import junit.framework.TestCase;

/**
 * Accuracy test cases for the <i>CSharpGenerator</i> class.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class CSharpGeneratorAccuracyTests extends TestCase {
    /**
     * The namespace used by the tests.
     */
    private static final String NAMESPACE = "accuracy.tests";

    /**
     * A constant representing the <i>void</i> data type.
     */
    private static final Classifier VOID = new DataTypeImpl();

    /**
     * The config manager.
     */
    private static final ConfigManager MANAGER = ConfigManager.getInstance();

    static {
        VOID.setName("void");
    }

    /**
     * A generator used by the tests.
     */
    private CSharpGenerator test;

    /**
     * A test package used by the tests.
     */
    private Package testPackage = new PackageImpl();

    /**
     * A test class used by the tests.
     */
    private Class testClass = new ClassImpl();

    /**
     * A child class used by the tests.
     */
    private Class testChildClass = new ClassImpl();

    /**
     * An interface used by the tests.
     */
    private Interface testInterface = new InterfaceImpl();

    /**
     * A child interface used by the tests.
     */
    private Interface childInterface = new InterfaceImpl();

    /**
     * An enumeration used by the tests.
     */
    private Enumeration testEnum = new EnumerationImpl();

    /**
     * Creates a new <code>TaggedValue</code> with the specified type and data value.
     *
     * @return a new <code>TaggedValue</code> with the specified type and data value
     * @param type the type
     * @param dataValue the data value
     */
    private static TaggedValue createTaggedValue(String type, String dataValue) {
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(type);
        tagDefinition.setName(type);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * Pre-test setup: initializes the configuration and sets up the member variables.
     *
     * @throws Exception if an unexpected exception occurs
     */
    public void setUp() throws Exception {
        MANAGER.add("accuracy_tests.xml");
        test = new CSharpGenerator(NAMESPACE);

        testChildClass.setName("ChildClass");

        testClass.setName("AccuracyTestClass");
        testClass.setVisibility(VisibilityKind.PUBLIC);
        testClass.setNamespace(testPackage);
        testClass.addTaggedValue(createTaggedValue("documentation", "Class documentation."));
        testClass.addTaggedValue(createTaggedValue("documentation#author", "TCSDEVELOPER"));
        testClass.addTaggedValue(createTaggedValue("documentation#version", "1.0"));

        testInterface.setName("AccuracyTestInterface");
        testInterface.setVisibility(VisibilityKind.PUBLIC);
        testInterface.addTaggedValue(createTaggedValue("documentation", "Interface documentation."));

        childInterface.setName("SomeOtherInterface");
        childInterface.setVisibility(VisibilityKind.PUBLIC);
        childInterface.addTaggedValue(createTaggedValue("documentation", "Interface documentation."));

        Generalization generalization = new GeneralizationImpl();
        generalization.setParent(testClass);
        testChildClass.addGeneralization(generalization);

        Generalization generalization2 = new GeneralizationImpl();
        generalization2.setParent(testInterface);
        testChildClass.addGeneralization(generalization2);

        Generalization generalization3 = new GeneralizationImpl();
        generalization3.setParent(childInterface);
        testChildClass.addGeneralization(generalization3);

        Generalization generalization4 = new GeneralizationImpl();
        generalization4.setParent(testInterface);
        childInterface.addGeneralization(generalization4);

        testEnum.setName("AccuracyTestEnum");
        testEnum.addTaggedValue(createTaggedValue("documentation", "Enumeration documentation."));
        testEnum.setVisibility(VisibilityKind.PUBLIC);

        testPackage.setName(NAMESPACE);
        testPackage.addOwnedElement(testClass);
        testPackage.addOwnedElement(testInterface);
        testPackage.addOwnedElement(testChildClass);
        testPackage.addOwnedElement(childInterface);
    }

    /**
     * Post-test cleanup: clears the configuration manager.
     *
     * @throws Exception if an unexpected exception occurs
     */
    public void tearDown() throws Exception {
        for (Iterator it = MANAGER.getAllNamespaces(); it.hasNext();) {
            MANAGER.removeNamespace((String) it.next());
        }
    }

    /**
     * Tests that the package is written correctly.
     */
    public void test_package() {
        String result = test.createClassifierCode(testClass);

        assertTrue("namespace not generated", result.contains("namespace " + NAMESPACE));
    }

    /**
     * Tests that the class docs are written correctly.
     */
    public void test_class_doc() {
        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("<summary>");
        i = results.indexOf("Class documentation", i);
        assertTrue("class doc not generated", i >= 0);
        assertTrue("author tag not generated", results.indexOf("<author>") >= 0);
        assertTrue("version tag not generated", results.indexOf("<version>") >= 0);
    }

    /**
     * Tests that the class header is written correctly.
     */
    public void test_class_header() {
        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("///");
        i = results.indexOf("public class AccuracyTestClass", i);
        assertTrue("class header generated incorrectly", i >= 0);
        assertFalse(": incorrectly generated", results.contains(":"));
        i = results.indexOf("{", i);
        assertTrue("{ not generated", i >= 0);
        i = results.indexOf("}", i);
        assertTrue("} not generated", i >= 0);
    }

    /**
     * Tests that an abstract class is written correctly.
     */
    public void test_abstract_class() {
        testClass.setVisibility(VisibilityKind.PACKAGE);
        testClass.setAbstract(true);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("///");
        i = results.indexOf("abstract class AccuracyTestClass", i);
        assertTrue("class header generated incorrectly", i >= 0);
        assertFalse("class header generated incorrectly", results.contains(":"));
        i = results.indexOf("{", i);
        assertTrue("{ not generated", i >= 0);
        i = results.indexOf("}", i);
        assertTrue("} not generated", i >= 0);
    }

    /**
     * Tests that a package private class is written correctly.
     */
    public void test_package_private_class() {
        testClass.setVisibility(VisibilityKind.PACKAGE);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("///");
        i = results.indexOf("class AccuracyTestClass", i);
        assertTrue("class header generated incorrectly", i >= 0);
        assertFalse("class header generated incorrectly", results.contains(":"));
        i = results.indexOf("{", i);
        assertTrue("{ not generated", i >= 0);
        i = results.indexOf("}", i);
        assertTrue("} not generated", i >= 0);
    }

    /**
     * Tests that an interface is written correctly.
     */
    public void test_interface() {
        String results = test.createClassifierCode(testInterface);

        int i = results.indexOf("///");
        i = results.indexOf("public interface AccuracyTestInterface", i);
        assertTrue("interface header generated incorrectly", i >= 0);
        assertFalse("interface header generated incorrectly", results.contains(":"));
        i = results.indexOf("{", i);
        assertTrue("{ not generated", i >= 0);
        i = results.indexOf("}", i);
        assertTrue("} not generated", i >= 0);
    }

    /**
     * Tests that an enumeration is written correctly.
     */
    public void test_enum() {
        String results = test.createClassifierCode(testEnum);

        int i = results.indexOf("///");
        i = results.indexOf("public enum AccuracyTestEnum", i);
        assertTrue("interface header generated incorrectly", i >= 0);
        assertFalse("interface header generated incorrectly", results.contains(":"));
        i = results.indexOf("{", i);
        assertTrue("{ not generated", i >= 0);
        i = results.indexOf("}", i);
        assertTrue("} not generated", i >= 0);
    }

    /**
     * Tests that a class that extends and implements is written correctly.
     */
    public void test_extend_implement() {
        String results = test.createClassifierCode(testChildClass);

        int i = results.indexOf("///");
        i = results.indexOf("class ChildClass : AccuracyTestClass, AccuracyTestInterface, SomeOtherInterface", i);
        assertTrue("class definition not found", i >= 0);
    }

    /**
     * Tests that a struct is written correctly.
     */
    public void test_struct() {
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("struct");
        testInterface.addStereotype(stereotype);

        String results = test.createClassifierCode(testInterface);
        int i = results.indexOf("///");
        i = results.indexOf("public struct AccuracyTestInterface", i);
        assertTrue("struct definition not found", i >= 0);
    }

    /**
     * Tests that an attribute document is written correctly.
     */
    public void test_attribute_doc() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));
        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        i = results.indexOf("///", i);
        i = results.indexOf("<summary>", i);
        i = results.indexOf("Attribute documentation.", i);
        assertTrue("attribute documentation is missing", i >= 0);
    }

    /**
     * Tests that an attribute is written correctly.
     */
    public void test_attribute() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));
        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        i = results.indexOf("private AccuracyTestClass attribute;", i);
        assertTrue("attribute declaration is missing", i >= 0);
    }

    /**
     * Tests that a const attribute is written correctly.
     */
    public void test_const_attribute() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.FROZEN);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));
        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        i = results.indexOf("private const AccuracyTestClass attribute;", i);
        assertTrue("attribute declaration is missing", i >= 0);
    }

    /**
     * Tests that a const static attribute is written correctly.
     */
    public void test_const_static_attribute() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.FROZEN);
        attr.setOwnerScope(ScopeKind.CLASSIFIER);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));
        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);

        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        assertTrue("attribute declaration is missing",
                   (results.indexOf("private const static AccuracyTestClass attribute;", i) >= 0)
                   || (results.indexOf("private static const AccuracyTestClass attribute;", i) >= 0));
    }

    /**
     * Tests that an attribute with a default value is written correctly.
     */
    public void test_attribute_value() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setOwnerScope(ScopeKind.CLASSIFIER);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        Expression expr = new ExpressionImpl();
        expr.setBody("\"test\"");
        attr.setInitialValue(expr);

        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        i = results.indexOf("private static AccuracyTestClass attribute = \"test\";", i);
        assertTrue("attribute declaration is missing", i >= 0);
    }

    /**
     * Tests that an internal static attribute is written correctly.
     */
    public void test_internal_static() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PACKAGE);
        attr.setOwnerScope(ScopeKind.CLASSIFIER);
        attr.setType(testClass);
        attr.setName("attribute");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("protected internal");
        attr.addStereotype(stereotype);

        Expression expr = new ExpressionImpl();
        expr.setBody("\"test\"");
        attr.setInitialValue(expr);

        testClass.addFeature(attr);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        assertTrue("{ is missing", i >= 0);
        i = results.indexOf("protected internal static AccuracyTestClass attribute = \"test\";", i);
        assertTrue("attribute declaration is missing", i >= 0);
    }

    /**
     * Tests that a method doc is written correctly.
     */
    public void test_method_doc() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);
        testClass.addFeature(method);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        i = results.indexOf("///", i);
        i = results.indexOf("Method documentation.", i);
        assertTrue("method docs missing", i >= 0);
    }

    /**
     * Tests that a method with tags is written correctly.
     */
    public void test_method_tags() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);
        testClass.addFeature(method);

        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(testClass);
        param1.addTaggedValue(createTaggedValue("documentation", "param1 doc"));
        method.addParameter(param1);
        Parameter param2 = new ParameterImpl();
        param2.setName("param2");
        param2.setType(testClass);
        param2.addTaggedValue(createTaggedValue("documentation", "param2 doc"));
        method.addParameter(param2);

        method.addTaggedValue(createTaggedValue("documentation#throws", "Exception"));

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        i = results.indexOf("Method documentation.", i);
        assertTrue("method docs missing", i >= 0);
        assertTrue("param1 doc not found", results.indexOf("<param name=\"param1\">", i) >= 0);
        assertTrue("param2 doc not found", results.indexOf("<param name=\"param2\">", i) >= 0);
        assertTrue("throws doc not found", results.indexOf("<throws>", i) >= 0);
    }

    /**
     * Tests that the method return doc is written correctly.
     */
    public void test_method_return_doc() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);
        testClass.addFeature(method);

        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(testClass);
        param1.addTaggedValue(createTaggedValue("documentation", "param1 doc"));
        method.addParameter(param1);
        Parameter param2 = new ParameterImpl();
        param2.setName("param2");
        param2.setType(testClass);
        param2.addTaggedValue(createTaggedValue("documentation", "param2 doc"));
        method.addParameter(param2);
        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("{");
        i = results.indexOf("{", i);
        i = results.indexOf("<returns>", i);
        assertTrue("returns not found", i >= 0);
        i = results.indexOf("return documentation", i);
        assertTrue("return documentation", i >= 0);
        i = results.indexOf("</returns>", i);
        assertTrue("</returns> not found", i >= 0);
    }

    /**
     * Tests that a constructor is written correctly.
     */
    public void test_constructor() {
        Operation ctor = new OperationImpl();
        ctor.setName("AccuracyTestClass");
        ctor.addTaggedValue(createTaggedValue("documentation", "Constructor doc."));
        ctor.setVisibility(VisibilityKind.PUBLIC);
        ctor.setOwner(testClass);
        testClass.addFeature(ctor);

        String results = test.createClassifierCode(testClass);
        assertTrue("missing ctor signature", results.contains("public AccuracyTestClass()"));
    }

    /**
     * Tests that the method signature is written correctly.
     */
    public void test_method_signature() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(VOID);
        ret.setKind(ParameterDirectionKind.RETURN);
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("public void method()"));
    }

    /**
     * Tests that the method return is written correctly.
     */
    public void test_method_return() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return doc"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("public AccuracyTestClass method()"));
    }

    /**
     * Tests that a static method is written correctly.
     */
    public void test_static_method() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);
        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(VOID);
        ret.setKind(ParameterDirectionKind.RETURN);
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("public static void method()"));
    }

    /**
     * Tests that an abstract method is written correctly.
     */
    public void test_abstract_method() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setAbstract(true);
        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(VOID);
        ret.setKind(ParameterDirectionKind.RETURN);
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("public abstract void method()"));
    }

    /**
     * Tests that a const method is written correctly.
     */
    public void test_const_method() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setLeaf(true);
        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(VOID);
        ret.setKind(ParameterDirectionKind.RETURN);
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("public const void method()"));
    }

    /**
     * Tests that the method params are written correctly.
     */
    public void test_method_params() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Method doc."));
        method.setVisibility(VisibilityKind.PUBLIC);
        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return doc"));
        method.addParameter(ret);
        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(testClass);
        param1.addTaggedValue(createTaggedValue("documentatoin", "param1 doc"));
        method.addParameter(param1);
        Parameter param2 = new ParameterImpl();
        param2.setName("param2");
        param2.setType(testClass);
        param2.addTaggedValue(createTaggedValue("documentation", "param2 doc"));
        method.addParameter(param2);
        method.addTaggedValue(createTaggedValue("documentation#see", "SomeClass"));
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("wrong method signature",
                   result.contains("public AccuracyTestClass "
                                   + "method1(AccuracyTestClass param1, AccuracyTestClass param2)"));
    }

    /**
     * Tests that an override method is written correctly.
     */
    public void test_method_override() {
        Operation method = new OperationImpl();
        method.setName("method");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        testClass.addFeature(method);

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("override");
        method.addStereotype(stereotype);

        Parameter ret = new ParameterImpl();
        ret.setType(VOID);
        ret.setKind(ParameterDirectionKind.RETURN);
        method.addParameter(ret);

        String results = test.createClassifierCode(testClass);
        assertTrue("wrong method signature", results.contains("override public void method()"));
    }

    /**
     * Tests that a destructor is written correctly.
     */
    public void test_destructor() {
        Operation method = new OperationImpl();
        method.setName("AccuracyTestClass");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        testClass.addFeature(method);

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("destructor");
        method.addStereotype(stereotype);
        method.setOwner(testClass);

        String results = test.createClassifierCode(testClass);
        System.out.println(results);
        assertTrue("wrong method signature", results.contains("public ~AccuracyTestClass()"));
    }

    /**
     * Tests that a property doc is written correctly.
     */
    public void test_property_doc() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Property documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("property");
        method.addStereotype(stereotype);
        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return doc"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String results = test.createClassifierCode(testClass);
        int i = results.indexOf("Property documentation.");
        results.indexOf("public TestClass method1", i);

        assertTrue("property is not generated properly", i >= 0);
        assertTrue("property is not generated properly", results.contains("set"));
        assertTrue("property is not generated properly", results.contains("get"));
    }

    /**
     * Tests that property accessors are written correctly.
     */
    public void test_property_accessors() {
        Operation method = new OperationImpl();
        method.setName("method1");
        method.addTaggedValue(createTaggedValue("documentation", "Property doc."));
        method.setVisibility(VisibilityKind.PUBLIC);
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("property_get");
        method.addStereotype(stereotype);
        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return doc"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String str = test.createClassifierCode(testClass);
        int temp = str.indexOf("Property doc.");
        str.indexOf("public TestClass method1", temp);

        assertTrue("property is not generated properly", temp >= 0);
        assertTrue("property is not generated properly", str.contains("get"));
    }

    /**
     * Tests that an attribute data type is imported.
     */
    public void test_import_attribute() {
        Class linkedList = new ClassImpl();
        linkedList.setName("List");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("System.Collection");

        model.addOwnedElement(pkg);
        pkg.setNamespace(model);

        pkg.addOwnedElement(linkedList);
        linkedList.setNamespace(pkg);

        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.CHANGEABLE);
        attr.setType(linkedList);
        attr.setName("attribute1");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute attr doc."));

        testClass.addFeature(attr);

        String str = test.createClassifierCode(testClass);
        assertTrue("createClassifierCode fails: import is not generated properly.",
                   str.contains("using System.Collection;"));
    }

    /**
     * Tests that a returned data type is written.
     */
    public void test_import_return() {
        Class linkedList = new ClassImpl();
        linkedList.setName("List");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("System.Collection");

        model.addOwnedElement(pkg);
        pkg.setNamespace(model);

        pkg.addOwnedElement(linkedList);
        linkedList.setNamespace(pkg);

        Operation opr1 = new OperationImpl();
        opr1.setName("method1");
        opr1.addTaggedValue(createTaggedValue("documentation", "Method doc."));
        opr1.setVisibility(VisibilityKind.PUBLIC);
        opr1.setLeaf(true);
        Parameter ret = new ParameterImpl();
        ret.setType(linkedList);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return doc"));
        opr1.addParameter(ret);
        testClass.addFeature(opr1);

        String str = test.createClassifierCode(testClass);
        assertTrue("createClassifierCode fails: import is not generated properly.",
                str.contains("using System.Collection;"));
    }

    /**
     * Tests that a parameter data type is imported.
     */
    public void test_import_parameter() {
        Class linkedList = new ClassImpl();
        linkedList.setName("List");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("System.Collection");

        model.addOwnedElement(pkg);
        pkg.setNamespace(model);

        pkg.addOwnedElement(linkedList);
        linkedList.setNamespace(pkg);

        Operation opr1 = new OperationImpl();
        opr1.setName("method1");
        opr1.addTaggedValue(createTaggedValue("documentation", "Method doc."));
        opr1.setVisibility(VisibilityKind.PUBLIC);
        opr1.setLeaf(true);
        Parameter param1 = new ParameterImpl();
        param1.setName("param1");
        param1.setType(linkedList);
        param1.addTaggedValue(createTaggedValue("documentation", "param1 doc"));
        opr1.addParameter(param1);
        testClass.addFeature(opr1);

        String str = test.createClassifierCode(testClass);
        assertTrue("createClassifierCode fails: import is not generated properly.",
                str.contains("using System.Collection;"));
    }
}
