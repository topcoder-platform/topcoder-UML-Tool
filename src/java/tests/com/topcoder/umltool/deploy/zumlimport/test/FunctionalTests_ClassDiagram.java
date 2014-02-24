package com.topcoder.umltool.deploy.zumlimport.test;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.panels.style.FontFamilySelector;
import com.topcoder.gui.panels.style.FontSizeSelector;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.config.ConfigManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.util.ArrayList;

public class FunctionalTests_ClassDiagram extends TestCase {

	private UMLModelManager umlModelManager;

	private ProjectConfigurationManager projectConfigurationManager;

	/**
	 * <p>
	 * Represents the document tree panel, initialized in constructor.
	 * </p>
	 */
	private DocumentTreeTabbedPaneImpl documentTreePanelComponent;

	/**
	 * <p>
	 * Represents the namespace of config file.
	 * </p>
	 */
	private static String NS = "com.topcoder.umltool.deploy.zumlimport.test.class";

	/**
	 * <p>
	 * Represents the diagram viewer, initialized in constructor.
	 * </p>
	 */
	private DiagramViewer diagramViewerComponent;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		try {
			UIManager
					.setLookAndFeel("com.topcoder.umltool.deploy.UMLToolLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConfigManager cm = ConfigManager.getInstance();
		cm.add("class_config.xml");
		umlModelManager = UMLModelManager.getInstance();

		projectConfigurationManager = new ProjectConfigurationManager(
				umlModelManager, ProjectConfigurationManager.class.getName());

		umlModelManager
				.setProjectConfigurationManager(projectConfigurationManager);
		umlModelManager.setProjectLanguage("Java");

		documentTreePanelComponent = new DocumentTreeTabbedPaneImpl(
				umlModelManager, "com.topcoder.gui.trees.document.impl");

		diagramViewerComponent = new DiagramViewer();
	}

	@Override
	protected void tearDown() throws Exception {
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
	 * Verify that class diagram's name is correct after import.
	 * </p>
	 */
	public void test1() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test1_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		for (int i = 0; i < diagramlists.size(); i++) {
			Diagram diagram = diagramlists.get(i);
			if ("ClassDiagram".equals(DeployHelper.getTypeInfo(diagram))) {
				assertEquals(diagram.getName(), TestHelper.getProperty(NS,
						"test1_name"));
				return;
			}
		}
		fail("There is at least a class diagram in file.");
	}

	/**
	 * <p>
	 * Verify that class diagram is correctly displayed in the document tree
	 * after import.
	 * </p>
	 */
	public void test2() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test2_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		// documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();// getCurrentView().getTree();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				assertEquals(node.toString(), TestHelper.getProperty(NS,
						"test2_name"));
				return;
			}
		}
		fail("There are at least a class diagram in model");
	}

	/**
	 * <p>
	 * Verify that class diagram's background color is correct after import.
	 * </p>
	 */
	public void test3() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test3_filename"), TestHelper.getProperty(NS,
				"test3_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		assertEquals(diagramViewerComponent.getDiagramBackgroundColor(),
				TestHelper.configGetCol(NS, "test3_color"));
	}

	/**
	 * <p>
	 * Verify that class diagram's outline color is correct after import.
	 * </p>
	 */
	public void test4() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test4_filename"), TestHelper.getProperty(NS,
				"test4_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		StylePanel stylePanel = new StylePanel();

		List<JComponent> list = new ArrayList<JComponent>();
		list.add(view);
		TestHelper.updateStylePanel(list, stylePanel);
		Method method = StylePanel.class.getDeclaredMethod(
				"getOutlineColorButton", (Class[]) null);
		method.setAccessible(true);
		JButton button = (JButton) method.invoke(stylePanel, (Object[]) null);
		method.setAccessible(false);
		assertEquals(button.getBackground(), TestHelper.configGetCol(NS,
				"test4_color"));
	}

	/**
	 * <p>
	 * Verify that class diagram's font is correct after import.
	 * </p>
	 */
	public void test5() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test5_filename"), TestHelper.getProperty(NS,
				"test5_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

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

		Method method = StylePanel.class.getDeclaredMethod(
				"getFontFamilySelector", (Class[]) null);
		method.setAccessible(true);
		FontFamilySelector selector = (FontFamilySelector) method.invoke(
				stylePanel, (Object[]) null);
		method.setAccessible(false);
		assertEquals(selector.getSelectedItem().toString(), TestHelper
				.getProperty(NS, "test5_fontname"));
	}

	/**
	 * <p>
	 * Verify that class diagram's text color is correct after import.
	 * </p>
	 */
	public void test6() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test6_filename"), TestHelper.getProperty(NS,
				"test6_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		Color c = view.getForeground();
		if (c == null)
			c = Color.black;
		assertEquals(c, TestHelper.configGetCol(NS, "test6_color"));
		StylePanel stylePanel = new StylePanel();

		List<JComponent> list = new ArrayList<JComponent>();
		list.add(view);
		TestHelper.updateStylePanel(list, stylePanel);

		Method method = StylePanel.class.getDeclaredMethod(
				"getTextColorButton", (Class[]) null);
		method.setAccessible(true);
		JButton button = (JButton) method.invoke(stylePanel, (Object[]) null);
		method.setAccessible(false);
		assertEquals(button.getBackground(), TestHelper.configGetCol(NS,
				"test6_color"));
	}

	/**
	 * <p>
	 * Verify that class diagram's font size is correct after import.
	 * </p>
	 */
	public void test7() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test7_filename"), TestHelper.getProperty(NS,
				"test7_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		Font f = view.getFont();
		int fontSize = f == null ? 10 : f.getSize();
		assertEquals(fontSize, 10);
		StylePanel stylePanel = new StylePanel();

		List<JComponent> list = new ArrayList<JComponent>();
		list.add(view);
		TestHelper.updateStylePanel(list, stylePanel);

		Method method = StylePanel.class.getDeclaredMethod(
				"getFontSizeSelector", (Class[]) null);
		method.setAccessible(true);
		FontSizeSelector selector = (FontSizeSelector) method.invoke(
				stylePanel, (Object[]) null);
		method.setAccessible(false);
		assertEquals(selector.getSelectedItem().toString(), TestHelper
				.getProperty(NS, "test7_size"));
	}

	/**
	 * <p>
	 * Verify that class diagram's size is correct after import.
	 * </p>
	 */
	public void test8() throws Exception {

		MainFrame mainFrame = new MainFrame();
		mainFrame.loadProject(new File(TestHelper.getProperty(NS,
				"test8_filename")), MainFrame.OPEN_PROJECT_ZUML);
		for (DiagramView view : mainFrame.getDiagramViewer()
				.getCachedDiagramViews()) {

			Diagram diagram = view.getDiagram();

			if (diagram.getName().equals(
					TestHelper.getProperty(NS, "test8_diagram_name"))) {
				assertEquals(diagram.getSize().getWidth(), Double
						.parseDouble(TestHelper.getProperty(NS, "test8_width")));
				assertEquals(diagram.getSize().getHeight(),
						Double.parseDouble(TestHelper.getProperty(NS,
								"test8_height")));
			}

		}

		mainFrame.dispose();
	}

	/**
	 * <p>
	 * Verify that class diagram's location is correct after import.
	 * </p>
	 */
	public void test9() throws Exception {

		MainFrame mainFrame = new MainFrame();
		mainFrame.loadProject(new File(TestHelper.getProperty(NS,
				"test9_filename")), MainFrame.OPEN_PROJECT_ZUML);
		for (DiagramView view : mainFrame.getDiagramViewer()
				.getCachedDiagramViews()) {

			Diagram diagram = view.getDiagram();

			if (diagram.getName().equals(
					TestHelper.getProperty(NS, "test9_diagram_name"))) {
				assertEquals(diagram.getPosition().getX(), Double
						.parseDouble(TestHelper.getProperty(NS, "test9_x")));
				assertEquals(diagram.getPosition().getY(), Double
						.parseDouble(TestHelper.getProperty(NS, "test9_y")));
			}

		}

		mainFrame.dispose();

	}

	/**
	 * <p>
	 * Verify that package's name is correct after import.
	 * </p>
	 */
	public void test10() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test10_filename"), TestHelper.getProperty(NS,
				"test10_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(node.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test10_name"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's background color is correct after import.
	 * </p>
	 */
	public void test11() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test11_filename"), TestHelper.getProperty(NS,
				"test11_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(node.getBackground() == null ? Color.white : node
				.getBackground(), TestHelper.configGetCol(NS, "test11_color"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's outline color is correct after import.
	 * </p>
	 */
	public void test12() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test12_filename"), TestHelper.getProperty(NS,
				"test12_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(node.getStrokeColor(), TestHelper.configGetCol(NS,
				"test12_color"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's font is correct after import.
	 * </p>
	 */
	public void test13() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test13_filename"), TestHelper.getProperty(NS,
				"test13_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(node.getFont().getFamily(), TestHelper.getProperty(NS,
				"test13_font"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's font color is correct after import.
	 * </p>
	 */
	public void test14() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test14_filename"), TestHelper.getProperty(NS,
				"test14_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(node.getFontColor(), TestHelper.configGetCol(NS,
				"test14_fontcolor"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's font size is correct after import.
	 * </p>
	 */
	public void test15() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test15_filename"), TestHelper.getProperty(NS,
				"test15_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(Integer.toString(node.getFont().getSize()), TestHelper
				.getProperty(NS, "test15_fontsize"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's size is correct after import.
	 * </p>
	 */
	public void test16() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test16_filename"), TestHelper.getProperty(NS,
				"test16_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(Integer.toString(node.getWidth()), TestHelper.getProperty(
				NS, "test16_width"));
		assertEquals(Integer.toString(node.getHeight()), TestHelper
				.getProperty(NS, "test16_height"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's location is correct after import.
	 * </p>
	 */
	public void test17() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test17_filename"), TestHelper.getProperty(NS,
				"test17_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		assertEquals(Integer.toString(node.getX()), TestHelper.getProperty(NS,
				"test17_x"));
		assertEquals(Integer.toString(node.getY()), TestHelper.getProperty(NS,
				"test17_y"));

	}

	/**
	 * <p>
	 * Verify that package rectangle's modifiers is correct after import.
	 * </p>
	 */
	public void test18() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test18_filename"), TestHelper.getProperty(NS,
				"test18_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		ModelElement element = DeployHelper.getElement(node);

		PackageImpl pack = (PackageImpl) element;

		assertEquals(Boolean.toString(pack.isAbstract()), TestHelper
				.getProperty(NS, "test18_abstract"));
		assertEquals(Boolean.toString(pack.isRoot()), TestHelper.getProperty(
				NS, "test18_root"));
		assertEquals(Boolean.toString(pack.isLeaf()), TestHelper.getProperty(
				NS, "test18_leaf"));
	}

	/**
	 * <p>
	 * Verify that package rectangle's steretypes is correct after import.
	 * </p>
	 */
	public void test19() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test19_filename"), TestHelper.getProperty(NS,
				"test19_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		ModelElement element = DeployHelper.getElement(node);

		PackageImpl pack = (PackageImpl) element;

		assertEquals(Integer.toString(pack.getStereotypes().size()), TestHelper
				.getProperty(NS, "test19_size"));
		assertEquals(pack.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test19_name"));
	}

	/**
	 * <p>
	 * Verify that package rectangle's document is correct after import.
	 * </p>
	 */
	public void test20() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test20_filename"), TestHelper.getProperty(NS,
				"test20_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode node = getPackageNode(diagram);
		assertNotNull("There is at least a  package in diagram.", node);
		ModelElement element = DeployHelper.getElement(node);

		PackageImpl pack = (PackageImpl) element;

		assertEquals(pack.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test20_doc"));
	}

	/**
	 * <p>
	 * Verify that package rectangle's z-order is correct after import.
	 * </p>
	 */
	public void test21() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test21_filename"), TestHelper.getProperty(NS,
				"test21_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		PackageNode[] nodes = getPackageNodes(diagram);
		assertTrue("There is at least a package in diagram.", nodes.length >= 2);
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		// package2 should be above.
		assertTrue(view.getComponentZOrder(nodes[0]) < view
				.getComponentZOrder(nodes[1]));
	}

	/**
	 * <p>
	 * Verify that package is correctly displayed in the document tree after
	 * import.
	 * </p>
	 */
	public void test22() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test22_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				node = (DefaultMutableTreeNode) node.getFirstChild();
				assertEquals(node.toString(), TestHelper.getProperty(NS,
						"test22_name"));
				return;
			}
		}
		fail("There are at least a class diagram in model");
	}

	/**
	 * <p>
	 * Verify that class's name is correct after import.
	 * </p>
	 */
	public void test23() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test23_filename"), TestHelper.getProperty(NS,
				"test23_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(node.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test23_name"));

	}

	/**
	 * <p>
	 * Verify that class's namespace is correct after import.
	 * </p>
	 */
	public void test24() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test24_filename"), TestHelper.getProperty(NS,
				"test24_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);
		assertEquals(element.getNamespace().getName(), TestHelper.getProperty(
				NS, "test24_name"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's background color is correct after import.
	 * </p>
	 */
	public void test25() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test25_filename"), TestHelper.getProperty(NS,
				"test25_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(node.getBackground() == null ? Color.white : node
				.getBackground(), TestHelper.configGetCol(NS, "test25_color"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's outline color is correct after import.
	 * </p>
	 */
	public void test26() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test26_filename"), TestHelper.getProperty(NS,
				"test26_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(node.getStrokeColor(), TestHelper.configGetCol(NS,
				"test26_color"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's font is correct after import.
	 * </p>
	 */
	public void test27() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test27_filename"), TestHelper.getProperty(NS,
				"test27_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(node.getFont().getFamily(), TestHelper.getProperty(NS,
				"test27_font"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's font color is correct after import.
	 * </p>
	 */
	public void test28() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test28_filename"), TestHelper.getProperty(NS,
				"test28_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(node.getFontColor(), TestHelper.configGetCol(NS,
				"test28_fontcolor"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's font size is correct after import.
	 * </p>
	 */
	public void test29() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test29_filename"), TestHelper.getProperty(NS,
				"test29_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(Integer.toString(node.getFont().getSize()), TestHelper
				.getProperty(NS, "test29_fontsize"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's size is correct after import.
	 * </p>
	 */
	public void test30() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test30_filename"), TestHelper.getProperty(NS,
				"test30_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(Integer.toString(node.getWidth()), TestHelper.getProperty(
				NS, "test30_width"));
		assertEquals(Integer.toString(node.getHeight()), TestHelper
				.getProperty(NS, "test30_height"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's location is correct after import.
	 * </p>
	 */
	public void test31() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test31_filename"), TestHelper.getProperty(NS,
				"test31_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		assertEquals(Integer.toString(node.getX()), TestHelper.getProperty(NS,
				"test31_x"));
		assertEquals(Integer.toString(node.getY()), TestHelper.getProperty(NS,
				"test31_y"));

	}

	/**
	 * <p>
	 * Verify that class rectangle's steretypes is correct after import.
	 * </p>
	 */
	public void test32() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test32_filename"), TestHelper.getProperty(NS,
				"test32_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;

		assertEquals(Integer.toString(pack.getStereotypes().size()), TestHelper
				.getProperty(NS, "test32_size"));
		assertEquals(pack.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test32_name"));
	}

	/**
	 * <p>
	 * Verify that class rectangle's document is correct after import.
	 * </p>
	 */
	public void test33() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test33_filename"), TestHelper.getProperty(NS,
				"test33_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;

		assertEquals(pack.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test33_doc"));
	}

	/**
	 * <p>
	 * Verify that class' document tags are correct after import.
	 * </p>
	 */
	public void test34() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test34_filename"), TestHelper.getProperty(NS,
				"test34_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;
		assertEquals(pack.getTaggedValues().size(), Integer.parseInt(TestHelper
				.getProperty(NS, "test34_size")));
		Iterator<TaggedValue> it = pack.getTaggedValues().iterator();
		it.next();
		TaggedValue value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test34_name1"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test34_value1"));

		value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test34_name2"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test34_value2"));
	}

	/**
	 * <p>
	 * Verify that class' visibility tags are correct after import.
	 * </p>
	 */
	public void test35() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test35_filename"), TestHelper.getProperty(NS,
				"test35_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;
		assertEquals(pack.getVisibility().toString(), TestHelper.getProperty(
				NS, "test35_visibility"));
	}

	/**
	 * <p>
	 * Verify that class's modifiers is correct after import.
	 * </p>
	 */
	public void test36() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test36_filename"), TestHelper.getProperty(NS,
				"test36_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;

		assertEquals(Boolean.toString(pack.isAbstract()), TestHelper
				.getProperty(NS, "test36_abstract"));
		assertEquals(Boolean.toString(pack.isRoot()), TestHelper.getProperty(
				NS, "test36_root"));
		assertEquals(Boolean.toString(pack.isLeaf()), TestHelper.getProperty(
				NS, "test36_leaf"));
	}

	/**
	 * <p>
	 * Verify that class rectangle's z-order is correct after import.
	 * </p>
	 */
	public void test37() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test37_filename"), TestHelper.getProperty(NS,
				"test37_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		// class1(node[1]) should be above.
		assertTrue(view.getComponentZOrder(nodes[0]) < view
				.getComponentZOrder(nodes[1]));
	}

	/**
	 * <p>
	 * Verify that class is correctly displayed in the document tree after
	 * import.
	 * </p>
	 */
	public void test38() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test38_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				node = (DefaultMutableTreeNode) node.getFirstChild();
				assertEquals(node.toString(), TestHelper.getProperty(NS,
						"test38_name"));
				return;
			}
		}
		fail("There are at least a class diagram in model");
	}

	/**
	 * <p>
	 * Verify that class' methods is correct after import. (including the amount
	 * of methods)
	 * </p>
	 */
	public void test39() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test39_filename"), TestHelper.getProperty(NS,
				"test39_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;
		GroupTextField operations = node.getOperationsCompartment();
		assertEquals(Integer.toString(operations.getItems().size()), TestHelper
				.getProperty(NS, "test39_size"));
		assertEquals(operations.getItems().get(0).getText(), TestHelper
				.getProperty(NS, "test39_name1"));
		assertEquals(operations.getItems().get(1).getText(), TestHelper
				.getProperty(NS, "test39_name2"));

	}

	/**
	 * <p>
	 * Verify that class' attributes is correct after import. (including the
	 * amount of methods)
	 * </p>
	 */
	public void test40() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test40_filename"), TestHelper.getProperty(NS,
				"test40_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;
		GroupTextField attributes = node.getAttributesCompartment();
		assertEquals(Integer.toString(attributes.getItems().size()), TestHelper
				.getProperty(NS, "test40_size"));
		assertEquals(attributes.getItems().get(0).getText(), TestHelper
				.getProperty(NS, "test40_name1"));
		assertEquals(attributes.getItems().get(1).getText(), TestHelper
				.getProperty(NS, "test40_name2"));

	}

	/**
	 * <p>
	 * Verify that methods in the same class are in correct order when.
	 * </p>
	 */
	public void test41() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test41_filename"), TestHelper.getProperty(NS,
				"test41_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;
		GroupTextField operations = node.getOperationsCompartment();
		assertEquals(Integer.toString(operations.getItems().size()), TestHelper
				.getProperty(NS, "test41_size"));
		assertEquals(operations.getItems().get(0).getText(), TestHelper
				.getProperty(NS, "test41_name1"));
		assertEquals(operations.getItems().get(1).getText(), TestHelper
				.getProperty(NS, "test41_name2"));

	}

	/**
	 * <p>
	 * Verify that attributes in the same class are in correct order when.
	 * </p>
	 */
	public void test42() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test42_filename"), TestHelper.getProperty(NS,
				"test42_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		ClassNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		ClassImpl pack = (ClassImpl) element;

		GroupTextField attributes = node.getAttributesCompartment();
		assertEquals(Integer.toString(attributes.getItems().size()), TestHelper
				.getProperty(NS, "test42_size"));
		assertEquals(attributes.getItems().get(0).getText(), TestHelper
				.getProperty(NS, "test42_name1"));
		assertEquals(attributes.getItems().get(1).getText(), TestHelper
				.getProperty(NS, "test42_name2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method name is correct after
	 * import
	 * </p>
	 */
	public void test43() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test43_filename"), TestHelper.getProperty(NS,
				"test43_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getName(), TestHelper.getProperty(NS,
				"test43_name"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' number.)
	 * </p>
	 */
	public void test44() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test44_filename"), TestHelper.getProperty(NS,
				"test44_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Integer.toString(operation.getParameters().size()),
				TestHelper.getProperty(NS, "test44_size"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' name.)
	 * </p>
	 */
	public void test45() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test45_filename"), TestHelper.getProperty(NS,
				"test45_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getName(), TestHelper
				.getProperty(NS, "test45_name1"));
		assertEquals(operation.getParameters().get(1).getName(), TestHelper
				.getProperty(NS, "test45_name2"));
		assertEquals(operation.getParameters().get(2).getName(), TestHelper
				.getProperty(NS, "test45_name3"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' type.)
	 * </p>
	 */
	public void test46() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test46_filename"), TestHelper.getProperty(NS,
				"test46_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getType().getName(),
				TestHelper.getProperty(NS, "test46_type1"));
		assertEquals(operation.getParameters().get(1).getType().getName(),
				TestHelper.getProperty(NS, "test46_type2"));
		assertEquals(operation.getParameters().get(2).getType().getName(),
				TestHelper.getProperty(NS, "test46_type3"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' modifiers.)
	 * </p>
	 */
	public void test47() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test47_filename"), TestHelper.getProperty(NS,
				"test47_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(getTaggedValue(operation.getParameters().get(0), "final"),
				Boolean.parseBoolean(TestHelper
						.getProperty(NS, "test47_final1")));
		assertEquals(getTaggedValue(operation.getParameters().get(1), "final"),
				Boolean.parseBoolean(TestHelper
						.getProperty(NS, "test47_final2")));
		assertEquals(getTaggedValue(operation.getParameters().get(2), "final"),
				Boolean.parseBoolean(TestHelper
						.getProperty(NS, "test47_final3")));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' kind.)
	 * </p>
	 */
	public void test48() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test48_filename"), TestHelper.getProperty(NS,
				"test48_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getKind().toString(),
				TestHelper.getProperty(NS, "test48_kind1"));
		assertEquals(operation.getParameters().get(1).getKind().toString(),
				TestHelper.getProperty(NS, "test48_kind2"));
		assertEquals(operation.getParameters().get(2).getKind().toString(),
				TestHelper.getProperty(NS, "test48_kind3"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' kind.)
	 * </p>
	 */
	public void test49() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test49_filename"), TestHelper.getProperty(NS,
				"test49_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getStereotypes().size(),
				Integer.parseInt(TestHelper.getProperty(NS, "test49_size1")));
		assertEquals(operation.getParameters().get(0).getStereotypes()
				.iterator().next().getName(), TestHelper.getProperty(NS,
				"test49_name1"));
		assertEquals(operation.getParameters().get(1).getStereotypes().size(),
				Integer.parseInt(TestHelper.getProperty(NS, "test49_size2")));
		assertEquals(operation.getParameters().get(2).getStereotypes().size(),
				Integer.parseInt(TestHelper.getProperty(NS, "test49_size3")));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's parameters are correct
	 * after import. (This test case focus on the parameters' document.)
	 * </p>
	 */
	public void test50() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test50_filename"), TestHelper.getProperty(NS,
				"test50_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getTaggedValues()
				.iterator().next().getDataValue(), TestHelper.getProperty(NS,
				"test50_doc1"));
		assertEquals(operation.getParameters().get(1).getTaggedValues()
				.iterator().next().getDataValue(), TestHelper.getProperty(NS,
				"test50_doc2"));
		assertEquals(operation.getParameters().get(2).getTaggedValues()
				.iterator().next().getDataValue(), TestHelper.getProperty(NS,
				"test50_doc3"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in class) method's return is correct
	 * after import.
	 * </p>
	 */
	public void test51() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test51_filename"), TestHelper.getProperty(NS,
				"test51_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		int num = operation.getParameters().size();
		assertEquals(operation.getParameters().get(num - 1).getName(),
				TestHelper.getProperty(NS, "test51_name"));

	}

	/**
	 * <p>
	 * Verify that method's owner is correct after import.
	 * </p>
	 */
	public void test52() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test52_filename"), TestHelper.getProperty(NS,
				"test52_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getOwner().getName(), TestHelper.getProperty(NS,
				"test52_name"));

	}

	/**
	 * <p>
	 * Verify that method's visibility is correct after import.
	 * </p>
	 */
	public void test53() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test53_filename"), TestHelper.getProperty(NS,
				"test53_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getVisibility().toString(), TestHelper
				.getProperty(NS, "test53_vis"));

	}

	/**
	 * <p>
	 * Verify that method's modifiers is correct after import.
	 * </p>
	 */
	public void test54() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test54_filename"), TestHelper.getProperty(NS,
				"test54_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Boolean.toString(operation.isAbstract()), TestHelper
				.getProperty(NS, "test54_abstract"));

		assertEquals(Boolean.toString(operation.isRoot()), TestHelper
				.getProperty(NS, "test54_root"));

		assertEquals(Boolean.toString(operation.isLeaf()), TestHelper
				.getProperty(NS, "test54_leaf"));

	}

	/**
	 * <p>
	 * Verify that method's stereotypes is correct after import.
	 * </p>
	 */
	public void test55() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test55_filename"), TestHelper.getProperty(NS,
				"test55_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Integer.toString(operation.getStereotypes().size()),
				TestHelper.getProperty(NS, "test55_size"));

		assertEquals(operation.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test55_name"));

	}

	/**
	 * <p>
	 * Verify that method's document is correct after import.
	 * </p>
	 */
	public void test56() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test56_filename"), TestHelper.getProperty(NS,
				"test56_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertTrue(operation.getTaggedValues().iterator().next().getDataValue()
				.indexOf(TestHelper.getProperty(NS, "test56_doc")) >= 0);

	}

	/**
	 * <p>
	 * Verify that method's document tag is correct after import.
	 * </p>
	 */
	public void test57() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test57_filename"), TestHelper.getProperty(NS,
				"test57_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getTaggedValues().size(), Integer
				.parseInt(TestHelper.getProperty(NS, "test57_size")));
		Iterator<TaggedValue> it = operation.getTaggedValues().iterator();
		TaggedValue value = it.next();
		value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test57_name1"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test57_value1"));
	}

	/**
	 * <p>
	 * Verify that method's concurrency is correct after import.
	 * </p>
	 */
	public void test58() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test58_filename"), TestHelper.getProperty(NS,
				"test58_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in class.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getConcurrency().toString(), TestHelper
				.getProperty(NS, "test58_cc"));
	}

	/**
	 * <p>
	 * Verify that method (in class) is correctly displayed in the document tree
	 * after import.
	 * </p>
	 */
	public void test59() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test59_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		Iterator<DocumentTreePanel> iter = documentTreePanelComponent
				.getPanels().iterator();
		JTree tree = null;
		for (; iter.hasNext() && tree == null;) {
			DocumentTreeView[] views = iter.next().getAllViews();// getCurrentView().getTree();

			for (DocumentTreeView view : views) {
				if (view.getViewType().equals(
						DocumentTreeViewType.PACKAGE_CENTRIC)) {
					tree = view.getTree();
				}
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if (TestHelper.getProperty(NS, "test59_class_name").equals(
					docNode.toString())) {

				for (int j = 0; j < node.getChildCount(); j++) {
					if (TestHelper.getProperty(NS, "test59_name").equals(
							node.getChildAt(j).toString())) {
						return;
					}

				}
				fail("There are no give operation in model");
			}
		}
		fail("There are no give class node in model");
	}

	/**
	 * <p>
	 * Verify that attribute's name is correct after import.
	 * </p>
	 */
	public void test60() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test60_filename"), TestHelper.getProperty(NS,
				"test60_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getName(), TestHelper.getProperty(NS,
				"test60_name"));

	}

	/**
	 * <p>
	 * Verify that attribute's initial value is correct after import.
	 * </p>
	 */
	public void test61() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test61_filename"), TestHelper.getProperty(NS,
				"test61_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getInitialValue().getBody(), TestHelper
				.getProperty(NS, "test61_value"));

	}

	/**
	 * <p>
	 * Verify that attribute's type is correct after import.
	 * </p>
	 */
	public void test62() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test62_filename"), TestHelper.getProperty(NS,
				"test62_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getType().getName(), TestHelper.getProperty(NS,
				"test62_type"));

	}

	/**
	 * <p>
	 * Verify that attribute's changeability is correct after import.
	 * </p>
	 */
	public void test63() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test63_filename"), TestHelper.getProperty(NS,
				"test63_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getChangeability().toString(), TestHelper
				.getProperty(NS, "test63_changeability"));

	}

	/**
	 * <p>
	 * Verify that attribute's modifiers is correct after import.
	 * </p>
	 */
	public void test64() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test64_filename"), TestHelper.getProperty(NS,
				"test64_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		// static
		assertEquals(attribute.getOwnerScope(), ScopeKind.CLASSIFIER);
		assertEquals(getTaggedValue(attribute, "transient"), Boolean
				.parseBoolean(TestHelper.getProperty(NS, "test64_transient")));
	}

	/**
	 * <p>
	 * Verify that attribute's visibility is correct after import.
	 * </p>
	 */
	public void test65() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test65_filename"), TestHelper.getProperty(NS,
				"test65_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];

		assertEquals(attribute.getVisibility().toString(), TestHelper
				.getProperty(NS, "test65_vis"));
	}

	/**
	 * <p>
	 * Verify that attribute's stereotypes is correct after import.
	 * </p>
	 */
	public void test66() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test66_filename"), TestHelper.getProperty(NS,
				"test66_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];

		assertEquals(Integer.toString(attribute.getStereotypes().size()),
				TestHelper.getProperty(NS, "test66_size"));
		assertEquals(attribute.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test66_name"));
	}

	/**
	 * <p>
	 * Verify that attribute's multiplicity is correct after import.
	 * </p>
	 */
	public void test67() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test67_filename"), TestHelper.getProperty(NS,
				"test67_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getMultiplicity().getRanges().iterator().next()
				.getLower(), Integer.parseInt(TestHelper.getProperty(NS,
				"test67_mul")));
		assertEquals(attribute.getMultiplicity().getRanges().iterator().next()
				.getUpper(), Integer.parseInt(TestHelper.getProperty(NS,
				"test67_mul")));
	}

	/**
	 * <p>
	 * Verify that attribute's document is correct after import.
	 * </p>
	 */
	public void test68() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test68_filename"), TestHelper.getProperty(NS,
				"test68_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		Iterator<TaggedValue> it = attribute.getTaggedValues().iterator();
		it.next();
		it.next();
		assertTrue(it.next().getDataValue().indexOf(
				TestHelper.getProperty(NS, "test68_doc")) >= 0);
	}

	/**
	 * <p>
	 * Verify that attribute's document tag is correct after import.
	 * </p>
	 */
	public void test69() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test69_filename"), TestHelper.getProperty(NS,
				"test69_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least a  class node in diagram.",
				nodes.length > 0);
		ClassNode node = nodes[0];
		AttributeImpl[] attributes = getAttributes(node);
		assertTrue("There are at least a  operation in class.",
				attributes.length > 0);
		AttributeImpl attribute = attributes[0];
		assertEquals(attribute.getTaggedValues().iterator().next()
				.getDataValue(), TestHelper.getProperty(NS, "test69_tag"));
	}

	/**
	 * <p>
	 * Verify that attribute (in class) is correctly displayed in the document
	 * tree after import.
	 * </p>
	 */
	public void test70() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test70_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		Iterator<DocumentTreePanel> iter = documentTreePanelComponent
				.getPanels().iterator();
		JTree tree = null;
		for (; iter.hasNext() && tree == null;) {
			DocumentTreeView[] views = iter.next().getAllViews();// getCurrentView().getTree();

			for (DocumentTreeView view : views) {
				if (view.getViewType().equals(
						DocumentTreeViewType.PACKAGE_CENTRIC)) {
					tree = view.getTree();
				}
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if (TestHelper.getProperty(NS, "test70_class_name").equals(
					docNode.toString())) {

				for (int j = 0; j < node.getChildCount(); j++) {
					if (TestHelper.getProperty(NS, "test70_name").equals(
							node.getChildAt(j).toString())) {
						return;
					}

				}
				fail("There are no give operation in model");
			}
		}
		fail("There are no give class node in model");
	}

	/**
	 * <p>
	 * Verify that interface's name is correct after import.
	 * </p>
	 */
	public void test71() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test71_filename"), TestHelper.getProperty(NS,
				"test71_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(node.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test71_name"));

	}

	/**
	 * <p>
	 * Verify that interface's namespace is correct after import.
	 * </p>
	 */
	public void test72() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test72_filename"), TestHelper.getProperty(NS,
				"test72_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);
		assertEquals(element.getNamespace().getName(), TestHelper.getProperty(
				NS, "test72_name"));

	}

	/**
	 * <p>
	 * Verify that interface's background color is correct after import.
	 * </p>
	 */
	public void test73() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test73_filename"), TestHelper.getProperty(NS,
				"test73_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(node.getBackground() == null ? Color.white : node
				.getBackground(), TestHelper.configGetCol(NS, "test73_color"));

	}

	/**
	 * <p>
	 * Verify that interface's outline color is correct after import.
	 * </p>
	 */
	public void test74() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test74_filename"), TestHelper.getProperty(NS,
				"test74_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(node.getStrokeColor(), TestHelper.configGetCol(NS,
				"test74_color"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's font is correct after import.
	 * </p>
	 */
	public void test75() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test75_filename"), TestHelper.getProperty(NS,
				"test75_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(node.getFont().getFamily(), TestHelper.getProperty(NS,
				"test75_font"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's font color is correct after import.
	 * </p>
	 */
	public void test76() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test76_filename"), TestHelper.getProperty(NS,
				"test76_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(node.getFontColor(), TestHelper.configGetCol(NS,
				"test76_fontcolor"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's font size is correct after import.
	 * </p>
	 */
	public void test77() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test77_filename"), TestHelper.getProperty(NS,
				"test77_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(Integer.toString(node.getFont().getSize()), TestHelper
				.getProperty(NS, "test77_fontsize"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's size is correct after import.
	 * </p>
	 */
	public void test78() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test78_filename"), TestHelper.getProperty(NS,
				"test78_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(Integer.toString(node.getWidth()), TestHelper.getProperty(
				NS, "test78_width"));
		assertEquals(Integer.toString(node.getHeight()), TestHelper
				.getProperty(NS, "test78_height"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's location is correct after import.
	 * </p>
	 */
	public void test79() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test79_filename"), TestHelper.getProperty(NS,
				"test79_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		assertEquals(Integer.toString(node.getX()), TestHelper.getProperty(NS,
				"test79_x"));
		assertEquals(Integer.toString(node.getY()), TestHelper.getProperty(NS,
				"test79_y"));

	}

	/**
	 * <p>
	 * Verify that interface rectangle's steretypes is correct after import.
	 * </p>
	 */
	public void test80() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test80_filename"), TestHelper.getProperty(NS,
				"test80_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;

		assertEquals(Integer.toString(pack.getStereotypes().size()), TestHelper
				.getProperty(NS, "test80_size"));
		assertEquals(pack.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test80_name"));
	}

	/**
	 * <p>
	 * Verify that interface rectangle's document is correct after import.
	 * </p>
	 */
	public void test81() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test81_filename"), TestHelper.getProperty(NS,
				"test81_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;

		assertEquals(pack.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test81_doc"));
	}

	/**
	 * <p>
	 * Verify that interface document tags are correct after import.
	 * </p>
	 */
	public void test82() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test82_filename"), TestHelper.getProperty(NS,
				"test82_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;
		assertEquals(pack.getTaggedValues().size(), Integer.parseInt(TestHelper
				.getProperty(NS, "test34_size")));
		Iterator<TaggedValue> it = pack.getTaggedValues().iterator();
		it.next();
		TaggedValue value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test82_name1"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test82_value1"));

		value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test82_name2"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test82_value2"));
	}

	/**
	 * <p>
	 * Verify that interface visibility tags are correct after import.
	 * </p>
	 */
	public void test83() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test83_filename"), TestHelper.getProperty(NS,
				"test83_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;
		assertEquals(pack.getVisibility().toString(), TestHelper.getProperty(
				NS, "test83_visibility"));
	}

	/**
	 * <p>
	 * Verify that interface's modifiers is correct after import.
	 * </p>
	 */
	public void test84() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test84_filename"), TestHelper.getProperty(NS,
				"test84_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;

		assertEquals(Boolean.toString(pack.isAbstract()), TestHelper
				.getProperty(NS, "test84_abstract"));
		assertEquals(Boolean.toString(pack.isRoot()), TestHelper.getProperty(
				NS, "test84_root"));
		assertEquals(Boolean.toString(pack.isLeaf()), TestHelper.getProperty(
				NS, "test84_leaf"));
	}

	/**
	 * <p>
	 * Verify that interface rectangle's z-order is correct after import.
	 * </p>
	 */
	public void test85() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test85_filename"), TestHelper.getProperty(NS,
				"test85_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		ClassNode[] nodes = getClassNodes(diagram);

		assertTrue("There are at least two  classes in diagram.",
				nodes.length > 1);
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);
		// interface1(node[1]) should be above.
		assertTrue(view.getComponentZOrder(nodes[0]) < view
				.getComponentZOrder(nodes[1]));
	}

	/**
	 * <p>
	 * Verify that interface is correctly displayed in the document tree after
	 * import.
	 * </p>
	 */
	public void test86() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test86_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				node = (DefaultMutableTreeNode) node.getFirstChild();
				assertEquals(node.toString(), TestHelper.getProperty(NS,
						"test86_name"));
				return;
			}
		}
		fail("There are at least a class diagram in model");
	}

	/**
	 * <p>
	 * Verify that interface' methods is correct after import. (including the
	 * amount of methods)
	 * </p>
	 */
	public void test87() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test87_filename"), TestHelper.getProperty(NS,
				"test87_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;
		GroupTextField operations = node.getOperationsCompartment();
		assertEquals(Integer.toString(operations.getItems().size()), TestHelper
				.getProperty(NS, "test87_size"));

	}

	/**
	 * <p>
	 * Verify that methods in the same interface are in correct order when.
	 * </p>
	 */
	public void test88() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test88_filename"), TestHelper.getProperty(NS,
				"test88_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		ModelElement element = DeployHelper.getElement(node);

		InterfaceImpl pack = (InterfaceImpl) element;
		GroupTextField operations = node.getOperationsCompartment();
		assertEquals(Integer.toString(operations.getItems().size()), TestHelper
				.getProperty(NS, "test88_size"));
		assertEquals(operations.getItems().get(0).getText(), TestHelper
				.getProperty(NS, "test88_name1"));
		assertEquals(operations.getItems().get(1).getText(), TestHelper
				.getProperty(NS, "test88_name2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method name is correct
	 * after import
	 * </p>
	 */
	public void test89() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test89_filename"), TestHelper.getProperty(NS,
				"test89_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getName(), TestHelper.getProperty(NS,
				"test89_name"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' number.)
	 * </p>
	 */
	public void test90() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test90_filename"), TestHelper.getProperty(NS,
				"test90_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Integer.toString(operation.getParameters().size()),
				TestHelper.getProperty(NS, "test90_size"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' name.)
	 * </p>
	 */
	public void test91() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test91_filename"), TestHelper.getProperty(NS,
				"test91_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getName(), TestHelper
				.getProperty(NS, "test91_name1"));
		assertEquals(operation.getParameters().get(1).getName(), TestHelper
				.getProperty(NS, "test91_name2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' type.)
	 * </p>
	 */
	public void test92() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test92_filename"), TestHelper.getProperty(NS,
				"test92_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getType().getName(),
				TestHelper.getProperty(NS, "test92_type1"));
		assertEquals(operation.getParameters().get(1).getType().getName(),
				TestHelper.getProperty(NS, "test92_type2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters'
	 * modifiers.)
	 * </p>
	 */
	public void test93() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test93_filename"), TestHelper.getProperty(NS,
				"test93_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(getTaggedValue(operation.getParameters().get(0), "final"),
				Boolean.parseBoolean(TestHelper
						.getProperty(NS, "test93_final1")));
		assertEquals(getTaggedValue(operation.getParameters().get(1), "final"),
				Boolean.parseBoolean(TestHelper
						.getProperty(NS, "test93_final2")));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' kind.)
	 * </p>
	 */
	public void test94() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test94_filename"), TestHelper.getProperty(NS,
				"test94_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getKind().toString(),
				TestHelper.getProperty(NS, "test94_kind1"));
		assertEquals(operation.getParameters().get(1).getKind().toString(),
				TestHelper.getProperty(NS, "test94_kind2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' kind.)
	 * </p>
	 */
	public void test95() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test95_filename"), TestHelper.getProperty(NS,
				"test95_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getStereotypes().size(),
				Integer.parseInt(TestHelper.getProperty(NS, "test95_size1")));
		assertEquals(operation.getParameters().get(0).getStereotypes()
				.iterator().next().getName(), TestHelper.getProperty(NS,
				"test95_name1"));
		assertEquals(operation.getParameters().get(1).getStereotypes().size(),
				Integer.parseInt(TestHelper.getProperty(NS, "test95_size2")));
		;

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's parameters are
	 * correct after import. (This test case focus on the parameters' document.)
	 * </p>
	 */
	public void test96() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test96_filename"), TestHelper.getProperty(NS,
				"test96_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getParameters().get(0).getTaggedValues()
				.iterator().next().getDataValue(), TestHelper.getProperty(NS,
				"test96_doc1"));
		assertEquals(operation.getParameters().get(1).getTaggedValues()
				.iterator().next().getDataValue(), TestHelper.getProperty(NS,
				"test96_doc2"));

	}

	/**
	 * <p>
	 * Verify that (a method signature in interface) method's return is correct
	 * after import.
	 * </p>
	 */
	public void test97() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test97_filename"), TestHelper.getProperty(NS,
				"test97_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		int num = operation.getParameters().size();
		assertEquals(operation.getParameters().get(num - 1).getName(),
				TestHelper.getProperty(NS, "test97_name"));

	}

	/**
	 * <p>
	 * Verify that method's owner is correct after import.
	 * </p>
	 */
	public void test98() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test98_filename"), TestHelper.getProperty(NS,
				"test98_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertNotNull("The operation has owner",operation.getOwner());
		assertEquals(operation.getOwner().getName(), TestHelper.getProperty(NS,
				"test98_name"));

	}

	/**
	 * <p>
	 * Verify that method's visibility is correct after import.
	 * </p>
	 */
	public void test99() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test99_filename"), TestHelper.getProperty(NS,
				"test99_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getVisibility().toString(), TestHelper
				.getProperty(NS, "test99_vis"));

	}

	/**
	 * <p>
	 * Verify that method's modifiers is correct after import.
	 * </p>
	 */
	public void test100() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test100_filename"), TestHelper.getProperty(NS,
				"test100_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Boolean.toString(operation.isAbstract()), TestHelper
				.getProperty(NS, "test100_abstract"));

		assertEquals(Boolean.toString(operation.isRoot()), TestHelper
				.getProperty(NS, "test100_root"));

		assertEquals(Boolean.toString(operation.isLeaf()), TestHelper
				.getProperty(NS, "test100_leaf"));

	}

	/**
	 * <p>
	 * Verify that method's stereotypes is correct after import.
	 * </p>
	 */
	public void test101() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test101_filename"), TestHelper.getProperty(NS,
				"test101_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(Integer.toString(operation.getStereotypes().size()),
				TestHelper.getProperty(NS, "test101_size"));

		assertEquals(operation.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test101_name"));

	}

	/**
	 * <p>
	 * Verify that method's document is correct after import.
	 * </p>
	 */
	public void test102() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test102_filename"), TestHelper.getProperty(NS,
				"test102_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertTrue(operation.getTaggedValues().iterator().next().getDataValue()
				.indexOf(TestHelper.getProperty(NS, "test102_doc")) >= 0);

	}

	/**
	 * <p>
	 * Verify that method's document tag is correct after import.
	 * </p>
	 */
	public void test103() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test103_filename"), TestHelper.getProperty(NS,
				"test103_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getTaggedValues().size(), Integer
				.parseInt(TestHelper.getProperty(NS, "test57_size")));
		Iterator<TaggedValue> it = operation.getTaggedValues().iterator();
		TaggedValue value = it.next();
		value = it.next();
		assertEquals(value.getType().getName(), TestHelper.getProperty(NS,
				"test103_name1"));
		assertEquals(value.getDataValue(), TestHelper.getProperty(NS,
				"test103_value1"));
	}

	/**
	 * <p>
	 * Verify that method's concurrency is correct after import.
	 * </p>
	 */
	public void test104() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
				"test104_filename"), TestHelper.getProperty(NS,
				"test104_diagram_name"));

		assertNotNull("There is a given name class diagram in file.", diagram);

		InterfaceNode[] nodes = getInterfaceNodes(diagram);

		assertTrue("There are at least two  interfaces in diagram.",
				nodes.length > 1);
		InterfaceNode node = nodes[1];
		OperationImpl[] operations = getOperations(node);
		assertTrue("There are at least a  operation in interface.",
				operations.length > 0);
		OperationImpl operation = operations[0];
		assertEquals(operation.getConcurrency().toString(), TestHelper
				.getProperty(NS, "test104_cc"));
	}

	/**
	 * <p>
	 * Verify that method (in interface) is correctly displayed in the document
	 * tree after import.
	 * </p>
	 */
	public void test105() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test105_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		Iterator<DocumentTreePanel> iter = documentTreePanelComponent
				.getPanels().iterator();
		JTree tree = null;
		for (; iter.hasNext() && tree == null;) {
			DocumentTreeView[] views = iter.next().getAllViews();// getCurrentView().getTree();

			for (DocumentTreeView view : views) {
				if (view.getViewType().equals(
						DocumentTreeViewType.PACKAGE_CENTRIC)) {
					tree = view.getTree();
				}
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if (TestHelper.getProperty(NS, "test105_interface_name").equals(
					docNode.toString())) {

				for (int j = 0; j < node.getChildCount(); j++) {
					if (TestHelper.getProperty(NS, "test105_name").equals(
							node.getChildAt(j).toString())) {
						return;
					}

				}
				fail("There are no give operation in model");
			}
		}
		fail("There are no give interface node in model");
	}
	
	/**
	 * <p>
	 * Verify that actor's name is correct after import.
	 * </p>
	 */
	public void test106() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test106_filename"), TestHelper.getProperty(NS,
		"test106_diagram_name"));

assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test106_name"));

	}

	/**
	 * <p>
	 * Verify that actor's namespace is correct after import.
	 * </p>
	 */
	public void test107() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test107_filename"), TestHelper.getProperty(NS,
		"test107_diagram_name"));
		
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getNamespaceCompartment().getText(), TestHelper
				.getProperty(NS, "test107_ns"));

	}

	/**
	 * <p>
	 * Verify that actor's background color is correct after import.
	 * </p>
	 */
	public void test108() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test108_filename"), TestHelper.getProperty(NS,
		"test108_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getBackground() == null ? Color.white : node
				.getBackground(), TestHelper.configGetCol(NS, "test108_color"));

	}

	/**
	 * <p>
	 * Verify that actor's outline color is correct after import.
	 * </p>
	 */
	public void test109() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test109_filename"), TestHelper.getProperty(NS,
		"test109_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getStrokeColor(), TestHelper.configGetCol(NS,
				"test109_color"));

	}
	
	/**
	 * <p>
	 * Verify that actor's font is correct after import.
	 * </p>
	 */
	public void test110() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test110_filename"), TestHelper.getProperty(NS,
		"test110_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getFont().getFamily(), TestHelper.getProperty(NS,
				"test110_font"));

	}

	/**
	 * <p>
	 * Verify that actor's text color is correct after import.
	 * </p>
	 */
	public void test111() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test111_filename"), TestHelper.getProperty(NS,
		"test111_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(node.getFontColor(), TestHelper.configGetCol(NS,
				"test111_color"));

	}

	/**
	 * <p>
	 * Verify that actor's font size is correct after import.
	 * </p>
	 */
	public void test112() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test112_filename"), TestHelper.getProperty(NS,
		"test112_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(Integer.toString(node.getFont().getSize()), TestHelper
				.getProperty(NS, "test112_size"));

	}

	/**
	 * <p>
	 * Verify that actor's size is correct after import.
	 * </p>
	 */
	public void test113() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test113_filename"), TestHelper.getProperty(NS,
		"test113_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(Integer.toString(node.getWidth()), TestHelper.getProperty(
				NS, "test113_width"));
		assertEquals(Integer.toString(node.getHeight()), TestHelper
				.getProperty(NS, "test113_height"));

	}

	/**
	 * <p>
	 * Verify that actor's location is correct after import.
	 * </p>
	 */
	public void test114() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test114_filename"), TestHelper.getProperty(NS,
		"test114_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		assertEquals(Integer.toString(node.getX()), TestHelper.getProperty(NS,
				"test114_x"));
		assertEquals(Integer.toString(node.getX()), TestHelper.getProperty(NS,
				"test114_y"));

	}
	/**
	 * <p>
	 * Verify that actor's steretypes is correct after import.
	 * </p>
	 */
	public void test115() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test115_filename"), TestHelper.getProperty(NS,
		"test115_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];

		ModelElement element = DeployHelper.getElement(node);

		ActorImpl system = (ActorImpl) element;
		assertEquals(Integer.toString(system.getStereotypes().size()),
				TestHelper.getProperty(NS, "test115_size"));

		assertEquals(system.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test115_name"));
	}

	/**
	 * <p>
	 * Verify that actor's document is correct after import.
	 * </p>
	 */
	public void test116() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test116_filename"), TestHelper.getProperty(NS,
		"test116_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];

		ModelElement element = DeployHelper.getElement(node);

		ActorImpl system = (ActorImpl) element;
		assertEquals(system.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test116_doc"));

	}
	/**
	 * <p>
	 * Verify that actor's visibility is correct after import.
	 * </p>
	 */
	public void test117() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test117_filename"), TestHelper.getProperty(NS,
		"test117_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];

		ModelElement element = DeployHelper.getElement(node);

		ActorImpl system = (ActorImpl) element;
		assertEquals(system.getVisibility().toString(), TestHelper.getProperty(
				NS, "test117_visibility"));
	}
	/**
	 * <p>
	 * Verify that actor's modifiers is correct after import.
	 * </p>
	 */
	public void test118() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test118_filename"), TestHelper.getProperty(NS,
		"test118_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];

		ModelElement element = DeployHelper.getElement(node);

		ActorImpl system = (ActorImpl) element;
		assertEquals(Boolean.toString(system.isAbstract()), TestHelper
				.getProperty(NS, "test118_abstract"));
		assertEquals(Boolean.toString(system.isRoot()), TestHelper.getProperty(
				NS, "test118_root"));
		assertEquals(Boolean.toString(system.isLeaf()), TestHelper.getProperty(
				NS, "test118_leaf"));

	}

	/**
	 * <p>
	 * Verify that actor's z-order is correct after import.
	 * </p>
	 */
	public void test119() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test119_filename"), TestHelper.getProperty(NS,
		"test119_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		ActorNode[] nodes = getActorNodes(diagram);

		assertTrue("There are at least two  actor's in diagram.",
				nodes.length > 1);
		ActorNode node = nodes[1];
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		assertTrue(view.getComponentZOrder(nodes[0]) > view
				.getComponentZOrder(nodes[1]));

	}

	/**
	 * <p>
	 * Verify that actor is correctly displayed in the document tree after
	 * import.
	 * </p>
	 */
	public void test120() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test120_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				// assertEquals(node.toString(), "Add_Entry_Sequence_Diagram");
				node = (DefaultMutableTreeNode) node.getFirstChild();
				assertEquals(node.toString(), TestHelper.getProperty(NS,
						"test120_name"));
				return;
			}
		}
		fail("There are at least a class diagram in model");

	}
	
	/**
	 * <p>
	 * Verify that generalization's name is correct after import.
	 * </p>
	 */
	public void test121() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test121_filename"), TestHelper.getProperty(NS,
		"test121_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		assertEquals(edge.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test121_name"));

	}

	/**
	 * <p>
	 * Verify that generalization's start point is correct after import.
	 * </p>
	 */
	public void test122() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test122_filename"), TestHelper.getProperty(NS,
		"test122_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		SelectionCorner start = edge.getWayPoints().get(0);
		assertEquals(start.getCenter().getX(), Double.parseDouble(TestHelper
				.getProperty(NS, "test122_x")));
		assertEquals(start.getCenter().getY(), Double.parseDouble(TestHelper
				.getProperty(NS, "test122_y")));

	}

	/**
	 * <p>
	 * Verify that generalization's endpoint is correct after import.
	 * </p>
	 */
	public void test123() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test123_filename"), TestHelper.getProperty(NS,
		"test123_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		SelectionCorner end = edge.getWayPoints().get(
				edge.getWayPoints().size() - 1);

		assertEquals(end.getCenter().getX(), Double.parseDouble(TestHelper
				.getProperty(NS, "test123_x")));
		assertEquals(end.getCenter().getY(), Double.parseDouble(TestHelper
				.getProperty(NS, "test123_y")));

	}

	/**
	 * <p>
	 * Verify that generalization's namespace is correct after import.
	 * </p>
	 */
	public void test124() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test124_filename"), TestHelper.getProperty(NS,
		"test124_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(element.getNamespace().getName(), TestHelper.getProperty(
				NS, "test124_ns"));

	}

	/**
	 * <p>
	 * Verify that generalization's steretypes is correct after import.
	 * </p>
	 */
	public void test125() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test125_filename"), TestHelper.getProperty(NS,
		"test125_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(Integer.toString(element.getStereotypes().size()),
				TestHelper.getProperty(NS, "test125_size"));
		assertEquals(element.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test125_name"));

	}

	/**
	 * <p>
	 * Verify that generalization's doc is correct after import.
	 * </p>
	 */
	public void test126() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test126_filename"), TestHelper.getProperty(NS,
		"test126_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(
				element.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test126_doc"));

	}

	/**
	 * <p>
	 * Verify that generalization's outline color is correct after import.
	 * </p>
	 */
	public void test127() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test127_filename"), TestHelper.getProperty(NS,
		"test127_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		Field field = Edge.class.getDeclaredField("strokeColor");
		field.setAccessible(true);
		assertEquals(field.get(edge), TestHelper.configGetCol(NS,
				"test127_color"));
		field.setAccessible(false);

	}

	/**
	 * <p>
	 * Verify that generalization's font is correct after import.
	 * </p>
	 */
	public void test128() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test128_filename"), TestHelper.getProperty(NS,
		"test128_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		assertEquals(edge.getNameCompartment().getFont().getFamily(),
				TestHelper.getProperty(NS, "test128_font"));

	}

	/**
	 * <p>
	 * Verify that generalization's text color is correct after import.
	 * </p>
	 */
	public void test129() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test129_filename"), TestHelper.getProperty(NS,
		"test129_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		assertEquals(edge.getNameCompartment().getFontColor(), TestHelper
				.configGetCol(NS, "test129_color"));

	}

	/**
	 * <p>
	 * Verify that generalization's font size is correct after import.
	 * </p>
	 */
	public void test130() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test130_filename"), TestHelper.getProperty(NS,
		"test130_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		GeneralizationEdge edge = edges[0];
		assertEquals(Integer.toString(edge.getNameCompartment().getFont()
				.getSize()), TestHelper.getProperty(NS, "test130_size"));

	}

	/**
	 * <p>
	 * Verify that generalization's z-order is correct after import.
	 * </p>
	 */
	public void test131() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test131_filename"), TestHelper.getProperty(NS,
		"test131_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		GeneralizationEdge[] edges = getGeneralizations(diagram);

		assertTrue("There are at least two  generalization edges in diagram.",
				edges.length > 1);
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		assertTrue(view.getComponentZOrder(edges[0]) > view
				.getComponentZOrder(edges[1]));

	}

	/**
	 * <p>
	 * Verify that generalization is correctly displayed in the document tree
	 * after import.
	 * </p>
	 */
	public void test132() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test132_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		// documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();// getCurrentView().getTree();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();
				
				for (int j = 0; j < node.getChildCount(); j++) {

					if (TestHelper.getProperty(NS, "test132_name").equals(
							node.getChildAt(j).toString())) {
						return;
					}
				}
				fail("There should be a generalization edge with the given name.");
			}
		}
		fail("There are at least a class diagram in model");

	}
	
	/**
	 * <p>
	 * Return the all Generalization Edges in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given sequence diagram
	 * @return all Generalization edge in diagram or emptry array if not found
	 * @throws Exception
	 *             to junit
	 */
	private GeneralizationEdge[] getGeneralizations(Diagram diagram)
			throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();

		List<GeneralizationEdge> ret = new ArrayList<GeneralizationEdge>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphEdge) {
				Edge edge = TestHelper.createEdge((GraphEdge) diagramElement,
						view, true);

				if (edge instanceof GeneralizationEdge) {
					GeneralizationEdge sEdge = (GeneralizationEdge) edge;

					ret.add(sEdge);
				}
			}

		}
		return ret.toArray(new GeneralizationEdge[ret.size()]);
	}
	/**
	 * <p>
	 * Verify that dependency's name is correct after import.
	 * </p>
	 */
	public void test133() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test133_filename"), TestHelper.getProperty(NS,
		"test133_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		assertEquals(edge.getNameCompartment().getText(), TestHelper
				.getProperty(NS, "test133_name"));

	}

	/**
	 * <p>
	 * Verify that dependency's start point is correct after import.
	 * </p>
	 */
	public void test134() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test134_filename"), TestHelper.getProperty(NS,
		"test134_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		SelectionCorner start = edge.getWayPoints().get(0);
		assertEquals(start.getCenter().getX(), Double.parseDouble(TestHelper
				.getProperty(NS, "test134_x")));
		assertEquals(start.getCenter().getY(), Double.parseDouble(TestHelper
				.getProperty(NS, "test134_y")));

	}

	/**
	 * <p>
	 * Verify that dependency's endpoint is correct after import.
	 * </p>
	 */
	public void test135() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test135_filename"), TestHelper.getProperty(NS,
		"test135_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		SelectionCorner end = edge.getWayPoints().get(
				edge.getWayPoints().size() - 1);

		assertEquals(end.getCenter().getX(), Double.parseDouble(TestHelper
				.getProperty(NS, "test135_x")));
		assertEquals(end.getCenter().getY(), Double.parseDouble(TestHelper
				.getProperty(NS, "test135_y")));

	}

	/**
	 * <p>
	 * Verify that dependency's namespace is correct after import.
	 * </p>
	 */
	public void test136() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test136_filename"), TestHelper.getProperty(NS,
		"test136_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(element.getNamespace().getName(), TestHelper.getProperty(
				NS, "test136_ns"));

	}

	/**
	 * <p>
	 * Verify that dependency's steretypes is correct after import.
	 * </p>
	 */
	public void test137() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test137_filename"), TestHelper.getProperty(NS,
		"test137_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(Integer.toString(element.getStereotypes().size()),
				TestHelper.getProperty(NS, "test137_size"));
		assertEquals(element.getStereotypes().iterator().next().getName(),
				TestHelper.getProperty(NS, "test137_name"));

	}

	/**
	 * <p>
	 * Verify that dependency's doc is correct after import.
	 * </p>
	 */
	public void test138() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test138_filename"), TestHelper.getProperty(NS,
		"test138_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		ModelElement element = DeployHelper.getElement(edge);

		assertEquals(
				element.getTaggedValues().iterator().next().getDataValue(),
				TestHelper.getProperty(NS, "test138_doc"));

	}

	/**
	 * <p>
	 * Verify that dependency's outline color is correct after import.
	 * </p>
	 */
	public void test139() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test139_filename"), TestHelper.getProperty(NS,
		"test139_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		Field field = Edge.class.getDeclaredField("strokeColor");
		field.setAccessible(true);
		assertEquals(field.get(edge), TestHelper.configGetCol(NS,
				"test139_color"));
		field.setAccessible(false);

	}

	/**
	 * <p>
	 * Verify that dependency's font is correct after import.
	 * </p>
	 */
	public void test140() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test140_filename"), TestHelper.getProperty(NS,
		"test140_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		assertNotNull("edge font can not be null",edge.getNameCompartment().getFont());
		assertEquals(edge.getNameCompartment().getFont().getFamily(),
				TestHelper.getProperty(NS, "test140_font"));

	}

	/**
	 * <p>
	 * Verify that dependency's text color is correct after import.
	 * </p>
	 */
	public void test141() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test141_filename"), TestHelper.getProperty(NS,
		"test141_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		assertEquals(edge.getNameCompartment().getFontColor(), TestHelper
				.configGetCol(NS, "test141_color"));

	}

	/**
	 * <p>
	 * Verify that dependency's font size is correct after import.
	 * </p>
	 */
	public void test142() throws Exception {
		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test142_filename"), TestHelper.getProperty(NS,
		"test142_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DependencyEdge edge = edges[0];
		assertNotNull("edge font can not be null",edge.getNameCompartment().getFont());
		assertEquals(Integer.toString(edge.getNameCompartment().getFont()
				.getSize()), TestHelper.getProperty(NS, "test142_size"));

	}

	/**
	 * <p>
	 * Verify that dependency's z-order is correct after import.
	 * </p>
	 */
	public void test143() throws Exception {

		Diagram diagram = getClassDiagram(TestHelper.getProperty(NS,
		"test143_filename"), TestHelper.getProperty(NS,
		"test143_diagram_name"));
		assertNotNull("There is a given name class diagram in file.", diagram);

		DependencyEdge[] edges = getDependencyEdges(diagram);

		assertTrue("There are at least two  dependency edges in diagram.",
				edges.length > 1);
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		assertTrue(view.getComponentZOrder(edges[0]) > view
				.getComponentZOrder(edges[1]));

	}

	/**
	 * <p>
	 * Verify that dependency is correctly displayed in the document tree after
	 * import.
	 * </p>
	 */
	public void test144() throws Exception {

		File file = new File(TestHelper.getProperty(NS, "test144_filename"));

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		documentTreePanelComponent.updateTree();
		// documentTreePanelComponent.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
		DocumentTreeView[] views = documentTreePanelComponent.getCurrentPanel()
				.getAllViews();// getCurrentView().getTree();
		JTree tree = null;
		for (DocumentTreeView view : views) {
			if (view.getViewType().equals(DocumentTreeViewType.DIAGRAM_CENTRIC)) {
				tree = view.getTree();
			}
		}
		TreeModel model = tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);

			DocumentTreeNode docNode = (DocumentTreeNode) node.getUserObject();

			if ("Class Diagram".equals(docNode.toString())) {
				node = (DefaultMutableTreeNode) node.getFirstChild();

				for (int j = 0; j < node.getChildCount(); j++) {

					if (TestHelper.getProperty(NS, "test144_name").equals(
							node.getChildAt(j).toString())) {
						return;
					}
				}
				fail("There should be a dependency edge with the given name.");
			}
		}
		fail("There are at least a class diagram in model");

	}
	
	/**
	 * <p>
	 * Return the all DependencyEdges in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given sequence diagram
	 * @return all DependencyEdge in diagram or emptry array if not found
	 * @throws Exception
	 *             to junit
	 */
	private DependencyEdge[] getDependencyEdges(Diagram diagram)
			throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();

		List<DependencyEdge> ret = new ArrayList<DependencyEdge>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphEdge) {
				Edge edge = TestHelper.createEdge((GraphEdge) diagramElement,
						view, true);

				if (edge instanceof DependencyEdge) {
					DependencyEdge sEdge = (DependencyEdge) edge;

					ret.add(sEdge);
				}
			}

		}
		return ret.toArray(new DependencyEdge[ret.size()]);
	}


	/**
	 * <p>
	 * This method checks whether a given model element has a
	 * <code>TaggedValue</code> with the given <code>type</code> name and
	 * its value is <b>true</b>.
	 * </p>
	 * 
	 * @param element
	 *            the model element
	 * @param type
	 *            the tag type
	 * 
	 * @return true if the <code>TaggedValue</code> can be found, false
	 *         otherwise
	 */
	private boolean getTaggedValue(ModelElement element, String type) {
		for (TaggedValue taggedValue : element.getTaggedValues()) {
			TagDefinition tagDefinition = taggedValue.getType();
			if (type.equals(tagDefinition.getTagType())) {
				// The TaggedValue is found
				if ("true".equals(taggedValue.getDataValue())) {
					return true;
				}

			}
		}

		// The TaggedValue is not found
		return false;
	}
	/**
	 * <p>
	 * Return the all ActorNodes in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given sequence diagram
	 * @return the array contains all ActorNodes in diagram or a empty array if
	 *         not found
	 * @throws Exception
	 *             to junit
	 */
	private ActorNode[] getActorNodes(Diagram diagram) throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();
		List<ActorNode> ret = new ArrayList<ActorNode>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				Node node = TestHelper.createNode(diagramElement, view, true);
				if (node instanceof ActorNode) {
					ret.add((ActorNode) node);
				}
			}

		}
		return ret.toArray(new ActorNode[ret.size()]);
	}

	/**
	 * <p>
	 * Return the given name class diagram in the umlfile.
	 * </p>
	 * 
	 * @param umlfilename
	 *            the uml file name
	 * @param name
	 *            the diagram name
	 * @return the first class diagram in the uml file or null if no class
	 *         diagram
	 * @throws Exception
	 *             to junit
	 */
	private Diagram getClassDiagram(String umlfilename, String name)
			throws Exception {
		File file = new File(umlfilename);

		DeployHelper.loadPoseidonFile(file, umlModelManager,
				projectConfigurationManager, false);

		List<Diagram> diagramlists = umlModelManager.getDiagrams();
		for (int i = 0; i < diagramlists.size(); i++) {
			Diagram diagram = diagramlists.get(i);
			if ("ClassDiagram".equals(DeployHelper.getTypeInfo(diagram))
					&& diagram.getName().equals(name)) {

				return diagram;

			}
		}
		return null;
	}

	/**
	 * <p>
	 * Return the first PackageNode in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given class diagram
	 * @return the first PackageNode in diagram or null if not found
	 * @throws Exception
	 *             to junit
	 */
	private PackageNode getPackageNode(Diagram diagram) throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();

		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				Node node = TestHelper.createNode(diagramElement, view, true);
				if (node instanceof PackageNode) {
					return (PackageNode) node;
				}
			}

		}
		return null;
	}

	/**
	 * <p>
	 * Return the all PackageNodes in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given class diagram
	 * @return the array contains all PackageNodes in diagram or a empty array
	 *         if not found
	 * @throws Exception
	 *             to junit
	 */
	private PackageNode[] getPackageNodes(Diagram diagram) throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();
		List<PackageNode> ret = new ArrayList<PackageNode>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				Node node = TestHelper.createNode(diagramElement, view, true);
				if (node instanceof PackageNode) {
					ret.add((PackageNode) node);
				}
			}

		}
		return ret.toArray(new PackageNode[ret.size()]);
	}

	/**
	 * <p>
	 * Return the all InterfaceNodes in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given class diagram
	 * @return the array contains all InterfaceNodes in diagram or a empty array
	 *         if not found
	 * @throws Exception
	 *             to junit
	 */
	private InterfaceNode[] getInterfaceNodes(Diagram diagram) throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();
		List<InterfaceNode> ret = new ArrayList<InterfaceNode>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				Node node = TestHelper.createNode(diagramElement, view, true);

				if (node instanceof InterfaceNode) {
					ret.add((InterfaceNode) node);
				}
			}

		}
		return ret.toArray(new InterfaceNode[ret.size()]);
	}

	/**
	 * <p>
	 * Return the all ClassNodes in the diagram.
	 * </p>
	 * 
	 * @param diagram
	 *            the given class diagram
	 * @return the array contains all ClassNodes in diagram or a empty array if
	 *         not found
	 * @throws Exception
	 *             to junit
	 */
	private ClassNode[] getClassNodes(Diagram diagram) throws Exception {
		DiagramView view = diagramViewerComponent.createDiagramView(diagram);

		List<DiagramElement> list = diagram.getContaineds();
		List<ClassNode> ret = new ArrayList<ClassNode>();
		for (int j = 0; j < list.size(); j++) {
			DiagramElement diagramElement = list.get(j);
			if (diagramElement instanceof GraphNode
					|| diagramElement instanceof Polyline) {
				Node node = TestHelper.createNode(diagramElement, view, true);
				if (node instanceof ClassNode) {
					ret.add((ClassNode) node);
				}
			}

		}
		return ret.toArray(new ClassNode[ret.size()]);
	}

	/**
	 * <p>
	 * Return the all operations in the class.
	 * </p>
	 * 
	 * @param node
	 *            the given class node
	 * @return the array contains all operations of class or a empty array if
	 *         not found
	 * @throws Exception
	 *             to junit
	 */
	private OperationImpl[] getOperations(BaseNode node) throws Exception {
		GroupTextField fields = node.getOperationsCompartment();
		List<OperationImpl> ret = new ArrayList<OperationImpl>();
		for (StereotypeTextField field : fields.getItems()) {
			ModelElement element = DeployHelper
					.getElement(field.getGraphNode());

			ret.add((OperationImpl) element);
		}

		return ret.toArray(new OperationImpl[ret.size()]);
	}

	/**
	 * <p>
	 * Return the all attributes in the class.
	 * </p>
	 * 
	 * @param node
	 *            the given class node
	 * @return the array contains all attributes of class or a empty array if
	 *         not found
	 * @throws Exception
	 *             to junit
	 */
	private AttributeImpl[] getAttributes(BaseNode node) throws Exception {
		GroupTextField fields = node.getAttributesCompartment();
		List<AttributeImpl> ret = new ArrayList<AttributeImpl>();
		for (StereotypeTextField field : fields.getItems()) {
			ModelElement element = DeployHelper
					.getElement(field.getGraphNode());

			ret.add((AttributeImpl) element);
		}

		return ret.toArray(new AttributeImpl[ret.size()]);
	}
}
