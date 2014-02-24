package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;

/**
 * <p>
 * Failure test for the <code>LifelineSegment</code> class.
 * </p>
 *
 * @author kaqi072821
 * @version 1.1
 * @since 1.1
 */
public class LifelineSegmentFailureTest extends TestCase {
    /**
     * <p>
     * The LifelineSegment instance under test.
     * </p>
     */
    private LifelineSegment instance;

    /**
     * The property name map used in the test.
     */
    private EnumMap<LifelineSegmentPropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     */
    protected void setUp() {
        propertyNameMapping = new EnumMap<LifelineSegmentPropertyType, String>(LifelineSegmentPropertyType.class);
        propertyNameMapping.put(LifelineSegmentPropertyType.FILL_COLOR, "#FFFFFF");
        propertyNameMapping.put(LifelineSegmentPropertyType.HEIGHT, "15");
        propertyNameMapping.put(LifelineSegmentPropertyType.MINIMUM_HEIGHT, "5");
        propertyNameMapping.put(LifelineSegmentPropertyType.RENDER_SCHEME, "1");
        propertyNameMapping.put(LifelineSegmentPropertyType.SHADOW_COLOR, "#000000");
        propertyNameMapping.put(LifelineSegmentPropertyType.STROKE_COLOR, "#000000");
        propertyNameMapping.put(LifelineSegmentPropertyType.MINIMUM_WIDTH, "5");
        propertyNameMapping.put(LifelineSegmentPropertyType.SHADOW_LENGTH, "5");
        propertyNameMapping.put(LifelineSegmentPropertyType.WIDTH, "5");
        instance = new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(new Point(0, 0), new Dimension(
            100, 100)), propertyNameMapping);
    }

    /**
     * <p>
     * Finalizes the test environment.
     * </p>
     */
    protected void tearDown() {
        instance = null;
        propertyNameMapping = null;
    }

    /**
     * Failure test for the constructor when the graphNode parameter is null.
     *
     */
    public void testCtor_graphNodeNull() {
        try {
            new LifelineSegment(null, new Point(0, 0), new Rectangle(new Point(0, 0), new Dimension(100, 100)),
                propertyNameMapping);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the position parameter is null.
     *
     */
    public void testCtor_positionNull() {
        try {
            new LifelineSegment(new GraphNode(), null, new Rectangle(new Point(0, 0), new Dimension(100, 100)),
                propertyNameMapping);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the bound parameter is null.
     *
     */
    public void testCtor_boundNull() {
        try {
            new LifelineSegment(new GraphNode(), new Point(0, 0), null, propertyNameMapping);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the graphNode parameter is null.
     *
     */
    public void testCtor_propertyNameMappingNull() {
        try {
            new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(new Point(0, 0),
                new Dimension(100, 100)), null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the propertyNameMapping parameter contains null value.
     *
     */
    public void testCtor_propertyNameMappingContainNullValue() {
        propertyNameMapping.remove(LifelineSegmentPropertyType.FILL_COLOR);
        propertyNameMapping.put(LifelineSegmentPropertyType.FILL_COLOR, null);
        try {
            new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(new Point(0, 0),
                new Dimension(100, 100)), propertyNameMapping);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the propertyNameMapping parameter contains empty value.
     *
     */
    public void testCtor_propertyNameMappingContainEmptyValue() {
        propertyNameMapping.remove(LifelineSegmentPropertyType.FILL_COLOR);
        propertyNameMapping.put(LifelineSegmentPropertyType.FILL_COLOR, "");
        try {
            new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(new Point(0, 0),
                new Dimension(100, 100)), propertyNameMapping);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test for the constructor when the propertyNameMapping parameter is empty.
     *
     */
    public void testCtor_propertyNameMappingempty() {
        try {
            new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(new Point(0, 0),
                new Dimension(100, 100)), new EnumMap<LifelineSegmentPropertyType, String>(
                LifelineSegmentPropertyType.class));
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setFillColor method when the parameter is null.
     */
    public void testSetFillColorFailure() {
        try {
            instance.setFillColor(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test of setShadowLength method.
     */
    public void testSetShadowLength() {
        System.out.println("setShadowLength");

        int shadowLength = 10;

        instance.setShadowLength(shadowLength);

        int result = instance.getShadowLength();

        assertEquals(shadowLength, result);
    }

    /**
     * Failure Test of setShadowLength method then the parameter is less than 0.
     */
    public void testSetShadowLengthFailure() {

        try {
            instance.setShadowLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Failure test of setStrokeColor method when the parameter is null.
     */
    public void testSetStrokeColor() {
        try {
            instance.setStrokeColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Failure test of setShadowColor method when the parameter is null.
     */
    public void testSetShadowColor() {
        try {
            instance.setShadowColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Failure test of setRenderScheme method when the parameter is null.
     */
    public void testSetRenderScheme() {
        try {
            instance.setRenderScheme(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Failure test of setPopup method when the parameter is null.
     */
    public void testSetPopup() {
        try {
            instance.setPopup(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Failure test of getPropertyNameMappingElement method when the parameter is null.
     */
    public void testGetPropertyNameMappingElement() {
        try {
            instance.getPropertyNameMappingElement(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setPropertyNameMappingElement method when the key is null.
     */
    public void testSetPropertyNameMappingElement1() {
        try {
            instance.setPropertyNameMappingElement(null, "1");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setPropertyNameMappingElement method when the value is null.
     */
    public void testSetPropertyNameMappingElement2() {
        try {
            instance.setPropertyNameMappingElement(LifelineSegmentPropertyType.FILL_COLOR, null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Failure test of setPropertyNameMappingElement method when the value is empty.
     */
    public void testSetPropertyNameMappingElement3() {
        try {
            instance.setPropertyNameMappingElement(LifelineSegmentPropertyType.FILL_COLOR, "");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}