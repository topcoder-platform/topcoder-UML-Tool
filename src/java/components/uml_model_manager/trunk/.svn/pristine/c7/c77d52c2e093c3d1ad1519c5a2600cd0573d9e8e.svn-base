/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.modelmanager.UMLModelManager;
import junit.framework.TestCase;

/**
 * Failure tests for UMLModelManager class.
 * 
 * @author slion
 * @version 1.0
 */
public class UMLModelManagerFailureTests extends TestCase {
    /**
     * Represents the UMLModelManager instance for testing.
     */
    private UMLModelManager manager = null;
    
    /**
     * Represents the ProjectConfigurationManager instance for testing.
     */
    private ProjectConfigurationManager projectConfigurationManager;

    /**
     * Represents the Diagram instance for testing.
     */
    private Diagram diagram;

    /**
     * Represents the ActivityGraph instance for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * Represents the ActivityGraph arrays for testing.
     */
    private Collection<ActivityGraph> graphs;

    /**
     * Represents the Diagram arrays for testing.
     */
    private Collection<Diagram> diagrams;
    
    /**
     * Setup the test environment.
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        manager = new UMLModelManager("test");
        diagram = new Diagram();
        activityGraph = new ActivityGraphImpl();
        manager.addActivityGraph(new ActivityGraphImpl());
        manager.addDiagram(new Diagram());
        graphs = new ArrayList<ActivityGraph>();
        diagrams = new ArrayList<Diagram>();
    }

    /**
     * Teardown the test environment.
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void tearDown() throws Exception {
        manager = null;
        diagram = null;
        activityGraph = null;
        graphs = null;
        diagrams = null;
    }

    /**
     * Tests UMLModelManager(String instanceName) method with null String
     * instanceName, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager1_NullInstanceName() {
        try {
            new UMLModelManager(null);
            fail("testUMLModelManager_NullInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_NullInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName) method with empty String
     * instanceName, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager1_EmptyInstanceName() {
        try {
            new UMLModelManager("  ");
            fail("testUMLModelManager_EmptyInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_EmptyInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager) method with null String instanceName,
     * IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager2_NullInstanceName() {
        try {
            new UMLModelManager(null, projectConfigurationManager);
            fail("testUMLModelManager_NullInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_NullInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager) method with empty String instanceName,
     * IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager2_EmptyInstanceName() {
        try {
            new UMLModelManager("  ", projectConfigurationManager);
            fail("testUMLModelManager_EmptyInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_EmptyInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager) method with null
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager2_NullProjectConfigurationManager() {
        try {
            new UMLModelManager("test", null);
            fail("testUMLModelManager_NullProjectConfigurationManager is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_NullProjectConfigurationManager.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, String projectLanguage) method with null
     * String instanceName, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager3_NullInstanceName() {
        try {
            new UMLModelManager(null, projectConfigurationManager, "java");
            fail("testUMLModelManager_NullInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_NullInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, String projectLanguage) method with empty
     * String instanceName, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager3_EmptyInstanceName() {
        try {
            new UMLModelManager("  ", projectConfigurationManager, "java");
            fail("testUMLModelManager_EmptyInstanceName is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_EmptyInstanceName.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, String projectLanguage) method with null
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager3_NullProjectConfigurationManager() {
        try {
            new UMLModelManager("test", null, "java");
            fail("testUMLModelManager_NullProjectConfigurationManager is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_NullProjectConfigurationManager.");
        }
    }

    /**
     * Tests UMLModelManager(String instanceName,
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, String projectLanguage) method with empty
     * String projectLanguage, IllegalArgumentException should be thrown.
     */
    public void testUMLModelManager3_EmptyProjectLanguage() {
        try {
            new UMLModelManager("test", projectConfigurationManager, " ");
            fail("testUMLModelManager_EmptyProjectLanguage is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testUMLModelManager_EmptyProjectLanguage.");
        }
    }

    /**
     * Tests setModel(com.topcoder.uml.model.modelmanagement.Model model) method
     * with null com.topcoder.uml.model.modelmanagement.Model model,
     * IllegalArgumentException should be thrown.
     */
    public void testSetModel_NullModel() {
        try {
            manager.setModel(null);
            fail("testSetModel_NullModel is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetModel_NullModel.");
        }
    }

