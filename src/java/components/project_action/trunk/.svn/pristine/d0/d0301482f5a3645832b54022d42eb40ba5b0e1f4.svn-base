/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.uml.actions.project.ExportDiagramToImageAction;
import com.topcoder.uml.actions.project.failuretests.mock.MockImageExporter;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>ExportDiagramToImageAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExportDiagramToImageActionFailureTest extends TestCase {
    /**
     * An instance of component used to construct ExportDiagramToImageAction.
     */
    private JComponent component;
    
    /**
     * The location used to construct ExportDiagramToImageAction.
     */
    private String location;
    
    /**
     * The fileName used to construct ExportDiagramToImageAction.
     */
    private String fileName;
    
    /**
     * The format used to construct ExportDiagramToImageAction.
     */
    private String format;
    
    /**
     * The format used to construct ExportDiagramToImageAction.
     */
    private ImageExporter imageExporter;
    
    /**
     * The viewport used to construct ExportDiagramToImageAction.
     */
    private Rectangle viewport;
    
    /**
     * Set up for each test.
     */
    protected void setUp() throws Exception {
        component = new JLabel();
        location = "./test_files/failure/location";
        fileName = "test.jpg";
        format = "jpg";
        viewport = new Rectangle();
        imageExporter = new MockImageExporter();
    }
    
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when component is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ComponentIsNull() {
        try {
            new ExportDiagramToImageAction(null, location, fileName, format, imageExporter);
            fail("when component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when location is null, IllegalArgumentException is expected.
     */
    public void testCtor1_LocationIsNull() {
        try {
            new ExportDiagramToImageAction(component, null, fileName, format, imageExporter);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_LocationIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, " \r \t \n ", fileName, format, imageExporter);
            fail("when location is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when fileName is null, IllegalArgumentException is expected.
     */
    public void testCtor1_FileNameIsNull() {
        try {
            new ExportDiagramToImageAction(component, location, null, format, imageExporter);
            fail("when fileName is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when fileName is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_FileNameIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, location, " \r \t \n ", format, imageExporter);
            fail("when fileName is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when format is null, IllegalArgumentException is expected.
     */
    public void testCtor1_FormatIsNull() {
        try {
            new ExportDiagramToImageAction(component, location, fileName, null, imageExporter);
            fail("when format is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when format is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_FormatIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, location, fileName, " \r \t \n ", imageExporter);
            fail("when format is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor ExportDiagramToImageAction(Component component, String
     * location, String fileName, String format, ImageExporter imageExporter),
     * when imageExporter is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ImageExporterIsull() {
        try {
            new ExportDiagramToImageAction(component, location, fileName, format, null);
            fail("when imageExporter is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when component is null, IllegalArgumentException is expected.
     */
    public void testCtor2_ComponentIsNull() {
        try {
            new ExportDiagramToImageAction(null, viewport, location, fileName, format, imageExporter);
            fail("when component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when viewport is null, IllegalArgumentException is expected.
     */
    public void testCtor2_ViewportIsNull() {
        try {
            new ExportDiagramToImageAction(component, null, location, fileName, format, imageExporter);
            fail("when viewport is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when location is null, IllegalArgumentException is expected.
     */
    public void testCtor2_LocationIsNull() {
        try {
            new ExportDiagramToImageAction(component, viewport, null, fileName, format, imageExporter);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor2_LocationIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, viewport, " \r \t \n ", fileName, format, imageExporter);
            fail("when location is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when fileName is null, IllegalArgumentException is expected.
     */
    public void testCtor2_FileNameIsNull() {
        try {
            new ExportDiagramToImageAction(component, viewport, location, null, format, imageExporter);
            fail("when fileName is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when fileName is empty, IllegalArgumentException is expected.
     */
    public void testCtor2_FileNameIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, viewport, location, " \r \t \n ", format, imageExporter);
            fail("when fileName is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when format is null, IllegalArgumentException is expected.
     */
    public void testCtor2_FormatIsNull() {
        try {
            new ExportDiagramToImageAction(component, viewport, location, fileName, null, imageExporter);
            fail("when format is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when format is empty, IllegalArgumentException is expected.
     */
    public void testCtor2_FormatIsEmpty() {
        try {
            new ExportDiagramToImageAction(component, viewport, location, fileName, " \r \t \n ", imageExporter);
            fail("when format is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(Component component, Rectangle
     * viewport, String location, String fileName, String format, ImageExporter
     * imageExporter), when format is null, IllegalArgumentException is expected.
     */
    public void testCtor2_ImageExporterIsNull() {
        try {
            new ExportDiagramToImageAction(component, viewport, location, fileName, format, null);
            fail("when imageExporter is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<Component> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when components is null, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(null, location, fileNames, format, imageExporter);
            fail("when components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<Component> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when components contains null, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsContainsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        components.add(null);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when components contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<Component> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when components is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsContainIsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when components is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<Component> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when location is null, IllegalArgumentException is expected.
     */
    public void testCtor3_LocationIsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, null, fileNames, format, imageExporter);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<Component> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_LocationIsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, "\r \t \n ", fileNames, format, imageExporter);
            fail("when location is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames is null, IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesIsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        try {
            new ExportDiagramToImageAction(components, location, null, format, imageExporter);
            fail("when fileNames is nul, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames is null, IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesContainsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(null);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when fileNames is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames contains null, IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesContainsNUll() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(null);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when fileNames contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesIsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when fileNames is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames contains empty, IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesContainsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(" \r\t\n ");
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when fileNames contains empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when fileNames and components are different size, 
     * IllegalArgumentException is expected.
     */
    public void testCtor3_FileNamesAndCompentsNotSameNumber() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, imageExporter);
            fail("when fileNames and components are different size, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when format is null, IllegalArgumentException is expected.
     */
    public void testCtor3_FormatIsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, null, imageExporter);
            fail("when format is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when format is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_FormatIsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, " \r \t \n ", imageExporter);
            fail("when format is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, String
     * location, List<String> fileNames, String format, ImageExporter
     * imageExporter), when format is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_ImageExporterIsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        try {
            new ExportDiagramToImageAction(components, location, fileNames, format, null);
            fail("when imageExporter is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when components is null, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(null, viewports, location, fileNames, format, imageExporter);
            fail("when components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when components contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsContainsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(null);
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when components contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when components is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsIsEmpty() {
        List<JComponent> components = new ArrayList<JComponent>();
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when components is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when viewports is null, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, null, location, fileNames, format, imageExporter);
            fail("when viewports is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when viewports is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsIsEmpty() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when viewports is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when viewports contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsContainsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(null);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when viewports contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when viewports and components has different size, 
     * IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsAndCompenentsNotSameSize() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when viewports and components has different size, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when location is null, IllegalArgumentException is expected.
     */
    public void testCtor4_LocationIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, null, fileNames, format, imageExporter);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_LocationIsEmpty() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, " \r \t \n ", fileNames, format, imageExporter);
            fail("when location is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when fileNames is null, IllegalArgumentException is expected.
     */
    public void testCtor4_FileNamesIsNull() {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, null, format, imageExporter);
            fail("when fileNames is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when fileNames contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_FileNamesContainsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(null);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when fileNames contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when fileNames contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_FileNamesIsEmpty() {
        List<String> fileNames = new ArrayList<String>();
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when fileNames contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when fileNames contains empty, IllegalArgumentException is expected.
     */
    public void testCtor4_FileNamesContainsEmpty() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(" \r \t \n ");
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when fileNames contains empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when fileNames and compoents are different size, 
     * IllegalArgumentException is expected.
     */
    public void testCtor4_FileNamesAndComponetsSizeAreDifferent() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, imageExporter);
            fail("when fileNames and compoents are different size, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when format is null, IllegalArgumentException is expected.
     */
    public void testCtor4_FormatIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, null, imageExporter);
            fail("when format is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when format is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_FormatIsEmpty() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, " \r \n \t ", imageExporter);
            fail("when format is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor ExportDiagramToImageAction(List<JComponent> components, List<Rectangle>
     * viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter), when imageExporter is null, IllegalArgumentException is expected.
     */
    public void testCtor4_ImageExporterIsNull() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, fileNames, format, null);
            fail("when imageExporter is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test execute(), with viewports,
     * when failed to execute, ActionExecutionException.
     */
    public void testExecute_Failed1() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        
        try {
            new ExportDiagramToImageAction(components, viewports, location, 
                    fileNames, format, imageExporter).execute();
            fail("when failed to execute, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
    
    /**
     * Test execute(), with no viewports,
     * when failed to execute, ActionExecutionException.
     */
    public void testExecute_Failed2() {
        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);
        
        try {
            new ExportDiagramToImageAction(components, location, 
                    fileNames, format, imageExporter).execute();
            fail("when failed to execute, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
}