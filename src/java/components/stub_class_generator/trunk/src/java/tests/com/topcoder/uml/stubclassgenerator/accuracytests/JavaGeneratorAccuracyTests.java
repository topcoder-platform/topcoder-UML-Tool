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
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
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

import com.topcoder.uml.stubclassgenerator.java.JavaGenerator;

import com.topcoder.util.config.ConfigManager;

import java.util.Iterator;

import junit.framework.TestCase;

/**
 * Accuracy test cases for the <i>JavaGenerator</i> class.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class JavaGeneratorAccuracyTests extends TestCase {
    /**
     * The namespace used by the accuracy tests.
     */
    private static final String NAMESPACE = "accuracy.tests";

    /**
     * The configuration manager instance.
     */
    private static final ConfigManager MANAGER = ConfigManager.getInstance();

    /**
     * A package used by the accuracy tests.
     */
    private Package testPackage;

    /**
     * A class used by the accuracy tests.
     */
    private Class testClass;

    /**
     * A child class used by the accuracy tests.
     */
    private Class testChildClass;

    /**
     * An interface used by the accuracy tests.
     */
    private Interface testInterface;

    /**
     * A child interface used by the accuracy tests.
     */
    private Interface childInterface;

    /**
     * An enumeration used by the accuracy tests.
     */
    private Enumeration testEnum;

    /**
     * A <code>JavaGenerator</code> instance to test.
     */
    private JavaGenerator test;

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
     * Setup: loads the test configuration and initializes the objects.
     *
     * @throws Exception if an unexpected exception occurs
     */
    public void setUp() throws Exception {
        MANAGER.add("accuracy_tests.xml");
        test = new JavaGenerator(NAMESPACE);

        testClass = new ClassImpl();
        testPackage = new PackageImpl();
        testChildClass = new ClassImpl();
        testInterface = new InterfaceImpl();
        childInterface = new InterfaceImpl();
        testEnum = new EnumerationImpl();

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

        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        Generalization generalization2 = new GeneralizationImpl();
//        generalization2.setParent(testInterface);
//        testChildClass.addGeneralization(generalization2);
        addInterface(testChildClass, testInterface);

        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        Generalization generalization3 = new GeneralizationImpl();
//        generalization3.setParent(childInterface);
//        testChildClass.addGeneralization(generalization3);
        addInterface(testChildClass, childInterface);

        /*
         * BugFix: UML-9994
         * Realization information is stored in clientDependency list.
         */
        // old code
//        Generalization generalization4 = new GeneralizationImpl();
//        generalization4.setParent(testInterface);
//        childInterface.addGeneralization(generalization4);
        addInterface(childInterface, testInterface);

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
     * Clears the config manager.
     *
     * @throws Exception if an unexpected exception occurs
     */
    public void tearDown() throws Exception {
        for (Iterator it = MANAGER.getAllNamespaces(); it.hasNext();) {
            MANAGER.removeNamespace((String) it.next());
        }
    }

    /**
     * Tests that <code>CreateClassifierCode</code> generates the package correctly.
     */
    public void test_generate_package() {
        String result = test.createClassifierCode(testClass);
        assertTrue("package should be '" + NAMESPACE + "'", result.contains("package " + NAMESPACE + ";"));
    }

    /**
     * Tests that the class documentation is generated correctly.
     */
    public void test_generate_class_doc() {
        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("/**");
        assertTrue("/** not found", i >= 0);
        i = result.indexOf("Class documentation.", i);
        assertTrue("class documentation not found", i >= 0);
        i = result.indexOf("*/", i);
        assertTrue("*/ not found", i >= 0);
    }

    /**
     * Tests that the class-level tags (@author, @version, etc.) are generated correctly.
     */
    public void test_generate_class_doc_tags() {
        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("/**");
        assertTrue("/** not found", i >= 0);
        i = result.indexOf("@author TCSDEVELOPER", i);
        assertTrue("@author not found", i >= 0);
        i = result.indexOf("@version 1.0", i);
        assertTrue("@version not found", i >= 0);
        i = result.indexOf("*/", i);
        assertTrue("*/ not found", i >= 0);
    }

    /**
     * Tests that a public final class is generated correctly.
     */
    public void test_class_def_public_final() {
        testClass.setLeaf(true);

        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("*/");
        i = result.indexOf("public final class AccuracyTestClass", i);
        assertTrue("public final class not generated correctly", i >= 0);
        i = result.indexOf("{", i);
        assertTrue("{ not found", i >= 0);
        i = result.indexOf("}", i);
        assertTrue("} not found", i >= 0);
    }

    /**
     * Tests that a package private class is generated correctly.
     */
    public void test_class_def_package_private() {
        String result = test.createClassifierCode(testClass);
        testClass.setVisibility(VisibilityKind.PACKAGE);

        int i = result.indexOf("*/");
        i = result.indexOf("class AccuracyTestClass", i);
        assertTrue("class not generated correctly", i >= 0);
        i = result.indexOf("{", i);
        assertTrue("{ not found", i >= 0);
        i = result.indexOf("}", i);
        assertTrue("} not found", i >= 0);
    }

    /**
     * Tests that an abstract class is generated correctly.
     */
    public void test_class_def_abstract() {
        testClass.setAbstract(true);
        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("*/");
        i = result.indexOf("public abstract class AccuracyTestClass", i);
        assertTrue("public abstract class not generated correctly", i >= 0);
        i = result.indexOf("{", i);
        assertTrue("{ not found", i >= 0);
        i = result.indexOf("}", i);
        assertTrue("} not found", i >= 0);
    }

    /**
     * Tests that an interface is generated correctly.
     */
    public void test_interface_def() {
        String result = test.createClassifierCode(testInterface);

        int i = result.indexOf("*/");
        i = result.indexOf("public interface AccuracyTestInterface", i);
        assertTrue("public interface not generated correctly", i >= 0);
        i = result.indexOf("{", i);
        assertTrue("{ not found", i >= 0);
        i = result.indexOf("}", i);
        assertTrue("} not found", i >= 0);
    }

    /**
     * Tests that an enumeration is generated correctly.
     */
    public void test_enum_def() {
        String result = test.createClassifierCode(testEnum);

        int i = result.indexOf("*/");
        i = result.indexOf("public enum AccuracyTestEnum", i);
        assertTrue("public enum not generated correctly", i >= 0);
        i = result.indexOf("{", i);
        assertTrue("{ not found", i >= 0);
        i = result.indexOf("}", i);
        assertTrue("} not found", i >= 0);
    }

    /**
     * Tests that a class that extends and implements is generated correctly.
     */
    public void test_class_extends_implements() {
        String result = test.createClassifierCode(testChildClass);

        String expected =
            "class ChildClass extends AccuracyTestClass implements AccuracyTestInterface, SomeOtherInterface";

        assertTrue("should find " + expected, result.contains(expected));
    }

    /**
     * Tests that an interface that extends another interface is implemented correctly.
     */
    public void test_interface_extends() {
        String result = test.createClassifierCode(childInterface);

        String expected = "public interface SomeOtherInterface extends AccuracyTestInterface";

        assertTrue("should find " + expected, result.contains(expected));
    }

    /**
     * Tests that attribute documentation is generated correctly.
     */
    public void test_attribute_documentation() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setType(testClass);
        attr.setName("testAttr");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("{");
        i = result.indexOf("/**", i);
        assertTrue("missing /**", i >= 0);
        i = result.indexOf("Attribute documentation.");
        assertTrue("missing documentation", i >= 0);
        i = result.indexOf("*/", i);
        assertTrue("missing */", i >= 0);
        i = result.indexOf("private AccuracyTestClass testAttr;");
        assertTrue("missing attribute", i >= 0);
    }

    /**
     * Tests that a private attribute is generated correctly.
     */
    public void test_attribute_private() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.CHANGEABLE);
        attr.setType(testClass);
        attr.setName("testAttr");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);
        int i = result.indexOf("{");
        i = result.indexOf("private AccuracyTestClass testAttr;");
        assertTrue("missing attribute", i >= 0);
    }

    /**
     * Tests that a private final attribute is generated correctly.
     */
    public void test_attribute_private_final() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.FROZEN);
        attr.setType(testClass);
        attr.setName("testAttr");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);
        int i = result.indexOf("{");
        i = result.indexOf("private final AccuracyTestClass testAttr;");
        assertTrue("missing attribute", i >= 0);
    }

    /**
     * Tests that a package private static final attribute is generated correctly.
     */
    public void test_attribute_private_static_final() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.FROZEN);
        attr.setOwnerScope(ScopeKind.CLASSIFIER);
        attr.setType(testClass);
        attr.setName("testAttr");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);
        int i = result.indexOf("{");
        i = result.indexOf("private static final AccuracyTestClass testAttr;");
        assertTrue("missing attribute", i >= 0);
    }

    /**
     * Tests that a default attribute value is generated correctly.
     */
    public void test_attribute_value() {
        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.FROZEN);
        attr.setOwnerScope(ScopeKind.CLASSIFIER);
        attr.setType(testClass);
        attr.setName("testAttr");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        Expression expr = new ExpressionImpl();
        expr.setBody("\"test\"");
        attr.setInitialValue(expr);

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);
        int i = result.indexOf("{");
        i = result.indexOf("private static final AccuracyTestClass testAttr = \"test\";");
        assertTrue("missing attribute", i >= 0);
    }

    /**
     * Tests that method documentation is generated correctly.
     */
    public void test_method_doc() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);

        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("{");
        i = result.indexOf("/**", i);
        assertTrue("/** not found", i >= 0);
        i = result.indexOf("Method documentation.", i);
        assertTrue("*/", i >= 0);
        i = result.indexOf("*/", i);
        assertTrue("missing */", i >= 0);
    }

    /**
     * Tests that method tags are generated correctly.
     */
    public void test_method_tags() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);

        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);

        Parameter param1 = new ParameterImpl();
        param1.setType(testClass);
        param1.setName("param1");
        param1.addTaggedValue(createTaggedValue("documentation", "param1 documentation"));
        method.addParameter(param1);

        Parameter param2 = new ParameterImpl();
        param2.setType(testClass);
        param2.addTaggedValue(createTaggedValue("documentation", "param2 documentation"));
        param2.setName("param2");
        method.addParameter(param2);

        method.addTaggedValue(createTaggedValue("documentation#throws", "throws documentation"));

        String result = test.createClassifierCode(testClass);

        int i = result.indexOf("{");
        i = result.indexOf("/**", i);
        assertTrue("/** not found", i >= 0);
        i = result.indexOf("Method documentation.", i);
        assertTrue("missing method documentation", i >= 0);
        i = result.indexOf("@throws throws documentation", i);
        assertTrue("missing @throws", i >= 0);
        i = result.indexOf("@param param2 param2 documentation", i);
        assertTrue("missing @param2", i >= 0);
        i = result.indexOf("@param param1 param1 documentation", i);
        assertTrue("missing @param1", i >= 0);
        i = result.indexOf("@return return documentation", i);
        assertTrue("missing @return", i >= 0);
        i = result.indexOf("*/", i);
        assertTrue("missing */", i >= 0);
    }

    /**
     * Tests that a constructor is generated correctly.
     */
    public void test_constructor_doc() {
        Operation ctor = new OperationImpl();
        ctor.setName("AccuracyTestClass");
        ctor.addTaggedValue(createTaggedValue("documentation", "constructor doc"));
        ctor.setVisibility(VisibilityKind.PUBLIC);
        ctor.setOwner(testClass);
        testClass.addFeature(ctor);

        String result = test.createClassifierCode(testClass);
        assertTrue("bad constructor signature", result.contains("public AccuracyTestClass()"));
    }

    /**
     * Tests that a method signature is generated correctly.
     */
    public void test_method_signature() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "method documentation"));
        method.setVisibility(VisibilityKind.PUBLIC);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature", result.contains("public AccuracyTestClass testMethod()"));
    }

    /**
     * Tests that a static method signature is generated correctly.
     */
    public void test_static_method() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "method documentation"));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setOwnerScope(ScopeKind.CLASSIFIER);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature", result.contains("public static AccuracyTestClass testMethod()"));
    }

    /**
     * Tests that a synchronized method signature is generated correctly.
     */
    public void test_synchronized_method() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "method documentation"));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setConcurrency(CallConcurrencyKind.GUARDED);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature",
                   result.contains("public synchronized AccuracyTestClass testMethod()"));
    }

    /**
     * Tests that an abstract method signature is generated correctly.
     */
    public void test_abstract_method() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "method documentation"));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setAbstract(true);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature", result.contains("public abstract AccuracyTestClass testMethod()"));
    }

    /**
     * Tests that a final method signature is generated correctly.
     */
    public void test_final_method() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "method documentation"));
        method.setVisibility(VisibilityKind.PUBLIC);
        method.setLeaf(true);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);
        testClass.addFeature(method);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature", result.contains("public final AccuracyTestClass testMethod()"));
    }

    /**
     * Tests that a method with parameters is generated correctly.
     */
    public void test_method_params() {
        Operation method = new OperationImpl();
        method.setName("testMethod");
        method.addTaggedValue(createTaggedValue("documentation", "Method documentation."));
        method.setVisibility(VisibilityKind.PUBLIC);

        testClass.addFeature(method);

        Parameter ret = new ParameterImpl();
        ret.setType(testClass);
        ret.setKind(ParameterDirectionKind.RETURN);
        ret.addTaggedValue(createTaggedValue("documentation", "return documentation"));
        method.addParameter(ret);

        Parameter param1 = new ParameterImpl();
        param1.setType(testClass);
        param1.setName("param1");
        param1.addTaggedValue(createTaggedValue("documentation", "param1 documentation"));
        method.addParameter(param1);

        Parameter param2 = new ParameterImpl();
        param2.setType(testClass);
        param2.addTaggedValue(createTaggedValue("documentation", "param2 documentation"));
        param2.setName("param2");
        method.addParameter(param2);

        String result = test.createClassifierCode(testClass);
        assertTrue("incorrect method signature",
                   result.contains("public AccuracyTestClass testMethod(AccuracyTestClass param1, "
                                   + "AccuracyTestClass param2)"));
    }

    /**
     * Tests that the type of an attribute is imported.
     */
    public void test_attr_import() {
        Class linkedList = new ClassImpl();
        linkedList.setName("LinkedList");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("java.util");
        model.addOwnedElement(pkg);
        pkg.setNamespace(model);
        pkg.addOwnedElement(linkedList);
        linkedList.setNamespace(pkg);

        Attribute attr = new AttributeImpl();
        attr.setVisibility(VisibilityKind.PRIVATE);
        attr.setChangeability(ChangeableKind.CHANGEABLE);
        attr.setType(linkedList);
        attr.setName("attribute1");
        attr.addTaggedValue(createTaggedValue("documentation", "Attribute documentation."));

        testClass.addFeature(attr);

        String result = test.createClassifierCode(testClass);
        assertTrue("import not generated properly", result.contains("import java.util"));
    }

    /**
     * Tests that the type of a parameter is imported.
     */
    public void test_param_import() {
        Class linkedList = new ClassImpl();
        linkedList.setName("LinkedList");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("java.util");
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
        param1.setType(linkedList);
        param1.addTaggedValue(createTaggedValue("documentation", "param doc"));
        opr1.addParameter(param1);
        testClass.addFeature(opr1);

        String result = test.createClassifierCode(testClass);
        assertTrue("import not generated properly", result.contains("import java.util"));
    }

    /**
     * Tests that the type of a return value is imported.
     */
    public void test_return_import() {
        Class linkedList = new ClassImpl();
        linkedList.setName("LinkedList");
        linkedList.addTaggedValue(createTaggedValue("documentation", "LinkedList class doc."));
        linkedList.setVisibility(VisibilityKind.PUBLIC);

        Model model = new ModelImpl();
        Package pkg = new PackageImpl();
        pkg.setName("java.util");
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

        String result = test.createClassifierCode(testClass);
        assertTrue("import not generated properly", result.contains("import java.util."));
    }
}
