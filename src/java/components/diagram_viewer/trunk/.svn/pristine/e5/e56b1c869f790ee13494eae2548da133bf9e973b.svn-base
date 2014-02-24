/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.accuracytests;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for DiagramView.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class DiagramViewAccuracyTests extends TestCase {

    /**
     * DiagramViewer instance for testing.
     */
    private DiagramViewer viewer;

    /**
     * DiagramView instance for testing.
     */
    private DiagramView view;

    /**
     * Diagram instance for testing.
     */
    private Diagram diagram;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the configuration
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);
        viewer = new DiagramViewer();
        diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        Diagram diagram2 = new Diagram();
        diagram2.setSize(dimension);
        diagram2.setPosition(point);
        diagram.setContainer(diagram2);
        viewer.setBackgroundGridVisible(true);
        view = viewer.createDiagramView(diagram);
        view.setDraggingRectangleVisible(true);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
    	AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: DiagramView(Diagram diagram,
     * DiagramViewer viewer). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        view = (DiagramView) AccuracyTestsHelper.createInstance(DiagramView.class,
                new Class[] {Diagram.class, DiagramViewer.class},
                new Object[] {diagram, viewer}
        );
        assertNotNull("Failed to create DiagramView instance.", view);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: paintComponent(Graphics graphics).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testPaintComponentAccuracy() throws Exception {
        Graphics graphics = new MyGraphics();
        graphics.create(0, 0, 10, 10);
        AccuracyTestsHelper.invokeMethod(view,
                DiagramView.class, "paintComponent",
                new Class[] {Graphics.class}, new Object[] {graphics});
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagram().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramAccuracy() throws Exception {
        assertEquals("Fail to get Diagram", diagram, view.getDiagram());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getViewer().
     * </p>
     */
    public void testGetViewerAccuracy() {
        assertEquals("Fail to get DiagramViewer", viewer, view.getViewer());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTransferHandler(TransferHandler
     * newTransferHandler) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTransferHandlerAccuracy() throws Exception {
        view.setTransferHandler(new TransferHandler("Test"));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTransferHandler(TransferHandler
     * newTransferHandler) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testNotifyDiagramChangedAccuracy() throws Exception {
        view.notifyDiagramChanged();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getPreferredDiagramSize() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetPreferredDiagramSizeAccuracy() throws Exception {
        assertNotNull("Failed to getPreferredDiagramSize.", view.getPreferredDiagramSize());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: updateDraggingRectangle(Rectangle
     * rectangle) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testUpdateDraggingRectangleAccuracy() throws Exception {
        view.updateDraggingRectangle(new Rectangle());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setDraggingRectangleVisible(boolean
     * draggingRectangleVisible) .
     * </p>
     */
    public void testSetDraggingRectangleVisibleAccuracy() {
        view.setDraggingRectangleVisible(false);
        assertFalse("Failed to setDraggingRectangleVisible.", view.isDraggingRectangleVisible());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isDraggingRectangleVisible() .
     * </p>
     */
    public void testIsDraggingRectangleVisibleAccuracy() {
        view.setDraggingRectangleVisible(true);
        assertTrue("Failed to setDraggingRectangleVisible.", view.isDraggingRectangleVisible());
        view.setDraggingRectangleVisible(false);
        assertFalse("Failed to setDraggingRectangleVisible.", view.isDraggingRectangleVisible());
    }

    /**
     * <p>
     * An implementation of the abstract class <c>Graphics</c>.
     * </p>
     *
     * @author tianniu.
     */
    final public class MyGraphics extends Graphics {

        @Override
        public void clearRect(int x, int y, int width, int height) {
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {
        }

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        }

        @Override
        public Graphics create() {
            return null;
        }

        @Override
        public void dispose() {
        }

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle,
                int arcAngle) {
        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor,
                ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height,
                ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height,
                Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
                int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
                int sx1, int sy1, int sx2, int sy2, Color bgcolor,
                ImageObserver observer) {
            return false;
        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {
        }

        @Override
        public void drawOval(int x, int y, int width, int height) {
        }

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        }

        @Override
        public void drawRoundRect(int x, int y, int width, int height,
                int arcWidth, int arcHeight) {
        }

        @Override
        public void drawString(String str, int x, int y) {
        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        }

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle,
                int arcAngle) {
        }

        @Override
        public void fillOval(int x, int y, int width, int height) {
        }

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        }

        @Override
        public void fillRect(int x, int y, int width, int height) {
        }

        @Override
        public void fillRoundRect(int x, int y, int width, int height,
                int arcWidth, int arcHeight) {
        }

        @Override
        public Shape getClip() {
            return null;
        }

        @Override
        public Rectangle getClipBounds() {
            return null;
        }

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public Font getFont() {
            return null;
        }

        @Override
        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        @Override
        public void setClip(Shape clip) {
        }

        @Override
        public void setClip(int x, int y, int width, int height) {
        }

        @Override
        public void setColor(Color c) {
        }

        @Override
        public void setFont(Font font) {
        }

        @Override
        public void setPaintMode() {
        }

        @Override
        public void setXORMode(Color c1) {
        }

        @Override
        public void translate(int x, int y) {
        }
    }
}
