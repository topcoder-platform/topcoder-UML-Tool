package com.topcoder.umltool.deploy.zumlimport.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentConnector;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
import com.topcoder.gui.panels.style.FontFamilySelector;
import com.topcoder.gui.panels.style.FontSizeSelector;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of import zuml file for sequence diagram.
 * </p>
 *
 * @version 1.0
 */
public class FunctionalTests_SequenceDiagram extends TestCase {
    /**
     * <p>
     * Represents the uml model manager handle the uml model.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Represents the project configuration manager, gets in constructor.
     * </p>
     */
    private ProjectConfigurationManager projectConfigurationManager;

    /**
     * <p>
     * Represents the document tree panel, initialized in constructor.
     * </p>
     */
    private DocumentTreeTabbedPaneImpl documentTreePanelComponent;

    /**
     * <p>
     * Represents the test file 1.
     * </p>
     */
    private String filename;

    /**
     * <p>
     * Represents the test file 2.
     * </p>
     */
    private String filename1;

    /**
     * <p>
     * Represents the test file 3.
     * </p>
     */
    private String filename2;

    /**
     * <p>
     * Represents the test file with a createmessage.
     * </p>
     */
    private String createmessagefilename;

    /**
     * <p>
     * Represents the namespace of config file.
     * </p>
     */
    private static String NS = "com.topcoder.umltool.deploy.zumlimport.test";

    /**
     * <p>
     * Represents the diagram viewer, initialized in constructor.
     * </p>
     */
    private DiagramViewer diagramViewerComponent;

