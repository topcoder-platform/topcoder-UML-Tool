/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for UMLModelManager class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class UMLModelManagerAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * This instance is used in the test.
     */
    private ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager();

    /**
     * This instance is used in the test.
     */
    private String instanceName = "test";

    /**
     * This instance is used in the test.
     */
    private String language = "CSharp";

    /**
     * This instance is used in the test.
     */
    private ActivityGraph activityGraph1 = new ActivityGraphImpl();

    /**
     * This instance is used in the test.
     */
    private ActivityGraph activityGraph2 = new ActivityGraphImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<ActivityGraph> activityGraphs = new ArrayList<ActivityGraph>();

    /**
     * This instance is used in the test.
     */
    private Diagram diagram1 = new Diagram();

    /**
     * This instance is used in the test.
     */
    private Diagram diagram2 = new Diagram();

    /**
     * This instance is used in the test.
     */
    private Collection<Diagram> diagrams = new ArrayList<Diagram>();

    /**
     * This instance is used in the test.
     */
    private Model model = new ModelImpl();

    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(UMLModelManagerAccuracyTest.class);
    }

    /**
     * Accuracy test of <code>UMLModelManager()</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUMLModelManager1Accuracy() throws Exception {
        assertEquals("default instance name is incorrect.", "Default", umlModelManager.getInstanceName());
        assertNull("default project language should be null.", umlModelManager.getProjectLanguage());
        assertNotNull("default model should not be null.", umlModelManager.getModel());
        assertEquals("diagrams count should be 0.", 0, umlModelManager.countDiagrams());
        assertEquals("activity graphs count should be 0.", 0, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of <code>UMLModelManager(String instanceName)</code>
     * constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUMLModelManager2Accuracy() throws Exception {
        umlModelManager = new UMLModelManager(instanceName);
        assertEquals("instance name is incorrect.", instanceName, umlModelManager.getInstanceName());
        assertNull("default project language should be null.", umlModelManager.getProjectLanguage());
        assertNotNull("default model should not be null.", umlModelManager.getModel());
        assertEquals("diagrams count should be 0.", 0, umlModelManager.countDiagrams());
        assertEquals("activity graphs count should be 0.", 0, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of
     * <code>UMLModelManager(String instanceName, ProjectConfigurationManager projectConfigurationManager)</code>
     * constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUMLModelManager3Accuracy() throws Exception {
        umlModelManager = new UMLModelManager(instanceName, projectConfigurationManager);
        assertEquals("instance name is incorrect.", instanceName, umlModelManager.getInstanceName());
        assertNull("default project language should be null.", umlModelManager.getProjectLanguage());
        assertNotNull("default model should not be null.", umlModelManager.getModel());
        assertEquals("diagrams count should be 0.", 0, umlModelManager.countDiagrams());
        assertEquals("activity graphs count should be 0.", 0, umlModelManager.countActivityGraphs());
        assertEquals("project configuration manager is incorrect.", projectConfigurationManager, umlModelManager
            .getProjectConfigurationManager());
    }

    /**
     * Accuracy test of
     * <code>UMLModelManager(String instanceName, ProjectConfigurationManager projectConfigurationManager,
     * String projectLanguage)</code> constructor.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testUMLModelManager4Accuracy() throws Exception {
        umlModelManager = new UMLModelManager(instanceName, projectConfigurationManager, language);
        assertEquals("instance name is incorrect.", instanceName, umlModelManager.getInstanceName());
        assertEquals("project language is incorrect.", language, umlModelManager.getProjectLanguage());
        assertEquals("diagrams count should be 0.", 0, umlModelManager.countDiagrams());
        assertEquals("activity graphs count should be 0.", 0, umlModelManager.countActivityGraphs());
        assertEquals("project configuration manager is incorrect.", projectConfigurationManager, umlModelManager
            .getProjectConfigurationManager());
        assertNotNull("default model should not be null.", umlModelManager.getModel());
    }

    /**
     * Accuracy test of <code>getInstance()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetInstanceAccuracy() throws Exception {
        umlModelManager = UMLModelManager.getInstance();
        assertEquals("default instance name is incorrect.", "Default", umlModelManager.getInstanceName());
        assertNull("default project language should be null.", umlModelManager.getProjectLanguage());
        assertNotNull("default model should not be null.", umlModelManager.getModel());
        assertEquals("diagrams count should be 0.", 0, umlModelManager.countDiagrams());
        assertEquals("activity graphs count should be 0.", 0, umlModelManager.countActivityGraphs());

        assertSame("instance should be the same.", umlModelManager, UMLModelManager.getInstance());
    }

    /**
     * Accuracy test of <code>getModel()</code> and
     * <code>setModel(Model model)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetModelAccuracy() throws Exception {
        assertNotNull("default model should not be null.", umlModelManager.getModel());
        umlModelManager.setModel(model);
        assertEquals("model is incorrect.", model, umlModelManager.getModel());
    }

    /**
     * Accuracy test of <code>getInstanceName()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetInstanceNameAccuracy() throws Exception {
        assertEquals("default instance name is incorrect.", "Default", umlModelManager.getInstanceName());
    }

    /**
     * Accuracy test of
     * <code>addActivityGraph(ActivityGraph activityGraph)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActivityGraph1Accuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertEquals("count of activity graphs should be 1.", 1, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph1 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph1));
        umlModelManager.addActivityGraph(activityGraph2);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph2 should be 1.", 1, umlModelManager
            .indexOfActivityGraph(activityGraph2));
        umlModelManager.addActivityGraph(activityGraph1);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of
     * <code>addActivityGraph(int index, ActivityGraph activityGraph)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActivityGraph2Accuracy() throws Exception {
        umlModelManager.addActivityGraph(0, activityGraph1);
        assertEquals("count of activity graphs should be 1.", 1, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph1 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph1));
        umlModelManager.addActivityGraph(0, activityGraph2);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph2 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph2));
        umlModelManager.addActivityGraph(0, activityGraph1);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph2 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph2));
    }

    /**
     * Accuracy test of
     * <code>addActivityGraphs(Collection&lt;ActivityGraph&gt; activityGraphs)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActivityGraphs1Accuracy() throws Exception {
        umlModelManager.addActivityGraphs(activityGraphs);
        assertEquals("count of activity graphs should be 0.", 0, umlModelManager.countActivityGraphs());
        activityGraphs.add(activityGraph1);
        umlModelManager.addActivityGraphs(activityGraphs);
        assertEquals("count of activity graphs should be 1.", 1, umlModelManager.countActivityGraphs());
        activityGraphs.add(activityGraph2);
        activityGraphs.add(activityGraph2);
        umlModelManager.addActivityGraphs(activityGraphs);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of
     * <code>addActivityGraphs(int index, Collection&lt;ActivityGraph&gt; activityGraphs)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddActivityGraphs2Accuracy() throws Exception {
        umlModelManager.addActivityGraphs(0, activityGraphs);
        assertEquals("count of activity graphs should be 0.", 0, umlModelManager.countActivityGraphs());
        activityGraphs.add(activityGraph1);
        umlModelManager.addActivityGraphs(0, activityGraphs);
        assertEquals("count of activity graphs should be 1.", 1, umlModelManager.countActivityGraphs());
        activityGraphs.add(activityGraph2);
        activityGraphs.add(activityGraph2);
        umlModelManager.addActivityGraphs(0, activityGraphs);
        assertEquals("count of activity graphs should be 2.", 2, umlModelManager.countActivityGraphs());
        assertEquals("index of activityGraph2 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph2));
    }

    /**
     * Accuracy test of
     * <code>setActivityGraph(int index, ActivityGraph activityGraph)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetActivityGraphAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        umlModelManager.setActivityGraph(0, activityGraph2);
        assertEquals("element of index 0 should be activityGraph2", 0, umlModelManager
            .indexOfActivityGraph(activityGraph2));
        umlModelManager.addActivityGraph(activityGraph1);
        umlModelManager.setActivityGraph(0, activityGraph1);
        assertEquals("element of index 0 should still be activityGraph2", 0, umlModelManager
            .indexOfActivityGraph(activityGraph2));
    }

    /**
     * Accuracy test of <code>removeActivityGraph(int index)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActivityGraph1Accuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertEquals("the element removed is incorrect.", activityGraph1, umlModelManager.removeActivityGraph(0));
    }

    /**
     * Accuracy test of
     * <code>removeActivityGraph(ActivityGraph activityGraph)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActivityGraph2Accuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertTrue("activityGraph1 should be removed.", umlModelManager.removeActivityGraph(activityGraph1));
        assertFalse("activityGraph1 is already removed.", umlModelManager.removeActivityGraph(activityGraph1));
    }

    /**
     * Accuracy test of
     * <code>removeActivityGraphs(Collection&lt;ActivityGraph&gt; activityGraphs)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveActivityGraphsAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        umlModelManager.addActivityGraph(activityGraph2);
        activityGraphs.add(activityGraph1);
        assertTrue("activityGraph1 should be removed.", umlModelManager.removeActivityGraphs(activityGraphs));
        assertFalse("activityGraph1 is already removed.", umlModelManager.removeActivityGraphs(activityGraphs));
        activityGraphs.add(activityGraph1);
        activityGraphs.add(activityGraph2);
        activityGraphs.add(activityGraph2);
        assertTrue("activityGraph2 should be removed.", umlModelManager.removeActivityGraphs(activityGraphs));
        assertFalse("activityGraph2 is already removed.", umlModelManager.removeActivityGraphs(activityGraphs));
    }

    /**
     * Accuracy test of <code>clearActivityGraphs()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClearActivityGraphsAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        umlModelManager.addActivityGraph(activityGraph2);
        umlModelManager.clearActivityGraphs();
        assertEquals("count of activity graphs should be 0.", 0, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of <code>getActivityGraphs()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetActivityGraphsAccuracy() throws Exception {
        activityGraphs.add(activityGraph1);
        activityGraphs.add(activityGraph2);
        umlModelManager.addActivityGraphs(activityGraphs);
        assertEquals("activityGraphs is incorrect.", activityGraphs, umlModelManager.getActivityGraphs());
        // shadow copy should be returned.
        activityGraphs = umlModelManager.getActivityGraphs();
        // clear it and check if activityGraphs in the uml model manager is
        // changed.
        activityGraphs.clear();
        assertEquals("activityGraphs in the umlModelManager should not be changed.", 2, umlModelManager
            .countActivityGraphs());
    }

    /**
     * Accuracy test of
     * <code>containsActivityGraph(ActivityGraph activityGraph)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsActivityGraphAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertTrue("should return true indicated that it contains activityGraph1.", umlModelManager
            .containsActivityGraph(activityGraph1));
        assertFalse("should return false indicated that it does not contain activityGraph2.", umlModelManager
            .containsActivityGraph(activityGraph2));
    }

    /**
     * Accuracy test of
     * <code>indexOfActivityGraph(ActivityGraph activityGraph)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfActivityGraphAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertEquals("index of activityGraph1 should be 0.", 0, umlModelManager
            .indexOfActivityGraph(activityGraph1));
        assertEquals("it should return -1 indicated that activityGraph2 is not exist.", -1, umlModelManager
            .indexOfActivityGraph(activityGraph2));
    }

    /**
     * Accuracy test of <code>countActivityGraphs()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCountActivityGraphsAccuracy() throws Exception {
        umlModelManager.addActivityGraph(activityGraph1);
        assertEquals("count of activity graphs should be 1.", 1, umlModelManager.countActivityGraphs());
    }

    /**
     * Accuracy test of <code>isActivityGraphsEmpty()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsActivityGraphsEmptyAccuracy() throws Exception {
        assertTrue("it should return true indicated that activity graphs is empty.", umlModelManager
            .isActivityGraphsEmpty());
        umlModelManager.addActivityGraph(activityGraph1);
        assertFalse("it should return false indicated that activity graphs is not empty.", umlModelManager
            .isActivityGraphsEmpty());
    }

    /**
     * Accuracy test of <code>addDiagram(Diagram diagram)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddDiagram1Accuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertEquals("count of diagrams should be 1.", 1, umlModelManager.countDiagrams());
        assertEquals("index of diagram1 should be 0.", 0, umlModelManager.indexOfDiagram(diagram1));
        umlModelManager.addDiagram(diagram2);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
        assertEquals("index of diagram2 should be 1.", 1, umlModelManager.indexOfDiagram(diagram2));
        umlModelManager.addDiagram(diagram1);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
    }

    /**
     * Accuracy test of <code>addDiagram(int index, Diagram diagram)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddDiagram2Accuracy() throws Exception {
        umlModelManager.addDiagram(0, diagram1);
        assertEquals("count of diagrams should be 1.", 1, umlModelManager.countDiagrams());
        assertEquals("index of diagram1 should be 0.", 0, umlModelManager.indexOfDiagram(diagram1));
        umlModelManager.addDiagram(0, diagram2);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
        assertEquals("index of diagram2 should be 0.", 0, umlModelManager.indexOfDiagram(diagram2));
        umlModelManager.addDiagram(0, diagram1);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
        assertEquals("index of diagram2 should be 0.", 0, umlModelManager.indexOfDiagram(diagram2));
    }

    /**
     * Accuracy test of <code>addDiagrams(Collection&lt;Diagram&gt; diagrams)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddDiagrams1Accuracy() throws Exception {
        umlModelManager.addDiagrams(diagrams);
        assertEquals("count of diagrams should be 0.", 0, umlModelManager.countDiagrams());
        diagrams.add(diagram1);
        umlModelManager.addDiagrams(diagrams);
        assertEquals("count of diagrams should be 1.", 1, umlModelManager.countDiagrams());
        diagrams.add(diagram2);
        diagrams.add(diagram2);
        umlModelManager.addDiagrams(diagrams);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
    }

    /**
     * Accuracy test of
     * <code>addDiagrams(int index, Collection&lt;Diagram&gt; diagrams)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddDiagrams2Accuracy() throws Exception {
        umlModelManager.addDiagrams(0, diagrams);
        assertEquals("count of diagrams should be 0.", 0, umlModelManager.countDiagrams());
        diagrams.add(diagram1);
        umlModelManager.addDiagrams(0, diagrams);
        assertEquals("count of diagrams should be 1.", 1, umlModelManager.countDiagrams());
        diagrams.add(diagram2);
        diagrams.add(diagram2);
        umlModelManager.addDiagrams(0, diagrams);
        assertEquals("count of diagrams should be 2.", 2, umlModelManager.countDiagrams());
        assertEquals("index of diagram2 should be 0.", 0, umlModelManager.indexOfDiagram(diagram2));
    }

    /**
     * Accuracy test of <code>setDiagram(int index, Diagram diagram)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetDiagramAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        umlModelManager.setDiagram(0, diagram2);
        assertEquals("element of index 0 should be diagram2", 0, umlModelManager.indexOfDiagram(diagram2));
        umlModelManager.addDiagram(diagram1);
        umlModelManager.setDiagram(0, diagram1);
        assertEquals("element of index 0 should still be diagram2", 0, umlModelManager.indexOfDiagram(diagram2));
    }

    /**
     * Accuracy test of <code>removeDiagram(int index)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveDiagram1Accuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertEquals("the element removed is incorrect.", diagram1, umlModelManager.removeDiagram(0));
    }

    /**
     * Accuracy test of <code>removeDiagram(Diagram diagram)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveDiagram2Accuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertTrue("diagram1 should be removed.", umlModelManager.removeDiagram(diagram1));
        assertFalse("diagram1 is already removed.", umlModelManager.removeDiagram(diagram1));
    }

    /**
     * Accuracy test of
     * <code>removeDiagrams(Collection&ltDiagram&gt; diagrams)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveDiagramsAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        umlModelManager.addDiagram(diagram2);
        diagrams.add(diagram1);
        assertTrue("diagram1 should be removed.", umlModelManager.removeDiagrams(diagrams));
        assertFalse("diagram1 is already removed.", umlModelManager.removeDiagrams(diagrams));
        diagrams.add(diagram1);
        diagrams.add(diagram2);
        diagrams.add(diagram2);
        assertTrue("diagram2 should be removed.", umlModelManager.removeDiagrams(diagrams));
        assertFalse("diagram2 is already removed.", umlModelManager.removeDiagrams(diagrams));
    }

    /**
     * Accuracy test of <code>clearDiagrams()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClearDiagramsAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        umlModelManager.addDiagram(diagram2);
        umlModelManager.clearDiagrams();
        assertEquals("count of diagrams should be 0.", 0, umlModelManager.countDiagrams());
    }

    /**
     * Accuracy test of <code>getDiagrams()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetDiagramsAccuracy() throws Exception {
        diagrams.add(diagram1);
        diagrams.add(diagram2);
        umlModelManager.addDiagrams(diagrams);
        assertEquals("diagrams is incorrect.", diagrams, umlModelManager.getDiagrams());
        // shadow copy should be returned.
        diagrams = umlModelManager.getDiagrams();
        // clear it and check if diagrams in the uml model manager is changed.
        diagrams.clear();
        assertEquals("diagrams in the umlModelManager should not be changed.", 2, umlModelManager.countDiagrams());
    }

    /**
     * Accuracy test of <code>containsDiagram(Diagram diagram)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsDiagramAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertTrue("should return true indicated that it contains diagram1.", umlModelManager
            .containsDiagram(diagram1));
        assertFalse("should return false indicated that it does not contain diagram2.", umlModelManager
            .containsDiagram(diagram2));
    }

    /**
     * Accuracy test of <code>indexOfDiagram(Diagram diagram)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfDiagramAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertEquals("index of diagram1 should be 0.", 0, umlModelManager.indexOfDiagram(diagram1));
        assertEquals("it should return -1 indicated that diagram2 is not exist.", -1, umlModelManager
            .indexOfDiagram(diagram2));
    }

    /**
     * Accuracy test of <code>countDiagrams()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCountDiagramsAccuracy() throws Exception {
        umlModelManager.addDiagram(diagram1);
        assertEquals("count of diagrams should be 1.", 1, umlModelManager.countDiagrams());
    }

    /**
     * Accuracy test of <code>isDiagramsEmpty()</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIsDiagramsEmptyAccuracy() throws Exception {
        assertTrue("it should return true indicated that diagrams is empty.", umlModelManager.isDiagramsEmpty());
        umlModelManager.addDiagram(diagram1);
        assertFalse("it should return false indicated that diagrams is not empty.", umlModelManager
            .isDiagramsEmpty());
    }

    /**
     * Accuracy test of <code>getProjectConfigurationManager()</code> and
     * <code>setProjectConfigurationManager(ProjectConfigurationManager projectConfigurationManager)</code>
     * method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetProjectConfigurationManagerAccuracy() throws Exception {
        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);
        assertEquals("project configuration manager is incorrect.", projectConfigurationManager, umlModelManager
            .getProjectConfigurationManager());
    }

    /**
     * Accuracy test of <code>getProjectLanguage()</code> and
     * <code>setProjectLanguage(String projectLanguage)</code> method.
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetSetProjectLanguageAccuracy() throws Exception {
        umlModelManager.setProjectLanguage(language);
        assertEquals("language is incorrect.", language, umlModelManager.getProjectLanguage());
        umlModelManager.setProjectLanguage(null);
        assertNull("language should be null.", umlModelManager.getProjectLanguage());
    }
}
