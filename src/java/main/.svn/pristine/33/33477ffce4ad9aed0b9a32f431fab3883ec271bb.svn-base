/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.GridRenderer;

/**
 * <p>
 * A simple implementation of the GridRender interface. The grid in the active area is painted differently (lighter)
 * than the grid outside the active area. The grid size can be configured by accessing field gridSize.
 * </p>
 * <p>
 * Thread safety: this class is mutable and not thread safe.
 * </p>
 * @author ly
 * @version 1.0
 */
public class DeployGridRenderer implements GridRenderer {

    /**
     * <p>
     * Represents the size of the grid.
     * </p>
     * <p>
     * Initialized in ctor, must be positive. Can be accessed by getter and setter.
     * </p>
     */
    private int gridSize;

    /**
     * <p>
     * Represents the stroke color.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Creates an instance of <code>DeployGridRenderer</code>.
     * </p>
     * @param gridSize
     *            the gridSize of the grid
     */
    public DeployGridRenderer(int gridSize) {
        this(gridSize, Color.LIGHT_GRAY);
    }

    /**
     * <p>
     * Creates an instance of <code>DeployGridRenderer</code>.
     * </p>
     * @param gridSize
     *            the gridSize of the grid
     * @param strokeColor
     *            the stroke color
     */
    public DeployGridRenderer(int gridSize, Color strokeColor) {
        if (gridSize <= 0) {
            throw new IllegalArgumentException("Grid size should be positive.");
        }
        DeployHelper.checkNotNull(strokeColor, "strokeColor");
        this.gridSize = gridSize;
        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Render background grid for the given DiagramView.
     * </p>
     * @param graphics
     *            the graphics context
     * @param diagramView
     *            the DiagramView for which the grid is rendered
     * @throws IllegalArgumentException
     *             if any of the args is null
     */
    public void renderGrid(Graphics graphics, DiagramView diagramView) {
        DeployHelper.checkNotNull(graphics, "graphics");
        DeployHelper.checkNotNull(diagramView, "diagramView");

        Graphics2D g2d = (Graphics2D) graphics;

        try {
            if (DeployHelper.getProperty("com.topcoder.umltool.deploy", "Antialiasing").equals("true")) {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
			else{
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			}

        } catch (DeployConfigException e) {
        }

        // Record the original color:
        Color originalColor = g2d.getColor();
        // Compute the number of rows and columns of the grid:
        int width = (int) Math.round(diagramView.getWidth());
        int height = (int) Math.round(diagramView.getHeight());

        int row = height / gridSize;
        int columns = width / gridSize;
        // Draw grid as the whole area is inactive:
        g2d.setColor(strokeColor);
        // for each row draw a horizontal line;
        // for each columns draw a vertical line;
        for (int i = 0; i <= row; i++) {
            Stroke stroke;
             if (i % 4 == 0) {
				g2d.setColor(strokeColor);
	            stroke = new BasicStroke();
             } else {
				Color lightStroke=new Color(strokeColor.getRed() + 40, strokeColor.getGreen()+40, strokeColor.getBlue()+40);
		        g2d.setColor(lightStroke);
	            stroke = new BasicStroke();

            }

            g2d.setStroke(stroke);
            g2d.drawLine(0, i * gridSize, width, i * gridSize);
        }
        for (int i = 0; i <= columns; i++) {
            Stroke stroke;
   			 if (i % 4 == 0) {
				g2d.setColor(strokeColor);
	            stroke = new BasicStroke();
             } else {
				Color lightStroke=new Color(strokeColor.getRed() + 40, strokeColor.getGreen()+40, strokeColor.getBlue()+40);
		        g2d.setColor(lightStroke);
	            stroke = new BasicStroke();

            }
            g2d.setStroke(stroke);
            g2d.drawLine(i * gridSize, 0, i * gridSize, height);
        }
        g2d.setStroke(new BasicStroke());
        g2d.setColor(originalColor);
    }

    /**
     * <p>
     * Getter of gridSize, see field doc for explanation.
     * </p>
     * @return the grid size
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * <p>
     * Setter of gridSize, see field doc for explanation.
     * </p>
     * @param gridSize
     *            the new grid size
     * @throws IllegalArgumentException
     *             if the arg is non-positive
     */
    public void setGridSize(int gridSize) {
        if (gridSize <= 0) {
            throw new IllegalArgumentException("Grid size should be positive.");
        }
        this.gridSize = gridSize;
    }
}
