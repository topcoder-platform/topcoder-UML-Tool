/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.accuracytests;

import java.io.File;
import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.xml.sax.helpers.LocatorImpl;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.DefaultXMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;

/**
 * <p>
 * Accuracy test for {@link  XMI2ModelHandler XMI2ModelHandler} class.
 * </p>
 *
 * <p>
 * This class tests the constructor <code>XMI2ModelHandler()</code> and
 * <code>XMI2ModelHandler(XMIReader, ModelElementFactory, UMLModelManager)</code>of <code>XMI2ModelHandler</code>.
 * This class also tests the methods <code>XMI2ModelHandler#setModelElementFactory(ModelElementFactory)</code>,
 * <code>XMI2ModelHandler#getModelElementFactory()</code>,
 * <code>XMI2ModelHandler#setDocumentLocator(Locator)</code>,
 * <code>XMI2ModelHandler#setUmlModelManager(UMLModelManager)</code>,
 * <code>XMI2ModelHandler#getUmlModelManager()</code> and <code>XMI2ModelHandler#startElement()</code> and
 * <code>XMI2ModelHandler#endElement()</code>.
 * </p>
 *
 *
 * @author mittu
 * @version 1.0
 */
public class XMI2ModelHandlerAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents the instance of <code>XMI2ModelHandler</code> for testing.
     * </p>
     */
    private XMI2ModelHandler xMI2ModelHandler;

    /**
     * <p>
     * Represents the instaance of <code>XMIReader</code> for testing.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Represents the instance of <code>ModelElementFactory</code> for testing.
     * </p>
     */
    private ModelElementFactory modelElementFactory;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite of all tests of <code>XMI2ModelHandlerAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(XMI2ModelHandlerAccuracyTests.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.ACCURACY_DIR + "XMIReader_Accuracy.xml", true);
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.ACCURACY_DIR + "ModelElementFactory_Accuracy.xml", false);
        reader = new XMIReader();
        xMI2ModelHandler = (XMI2ModelHandler) reader.getHandler("UML:Model");
        modelElementFactory = new ModelElementFactory(ModelElementFactory.class.getName());
        xMI2ModelHandler.setModelElementFactory(modelElementFactory);
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        xMI2ModelHandler = null;
        modelElementFactory = null;
        reader = null;
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#XMI2ModelHandler()}</code> constructor.
     * </p>
     *
     * <p>
     * This method tests the instantiation of <code>XMI2ModelHandler</code>. Also tests for the inheritence
     * (<code>XMI2ModelHandler</code> must extend <code>DefaultXMIHandler</code>).
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMI2ModelHandlerAccuracy1() throws Exception {
        xMI2ModelHandler = new XMI2ModelHandler();
        assertNotNull("failed to create XMI2ModelHandler", xMI2ModelHandler);
        assertTrue("XMI2ModelHandler must extend DefaultXMIHandler", xMI2ModelHandler instanceof DefaultXMIHandler);

    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#(XMIReader, ModelElementFactory, UMLModelManager)}</code>
     * constructor.
     * </p>
     *
     * <p>
     * This method tests the instantiation of <code>XMI2ModelHandler</code>. Also tests for the inheritence
     *  (<code>XMI2ModelHandler</code> must extend <code>DefaultXMIHandler</code>).
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testXMI2ModelHandlerAccuracy2() throws Exception {
        assertNotNull("failed to create XMI2ModelHandler", xMI2ModelHandler);
        assertTrue("XMI2ModelHandler must extend DefaultXMIHandler", xMI2ModelHandler instanceof DefaultXMIHandler);
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#getModelElementFactory()}</code> method.
     * </p>
     *
     * <p>
     * This method tests whether the <code>ModelElementFactory</code> which is set in <code>XMI2ModelHandler</code>
     * is retrieved properly. This method verifies the <code>ModelElementFactory</code> set in constructor of
     * <code>XMI2ModelHandler</code> is retrieved properly.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetModelElementFactoryAccuracy() throws Exception {
        assertEquals("failed to retrieve ModelElementFactory", modelElementFactory, xMI2ModelHandler
                .getModelElementFactory());

        xMI2ModelHandler = new XMI2ModelHandler();

        assertNotNull("failed to retrieve ModelElementFactory", xMI2ModelHandler.getModelElementFactory());
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#setModelElementFactory(ModelElementFactory)}</code> method.
     * </p>
     *
     * <p>
     * This method tests whether the <code>ModelElementFactory</code> is set properly. The verification is done with
     * the help of its appropriate getter.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetModelElementFactoryAccuracy() throws Exception {
        modelElementFactory = new ModelElementFactory();
        xMI2ModelHandler.setModelElementFactory(modelElementFactory);
        assertEquals("failed to set ModelElementFactory", modelElementFactory, xMI2ModelHandler
                .getModelElementFactory());
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#setDocumentLocator(Locator)}</code> method.
     * </p>
     *
     * <p>
     * This method tests whether the <code>Locator</code> is set in the <code>XMI2ModelHandler</code>. As this
     * method is not used in this component. This method is just checked whether it throws any exceptions or not. Also
     * checks whether null arguments are accepted.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetDocumentLocatorAccuracy() throws Exception {
        xMI2ModelHandler.setDocumentLocator(new LocatorImpl());
        xMI2ModelHandler.setDocumentLocator(null);
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#getUmlModelManager()}</code> method.
     * </p>
     *
     * <p>
     * This method tests whether the <code>UMLModelManager</code> which is set in <code>XMI2ModelHandler</code> is
     * retrieved properly. This method verifies the <code>UMLModelManager</code> set in constructor of
     * <code>XMI2ModelHandler</code> is retrieved properly.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetUmlModelManagerAccuracy() throws Exception {
        assertEquals("failed to retrieve UMLModelManager", UMLModelManager.getInstance(), xMI2ModelHandler
                .getUmlModelManager());

        xMI2ModelHandler = new XMI2ModelHandler();

        assertNotNull("failed to retrieve ModelElementFactory", xMI2ModelHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Accuracy test of <code>{@link XMI2ModelHandler#setUmlModelManager(UMLModelManager)}</code> method.
     * </p>
     *
     * <p>
     * This method checks whether the <code>UMLModelManager</code> is set properly.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetUmlModelManagerAccuracy() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        xMI2ModelHandler.setUmlModelManager(manager);

        assertEquals("failed to set UMLModelManager", manager, xMI2ModelHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Actor is parsed by the handler as <code>Actor</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testActor() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Actor actor = (Actor) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f49");

        assertEquals("failed to parse the name of UML:Actor specified in the xmi", "Actor", actor.getName());
        assertEquals("failed to parse the attribute visibility of UML:Actor specified in the xmi",
                VisibilityKind.PUBLIC, actor.getVisibility());
        assertFalse("failed to parse the attribute isSpecification of UML:Actor specified in the xmi", actor
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Actor specified in the xmi", actor.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Actor specified in the xmi", actor.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Actor specified in the xmi", actor.isAbstract());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:UseCase is parsed by the handler as <code>UseCase</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUseCase1() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        UseCase useCase = (UseCase) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f34");

        assertEquals("failed to parse the name of UML:UseCase specified in the xmi", "Register for Course", useCase
                .getName());
        assertEquals("failed to parse the attribute visibility of UML:UseCase specified in the xmi",
                VisibilityKind.PUBLIC, useCase.getVisibility());
        assertFalse("failed to parse the attribute isSpecification of UML:UseCase specified in the xmi", useCase
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:UseCase specified in the xmi", useCase.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:UseCase specified in the xmi", useCase.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:UseCase specified in the xmi", useCase
                .isAbstract());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:UseCase is parsed by the handler as <code>UseCase</code>. This method also
     * tests whether UML:Extend is parsed perfectly by the handler. This method checks whether the handler handles the
     * forward reference in xmi.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUseCase2() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        UseCase useCase = (UseCase) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f2d");

        assertEquals("failed to parse the name of UML:UseCase specified in the xmi", "Register By Mail", useCase
                .getName());
        assertEquals("failed to parse the attribute visibility of UML:UseCase specified in the xmi",
                VisibilityKind.PUBLIC, useCase.getVisibility());
        assertFalse("failed to parse the attribute isSpecification of UML:UseCase specified in the xmi", useCase
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:UseCase specified in the xmi", useCase.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:UseCase specified in the xmi", useCase.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:UseCase specified in the xmi", useCase
                .isAbstract());

        Collection<Extend> useCaseExtends = useCase.getExtends();

        assertEquals("failed to parse the child attribute UML:Extend", 1, useCaseExtends.size());

        Extend extend = (Extend) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f03");

        assertFalse("failed to parse the attribute isSpecification of UML:Extend specified in the xmi", extend
                .isSpecification());
        assertEquals("failed to get the extension of Extend properly", useCase, extend.getExtension());

        assertTrue("failed to get the use case's extend properly from XMI", useCaseExtends.contains(extend));

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:TaggedValue is parsed by the handler as <code>TaggedValue</code>. This method
     * also tests whether UML:TagDefinition is parsed perfectly by the handler. This method checks whether the handler
     * handles the forward reference in xmi.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testTaggedValue() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        TaggedValue taggedValue = (TaggedValue) reader.getElement("I197e57cm10e829be86amm789c");

        assertFalse("failed to parse the attribute isSpecification of UML:TaggedValue specified in the xmi",
                taggedValue.isSpecification());
        assertEquals("failed to parse the dataValue of UML:TaggedValue specified in the xmi", "accuracy data",
                taggedValue.getDataValue());

        TagDefinition tagDefinition = (TagDefinition) reader.getElement("I197e57cm10e829be86amm789d");

        assertEquals("failed to parse the type fo UML:TaggedValue specified in the xmi", tagDefinition, taggedValue
                .getType());

        assertEquals("failed to parse the name of UML:TagDefinition specified in the xmi",
                "accuracy tests tag definition", tagDefinition.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:TagDefinition specified in the xmi",
                tagDefinition.isSpecification());
        assertEquals("failed to parse the tag type of UML:TagDefinition specified in the xmi", "String",
                tagDefinition.getTagType());
    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Operation is parsed by the handler as <code>Operation</code>. This method also
     * tests whether UML:StereoType is parsed perfectly by the handler. This method checks whether the handler handles
     * the forward reference in xmi.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testOperation() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Operation operation = (Operation) reader.getElement("I197e57cm10e829be86amm7de7");

        assertEquals("failed to get the name of UML:Operation specified in the xmi", "XMI2ModelHandler", operation
                .getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Operation specified in the xmi", operation
                .isSpecification());
        assertEquals("failed to parse the attribute visibility of UML:Operation specified in the xmi",
                VisibilityKind.PUBLIC, operation.getVisibility());
        assertFalse("failed to parse the attribute isRoot of UML:Operation specified in the xmi", operation.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Operation specified in the xmi", operation.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Operation specified in the xmi", operation
                .isAbstract());
        assertFalse("failed to parse the attribute isQuery of UML:Operation specified in the xmi", operation
                .isQuery());
        assertEquals("failed to parse the attribute ownerscope of UML:Operation specified in the xmi",
                ScopeKind.INSTANCE, operation.getOwnerScope());
        assertEquals("failed to parse the attribute concurrency of UML:Operation specified in the xmi",
                CallConcurrencyKind.SEQUENTIAL, operation.getConcurrency());

        Stereotype stereotype = (Stereotype) reader.getElement("I197e57cm10e829be86amm7dcf");

        Collection<Stereotype> stereoTypes = operation.getStereotypes();
        assertTrue("failed to parse the type fo UML:Operation specified in the xmi", stereoTypes.contains(stereotype));

        assertEquals("failed to get the name of UML:StereoType specified in the xmi", "create", stereotype.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:StereoType specified in the xmi", operation
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:StereoType specified in the xmi", stereotype
                .isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:StereoType specified in the xmi", stereotype
                .isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:StereoType specified in the xmi", stereotype
                .isAbstract());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Class is parsed by the handler as <code>Class</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClass() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Class clazz = (Class) reader.getElement("I197e57cm10e829be86amm7cae");

        assertEquals("failed to get the name of UML:Class specified in the xmi", "String", clazz.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Class specified in the xmi", clazz
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Class specified in the xmi", clazz.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Class specified in the xmi", clazz.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Class specified in the xmi", clazz.isAbstract());
        assertFalse("failed to parse the attribute isActive of UML:Class specified in the xmi", clazz.isActive());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:DataType is parsed by the handler as <code>DataType</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDataType() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        DataType dataType = (DataType) reader.getElement("I197e57cm10e829be86amm7a86");

        assertEquals("failed to get the name of UML:DataType specified in the xmi", "char[]", dataType.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:DataType specified in the xmi", dataType
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:DataType specified in the xmi", dataType.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:DataType specified in the xmi", dataType.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:DataType specified in the xmi", dataType
                .isAbstract());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:MultiplicityRange is parsed by the handler as <code>MultiplicityRange</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testMultiplicityRange() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        MultiplicityRange multiplicityRange = (MultiplicityRange) reader.getElement("I197e57cm10e829be86amm7d59");

        assertEquals("failed to get the lower range of UML:MultiplicityRange specified in the xmi", 1,
                multiplicityRange.getLower());
        assertEquals("failed to get the upper range of UML:MultiplicityRange specified in the xmi", 1,
                multiplicityRange.getUpper());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Generalization is parsed by the handler as <code>Generalization</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGeneralization() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Generalization generalization = (Generalization) reader.getElement("I3b4f79m10e82d15a2dmm769d");

        assertFalse("failed to parse the attribute isSpecification of UML:Generalization specified in the xmi",
                generalization.isSpecification());
        assertEquals("failed to parse the child of UML:Generalization specified in the xmi", reader
                .getElement("I197e57cm10e829be86amm7cae"), generalization.getChild());
        assertEquals("failed to parse the parent of UML:Generalization specified in the xmi", reader
                .getElement("I197e57cm10e829be86amm76af"), generalization.getParent());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Comment is parsed by the handler as <code>Comment</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testComment() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Comment comment = (Comment) reader.getElement("I3b4f79m10e82d15a2dmm71bb");

        assertEquals("failed to get the name of UML:Comment specified in the xmi", "Accuracy Comment", comment
                .getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Comment specified in the xmi", comment
                .isSpecification());
        assertEquals("failed to parse the attribute body of UML:Comment specified in the xmi",
                "This step is really complex", comment.getBody());
        assertEquals("failed to parse the attribute visibility of UML:Comment specified in the xmi",
                VisibilityKind.PUBLIC, comment.getVisibility());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Association is parsed by the handler as <code>Association</code>. This method
     * also tests whether UML:AssociationEnd is parsed by the handler.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAssociation() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Association association = (Association) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f20");

        assertFalse("failed to parse the attribute isSpecification of UML:Association specified in the xmi",
                association.isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Association specified in the xmi", association
                .isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Association specified in the xmi", association
                .isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Association specified in the xmi", association
                .isAbstract());
        Collection<AssociationEnd> connections = association.getConnections();

        AssociationEnd associationEnd1 = (AssociationEnd) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f26");
        AssociationEnd associationEnd2 = (AssociationEnd) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f23");

        assertTrue("failed to parse the connections of UML:Association specified in the xmi", connections
                .contains(associationEnd1));
        assertTrue("failed to parse the connections of UML:Association specified in the xmi", connections
                .contains(associationEnd2));

        assertFalse("failed to parse the attribute isSpecification of UML:AssociationEnd specified in the xmi",
                associationEnd1.isSpecification());
        assertTrue("failed to parse the attribute isNavigable of UML:AssociationEnd specified in the xmi",
                associationEnd1.isNavigable());
        assertEquals("failed to parse the attribute visibility of UML:AssociationEnd specified in the xmi",
                VisibilityKind.PUBLIC, associationEnd1.getVisibility());
        assertEquals("failed to parse the attribute aggregation of UML:AssociationEnd specified in the xmi",
                AggregationKind.NONE, associationEnd1.getAggregation());
        assertEquals("failed to parse the attribute targetScope of UML:AssociationEnd specified in the xmi",
                ScopeKind.INSTANCE, associationEnd1.getTargetKind());
        assertEquals("failed to parse the attribute changeability of UML:AssociationEnd specified in the xmi",
                ChangeableKind.CHANGEABLE, associationEnd1.getChangeability());
        assertEquals("failed to parse the attribute ordering of UML:AssociationEnd specified in the xmi",
                OrderingKind.UNORDERED, associationEnd1.getOrdering());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Abstraction is parsed by the handler as <code>Abstraction</code>.
     * </p>
     *
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAbstraction() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Abstraction abstraction = (Abstraction) reader.getElement("I197e57cm10e829be86amm7e31");

        assertFalse("failed to parse the attribute isSpecification of UML:Class specified in the xmi", abstraction
                .isSpecification());
    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Interface is parsed by the handler as <code>Interface</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testInterface() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Interface clazz = (Interface) reader.getElement("I197e57cm10e829be86amm7efe");

        assertEquals("failed to get the name of UML:Interface specified in the xmi", "ContentHandler", clazz
                .getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Interface specified in the xmi", clazz
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Interface specified in the xmi", clazz.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Interface specified in the xmi", clazz.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Interface specified in the xmi", clazz
                .isAbstract());
        assertEquals("failed to parse the attribute visibility of UML:Interface specified in the xmi",
                VisibilityKind.PACKAGE, clazz.getVisibility());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Attribute is parsed by the handler as <code>Attribute</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAttribute() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Attribute attribute = (Attribute) reader.getElement("I197e57cm10e829be86amm78b1");

        assertEquals("failed to get the name of UML:Attribute specified in the xmi", "locator", attribute.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Attribute specified in the xmi", attribute
                .isSpecification());
        assertEquals("failed to parse the attribute ownerScope of UML:Attribute specified in the xmi",
                ScopeKind.INSTANCE, attribute.getOwnerScope());
        assertEquals("failed to parse the attribute changeability of UML:Attribute specified in the xmi",
                ChangeableKind.CHANGEABLE, attribute.getChangeability());
        assertEquals("failed to parse the attribute visibility of UML:Attribute specified in the xmi",
                VisibilityKind.PRIVATE, attribute.getVisibility());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Parameter is parsed by the handler as <code>Parameter</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testParameter() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Parameter parameter = (Parameter) reader.getElement("I3b4f79m10e82d15a2dmm7906");

        assertEquals("failed to get the name of UML:Parameter specified in the xmi", "reader", parameter.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Parameter specified in the xmi", parameter
                .isSpecification());
        assertEquals("failed to parse the attribute kind of UML:Parameter specified in the xmi",
                ParameterDirectionKind.IN, parameter.getKind());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Enumeration is parsed by the handler as <code>Enumeration</code>. This method
     * also tests UML:EnumerationLiteral is parsed correctly by the handler or not.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testEnumeration() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Enumeration enumeration = (Enumeration) reader.getElement("F197e57cm10e829be86amm78b1");

        assertEquals("failed to get the name of UML:Enumeration specified in the xmi", "Enumeration", enumeration
                .getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Enumeration specified in the xmi",
                enumeration.isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Enumeration specified in the xmi", enumeration
                .isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Enumeration specified in the xmi", enumeration
                .isLeaf());
        assertTrue("failed to parse the attribute isAbstract of UML:Enumeration specified in the xmi", enumeration
                .isAbstract());
        assertEquals("failed to parse the attribute visibility of UML:Enumeration specified in the xmi",
                VisibilityKind.PRIVATE, enumeration.getVisibility());

        Collection<EnumerationLiteral> collection = enumeration.getLiterals();

        EnumerationLiteral enumerationLiteral = (EnumerationLiteral) reader.getElement("F197e57cm10e829be86amm78b2");

        assertTrue("failed to get the literals of UML:Enumeration specified in the xmi", collection
                .contains(enumerationLiteral));

        assertEquals("failed to get the name of UML:Enumeration specified in the xmi", "enumliteral",
                enumerationLiteral.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Enumeration specified in the xmi",
                enumerationLiteral.isSpecification());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Package is parsed by the handler as <code>Package</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testPackage() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Package package1 = (Package) reader.getElement("I197e57cm10e829be86amm7f07");

        assertEquals("failed to get the name of UML:Package specified in the xmi", "org.xml.sax", package1.getName());
        assertFalse("failed to parse the attribute isSpecification of UML:Package specified in the xmi", package1
                .isSpecification());
        assertFalse("failed to parse the attribute isRoot of UML:Package specified in the xmi", package1.isRoot());
        assertFalse("failed to parse the attribute isLeaf of UML:Package specified in the xmi", package1.isLeaf());
        assertFalse("failed to parse the attribute isAbstract of UML:Package specified in the xmi", package1
                .isAbstract());
        assertEquals("failed to parse the attribute visibility of UML:Package specified in the xmi",
                VisibilityKind.PACKAGE, package1.getVisibility());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Method is parsed by the handler as <code>Method</code>. This method also tests
     * whether UML:ProcedureExpression is parsed perfectly by the reader.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testMethod() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Method method = (Method) reader.getElement("I197e57cm10e829be86amm7de5");

        assertFalse("failed to parse the attribute isSpecification of UML:Method specified in the xmi", method
                .isSpecification());
        assertFalse("failed to parse the attribute isQuery of UML:Method specified in the xmi", method.isQuery());

        ProcedureExpression procedureExpression = (ProcedureExpression) reader
                .getElement("I197e57cm10e829be86amm7de6");
        assertEquals("failed to parse the body of UML:Method specified in the xmi", procedureExpression, method
                .getBody());

        Operation operation = (Operation) reader.getElement("I197e57cm10e829be86amm7de7");
        assertEquals("failed to parse the specification of UML:Method specified in the xmi", operation, method
                .getSpecification());

        assertEquals("failed to retrieve the language of UML:ProcedureExpression", "java", procedureExpression
                .getLanguage());
        assertEquals("failed to retrieve the body of UML:ProcedureExpression", "procedure", procedureExpression
                .getBody());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Dependency is parsed by the handler as <code>Dependency</code>. This test case
     * tests the IDREF attribute is properly parsed by the handler.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDependency() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Dependency dependency = (Dependency) reader.getElement("I3b4f79m10e82d15a2dmm76e0");

        assertFalse("failed to parse the attribute isSpecification of UML:Dependency specified in the xmi",
                dependency.isSpecification());

        assertEquals("failed to parse the attribute client of UML:Dependency specified in the xmi", 1, dependency
                .getClients().size());

    }

    /**
     * <p>
     * Accuracy test of
     * <code>{@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes)}</code> and
     * <code>{@link XMI2ModelHandler#endElement(String, String, String)}</code> methods. These methods will be
     * invoked by <code>XMIReader</code>, Hence these methods are tested by making the reader parse the XMI.
     * </p>
     *
     * <p>
     * This method tests whether UML:Multiplicity is parsed by the handler as <code>Multiplicity</code>.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testMultiplicity() throws Exception {
        reader.parse(new File(AccuracyTestHelper.ACCURACY_DIR + "sample_accuracy_xmi.xmi"));
        Multiplicity multiplicity = (Multiplicity) reader.getElement("I1aa8eb7m10f6dbd4de0mm7f24");

        assertEquals("failed to parse the multiplicity ranges specified in the xmi", 1, multiplicity.getRanges()
                .size());
    }

}
