/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.helpers.LocatorImpl;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationClass;
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
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.errorhandling.BaseException;
import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderParseException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for XMI2ModelHandler.
 * </p>
 *
 * <p>
 * Note, because this component is a plugin of XMIReader component, the startElement()
 * and endElement() can not be tested separately. So the two methods are tested using
 * the XMIReader component. The two methods are invoked indirectly via the XMIReader instance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMI2ModelHandlerTests extends TestCase {
    /**
     * <p>
     * XMI2ModelHandler instance for testing.
     * </p>
     */
    private XMI2ModelHandler handler;

    /**
     * <p>
     * XMIReader instance for helping testing.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(), "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(), "test_files" + File.separator
            + "factory_config.xml");
        reader = new XMIReader();

        handler = (XMI2ModelHandler) reader.getHandler("UML:Model");
        handler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(XMIReader.class.getName());
        TestHelper.clearConfigFile(ModelElementFactory.class.getName());

        reader = null;
        handler = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(XMI2ModelHandlerTests.class);
    }

    /**
     * <p>
     * Tests ctor XMI2ModelHandler#XMI2ModelHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created XMI2ModelHandler should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to created a new XMI2ModelHandler instance.", new XMI2ModelHandler(reader,
            new ModelElementFactory(), UMLModelManager.getInstance()));
    }

    /**
     * <p>
     * Tests ctor XMI2ModelHandler#XMI2ModelHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when reader is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullReader() {
        try {
            new XMI2ModelHandler(null, new ModelElementFactory(), UMLModelManager.getInstance());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor XMI2ModelHandler#XMI2ModelHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElementFactory is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullModelElementFactory() {
        try {
            new XMI2ModelHandler(reader, null, UMLModelManager.getInstance());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor XMI2ModelHandler#XMI2ModelHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullModelManager() {
        try {
            new XMI2ModelHandler(reader, new ModelElementFactory(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor XMI2ModelHandler#XMI2ModelHandler() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created XMI2ModelHandler should not be null.
     * </p>
     */
    public void testCtor2() {
        XMI2ModelHandler modelHandler = new XMI2ModelHandler();
        assertNotNull("Failed to created a new XMI2ModelHandler instance.", modelHandler);

        assertNull("The XMIReader should be null.", modelHandler.getXMIReader());
        assertNotNull("The ModelElementFactory instance should not be null.", modelHandler.getModelElementFactory());
        assertNotNull("The UMLModelManager instance should not be null.", modelHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setModelElementFactory(ModelElementFactory) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The ModelElementFactory instance should be set correctly.
     * </p>
     */
    public void testSetModelElementFactory() {
        ModelElementFactory factory = new ModelElementFactory();
        handler.setModelElementFactory(factory);

        assertSame("The ModelElementFactory instance should be set correctly.", factory,
            handler.getModelElementFactory());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setModelElementFactory(ModelElementFactory) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElementFactory is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetModelElementFactory_NullModelElementFactory() {
        try {
            handler.setModelElementFactory(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#getModelElementFactory() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The model element factory should be returned correctly.
     * </p>
     */
    public void testGetModelElementFactory() {
        ModelElementFactory factory = new ModelElementFactory();
        XMI2ModelHandler activityHandler = new XMI2ModelHandler(reader, factory, UMLModelManager.getInstance());

        assertSame("The model element factory should be returned correctly.", factory,
            activityHandler.getModelElementFactory());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setUmlModelManager(UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The uml model manager should be set correctly.
     * </p>
     */
    public void testSetUmlModelManager() {
        UMLModelManager manager = UMLModelManager.getInstance();
        handler.setUmlModelManager(manager);

        assertSame("The uml model manager should be set correctly.", manager, handler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setUmlModelManager(UMLModelManager) for failure.
     * It tests the case that when modelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetUmlModelManager_NullModelManager() {
        try {
            handler.setUmlModelManager(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#getUmlModelManager() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The uml model manager should be returned correctly.
     * </p>
     */
    public void testGetUmlModelManager() {
        UMLModelManager manager = UMLModelManager.getInstance();
        XMI2ModelHandler modelHandler = new XMI2ModelHandler(reader, new ModelElementFactory(), manager);

        assertSame("The uml model manager should be returned correctly.", manager, modelHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setDocumentLocator(Locator) for accuracy.
     * </p>
     *
     * <p>
     * Verify : setDocumentLocator() is invoked successfully and no exception.
     * </p>
     */
    public void testSetDocumentLocator() {
        // no validation here because the locator is not used in current implementation.
        handler.setDocumentLocator(new LocatorImpl());
    }

    /**
     * <p>
     * Tests XMI2ModelHandler#setDocumentLocator(Locator) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when locator is null and expects success.
     * </p>
     */
    public void testSetDocumentLocator_NullLocator() {
        // except no exception
        handler.setDocumentLocator(null);
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Multiplicity element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testMultiplicity() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007A2");

        // verify the type
        assertTrue("Expects Multiplicity instance.", obj != null && obj instanceof Multiplicity);

        Multiplicity multiplicity = (Multiplicity) obj;

        // verify the Multiplicity properties
        assertEquals("Failed to get correct size of multiplicity ranges", 1, multiplicity.getRanges().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:MultiplicityRange element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testMultiplicityRange() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007A3");

        // verify the type
        assertTrue("Expects MultiplicityRange instance.", obj != null && obj instanceof MultiplicityRange);

        MultiplicityRange multiplicityRange = (MultiplicityRange) obj;

        // verify the MultiplicityRange properties
        assertEquals("Failed to get correct lower value.", 1, multiplicityRange.getLower());
        assertEquals("Failed to get correct upper value.", 1, multiplicityRange.getUpper());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Expression element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testExpression() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000082F");

        // verify the type
        assertTrue("Expects Expression instance.", obj != null && obj instanceof Expression);

        Expression expression = (Expression) obj;

        // verify the Expression properties
        assertEquals("Failed to get correct language.", "Java", expression.getLanguage());
        assertEquals("Failed to get correct body.", "19", expression.getBody());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:BooleanExpression element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testBooleanExpression() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000086F");

        // verify the type
        assertTrue("Expects BooleanExpression instance.", obj != null && obj instanceof BooleanExpression);

        BooleanExpression expression = (BooleanExpression) obj;

        // verify the BooleanExpression properties
        assertEquals("Failed to get correct language.", "Java", expression.getLanguage());
        assertEquals("Failed to get correct body.", "value1", expression.getBody());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:ProcedureExpression element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testProcedureExpression() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000834");

        // verify the type
        assertTrue("Expects ProcedureExpression instance.", obj != null && obj instanceof ProcedureExpression);

        ProcedureExpression expression = (ProcedureExpression) obj;

        // verify the ProcedureExpression properties
        assertEquals("Failed to get correct language.", "Java", expression.getLanguage());
        assertEquals("Failed to get correct body.", "System.out.println(\"Yes\");", expression.getBody().trim());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Class element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testClass() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000079C");

        // verify the type
        assertTrue("Expects Class instance.", obj != null && obj instanceof Class);

        Class type = (Class) obj;

        // verify the Class properties
        assertEquals("Failed to get correct name.", "HelloWorld", type.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, type.getVisibility());
        assertFalse("Failed to get correct specification value.", type.isSpecification());
        assertFalse("Failed to get correct leaf value.", type.isLeaf());
        assertFalse("Failed to get correct root value.", type.isRoot());
        assertFalse("Failed to get correct abstract value.", type.isAbstract());
        assertFalse("Failed to get correct active value.", type.isActive());
        assertEquals("Failed to get correct size of features.", 5, type.getFeatures().size());

        List<Feature> features = type.getFeatures();
        Feature feature = features.get(0);
        assertTrue("Failed to get correct feature.", feature instanceof Attribute);
        assertEquals("Failed to get correct feature.", "newAttr", feature.getName());

        feature = features.get(1);
        assertTrue("Failed to get correct feature.", feature instanceof Operation);
        assertEquals("Failed to get correct feature.", "newOperation", feature.getName());

        feature = features.get(2);
        assertTrue("Failed to get correct feature.", feature instanceof Attribute);
        assertEquals("Failed to get correct feature.", "newAttr", feature.getName());

        feature = features.get(3);
        assertTrue("Failed to get correct feature.", feature instanceof Method);
        assertEquals("Failed to get correct feature.", "newOperation", feature.getName());

        feature = features.get(4);
        assertTrue("Failed to get correct feature.", feature instanceof Method);
        assertEquals("Failed to get correct feature.", "newOperation", feature.getName());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:DataType element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testDataType() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007A0");

        // verify the type
        assertTrue("Expects DataType instance.", obj != null && obj instanceof DataType);

        DataType type = (DataType) obj;

        // verify the DataType properties
        assertEquals("Failed to get correct name.", "int", type.getName());
        assertFalse("Failed to get correct specification value.", type.isSpecification());
        assertFalse("Failed to get correct leaf value.", type.isLeaf());
        assertFalse("Failed to get correct root value.", type.isRoot());
        assertFalse("Failed to get correct abstract value.", type.isAbstract());
        assertEquals("Failed to get correct size of features.", 0, type.getFeatures().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:AssociationEnd element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAssociationEnd() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007AB");

        // verify the type
        assertTrue("Expects AssociationEnd instance.", obj != null && obj instanceof AssociationEnd);

        AssociationEnd associationEnd = (AssociationEnd) obj;

        // verify the AssociationEnd properties
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, associationEnd.getVisibility());
        assertFalse("Failed to get correct specification value.", associationEnd.isSpecification());
        assertTrue("Failed to get correct navigable value.", associationEnd.isNavigable());
        assertEquals("Failed to get correct ordering", OrderingKind.UNORDERED, associationEnd.getOrdering());
        assertEquals("Failed to get correct aggregation kind", AggregationKind.NONE, associationEnd.getAggregation());
        assertEquals("Failed to get correct target scope kind", ScopeKind.INSTANCE, associationEnd.getTargetKind());
        assertEquals("Failed to get correct changeability", ChangeableKind.CHANGEABLE,
            associationEnd.getChangeability());
        assertNotNull("The multiplicity property should be set.", associationEnd.getMultiplicity());
        assertNotNull("The participant property should be set.", associationEnd.getParticipant());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Interface element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testInterface() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000079E");

        // verify the type
        assertTrue("Expects Interface instance.", obj != null && obj instanceof Interface);

        Interface type = (Interface) obj;

        // verify the Interface properties
        assertEquals("Failed to get correct name.", "MyInterface", type.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, type.getVisibility());
        assertFalse("Failed to get correct specification value.", type.isSpecification());
        assertFalse("Failed to get correct leaf value.", type.isLeaf());
        assertFalse("Failed to get correct root value.", type.isRoot());
        assertFalse("Failed to get correct abstract value.", type.isAbstract());
        assertEquals("Failed to get correct size of stereotypes.", 1, type.getStereotypes().size());
        assertEquals("Failed to get correct size of features.", 0, type.getFeatures().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Association element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAssociation() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007B3");

        // verify the type
        assertTrue("Expects Association instance.", obj != null && obj instanceof Association);

        Association association = (Association) obj;

        // verify the Association properties
        assertEquals("Failed to get correct name.", "assoc", association.getName());
        assertFalse("Failed to get correct specification value.", association.isSpecification());
        assertFalse("Failed to get correct leaf value.", association.isLeaf());
        assertFalse("Failed to get correct root value.", association.isRoot());
        assertFalse("Failed to get correct abstract value.", association.isAbstract());
        assertEquals("Failed to get correct size of connections.", 2, association.getConnections().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Attribute element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAttribute() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000083A");

        // verify the type
        assertTrue("Expects Attribute instance.", obj != null && obj instanceof Attribute);

        Attribute attribute = (Attribute) obj;

        // verify the Attribute properties
        assertEquals("Failed to get correct name.", "newAttr", attribute.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, attribute.getVisibility());
        assertFalse("Failed to get correct specification value.", attribute.isSpecification());
        assertEquals("Failed to get correct owner scope kind", ScopeKind.INSTANCE, attribute.getOwnerScope());
        assertEquals("Failed to get correct target scope kind", ScopeKind.INSTANCE, attribute.getTargetScope());
        assertEquals("Failed to get correct changeability", ChangeableKind.CHANGEABLE, attribute.getChangeability());
        assertNotNull("The multiplicity property should be set.", attribute.getMultiplicity());
        assertNotNull("The initial value property should be set.", attribute.getInitialValue());
        assertNotNull("The type property should be set.", attribute.getType());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Operation element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testOperation() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007A5");

        // verify the type
        assertTrue("Expects Operation instance.", obj != null && obj instanceof Operation);

        Operation operation = (Operation) obj;

        // verify the Operation properties
        assertEquals("Failed to get correct name.", "newOperation", operation.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, operation.getVisibility());
        assertFalse("Failed to get correct specification value.", operation.isSpecification());
        assertFalse("Failed to get correct query value.", operation.isQuery());
        assertFalse("Failed to get correct leaf value.", operation.isLeaf());
        assertFalse("Failed to get correct root value.", operation.isRoot());
        assertFalse("Failed to get correct abstract value.", operation.isAbstract());
        assertEquals("Failed to get correct owner scope kind", ScopeKind.INSTANCE, operation.getOwnerScope());
        assertEquals("Failed to get correct concurrency kind", CallConcurrencyKind.SEQUENTIAL,
            operation.getConcurrency());
        assertEquals("Failed to get correct size of parameters", 1, operation.getParameters().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Parameter element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testParameter() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007A6");

        // verify the type
        assertTrue("Expects Parameter instance.", obj != null && obj instanceof Parameter);

        Parameter parameter = (Parameter) obj;

        // verify the Parameter properties
        assertEquals("Failed to get correct name.", "return", parameter.getName());
        assertFalse("Failed to get correct specification value.", parameter.isSpecification());
        assertEquals("Failed to get correct parameter direction kind.", ParameterDirectionKind.RETURN,
            parameter.getKind());
        assertNotNull("The type parameter should be set.", parameter.getType());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Method element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testMethod() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000833");

        // verify the type
        assertTrue("Expects Method instance.", obj != null && obj instanceof Method);

        Method method = (Method) obj;

        // verify the Method properties
        assertEquals("Failed to get correct name.", "newOperation", method.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, method.getVisibility());
        assertFalse("Failed to get correct specification value.", method.isSpecification());
        assertFalse("Failed to get correct query value.", method.isQuery());
        assertEquals("Failed to get correct owner scope kind", ScopeKind.INSTANCE, method.getOwnerScope());
        assertNotNull("The body property should be set.", method.getBody());
        assertNotNull("The specification property should be set.", method.getSpecification());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Generalization element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGeneralization() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007D0");

        // verify the type
        assertTrue("Expects Generalization instance.", obj != null && obj instanceof Generalization);

        Generalization generalization = (Generalization) obj;

        // verify the Generalization properties
        assertFalse("Failed to get correct specification value.", generalization.isSpecification());
        assertEquals("Failed to get correct size of stereotypes.", 1, generalization.getStereotypes().size());
        assertNotNull("The body property should be set.", generalization.getChild());
        assertNotNull("The specification property should be set.", generalization.getParent());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:AssociationClass element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAssociationClass() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007AA");

        // verify the type
        assertTrue("Expects AssociationClass instance.", obj != null && obj instanceof AssociationClass);

        AssociationClass associationClass = (AssociationClass) obj;

        // verify the AssociationClass properties
        assertEquals("Failed to get correct name.", "MyAssociationClass", associationClass.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PUBLIC, associationClass.getVisibility());
        assertFalse("Failed to get correct specification value.", associationClass.isSpecification());
        assertFalse("Failed to get correct leaf value.", associationClass.isLeaf());
        assertFalse("Failed to get correct root value.", associationClass.isRoot());
        assertFalse("Failed to get correct abstract value.", associationClass.isAbstract());
        assertFalse("Failed to get correct active value.", associationClass.isActive());
        assertEquals("Failed to get correct size of client dependencies.", 1,
            associationClass.getClientDependencies().size());
        assertEquals("Failed to get correct size of connections.", 2, associationClass.getConnections().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Abstraction element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAbstraction() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007D2");

        // verify the type
        assertTrue("Expects Abstraction instance.", obj != null && obj instanceof Abstraction);

        Abstraction abstraction = (Abstraction) obj;

        // verify the Abstraction properties
        assertFalse("Failed to get correct specification value.", abstraction.isSpecification());
        assertEquals("Failed to get correct size of stereotypes.", 1, abstraction.getStereotypes().size());
        assertEquals("Failed to get correct size of suppliers.", 1, abstraction.getSuppliers().size());
        assertEquals("Failed to get correct size of clients.", 1, abstraction.getClients().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Comment element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testComment() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007D9");

        // verify the type
        assertTrue("Expects Comment instance.", obj != null && obj instanceof Comment);

        Comment comment = (Comment) obj;

        // verify the Comment properties
        assertFalse("Failed to get correct specification value.", comment.isSpecification());
        assertEquals("Failed to get correct size of annotated elements.", 1, comment.getAnnotatedElements().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Enumeration element is parsed correctly.
     * </p>
     *
     * <p>
     * Note, this test case also tests the IDREF attribute is properly parsed by the handler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testEnumeration() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000836");

        // verify the type
        assertTrue("Expects Enumeration instance.", obj != null && obj instanceof Enumeration);

        Enumeration enumeration = (Enumeration) obj;

        // verify the Enumeration properties
        assertEquals("Failed to get correct name.", "Enumeration", enumeration.getName());
        assertEquals("Failed to get correct visibility", VisibilityKind.PROTECTED, enumeration.getVisibility());
        assertFalse("Failed to get correct specification value.", enumeration.isSpecification());
        assertFalse("Failed to get correct leaf value.", enumeration.isLeaf());
        assertFalse("Failed to get correct root value.", enumeration.isRoot());
        assertTrue("Failed to get correct abstract value.", enumeration.isAbstract());
        assertEquals("Failed to get correct size of stereotypes.", 1, enumeration.getStereotypes().size());
        assertEquals("Failed to get correct size of literals.", 1, enumeration.getLiterals().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:EnumerationLiteral element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testEnumerationLiteral() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000837");

        // verify the type
        assertTrue("Expects EnumerationLiteral instance.", obj != null && obj instanceof EnumerationLiteral);

        EnumerationLiteral enumerationLiteral = (EnumerationLiteral) obj;

        // verify the EnumerationLiteral properties
        assertEquals("Failed to get correct name.", "anon", enumerationLiteral.getName());
        assertFalse("Failed to get correct specification value.", enumerationLiteral.isSpecification());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Stereotype element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testStereotype() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000871");

        // verify the type
        assertTrue("Expects Stereotype instance.", obj != null && obj instanceof Stereotype);

        Stereotype stereotype = (Stereotype) obj;

        // verify the Stereotype properties
        assertEquals("Failed to get correct name.", "callAction1", stereotype.getName());
        assertEquals("Failed to get correct base class value.", "CallAction", stereotype.getBaseClass());
        assertFalse("Failed to get correct specification value.", stereotype.isSpecification());
        assertFalse("Failed to get correct leaf value.", stereotype.isLeaf());
        assertFalse("Failed to get correct root value.", stereotype.isRoot());
        assertFalse("Failed to get correct abstract value.", stereotype.isAbstract());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:TagDefinition element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testTagDefinition() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000813");

        // verify the type
        assertTrue("Expects TagDefinition instance.", obj != null && obj instanceof TagDefinition);

        TagDefinition tagDefinition = (TagDefinition) obj;

        // verify the TagDefinition properties
        assertEquals("Failed to get correct name.", "documentation", tagDefinition.getName());
        assertFalse("Failed to get correct specification value.", tagDefinition.isSpecification());
        assertEquals("Failed to get correct tag type value.", "String", tagDefinition.getTagType());
        assertNotNull("The multiplicity property should be set.", tagDefinition.getMultiplicity());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:TaggedValue element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testTaggedValue() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:0000000000000812");

        // verify the type
        assertTrue("Expects TaggedValue instance.", obj != null && obj instanceof TaggedValue);

        TaggedValue taggedValue = (TaggedValue) obj;

        // verify the TaggedValue properties
        assertEquals("Failed to get correct name.", "HelloWorld", taggedValue.getDataValue());
        assertFalse("Failed to get correct specification value.", taggedValue.isSpecification());
        assertNotNull("The type property should be set.", taggedValue.getType());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Collaboration element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCollaboration() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000077C");

        // verify the type
        assertTrue("Expects Collaboration instance.", obj != null && obj instanceof Collaboration);

        Collaboration collaboration = (Collaboration) obj;

        // verify the Collaboration properties
        assertEquals("Failed to get correct name.", "unattachedCollaboration", collaboration.getName());
        assertFalse("Failed to get correct specification value.", collaboration.isSpecification());
        assertFalse("Failed to get correct leaf value.", collaboration.isLeaf());
        assertFalse("Failed to get correct root value.", collaboration.isRoot());
        assertFalse("Failed to get correct abstract value.", collaboration.isAbstract());
        assertEquals("Failed to get correct size of owned elements", 2, collaboration.getOwnedElements().size());

        Collection<ModelElement> elements = collaboration.getOwnedElements();
        Iterator<ModelElement> it = elements.iterator();
        ModelElement element1 = it.next();
        ModelElement element2 = it.next();

        if (element1 instanceof Comment) {
            assertTrue("Failed to get correct owned element.", element2 instanceof Stereotype);
        } else {
            assertTrue("Failed to get correct owned element.", element1 instanceof Stereotype);
            assertTrue("Failed to get correct owned element.", element2 instanceof Comment);
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Package element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testPackage() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000079B");

        // verify the type
        assertTrue("Expects Package instance.", obj != null && obj instanceof Package);

        Package pkg = (Package) obj;

        // verify the Package properties
        assertFalse("Failed to get correct specification value.", pkg.isSpecification());
        assertFalse("Failed to get correct leaf value.", pkg.isLeaf());
        assertFalse("Failed to get correct root value.", pkg.isRoot());
        assertFalse("Failed to get correct abstract value.", pkg.isAbstract());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Model element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testModel() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:000000000000077B");

        // verify the type
        assertTrue("Expects Model instance.", obj != null && obj instanceof Model);

        Model model = (Model) obj;

        // verify the Model properties
        assertEquals("Failed to get correct name.", "untitledModel", model.getName());
        assertFalse("Failed to get correct specification value.", model.isSpecification());
        assertFalse("Failed to get correct leaf value.", model.isLeaf());
        assertFalse("Failed to get correct root value.", model.isRoot());
        assertFalse("Failed to get correct abstract value.", model.isAbstract());

        assertEquals("Failed to get correct size of owned elements.", 41, model.getOwnedElements().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Actor element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testActor() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007D6");

        // verify the type
        assertTrue("Expects Actor instance.", obj != null && obj instanceof Actor);

        Actor actor = (Actor) obj;

        // verify the Actor properties
        assertFalse("Failed to get correct specification value.", actor.isSpecification());
        assertFalse("Failed to get correct leaf value.", actor.isLeaf());
        assertFalse("Failed to get correct root value.", actor.isRoot());
        assertFalse("Failed to get correct abstract value.", actor.isAbstract());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:UseCase element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUseCase() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007D7");

        // verify the type
        assertTrue("Expects UseCase instance.", obj != null && obj instanceof UseCase);

        UseCase useCase = (UseCase) obj;

        // verify the UseCase properties
        assertFalse("Failed to get correct specification value.", useCase.isSpecification());
        assertFalse("Failed to get correct leaf value.", useCase.isLeaf());
        assertFalse("Failed to get correct root value.", useCase.isRoot());
        assertFalse("Failed to get correct abstract value.", useCase.isAbstract());
        assertEquals("Failed to get correct size of generalizations.", 1, useCase.getGeneralizations().size());
        assertEquals("Failed to get correct size of includes.", 1, useCase.getIncludes().size());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Include element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testInclude() throws Exception {
        reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));

        Object obj = reader.getElement("-64--88-1-55--1e9f2c8:10f94402c4c:-8000:00000000000007DA");

        // verify the type
        assertTrue("Expects Include instance.", obj != null && obj instanceof Include);

        Include include = (Include) obj;

        // verify the Include properties
        assertFalse("Failed to get correct specification value.", include.isSpecification());
        assertNotNull("The addition property should be set.", include.getAddition());
        assertNotNull("The addition property should be set.", include.getBase());
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when the xmi reader is null for the activityHandler during parsing
     * and expects IllegalStateException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNullXMIReader() throws Exception {
        XMI2ModelHandler modelHandler = new XMI2ModelHandler();
        modelHandler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
        reader.addHandler("UML:Model", modelHandler);

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Multiplicity in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForMultiplicity() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Multiplicity");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:MultiplicityRange in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForMultiplicityRange() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:MultiplicityRange");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Expression in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForExpression() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Expression");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:BooleanExpression in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForBooleanExpression() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:BooleanExpression");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:ProcedureExpression in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForProcedureExpression() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:ProcedureExpression");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Class in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForClass() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Class");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:DataType in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForDataType() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:DataType");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:AssociationEnd in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForAssociationEnd() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:AssociationEnd");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Interface in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForInterface() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Interface");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Association in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForAssociation() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Association");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Attribute in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForAttribute() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Attribute");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Operation in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForOperation() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Operation");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Parameter in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForParameter() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Parameter");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Method in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForMethod() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Method");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Generalization in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForGeneralization() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Generalization");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:AssociationClass in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForAssociationClass() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:AssociationClass");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Abstraction in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForAbstraction() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Abstraction");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Comment in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForComment() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Comment");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Enumeration in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForEnumeration() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Enumeration");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:EnumerationLiteral in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForEnumerationLiteral() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:EnumerationLiteral");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Stereotype in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForStereotype() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Stereotype");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:TagDefinition in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForTagDefinition() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:TagDefinition");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:TaggedValue in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForTaggedValue() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:TaggedValue");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Collaboration in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForCollaboration() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Collaboration");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Package in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForPackage() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Package");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Model in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForModel() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Model");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Actor in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForActor() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Actor");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:UseCase in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForUseCase() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:UseCase");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link XMI2ModelHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link XMI2ModelHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Include in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the XMI2ModelHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForInclude() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Include");

        try {
            reader.parse(new File("test_files" + File.separator + "model_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies XMI2ModelHandler subclasses XMIHandler.
     * </p>
     */
    public void testXMI2ModelHandlerInheritance() {
        assertTrue("XMI2ModelHandler does not subclass XMIHandler.", new XMI2ModelHandler() instanceof XMIHandler);
    }
}