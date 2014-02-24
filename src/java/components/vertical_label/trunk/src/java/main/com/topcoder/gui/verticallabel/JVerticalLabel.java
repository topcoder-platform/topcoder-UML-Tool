/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 * <p>
 * This class extends the <code>JLabel</code> class, and it will layout the text and icon either in 90 degrees or
 * in 270 degrees (i.e. where the ascent is on the left and the decent is on the right OR the ascent is on the right
 * and the descent is on the left).
 * </p>
 * <p>
 * It contains an extra <code>flipped</code> attribute to control how the vertical label is like, if flipped is
 * false (default), the label must be rotated 90 degrees counter-clockwise from usual horizontal orientation; if
 * flipped is true, it must be 270 degrees counter-clockwise (the same as 90 degrees clockwise).
 * </p>
 * <p>
 * It also inherits all functionalities provided by the JLabel, like icon, alignment, component orientation,
 * background/foreground color, text, font, etc.
 * </p>
 * <p>
 * Thread safety: This class is mutable and not thread safe.
 * </p>
 * <p>
 * <strong>Sample usage:</strong><br>
 * <br>
 * ImageIcon icon = new ImageIcon(&quot;test_files/uml.png&quot;);<br>
 * <br>
 * JVerticalLabel label = new JVerticalLabel(&quot;Rotated anti-clockwise&quot;, icon, SwingConstants.LEFT, false);<br>
 * label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);<br>
 * label.setVerticalAlignment(SwingConstants.TOP);<br>
 * label.setBackground(Color.RED);<br>
 * label.setForeground(Color.YELLOW);<br>
 * label.setOpaque(true);<br>
 * label.setFont(Font.getFont(&quot;Arial&quot;));<br>
 * label.setBorder(new EtchedBorder());<br>
 * <br>
 * Container c = new Container();<br>
 * c.setLayout(new GridLayout(1, 1));<br>
 * c.add(label);<br>
 * <br>
 * JFrame jframe = new JFrame(&quot;Sample&quot;);<br>
 * jframe.setContentPane(c);<br>
 * jframe.setSize(new Dimension(200, 400));<br>
 * jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);<br>
 * jframe.setVisible(true);<br>
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class JVerticalLabel extends JLabel {
    /**
     * <p>
     * If flipped is false (default), the label must be rotated 90 degrees counter-clockwise from usual horizontal
     * orientation.
     * </p>
     * <p>
     * If flipped is true, it must be 270 degrees counter-clockwise (the same as 90 degrees clockwise).
     * </p>
     * <p>
     * It can be set in the constructor, and it has getter and setter.
     * </p>
     */
    private boolean flipped = false;

    /**
     * Constructor with no icon and text.
     */
    public JVerticalLabel() {
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with flipped flag.
     *
     * @param flipped the flipped flag.
     */
    public JVerticalLabel(boolean flipped) {
        this();
        setFlipped(flipped);
    }

    /**
     * Constructor with icon.
     *
     * @param icon the icon.
     */
    public JVerticalLabel(Icon icon) {
        super(icon);
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with icon and flipped flag.
     *
     * @param icon the icon.
     * @param flipped the flipped flag.
     */
    public JVerticalLabel(Icon icon, boolean flipped) {
        this(icon);
        setFlipped(flipped);
    }

    /**
     * Constructor with icon and horizontal alignment value.
     *
     * @param icon the icon.
     * @param horizontalAlignment the horizontal alignment.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(Icon icon, int horizontalAlignment) {
        super(icon, horizontalAlignment);
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with icon, horizontal alignment value and flipped flag.
     *
     * @param icon the icon.
     * @param horizontalAlignment the horizontal alignment.
     * @param flipped the flipped flag.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(Icon icon, int horizontalAlignment, boolean flipped) {
        this(icon, horizontalAlignment);
        setFlipped(flipped);
    }

    /**
     * Constructor with text.
     *
     * @param text the label text.
     */
    public JVerticalLabel(String text) {
        super(text);
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with text and flipped flag.
     *
     * @param text the label text.
     * @param flipped the flipped flag.
     */
    public JVerticalLabel(String text, boolean flipped) {
        this(text);
        setFlipped(flipped);
    }

    /**
     * Constructor with text and horizontal alignment value.
     *
     * @param horizontalAlignment the horizontal alignment.
     * @param text the label text.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with text, horizontal alignment value and flipped flag.
     *
     * @param text the label text.
     * @param horizontalAlignment the horizontal alignment.
     * @param flipped the flipped flag.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(String text, int horizontalAlignment, boolean flipped) {
        this(text, horizontalAlignment);
        setFlipped(flipped);
    }

    /**
     * Constructor with text, icon, and horizontal alignment.
     *
     * @param text the label text.
     * @param icon the icon.
     * @param horizontalAlignment the horizontal alignment.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setUI(new VerticalLabelUI());
    }

    /**
     * Constructor with text, icon, horizontal alignment and flipped flag.
     *
     * @param text the label text.
     * @param icon the icon.
     * @param horizontalAlignment the horizontal alignment.
     * @param flipped the flipped flag.
     * @throws IllegalArgumentException if horizontalAlignment is invalid.
     */
    public JVerticalLabel(String text, Icon icon, int horizontalAlignment, boolean flipped) {
        this(text, icon, horizontalAlignment);
        setFlipped(flipped);
    }

    /**
     * Gets the flipped flag.
     *
     * @return the flipped flag.
     */
    public boolean isFlipped() {
        return flipped;
    }

    /**
     * Sets the flipped flag.
     *
     * @param flipped the flipped flag to set.
     */
    public void setFlipped(boolean flipped) {
        if (this.flipped != flipped) {
            firePropertyChange("flipped", this.flipped, flipped);
            this.flipped = flipped;
            repaint();
        }
    }

    /**
     * <p>
     * This class extends the <code>BasicLabelUI</code> class and it is used to paint the icon and text of
     * <code>JVerticalLabel</code> either in a 90 degrees or 270 degrees rotation depending on the
     * JVerticalLabel's flipped flag.
     * </p>
     * <p>
     * It's a private inner static class of JVerticalLabel.
     * </p>
     * <p>
     * Thread safety: This class has mutable static variables, thus it's not thread safe.
     * </p>
     *
     * @author Standlove, TCSDEVELOPER
     * @version 1.0
     */
    private static class VerticalLabelUI extends BasicLabelUI {
        /**
         * <p>
         * Represents the <code>Rectangle</code> for the icon of vertical label to paint. Must be non-null.
         * </p>
         * <p>
         * This rectangle is allocated once for this shared VerticalLabelUI implementation. Re-using rectangle
         * rather than allocating it in each paint call halved the time it took paint to run.
         * </p>
         */
        private static Rectangle paintIconRectangle = new Rectangle();

        /**
         * <p>
         * Represents the <code>Rectangle</code> for the text of vertical label to paint. Must be non-null.
         * </p>
         * <p>
         * This rectangle is allocated once for this shared VerticalLabelUI implementation. Re-using rectangle
         * rather than allocating it in each paint call halved the time it took paint to run.
         * </p>
         */
        private static Rectangle paintTextRectangle = new Rectangle();

        /**
         * <p>
         * Represents the <code>Rectangle</code> for the vertical label to paint. Must be non-null.
         * </p>
         * <p>
         * This rectangle is allocated once for this shared VerticalLabelUI implementation. Re-using rectangle
         * rather than allocating it in each paint call halved the time it took paint to run.
         * </p>
         */
        private static Rectangle paintViewRectangle = new Rectangle();

        /**
         * <p>
         * Represents the <code>Insets</code> for the vertical label to paint. Must be non-null.
         * </p>
         * <p>
         * This Insets is allocated once for this shared VerticalLabelUI implementation. Re-using Insets rather
         * than allocating it in each paint call halved the time it took paint to run.
         * </p>
         */
        private static Insets paintViewInsets = new Insets(0, 0, 0, 0);

        /**
         * Default constructor, currently does nothing.
         */
        public VerticalLabelUI() {

        }

        /**
         * Gets the preferred size of the vertical label. It will simply reverse the height/width of the
         * corresponding horizontal label.
         *
         * @param component the vertical label.
         * @return the preferred size of the vertical label.
         * @throws IllegalArgumentException if the component argument is null or not instance of JVerticalLabel.
         */
        public Dimension getPreferredSize(JComponent component) {
            if (component == null) {
                throw new IllegalArgumentException("Parameter [component] can not be null.");
            }
            if (!(component instanceof JVerticalLabel)) {
                throw new IllegalArgumentException("Parameter [component] should be instance of JVerticalLabel.");
            }
            Dimension d = super.getPreferredSize(component);
            return new Dimension(d.height, d.width);
        }

        /**
         * Paints the vertical label.
         *
         * @param g the graphics.
         * @param component the vertical label.
         * @throws IllegalArgumentException if any argument is null or the component argument is not instance of
         *             JVerticalLabel.
         */
        public void paint(Graphics g, JComponent component) {
            if (g == null) {
                throw new IllegalArgumentException("Parameter [g] can not be null.");
            }
            if (component == null) {
                throw new IllegalArgumentException("Parameter [component] can not be null.");
            }
            if (!(component instanceof JVerticalLabel)) {
                throw new IllegalArgumentException("Parameter [component] should be instance of JVerticalLabel.");
            }

            JVerticalLabel label = (JVerticalLabel) component;

            // Get text and icon.
            String text = label.getText();
            Icon icon = label.isEnabled() ? label.getIcon() : label.getDisabledIcon();

            // Do nothing if icon and text are both null.
            if (icon == null && text == null) {
                return;
            }

            FontMetrics fm = g.getFontMetrics();

            // Calculate the insets of the vertical label
            Insets insets = component.getInsets(paintViewInsets);

            paintViewRectangle.x = insets.left;
            paintViewRectangle.y = insets.top;

            // Reverse the width and height.
            paintViewRectangle.height = component.getWidth() - (insets.left + insets.right);
            paintViewRectangle.width = component.getHeight() - (insets.top + insets.bottom);

            // Reset paintIconRectangle and paintTextRectangle.
            paintIconRectangle.x = 0;
            paintIconRectangle.y = 0;
            paintIconRectangle.width = 0;
            paintIconRectangle.height = 0;

            paintTextRectangle.x = 0;
            paintTextRectangle.y = 0;
            paintTextRectangle.width = 0;
            paintTextRectangle.height = 0;

            // Layout the label.
            String clippedText = layoutCL(label, fm, text, icon, paintViewRectangle, paintIconRectangle,
                paintTextRectangle);

            // Here no need to check g for instance of Graphics2D, since the java environment will ensure it.
            Graphics2D g2d = (Graphics2D) g;

            // Set graphics transformation data.
            AffineTransform tr = g2d.getTransform();
            if (label.isFlipped()) {
                g2d.rotate(Math.PI / 2);
                g2d.translate(0, -component.getWidth());
            } else {
                g2d.rotate(-Math.PI / 2);
                g2d.translate(-component.getHeight(), 0);
            }

            // Paint the icon.
            if (icon != null) {
                icon.paintIcon(component, g, paintIconRectangle.x, paintIconRectangle.y);
            }
            // Paint the text.
            if (text != null) {
                int textX = paintTextRectangle.x;
                int textY = paintTextRectangle.y + fm.getAscent();
                if (label.isEnabled()) {
                    paintEnabledText(label, g, clippedText, textX, textY);
                } else {
                    paintDisabledText(label, g, clippedText, textX, textY);
                }
            }

            // Transform the label.
            g2d.setTransform(tr);
        }
    }
}