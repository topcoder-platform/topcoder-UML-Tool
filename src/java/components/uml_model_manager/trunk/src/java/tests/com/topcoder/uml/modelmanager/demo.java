/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * This class demonstrate the usage of UMLModelManager.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class demo {
    /**
     * The UMLModelManager for demonstration.
     */
    private UMLModelManager umlModelManager;

    /**
     * The ProjectConfigurationManager for demonstration.
     */
    private ProjectConfigurationManager projectConfigurationManager = new ProjectConfigurationManager();

    /**
     * The Model for demonstration.
     */
    private Model model;

    /**
     * The instanceName for demonstration.
     */
    private String instanceName = "New Instance";

    /**
     * The ProjectLanguage for demonstration.
     */
    private String projectLanguage = "Java";

    /**
     * The index used in addXXX(), setXXX() or removeXXX() methods.
     */
    private int index = 0;

    /**
     * The number of the elements in the return collection.
     */
    private int count = 0;

    /**
     * The status which denotes if the collection is empty.
     */
    private boolean status = false;

    /**
     * The activityGraph use in addActivityGraph, setActivityGraph or
     * removeActivityGraph method.
     */
    private ActivityGraph activityGraph = new ActivityGraphImpl();

    /**
     * The activityGraphs collection used in addActivityGraphs or
     * removeActivityGraphs.
     */
    private Collection<ActivityGraph> activityGraphs = new ArrayList<ActivityGraph>();

    /**
     * The activityGraphList used in addActivityGraphs or removeActivityGraphs.
     */
    private List<ActivityGraph> activityGraphList = new ArrayList<ActivityGraph>();

    /**
     * The diagram used in addDiagram(), setDiagram or removeDiagram method.
     */
    private Diagram diagram = new Diagram();

    /**
     * The diagram collection used in addDiagrams or removeDiagrams method.
     */
    private Collection<Diagram> diagrams = new ArrayList<Diagram>();

    /**
     * The diagramList used in addDiagrams or removeDiagrams method.
     */
    private List<Diagram> diagramList = new ArrayList<Diagram>();

    /**
     * Default constructor.
     */
    public demo() {
        // nothing to do.
    }

    /**
     * This part demonstrate all the methods which are not related to
     * activeGraphs or diagrams.
     * <ol>
     * <li>Constructors</li>
     * <li>getInstance()</li>
     * <li>getModel()</li>
     * <li>getInstanceName()</li>
     * <li>setProjectLanguage(projectLanguage)</li>
     * <li>getProjectLanguage()</li>
     * </ol>
     */
    public void demoOther() {
        // 1. Creation of UMLModelManager.

        // 1.1 Create a new UMLModelManager using a instance name.
        // The instanceName field will be set.
        umlModelManager = new UMLModelManager(instanceName);

        // 1.2 umlModelManager can be created using public static getInstance()
        // method.
        umlModelManager = UMLModelManager.getInstance();

        // 1.3 umlModelManager can be created using new
        // UMLModelManager(newInstance, projectConfigurationManager).
        // The instanceName and projectConfigurationManager field will be set.
        umlModelManager = new UMLModelManager(this.instanceName, this.projectConfigurationManager);

        // 1.4 umlModelManager can be created using new
        // UMLModelManager(newInstance, projectConfigurationManager,
        // projectLanguage).
        // The instanceName, projectConfigurationManager and projectLanguage
        // field will be set.
        umlModelManager = new UMLModelManager(this.instanceName, this.projectConfigurationManager,
            this.projectLanguage);

        // 2. Get the Model instance.
        model = umlModelManager.getModel();

        // 3. Get the ProjectConfigurationManager instance.
        projectConfigurationManager = umlModelManager.getProjectConfigurationManager();

        // 4. Get instance name.
        instanceName = umlModelManager.getInstanceName();

        // 5. Manage project language.
        // 5.1 Set project language.
        umlModelManager.setProjectLanguage(projectLanguage);

        // 5.2 Retrieve project language.
        projectLanguage = umlModelManager.getProjectLanguage();
    }

    /**
     * This part demonstrate all the methods related to activeGraphs.
     */
    public void demoActiveGraphs() {

        // 6. Manage ActivityGraphs list.

        // 6.1 Add a new ActivityGraph at the end of the activityGraphs list.
        umlModelManager.addActivityGraph(activityGraph);

        // 6.2 Add a new ActivityGraph at the specified position in the
        // activityGraphs list.
        umlModelManager.addActivityGraph(index, activityGraph);

        // 6.3 Add a collection of ActivityGraphs in the activityGraphs list.
        umlModelManager.addActivityGraphs(activityGraphs);

        // 6.4 Add a collection of ActivityGraphs at the specified position in
        // the activityGraphs list.
        umlModelManager.addActivityGraphs(index, activityGraphs);

        // 6.5 Set a ActivityGraph at the specified position in the
        // activityGraphs list.
        umlModelManager.setActivityGraph(index, activityGraph);

        // 6.6 Remove a ActivityGraph from specified position in the
        // activityGraphs list.
        umlModelManager.removeActivityGraph(index);

        // 6.7 Remove specified ActivityGraph from the activityGraphs list.
        umlModelManager.removeActivityGraph(activityGraph);

        // 6.8 Remove a Collection of ActivityGraphs from the activityGraphs
        // list.
        umlModelManager.removeActivityGraphs(activityGraphs);

        // 6.9 Clear all elements from the activityGraph list.
        umlModelManager.clearActivityGraphs();

        // 6.10 Get the list of ActivityGraphs.
        activityGraphList = umlModelManager.getActivityGraphs();

        // 6.11 Check if the specified ActivityGraph status in the
        // activityGraphs list.
        status = umlModelManager.containsActivityGraph(activityGraph);

        // 6.12 Get the index where the given ActivityGraph exist in the
        // activityGraphs list.
        index = umlModelManager.indexOfActivityGraph(activityGraph);

        // 6.13 Get the number of ActivityGraphs from the activityGraph list.
        count = umlModelManager.countActivityGraphs();

        // 6.14 Check if the activityGraphs list is empty or not.
        status = umlModelManager.isActivityGraphsEmpty();
    }

    /**
     * This part demonstrate all the methods related to diagrams.
     */
    public void demoDiagrams() {

        // 7. Manage Diagrams list.

        // 7.1 Register a new Diagram at the end of the diagrams list.
        umlModelManager.addDiagram(diagram);

        // 7.2 Register a new Diagram at the specified position in the diagrams
        // list.
        umlModelManager.addDiagram(index, diagram);

        // 7.3 Register a collection of Diagrams.
        umlModelManager.addDiagrams(diagrams);

        // 7.4 Register a collection of Diagrams at the specified position in
        // the diagrams list.
        umlModelManager.addDiagrams(index, diagrams);

        // 7.5 Set a Diagram at the specified position in the diagrams list.
        umlModelManager.setDiagram(index, diagram);

        // 7.6 Remove a Diagram from specified position in the diagrams list.
        umlModelManager.removeDiagram(index);

        // 7.7 Remove specified Diagram from the diagrams list.
        umlModelManager.removeDiagram(diagram);

        // 7.8 Remove a Collection of Diagrams from the diagrams list.
        umlModelManager.removeDiagrams(diagrams);

        // 7.9 Clear all elements from the diagram list.
        umlModelManager.clearDiagrams();

        // 7.10 Get the list of Diagrams.
        diagramList = umlModelManager.getDiagrams();

        // 7.11 Check if the specified Diagram status in the diagrams list.
        status = umlModelManager.containsDiagram(diagram);

        // 7.12 Get the index where the given Diagram exist in the diagrams
        // list.
        index = umlModelManager.indexOfDiagram(diagram);

        // 7.13 Get the number of Diagrams from the diagram list.
        count = umlModelManager.countDiagrams();

        // 7.14 Check if the diagrams list is empty or not.
        status = umlModelManager.isDiagramsEmpty();
    }
}
