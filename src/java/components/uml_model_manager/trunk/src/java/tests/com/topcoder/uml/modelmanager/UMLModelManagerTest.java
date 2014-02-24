/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * Test class for the UMLModelManager. This class test all the public methods in
 * UMLModelManager, including:
 * <ol>
 * <li>UMLModelManager()</li>
 * <li>UMLModelManager(String)</li>
 * <li>UMLModelManager(String, ProjectConfigurationManager)</li>
 * <li>UMLModelManager(String, ProjectConfigurationManager, String)</li>
 * <li>getInstance()</li>
 * <li>getModel()</li>
 * <li>setModel(Model)</li>
 * <li>getInstanceName()</li>
 * <li>addActivityGraph(ActivityGraph)</li>
 * <li>addActivityGraph(int, ActivityGraph)</li>
 * <li>addActivityGraphs(Collection<ActivityGraph>)</li>
 * <li>addActivityGraphs(int, Collection<ActivityGraph>)</li>
 * <li>setActivityGraph(int, ActivityGraph)</li>
 * <li>removeActivityGraph(int)</li>
 * <li>removeActivityGraph(ActivityGraph)</li>
 * <li>removeActivityGraphs(Collection<ActivityGraph>)</li>
 * <li>clearActivityGraphs()</li>
 * <li>getActivityGraphs()</li>
 * <li>containsActivityGraph(ActivityGraph)</li>
 * <li>indexOfActivityGraph(ActivityGraph)</li>
 * <li>countActivityGraphs()</li>
 * <li>isActivityGraphsEmpty()</li>
 * <li>addDiagram(Diagram)</li>
 * <li>addDiagram(int, Diagram)</li>
 * <li>addDiagrams(Collection<Diagram>)</li>
 * <li>addDiagrams(int, Collection<Diagram>)</li>
 * <li>setDiagram(int, Diagram)</li>
 * <li>removeDiagram(int)</li>
 * <li>removeDiagram(Diagram)</li>
 * <li>removeDiagrams(Collection<Diagram>)</li>
 * <li>clearDiagrams()</li>
 * <li>getDiagrams()</li>
 * <li>containsDiagram(Diagram)</li>
 * <li>indexOfDiagram(Diagram)</li>
 * <li>countDiagrams()</li>
 * <li>isDiagramsEmpty()</li>
 * <li>getProjectConfigurationManager()</li>
 * <li>setProjectConfigurationManager(ProjectConfigurationManager)</li>
 * <li>getProjectLanguage()</li>
 * <li>setProjectLanguage(String)</li>
 * </ol>
 * The testing case covers parameter checking, bound condition operation and
 * accuracy testing.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UMLModelManagerTest extends TestCase {
    /**
     * Sample UMLModelManger for testing.
     */
    private UMLModelManager uml;

    /**
     * Sample instanceName for testing.
     */
    private String instanceName = "testInstanceName";

    /**
     * Sample projectLanguage for testing.
     */
    private String projectLanguage = "C#";

    /**
     * Sample Model for testing.
     */
    private Model model = new ModelImpl();

    /**
     * Sample activityGraph for testing.
     */
    private ActivityGraph activityGraph = new ActivityGraphImpl();

    /**
     * Sample diagram for testing.
     */
    private Diagram diagram = new Diagram();

    /**
     * Sample ProjectConfigurationManager for testing.
     */
    private ProjectConfigurationManager ProjectConfigurationManager = new ProjectConfigurationManager();

    /**
     * Sample Collection<ActivityGraph> for testing.
     */
    private Collection<ActivityGraph> collectionActivityGraph = new ArrayList<ActivityGraph>();

    /**
     * Sample Collection<Diagram> for testing.
     */
    private Collection<Diagram> CollectionDiagram = new ArrayList<Diagram>();

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        uml = new UMLModelManager();
    }

    /**
     * Test method for UMLModelManager().
     */
    public void testUMLModelManager() {
        uml = new UMLModelManager();
        assertNotNull("Should not be null.", uml);
        assertTrue("uml should be and instance of UMLModelManager.", uml instanceof UMLModelManager);
    }

    /**
     * Test accuracy for UMLModelManager().
     * <ol>
     * <li> model field should not be null.</li>
     * <li> instanceName field should be DEFAULT_INSTANCE_NAME.</li>
     * </ol>
     */
    public void testUMLModelManagerAccuracy() {
        uml = new UMLModelManager();
        assertNotNull("model field should not be null.", uml.getModel());
        assertEquals("instanceName field should be DEFAULT_INSTANCE_NAME.", UMLModelManager.DEFAULT_INSTANCE_NAME,
            uml.getInstanceName());
    }

    /**
     * Test method for UMLModelManager(String) when passing the null parameter.
     * IllegalArgumentException is expected.
     */
    public void testUMLModelManagerString() {
        try {
            uml = new UMLModelManager(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager(String) when passing the empty String.
     * IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringEmpty() {
        try {
            uml = new UMLModelManager("       ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Accuracy test for UMLModelManager(String).
     * <ol>
     * <li>model field should not be null. </li>
     * <li>instanceName field should be set correctly.</li>
     * </ol>
     */
    public void testUMLModelManagerStringAccuracy() {
        uml = new UMLModelManager(this.instanceName);
        assertNotNull("The model filed should not be null.", uml.getModel());
        assertEquals("The instanceName field should be set correctly.", this.instanceName, uml.getInstanceName());
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager) when
     * passing a null String. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerNullString() {
        try {
            uml = new UMLModelManager(null, this.ProjectConfigurationManager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager) when
     * passing an empty String. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerEmptyString() {
        try {
            uml = new UMLModelManager("     ", this.ProjectConfigurationManager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager) when
     * passing a null ProjectConfigurationManager. IllegalArgumentException is
     * expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerNullPro() {
        try {
            uml = new UMLModelManager(this.instanceName, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Accuracy test method for UMLModelManager(String,
     * ProjectConfigurationManager).
     * <ol>
     * <li> The model field should not be null.</li>
     * <li> The instanceName filed should be set correctly.</li>
     * <li> The projectConfigurationManager should be set correctly. </li>
     * </ol>
     */
    public void testUMLModelManagerStringProjectConfigurationManagerAccuray() {
        uml = new UMLModelManager(this.instanceName, this.ProjectConfigurationManager);
        assertNotNull("The model field should not be null.", uml.getModel());
        assertEquals("The instanceName filed should be set correctly.", this.instanceName, uml.getInstanceName());
        assertEquals("The projectConfigurationManager should be set correctly.", this.ProjectConfigurationManager,
            uml.getProjectConfigurationManager());
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager,
     * String).
     */
    public void testUMLModelManagerStringProjectConfigurationManagerString() {
        uml = new UMLModelManager(this.instanceName, this.ProjectConfigurationManager, this.projectLanguage);
        assertNotNull("The model field should not be null.", uml.getModel());
        assertEquals("The instanceName filed should be set correctly.", this.instanceName, uml.getInstanceName());
        assertEquals("The projectConfigurationManager should be set correctly.", this.ProjectConfigurationManager,
            uml.getProjectConfigurationManager());
        assertEquals("The projectLanguage should be set correctly.", this.projectLanguage, uml
            .getProjectLanguage());
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager,
     * String) with first null parameter. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerStringFirstNull() {
        try {
            uml = new UMLModelManager(null, this.ProjectConfigurationManager, this.projectLanguage);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager,
     * String) with first empty parameter. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerStringFirstEmpty() {
        try {
            uml = new UMLModelManager("    ", this.ProjectConfigurationManager, this.projectLanguage);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager,
     * String) with null second parameter. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerStringNullSecond() {
        try {
            uml = new UMLModelManager(this.instanceName, null, this.projectLanguage);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager(String, ProjectConfigurationManager,
     * String) with empty third parameter. IllegalArgumentException is expected.
     */
    public void testUMLModelManagerStringProjectConfigurationManagerStringThirdEmpty() {
        try {
            uml = new UMLModelManager(this.instanceName, this.ProjectConfigurationManager, "    ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Accuracy test for UMLModelManager.getInstance().
     * <ol>
     * <li>The model field should be set.</li>
     * <li>The instanceName field should be set correctly.</li>
     * <li>The projectConfigurationManager field should be set correctly.</li>
     * <li>The projectLanguage field should be set correctly.</li>
     * </ol>
     */
    public void testUMLModelManagerStringProjectConfigurationManagerStringAccuracy() {
        uml = new UMLModelManager(this.instanceName, this.ProjectConfigurationManager, this.projectLanguage);
        assertNotNull("The model field should be set.", uml.getModel());
        assertEquals("The instanceName field should be set correctly.", this.instanceName, uml.getInstanceName());

    }

    /**
     * <P>
     * Test for getInstance.
     * </p>
     * <Strong>Expected result:</Strong> Instance of UMLModelManager.
     */
    public void testGetInstance() {
        assertTrue("The result should be an instance of UMLModelManager.",
            uml.getInstance() instanceof UMLModelManager);
    }

    /**
     * <p>
     * Test method for UMLModelManager.getModel().
     * </p>
     * <Strong>Test method:</Strong>
     * <ol>
     * <li>Set the model field to be this.model.</li>
     * <li>Get the model field and check if it is equal to this.model.</li>
     * </ol>
     */
    public void testGetModel() {
        uml.setModel(this.model);
        assertEquals("The model field is not get properly.", this.model, uml.getModel());
    }

    /**
     * Test method for UMLModelManager.setModel(Model) with null parameter.
     * IllegalArgumentException is expected.
     */
    public void testSetModelNull() {
        try {
            uml.setModel(null);
            fail("IllagelArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Accuracy test method for UMLModelManager.setModel(Model).
     */
    public void testSetModel() {
        uml.setModel(this.model);
        assertEquals("IllegalArgumentException is expected.", this.model, uml.getModel());
    }

    /**
     * <p>
     * Test method for UMLModelManager.getInstanceName() without setting the
     * instanceName field.
     * </p>
     * <Strong>Expecting Result:</Strong> "Default" should be returned.
     */
    public void testGetInstanceNameNotSet() {
        assertEquals("\"Default\" should be returned.", "Default", uml.getInstanceName());
    }

    /**
     * <p>
     * Accuracy test for UMLModelManager.getInstanceName().
     * </p>
     * <Strong>Test Method:</Strong>
     * <ol>
     * <li>Set the instanceName field to be this.instanceName.</li>
     * <li>Get the instanceName, the result should be this.instanceName.</li>
     * </ol>
     */
    public void testGetInstanceNameAccuracy() {
        uml = new UMLModelManager(this.instanceName);
        assertEquals("this.instanceName should be returned.", this.instanceName, uml.getInstanceName());
    }

    /**
     * Test method for UMLModelManager.addActivityGraph(ActivityGraph) with null
     * parameter. IllegalArgumentException is expected.
     */
    public void testAddActivityGraphActivityGraphNull() {
        try {
            uml.addActivityGraph(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraph(ActivityGraph) with
     * duplicate adding. Nothing will be done when adding a duplicate element.
     */
    public void testAddActivityGraphActivityGraphDupliate() {
        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(this.activityGraph);
        // Only one activityGraph should be appear in the list.
        assertEquals("Duplicate activityGraph should be added exactly once.", 1, uml.getActivityGraphs().size());
        // The result list should contain only one activityGraph.
        assertEquals("activityGraph should be added to the list.", this.activityGraph, uml.getActivityGraphs()
            .get(0));
    }

    /**
     * <p>
     * Accuracy test for UMLModelManager.addActivityGraph(ActivityGraph).
     * </p>
     * <Strong>Test method:</Strong>
     * <ol>
     * <li> Add the activityGrpah[3] to the List one by one.</li>
     * <li> The expected List would be {activityGraph[0], activityGraph[1],
     * activitGraph[2]}.
     * </ol>
     */
    public void testAddActivityGraphActivityGraph() {
        ActivityGraph[] addGraphs = new ActivityGraph[3];
        // add the activityGraph one by one.
        for (int i = 0; i < 3; i++) {
            addGraphs[i] = new ActivityGraphImpl();
            uml.addActivityGraph(addGraphs[i]);
        }
        List res = uml.getActivityGraphs();
        for (int i = 0; i < 3; i++) {
            assertEquals("Should be Equal.", addGraphs[i], res.get(i));
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraph(int, ActivityGraph) with
     * index less than 0. IndexOutOfBoundsException is expected.
     */
    public void testAddActivityGraphIntActivityGraphLessIndex() {
        try {
            uml.addActivityGraph(-1, this.activityGraph);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraph(int, ActivityGraph) with
     * index larger than the size of list. IndexOutOfBoundsException is
     * expected.
     */
    public void testAddActivityGraphIntActivityGraphLargerIndex() {
        try {
            uml.addActivityGraph(1, this.activityGraph);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.addActivityGraph(int, ActivityGraph) with
     * null activityGraph. IllegalArgumentException is expected.
     */
    public void testAddActivityGraphIntActivityGraphNull() {
        try {
            uml.addActivityGraph(0, null);
            fail("IlleaglArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraph(int, ActivityGraph) with
     * duplicate activityGraph. Only the first activityGraph should be added.
     */
    public void testAddActivityGraphIntActivityGraphDuplicate() {
        ActivityGraph newActivityGraph = new ActivityGraphImpl();
        uml.addActivityGraph(0, this.activityGraph);
        uml.addActivityGraph(0, newActivityGraph);
        uml.addActivityGraph(0, this.activityGraph);

        List res = uml.getActivityGraphs();
        // the expected result list should be {newActivityGraph,
        // this.activityGraph}.
        assertEquals("Duplicate element should be added only once.", 2, res.size());
        assertEquals("The first element should be equal.", newActivityGraph, res.get(0));
        assertEquals("The second element should be equal.", this.activityGraph, res.get(1));
    }

    /**
     * Normal test for UMLModelManager.addActivityGraph(int, ActivityGraph).
     */
    public void testAddActivityGraphIntActivityGraph() {
        ActivityGraph[] addGraphs = new ActivityGraph[3];
        for (int i = 0; i < 3; i++) {
            addGraphs[i] = new ActivityGraphImpl();
        }
        uml.addActivityGraph(0, addGraphs[1]);
        uml.addActivityGraph(1, addGraphs[2]);
        uml.addActivityGraph(1, addGraphs[0]);

        // The expected result list should be {addGraphs[1], addGraphs[0],
        // addGraphs[2]}.
        List res = uml.getActivityGraphs();
        assertEquals("The size of the list should be 3.", 3, res.size());
        assertEquals("The first element should be addGraphs[1]", addGraphs[1], res.get(0));
        assertEquals("The second element should be addGraphs[0]", addGraphs[0], res.get(1));
        assertEquals("The third element should be addGraphs[2]", addGraphs[2], res.get(2));
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(Collection<ActivityGraph>)
     * with null Collection. IllegalArgumentException is expected.
     */
    public void testAddActivityGraphsCollectionOfActivityGraphNull() {
        try {
            uml.addActivityGraphs(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(Collection<ActivityGraph>)
     * with the Collection which contains null element. IllegalArgumentException
     * is expected.
     */
    public void testAddActivityGraphsCollectionOfActivityGraphContainsNull() {
        Collection<ActivityGraph> addGraphs = new ArrayList<ActivityGraph>();
        addGraphs.add(this.activityGraph);
        addGraphs.add(null);
        try {
            uml.addActivityGraphs(addGraphs);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(Collection<ActivityGraph>)
     * with collection containning duplicate element. The duplicate element will
     * be added only once.
     */
    public void testAddActivityGraphsCollectionOfActivityGraphDuplicateElement() {
        Collection<ActivityGraph> addGraphs = new ArrayList<ActivityGraph>();
        ActivityGraph newActivityGraph = new ActivityGraphImpl();
        addGraphs.add(this.activityGraph);
        addGraphs.add(this.activityGraph);
        addGraphs.add(newActivityGraph);
        addGraphs.add(newActivityGraph);
        uml.addActivityGraphs(addGraphs);
        // The result list should be {this.activityGraph, newActivityGraph}.
        List res = uml.getActivityGraphs();
        assertEquals("Duplicate element should be added only once.", 2, res.size());
        assertEquals("The first element should be this.activityGraph.", this.activityGraph, res.get(0));
        assertEquals("The second element should be newActivityGraph.", newActivityGraph, res.get(1));
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(Collection<ActivityGraph>)
     * with collection with zero length.
     */
    public void testAddActivityGraphsCollectionOfActivityGraphZero() {
        Collection<ActivityGraph> addGraphs = new ArrayList<ActivityGraph>();
        uml.addActivityGraphs(addGraphs);
        assertEquals("The length of the result list should be zero.", 0, uml.getActivityGraphs().size());
    }

    /**
     * Normal test method for UMLModelManager.addActivityGraphs(Collection<ActivityGraph>).
     */
    public void testAddActivityGraphsCollectionOfActivityGraph() {
        Collection<ActivityGraph> addGraphs = new ArrayList<ActivityGraph>();
        for (int i = 0; i < 5; i++) {
            addGraphs.add(new ActivityGraphImpl());
        }
        uml.addActivityGraphs(addGraphs);
        // The result list should be {this.activityGraph, newActivityGraph}.
        List res = uml.getActivityGraphs();
        assertEquals("The length should be 5.", 5, res.size());
        for (int i = 0; i < 5; i++) {
            assertEquals("Should be equal.", ((ArrayList) addGraphs).get(i), res.get(i));
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>)
     * with index less than 0. IndexOutOfBoundsException is expected.
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphLessIndex() {
        try {
            uml.addActivityGraphs(-1, this.collectionActivityGraph);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>)
     * with index larger than the size of the list. IndexOutOfBoundsException is
     * expected.
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphLargerIndex() {
        try {
            uml.addActivityGraphs(1, this.collectionActivityGraph);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>)
     * with null collection. IllegalArgumentException is expected.
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphNull() {
        try {
            uml.addActivityGraphs(0, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>)
     * with collection containing null element. IllegalArgumentException is
     * expected.
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphContainsNull() {
        this.collectionActivityGraph.add(null);
        try {
            uml.addActivityGraphs(0, this.collectionActivityGraph);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>)
     * with duplicate element adding. The duplicate element should be added only
     * once.
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphDuplicate() {
        ActivityGraph newActivityGraph = new ActivityGraphImpl();
        for (int i = 0; i < 3; i++) {
            this.collectionActivityGraph.add(this.activityGraph);
        }
        for (int i = 0; i < 3; i++) {
            this.collectionActivityGraph.add(newActivityGraph);
        }

        uml.addActivityGraphs(0, this.collectionActivityGraph);
        // The result list would be {activityGraph, newActivityGraph}.
        List res = uml.getActivityGraphs();
        assertEquals("The length of the list should be 2.", 2, res.size());
        assertEquals("The first element should be equal.", this.activityGraph, res.get(0));
        assertEquals("The second element should be equal.", newActivityGraph, res.get(1));
    }

    /**
     * Normal test method for UMLModelManager.addActivityGraphs(int, Collection<ActivityGraph>).
     */
    public void testAddActivityGraphsIntCollectionOfActivityGraphNormal() {
        ActivityGraph oldActivityGraph = new ActivityGraphImpl();
        ActivityGraph newActivityGraph = new ActivityGraphImpl();
        this.collectionActivityGraph.add(this.activityGraph);
        this.collectionActivityGraph.add(newActivityGraph);

        uml.addActivityGraph(oldActivityGraph);

        uml.addActivityGraphs(0, this.collectionActivityGraph);
        // The result list would be {oldActivityGraph, activityGraph,
        // newActivityGraph}.
        List res = uml.getActivityGraphs();
        assertEquals("The length of the list should be 3.", 3, res.size());
        assertEquals("The first element should be equal.", this.activityGraph, res.get(0));
        assertEquals("The second element should be equal.", newActivityGraph, res.get(1));
        assertEquals("The third element should be equal.", oldActivityGraph, res.get(2));
    }

    /**
     * Test method for UMLModelManager.setActivityGraph(int, ActivityGraph) with
     * index less than 0. IndexOutOfBoundsException is expected.
     */
    public void testSetActivityGraphLessIndex() {
        try {
            uml.setActivityGraph(-1, this.activityGraph);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.setActivityGraph(int, ActivityGraph) with
     * index equal the size of the list. IndexOutOfBoundsException is expected.
     */
    public void testSetActivityGraphEqual() {
        try {
            uml.setActivityGraph(0, this.activityGraph);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.setActivityGraph(int, ActivityGraph) with
     * index larger than the size of the list. IndexOutOfBoundsException is
     * expected.
     */
    public void testSetActivityGraphLarger() {
        try {
            uml.setActivityGraph(1, this.activityGraph);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.setActivityGraph(int, ActivityGraph) with
     * null ActivityGraph. IllegalArgumentException is expected.
     */
    public void testSetActivityGraphNullActivity() {
        uml.addActivityGraph(this.activityGraph);
        try {
            uml.setActivityGraph(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.setActivityGraph(int, ActivityGraph) with
     * duplicate ActivityGraph. Nothing will be done.
     */
    public void testSetActivityGraphDuplicate() {
        ActivityGraph newGraph = new ActivityGraphImpl();
        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(newGraph);

        uml.setActivityGraph(1, this.activityGraph);

        List res = uml.getActivityGraphs();
        assertEquals("The first element should be equal.", this.activityGraph, res.get(0));
        assertEquals("The second element should be equal.", newGraph, res.get(1));
    }

    /**
     * Normal test method for UMLModelManager.setActivityGraph(int,
     * ActivityGraph).
     */
    public void testSetActivityGraph() {
        ActivityGraph newGraph1 = new ActivityGraphImpl();
        ActivityGraph newGraph2 = new ActivityGraphImpl();
        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(newGraph1);
        uml.setActivityGraph(0, newGraph2);

        List res = uml.getActivityGraphs();
        assertEquals("The first element should be equal.", newGraph2, res.get(0));
        assertEquals("The second element should be equal.", newGraph1, res.get(1));
    }

    /**
     * Test method for UMLModelManager.removeActivityGraph(int) with index less
     * than 0. IndexOutOfBoundsException is expected.
     */
    public void testRemoveActivityGraphIntLess() {
        try {
            uml.removeActivityGraph(-1);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.removeActivityGraph(int) with index equal
     * the size of the list. IndexOutOfBoundsException is expected.
     */
    public void testRemoveActivityGraphIntEqual() {
        try {
            uml.removeActivityGraph(0);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.removeActivityGraph(int) with index
     * larger than the size of the list. IndexOutOfBoundsException is expected.
     */
    public void testRemoveActivityGraphIntLarger() {
        try {
            uml.removeActivityGraph(1);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Normal test method for UMLModelManager.removeActivityGraph(int).
     */
    public void testRemoveActivityGraphInt() {
        uml.addActivityGraph(this.activityGraph);
        assertEquals("The return value should be this.activityGraph.", this.activityGraph, uml
            .removeActivityGraph(0));
        assertEquals("The ActivityGraphs should be empty.", 0, uml.getActivityGraphs().size());
    }

    /**
     * Test method for UMLModelManager.removeActivityGraph(ActivityGraph) with
     * null parameter. IllegalArgumentException is expected.
     */
    public void testRemoveActivityGraphActivityGraphNull() {
        try {
            uml.removeActivityGraph(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.removeActivityGraph(ActivityGraph) with
     * the activityGraph which is not in the list. Nothing will be done.
     */
    public void testRemoveActivityGraphActivityGraphNotContain() {
        uml.addActivityGraph(this.activityGraph);
        assertFalse("Should be false.", uml.removeActivityGraph(new ActivityGraphImpl()));
        List res = uml.getActivityGraphs();
        assertEquals("The length of res should be 1.", 1, res.size());
        assertEquals("The first element should be equal.", this.activityGraph, res.get(0));
    }

    /**
     * Normal test method for
     * UMLModelManager.removeActivityGraph(ActivityGraph).
     */
    public void testRemoveActivityGraphActivityGraph() {
        uml.addActivityGraph(this.activityGraph);
        assertTrue("Should be true.", uml.removeActivityGraph(this.activityGraph));
        assertEquals("The list should be empty.", 0, uml.getActivityGraphs().size());
    }

    /**
     * Test method for UMLModelManager.removeActivityGraphs(Collection<ActivityGraph>)
     * with null collection. IllegalArgumentException is expected.
     */
    public void testRemoveActivityGraphsNullPara() {
        try {
            uml.removeActivityGraphs(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.removeActivityGraphs(Collection<ActivityGraph>)
     * with collection which contains null element. IllegalArgumentException is
     * expected.
     */
    public void testRemoveActivityGraphsContainNull() {
        this.collectionActivityGraph.add(null);
        try {
            uml.removeActivityGraphs(this.collectionActivityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Normal test method for UMLModelManager.removeActivityGraphs(Collection<ActivityGraph>).
     */
    public void testRemoveActivityGraphs() {
        ActivityGraph newGraph1 = new ActivityGraphImpl();
        ActivityGraph newGraph2 = new ActivityGraphImpl();

        this.collectionActivityGraph.add(this.activityGraph);
        this.collectionActivityGraph.add(newGraph1);

        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(newGraph1);
        uml.addActivityGraph(newGraph2);

        assertTrue("Should be true.", uml.removeActivityGraphs(this.collectionActivityGraph));

        List res = uml.getActivityGraphs();
        assertEquals("The length of the result list should be 1.", 1, res.size());
        assertEquals("The first element should be equal.", newGraph2, res.get(0));
    }

    /**
     * Test method for UMLModelManager.clearActivityGraphs().
     */
    public void testClearActivityGraphs() {
        for (int i = 0; i < 10; i++) {
            uml.addActivityGraph(new ActivityGraphImpl());
        }
        uml.clearActivityGraphs();
        assertEquals("The result list should be empty.", 0, uml.getActivityGraphs().size());
    }

    /**
     * Test method for UMLModelManager.getActivityGraphs().
     * <p>
     * <Strong>Test target:</Strong>
     * <ol>
     * <li> Check if the result list is correct.</li>
     * </ol>
     * </p>
     */
    public void testGetActivityGraphs() {
        ActivityGraph newGraph = new ActivityGraphImpl();
        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(newGraph);
        // Check if the result list is correct.
        List res = uml.getActivityGraphs();
        assertEquals("The length of the list should be 2.", 2, res.size());
        assertEquals("The first element should be equal.", this.activityGraph, res.get(0));
        assertEquals("The second element should be equal.", newGraph, res.get(1));
    }

    /**
     * Test method for UMLModelManager.containsActivityGraph(ActivityGraph) with
     * null parameter. IllegalArgumentException is expected.
     */
    public void testContainsActivityGraphNull() {
        try {
            uml.containsActivityGraph(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Normal test method for
     * UMLModelManager.containsActivityGraph(ActivityGraph).
     */
    public void testContainsActivityGraph() {
        uml.addActivityGraph(this.activityGraph);
        assertFalse("Should be false.", uml.containsActivityGraph(new ActivityGraphImpl()));
        assertTrue("Should be true.", uml.containsActivityGraph(this.activityGraph));
    }

    /**
     * Test method for UMLModelManager.indexOfActivityGraph(ActivityGraph) with
     * no corresponding activityGraph containning.
     */
    public void testIndexOfActivityGraphNotContain() {
        assertEquals("The result should be -1.", -1, uml.indexOfActivityGraph(new ActivityGraphImpl()));
    }

    /**
     * Test method for UMLModelManager.indexOfActivityGraph(ActivityGraph) with
     * null parameter. IllegalArgumentException is expected.
     */
    public void testIndexOfActivityGraphNull() {
        try {
            uml.indexOfActivityGraph(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Normal test method for
     * UMLModelManager.indexOfActivityGraph(ActivityGraph).
     */
    public void testIndexOfActivityGraph() {
        ActivityGraph newGraph = new ActivityGraphImpl();
        uml.addActivityGraph(this.activityGraph);
        uml.addActivityGraph(newGraph);
        assertEquals("Should be equal.", 0, uml.indexOfActivityGraph(this.activityGraph));
        assertEquals("Should be equal.", 1, uml.indexOfActivityGraph(newGraph));
    }

    /**
     * Normal test for UMLModelManager.countActivityGraphs().
     */
    public void testCountActivityGraphs() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            uml.addActivityGraph(new ActivityGraphImpl());
        }
        assertEquals("Should be equal.", 10, uml.countActivityGraphs());
    }

    /**
     * Normal test for UMLModelManager.isActivityGraphsEmpty().
     */
    public void testIsActivityGraphsEmpty() {
        assertTrue("The activityGraphs List is empty.", uml.isActivityGraphsEmpty());
        uml.addActivityGraph(this.activityGraph);
        assertFalse("The activityGraphs list is not empty", uml.isActivityGraphsEmpty());
    }

    /**
     * Test method for UMLModelManager.addDiagram(Diagram) with null parameter.
     * IllegalArgumentException is expected.
     */
    public void testAddDiagramDiagramNull() {
        try {
            uml.addDiagram(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.addDiagram(Diagram) with duplicate
     * adding. Duplicate element should be added only once.
     */
    public void testAddDiagramDiagramDuplicate() {
        uml.addDiagram(this.diagram);
        uml.addDiagram(this.diagram);
        assertEquals("Duplicate element should be add only once.", 1, uml.getDiagrams().size());
        assertEquals("The first element should be equal.", this.diagram, uml.getDiagrams().get(0));
    }

    /**
     * Normal test method for UMLModelManager.addDiagram(Diagram).
     */
    public void testAddDiagramDiagram() {
        uml.addDiagram(this.diagram);
        assertEquals("The first element should be equal.", this.diagram, uml.getDiagrams().get(0));
    }

    /**
     * Test method for UMLModelManager.addDiagram(int, Diagram) with index less
     * than 0. IndexOutOfBoundsException is expected.
     */
    public void testAddDiagramIntDiagramIessIndex() {
        try {
            uml.addDiagram(-1, this.diagram);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test method for UMLModelManager.addDiagram(int, Diagram) with index
     * larger than the size of the list. IndexOutOfBoundsException is expected.
     */
    public void testAddDiagramIntDiagramLargerIndex() {
        try {
            uml.addDiagram(1, this.diagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addDiagram(int, Diagram) with null
     * element. IllegalArgumentException is expected.
     */
    public void testAddDiagramIntDiagramNullElement() {
        try {
            uml.addDiagram(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addDiagram(int, Diagram) with duplicate
     * element adding. Duplicate element should be added only once.
     */
    public void testAddDiagramIntDiagramDuplicate() {
        uml.addDiagram(0, this.diagram);
        uml.addDiagram(0, this.diagram);
        assertEquals("The duplicate element should be added only once.", 1, uml.getDiagrams().size());
        assertEquals("The first element should be equal.", this.diagram, uml.getDiagrams().get(0));
    }

    /**
     * Normal test method for UMLModelManager.addDiagram(int, Diagram).
     */
    public void testAddDiagramIntDiagram() {
        uml.addDiagram(0, this.diagram);
        Diagram newDiagram = new Diagram();
        uml.addDiagram(0, newDiagram);
        assertEquals("The size of the list should be 2", 2, uml.getDiagrams().size());
        assertEquals("The first element should be equal.", newDiagram, uml.getDiagrams().get(0));
        assertEquals("The second element should be equal.", this.diagram, uml.getDiagrams().get(1));
    }

    /**
     * Test method for UMLModelManager.addDiagrams(Collection<Diagram>) with
     * null parameter. IllegalArgumentException is expected.
     */
    public void testAddDiagramsCollectionOfDiagramNull() {
        try {
            uml.addDiagrams(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }

    }

    /**
     * Test method for UMLModelManager.addDiagrams(Collection<Diagram>) with
     * collection containing null element. IllegalArgumentException is expected.
     */
    public void testAddDiagramsCollectionOfDiagramNullElementContainning() {
        this.CollectionDiagram.add(null);
        try {
            uml.addDiagrams(this.CollectionDiagram);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for UMLModelManager.addDiagrams(Collection<Diagram>) with
     * collection containing duplicate element. Duplicate element should be
     * added only once.
     */
    public void testAddDiagramsCollectionOfDiagram() {
        this.CollectionDiagram.add(this.diagram);
        this.CollectionDiagram.add(this.diagram);
        uml.addDiagrams(this.CollectionDiagram);
        assertEquals("The length of the list should be 1.", 1, uml.getDiagrams().size());
        assertEquals("The first element of the list should be equal.", this.diagram, uml.getDiagrams().get(0));
    }

    /**
     * Test method for addDiagrams(int, Collection<Diagram>) with index less
     * than 0. IndexOutOfBoundsException is expected.
     */
    public void testAddDiagramsIntCollectionOfDiagramLessIndex() {
        try {
            uml.addDiagrams(-1, this.CollectionDiagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for addDiagrams(int, Collection<Diagram>) with index larger
     * than the size of the list. IndexOutOfBoundsException is expected.
     */
    public void testAddDiagramsIntCollectionOfDiagramLargerIndex() {
        try {
            uml.addDiagrams(1, this.CollectionDiagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for addDiagrams(int, Collection<Diagram>) with null
     * collection. IllegalArgumentException is expected.
     */
    public void testAddDiagramsIntCollectionOfDiagramNullCollection() {
        try {
            uml.addDiagrams(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for addDiagrams(int, Collection<Diagram>) with collection
     * contains null element. IllegalArgumentException is expected.
     */
    public void testAddDiagramsIntCollectionOfDiagramContainsNull() {
        this.CollectionDiagram.add(null);
        try {
            uml.addDiagrams(0, this.CollectionDiagram);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for addDiagrams(int, Collection<Diagram>) with collection
     * contains duplicate element. Duplicate element should be added only once.
     */
    public void testAddDiagramsIntCollectionOfDiagramDuplicate() {
        uml.addDiagram(this.diagram);
        for (int i = 0; i < 3; i++) {
            this.CollectionDiagram.add(new Diagram());
        }

        uml.addDiagrams(0, this.CollectionDiagram);

        List<Diagram> expected = (ArrayList<Diagram>) this.CollectionDiagram;
        expected.add(this.diagram);

        List res = uml.getDiagrams();
        for (int i = 0; i < 4; i++) {
            assertEquals("The " + i + " element should be equal.", expected.get(0), res.get(0));
        }
        assertEquals("The length of the list should be 4.", 4, res.size());
    }

    /**
     * Test method for setDiagram(int, Diagram) with index less than 0.
     * IndexOutOfBoundsException is expected.
     */
    public void testSetDiagramLess() {
        try {
            uml.setDiagram(-1, this.diagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for setDiagram(int, Diagram) with index equal to the size of
     * the list. IndexOutOfBoundsException is expected.
     */
    public void testSetDiagramEqual() {
        try {
            uml.setDiagram(0, this.diagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for setDiagram(int, Diagram) with index larger than the size
     * of the list. IndexOutOfBoundsException is expected.
     */
    public void testSetDiagramLarger() {
        try {
            uml.setDiagram(1, this.diagram);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for setDiagram(int, Diagram) with duplicate diagram setting.
     * Nothing will be done.
     */
    public void testSetDiagramDuplicate() {
        Diagram newDiagram = new Diagram();
        uml.addDiagram(newDiagram);
        uml.addDiagram(this.diagram);
        uml.setDiagram(0, this.diagram);
        assertEquals("The first element should be equal.", newDiagram, uml.getDiagrams().get(0));
        assertEquals("The second element should be equal.", this.diagram, uml.getDiagrams().get(1));
    }

    /**
     * Normal test method for setDiagram(int, Diagram).
     */
    public void testSetDiagram() {
        uml.addDiagram(new Diagram());
        uml.setDiagram(0, this.diagram);
        assertEquals("Should be equal.", this.diagram, uml.getDiagrams().get(0));
    }

    /**
     * Test method for removeDiagram(int) with index less than 0.
     * IndexOutOfBoundsException is expected.
     */
    public void testRemoveDiagramIntLess() {
        try {
            uml.removeDiagram(-1);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Test method for removeDiagram(int) with index larger than the size of the
     * list. IndexOutOfBoundsException is expected.
     */
    public void testRemoveDiagramIntLarger() {
        try {
            uml.removeDiagram(1);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok.
        }
    }

    /**
     * Normal test method for removeDiagram(int).
     */
    public void testRemoveDiagramInt() {
        uml.addDiagram(this.diagram);
        assertEquals("The return value should be this.diagram.", this.diagram, uml.removeDiagram(0));
        assertEquals("The list should be empty.", 0, this.uml.getDiagrams().size());
    }

    /**
     * Test method for removeDiagram(Diagram) with null parameter.
     * IllegalArgumentException is expected.
     */
    public void testRemoveDiagramDiagramNull() {
        try {
            uml.removeDiagram(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for removeDiagram(Diagram) with the diagram which is not
     * contained in the list. Nothing will be done.
     */
    public void testRemoveDiagramDiagramNotContain() {
        uml.removeDiagram(this.diagram);
        assertEquals("The length of the list should be 0.", 0, uml.getDiagrams().size());
    }

    /**
     * Test method for removeDiagram(Diagram).
     */
    public void testRemoveDiagramDiagram() {
        uml.addDiagram(this.diagram);
        assertTrue("Should be true.", uml.removeDiagram(this.diagram));
        assertEquals("The length of the list should be 0.", 0, uml.getDiagrams().size());
    }

    /**
     * Test method for removeDiagrams(Collection<Diagram>) with null parameter.
     * IllegalArgumentException is expected.
     */
    public void testRemoveDiagramsNull() {
        try {
            uml.removeDiagram(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for removeDiagrams(Collection<Diagram>) with null element
     * containing. IllegalArgumentException is expected.
     */
    public void testRemoveDiagramsNullContaining() {
        this.CollectionDiagram.add(null);
        try {
            uml.removeDiagrams(this.CollectionDiagram);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for removeDiagrams(Collection<Diagram>).
     */
    public void testRemoveDiagrams() {
        Diagram newDiagram1 = new Diagram();
        Diagram newDiagram2 = new Diagram();
        this.CollectionDiagram.add(newDiagram1);
        this.CollectionDiagram.add(newDiagram2);
        this.CollectionDiagram.add(this.diagram);
        uml.addDiagrams(this.CollectionDiagram);

        Collection<Diagram> remDiagram = new ArrayList<Diagram>();
        remDiagram.add(newDiagram1);
        remDiagram.add(this.diagram);

        assertTrue("Should be true.", uml.removeDiagrams(remDiagram));
        assertEquals("The length of the diagram should be 1.", 1, uml.getDiagrams().size());
        assertEquals("The first element should be equal.", newDiagram2, uml.getDiagrams().get(0));
    }

    /**
     * Test method for UMLModelManager.clearDiagrams().
     */
    public void testClearDiagrams() {
        for (int i = 0; i < 3; i++) {
            uml.addDiagram(new Diagram());
        }
        uml.clearDiagrams();
        assertEquals("The list should be empty.", 0, uml.getDiagrams().size());
    }

    /**
     * Test method for UMLModelManager.getDiagrams().
     */
    public void testGetDiagrams() {

        for (int i = 0; i < 3; i++) {
            this.CollectionDiagram.add(new Diagram());
        }

        uml.addDiagrams(0, this.CollectionDiagram);

        List<Diagram> expected = (ArrayList<Diagram>) this.CollectionDiagram;

        List res = uml.getDiagrams();
        for (int i = 0; i < 3; i++) {
            assertEquals("The " + i + " element should be equal.", expected.get(i), res.get(i));
        }
        assertEquals("The length of the list should be 3.", 3, res.size());
    }

    /**
     * Test method for containsDiagram(Diagram) without containing.
     */
    public void testContainsDiagramWithout() {
        assertFalse("Should be false.", uml.containsDiagram(this.diagram));
    }

    /**
     * Test method for containsDiagram(Diagram) containing.
     */
    public void testContainsDiagramContain() {
        uml.addDiagram(this.diagram);
        assertTrue("Should be true.", uml.containsDiagram(this.diagram));
    }

    /**
     * Test method for containsDiagram(Diagram) with null parameter.
     * IllegalArgumentException is expected.
     */
    public void testContainsDiagramNull() {
        try {
            uml.containsDiagram(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for indexOfDiagram(Diagram) with null element.
     * IllegalArgumentException is expected.
     */
    public void testIndexOfDiagramNull() {
        try {
            uml.indexOfDiagram(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for indexOfDiagram(Diagram) without containing diagram.
     */
    public void testIndexOfDiagramWithout() {
        assertEquals("Should be equal.", -1, uml.indexOfDiagram(this.diagram));
    }

    /**
     * Test method for indexOfDiagram(Diagram).
     */
    public void testIndexOfDiagram() {
        uml.addDiagram(this.diagram);
        assertEquals("Should be 0.", 0, uml.indexOfDiagram(this.diagram));
    }

    /**
     * Test method for countDiagrams().
     */
    public void testCountDiagrams() {
        uml.addDiagram(this.diagram);
        uml.addDiagram(new Diagram());
        assertEquals("Should be 2.", 2, uml.countDiagrams());
    }

    /**
     * Test method for isDiagramsEmpty() with empty list.
     */
    public void testIsDiagramsEmptyTrue() {
        assertTrue("Should be true.", uml.isDiagramsEmpty());
    }

    /**
     * Test method for isDiagramsEmpty() with non-empty list.
     */
    public void testIsDiagramsEmptyFalse() {
        uml.addDiagram(this.diagram);
        assertFalse("Should be false.", uml.isDiagramsEmpty());
    }

    /**
     * Test method for getProjectConfigurationManager() with
     * projectConfigurationManager not setting. IllegalStateException is
     * expected.
     */
    public void testGetProjectConfigurationManagerNotSet() {
        try {
            uml.getProjectConfigurationManager();
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            // ok.
        }
    }

    /**
     * Test method for getProjectConfigurationManager().
     */
    public void testGetProjectConfigurationManager() {
        uml.setProjectConfigurationManager(this.ProjectConfigurationManager);
        assertEquals("Should be equal.", this.ProjectConfigurationManager, uml.getProjectConfigurationManager());
    }

    /**
     * Test method for
     * setProjectConfigurationManager(ProjectConfigurationManager) with null
     * parameter. IllegalArgumentException is expected.
     */
    public void testSetProjectConfigurationManagerNull() {
        try {
            uml.setProjectConfigurationManager(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for
     * setProjectConfigurationManager(ProjectConfigurationManager).
     */
    public void testSetProjectConfigurationManager() {
        uml.setProjectConfigurationManager(this.ProjectConfigurationManager);
        assertEquals("Should be equal.", this.ProjectConfigurationManager, uml.getProjectConfigurationManager());
    }

    /**
     * Test method for getProjectLanguage() with no projectLanguage setting.
     * null will be returned.
     */
    public void testGetProjectLanguageNotSet() {
        assertEquals("Should be equal.", null, uml.getProjectLanguage());
    }

    /**
     * Test method for getProjectLanguage().
     */
    public void testGetProjectLanguage() {
        uml.setProjectLanguage(this.projectLanguage);
        assertEquals("Should be equal.", this.projectLanguage, uml.getProjectLanguage());
    }

    /**
     * Test method for setProjectLanguage(String) with null parameter.
     */

    public void testSetProjectLanguageNull() {
        uml.setProjectLanguage(null);
        assertEquals("Should be equal.", null, uml.getProjectLanguage());
    }

    /**
     * Test method for setProjectLanguage(String) with empty String.
     * IllegalArgumentException is expected.
     */
    public void testSetProjectLanguageEmpty() {
        try {
            uml.setProjectLanguage("        ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method for setProjectLanguage(String).
     */
    public void testSetProjectLanguage() {
        uml.setProjectLanguage(this.projectLanguage);
        assertEquals("Should be equal.", this.projectLanguage, uml.getProjectLanguage());
    }

}
