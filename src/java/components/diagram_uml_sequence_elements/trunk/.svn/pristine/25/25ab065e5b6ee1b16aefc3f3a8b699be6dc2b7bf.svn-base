package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelinePropertyType;

/**
 * <p>
 * Failure tests for the class <code>Lifeline</code>.
 * </p>
 *
 * @author kaqi072821
 * @version 1.1
 * @since 1.1
 */
public class LifelineFailureTest extends TestCase {
    /**
     * <p>
     * <code>Lifeline</code> instance under test.
     * </p>
     */
    private Lifeline lifeline;

    /**
     * The propertyName map used in the test.
     */
    private EnumMap<LifelinePropertyType, String> propertyNameMapping;

    /**
     * The GraphEdge used in the test.
     */
    private GraphEdge edge;

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     */
    protected void setUp() {
        propertyNameMapping = new EnumMap<LifelinePropertyType, String>(LifelinePropertyType.class);
        propertyNameMapping.put(LifelinePropertyType.BLANK_LENGTH, "4");
        propertyNameMapping.put(LifelinePropertyType.DASH_LENGTH, "4");
        propertyNameMapping.put(LifelinePropertyType.LIFELINE_LENGTH, "100");
        propertyNameMapping.put(LifelinePropertyType.RENDER_SCHEME, "1");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_COLOR, "#000000");
        propertyNameMapping.put(LifelinePropertyType.STROKE_COLOR, "#000000");
        propertyNameMapping.put(LifelinePropertyType.SHADOW_LENGTH, "5");

        edge = new GraphEdge();
        edge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        edge.addWaypoint(new com.topcoder.diagraminterchange.Point());
        lifeline = new Lifeline(edge, propertyNameMapping);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() {
        lifeline = null;
        propertyNameMapping = null;
        edge = null;
    }

    /**
     * <p>
     * Failure test for the constructor. IllegalArgumentException expected when graphEdge is null.
     * </p>
     */
    public void testCtorFailure_graphEdgeNull() {
        try {
            new Lifeline(null, propertyNameMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for the constructor. IllegalArgumentException expected when propertyNameMapping is null.
     * </p>
     */
    public void testCtorFailure_propertyNameMappingNull() {
        try {
            new Lifeline(edge, null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for the constructor. IllegalArgumentException expected when propertyNameMapping is empty.
     * </p>
     */
    public void testCtorFailure_propertyNameMappingEmpty() {
        try {
            new Lifeline(edge, new EnumMap<LifelinePropertyType, String>(LifelinePropertyType.class));
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for the constructor. IllegalArgumentException expected when propertyNameMapping contains null value.
     * </p>
     */
    public void testCtorFailure_propertyNameMappingContainNullValue() {
        propertyNameMapping.remove(LifelinePropertyType.BLANK_LENGTH);
        propertyNameMapping.put(LifelinePropertyType.BLANK_LENGTH, null);
        try {
            new Lifeline(edge, propertyNameMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Failure test for the constructor. IllegalArgumentException expected when propertyNameMapping contains empty
     * value.
     * </p>
     */
    public void testCtorFailure_propertyNameMappingContainEmpty() {
        propertyNameMapping.remove(LifelinePropertyType.BLANK_LENGTH);
        propertyNameMapping.put(LifelinePropertyType.BLANK_LENGTH, "");
        try {
            new Lifeline(edge, propertyNameMapping);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setDashLength() method. IllegalArgumentException expected when the parameter is 0 or less than 0.
     */
    public void testSetDashLengthFailure() {
        try {
            lifeline.setDashLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }

        try {
            lifeline.setDashLength(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setStrokeColor method.IllegalArgumentException expected when the parameter is null.
     */
    public void testSetStrokeColorFailure() {
        try {
            lifeline.setStrokeColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure Test of setBlankLength method. IllegalArgumentException expected when the parameter is less than 0.
     */
    public void testSetBlankLengthFailure() {
        try {
            lifeline.setBlankLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setRenderScheme method. IllegalArgumentException expected when the parameter is null.
     */
    public void testSetRenderSchemeFailure() {
        try {
            lifeline.setRenderScheme(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setLifelineLength method.IllegalArgumentException expected when the parameter is 0 or less than
     * 0.
     */
    public void testSetLifelineLengthFailure() {
        try {
            lifeline.setLifelineLength(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
        try {
            lifeline.setLifelineLength(-5);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setLifelineLength method.
     */
    public void testSetShadowLengthFailure() {

        try {
            lifeline.setShadowLength(-15);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test of setPropertyNameMappingElement method. IllegalArgumentException expected when the key is null.
     */
    public void testSetPropertyNameMappingElement_keyNull() {
        try {
            lifeline.setPropertyNameMappingElement(null, "3");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test of setPropertyNameMappingElement method. IllegalArgumentException expected when the value is null.
     */
    public void testSetPropertyNameMappingElement_valueNull() {
        try {
            lifeline.setPropertyNameMappingElement(LifelinePropertyType.BLANK_LENGTH, null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test of setPropertyNameMappingElement method. IllegalArgumentException expected when the value is empty.
     */
    public void testSetPropertyNameMappingElement_valueEmpty() {
        try {
            lifeline.setPropertyNameMappingElement(LifelinePropertyType.BLANK_LENGTH, " ");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of getPropertyNameMappingElement method. IllegalArgumentException expected when the parameter is
     * null.
     */
    public void testGetPropertyNameMappingElement_Failure() {
        try {
            lifeline.getPropertyNameMappingElement(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setShadowColor method.IllegalArgumentException expected when the parameter is null.
     */
    public void testSetShadowColorFailure() {
        try {
            lifeline.setShadowColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}