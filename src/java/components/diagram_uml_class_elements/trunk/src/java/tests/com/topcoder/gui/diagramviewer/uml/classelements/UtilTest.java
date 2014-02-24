/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;

/**
 * <p>
 * Test the functionality of <code>Util</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class UtilTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(280, 140);

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** A GraphNode for <code>ClassNode</code>. */
    private GraphNode classGraphNode;

    /** An instance of <code>EnumerationNode</code> for testing. */
    private EnumerationNode enumerationNode;

    /** A GraphNode for <code>EnumerationNode</code>. */
    private GraphNode enumerationGraphNode;

    /** An instance of <code>PackageNode</code> for testing. */
    private PackageNode packageNode;

    /** A GraphNode for <code>PackageNode</code>. */
    private GraphNode packageGraphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        classGraphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);

        enumerationGraphNode = TestUtil.createEnumerationGraphNode(POSITION, SIZE);

        packageGraphNode = TestUtil.createPackageGraphNode(POSITION, SIZE);

        properties = TestUtil.createProperties();

        classNode = new ClassNode(classGraphNode, properties);

        enumerationNode = new EnumerationNode(enumerationGraphNode, properties);

        packageNode = new PackageNode(packageGraphNode, properties, new TransferHandler(null));
    }

    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with <code>null</code> Argument.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testCheckNotNullWithNullArgument() {
        try {
            Util.checkNotNull(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with non null Argument. No exception
     * should be thrown.
     * </p>
     */
    public void testCheckNotNullWithUnNullArgument() {
        try {
            Util.checkNotNull(new Object(), "test");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with <code>null</code>
     * Argument. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testCheckMapNotNullOrEmptyWithNull() {
        try {
            Util.checkMapNotNullOrContainingEmpty(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with map containing null.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testCheckMapWithContainNull() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put(null, null);
            Util.checkMapNotNullOrContainingEmpty(map, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Test the method <code>chekMapNotNullOrContainingEmpty(Map map, String name)</code> with good map. No exception
     * should be thrown.
     * </p>
     */
    public void testCheckMapNotNullOrEmpty() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("a", "b");
            Util.checkMapNotNullOrContainingEmpty(map, "test");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>checkCollectionNotNull(Collection collection, String name)</code> with <code>null</code>
     * Argument. <code>IllegalArgumentException</code> should be thrown.
     * </p>
     */
    public void testCheckCollectionNotNullWithNull() {
        try {
            Util.checkCollectionNotNull(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test the method <code>checkCollectionNotNull(Collection collection, String name)</code> with non null Argument.
     * No exception should be thrown.
     * </p>
     */
    public void testCheckCollectionNotNullContainNull() {
        try {
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);
            Util.checkCollectionNotNull(collection, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test the method <code>checkCollectionNotNull(Collection collection, String name)</code> with non null
     * Argument.No exception should be thrown.
     * </p>
     */
    public void testCheckCollectionNotNull() {
        try {
            Util.checkCollectionNotNull(new ArrayList<Object>(), "test");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    /**
     * Test method for 'checkPackageGraphNode(GraphNode)'. The argument is a correct graph node for PackageNode, no
     * exception should be thrown.
     */
    public void testCheckPackageGraphNode_Accuracy() {
        try {
            Util.checkPackageGraphNode(packageGraphNode);
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'checkPackageGraphNode(GraphNode)'. The argument isn't a correct graph node for PackageNode,
     * IllegalGraphElementException should be thrown.
     */
    public void testCheckPackageGraphNode_Failure() {
        try {
            Util.checkPackageGraphNode(classGraphNode);
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'checkGraphNode(BaseNode)'. The argument is a ClassNode, no exception should be thrown.
     */
    public void testCheckGraphNode_ClassNode() {
        Util.checkGraphNode(classNode);
    }

    /**
     * Test method for 'checkGraphNode(BaseNode)'. The argument is a InterfaceNode, no exception should be thrown.
     */
    public void testCheckGraphNode_InterfaceNode() {
        GraphNode interfaceGraphNode = TestUtil.createClassGraphNode(POSITION, SIZE, true, false);
        Util.checkGraphNode(new InterfaceNode(interfaceGraphNode, properties));
    }

    /**
     * Test method for 'checkGraphNode(BaseNode)'. The argument is a ExceptionNode, no exception should be thrown.
     */
    public void testCheckGraphNode_ExceptionNode() {
        GraphNode exceptionGraphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, true);
        Util.checkGraphNode(new ExceptionNode(exceptionGraphNode, properties));
    }

    /**
     * Test method for 'checkGraphNode(BaseNode)'. The argument is a EnumerationNode, no exception should be thrown.
     */
    public void testCheckGraphNode_EnumerationNode() {
        Util.checkGraphNode(enumerationNode);
    }

    /**
     * Test method for 'parseFontFamily(String)'. The argument is null, "Arial" should be returned.
     */
    public void testParseFontFamily_null() {
        assertEquals("Null argument should be parsed as \"Arial\".", Util.parseFontFamily(null), "Arial");
    }

    /**
     * Test method for 'parseFontFamily(String)'. The argument is a non null string, should be returned directly.
     */
    public void testParseFontFamily() {
        assertEquals("Non null argument should be parsed correctly.", Util.parseFontFamily("value"), "value");
    }

    /**
     * Test method for 'parseFontStyle(String)'. The argument is null, 0 should be returned.
     */
    public void testParseFontStyle_null() {
        assertEquals("Null argument should be parsed as 0.", Util.parseFontStyle(null), 0);
    }

    /**
     * Test method for 'parseFontStyle(String)'. The argument is a incorrect string, default 0 should be returned.
     */
    public void testParseFontStyle_incorrect() {
        assertEquals("Incorrect argument should be parsed as 0.", Util.parseFontStyle("incorrect"), 0);
    }

    /**
     * Test method for 'parseFontStyle(String)'. The argument is a correct string, should be parsed correctly.
     */
    public void testParseFontStyle() {
        assertEquals("Correct argument should be parsed correctly.", Util.parseFontStyle("10"), 10);
    }

    /**
     * Test method for 'parseFontSize(String)'. The argument is null, default 11.0 should be returned.
     */
    public void testParseFontSize_null() {
        assertEquals("Null argument should be parsed as 11.0.", Util.parseFontSize(null), 11.0);
    }

    /**
     * Test method for 'parseFontSize(String)'. The argument is a incorrect string, default 11.0 should be returned.
     */
    public void testParseFontSize_incorrect() {
        assertEquals("Incorrect argument should be parsed as 11.0.", Util.parseFontSize("incorrect"), 11.0);
    }

    /**
     * Test method for 'parseFontSize(String)'. The argument is a correct string, should be parsed correctly.
     */
    public void testParseFontSize() {
        assertEquals("Correct argument should be parsed correctly.", Util.parseFontSize("10.0"), 10.0);
    }

    /**
     * Test method for 'parseColor(String)'. The argument is null, null should be returned.
     */
    public void testParseColor_null() {
        assertNull("Null argument should be parsed as null.", Util.parseColor(null));
    }

    /**
     * Test method for 'parseColor(String)'. The argument's length is not equal to six, null should be returned.
     */
    public void testParseColor_WrongLength() {
        assertNull("Wrong length argument should be parsed as null.", Util.parseColor("#00FFFF"));
    }

    /**
     * Test method for 'parseColor(String)'. The argument is incorrect, null should be returned.
     */
    public void testParseColor_incorrect() {
        assertNull("Incorrect argument should be parsed as null.", Util.parseColor("00XXYY"));
    }

    /**
     * Test method for 'parseColor(String)'. The argument is correct, should be parsed correctly.
     */
    public void testParseColor() {
        String red = "FF0000";
        assertEquals("Correct argument should be parsed correctly.", Util.parseColor(red), Color.RED);
    }

    /**
     * Test method for 'getPropertyValue(GraphNode, Map, String)'. The key argument can't be found, null should be
     * returned.
     */
    public void testGetPropertyValue_NoSuchKey() {
        assertNull("Null should returned if no such key.", Util.getPropertyValue(classGraphNode, properties,
                "NoSuchKey"));
    }

    /**
     * Test method for 'getPropertyValue(GraphNode, Map, String)'. The key argument can be found, its value should be
     * returned.
     */
    public void testGetPropertyValue() {
        classGraphNode.addProperty(TestUtil.createProperty("key", "value"));
        properties.put("key", "key");
        assertEquals("Its value should returned if such key exists.", Util.getPropertyValue(classGraphNode, properties,
                "key"), "value");
    }

    /**
     * Test method for 'getGraphNodeSize(GraphNode)'. The size of given graph node is null, IllegalGraphElementException
     * should be thrown.
     */
    public void testGetGraphNodeSize_null() {
        try {
            Util.getGraphNodeSize(new GraphNode());
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'getGraphNodeSize(GraphNode)'. The size of given graph node is not null, should be got correctly.
     */
    public void testGetGraphNodeSize_Accuracy() {
        Dimension size = Util.getGraphNodeSize(classGraphNode);
        assertEquals("Size of correct graph node should be got correctly.", size, SIZE);
    }

    /**
     * Test method for 'getGraphNodePosition(GraphNode)'. The position of given graph node is null,
     * IllegalGraphElementException should be thrown.
     */
    public void testGetGraphNodePosition_null() {
        try {
            Util.getGraphNodeSize(new GraphNode());
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'getGraphNodePosition(GraphNode)'. The position of given graph node is not null, should be got
     * correctly.
     */
    public void testGetGraphNodePosition_Accuracy() {
        GraphNode viewerNode = new GraphNode();
        classGraphNode.setContainer(viewerNode);

        Point position = Util.getGraphNodePosition(classGraphNode);

        assertEquals("Position of correct graph node should be got correctly.", position, POSITION);
    }

    /**
     * Test method for 'updateNodeBound(Node, int, Dimension, String)'. The node's boundary should be updated correctly.
     */
    public void testUpdateNodeBound() {
        Util.updateNodeBound(classNode, SelectionCorner.DEFAULT_RADIUS, new Dimension(120, 80), "");
    }

    /**
     * Test method for 'rearrangeCompartments(Node, int)'. The compartments should be rearranged correctly.
     */
    public void testRearrangeCompartments() {
        assertNotNull(Util.rearrangeCompartments(classNode, SelectionCorner.DEFAULT_RADIUS));
    }

    /**
     * Test method for 'updateGroupProperties(BaseNode, GroupTextField)'. The properties of given GroupTextField should
     * be updated correctly.
     */
    public void testUpdateGroupProperties() {
        GroupTextField attribute = enumerationNode.getAttributesCompartment();
        Util.updateGroupProperties(enumerationNode, attribute);
        assertEquals("The properties should be updated correctly.", enumerationNode.getFont(), attribute.getFont());
        assertEquals("The properties should be updated correctly.", enumerationNode.getFillColor(), attribute
                .getFillColor());
        assertEquals("The properties should be updated correctly.", enumerationNode.getFontColor(), attribute
                .getFontColor());
        assertEquals("The properties should be updated correctly.", enumerationNode.getStrokeColor(), attribute
                .getStrokeColor());
    }

    /**
     * Test method for 'updateNameCompartments(int, Node, int)'. Location and font color of compartments should be
     * updated correctly.
     */
    public void testUpdateNameCompartments() {
        Util.updateNameCompartments(SelectionCorner.DEFAULT_RADIUS, packageNode, 100);
        assertEquals("Font color should be updated correctly.", packageNode.getStereotypeCompartment().getFontColor(),
                packageNode.getFontColor());
        assertEquals("Font color should be updated correctly.", packageNode.getNameCompartment().getFontColor(),
                packageNode.getFontColor());
        assertEquals("Font color should be updated correctly.", packageNode.getNamespaceCompartment().getFontColor(),
                packageNode.getFontColor());
    }

    /**
     * Test method for 'updateGroupTextField(GroupTextField, int)'. The items should be relocated and resized correctly.
     */
    public void testUpdateGroupTextField() {
        Util.updateGroupTextField(enumerationNode.getOperationsCompartment(), 200);
    }

    /**
     * Test method for 'getElement(GraphElement)'. Model element of given graph element should be got correctly.
     */
    public void testGetElement() {
        assertTrue("Model element of given graph element should be got correctly.",
                Util.getElement(classGraphNode) instanceof ClassImpl);
    }

    /**
     * Test method for 'getCompartmentGraphNode(GraphNode, int)'. The graph node argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testGetCompartmentGraphNode_null() {
        try {
            Util.getCompartmentGraphNode(null, 0);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Success
        }
    }

    /**
     * Test method for 'getCompartmentGraphNode(GraphNode, int)'. The index is 1, name graph node should be got.
     */
    public void testGetCompartmentGraphNode() {
        GraphNode name = Util.getCompartmentGraphNode(enumerationGraphNode, 1);
        assertNotNull("Name graph node should be got.", name);
    }

    /**
     * Test method for 'getAttributes(BaseNode)'. The argument is a ClassNode, its attributes should be got correctly.
     */
    public void testGetAttributes_CalssNode() {
        ArrayList<StereotypeTextField> attributes = Util.getAttributes(classNode);
        assertNotNull("Attributes should be got correctly.", attributes);
        assertTrue("Attributes should be got correctly.", attributes.size() > 1);
    }

    /**
     * Test method for 'getAttributes(BaseNode)'. The argument is a EnumerationNode, its attributes should be got
     * correctly.
     */
    public void testGetAttributes_EnumerationNode() {
        ArrayList<StereotypeTextField> attributes = Util.getAttributes(enumerationNode);
        assertNotNull("Attributes should be got correctly.", attributes);
        assertTrue("Attributes should be got correctly.", attributes.size() > 1);
    }

    /**
     * Test method for 'getOperations(BaseNode)'. The argument is a ClassNode, its operations should be got correctly.
     */
    public void testGetOperations_CalssNode() {
        ArrayList<StereotypeTextField> operations = Util.getOperations(classNode);
        assertNotNull("Operations should be got correctly.", operations);
        assertTrue("Operations should be got correctly.", operations.size() > 1);
    }

    /**
     * Test method for 'getOperations(BaseNode)'. The argument is a EnumerationNode, its operations should be got
     * correctly.
     */
    public void testGetOperations_EnumerationNode() {
        ArrayList<StereotypeTextField> operations = Util.getOperations(enumerationNode);
        assertNotNull("Operations should be got correctly.", operations);
        assertTrue("Operations should be got correctly.", operations.size() > 1);
    }

    /**
     * Test method for 'getEnumerationLiterals(GraphNode)'. The argument is a graph node for EnumerationNode, the
     * enumeration literals should be got correctly.
     */
    public void testGetEnumerationLiterals() {
        ArrayList<StereotypeTextField> literals = Util.getEnumerationLiterals(enumerationGraphNode);
        assertNotNull("Literals should be got correctly.", literals);
        Enumeration enumeration = (Enumeration) Util.getElement(enumerationGraphNode);
        assertEquals("Literals should be got correctly.", literals.size(), enumeration.getLiterals().size());
    }

    /**
     * Test method for 'combineSize(Dimension, Dimension, boolean)'. Gap is not required, size should be got correctly.
     */
    public void testCombineSize_WithoutGap() {
        Dimension size = new Dimension(SIZE);
        Util.combineSize(size, SIZE, false);
        assertEquals("Size should be got correctly.", size, new Dimension(SIZE.width, SIZE.height * 2));
    }

    /**
     * Test method for 'combineSize(Dimension, Dimension, boolean)'. Gap is required, size should be got correctly.
     */
    public void testCombineSize_WithGap() {
        Dimension size = new Dimension(SIZE);
        Util.combineSize(size, SIZE, true);
        assertEquals("Size should be got correctly.", size, new Dimension(SIZE.width, (int) Math.round(SIZE.height * 2
                + SIZE.height * Util.GAP_PERCENT)));
    }

    /**
     * Test method for 'getPreferredCompartmentsSize(TextField, TextField, TextField)'. The preferred size should be got
     * correctly.
     */
    public void testGetPreferredCompartmentsSize() {
        TextField stereotype = packageNode.getStereotypeCompartment();
        TextField name = packageNode.getNameCompartment();
        TextField namespace = packageNode.getNamespaceCompartment();
        Dimension size = Util.getPreferredCompartmentsSize(stereotype, name, namespace);
        assertNotNull("The preferred size should be got correctly.", size);
    }

    /**
     * Test method for 'createSelectionCornerTypes()'. The selection corners should be created correctly.
     */
    public void testCreateSelectionCornerTypes() {
        Collection<SelectionCornerType> corners = Util.createSelectionCornerTypes();
        assertNotNull("The selection corners should be created correctly.", corners);
        assertEquals("The selection corners should be created correctly.", corners.size(), 8);
    }

    /**
     * Test method for 'consumeEvent(BaseNode, MouseEvent)'. Valid arguments is provided, event should be consumed.
     */
    public void testConsumeEvent_True() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MousePressed event should be consumed.", Util.consumeEvent(classNode, event));
    }

    /**
     * Test method for 'consumeEvent(BaseNode, MouseEvent)'. Invalid arguments is provided, event shouldn't be consumed.
     */
    public void testConsumeEvent_False() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MousePressed event should not be consumed.", Util.consumeEvent(classNode, event));
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        classGraphNode = null;

        enumerationGraphNode = null;

        packageGraphNode = null;

        properties = null;

        classNode = null;

        enumerationNode = null;

        packageNode = null;
    }
}
