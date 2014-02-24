/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.accuracytests;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import junit.framework.TestCase;

import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 * Accuracy test for <code>AffineZoomTransform</code>.
 *
 * @author kzhu
 * @version 1.0
 */
public class AffineZoomTransformAccuracyTests extends TestCase {
    /**
     * <p>
     * AffineZoomTransform instance. Used for testing.
     * </p>
     */
    private AffineZoomTransform transform;

    /**
     * <p>
     * Represents double epsilon for float number manipulation.
     * </p>
     */
    private final double EPSILON = 1e-6;

    /**
     * <p>
     * Creates required instances.
     * </p>
     *
     * @throws Exception any exception to JUnit.
     */
    protected void setUp() throws Exception {
        transform = new AffineZoomTransform(2);
    }

    /**
     * <p>
     * Tests that AffineZoomTransform() instance is created and arguments are correctly propagated.
     * </p>
     */
    public void testConstructor1Accuracy() {
        AffineZoomTransform t = new AffineZoomTransform();
        assertNotNull("Unable to instantiate AffineZoomTransform", t);
        assertEquals("The default zoom factor must be 1", 1.0, t.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Tests that AffineZoomTransform(double) instance is created and arguments are correctly propagated.
     * </p>
     */
    public void testConstructor2Accuracy() {
        AffineZoomTransform t = new AffineZoomTransform(2.5);
        assertNotNull("Unable to instantiate AffineZoomTransform", t);
        assertEquals("The zoom factor was propagated incorrectly", 2.5, t.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Tests that AffineZoomTransform(AffineTransform) instance is created and arguments are correctly propagated.
     * </p>
     */
    public void testConstructor3Accuracy() {
        AffineTransform transformation = AffineTransform.getScaleInstance(1, 2);
        transformation.concatenate(AffineTransform.getTranslateInstance(3, 4));

        AffineZoomTransform t = new AffineZoomTransform(transformation);
        assertNotNull("Unable to instantiate AffineZoomTransform", t);
        assertEquals("The transformation was propagated incorrectly", transformation, t.getTransform());

        transformation.setToIdentity();
        assertFalse("Transformation must be cloned in constructor", transformation.equals(t.getTransform()));
    }

    /**
     * <p>
     * Tests that setZoomFactor(double) correctly propagates argument.
     * </p>
     */
    public void testSetZoomFactorAccuracy() {
        transform.setZoomFactor(3.5);
        assertEquals("The zoom factor was propagated incorrectly", 3.5, transform.getZoomFactor(), 1e-6);
    }

    /**
     * <p>
     * Tests that getZoomFactor() returns correct value.
     * </p>
     */
    public void testGetZoomFactorAccuracy() {
        assertEquals("The returned value is incorrect", 2.0, transform.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Tests that applyTransform(Graphics2D) correctly transforms graphics when transformation is scaling.
     * </p>
     */
    public void testApplyTransformAccuracy1() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = image.createGraphics();
        transform.applyTransform(graphics2D);
        assertEquals("The current transformation is incorrect", AffineTransform.getScaleInstance(2, 2),
            graphics2D.getTransform());
    }

    /**
     * <p>
     * Tests that applyTransform(Graphics2D) correctly transforms graphics when transformation is arbitrary.
     * </p>
     */
    public void testApplyTransformAccuracy2() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = image.createGraphics();

        AffineTransform transformation = AffineTransform.getTranslateInstance(10, 5);
        transformation.concatenate(AffineTransform.getRotateInstance(Math.PI / 2));
        transform.setTransform(transformation);

        transform.applyTransform(graphics2D);
        assertEquals("The current transformation is incorrect", transformation, graphics2D.getTransform());
    }

    /**
     * <p>
     * Tests that applyInverseTransform(MouseEvent) correctly transforms mouse event when transformation is scaling.
     * </p>
     */
    public void testApplyInverseTransformAccuracy1() {
        Label source = new Label();
        MouseEvent event = new MouseEvent(source, 1, 2, 3, 100, 24, 4, true, MouseEvent.BUTTON1);
        MouseEvent transformed = transform.applyInverseTransform(event);
        assertEquals("The event was transformed incorrectly", source, transformed.getSource());
        assertEquals("The event was transformed incorrectly", 1, transformed.getID());
        assertEquals("The event was transformed incorrectly", 2, transformed.getWhen());
        assertEquals("The event was transformed incorrectly", 3, transformed.getModifiers());
        assertEquals("The event was transformed incorrectly", 50, transformed.getX());
        assertEquals("The event was transformed incorrectly", 12, transformed.getY());
        assertEquals("The event was transformed incorrectly", 4, transformed.getClickCount());
        assertEquals("The event was transformed incorrectly", true, transformed.isPopupTrigger());
        assertEquals("The event was transformed incorrectly", MouseEvent.BUTTON1, transformed.getButton());
    }

    /**
     * <p>
     * Tests that applyInverseTransform(MouseEvent) correctly transforms mouse event when transformation is arbitrary.
     * </p>
     */
    public void testApplyInverseTransformAccuracy2() {
        // creates a transformation that moves point (5, 0) to the (10, 10)
        AffineTransform transformation = AffineTransform.getTranslateInstance(10, 5);
        transformation.concatenate(AffineTransform.getRotateInstance(Math.PI / 2));
        transform.setTransform(transformation);

        MouseEvent event = new MouseEvent(new Label(), 1, 2, 3, 10, 10, 4, true, MouseEvent.BUTTON1);
        MouseEvent transformed = transform.applyInverseTransform(event);
        assertEquals("The event was transformed incorrectly", 5, transformed.getX());
        assertEquals("The event was transformed incorrectly", 0, transformed.getY());
    }

    /**
     * <p>
     * Tests that isNoZoom() returns correct value. Sets zoom factor to 1, true is expected.
     * </p>
     */
    public void testIsNoZoomAccuracy1() {
        transform.setZoomFactor(1);
        assertTrue("The returned value is incorrect", transform.isNoZoom());
    }

    /**
     * <p>
     * Tests that isNoZoom() returns correct value. Sets transformation to identity, true is expected.
     * </p>
     */
    public void testIsNoZoomAccuracy2() {
        transform.setTransform(AffineTransform.getTranslateInstance(0, 0));
        assertTrue("The returned value is incorrect", transform.isNoZoom());
    }

    /**
     * <p>
     * Tests that isNoZoom() returns correct value. For default transformation false is expected.
     * </p>
     */
    public void testIsNoZoomAccuracy3() {
        assertFalse("The returned value is incorrect", transform.isNoZoom());
    }

    /**
     * <p>
     * Tests that getTransform() returns correct value.
     * </p>
     */
    public void testGetTransformAccuracy() {
        AffineTransform transformation = transform.getTransform();
        assertEquals("The returned value is incorrect", AffineTransform.getScaleInstance(2, 2), transformation);

        // modify returned value
        transformation.setToIdentity();
        assertFalse("Transformation must be cloned in method",
            AffineTransform.getScaleInstance(2, 2).equals(transformation));
    }

    /**
     * <p>
     * Tests that setTransform(AffineTransform) works correctly. It should clone transformation, set it and create
     * inverse transformation.
     * </p>
     */
    public void testSetTransformAccuracy() {
        AffineTransform transformation = AffineTransform.getRotateInstance(Math.PI / 2);
        transform.setTransform(transformation);

        // check that transformation was propagated
        assertEquals("The transformation was propagated incorrectly", transformation, transform.getTransform());

        // check that transformation was cloned
        transformation.setToIdentity();
        assertFalse("Transformation must be cloned in setter", transformation.equals(transform.getTransform()));

        // check that inverse transformation is correct
        MouseEvent event = new MouseEvent(new Label(), 1, 2, 3, -239, 1, 4, true, MouseEvent.BUTTON1);
        MouseEvent transformed = transform.applyInverseTransform(event);
        assertEquals("The inverse transformation is incorrect", 1, transformed.getX());
        assertEquals("The inverse transformation is incorrect", 239, transformed.getY());
    }
}
