/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager.stresstests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * This is the stress tests for class UMLModelManager.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class UMLModelManagerStressTests extends TestCase {
    /**
     * <p>
     * UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * This is a list of ActivityGraph for testing.
     */
    private List<ActivityGraph> activityGraphsList;

    /**
     * This is a list of Diagram for testing.
     */
    private List<Diagram> diagramsList;

    /**
     * Sets up testing environment.
     */
    protected void setUp() {
        manager = new UMLModelManager();
        // prepares data for stress testing.
        activityGraphsList = new ArrayList<ActivityGraph>();
        for (int i = 0; i < 10000; i++) {
            activityGraphsList.add(new ActivityGraphImpl());
        }
        for (int i = 0; i < 10000; i++) {
            activityGraphsList.add(activityGraphsList.get(0));
        }

        diagramsList = new ArrayList<Diagram>();
        for (int i = 0; i < 10000; i++) {
            diagramsList.add(new Diagram());
        }
        for (int i = 0; i < 10000; i++) {
            diagramsList.add(diagramsList.get(0));
        }
    }

    /**
     * <p>
     * This is the stress tests for method: addActivityGraphs(Collection<ActivityGraph>).
     * </p>
     */
    public void testAddActivityGraphs1Stress() {
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (ActivityGraph activityGraph : activityGraphsList) {
            manager.addActivityGraphs(Collections.singletonList(activityGraph));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<ActivityGraph> innerList = manager.getActivityGraphs();
        assertEquals("Fail to implement method addActivityGraphs(Collection<ActivityGraph>).",
            10000, innerList.size());
        for (int i = 0; i < 10000; i++) {
            assertEquals("Fail to implement method addActivityGraphs(Collection<ActivityGraph>).",
                activityGraphsList.get(i), innerList.get(i));
        }
        System.out
            .println("Stress test for method---addActivityGraphs(Collection<ActivityGraph>): "
                + "adding 20000 ActivityGraph instances with 10000 Duplicates costs: "
                + (endTime - startTime) + "ms.");
    }

    /**
     * <p>
     * This is the stress tests for method: addActivityGraphs(int, Collection<ActivityGraph>).
     * </p>
     */
    public void testAddActivityGraphs2Stress() {
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (ActivityGraph activityGraph : activityGraphsList) {
            manager.addActivityGraphs(0, Collections.singletonList(activityGraph));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<ActivityGraph> innerList = manager.getActivityGraphs();
        assertEquals("Fail to implement method addActivityGraphs(int, Collection<ActivityGraph>).",
            10000, innerList.size());
        for (int i = 0; i < 10000; i++) {
            assertEquals(
                "Fail to implement method addActivityGraphs(int, Collection<ActivityGraph>).",
                activityGraphsList.get(9999 - i), innerList.get(i));
        }
        System.out
            .println("Stress test for method---addActivityGraphs(int, Collection<ActivityGraph>): "
                + "adding 20000 ActivityGraph instances with 10000 Duplicates costs: "
                + (endTime - startTime) + "ms.");
    }

    /**
     * <p>
     * This is the stress tests for method: removeActivityGraphs(Collection<ActivityGraph>).
     * </p>
     */
    public void testRemoveActivityGraphsStress() {
        manager.addActivityGraphs(activityGraphsList);
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (ActivityGraph activityGraph : activityGraphsList) {
            manager.removeActivityGraphs(Collections.singletonList(activityGraph));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<ActivityGraph> innerList = manager.getActivityGraphs();
        assertEquals("Fail to implement method removeActivityGraphs(Collection<ActivityGraph>).",
            0, innerList.size());

        System.out
            .println("Stress test for method---removeActivityGraphs(Collection<ActivityGraph>): "
                + "invoking 20000 times costs: " + (endTime - startTime) + "ms.");
    }

    /**
     * <p>
     * This is the stress tests for method: addDiagrams(Collection<Diagram>).
     * </p>
     */
    public void testAddDiagrams1Stress() {
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (Diagram diagram : diagramsList) {
            manager.addDiagrams(Collections.singletonList(diagram));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<Diagram> innerList = manager.getDiagrams();
        assertEquals("Fail to implement method addDiagrams(Collection<Diagram>).", 10000, innerList
            .size());
        for (int i = 0; i < 10000; i++) {
            assertEquals("Fail to implement method addDiagrams(Collection<Diagram>).", diagramsList
                .get(i), innerList.get(i));
        }
        System.out.println("Stress test for method---addDiagrams(Collection<Diagram>): "
            + "adding 20000 Diagram instances with 10000 Duplicates costs: "
            + (endTime - startTime) + "ms.");
    }

    /**
     * <p>
     * This is the stress tests for method: addDiagrams(int, Collection<Diagram>).
     * </p>
     */
    public void testAddDiagrams2Stress() {
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (Diagram diagram : diagramsList) {
            manager.addDiagrams(0, Collections.singletonList(diagram));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<Diagram> innerList = manager.getDiagrams();
        assertEquals("Fail to implement method addDiagrams(int, Collection<Diagram>).", 10000,
            innerList.size());
        for (int i = 0; i < 10000; i++) {
            assertEquals("Fail to implement method addDiagrams(int, Collection<Diagram>).",
                diagramsList.get(9999 - i), innerList.get(i));
        }
        System.out.println("Stress test for method---addDiagrams(int, Collection<Diagram>): "
            + "adding 20000 Diagram instances with 10000 Duplicates costs: "
            + (endTime - startTime) + "ms.");
    }

    /**
     * <p>
     * This is the stress tests for method: removeDiagrams(Collection<Diagram>).
     * </p>
     */
    public void testRemoveDiagramsStress() {
        manager.addDiagrams(diagramsList);
        // starts the stress test
        long startTime = System.currentTimeMillis();
        for (Diagram activityGraph : diagramsList) {
            manager.removeDiagrams(Collections.singletonList(activityGraph));
        }
        long endTime = System.currentTimeMillis();

        // checks the result
        List<Diagram> innerList = manager.getDiagrams();
        assertEquals("Fail to implement method removeDiagrams(Collection<Diagram>).", 0, innerList
            .size());

        System.out.println("Stress test for method---removeDiagrams(Collection<Diagram>): "
            + "invoking 20000 times costs: " + (endTime - startTime) + "ms.");
    }
}