    /**
     * Tests
     * addActivityGraph(com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph) method with null
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraph_NullActivityGraph() {
        try {
            manager.addActivityGraph(null);
            fail("testAddActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests addActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddActivityGraph_InvalidIndex1() {
        try {
            manager.addActivityGraph(-1, activityGraph);
            fail("testAddActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests addActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddActivityGraph_InvalidIndex2() {
        try {
            manager.addActivityGraph(10, activityGraph);
            fail("testAddActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests addActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with null com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph, IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraph2_NullActivityGraph() {
        try {
            manager.addActivityGraph(0, null);
            fail("testAddActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests
     * addActivityGraphs(activityGraphs) method with null
     * activityGraphs,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraphs_NullActivityGraphs() {
        try {
            manager.addActivityGraphs(null);
            fail("testAddActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests
     * addActivityGraphs(activityGraphs) method with null
     * activityGraphs,
     * IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraphs_NullElementInActivityGraphs() {
        try {
            graphs.add(null);
            manager.addActivityGraphs(graphs);
            fail("testAddActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests addActivityGraphs(int index,
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs)
     * method with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddActivityGraphs_InvalidIndex1() {
        try {
            manager.addActivityGraphs(-1, graphs);
            fail("testAddActivityGraphs_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_InvalidIndex.");
        }
    }

    /**
     * Tests addActivityGraphs(int index,
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs)
     * method with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddActivityGraphs_InvalidIndex2() {
        try {
            manager.addActivityGraphs(-1, graphs);
            fail("testAddActivityGraphs_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_InvalidIndex.");
        }
    }

    /**
     * Tests addActivityGraphs(int index,
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs)
     * method with null com.topcoder.uml.modelmanager.Collection_ActivityGraph_
     * activityGraphs, IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraphs2_NullActivityGraphs() {
        try {
            manager.addActivityGraphs(0, (Collection<ActivityGraph>)null);
            fail("testAddActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests addActivityGraphs(int index,
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs)
     * method with null com.topcoder.uml.modelmanager.Collection_ActivityGraph_
     * activityGraphs, IllegalArgumentException should be thrown.
     */
    public void testAddActivityGraphs2_NullActivityGraphsElement() {
        try {
            graphs.add(null);
            manager.addActivityGraphs(0, graphs);
            fail("testAddActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests setActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testSetActivityGraph_InvalidIndex1() {
        try {
            manager.setActivityGraph(-1, activityGraph);
            fail("testSetActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests setActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testSetActivityGraph_InvalidIndex2() {
        try {
            manager.setActivityGraph(19, activityGraph);
            fail("testSetActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests setActivityGraph(int index,
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph) method
     * with null com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph, IllegalArgumentException should be thrown.
     */
    public void testSetActivityGraph_NullActivityGraph() {
        try {
            manager.setActivityGraph(0, null);
            fail("testSetActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests removeActivityGraph(int index) method with invalid int index,
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveActivityGraph_InvalidIndex1() {
        try {
            manager.removeActivityGraph(-1);
            fail("testRemoveActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests removeActivityGraph(int index) method with invalid int index,
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveActivityGraph_InvalidIndex2() {
        try {
            manager.removeActivityGraph(111);
            fail("testRemoveActivityGraph_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveActivityGraph_InvalidIndex.");
        }
    }

    /**
     * Tests
     * removeActivityGraph(com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph) method with null
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveActivityGraph_NullActivityGraph() {
        try {
            manager.removeActivityGraph(null);
            fail("testRemoveActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests
     * removeActivityGraphs(com.topcoder.uml.modelmanager.Collection_ActivityGraph_
     * activityGraphs) method with null
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveActivityGraphs_NullActivityGraphs() {
        try {
            manager.removeActivityGraphs(null);
            fail("testRemoveActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests
     * removeActivityGraphs(com.topcoder.uml.modelmanager.Collection_ActivityGraph_
     * activityGraphs) method with null
     * com.topcoder.uml.modelmanager.Collection_ActivityGraph_ activityGraphs element,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveActivityGraphs_NullActivityGraphElement() {
        try {
            graphs.add(null);
            manager.removeActivityGraphs(graphs);
            fail("testRemoveActivityGraphs_NullActivityGraphs is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveActivityGraphs_NullActivityGraphs.");
        }
    }

    /**
     * Tests
     * containsActivityGraph(com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph) method with null
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph,
     * IllegalArgumentException should be thrown.
     */
    public void testContainsActivityGraph_NullActivityGraph() {
        try {
            manager.containsActivityGraph(null);
            fail("testContainsActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testContainsActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests
     * indexOfActivityGraph(com.topcoder.uml.model.activitygraphs.ActivityGraph
     * activityGraph) method with null
     * com.topcoder.uml.model.activitygraphs.ActivityGraph activityGraph,
     * IllegalArgumentException should be thrown.
     */
    public void testIndexOfActivityGraph_NullActivityGraph() {
        try {
            manager.indexOfActivityGraph(null);
            fail("testIndexOfActivityGraph_NullActivityGraph is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testIndexOfActivityGraph_NullActivityGraph.");
        }
    }

    /**
     * Tests addDiagram(com.topcoder.diagraminterchange.Diagram diagram) method
     * with null com.topcoder.diagraminterchange.Diagram diagram,
     * IllegalArgumentException should be thrown.
     */
    public void testAddDiagram1_NullDiagram() {
        try {
            manager.addDiagram(null);
            fail("testAddDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagram_NullDiagram.");
        }
    }

    /**
     * Tests addDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with invalid int index, IndexOutOfBoundsException should be
     * thrown.
     */
    public void testAddDiagram2_InvalidIndex1() {
        try {
            manager.addDiagram(-1, diagram);
            fail("testAddDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests addDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with invalid int index, IndexOutOfBoundsException should be
     * thrown.
     */
    public void testAddDiagram2_InvalidIndex2() {
        try {
            manager.addDiagram(11, diagram);
            fail("testAddDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests addDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with null com.topcoder.diagraminterchange.Diagram
     * diagram, IllegalArgumentException should be thrown.
     */
    public void testAddDiagram2_NullDiagram() {
        try {
            manager.addDiagram(0, null);
            fail("testAddDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagram_NullDiagram.");
        }
    }

    /**
     * Tests addDiagrams(com.topcoder.uml.modelmanager.Collection_Diagram_
     * diagrams) method with null
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testAddDiagrams_NullDiagrams() {
        try {
            manager.addDiagrams(null);
            fail("testAddDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests addDiagrams(com.topcoder.uml.modelmanager.Collection_Diagram_
     * diagrams) method with null element in
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testAddDiagrams_NullDiagramElement() {
        try {
            diagrams.add(null);
            manager.addDiagrams(diagrams);
            fail("testAddDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests addDiagrams(int index,
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams) method with
     * invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddDiagrams2_InvalidIndex1() {
        try {
            manager.addDiagrams(-1, diagrams);
            fail("testAddDiagrams_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_InvalidIndex.");
        }
    }

    /**
     * Tests addDiagrams(int index,
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams) method with
     * invalid int index, IndexOutOfBoundsException should be thrown.
     */
    public void testAddDiagrams2_InvalidIndex2() {
        try {
            manager.addDiagrams(2, diagrams);
            fail("testAddDiagrams_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_InvalidIndex.");
        }
    }

    /**
     * Tests addDiagrams(int index,
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams) method with
     * null com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testAddDiagrams2_NullDiagrams() {
        try {
            manager.addDiagrams(0, null);
            fail("testAddDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests addDiagrams(int index,
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams) method with
     * null com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testAddDiagrams2_NullDiagramElement() {
        try {
            diagrams.add(null);
            manager.addDiagrams(0, diagrams);
            fail("testAddDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testAddDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests setDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with invalid int index, IndexOutOfBoundsException should be
     * thrown.
     */
    public void testSetDiagram_InvalidIndex1() {
        try {
            manager.setDiagram(-1, diagram);
            fail("testSetDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests setDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with invalid int index, IndexOutOfBoundsException should be
     * thrown.
     */
    public void testSetDiagram_InvalidIndex2() {
        try {
            manager.setDiagram(1, diagram);
            fail("testSetDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests setDiagram(int index, com.topcoder.diagraminterchange.Diagram
     * diagram) method with null com.topcoder.diagraminterchange.Diagram
     * diagram, IllegalArgumentException should be thrown.
     */
    public void testSetDiagram_NullDiagram() {
        try {
            manager.setDiagram(0, null);
            fail("testSetDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetDiagram_NullDiagram.");
        }
    }

    /**
     * Tests removeDiagram(int index) method with invalid int index,
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveDiagram_InvalidIndex1() {
        try {
            manager.removeDiagram(-1);
            fail("testRemoveDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests removeDiagram(int index) method with invalid int index,
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveDiagram_InvalidIndex2() {
        try {
            manager.removeDiagram(1);
            fail("testRemoveDiagram_InvalidIndex is failure.");
        } catch (IndexOutOfBoundsException ioobe) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveDiagram_InvalidIndex.");
        }
    }

    /**
     * Tests removeDiagram(com.topcoder.diagraminterchange.Diagram diagram)
     * method with null com.topcoder.diagraminterchange.Diagram diagram,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveDiagram_NullDiagram() {
        try {
            manager.removeDiagram(null);
            fail("testRemoveDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveDiagram_NullDiagram.");
        }
    }

    /**
     * Tests removeDiagrams(com.topcoder.uml.modelmanager.Collection_Diagram_
     * diagrams) method with null
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveDiagrams_NullDiagrams() {
        try {
            manager.removeDiagrams(null);
            fail("testRemoveDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests removeDiagrams(com.topcoder.uml.modelmanager.Collection_Diagram_
     * diagrams) method with null
     * com.topcoder.uml.modelmanager.Collection_Diagram_ diagrams,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveDiagrams_NullDiagramElement() {
        try {
            diagrams.add(null);
            manager.removeDiagrams(diagrams);
            fail("testRemoveDiagrams_NullDiagrams is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testRemoveDiagrams_NullDiagrams.");
        }
    }

    /**
     * Tests containsDiagram(com.topcoder.diagraminterchange.Diagram diagram)
     * method with null com.topcoder.diagraminterchange.Diagram diagram,
     * IllegalArgumentException should be thrown.
     */
    public void testContainsDiagram_NullDiagram() {
        try {
            manager.containsDiagram(null);
            fail("testContainsDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testContainsDiagram_NullDiagram.");
        }
    }

    /**
     * Tests indexOfDiagram(com.topcoder.diagraminterchange.Diagram diagram)
     * method with null com.topcoder.diagraminterchange.Diagram diagram,
     * IllegalArgumentException should be thrown.
     */
    public void testIndexOfDiagram_NullDiagram() {
        try {
            manager.indexOfDiagram(null);
            fail("testIndexOfDiagram_NullDiagram is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testIndexOfDiagram_NullDiagram.");
        }
    }

    /**
     * Tests
     * getProjectConfigurationManager() method with null 
     * projectConfigurationManager set , IllegalStateException should be thrown.
     */
    public void testGetProjectConfigurationManager_NullProjectConfigurationManager() {
        try {
            manager.getProjectConfigurationManager();
            fail("testGetProjectConfigurationManager_NullProjectConfigurationManager is failure.");
        } catch (IllegalStateException ise) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testGetProjectConfigurationManager_NullProjectConfigurationManager.");
        }
    }

    /**
     * Tests
     * setProjectConfigurationManager(com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager) method with null
     * com.topcoder.uml.projectconfiguration.ProjectConfigurationManager
     * projectConfigurationManager, IllegalArgumentException should be thrown.
     */
    public void testSetProjectConfigurationManager_NullProjectConfigurationManager() {
        try {
            manager.setProjectConfigurationManager(null);
            fail("testSetProjectConfigurationManager_NullProjectConfigurationManager is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetProjectConfigurationManager_NullProjectConfigurationManager.");
        }
    }

    /**
     * Tests setProjectLanguage(String projectLanguage) method with empty String
     * projectLanguage, IllegalArgumentException should be thrown.
     */
    public void testSetProjectLanguage_EmptyProjectLanguage() {
        try {
            manager.setProjectLanguage("  ");
            fail("testSetProjectLanguage_EmptyProjectLanguage is failure.");
        } catch (IllegalArgumentException iae) {
            // pass
        } catch (Exception e) {
            fail("Unknow exception occurs in testSetProjectLanguage_EmptyProjectLanguage.");
        }
    }
}