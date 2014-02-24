/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.gui.panels.style.accuracytests;

import static com.topcoder.gui.panels.style.accuracytests.TestHelper.NAMESPACE;
import static com.topcoder.gui.panels.style.accuracytests.TestHelper.createProp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.StyleEvent;
import com.topcoder.gui.panels.style.StyleListener;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

/**
 * Unit test for <code>StylePanel</code> class. You'd better run this test as java Application.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StylePanelTests extends TestCase {
    /**
     * Represents the StylePanel panel used for test.
     */
    private StylePanel panel = null;

    /**
     * Represents the String namespace used for test.
     */
    private String namespace = NAMESPACE;

    /**
     * Represents the StyleListener styleListener used for test.
     */
    private StyleListener styleListener = null;

    /**
     * Represents the StyleObject styleObject used for test.
     */
    private StyleObject styleObject = null;

    /**
     * Represents the List_StyleObject styleObjectList used for test.
     */
    private List<StyleObject> styleObjectList = null;

    /**
     * Represents the JFrame frm used for test.
     */
    private JFrame frm = null;

    /**
     * Represents the graph elements used for test.
     */
    private List<DiagramElement> elements = null;

    /**
     * Set up the test environment.
     * 
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleConfigFile();
        panel = new StylePanel(namespace);

        frm = new JFrame("Demo Test");
        frm.setBounds(200, 200, 600, 300);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);

        frm.add(panel);

        styleListener = new StyleListener() {
            public void styleChanged(StyleEvent styleEvent) {
                System.out.println("Style Changed");
            }
        };

        elements = new ArrayList<DiagramElement>();
        styleObjectList = new ArrayList<StyleObject>();

        for (int i = 0; i < 6; i++) {
            GraphEdge edge;
            GraphNode node;
            Polyline line;
            switch (i % 3) {
                case 0:
                    edge = new GraphEdge();
                    elements.add(edge);
                    styleObjectList.add(new GraphEdgeStyleObjectAdapter(edge));
                    break;
                case 1:
                    node = new GraphNode();
                    elements.add(node);
                    styleObjectList.add(new GraphNodeStyleObjectAdapter(node));
                    break;
                case 2:
                    line = new Polyline();
                    elements.add(line);
                    styleObjectList.add(new PolylineStyleObjectAdapter(line));
                    break;
            }
        }

        for (DiagramElement ele : elements) {
            ele.addProperty(createProp("width", "400"));
            ele.addProperty(createProp("height", "150"));
            ele.addProperty(createProp("x", "40"));
            ele.addProperty(createProp("y", "50"));
            ele.addProperty(createProp("fontName", "Arial"));
            ele.addProperty(createProp("fontSize", "12"));
            ele.addProperty(createProp("fillColor", "#00FF00"));
            ele.addProperty(createProp("outlineColor", "#0000FF"));
            ele.addProperty(createProp("textColor", "#000000"));
        }

        styleObject = styleObjectList.get(3);

    }

    /**
     * Tear down the test environment.
     * 
     * @throws Exception
     *             if any error occurred when tear down
     */
    public void tearDown() throws Exception {
        frm.dispose();
        frm = null;
    }

    /**
     * Accuracy test for the Constructor <code>StylePanel()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testStylePanelAccuracy() throws Exception {
        StylePanel panel1 = new StylePanel();
        // verify
        assertNotNull("the object should be created", panel1);
    }

    /**
     * Accuracy test for the Constructor <code>StylePanel(String namespace)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testStylePanelStringAccuracy() throws Exception {
        TestHelper.loadSingleConfigFile();
        StylePanel panel1 = new StylePanel(namespace);
        // verify
        assertNotNull("the object should be created", panel1);
    }

    /**
     * Accuracy test for the Method <code>Font getFont()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontAccuracy() throws Exception {
        Font font1 = panel.getFont();
        // verify
        System.out.println(font1);
    }

    /**
     * Accuracy test for the Method <code>void addStyleListener(StyleListener styleListener)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testAddStyleListenerStyleListenerAccuracy() throws Exception {
        panel.addStyleListener(styleListener);
    }

    /*
     * The following is a list of style support:
     * 
     *              Edge    Node    Line
     * fillColor    x       
     * fontName                     x
     * fontSize                     x
     * height       x               x
     * width        x               x
     * outlineColor            
     * textColor                    x
     * x                            x
     * y                            x
     *
     * Try run the following tests to verify the functionity
     * of the component submited.
     */
    
    /**
     * Accuracy test for the Method <code>void setStyleObject(StyleObject styleObject)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetStyleObjectStyleObjectAccuracy0() throws Exception {
        panel.setStyleObject(styleObjectList.get(0));
    }

    /**
     * Accuracy test for the Method <code>void setStyleObject(StyleObject styleObject)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetStyleObjectStyleObjectAccuracy1() throws Exception {
        panel.setStyleObject(styleObjectList.get(1));
    }

    /**
     * Accuracy test for the Method <code>void setStyleObject(StyleObject styleObject)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetStyleObjectStyleObjectAccuracy2() throws Exception {
        panel.setStyleObject(styleObjectList.get(2));
    }

    /**
     * Accuracy test for the Method
     * <code>void setStyleObject(List_StyleObject styleObjectList)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetStyleObjectListAccuracy() throws Exception {
        panel.setStyleObjectList(styleObjectList);
        panel.setStyleObjectList(styleObjectList);
        assertEquals("the value is wrong", 6, styleObjectList.size());
    }

    /**
     * Accuracy test for the property <code>List_StyleObject getStyleObjectList</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetStyleObjectListAccuracy() throws Exception {
        panel.setStyleObjectList(styleObjectList);
        List<StyleObject> l1 = panel.getStyleObjectList();
        // verify
        assertEquals("the value is wrong", styleObjectList, l1);
    }

    /**
     * Accuracy test for the Method <code>String getHeightKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetHeightKeyAccuracy() throws Exception {
        String string1 = panel.getHeightKey();
        // verify
        assertEquals("the value is wrong", "height", string1);
    }

    /**
     * Accuracy test for the Method <code>String getWidthKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetWidthKeyAccuracy() throws Exception {
        String string1 = panel.getWidthKey();
        // verify
        assertEquals("the value is wrong", "width", string1);
    }

    /**
     * Accuracy test for the Method <code>String getXKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetXKeyAccuracy() throws Exception {
        String string1 = panel.getXKey();
        // verify
        assertEquals("the value is wrong", "x", string1);
    }

    /**
     * Accuracy test for the Method <code>String getYKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetYKeyAccuracy() throws Exception {
        String string1 = panel.getYKey();
        // verify
        assertEquals("the value is wrong", "y", string1);
    }

    /**
     * Accuracy test for the Method <code>String getFontNameKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontNameKeyAccuracy() throws Exception {
        String string1 = panel.getFontNameKey();
        // verify
        assertEquals("the value is wrong", "fontName", string1);
    }

    /**
     * Accuracy test for the Method <code>String getFontSizeKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFontSizeKeyAccuracy() throws Exception {
        String string1 = panel.getFontSizeKey();
        // verify
        assertEquals("the value is wrong", "fontSize", string1);
    }

    /**
     * Accuracy test for the Method <code>String getFillColorKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetFillColorKeyAccuracy() throws Exception {
        String string1 = panel.getFillColorKey();
        // verify
        assertEquals("the value is wrong", "fillColor", string1);
    }

    /**
     * Accuracy test for the Method <code>String getOutlineColorKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetOutlineColorKeyAccuracy() throws Exception {
        String string1 = panel.getOutlineColorKey();
        // verify
        assertEquals("the value is wrong", "outlineColor", string1);
    }

    /**
     * Accuracy test for the Method <code>String getTextColorKey()</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetTextColorKeyAccuracy() throws Exception {
        String string1 = panel.getTextColorKey();
        // verify
        assertEquals("the value is wrong", "textColor", string1);
    }

    /**
     * Accuracy test for the Method <code>void setFont(Font font)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetFontFontAccuracy() throws Exception {
        panel.setFont(new Font("System", 2, 14));
    }

    /**
     * Accuracy test for the Method <code>void setFontFamilyStyle(String fontFamily)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetFontFamilyStyleStringAccuracy() throws Exception {
        panel.setFontFamilyStyle("Arial");
    }

    /**
     * Accuracy test for the Method <code>void setFontSizeStyle(int fontSize)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetFontSizeStyleIntAccuracy() throws Exception {
        panel.setFontSizeStyle(6);
    }

    /**
     * Accuracy test for the Method <code>void setFillColorStyle(Color fillColor)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetFillColorStyleColorAccuracy() throws Exception {
        panel.setFillColorStyle(Color.GREEN);
    }

    /**
     * Accuracy test for the Method <code>void setOutlineColorStyle(Color outlineColor)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetOutlineColorStyleColorAccuracy() throws Exception {
        panel.setOutlineColorStyle(Color.YELLOW);
    }

    /**
     * Accuracy test for the Method <code>void setTextColorStyle(Color textColor)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetTextColorStyleColorAccuracy() throws Exception {
        panel.setTextColorStyle(Color.BLUE);
    }

    /**
     * Accuracy test for the Method <code>void setPositionStyle(Point position)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetPositionStylePointAccuracy() throws Exception {
        panel.setPositionStyle(new Point(30, 20));
    }

    /**
     * Accuracy test for the Method <code>void setSizeStyle(Dimension size)</code>.
     * 
     * @throws Exception
     *             throws to JUnit
     */
    public void testSetSizeStyleDimensionAccuracy() throws Exception {
        panel.setSizeStyle(new Dimension(300, 600));
    }

    /*
     * Demo Tests
     */
    public int CntStyleObjects(){
        return styleObjectList.size();
    }

    public void callSetUp() throws Exception {
        setUp();
    }

    public void callTearDown() throws Exception {
        tearDown();
    }

    public static StylePanelTests test;

    public static Map<String, Method> map;

    public static void main(String[] args) throws Exception {
        test = new StylePanelTests();
        test.callSetUp();

        Class c = test.getClass();
        Method[] mthds = c.getMethods();

        map = new HashMap<String, Method>();

        JFrame frmMthds = new JFrame("Methods");
        JComboBox box = new JComboBox();

        for (Method m : mthds) {
            if (m.getName().startsWith("test")) {
                box.addItem(m.getName());
                map.put(m.getName(), m);
            }
        }

        box.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println(test.CntStyleObjects());
                try {
                    map.get((String) e.getItem()).invoke(test, new Object[] {});
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frmMthds.add(box);
        frmMthds.setBounds(20, 200, 300, 50);
        frmMthds.setVisible(true);

    }

}
