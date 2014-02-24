/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.accuracytests;

import com.topcoder.gui.panels.zoom.transform.NatureZoomTransform;

import junit.framework.TestCase;

import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 * Accuracy test for <code>NatureZoomTransform</code>.
 *
 * @author kzhu
 * @version 1.0
 */
public class NatureZoomTransformAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents double epsilon for float number manipulation.
     * </p>
     */
    private final double EPSILON = 1e-6;

    /**
     * <p>
     * NatureZoomTransform instance. Used for testing.
     * </p>
     */
    private NatureZoomTransform transform;

    /**
     * <p>
     * Creates required instances.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        transform = new NatureZoomTransform(2);
    }

    /**
     * <p>
     * Tests that NatureZoomTransform() instance is created and arguments are correctly propagated.
     * </p>
     */
    public void testConstructor1Accuracy() {
        NatureZoomTransform t = new NatureZoomTransform();
        assertNotNull("Unable to instantiate NatureZoomTransform", t);
        assertEquals("The default zoom factor must be 1", 1.0, t.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Tests that NatureZoomTransform(double) instance is created and arguments are correctly propagated.
     * </p>
     */
    public void testConstructor2Accuracy() {
        NatureZoomTransform t = new NatureZoomTransform(2.5);
        assertNotNull("Unable to instantiate NatureZoomTransform", t);
        assertEquals("The zoom factor was propagated incorrectly", 2.5, t.getZoomFactor(), EPSILON);
    }

    /**
     * <p>
     * Tests that setZoomFactor(double) correctly propagates argument.
     * </p>
     */
    public void testSetZoomFactorAccuracy() {
        transform.setZoomFactor(3.5);
        assertEquals("The zoom factor was propagated incorrectly", 3.5, transform.getZoomFactor(), EPSILON);
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
     * Tests that applyTransform(Graphics2D) correctly transforms graphics.
     * </p>
     */
    public void testApplyTransform() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = image.createGraphics();
        transform.applyTransform(graphics2D);
        assertEquals("The current transformation is incorrect", AffineTransform.getScaleInstance(2, 2),
            graphics2D.getTransform());
    }

    /**
     * <p>
     * Tests that applyInverseTransform(MouseEvent) correctly transforms mouse event.
     * </p>
     */
    public void testApplyInverseTransform() {
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
     * Tests that isNoZoom() returns correct value. Uses 1 as zoom factor, true is expected
     * </p>
     */
    public void testIsNoZoomAccuracy1() {
        transform.setZoomFactor(1);
        assertTrue("The returned value is incorrect", transform.isNoZoom());
    }

    /**
     * <p>
     * Tests that isNoZoom() returns correct value. Uses 2 as zoom factor, false is expected
     * </p>
     */
    public void testIsNoZoomAccuracy2() {
        assertFalse("The returned value is incorrect", transform.isNoZoom());
    }
}