    /**
     * <p>
     * set up test suite.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    @Override
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub
        super.setUp();
        try {
            UIManager.setLookAndFeel("com.topcoder.umltool.deploy.UMLToolLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("config.xml");
        umlModelManager = UMLModelManager.getInstance();

        projectConfigurationManager =
            new ProjectConfigurationManager(umlModelManager, ProjectConfigurationManager.class.getName());

        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);
        umlModelManager.setProjectLanguage("Java");

        documentTreePanelComponent =
            new DocumentTreeTabbedPaneImpl(umlModelManager, "com.topcoder.gui.trees.document.impl");

        diagramViewerComponent = new DiagramViewer();
        filename = getProperty("filename");// "test_files/LDAP_Active_Directory_Interface.zuml";

        filename1 = getProperty("filename1");

        filename2 = getProperty("filename2");
        createmessagefilename = getProperty("createmessage_filename");
    }

    /**
     * <p>
     * Clear up test suite.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    @Override
    protected void tearDown() throws Exception {
        // TODO Auto-generated method stub
        projectConfigurationManager = null;

        documentTreePanelComponent = null;

        diagramViewerComponent = null;
        ConfigManager cm = ConfigManager.getInstance();
        cm.removeNamespace(NS);
        System.gc();
        super.tearDown();
    }

    /**
     * <p>
     * get the property as string from config file.
     * </p>
     *
     *@param key
     *            the property name
     *@return the property as string
     * @throws Exception
     *             to JUnit
     */
    private String getProperty(String key) throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        return (String) cm.getProperty(NS, key);
    }

    /**
     * <p>
     * configGetCol of namespace, if the property loads fail , return the defaultValue.
     * </p>
     *
     * @param property
     *            the property will be loaded.
     * @param defaultValue
     *            the defaultValue of the property.
     * @return the value loaded from namespace ,if fail , return defaultValue
     * @throws ConfigurationException
     *             if the UnknownNamespaceException occurs.
     */
    private Color configGetCol(String property) throws ConfigurationException {
        try {
            ConfigManager cm = ConfigManager.getInstance();
            String color = cm.getString(NS, property);

            return new Color(Integer.parseInt(color, 16));
        } catch (NumberFormatException e) {
            throw new ConfigurationException("configuration error occurs when loading Color"
                + ": The color 's format is error");
        } catch (IllegalArgumentException e) {
            throw new ConfigurationException("configuration error occurs when loading Color");
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("configuration error occurs when loading Color"
                + ": The namespace is unknown");
        }
    }

    /**
     * <p>
     * Verify that sequence diagram's name is correct after import.
     * </p>
     */
    public void test1() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {
                assertEquals(diagram.getName(), getProperty("test1_name"));
                return;
            }
        }
        fail("There is at least a sequence diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram is correctly displayed in the document tree after import.
     * </p>
     */
    public void test2() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();
                assertEquals(node.toString(), getProperty("test2_name"));
                return;
            }
        }
        fail("There are at least a sequence diagram in model");
    }

    /**
     * <p>
     * Verify that sequence diagram's background color is correct after import.
     * </p>
     */
    public void test3() throws Exception {

        File file = new File("test_files/LDAP_Active_Directory_Interface.zuml");

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {
                diagramViewerComponent.createDiagramView(diagram);
                assertEquals(diagramViewerComponent.getDiagramBackgroundColor(), configGetCol("test3_color"));
                return;
            }
        }
        fail("There is at least a sequence diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram's outline color is correct after import.
     * </p>
     */
    public void test4() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {

                DiagramView view = diagramViewerComponent.createDiagramView(diagram);
                StylePanel stylePanel = new StylePanel();

                List<JComponent> list = new ArrayList<JComponent>();
                list.add(view);
                TestHelper.updateStylePanel(list, stylePanel);
                Method method = StylePanel.class.getDeclaredMethod("getOutlineColorButton", (Class[]) null);
                method.setAccessible(true);
                JButton button = (JButton) method.invoke(stylePanel, (Object[]) null);
                method.setAccessible(false);
                System.err.println(button.getBackground());
                assertEquals(button.getBackground(), configGetCol("test4_color"));
                return;
            }
        }
        fail("There is at least a class diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram's font is correct after import.
     * </p>
     */
    public void test5() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {

                DiagramView view = diagramViewerComponent.createDiagramView(diagram);
                Font f = view.getFont();
                String fontName = f == null ? "" : f.getFontName();
                int fontSize = f == null ? 10 : f.getSize();
                assertEquals(fontName, "");
                assertEquals(fontSize, 10);
                StylePanel stylePanel = new StylePanel();

                List<JComponent> list = new ArrayList<JComponent>();
                list.add(view);
                TestHelper.updateStylePanel(list, stylePanel);

                Method method = StylePanel.class.getDeclaredMethod("getFontFamilySelector", (Class[]) null);
                method.setAccessible(true);
                FontFamilySelector selector = (FontFamilySelector) method.invoke(stylePanel, (Object[]) null);
                method.setAccessible(false);
                assertEquals(selector.getSelectedItem().toString(), "");
                return;
            }
        }
        fail("There is at least a sequence diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram's text color is correct after import.
     * </p>
     */
    public void test6() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {

                DiagramView view = diagramViewerComponent.createDiagramView(diagram);

                Color c = view.getForeground();
                if (c == null)
                    c = Color.black;
                assertEquals(c, configGetCol("test6_color"));
                StylePanel stylePanel = new StylePanel();

                List<JComponent> list = new ArrayList<JComponent>();
                list.add(view);
                TestHelper.updateStylePanel(list, stylePanel);

                Method method = StylePanel.class.getDeclaredMethod("getTextColorButton", (Class[]) null);
                method.setAccessible(true);
                JButton button = (JButton) method.invoke(stylePanel, (Object[]) null);
                method.setAccessible(false);
                assertEquals(button.getBackground(), configGetCol("test6_color"));
                return;
            }
        }
        fail("There is at least a sequence diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram's font size is correct after import.
     * </p>
     */
    public void test7() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {

                DiagramView view = diagramViewerComponent.createDiagramView(diagram);
                Font f = view.getFont();
                int fontSize = f == null ? 10 : f.getSize();
                assertEquals(fontSize, 10);
                StylePanel stylePanel = new StylePanel();

                List<JComponent> list = new ArrayList<JComponent>();
                list.add(view);
                TestHelper.updateStylePanel(list, stylePanel);

                Method method = StylePanel.class.getDeclaredMethod("getFontSizeSelector", (Class[]) null);
                method.setAccessible(true);
                FontSizeSelector selector = (FontSizeSelector) method.invoke(stylePanel, (Object[]) null);
                method.setAccessible(false);
                assertEquals(selector.getSelectedItem().toString(), getProperty("test7_size"));
                return;
            }
        }
        fail("There is at least a sequence diagram in file.");
    }

    /**
     * <p>
     * Verify that sequence diagram's size is correct after import.
     * </p>
     */
    public void test8() throws Exception {

        MainFrame mainFrame = new MainFrame();
        mainFrame.loadProject(new File(filename), MainFrame.OPEN_PROJECT_ZUML);
        for (DiagramView view : mainFrame.getDiagramViewer().getCachedDiagramViews()) {

            Diagram diagram = view.getDiagram();

            if (diagram.getName().equals(getProperty("test1_name"))) {
                assertEquals(diagram.getSize().getWidth(), Double.parseDouble(getProperty("test8_width")));
                assertEquals(diagram.getSize().getHeight(), Double.parseDouble(getProperty("test8_height")));
            }

        }

        mainFrame.dispose();

    }

    /**
     * <p>
     * Verify that sequence diagram's location is correct after import.
     * </p>
     */
    public void test9() throws Exception {

        MainFrame mainFrame = new MainFrame();
        mainFrame.loadProject(new File(filename), MainFrame.OPEN_PROJECT_ZUML);
        for (DiagramView view : mainFrame.getDiagramViewer().getCachedDiagramViews()) {

            Diagram diagram = view.getDiagram();

            if (diagram.getName().equals(getProperty("test1_name"))) {
                assertEquals(diagram.getPosition().getX(), Double.parseDouble(getProperty("test9_x")));
                assertEquals(diagram.getPosition().getY(), Double.parseDouble(getProperty("test9_y")));
            }

        }

        mainFrame.dispose();

    }

    /**
     * <p>
     * Verify that lifeline's name is correct after import.
     * </p>
     */
    public void test11() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        // System.err.println(objectNode.getObject().getClassifier());
        assertEquals(objectNode.getName(), getProperty("test11_name"));

    }

    /**
     * <p>
     * Verify that lifeline's type is correct after import.
     * </p>
     */
    public void test12() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        System.err.println(objectNode.getObject().getClassifier());
        assertEquals(objectNode.getObject().getClassifier().getName(), getProperty("test12_name"));// "ActiveDirectoryFactory"
        // );
    }

    /**
     * <p>
     * Verify that lifeline's background color is correct after import.
     * </p>
     */
    public void test13() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getFillColor(), this.configGetCol("test13_color"));
    }

    /**
     * <p>
     * Verify that lifeline's outline color is correct after import.
     * </p>
     */
    public void test14() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);

        assertEquals(objectNode.getStrokeColor(), configGetCol("test14_color"));
    }

    /**
     * <p>
     * Verify that lifeline's font is correct after import.
     * </p>
     */
    public void test15() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getFontFamily(), getProperty("test15_font"));
    }

    /**
     * <p>
     * Verify that lifeline's font color is correct after import.
     * </p>
     */
    public void test16() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getFontColor(), configGetCol("test16_color"));
    }

    /**
     * <p>
     * Verify that lifeline's font size is correct after import.
     * </p>
     */
    public void test17() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getFontSize(), Integer.parseInt(getProperty("test17_size")));
    }

    /**
     * <p>
     * Verify that lifeline's size is correct after import.
     * </p>
     */
    public void test18() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getBounds().getWidth(), Double.parseDouble(getProperty("test18_width")));
        assertEquals(objectNode.getBounds().getHeight(), Double.parseDouble(getProperty("test18_height")));
    }

    /**
     * <p>
     * Verify that lifeline's location is correct after import.
     * </p>
     */
    public void test19() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        assertEquals(objectNode.getBounds().getCenterX(), Double.parseDouble(getProperty("test19_x")));
        assertEquals(objectNode.getBounds().getCenterY(), Double.parseDouble(getProperty("test19_y")));
    }

    /**
     * <p>
     * Verify that lifeline's visibility is correct after import.
     * </p>
     */
    public void test20() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram);
        assertNotNull("There is at least a lifeline in diagram.", objectNode);
        ModelElement element = DeployHelper.getElement(objectNode.getGraphNode());
        assertEquals(element.getVisibility().toString(), getProperty("test20_visiblity"));
    }

    /**
     * <p>
     * Verify that lifeline's stereotypes is correct after import.
     * </p>
     */
    public void test21() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test21_file"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        ObjectNode objectNode = getLifeLineNode(diagram, getProperty("test22_name"));
        assertNotNull("There is at least a lifeline with given name in diagram.", objectNode);
        ModelElement element = DeployHelper.getElement(objectNode);

        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test21_num")));
        Iterator<Stereotype> it = element.getStereotypes().iterator();
        Stereotype steretype = (Stereotype) it.next();
        assertEquals(steretype.getName(), getProperty("test21_name"));
    }

    /**
     * <p>
     * Verify that lifeline's document is correct after import.
     * </p>
     */
    public void test22() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test22_file"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode objectNode = getLifeLineNode(diagram, getProperty("test22_name"));
        assertNotNull("There is at least a lifeline with given name in diagram.", objectNode);

        ModelElement element = DeployHelper.getElement(objectNode);
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), getProperty("test22_doc"));
    }

    /**
     * <p>
     * Verify that lifeline's z-order is correct after import.
     * </p>
     */
    public void test23() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test23_file"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);
        ObjectNode lowZorder_objectNode = getLifeLineNode(diagram, getProperty("test23_low_zorder"));
        assertNotNull("There is no  a lifeline in diagram with name " + getProperty("test23_low_zorder"),
            lowZorder_objectNode);

        ObjectNode highZorder_objectNode = getLifeLineNode(diagram, getProperty("test23_high_zorder"));
        assertNotNull("There is no  a lifeline in diagram with name " + getProperty("test23_high_zorder"),
            highZorder_objectNode);

        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(lowZorder_objectNode) > view.getComponentZOrder(highZorder_objectNode));
    }

    /**
     * <p>
     * Verify that lifeline's display correctly in document Tree after import.
     * </p>
     */
    public void test24() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        Iterator<DocumentTreePanel> iter = documentTreePanelComponent.getPanels().iterator();
        JTree tree = null;
        for (; iter.hasNext() && tree == null;) {
            DocumentTreeView[] views = iter.next().getAllViews();// getCurrentView().getTree();

            for (DocumentTreeView view : views) {
                if (view.getViewType().equals(DocumentTreeViewType.PACKAGE_CENTRIC)) {
                    tree = view.getTree();
                }
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();
            if (docNode.toString().equals(getProperty("test24_name"))) {
                return;
            }
        }
        fail("The lifeline node should display in the document tree.");
    }

    /**
     * <p>
     * Verify that synchronous message's name is correct after import.
     * </p>
     */
    public void test25() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);
        assertEquals(edge.getName(), getProperty("test25_name"));
    }

    /**
     * <p>
     * Verify that synchronous message's start point is correct after import.
     * </p>
     */
    public void test26() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);
        SelectionCorner start = edge.getWayPoints().get(0);
        assertEquals(start.getCenter().getX(), Double.parseDouble(getProperty("test26_x")));
        assertEquals(start.getCenter().getY(), Double.parseDouble(getProperty("test26_y")));
    }

    /**
     * <p>
     * Verify that synchronous message's end point is correct after import.
     * </p>
     */
    public void test27() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);
        SelectionCorner end = edge.getWayPoints().get(edge.getWayPoints().size() - 1);

        assertEquals(end.getCenter().getX(), Double.parseDouble(getProperty("test27_x")));
        assertEquals(end.getCenter().getY(), Double.parseDouble(getProperty("test27_y")));
    }

    /**
     * <p>
     * Verify that synchronous message's steretypes is correct after import.
     * </p>
     */
    public void test28() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test28_file"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test28_num")));
        Iterator<Stereotype> it = element.getStereotypes().iterator();
        Stereotype steretype = (Stereotype) it.next();
        assertEquals(steretype.getName(), getProperty("test28_name"));
    }

    /**
     * <p>
     * Verify that synchronous message's document is correct after import.
     * </p>
     */
    public void test29() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test29_file"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), getProperty("test29_doc"));
    }

    /**
     * <p>
     * Verify that synchronous message's outline color is correct after import.
     * </p>
     */
    public void test30() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getStrokeColor(), configGetCol("test30_color"));
    }

    /**
     * <p>
     * Verify that synchronous message's text color is correct after import.
     * </p>
     */
    public void test31() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontColor(), configGetCol("test31_color"));
    }

    /**
     * <p>
     * Verify that synchronous message's text font is correct after import.
     * </p>
     */
    public void test32() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontFamily(), getProperty("test32_font"));
    }

    /**
     * <p>
     * Verify that synchronous message's text font size is correct after import.
     * </p>
     */
    public void test33() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge edge = getSynchronousMessageEdge(diagram);
        assertNotNull("There is at least a SynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontSize(), Integer.parseInt(getProperty("test33_fontsize")));
    }

    /**
     * <p>
     * Verify that synchronous message display correctly in document Tree after import.
     * </p>
     */
    public void test34() throws Exception {

        File file = new File(filename1);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();
                assertEquals(node.toString(), "Convert To Plain Text Format");
                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode nodeChild = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeChild.toString().equals(getProperty("test25_name"))) {
                        return;
                    }
                }
                fail("The given synchronous message doesn't display in document Tree");
            }
        }
        fail("There are at least a sequence diagram in model");
    }

    /**
     * <p>
     * Verify that synchronous message's Z-order is correct after import.
     * </p>
     */
    public void test35() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test35_filename"));
        assertNotNull("There is at least a sequence diagram in file ", diagram);

        SynchronousMessageEdge[] edges = getSynchronousMessageEdges(diagram);
        assertTrue("There is at least two SynchronousMessageEdge sin diagram.", edges.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(edges[0]) > view.getComponentZOrder(edges[1]));
    }

    /**
     * <p>
     * Verify that asynchronous message's name is correct after import.
     * </p>
     */
    public void test38() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        assertEquals(edge.getName(), getProperty("test38_name"));
    }

    /**
     * <p>
     * Verify that asynchronous message's start point is correct after import.
     * </p>
     */
    public void test39() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        SelectionCorner start = edge.getWayPoints().get(0);

        assertEquals(start.getX(), Integer.parseInt(getProperty("test39_x")));
        assertEquals(start.getY(), Integer.parseInt(getProperty("test39_y")));
    }

    /**
     * <p>
     * Verify that asynchronous message's end point is correct after import.
     * </p>
     */
    public void test40() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        SelectionCorner end = edge.getWayPoints().get(edge.getWayPoints().size() - 1);

        assertEquals(end.getX(), Integer.parseInt(getProperty("test40_x")));
        assertEquals(end.getY(), Integer.parseInt(getProperty("test40_y")));
    }

    /**
     * <p>
     * Verify that asynchronous message's steretypes is correct after import.
     * </p>
     */
    public void test41() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test41_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test41_num")));
        Iterator<Stereotype> it = element.getStereotypes().iterator();
        Stereotype steretype = (Stereotype) it.next();
        assertEquals(steretype.getName(), getProperty("test41_name"));
    }

    /**
     * <p>
     * Verify that asynchronous message's document is correct after import.
     * </p>
     */
    public void test42() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test42_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), getProperty("test42_doc"));
    }

    /**
     * <p>
     * Verify that asynchronous message's outline color is correct after import.
     * </p>
     */
    public void test43() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getStrokeColor(), configGetCol("test43_color"));
    }

    /**
     * <p>
     * Verify that asynchronous message's text color is correct after import.
     * </p>
     */
    public void test44() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontColor(), configGetCol("test43_color"));
    }

    /**
     * <p>
     * Verify that asynchronous message's font is correct after import.
     * </p>
     */
    public void test45() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontFamily(), getProperty("test45_font"));
    }

    /**
     * <p>
     * Verify that asynchronous message's font size is correct after import.
     * </p>
     */
    public void test46() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);

        assertEquals(edge.getFontSize(), Integer.parseInt(getProperty("test46_fontsize")));
    }

    /**
     * <p>
     * Verify that asynchronous message's z-order is correct after import.
     * </p>
     */
    public void test47() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        AsynchronousMessageEdge edge = getAsynchronousMessageEdge(diagram);
        assertNotNull("There is at least a AsynchronousMessageEdge in diagram.", edge);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertEquals(view.getComponentZOrder(edge), Integer.parseInt(getProperty("test47_zorder")));
    }

    /**
     * <p>
     * Verify that asynchronous message display correctly in document tree after import.
     * </p>
     */
    public void test48() throws Exception {

        File file = new File(filename2);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();
                assertEquals(node.toString(), "Activity Monitor Lifecycle");

                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode nodeChild = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeChild.toString().equals(getProperty("test38_name"))) {
                        return;
                    }
                }
                fail("The given asynchronous message doesn't display in document Tree");
            }
        }
        fail("There are at least a sequence diagram in model");
    }

    /**
     * <p>
     * Verify that create message's name is correct after import.
     * </p>
     */
    public void test51() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        assertEquals(edge.getName(), getProperty("test51_name"));
    }

    /**
     * <p>
     * Verify that create message's start point is correct after import.
     * </p>
     */
    public void test52() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        SelectionCorner start = edge.getWayPoints().get(0);

        assertEquals(start.getX(), Integer.parseInt(getProperty("test52_x")));
        assertEquals(start.getY(), Integer.parseInt(getProperty("test52_y")));
    }

    /**
     * <p>
     * Verify that create message's end point is correct after import.
     * </p>
     */
    public void test53() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        SelectionCorner end = edge.getWayPoints().get(edge.getWayPoints().size() - 1);

        assertEquals(end.getX(), Integer.parseInt(getProperty("test53_x")));
        assertEquals(end.getY(), Integer.parseInt(getProperty("test53_x")));
    }

    /**
     * <p>
     * Verify that create message's steretypes is correct after import.
     * </p>
     */
    public void test54() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test54_num")));
        Iterator<Stereotype> it = element.getStereotypes().iterator();
        Stereotype steretype = (Stereotype) it.next();
        assertEquals(steretype.getName(), getProperty("test54_name"));
    }

    /**
     * <p>
     * Verify that create message's document is correct after import.
     * </p>
     */
    public void test55() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        ModelElement element = DeployHelper.getElement(edge.getGraphEdge());
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), Integer.parseInt(getProperty("test55_doc")));
    }

    /**
     * <p>
     * Verify that create message's outline color is correct after import.
     * </p>
     */
    public void test56() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        assertEquals(edge.getStrokeColor(), configGetCol("test56_color"));
    }

    /**
     * <p>
     * Verify that create message's text color is correct after import.
     * </p>
     */
    public void test57() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        assertEquals(edge.getFontColor(), configGetCol("test57_color"));
    }

    /**
     * <p>
     * Verify that create message's font is correct after import.
     * </p>
     */
    public void test58() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        assertEquals(edge.getFontFamily(), getProperty("test58_font"));
    }

    /**
     * <p>
     * Verify that create message's font size is correct after import.
     * </p>
     */
    public void test59() throws Exception {

        Diagram diagram = getSequenceDiagram(createmessagefilename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge edge = getCreateMessageEdge(diagram);
        assertNotNull("There is at least a CreateMessageEdge in diagram.", edge);
        assertEquals(edge.getFontSize(), Integer.parseInt("test59_fontsize"));
    }

    /**
     * <p>
     * Verify that create message's z-order is correct after import.
     * </p>
     */
    public void test60() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test60_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CreateMessageEdge[] edges = getCreateMessageEdges(diagram);
        assertTrue("There is at least two CreateMessageEdge in diagram.", edges.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(edges[0]) > view.getComponentZOrder(edges[1]));
    }

    /**
     * <p>
     * Verify that create message display correctly in document tree after import.
     * </p>
     */
    public void test61() throws Exception {

        File file = new File(createmessagefilename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();
                // assertEquals(node.toString(), "Activity Monitor Lifecycle");

                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode nodeChild = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeChild.toString().equals(getProperty("test51_name"))) {
                        return;
                    }
                }
                fail("The given asynchronous message doesn't display in document Tree");
            }
        }
        fail("There are at least a sequence diagram in model");
    }

    /**
     * <p>
     * Verify that text content is correct after import.
     * </p>
     */
    public void test64() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getText(), getProperty("test64_text"));
    }

    /**
     * <p>
     * Verify that text label location is correct after import.
     * </p>
     */
    public void test65() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);

        assertEquals(node.getX(), Integer.parseInt(getProperty("test65_x")));
        assertEquals(node.getY(), Integer.parseInt(getProperty("test65_y")));
    }

    /**
     * <p>
     * Verify that text label size is correct after import.
     * </p>
     */
    public void test66() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getWidth(), Integer.parseInt(getProperty("test66_width")));
        assertEquals(node.getHeight(), Integer.parseInt(getProperty("test66_height")));
    }

    /**
     * <p>
     * Verify that text label bg color is correct after import.
     * </p>
     */
    public void test67() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getFillColor(), configGetCol("test67_color"));
    }

    /**
     * <p>
     * Verify that text label outline color is correct after import.
     * </p>
     */
    public void test68() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getStrokeColor(), configGetCol("test68_color"));
    }

    /**
     * <p>
     * Verify that text label text color is correct after import.
     * </p>
     */
    public void test69() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        Color c = node.getFontColor() != null ? node.getFontColor() : Color.black;
        assertEquals(c, configGetCol("test69_color"));
    }

    /**
     * <p>
     * Verify that text label text font is correct after import.
     * </p>
     */
    public void test70() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getFont().getFamily(), getProperty("test70_font"));
    }

    /**
     * <p>
     * Verify that text label text font is correct after import.
     * </p>
     */
    public void test71() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode node = getFreeTextNode(diagram);
        assertNotNull("There is at least a TextNode in diagram.", node);
        assertEquals(node.getFont().getSize(), Integer.parseInt(getProperty("test71_fontsize")));
    }

    /**
     * <p>
     * Verify that text label text Z-order is correct after import.
     * </p>
     */
    public void test72() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test72_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        FreeTextNode[] nodes = getFreeTextNodes(diagram);
        assertTrue("There are at least two TextNode in diagram.", nodes.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(nodes[0]) > view.getComponentZOrder(nodes[1]));
    }

    /**
     * <p>
     * Verify that shape (rectangle) size is correct after import.
     * </p>
     */
    public void test73() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        PolylineNode node = getShapeNode(diagram);
        assertNotNull("There is at least a Shape Node in diagram.", node);
        assertEquals(node.getWidth(), Integer.parseInt(getProperty("test73_width")));
        assertEquals(node.getHeight(), Integer.parseInt(getProperty("test73_height")));
    }

    /**
     * <p>
     * Verify that shape (rectangle) location is correct after import.
     * </p>
     */
    public void test74() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        PolylineNode node = getShapeNode(diagram);
        assertNotNull("There is at least a Shape Node in diagram.", node);
        assertEquals(node.getX(), Integer.parseInt(getProperty("test74_x")));
        assertEquals(node.getY(), Integer.parseInt(getProperty("test74_y")));
    }

    /**
     * <p>
     * Verify that shape (rectangle) bg color is correct after import.
     * </p>
     */
    public void test75() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        PolylineNode node = getShapeNode(diagram);
        assertNotNull("There is at least a Shape Node in diagram.", node);
        assertEquals(node.getFillColor(), configGetCol("test75_color"));
    }

    /**
     * <p>
     * Verify that shape (rectangle) outline color is correct after import.
     * </p>
     */
    public void test76() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        PolylineNode node = getShapeNode(diagram);
        assertNotNull("There is at least a Shape Node in diagram.", node);
        Color c = node.getStrokeColor();
        if (c == null)
            c = Color.black;
        assertEquals(c, configGetCol("test76_color"));
    }

    /**
     * <p>
     * Verify that shape (rectangle) Z-order is correct after import.
     * </p>
     */
    public void test80() throws Exception {

        Diagram diagram = getSequenceDiagram(filename1);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        PolylineNode[] nodes = getShapeNodes(diagram);
        assertNotNull("There are at least two Shape Node in diagram.", nodes.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(nodes[0]) > view.getComponentZOrder(nodes[1]));
    }

    /**
     * <p>
     * Verify that comment name is correct after import.
     * </p>
     */
    public void test81() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertNull(node.getName());
    }

    /**
     * <p>
     * Verify that comment content is correct after import.
     * </p>
     */
    public void test82() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertEquals(node.getText(), getProperty("test82_text"));
    }

    /**
     * <p>
     * Verify that comment document is correct after import.
     * </p>
     */
    public void test83() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        ModelElement element = DeployHelper.getElement(node.getGraphNode());
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), getProperty("test83_doc"));
    }

    /**
     * <p>
     * Verify that comment stereotypes is correct after import.
     * </p>
     */
    public void test84() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        ModelElement element = DeployHelper.getElement(node.getGraphNode());
        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test84_num")));
    }

    /**
     * <p>
     * Verify that comment location is correct after import.
     * </p>
     */
    public void test85() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertEquals(node.getX(), Integer.parseInt(getProperty("test85_x")));
        assertEquals(node.getY(), Integer.parseInt(getProperty("test85_y")));
    }

    /**
     * <p>
     * Verify that comment size is correct after import.
     * </p>
     */
    public void test86() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertEquals(node.getWidth(), Integer.parseInt(getProperty("test86_width")));// 170);
        assertEquals(node.getHeight(), Integer.parseInt(getProperty("test86_height")));// 90);
    }

    /**
     * <p>
     * Verify that comment background is correct after import.
     * </p>
     */
    public void test87() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertEquals(node.getFillColor(), configGetCol("test87_color"));
    }

    /**
     * <p>
     * Verify that comment outline color is correct after import.
     * </p>
     */
    public void test88() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getStrokeColor(), configGetCol("test88_color"));
    }

    /**
     * <p>
     * Verify that comment font color is correct after import.
     * </p>
     */
    public void test89() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        Color c = node.getFontColor();
        if (c == null)
            c = Color.black;
        assertEquals(c, configGetCol("test89_color"));
    }

    /**
     * <p>
     * Verify that comment font is correct after import.
     * </p>
     */
    public void test90() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFont().getFamily(), getProperty("test90_font"));
    }

    /**
     * <p>
     * Verify that comment font size is correct after import.
     * </p>
     */
    public void test91() throws Exception {

        Diagram diagram = getSequenceDiagram(filename);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFont().getSize(), Integer.parseInt(getProperty("test91_fontsize")));
    }

    /**
     * <p>
     * Verify that comment z-order is correct after import.
     * </p>
     */
    public void test92() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test92_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode[] nodes = getCommentNodes(diagram);
        assertTrue("There are at least two Comment Node in diagram.", nodes.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(nodes[0]) > view.getComponentZOrder(nodes[1]));
    }

    /**
     * <p>
     * Verify that comment display correctly in documentTree after import.
     * </p>
     */
    public void test93() throws Exception {

        File file = new File(filename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();

                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode nodeChild = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeChild.toString().equals(getProperty("test93_name"))) {
                        return;
                    }
                }
                fail("The given comment node doesn't display in document Tree");
            }
        }
        fail("There are at least a sequence diagram in model");
    }

    /**
     * <p>
     * Verify that comment (comment to model element) name is correct after import.
     * </p>
     */
    public void test94() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertNull(node.getName());
    }

    /**
     * <p>
     * Verify that comment (comment to model element) content is correct after import.
     * </p>
     */
    public void test95() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getText(), getProperty("test95_text"));
    }

    /**
     * <p>
     * Verify that comment (comment to model element) connect to model element.
     * </p>
     */
    public void test96() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        assertTrue(node.getConnector() instanceof CommentConnector);
        SynchronousMessageEdge[] edges = getSynchronousMessageEdges(diagram);
        GraphElement connected = null;
        for (SynchronousMessageEdge edge : edges) {
            if (getProperty("test96_name").equals(edge.getName())) {
                connected = edge.getGraphEdge();
                break;
            }
        }
        assertNotNull("The connected element doesn't exist", connected);
        List<GraphConnector> anchorages = node.getGraphNode().getAnchorages();

        for (int i = 0; i < anchorages.size(); i++) {
            GraphConnector conn = anchorages.get(i);
            Iterator<GraphEdge> iter = conn.getGraphEdges().iterator();
            while (iter.hasNext()) {
                GraphEdge edge = iter.next();
                List<GraphConnector> anchors = edge.getAnchors();
                for (int j = 0; j < anchors.size(); j++) {
                    if (connected == anchors.get(j).getGraphElement()) {
                        return;
                    }
                }
            }
        }
        fail("The comment doesn't connect to the correct model element");

    }

    /**
     * <p>
     * Verify that comment (comment to model element) document is correct after import.
     * </p>
     */
    public void test97() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        ModelElement element = DeployHelper.getElement(node.getGraphNode());
        DocumentationPanel docPanel = TestHelper.createDocumentationPanel();
        docPanel.setTarget(element);
        DefaultDocumentationEditor docEditor =
            (DefaultDocumentationEditor) ((JSplitPane) docPanel.getComponent(0)).getComponent(0);
        JTextArea docTextArea = (JTextArea) ((JScrollPane) docEditor.getComponent(0)).getViewport().getView();
        assertEquals(docTextArea.getText(), getProperty("test97_doc"));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) steretypes is correct after import.
     * </p>
     */
    public void test98() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);
        ModelElement element = DeployHelper.getElement(node.getGraphNode());

        assertEquals(element.getStereotypes().size(), Integer.parseInt(getProperty("test98_num")));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) label location is correct after import.
     * </p>
     */
    public void test99() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getX(), Integer.parseInt(getProperty("test99_x")));
        assertEquals(node.getY(), Integer.parseInt(getProperty("test99_y")));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) label size is correct after import.
     * </p>
     */
    public void test100() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getWidth(), Integer.parseInt(getProperty("test100_width")));
        assertEquals(node.getHeight(), Integer.parseInt(getProperty("test100_height")));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) bgcolor is correct after import.
     * </p>
     */
    public void test101() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFillColor(), configGetCol("test101_color"));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) outline color is correct after import.
     * </p>
     */
    public void test102() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getStrokeColor(), configGetCol("test102_color"));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) font color is correct after import.
     * </p>
     */
    public void test103() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFontColor(), configGetCol("test103_color"));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) font family is correct after import.
     * </p>
     */
    public void test104() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFont().getFamily(), getProperty("test104_font"));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) font Size is correct after import.
     * </p>
     */
    public void test105() throws Exception {

        Diagram diagram = getSequenceDiagram(filename2);
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode node = getCommentNode(diagram);
        assertNotNull("There is at least a Comment Node in diagram.", node);

        assertEquals(node.getFont().getSize(), Integer.parseInt(getProperty("test105_fontsize")));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) z-order is correct after import.
     * </p>
     */
    public void test106() throws Exception {

        Diagram diagram = getSequenceDiagram(getProperty("test106_file"));
        assertNotNull("There is no given sequence diagram in file ", diagram);

        CommentNode[] nodes = getCommentNodes(diagram);
        assertTrue("There are at least two Comment Node in diagram.", nodes.length >= 2);
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);
        assertTrue(view.getComponentZOrder(nodes[0]) > view.getComponentZOrder(nodes[1]));

    }

    /**
     * <p>
     * Verify that comment (comment to model element) display correctly in documentTree after import.
     * </p>
     */
    public void test107() throws Exception {

        File file = new File(filename2);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        documentTreePanelComponent.updateTree();
        // documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel().getAllViews();// getCurrentView().
        // getTree();
        JTree tree = null;
        for (DocumentTreeView view : views) {
            if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
                tree = view.getTree();
            }
        }
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);

            DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

            if ("Sequence Diagram".equals(docNode.toString())) {
                node = (DefaultMutableTreeNode) node.getFirstChild();
                assertEquals(node.toString(), "Activity Monitor Lifecycle");

                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode nodeChild = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeChild.toString().equals(getProperty("test107_name"))) {
                        return;
                    }
                }
                fail("The given comment node doesn't display in document Tree");
            }
        }
        fail("There are at least a sequence diagram in model");

    }

    /**
     * <p>
     * Return the first CreateMessageEdge in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first create message in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private CreateMessageEdge getCreateMessageEdge(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphEdge) {
                Edge edge = TestHelper.createEdge((GraphEdge) diagramElement, view, true);
                if (edge instanceof CreateMessageEdge) {
                    CreateMessageEdge sEdge = (CreateMessageEdge) edge;

                    return sEdge;
                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the all CreateMessageEdges in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the create message array contains all createmssages diagram or empty atray if not found
     * @throws Exception
     *             to junit
     */
    private CreateMessageEdge[] getCreateMessageEdges(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        List<CreateMessageEdge> ret = new ArrayList<CreateMessageEdge>();
        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphEdge) {
                Edge edge = TestHelper.createEdge((GraphEdge) diagramElement, view, true);

                if (edge instanceof CreateMessageEdge) {
                    CreateMessageEdge sEdge = (CreateMessageEdge) edge;

                    ret.add(sEdge);
                }
            }

        }
        return ret.toArray(new CreateMessageEdge[ret.size()]);
    }

    /**
     * <p>
     * Return the first asynchronousMessageEdge in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first asynchronous message in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private AsynchronousMessageEdge getAsynchronousMessageEdge(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphEdge) {
                Edge edge = TestHelper.createEdge((GraphEdge) diagramElement, view, true);

                if (edge instanceof AsynchronousMessageEdge) {
                    AsynchronousMessageEdge sEdge = (AsynchronousMessageEdge) edge;

                    return sEdge;
                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the first synchronousMessageEdge in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first synchronous message in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private SynchronousMessageEdge getSynchronousMessageEdge(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphEdge) {
                Edge edge = TestHelper.createEdge((GraphEdge) diagramElement, view, true);

                if (edge instanceof SynchronousMessageEdge) {
                    SynchronousMessageEdge sEdge = (SynchronousMessageEdge) edge;

                    return sEdge;
                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the all synchronousMessageEdges in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return all synchronous message in diagram or emptry array if not found
     * @throws Exception
     *             to junit
     */
    private SynchronousMessageEdge[] getSynchronousMessageEdges(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        List<SynchronousMessageEdge> ret = new ArrayList<SynchronousMessageEdge>();
        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphEdge) {
                Edge edge = TestHelper.createEdge((GraphEdge) diagramElement, view, true);

                if (edge instanceof SynchronousMessageEdge) {
                    SynchronousMessageEdge sEdge = (SynchronousMessageEdge) edge;

                    ret.add(sEdge);
                }
            }

        }
        return ret.toArray(new SynchronousMessageEdge[ret.size()]);
    }

    /**
     * <p>
     * Return the first FreeTextNode in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first FreeTextNode in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private FreeTextNode getFreeTextNode(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof FreeTextNode) {
                    return (FreeTextNode) node;

                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the all FreeTextNodes in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the FreeTextNode array
     * @throws Exception
     *             to junit
     */
    private FreeTextNode[] getFreeTextNodes(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();
        List<FreeTextNode> ret = new ArrayList<FreeTextNode>();
        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof FreeTextNode) {
                    // return (FreeTextNode) node;
                    ret.add((FreeTextNode) node);
                }
            }

        }
        return ret.toArray(new FreeTextNode[ret.size()]);
    }

    /**
     * <p>
     * Return the first Comment Node in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first CommentNode in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private CommentNode getCommentNode(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof CommentNode) {
                    return (CommentNode) node;

                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the all Comment Nodes in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the CommentNode array
     * @throws Exception
     *             to junit
     */
    private CommentNode[] getCommentNodes(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();
        List<CommentNode> ret = new ArrayList<CommentNode>();
        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof CommentNode) {
                    // return (CommentNode) node;
                    ret.add((CommentNode) node);
                }
            }

        }
        return ret.toArray(new CommentNode[ret.size()]);
    }

    /**
     * <p>
     * Return the first Shape Node in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first Shape Node in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private PolylineNode getShapeNode(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof PolylineNode) {
                    return (PolylineNode) node;

                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the all Shape Nodes in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the shape Node array found
     * @throws Exception
     *             to junit
     */
    private PolylineNode[] getShapeNodes(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();
        List<PolylineNode> ret = new ArrayList<PolylineNode>();
        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof PolylineNode) {
                    // return (PolylineNode) node;
                    ret.add((PolylineNode) node);
                }
            }

        }
        return ret.toArray(new PolylineNode[ret.size()]);
    }

    /**
     * <p>
     * Return the first Lifeline ObjectNode with not null type in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @return the first life line node in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private ObjectNode getLifeLineNode(Diagram diagram) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof ObjectNode) {
                    ObjectNode objectNode = (ObjectNode) node;

                    if (objectNode.getObject().getClassifier() == null) {
                        continue;
                    }

                    for (Component component : node.getComponents()) {
                        if (component instanceof Lifeline) {
                            return (ObjectNode) node;
                        }
                    }

                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the first Lifeline ObjectNode with given name in the diagram.
     * </p>
     *
     * @param diagram
     *            the given sequence diagram
     * @param name
     *            the given lifeline name
     * @return the life line node in diagram or null if not found
     * @throws Exception
     *             to junit
     */
    private ObjectNode getLifeLineNode(Diagram diagram, String name) throws Exception {
        DiagramView view = diagramViewerComponent.createDiagramView(diagram);

        List<DiagramElement> list = diagram.getContaineds();

        for (int j = 0; j < list.size(); j++) {
            DiagramElement diagramElement = list.get(j);
            if (diagramElement instanceof GraphNode || diagramElement instanceof Polyline) {
                Node node = TestHelper.createNode(diagramElement, view, true);
                if (node instanceof ObjectNode) {
                    ObjectNode objectNode = (ObjectNode) node;
                    if (objectNode.getName().equals(name)) {
                        return objectNode;
                    }
                }
            }

        }
        return null;
    }

    /**
     * <p>
     * Return the given name sequence diagram in the umlfile.
     * </p>
     *
     * @param umlfilename
     *            the uml file name
     * @param name
     *            the diagram name
     * @return the first diagram in the uml file or null if no sequence diagram
     * @throws Exception
     *             to junit
     */
    private Diagram getSequenceDiagram(String umlfilename, String name) throws Exception {
        File file = new File(umlfilename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram)) && diagram.getName().equals(name)) {

                return diagram;

            }
        }
        return null;
    }

    /**
     * <p>
     * Return the first sequence diagram in the umlfile.
     * </p>
     *
     * @param umlfilename
     *            the uml file name
     * @return the first diagram in the uml file or null if no sequence diagram
     * @throws Exception
     *             to junit
     */
    private Diagram getSequenceDiagram(String umlfilename) throws Exception {
        File file = new File(umlfilename);

        DeployHelper.loadPoseidonFile(file, umlModelManager, projectConfigurationManager, false);

        List<Diagram> diagramlists = umlModelManager.getDiagrams();
        for (int i = 0; i < diagramlists.size(); i++) {
            Diagram diagram = diagramlists.get(i);
            if ("SequenceDiagram".equals(DeployHelper.getTypeInfo(diagram))) {
                return diagram;

            }
        }
        return null;
    }

}