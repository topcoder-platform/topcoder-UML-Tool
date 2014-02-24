/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.TestCase;

import java.util.Scanner;


/**
 * This is the base class for {@link Generator} tests. It provides some useful
 * methods for testing.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractGeneratorTestCase extends TestCase {
    /**
     * Set up the fixture.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Asserts a text line by line.
     *
     * @param expected
     *            the expected text
     * @param result
     *            the current text
     */
    protected void assertText(String expected, String result) {
        Scanner expScanner = new Scanner(expected);
        Scanner resScanner = new Scanner(result);
        int i = 1;

        while (expScanner.hasNext()) {
            String lineExpected = expScanner.nextLine().trim();
            String lineResult = resScanner.nextLine().trim();
            assertEquals("Line " + i, lineExpected, lineResult);
            i++;
        }

        assertFalse("Too many lines", resScanner.hasNext());
    }

    /**
     * Sets the initial value.
     *
     * @param att
     *            {@link Attribute} to set the value of.
     * @param data
     *            the data for the value.
     */
    protected void setInitialValue(Attribute att, String data) {
        Expression initialValue = new ExpressionImpl();
        initialValue.setBody(data);
        att.setInitialValue(initialValue);
    }

    /**
     * Creates a new {@link Primitive} with the given name.
     *
     * @param name
     *            name of the {@link Primitive}
     * @return a new {@link Primitive}
     */
    protected Primitive createPrimitive(String name) {
        Primitive prim = new PrimitiveImpl();
        prim.setName(name);

        return prim;
    }

    /**
     * Creates a new {@link Enumeration} with the given name.
     *
     * @param name
     *            name of the {@link Enumeration}
     * @return a new {@link Enumeration}
     */
    protected Enumeration createEnumeration(String name) {
        Enumeration e = new EnumerationImpl();
        e.setName(name);

        return e;
    }

    /**
     * Adds a {@link Generalization} to the given {@link Classifier}.
     *
     * @param clazz
     *            {@link Classifier} to add the {@link Generalization} to
     * @param parent
     *            the extended {@link Classifier}
     * @return the new {@link Generalization}.
     */
    protected Generalization addGeneralization(Classifier clazz, Classifier parent) {
        Generalization gen = new GeneralizationImpl();
        gen.setParent(parent);
        clazz.addGeneralization(gen);

        return gen;
    }

    /**
     * Creates an inner class.
     *
     * @param name
     *            name of the inner class.
     * @param outerClass
     *            outer class
     * @return the inner class
     */
    protected Classifier createInnerClass(String name, Classifier outerClass) {
        Classifier innerClass = this.createClass(name, "");
        outerClass.addOwnedElement(innerClass);
        innerClass.setNamespace(outerClass);

        return innerClass;
    }

    /**
     * Creates a new {@link Class}.
     *
     * @param name
     *            name of the class.
     * @param packageName
     *            package of the class
     * @return a new {@link Class}
     */
    protected Classifier createClass(String name, String packageName) {
        Model model = new ModelImpl();
        model.setName("model");

        Classifier clazz = new ClassImpl();
        clazz.setName(name);

        Package pack = this.createPackage(packageName, model);

        if (pack == null) {
            clazz.setNamespace(model);
        } else {
            clazz.setNamespace(pack);
        }

        return clazz;
    }

    /**
     * Creates a new {@link Class}.
     *
     * @param name
     *            name of the class.
     * @param pack
     *            package of the class
     * @return a new {@link Class}
     */
    protected Classifier createClass(String name, Package pack) {
        Classifier clazz = new ClassImpl();
        clazz.setName(name);

        clazz.setNamespace(pack);
        pack.addOwnedElement(clazz);

        return clazz;
    }

    /**
     * Gets the root package.
     *
     * @param pack
     *            {@link Package} to get to root from
     * @return the root package.
     */
    protected Package getRootPackage(Package pack) {
        Package p = pack;

        while (p.getNamespace() instanceof Package) {
            p = (Package) p.getNamespace();
        }

        return p;
    }

    /**
     * Creates a new {@link Package} with the given name.
     *
     * @param name
     *            name of the package
     * @param model
     *            the {@link Model} to add the {@link Package} to
     * @return a new {@link Package}
     */
    protected Package createPackage(String name, Model model) {
        Package pack = null;

        for (String s : name.split("\\.")) {
            Package newPack = new PackageImpl();
            newPack.setName(s);

            if (pack == null) {
                newPack.setNamespace(model);
                model.addOwnedElement(newPack);
            } else {
                newPack.setNamespace(pack);
                pack.addOwnedElement(newPack);
            }

            pack = newPack;
        }

        return pack;
    }

    /**
     * Creates a new {@link Interface}.
     *
     * @param name
     *            name of the interface.
     * @param packageName
     *            package of the interface
     * @return a new {@link Interface}
     */
    protected Interface createInterface(String name, String packageName) {
        Model model = new ModelImpl();
        model.setName("model");

        Interface interfazze = new InterfaceImpl();
        interfazze.setName(name);

        Package pack = null;

        for (String s : packageName.split("\\.")) {
            Package newPack = new PackageImpl();
            newPack.setName(s);

            if (pack == null) {
                newPack.setNamespace(model);
            } else {
                newPack.setNamespace(pack);
            }

            pack = newPack;
        }

        if (pack == null) {
            interfazze.setNamespace(model);
        } else {
            interfazze.setNamespace(pack);
        }

        return interfazze;
    }

    /**
     * Adds a new tag to the documentation of the given {@link ModelElement}.
     *
     * @param element
     *            {@link ModelElement} to add the tag to
     * @param tagName
     *            name of the tag
     * @param data
     *            text of the tag
     */
    protected void addTaggedDocumentation(ModelElement element, String tagName, String data) {
        TaggedValue taggedValue1 = new TaggedValueImpl();
        taggedValue1.setDataValue(data);

        TagDefinition type = new TagDefinitionImpl();
        type.setTagType("doc#" + tagName);
        taggedValue1.setType(type);

        element.addTaggedValue(taggedValue1);
    }

    /**
     * Sets the general documentation of the given {@link ModelElement}.
     *
     * @param element
     *            {@link ModelElement} to set the documentation for
     * @param data
     *            text of the documentation to be added
     */
    protected void setGeneralDocumentation(ModelElement element, String data) {
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue(data);

        TagDefinition type = new TagDefinitionImpl();
        type.setTagType("doc");
        taggedValue.setType(type);

        element.addTaggedValue(taggedValue);
    }

    /**
     * Adds a new {@link Operation} to the given {@link Classifier}. The
     * {@link Operation} has a default return type of <code>void</code>.
     *
     * @param classifier
     *            {@link Classifier} to add the {@link Operation} to.
     * @param name
     *            name of the {@link Operation}
     * @param kind
     *            {@link VisibilityKind} of the {@link Operation}
     * @return a new created {@link Operation}
     */
    protected Operation addOperation(Classifier classifier, String name, VisibilityKind kind) {
        Operation op = new OperationImpl();
        op.setName(name);
        op.setVisibility(kind);

        Primitive type = new PrimitiveImpl();
        type.setName("void");
        this.addParameter(op, null, type, null).setKind(ParameterDirectionKind.RETURN);
        classifier.addFeature(op);

        return op;
    }

    /**
     * Adds a {@link Parameter} to the given {@link Operation}.
     *
     * @param op
     *            The {@link Operation} to add the {@link Parameter} to.
     * @param name
     *            name of the {@link Parameter}.
     * @param type
     *            type of the {@link Parameter}
     * @param doc
     *            documentation data.
     * @return a new created {@link Parameter}
     */
    protected Parameter addParameter(Operation op, String name, Classifier type, String doc) {
        Parameter param = new ParameterImpl();
        param.setName(name);
        param.setType(type);
        this.setGeneralDocumentation(param, doc);
        op.addParameter(param);

        return param;
    }

    /**
     * Creates a new {@link Attribute} and adds it to the {@link Classifier}.
     *
     * @param classifier
     *            {@link Classifier} to add the {@link Attribute} to
     * @param name
     *            name of the {@link Attribute}
     * @param kind
     *            the {@link VisibilityKind}
     * @param typeName
     *            name of the {@link Attribute}'s type
     * @return a new created {@link Attribute}
     */
    protected Attribute addAttribute(Classifier classifier, String name, VisibilityKind kind, String typeName) {
        Attribute att = new AttributeImpl();
        att.setName(name);
        att.setVisibility(kind);

        Classifier type;

        if ("String".equals(typeName)) {
            type = this.createClass("String", "java.lang");
        } else if ("int".equals(typeName) || "boolean".equals(typeName)) {
            type = new PrimitiveImpl();
            type.setName(typeName);
        } else {
            type = this.createClass(typeName, "");
        }

        att.setType(type);

        if (classifier != null) {
            classifier.addFeature(att);
        }

        return att;
    }

    /**
     * Adds a new {@link Stereotype} to the {@link ModelElement}.
     *
     * @param modelElement
     *            {@link ModelElement} to add the {@link Stereotype} to
     * @param name
     *            name of the new {@link Stereotype}
     * @return the new {@link Stereotype}
     */
    protected Stereotype addStereotype(ModelElement modelElement, String name) {
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName(name);
        modelElement.addStereotype(stereoType);

        return stereoType;
    }
}
