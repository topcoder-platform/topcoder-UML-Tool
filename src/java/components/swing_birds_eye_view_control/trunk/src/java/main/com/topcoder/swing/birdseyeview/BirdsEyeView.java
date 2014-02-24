/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.topcoder.gui.panels.zoom.ZoomPanel;

/**
 * <p>
 * The main class of the component. This is a JComponent child. It will just a
 * container for the ZoomPanel and there is some business logic: the input
 * object (JComponent), view port, dimension and position of the input object
 * view port are stored in this class. They are accessible through
 * setters/getters. This class processes mousePressed event - will center this
 * component view port at the mouse cursor. Please note, the BirdsEyeView will
 * be added as a child JComponent to the inputObject. So, the BirdsEyeView will
 * be automatically updated when the parent InputObject changes. The
 * paintComponent(...) method of this class will be called on any update of the
 * input object. All calculations will be performed in that method. Please note,
 * setting the properties of this class do not perform repainting of the
 * control, because the efficiency is very important and several properties will
 * be usually set (not just once).
 * </p>
 * <p>
 * The following shows the usage of BirdsEyeView.
 * </p>
 *
 * <p>
 * <pre>
 * // Assume we have the big class diagram, let's name it an input object
 * JLabel inputObject = new JLabel(new ImageIcon(&quot;test_files/demo_test.gif&quot;));
 * // The currently shown part of the input object has a size. We should
 * // use that size with our birds eye view control
 * Dimension inputObjectViewDimension = new Dimension(800, 600);
 * // The user can scroll the input object (for example, the big class
 * // diagram). The current location of the left-top origin of the
 * // currently shown part of the input object should be used with our
 * // birds eye view control
 * Point inputObjectViewPosition = new Point(300, 200);
 * // Finally - create the birds eye view control
 * BirdsEyeView control = new BirdsEyeView(inputObject, inputObjectViewDimension,
 *         inputObjectViewPosition);
 * // From now on, the birds view control is created, registered as a child
 * // of the inputObject, registered to mouse events, and displayed. Any
 * // changes in the inputObject (like change the entire size of the
 * // inputObject, change of the graphical data - add/remove new class) -
 * // will be automatically displayed by the current control. The user can
 * // manually change the size of our control and modify any GUI related
 * // properties as for other JComponent controls.
 *
 * // Set the new dimension of the inputObject view port. The birds eye
 * // view control will update its own view port size to have proper value
 * control.setInputObjectViewDimension(new Dimension(640, 480));
 * // Or another way:
 * control.getInputObjectViewDimension().setSize(500, 400);
 * // Set the new position of the inputObejct view port. The birds eye view
 * // control will update its own view port position to have proper value
 * control.setInputObjectViewPosition(new Point(100, 150));
 * // Or another way
 * control.getInputObjectViewPosition().setLocation(90, 80);
 * // If those updates were performed in the paintComponent(...) method of
 * // the input object, then no other actions are needed - our birds eye
 * // view control will be updated automatically.
 * // In other case (if dimension and position were changed outside the
 * // paintComponent(...) method of the parent JComponent), then we should
 * // manually redraw our control like this:
 * control.repaint();
 *
 * // Make an instance of the listener
 * ViewPortListener listener = new ChangeViewPortListener();
 * // Register the listener to the birds eye view control
 * control.getViewPort().addViewPortListener(listener);
 * // De-register the view port listener
 * control.getViewPort().removeViewPortListener(listener);
 * // Or all the ViewPortListener instances can be easily removed
 * control.getViewPort().clearViewPortListeners();
 *
 * // Change to another input object
 * control.setInputObject(inputObject);
 * // The next actions were performed in the previous call: - the birds eye
 * // view was totally de-registered from the previous inputObject. - all
 * // the ViewPortListener instances were de-registered from the birds eye
 * // view control view port. - the zoomPanel was updated with a new
 * // inputObject JComponent instance - the new inputObject was set to the
 * // internals of the bird eye view control - the birds eye view control
 * // was registered as a child to the new inputObject The input object
 * // view port position is most likely should be new, not from the
 * // previous inputObject (for example, the sequence diagram can be
 * // scrolled to the different position than class diagram). Set the new
 * // position of the input object view port
 * control.setInputObjectViewPosition(new Point(20, 40));
 * // The size of the input object view port is most likely should NOT be
 * // new, but the same as from previous input object (for example, the
 * // shown part of the sequence diagram will be the same as of the
 * // previous class diagram. So, no updating of the input object view part
 * // dimension is needed.
 * // But in the general cases, the user can set the new dimensions of the
 * // input object view port like this:
 * control.setInputObjectViewDimension(new Dimension(1024, 768));
 * // Please note, the previous listener was removed, because in general
 * // case the new inputObject will be a totally different and we can not
 * // assume in our component that the user will ALWAYS use just one
 * // listener for all the changed input objects.
 * // So, the user have to manually register a new listener like this:
 * control.getViewPort().addViewPortListener(new ViewPortListener() {
 *     public void viewPortMoved(ViewPortEvent event) {
 *     }
 * });
 *
 * // Set the semi-transparent view port
 * control.getViewPort().setOpacity(0.5);
 * // Set the fully transparent view port
 * control.getViewPort().setOpacity(0.0);
 * // Set the solid (non-transparent) view port
 * control.getViewPort().setOpacity(1.0);
 * </pre>
 * </p>
 *
 * <p>
 * Thread safety: This class is mutable and therefore is not thread-safe. There
 * is no need to make this class thread safe, because it is just a GUI control,
 * which usually are not thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class BirdsEyeView extends JPanel implements MouseListener {

    /**
     * <p>
     * The default value of opacity.
     * </p>
     */
    private static final double DEFAULT_OPACITY = 0.5;
    /**
     * <p>
     * Represents an instance of the input JComponent object, which will be
     * zoomed in the current component. This can be like a large class diagram
     * of the UML Tool, for which we should provide the birds eye view. It can
     * not be null. It is initialized in the constructor.
     * </p>
     *
     * <p>
     * Use related getter/setter methods to retrieve this field value or to
     * mutate its data.
     * </p>
     */
    private JComponent inputObject;
    /**
     * <p>
     * Represents the instance of the ViewPort - the JComponent to be used for
     * showing current view port rectangle on the zoomed input object. It can
     * not be null.
     * </p>
     *
     * <p>
     * It is initialized in the constructor and is never changed later. Use
     * related getter method to retrieve this field value.
     * </p>
     */
    private final ViewPort viewPort;
    /**
     * <p>
     * Represents an instance of the ZoomPanel - a special control, which will
     * show the input object in the zoomed way. Please note, the zoomPanel
     * contains the input object, so, when the input object of this class is
     * changed, then the zoomPanel field should be re-created.
     * </p>
     *
     * <p>
     * It can not be null. It is initialized in the constructor. Use related
     * getter/setter methods to retrieve this field value or to mutate its data.
     * </p>
     */
    private ZoomPanel zoomPanel;
    /**
     * <p>
     * Represents the view port dimension of the input object. This is like a
     * current window of UML tool with the part of class diagram. It is an
     * instance of the Dimension class.
     * </p>
     *
     * <p>
     * It can not be null. If dimension has 0,0 values - it means no view port
     * will be shown. It is initialized in the constructor. Use related
     * getter/setter methods to retrieve this field value or to mutate its data.
     * </p>
     */
    private Dimension inputObjectViewDimension;
    /**
     * <p>
     * Represents the left-top origin of the input object view port. This is an
     * instance of the Point class.
     * </p>
     *
     * <p>
     * It can not be null. It is initialized in the constructor.
     * Use related getter/setter methods to retrieve this field value or to mutate its data.
     * </p>
     */
    private Point inputObjectViewPosition;

    /**
     * <p>
     * A simple initialization constructor.
     * </p>
     *
     * @param inputObjectViewPosition
     *            the new value of the left-top origin of the input object view
     *            port. This is an instance of the Point class. It can not be
     *            null.
     * @param inputObject
     *            the new value of the instance of the input JComponent object,
     *            which will be zoomed in the current component. This can be
     *            like a large class diagram of the UML Tool, for which we
     *            should provide the birds eye view. It can not be null.
     * @param inputObjectViewDimension
     *            the new value of the view port dimension of the input object.
     *            This is like a current window of UML tool with the part of
     *            class diagram. It is an instance of the Dimension class. It
     *            can not be null. If dimension has 0,0 values - it means no
     *            view port will be shown.
     * @throws IllegalArgumentException
     *             if argument is null.
     *
     */
    public BirdsEyeView(JComponent inputObject,
            Dimension inputObjectViewDimension, Point inputObjectViewPosition) {
        super();
        // check the parameters
        Helper.checkNull(inputObject, "inputObject");
        Helper.checkNull(inputObjectViewDimension, "inputObjectViewDimension");
        Helper.checkNull(inputObjectViewPosition, "inputObjectViewPosition");
        // set the internal fields
        this.inputObject = inputObject;
        this.inputObjectViewDimension = inputObjectViewDimension;
        this.inputObjectViewPosition = inputObjectViewPosition;
        this.viewPort = new ViewPort();
        this.zoomPanel = new ZoomPanel(inputObject);

        // retrieve all the configurations
        Color overlayColor = UIManager.getColor("BirdsEyeView.overlayColor");
        Color overlayBorderColor = UIManager
                .getColor("BirdsEyeView.overlayBorderColor");
        String overlayBorderThickness = UIManager
                .getString("BirdsEyeView.overlayBorderThickness");
        String opacity = UIManager.getString("BirdsEyeView.overlayOpacity");

        if (overlayColor == null) {
            overlayColor = Color.GRAY;
        }
        if (overlayBorderColor == null) {
            overlayBorderColor = Color.BLACK;
        }
        Integer overlayBorderThicknessValue = Helper.convertStringToInt(overlayBorderThickness);
        // if the overlayBorderThicknessValue is invalid, use 1 as the default value
        if (overlayBorderThicknessValue == null || overlayBorderThicknessValue < 0) {
            overlayBorderThicknessValue = 1;
        }
        Double opacityValue = Helper.convertStringToDouble(opacity);
        if (opacityValue == null || opacityValue < 0 || opacityValue > 1) {
            opacityValue = DEFAULT_OPACITY;
        }
        // set the configuration values to the viewPort
        this.viewPort.setOpacity(opacityValue);
        this.viewPort.setBackground(overlayColor);
        this.viewPort.setForeground(overlayBorderColor);
        // Set the border
        this.viewPort.setBorder(BorderFactory.createLineBorder(
                overlayBorderColor, overlayBorderThicknessValue));
        // Register the mouse listener for the current class
        this.addMouseListener(this);

        // Set the parent-child hierarchy of the used JComponent instances
        this.add(this.zoomPanel);
        this.zoomPanel.add(this.viewPort, 0);
    }

    /**
     * <p>
     * A simple getter method for the "inputObject" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the instance of the input JComponent
     *         object, which will be zoomed in the current component. This can
     *         be like a large class diagram of the UML Tool, for which we
     *         should provide the birds eye view. It can not be null.
     */
    public JComponent getInputObject() {
        return this.inputObject;
    }

    /**
     * <p>
     * A simple setter method for the "inputObject" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if value to be set is null.
     * @param inputObject
     *            the new value of the instance of the input JComponent object,
     *            which will be zoomed in the current component. This can be
     *            like a large class diagram of the UML Tool, for which we
     *            should provide the birds eye view. It can not be null.
     */
    public void setInputObject(JComponent inputObject) {
        Helper.checkNull(inputObject, "inputObject");

        this.remove(this.zoomPanel);
        this.zoomPanel.remove(this.viewPort);
        // clear view port listeners
        this.getViewPort().clearViewPortListeners();
        // set the new zoom panel
        this.setZoomPanel(new ZoomPanel(inputObject));
        this.inputObject = inputObject;

        this.add(this.zoomPanel);
        this.zoomPanel.add(this.viewPort);
    }

    /**
     * <p>
     * A simple getter method for the "viewPort" internal field. Please refer to
     * the related field for more information.
     * </p>
     *
     * @return the retrieved value of the instance of the ViewPort the
     *         JComponent to be used for showing current view port rectangle on
     *         the zoomed input object. It can not be null
     */
    public ViewPort getViewPort() {
        return this.viewPort;
    }

    /**
     * <p>
     * A simple getter method for the "zoomPanel" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the instance of the ZoomPanel a special
     *         control, which will show the input object in the zoomed way.
     *         Please note, the zoomPanel contains the input object, so, when
     *         the input object of this class is changed, then the zoomPanel
     *         field should be re-created. It can not be null
     */
    public ZoomPanel getZoomPanel() {
        return this.zoomPanel;
    }

    /**
     * <p>
     * A simple setter method for the "zoomPanel" internal field. Please refer
     * to the related field for more information.
     * </p>
     *
     * @param zoomPanel
     *            the new value of the instance of the ZoomPanel a special
     *            control, which will show the input object in the zoomed way.
     *            Please note, the zoomPanel contains the input object, so, when
     *            the input object of this class is changed, then the zoomPanel
     *            field should be re-created. It can not be null.
     * @throws IllegalArgumentException
     *             if value to be set is null.
     */
    protected void setZoomPanel(ZoomPanel zoomPanel) {
        Helper.checkNull(zoomPanel, "zoomPanel");
        this.zoomPanel = zoomPanel;

    }

    /**
     * <p>
     * A simple getter method for the "inputObjectViewDimension" internal field.
     * Please refer to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the view port dimension of the input
     *         object. This is like a current window of UML tool with the part
     *         of class diagram. It is an instance of the Dimension class. It
     *         can not be null. If dimension has 0,0 values, it means no view
     *         port will be shown
     */
    public Dimension getInputObjectViewDimension() {
        return this.inputObjectViewDimension;
    }

    /**
     * <p>
     * A simple setter method for the "inputObjectViewDimension" internal field.
     * Please refer to the related field for more information.
     * </p>
     *
     * @param inputObjectViewDimension
     *            the new value of the view port dimension of the input object.
     *            This is like a current window of UML tool with the part of
     *            class diagram. It is an instance of the Dimension class. It
     *            can not be null. If dimension has 0,0 values, it means no view
     *            port will be shown.
     * @throws IllegalArgumentException
     *             if value to be set is null.
     */
    public void setInputObjectViewDimension(Dimension inputObjectViewDimension) {
        Helper.checkNull(inputObjectViewDimension, "inputObjectViewDimension");
        this.inputObjectViewDimension = inputObjectViewDimension;
    }

    /**
     * <p>
     * A simple getter method for the "inputObjectViewPosition" internal field.
     * Please refer to the related field for more information.
     * </p>
     *
     * @return the retrieved value of the left-top origin of the input object
     *         view port. This is an instance of the Point class. It can not be
     *         null
     */
    public Point getInputObjectViewPosition() {
        return this.inputObjectViewPosition;
    }

    /**
     * <p>
     * A simple setter method for the "inputObjectViewPosition" internal field.
     * Please refer to the related field for more information.
     * </p>
     *
     * @param inputObjectViewPosition
     *            the new value of the left-top origin of the input object view
     *            port. This is an instance of the Point class. It can not be
     *            null
     */
    public void setInputObjectViewPosition(Point inputObjectViewPosition) {
        Helper.checkNull(inputObjectViewPosition, "inputObjectViewPosition");
        this.inputObjectViewPosition = inputObjectViewPosition;
    }

    /**
     * <p>
     * Invoked when a mouse button has been pressed on a component. It will be
     * used for center the view port at the mouse cursor.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mousePressed(MouseEvent event) {
        if (event == null) {
            return;
        }
        // Get the mouse coordinates
        int x = event.getX();
        int y = event.getY();

        // Please note, the zoomPanel will fully cover the BirdsEyeView control,
        // and that zoomPanel has a special pre-processing of all the mouse events,
        // which go through it. That zoomPanel convert their coordinates to the
        // inputObject coordinates, which are not applicable for us. So, the conversion
        // back is needed
        x = (int) (x / this.getZoomPanel().getZoomFactor());
        y = (int) (y / this.getZoomPanel().getZoomFactor());

        // Check if the x and y are inside the "this" control bounds
        if (x < 0 || x > this.getWidth() || y < 0 || y > this.getHeight()) {
            return;
        }
        // Check if the x and y are inside the bounds of zoomPanel
        if (x < zoomPanel.getLocation().getX() || x > zoomPanel.getLocation().getX()
                + zoomPanel.getSize().getWidth()) {
            return;
        }
        if (y < zoomPanel.getLocation().getY() || y > zoomPanel.getLocation().getY()
                + zoomPanel.getSize().getHeight()) {
            return;
        }

        int halfViewPortWidth = this.getViewPort().getWidth() / 2;
        int halfViewPortHeight = this.getViewPort().getHeight() / 2;

        // Check the limits of the view port borders
        if (x - halfViewPortWidth < 0) {
            x = halfViewPortWidth;
        }
        if (x + halfViewPortWidth >= this.getWidth()) {
            x = this.getWidth() - halfViewPortWidth - 1;
        }
        if (y - halfViewPortHeight < 0) {
            y = halfViewPortHeight;
        }
        if (y + halfViewPortHeight >= this.getHeight()) {
            y = this.getHeight() - halfViewPortHeight - 1;
        }
        // Calculate the new location of the view port
        Point newViewPortLocation = new Point(x - halfViewPortWidth, y
                - halfViewPortHeight);
        // Set the new position of the view port
        this.getViewPort().setLocation(newViewPortLocation);
        // Repaint the entire component
        this.repaint();
    }

    /**
     * <p>
     * Invoked when a mouse button has been released on a component. Not used in
     * this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseReleased(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse button has been clicked (pressed and released) on
     * a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseClicked(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse enters a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseEntered(MouseEvent event) {
    }

    /**
     * <p>
     * Invoked when the mouse exits a component. Not used in this component.
     * </p>
     *
     * @param event
     *            an instance of the MouseEvent class with the data about the
     *            current mouse state. It should be not null. If null - simply
     *            ignore it and return.
     */
    public void mouseExited(MouseEvent event) {
    }

    /**
     * <p>
     * Draw the graphics of the component.
     * </p>
     *
     * <p>
     * It will also perform all the needed calculations of the view port and
     * zoom panel.
     * </p>
     *
     * @param g
     *            the Graphics instance to be used for drawing the component. It
     *            should be not null. If null - simply ignore it and return.
     */
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }
        int inputWidth = this.getInputObject().getWidth();
        int inputHeight = this.getInputObject().getHeight();
        // Calculate the zoom factor
        double zoomFactor = 0;
        if (inputWidth != 0 && inputHeight != 0) {
            double scaleWidth = this.getWidth() * 1.0 / inputWidth;
            double scaleHeight = this.getHeight() * 1.0
                    / inputHeight;
            zoomFactor = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
        }

        if (Helper.compareDoubles(zoomFactor, 0)) {
            zoomFactor = 1;
        }
        // Set the zoomFactor to the zoomPanel
        this.getZoomPanel().setZoomFactor(zoomFactor);
        // Calculate the size of the view port
        int zoomViewWidth = (int) (inputObjectViewDimension.getWidth() * zoomFactor);
        int zoomViewHeight = (int) (inputObjectViewDimension.getHeight() * zoomFactor);
        Dimension viewPortSize = new Dimension(zoomViewWidth, zoomViewHeight);

        // Set the view port size
        this.getViewPort().setSize(viewPortSize);
        // Calculate the location of the view port
        int zoomViewX = (int) (this.getInputObjectViewPosition().getX() * zoomFactor);
        int zoomViewY = (int) (this.getInputObjectViewPosition().getY() * zoomFactor);

        // Set the location of the view port
        Point viewPortLocation = new Point(zoomViewX, zoomViewY);
        this.getViewPort().setLocation(viewPortLocation);
        // Set the zoom factor to the viewPort
        this.getViewPort().setZoomFactor(zoomFactor);
    }
}
