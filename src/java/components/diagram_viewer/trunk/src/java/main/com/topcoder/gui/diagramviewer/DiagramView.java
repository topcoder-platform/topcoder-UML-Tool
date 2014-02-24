/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.UIManager;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.event.AddNewElementHandler;
import com.topcoder.gui.diagramviewer.event.MouseDragHandler;
import com.topcoder.gui.diagramviewer.event.PopupMenuTrigger;
import com.topcoder.gui.diagramviewer.event.SelectElementsHandler;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;

/**
 * <p>
 * This is a concrete JComponent that will correspond to Diagram from Diagram Interchange component. The instance
 * of this class can be added to the DiagramViewer as a tab. It has a null layout manager, so the elements can be
 * added according to the (x,y) coordinates.
 * </p>
 * <p>
 * It automatically register AddNewElementHandler, SelectElementsHandler, PopupMenuTrigger in ctor to provide
 * functionalities such as adding new element by mouse click/drag, showing Popupmenu when mouse is right clicked.
 * </p>
 * <p>
 * It can not be constructed directly using new statement outside this package, to create a new instance using
 * method DiagramViewer#createDiagramView.
 * </p>
 * <p>
 * Thread safety: this class is mutable so not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramView extends JComponent {

    /*
     * BugFix: BUGID UML-7695
     */
    /**
     * <p>
     * Represent the default dash length.
     * </p>
     */
    private static final int DEFAULT_DASH_LENGTH = 6;

    /*
     * BugFix: BUGID UML-7695
     */
    /**
     * <p>
     * Represent the default blank length.
     * </p>
     */
    private static final int DEFAULT_BLANK_LENGTH = 6;

    /**
     * <p>
     * Represents Diagram object from the Diagram Interchange Component that corresponds to this view.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null. Can be accessed by getter.
     * </p>
     */
    private final Diagram diagram;

    /**
     * <p>
     * Represents the DiagramViewer object that hold this view.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null.
     * </p>
     */
    private final DiagramViewer viewer;

    /**
     * <p>
     * Represents the rectangle dragged by user.
     * </p>
     * <p>
     * Initialized in ctor and never changed later (its content will be changed). Can not be null. Can be updated
     * by method updateDraggingRectangle.
     * </p>
     */
    private final Rectangle draggingRectangle;

    /**
     * <p>
     * Represents whether the dragging rectangle is displayed.
     * </p>
     * <p>
     * Initialized to false. Can be accessed by getter and setter.
     * </p>
     */
    private boolean draggingRectangleVisible = false;

    /*
     * BugFix: BUGID UML-8288 Description: Diagram viewer should support drawing a shape on a diagram. The intended
     * usage is in the SDs, when an edge is dragged up and down. This component will be told to draw a line on the
     * diagram in different positions according to the dragging events, and, eventually, it will be told not to
     * draw the line anymore (when the mouse button is released). The shape will be provided by the application.
     * From that moment on, the shape will be drawn when painting occurs, on top of all diagram's children. The
     * shape will be drawn on the diagram, according to the diagram's coordinates, not to the zoom panel. There
     * should be a method to update the shape to be drawn and a method to end drawing the shape. The color of the
     * shape should be configured in the first method. The shape should only be drawn, not filled. The Stroke
     * should also be configurable, in case dashed lines are desired.
     */
    /**
     * <p>
     * Represents the shape to be drawn on top of all diagram elements. Can be accessed by setter.
     * </p>
     */
    private Shape shape;

    /**
     * <p>
     * Represents the color to draw the shape. Default to black. Can be accessed by setter.
     * </p>
     */
    private Color shapeColor = Color.BLACK;

    /**
     * <p>
     * Represents the stroke to draw the shape. Default to BasicStroke. Can be accessed by setter.
     * </p>
     */
    private Stroke shapeStroke = new BasicStroke();

    /**
     * <p>
     * Represents whether the shape will be drawn. Default to false. Can be accessed by getter and setter.
     * </p>
     */
    private boolean shapeVisible = false;

    private Dimension diagramNameDimension;

    /**
     * <p>
     * Make it package to prevent instantiating outside this component.
     * </p>
     * <p>
     * Create a new DiagramView. Assigns the arguments to fields. Register AddNewElementHandler,
     * SelectElementsHandler, PopupMenuTrigger to this instance.
     * </p>
     *
     * @param diagram
     *            the Diagram object from the Diagram Interchange component corresponds to this view
     * @param viewer
     *            the diagram viewer to which this view belong
     * @throws IllegalArgumentException
     *             if any arg is null
     */
    DiagramView(Diagram diagram, DiagramViewer viewer) {
        DVHelper.validateNotNull(diagram, "diagram");
        DVHelper.validateNotNull(viewer, "viewer");
        // Assign the arguments to fields:
        this.diagram = diagram;
        this.viewer = viewer;
        this.draggingRectangle = new Rectangle();
        // BugFix: UML-9434
        // Set location and size
        setLocation((int) diagram.getPosition().getX(), (int) diagram.getPosition().getY());
        setSize((int) diagram.getSize().getWidth(), (int) diagram.getSize().getHeight());
        // Register listeners:
        MouseDragHandler addNewElementHandler = new AddNewElementHandler();
        MouseDragHandler selectElementsHandler = new SelectElementsHandler();
        // addNewElementHandler must be added after selectElementsHandler to make sure users
        // won't select any other elements when they are adding an element.
        addMouseListener(selectElementsHandler);
        addMouseListener(addNewElementHandler);
        addMouseListener(new PopupMenuTrigger());
        addMouseMotionListener(selectElementsHandler);
        addMouseMotionListener(addNewElementHandler);
    }

    /**
     * <p>
     * Overrides this method to provide custom UI rendering.
     * </p>
     *
     * @param graphics
     *            the Graphics context in which to paint (ignore null)
     */
    protected void paintComponent(Graphics graphics) {
        // BugFix: UML-9435
        // Paint the background if opaque
        if (isOpaque()) {
            graphics.setColor(this.getBackground());
            graphics.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        }

        // Draw a rectangle for the diagram (the information needed can be
        // retrieve from diagram):
        graphics.setColor(viewer.getDiagramBackgroundColor());
        /*
         * BugFix: BUGID UML-8975 Description: DiagramView is added as a child component, so it should paint its
         * bounding recangle in its own coordinate system (the rectangle should be located at 0,0)), and it should
         * be painted after the background grid is rendered.
         */
        // old code
        // Point point = diagram.getPosition();
        // com.topcoder.diagraminterchange.Dimension size = this.diagram.getSize();
        // graphics.drawRect((int) point.getX(), (int) point.getY(), (int) size.getWidth(), (int)
        // size.getHeight());
        // If the background grid is visible, render the
        // background grid:
        if (viewer.isBackgroundGridVisible()) {
            viewer.getGridRenderer().renderGrid(graphics, this);
        }

        String diagramName = diagram.getName();

        graphics.setFont(UIManager.getFont("DiagramView.diagramNameFont"));
        FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
        Dimension dim =
            new Dimension(SwingUtilities.computeStringWidth(fontMetrics, diagramName), fontMetrics.getHeight());

        diagramNameDimension = new Dimension(dim.width + 40, dim.height + 20);
        graphics.setColor(UIManager.getColor("DiagramView.diagramNameBackgroundColor"));
        graphics.fillRect(10, 10, diagramNameDimension.width, diagramNameDimension.height);
        graphics.setColor(UIManager.getColor("DiagramView.diagramNameForegroundColor"));
        graphics.drawRect(10, 10, diagramNameDimension.width, diagramNameDimension.height);
        graphics.drawString(diagramName, 30, 15 + dim.height);

        // new code to draw bound
        graphics.setColor(UIManager.getColor("DiagramView.borderColor"));
        graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        super.paintComponent(graphics);
        /*
         * BugFix: BUGID UML-7692 Description: When adding an element or line, Diagram Viewer draws the rectangle
         * (which will be a line when it gets fixed) on the background. So, if there is an element in from of the
         * line that is added, the rectangle cannot be viewed. This should be fixed to show it in front of any
         * elements present in the diagram. Solution: Paint the dragging rectangle at last in paint method.
         */
        // old code
        // // Draw the drag rectangle if needed:
        // if (draggingRectangleVisible) {
        // graphics.drawRect(draggingRectangle.x, draggingRectangle.y, draggingRectangle.width,
        // draggingRectangle.height);
        // }
    }

    /**
     * <p>
     * BugFix: BUGID UML-7692 Description: When adding an element or line, Diagram Viewer draws the rectangle
     * (which will be a line when it gets fixed) on the background. So, if there is an element in from of the line
     * that is added, the rectangle cannot be viewed. This should be fixed to show it in front of any elements
     * present in the diagram. Solution: Paint the dragging rectangle at last in paint method.
     * </p>
     */
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw the drag rectangle if needed:
        g2d.setColor(viewer.getDiagramBackgroundColor());
        if (draggingRectangleVisible) {
            /*
             * BugFix: BUGID UML-7695
             */
            // old code
            // graphics.drawRect(draggingRectangle.x, draggingRectangle.y, draggingRectangle.width,
            // draggingRectangle.height);
            DiagramState state = viewer.getState();

            if (state == DiagramState.ADD_SOLID_EDGE) {

                g2d.setColor(new Color(30, 30, 30, 150));
                g2d.drawLine(draggingRectangle.x, draggingRectangle.y, draggingRectangle.x
                    + draggingRectangle.width, draggingRectangle.y + draggingRectangle.height);
            } else if (state == DiagramState.ADD_DASHED_EDGE) {

                g2d.setColor(new Color(30, 30, 30, 150));
                float[] dashPattern = {DEFAULT_DASH_LENGTH, DEFAULT_BLANK_LENGTH};
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0));
                g2d.drawLine(draggingRectangle.x, draggingRectangle.y, draggingRectangle.x
                    + draggingRectangle.width, draggingRectangle.y + draggingRectangle.height);
            } else {
                g2d.setColor(new Color(50, 50, 50));
                g2d.drawRect(draggingRectangle.x, draggingRectangle.y, draggingRectangle.width,
                    draggingRectangle.height);
                g2d.setColor(new Color(150, 150, 150, 75));
                g2d.fillRect(draggingRectangle.x + 1, draggingRectangle.y + 1, draggingRectangle.width - 2,
                    draggingRectangle.height - 2);

            }
        }
        /*
         * BugFix: BUGID UML-8288 Description: Diagram viewer should support drawing a shape on a diagram. The
         * intended usage is in the SDs, when an edge is dragged up and down. This component will be told to draw a
         * line on the diagram in different positions according to the dragging events, and, eventually, it will be
         * told not to draw the line anymore (when the mouse button is released). The shape will be provided by the
         * application. From that moment on, the shape will be drawn when painting occurs, on top of all diagram's
         * children. The shape will be drawn on the diagram, according to the diagram's coordinates, not to the
         * zoom panel. There should be a method to update the shape to be drawn and a method to end drawing the
         * shape. The color of the shape should be configured in the first method. The shape should only be drawn,
         * not filled. The Stroke should also be configurable, in case dashed lines are desired.
         */
        if (shapeVisible && shape != null) {
            g2d.setColor(shapeColor);
            g2d.setStroke(shapeStroke);
            g2d.draw(shape);
        }
    }

    /**
     * <p>
     * Getter of the diagram, see field doc for explanation.
     * </p>
     *
     * @return the Diagram object corresponds to this view
     */
    public Diagram getDiagram() {
        return diagram;
    }

    /**
     * <p>
     * Getter of the viewer, see field doc for explanation.
     * </p>
     *
     * @return the Diagram object corresponds to this view
     */
    public DiagramViewer getViewer() {
        return viewer;
    }

    /**
     * <p>
     * Override of JComponent#setTransferHandler. It is overrode to prohibit null value, because this component is
     * a drag-drop-target.
     * </p>
     *
     * @param newTransferHandler
     *            the new transfer handler.
     * @throws IllegalArgumentException
     *             if newTransferHandler is null
     */
    public void setTransferHandler(TransferHandler newTransferHandler) {
        DVHelper.validateNotNull(newTransferHandler, "newTransferHandler");
        super.setTransferHandler(newTransferHandler);
    }

    /**
     * <p>
     * Reload diagram interchange information from contained diagram.
     * </p>
     */
    public void notifyDiagramChanged() {
        int diagramViewGap = viewer.getDiagramViewGap();
        setSize((int) (diagram.getSize().getWidth() + 2 * diagramViewGap),
            (int) (diagram.getSize().getHeight() + 2 * diagramViewGap));
        double x = 0;
        double y = 0;

        GraphElement node = this.diagram;
        while (node.getContainer() != null) {
            x += node.getPosition().getX();
            y += node.getPosition().getY();
            node = node.getContainer();

        }

        setLocation((int) Math.round(x) - SelectionCorner.DEFAULT_RADIUS, (int) Math.round(y)
            - SelectionCorner.DEFAULT_RADIUS);

    }

    /**
     * <p>
     * Get the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of the diagram.
     * </p>
     *
     * @return the preferred size of the diagram
     */
    public Dimension getPreferredDiagramSize() {
        return new Dimension((int) Math.ceil(diagram.getSize().getWidth()), (int) Math.ceil(diagram.getSize()
            .getHeight()));
    }

    /**
     * <p>
     * Update the dragging rectangle and repaint it.
     * </p>
     *
     * @param rectangle
     *            the new dragging rectangle
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void updateDraggingRectangle(Rectangle rectangle) {
        DVHelper.validateNotNull(rectangle, "rectangle");
        draggingRectangle.setBounds(rectangle);
        repaint();
    }

    /**
     * <p>
     * Setter of draggingRectangleVisible, see field doc for explanation.
     * </p>
     *
     * @param draggingRectangleVisible
     *            whether the dragging rectangle is visible
     */
    public void setDraggingRectangleVisible(boolean draggingRectangleVisible) {
        this.draggingRectangleVisible = draggingRectangleVisible;
    }

    /**
     * <p>
     * Getter of draggingRectangleVisible, see field doc for explanation.
     * </p>
     *
     * @return true if the dragging rectangle is visible, otherwise false
     */
    public boolean isDraggingRectangleVisible() {
        return draggingRectangleVisible;
    }

    /*
     * BugFix: BUGID UML-8288 Description: Diagram viewer should support drawing a shape on a diagram. The intended
     * usage is in the SDs, when an edge is dragged up and down. This component will be told to draw a line on the
     * diagram in different positions according to the dragging events, and, eventually, it will be told not to
     * draw the line anymore (when the mouse button is released). The shape will be provided by the application.
     * From that moment on, the shape will be drawn when painting occurs, on top of all diagram's children. The
     * shape will be drawn on the diagram, according to the diagram's coordinates, not to the zoom panel. There
     * should be a method to update the shape to be drawn and a method to end drawing the shape. The color of the
     * shape should be configured in the first method. The shape should only be drawn, not filled. The Stroke
     * should also be configurable, in case dashed lines are desired.
     */
    /**
     * <p>
     * Setter of shape, see field doc for explanation.
     * </p>
     *
     * @param shape
     *            the shape to be drawn
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void setShape(Shape shape) {
        DVHelper.validateNotNull(shape, "shape");
        this.shape = shape;
    }

    /**
     * <p>
     * Setter of shapeColor, see field doc for explanation.
     * </p>
     *
     * @param shape
     *            the color to draw shape
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void setShapeColor(Color shapeColor) {
        DVHelper.validateNotNull(shape, "shape");
        this.shapeColor = shapeColor;
    }

    /**
     * <p>
     * Setter of shapeStroke, see field doc for explanation.
     * </p>
     *
     * @param shape
     *            the stroke to draw shape
     * @throws IllegalArgumentException
     *             if the arg is null
     */
    public void setShapeStroke(Stroke shapeStroke) {
        DVHelper.validateNotNull(shape, "shape");
        this.shapeStroke = shapeStroke;
    }

    /**
     * <p>
     * Getter of shapeVisible, see field doc for explanation.
     * </p>
     *
     * @return true if the shape is visible, otherwise false
     */
    public boolean isShapeVisible() {
        return shapeVisible;
    }

    /**
     * <p>
     * Setter of shapeVisible, see field doc for explanation.
     * </p>
     *
     * @param shapeVisible
     *            whether the shape is visible
     */
    public void setShapeVisible(boolean shapeVisible) {
        this.shapeVisible = shapeVisible;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getPoint().x > 10 && e.getPoint().x < diagramNameDimension.width + 10 && e.getPoint().y > 10
            && e.getPoint().y < diagramNameDimension.height + 10 && e.getButton() == MouseEvent.BUTTON1
            && e.getClickCount() == 2) {

            final TextInputBox textInputBox = viewer.getTextInputBox();

            if (textInputBox.isShowing()) {
                textInputBox.fireTextEntered();
            }

            textInputBox.setText(diagram.getName());
            textInputBox.addTextInputListener(new TextInputListener() {

                public void textCancelled(TextInputEvent event) {

                }

                public void textEntered(TextInputEvent event) {
                    viewer.fireDiagramNameChanged(diagram, event.getText());
                    viewer.openDiagramView(diagram);
                    textInputBox.removeTextInputListener(this);
                }
            });
            textInputBox.show(this, 12, 12);

            JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
            textArea.requestFocus();
            textArea.selectAll();
        }
        super.processMouseEvent(e);
    }
}
