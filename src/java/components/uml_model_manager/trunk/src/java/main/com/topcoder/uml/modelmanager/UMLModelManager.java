/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.modelmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * This class provides a pseudo singleton instance, for easy access inside the
 * application, as the normal usage involves just one model.
 * </p>
 * <p>
 * This class keeps a Model instance, accessible through a getter. The model is
 * initialized in the constructor with a default empty Model (new ModelImpl()).
 * </p>
 * <p>
 * <ol>
 * <li> A list of ActivityGraph instances (an ordered list) is kept in this
 * class and it is accessible through a getter. There are also methods from a
 * powerful API that manipulates the activityGraphs list that supports
 * ActivityGraph instances. </li>
 * <li>Another list of Diagram instances (an ordered list) is kept in this
 * class and it is accessible through a getter. There are also methods from a
 * powerful API that manipulates the diagrams list that supports Diagram
 * instances. </li>
 * <li>Also this class keeps a ProjectConfigurationManager instance, accessible
 * through a getter.</li>
 * </ol>
 * </p>
 * <p>
 * <strong>Thread safety</strong>: this class contains mutable fields and
 * therefore it is not thread safe.
 * </p>
 * <p>
 * <strong>Note: </strong>Even the thread-safety is not a requirement, one
 * aspect regarding thread-safety should be ensured: thread-safety should be
 * provided at the time of getInstance() if a new instance is created.
 * </p>
 *
 * @author radium, Mafy
 * @version 1.0
 */
public class UMLModelManager {

    /**
     * <p>
     * <strong>Usage: </strong>Represents the instance name to be used for the
     * singleton instance.
     * </p>
     */
    public static final String DEFAULT_INSTANCE_NAME = "Default";

    /**
     * <p>
     * <strong>Usage: </strong>Represents the name of this instance. Initialized
     * in one of the constructors and never changed afterwards. Can be retrieved
     * by public getInstanceName() method.
     * </p>
     * <p>
     * <strong>Valid values:</strong> It can not be null or empty string.
     * </p>
     */
    private final String instanceName;

    /**
     * <p>
     * <strong>Usage: </strong>Represents the project language which is set to
     * null initially.
     * </p>
     * It can be set by the methods:
     * <ol>
     * <li>UMLModelManager(String, String, ProjectConfigurationManager))</li>
     * <li>setProjectLanguage(..)</li>
     * </ol>
     * It can be retrieved in:
     * <ol>
     * <li>getProjectLanguage() method. </li>
     * </ol>
     * It is mutable.
     * <p>
     * <strong>Valid values:</strong> It can be null but can not be empty
     * string. Sample values: &quot;Java&quot;, &quot;C#&quot;.
     * </p>
     */
    private String projectLanguage = null;

    /**
     * <p>
     * <strong>Usage: </strong>Represents the static field used to keep an
     * instance of this class: UMLModelManager. Used from public static
     * getInstance() method.
     * </p>
     */
    private static final UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * <p>
     * <strong>Usage: </strong>Represents the model instance.
     * <ol>
     * <li> Initialized in one of the constructors with default
     * <em>new ModelImpl()</em></li>
     * <li> Can be retrieved by public getModel() method. </li>
     * <li> Can be set by public setModel() method.</li>
     * </p>
     * </ol>
     * <p>
     * <strong>Valid values:</strong> It can not be null.
     * </p>
     */
    private Model model;

    /**
     * <p>
     * <strong>Usage: </strong>Represents a ordered list of ActivityGraph
     * elements, which will support ActivityGraph elements.
     * </p>
     * <p>
     * It can not be null. Null or duplicate elements are not allowed. It is
     * accessed through a powerful API that contains many methods like:
     * <ol>
     * <li>addActivityGraph(..)</li>
     * <li>addActivityGraphs(..)</li>
     * <li>setActivityGraph(..)</li>
     * <li>removeActivityGraph(..)</li>
     * <li>removeActivityGraphs(..)</li>
     * <li>clearActivityGraphs()</li>
     * <li>getActivityGraphs()</li>
     * <li>containsActivityGraph(..)</li>
     * <li>indexOfActivityGraph(..)</li>
     * <li>countActivityGraphs()</li>
     * <li>isActivityGraphsEmpty(..)</li>
     * </ol>
     * </p>
     */
    private final List<ActivityGraph> activityGraphs = new ArrayList<ActivityGraph>();

    /**
     * <p>
     * <strong>Usage: </strong>Represents a ordered list of Diagram elements,
     * which will support Diagram elements.
     * </p>
     * <p>
     * It can not be null. Null or duplicate elements are not allowed. It is
     * accessed thru a powerful API that contains many methods like:
     * <ol>
     * <li>addDiagram(..)</li>
     * <li>addDiagrams(..)</li>
     * <li>setDiagram(..)</li>
     * <li>removeDiagram(..)</li>
     * <li>removeDiagrams(..)</li>
     * <li>clearDiagrams()</li>
     * <li>getDiagrams()</li>
     * <li>containsDiagram(..)</li>
     * <li>indexOfDiagram(..)</li>
     * <li>countDiagrams()</li>
     * <li>isDiagramsEmpty(..)</li>
     * </ol>
     * </p>
     */
    private final List<Diagram> diagrams = new ArrayList<Diagram>();

    /**
     * <p>
     * <strong>Usage: </strong>Represents the projectConfigurationManager
     * instance, which is set to null initially.
     * </p>
     * <p>
     * It is initialized in one of the constructors:
     * <ol>
     * <li>UMLModelManager(String, ProjectConfigurationManager)</li>
     * <li>UMLModelManager(String, ProjectConfigurationManager, String)</li>
     * </ol>
     * It will not be changed afterwards.
     * </p>
     * <p>
     * It can be retrieved by
     * <ol>
     * <li>getProjectConfigurationManager() method.</li>
     * </ol>
     * </p>
     * <p>
     * <strong>Valid values:</strong> It can not be set to null.
     * </p>
     */
    private ProjectConfigurationManager projectConfigurationManager = null;

    /**
     * <p>
     * <strong>Usage: </strong>Default constructor, which initialize the model
     * field with default empty ModelImpl and instanceName field with default
     * value DEFAULT_INSTANCE_NAME.
     * </p>
     */
    public UMLModelManager() {
        this(DEFAULT_INSTANCE_NAME);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Constructor. Initialize the model field with
     * default empty ModelImpl and instanceName field with the given value (not
     * null and not empty).
     * </p>
     *
     * @param instanceName
     *            the new instance name to use
     * @throws IllegalArgumentException
     *             if instanceName is null or empty
     */
    public UMLModelManager(String instanceName) {
        checkNull(instanceName, "instanceName");
        checkEmpty(instanceName, "instanceName");
        this.model = new ModelImpl();
        this.instanceName = instanceName;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Constructor. Initialize the model field with
     * default empty ModelImpl, the projectConfigurationManager with the given
     * parameter (not null) and instanceName field with the given value (not
     * null and not empty).
     * </p>
     *
     * @param instanceName
     *            the new instance name to use
     * @param projectConfigurationManager
     *            the new ProjectConfigurationManager to use
     * @throws IllegalArgumentException
     *             if instanceName or projectConfigurationManager is null.
     * @throws IllegalArgumentException
     *             if instanceName is empty
     */
    public UMLModelManager(String instanceName, ProjectConfigurationManager projectConfigurationManager) {
        this(instanceName);
        this.setProjectConfigurationManager(projectConfigurationManager);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Initialize the model field with default empty
     * ModelImpl, the projectConfigurationManager with the given parameter (not
     * null),instanceName field with the given value (not null and not empty)
     * and projectLanguage with the given value (can be null but not empty).
     * </p>
     *
     * @param instanceName
     *            the new instance name to use
     * @param projectConfigurationManager
     *            the new ProjectConfigurationManager to use
     * @param projectLanguage
     *            the new project language to use
     * @throws IllegalArgumentException
     *             if instanceName or projectConfigurationManager is null
     * @throws IllegalArgumentException
     *             if instanceName or projectLanguage is empty
     */
    public UMLModelManager(String instanceName, ProjectConfigurationManager projectConfigurationManager,
        String projectLanguage) {
        this(instanceName, projectConfigurationManager);
        this.setProjectLanguage(projectLanguage);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Static method used by this pseudo-singleton to
     * return the UMLModelManager instance from static field umlModelManager.
     * </p>
     * <p>
     * <strong>Implementation notes</strong>: this method should ensure the
     * thread-safety of umlModelManager instance when calling this method if a
     * new instance is being created. Since eager instantiation is used instead
     * of lazy instantiation, this won't be an issue so no synchronization is
     * needed on umlModelManager.
     * </p>
     *
     * @return the UMLModelManager instance
     */
    public static UMLModelManager getInstance() {
        return umlModelManager;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply return the model field. Not null.
     * </p>
     *
     * @return the Model instance
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply set the model field. Can not be set to
     * null.
     * </p>
     *
     * @param model
     *            the new model to use
     * @throws IllegalArgumentException
     *             if the model is null
     */
    public void setModel(Model model) {
        checkNull(model, "model");
        this.model = model;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply return the instanceName field (the name of
     * this instance), which can not be null or empty string.
     * </p>
     *
     * @return the name of this instance
     */
    public String getInstanceName() {
        return this.instanceName;
    }

    /**
     * <p>
     * <strong>Usage</strong>: Appends the ActivityGraph to the activityGraphs
     * list.
     * </p>
     * Duplicates or null values are not allowed.
     * <ol>
     * <li>If the ActivityGraph that should be added to the activityGraphs list
     * already exist in the list, do nothing. add only ActivityGraphs that does
     * not exist in the list to ensure that duplicates are not presented.</li>
     * <li>If the ActivityGraph that should be added is null.
     * IllegalArgumentExcetpion will be thrown.</li>
     * </ol>
     *
     * @param activityGraph
     *            the ActivityGraph to add to this list
     * @throws IllegalArgumentException
     *             if activityGraph is null
     */
    public void addActivityGraph(ActivityGraph activityGraph) {
        this.addActivityGraph(this.countActivityGraphs(), activityGraph);
    }

    /**
     * <p>
     * <strong>Usage:</strong> Adds the ActivityGraph at the index position in
     * the activityGraphs list.
     * </p>
     * <p>
     * Duplicates and null values are not allowed.
     * <ol>
     * <li>If the ActivityGraph that should be added to the activityGraphs list
     * already exist in the list, do nothing. add only ActivityGraphs that does
     * not exist in the list to ensure that duplicates are not presented.</li>
     * </ol>
     * </p>
     *
     * @param index
     *            the position to insert this ActivityGraph in this list
     * @param activityGraph
     *            the ActivityGraph to add to this list
     * @throws IllegalArgumentException
     *             if activityGraph is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > activityGraphs.size()
     */
    public void addActivityGraph(int index, ActivityGraph activityGraph) {
        checkAddIndex(index, this.activityGraphs);
        // activityGraph is checked in the constainsActivityGraphs() method.
        if (!this.containsActivityGraph(activityGraph)) {
            this.activityGraphs.add(index, activityGraph);
        }
    }

    /**
     * <p>
     * <strong>Usage: </strong>Appends the ActivityGraph instance to the
     * activityGraphs list.
     * <p>
     * Duplicates and null values are not allowed.
     * </p>
     * <ol>
     * <li>If the ActivityGraph that should be added to the activityGraphs list
     * already exist in the inner list, do nothing, add only ActivityGraphs that
     * does not exist in the list to ensure that duplicates are not presented.
     * </li>
     * </ol>
     *
     * @param activityGraphs
     *            the ActivityGraph collection to add to this list
     * @throws IllegalArgumentException
     *             if activityGraphs is null or contains null elements
     */
    public void addActivityGraphs(Collection<ActivityGraph> activityGraphs) {
        this.addActivityGraphs(this.countActivityGraphs(), activityGraphs);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Adds the ActivityGraph instances at the index
     * position in the contained activityGraphs list.
     * </p>
     * <p>
     * Duplicates and null value are not allowed.
     * <ol>
     * <li> If the ActivityGraph that should be added to the activityGraphs list
     * already exist in the list, do nothing. add only ActivityGraphs that does
     * not exist in the list to ensure that duplicates are not presented. </li>
     * </ol>
     * </p>
     *
     * @param index
     *            the position to insert this ActivityGraph collection in this
     *            list
     * @param activityGraphs
     *            the ActivityGraph collection to add to this list
     * @throws IllegalArgumentException
     *             if activityGraphs is null or contains null elements
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > countActivityGraphs()
     */
    public void addActivityGraphs(int index, Collection<ActivityGraph> activityGraphs) {
        checkAddIndex(index, this.activityGraphs);
        checkCollection(activityGraphs, "activityGraphs");
        int toAddIndex = index;
        for (ActivityGraph activityGraph : activityGraphs) {
            /*
             * add the elements of activityGraphs which is not in
             * thethis.activityGraphs list. Note that: the implementation
             * suggested by the designer will fail the test case like:
             * Collection<ActivityGraph> activityGraph = {graph, graph}; (The
             * passing activityGraphs contains duplicate elements).
             */
            if (!this.containsActivityGraph(activityGraph)) {
                this.addActivityGraph(toAddIndex, activityGraph);
                toAddIndex++;
            }
        }
    }

    /**
     * <strong>Usage: </strong>Sets the ActivityGraph at the index position in
     * the activityGraphs list.
     * <p>
     * Duplicates and null values are not allowed.
     * </p>
     * <ol>
     * <li> If the ActivityGraph that should be set to the activityGraphs list
     * already exist in the list, do nothing. Set only ActivityGraphs that does
     * not exist in the list to ensure that duplicates are not presented. </li>
     * </ol>
     *
     * @param index
     *            the position to set this ActivityGraph in this list
     * @param activityGraph
     *            the ActivityGraph to set in this list
     * @throws IllegalArgumentException
     *             if activityGraph is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= activityGraphs.size()
     */
    public void setActivityGraph(int index, ActivityGraph activityGraph) {
        checkSetIndex(index, this.activityGraphs);
        // activityGraph is checked in containsActivityGraph.
        if (!this.containsActivityGraph(activityGraph)) {
            this.activityGraphs.set(index, activityGraph);
        }
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the ActivityGraph instance at the index
     * position from the activityGraphs list.
     * </p>
     *
     * @param index
     *            the position of the ActivityGraph in this list to remove
     * @return the removed ActivityGraph
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= activityGraphs.size()
     */
    public ActivityGraph removeActivityGraph(int index) {
        checkSetIndex(index, this.activityGraphs);
        return this.activityGraphs.remove(index);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the instance, by reference, of the passed
     * ActivityGraph, from the activityGraphs list.
     * </p>
     *
     * @param activityGraph
     *            the ActivityGraph to remove from this list
     * @return true if the instance was in the list and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         list
     * @throws IllegalArgumentException
     *             if activityGraph is null
     */
    public boolean removeActivityGraph(ActivityGraph activityGraph) {
        checkNull(activityGraph, "activityGraph");
        return this.activityGraphs.remove(activityGraph);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the instance, by reference, of each
     * passed ActivityGraph from the contained activityGraphs list.
     * </p>
     *
     * @param activityGraphs
     *            Collection of ActivityGraph instances to remove from the
     *            contained list
     * @return true if the state of the contained activityGraphs list has
     *         changed, false otherwise
     * @throws IllegalArgumentException
     *             if activityGraphs is null or it contains null elements
     */
    public boolean removeActivityGraphs(Collection<ActivityGraph> activityGraphs) {
        checkCollection(activityGraphs, "activityGraphs");
        return this.activityGraphs.removeAll(activityGraphs);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes all elements from the activityGraphs
     * list.
     * </p>
     */
    public void clearActivityGraphs() {
        this.activityGraphs.clear();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Returns a shallow copy of the activityGraphs
     * list.
     * </p>
     *
     * @return shallow copy of the activityGraphs list
     */
    public List<ActivityGraph> getActivityGraphs() {
        return new ArrayList<ActivityGraph>(this.activityGraphs);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Checks if the ActivityGraph is contained in the
     * activityGraphs list. The check is done by reference.
     * </p>
     *
     * @param activityGraph
     *            the ActivityGraph to check for its presence in this list
     * @return true if the ActivityGraph is in the list, false otherwise
     * @throws IllegalArgumentException
     *             if activityGraph is null
     */
    public boolean containsActivityGraph(ActivityGraph activityGraph) {
        checkNull(activityGraph, "activityGraph");
        return this.activityGraphs.contains(activityGraph);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Gets the index of the appearance of the
     * ActivityGraph, by reference, in the activityGraphs list. It will return
     * -1 if the ActivityGraph instance is not in the list.
     * </p>
     *
     * @param activityGraph
     *            the ActivityGraph instance to look for
     * @return the index of the ActivityGraph instance in the list, or -1 if not
     *         found
     * @throws IllegalArgumentException
     *             if activityGraph is null
     */
    public int indexOfActivityGraph(ActivityGraph activityGraph) {
        checkNull(activityGraph, "activityGraph");
        return this.activityGraphs.indexOf(activityGraph);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Returns the size of the activityGraphs list.
     * </p>
     *
     * @return the number of elements in the activityGraphs list
     */
    public int countActivityGraphs() {
        return this.activityGraphs.size();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Check if activityGraphs list is empty.
     * </p>
     *
     * @return true if this list has no elements; false otherwise
     */
    public boolean isActivityGraphsEmpty() {
        return this.activityGraphs.isEmpty();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Appends the Diagram to the diagrams list.
     * Duplicates or null values are not allowed.
     * </p>
     *
     * @param diagram
     *            the Diagram to add to this list
     * @throws IllegalArgumentException
     *             if diagram is null
     */
    public void addDiagram(Diagram diagram) {
        this.addDiagram(this.countDiagrams(), diagram);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Adds the Diagram at the index position in the
     * diagrams list.
     * </p>
     * <P>
     * Duplicates and null values are not allowed.
     * </p>
     * <ol>
     * <li>If the Diagram that should be added to the diagrams list already
     * exist in the list, do nothing. Add only Diagrams that does not exist in
     * the list to ensure that duplicates are not presented.</li>
     * </ol>
     *
     * @param index
     *            the position to insert this Diagram in this list
     * @param diagram
     *            the Diagram to add to this list
     * @throws IllegalArgumentException
     *             if diagram is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > diagrams.size()
     */
    public void addDiagram(int index, Diagram diagram) {
        checkAddIndex(index, this.diagrams);
        // diagram is checked in containsDiagram method.
        if (!this.containsDiagram(diagram)) {
            this.diagrams.add(index, diagram);
        }
    }

    /**
     * <p>
     * <strong>Usage: </strong>Appends the Diagram instance to the diagrams
     * list. Duplicates and null values are not allowed.
     * </p>
     * <ol>
     * <li>If the Diagram that should be added to the diagrams list already
     * exist in the list, do nothing. Add only Diagrams that does not exist in
     * the list to ensure that duplicates are not presented.</li>
     * </ol>
     *
     * @param diagrams
     *            the Diagram collection to add to this list
     * @throws IllegalArgumentException
     *             if diagrams is null or contains null elements
     */
    public void addDiagrams(Collection<Diagram> diagrams) {
        this.addDiagrams(this.countDiagrams(), diagrams);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Adds the Diagram instances at the index position
     * in the contained diagrams list. &nbsp;<span style='mso-ansi-language:
     * EN-US; mso-fareast-font-family: "Times New Roman"; mso-bidi-language:
     * AR-SA; mso-fareast-language: EN-US'>If the Diagram that should be added
     * to the diagrams list already exist in the list do nothing, add only
     * Diagrams that does not exist in the list to ensure that duplicates are
     * not presented.</span><!--EndFragment--> Duplicates and null values are
     * not allowed. Note that adding at index = countDiagrams() is equivalent to
     * calling addDiagrams(diagrams).
     * </p>
     *
     * @param index
     *            the position to insert this Diagram collection in this list
     * @param diagrams
     *            the Diagram collection to add to this list
     * @throws IllegalArgumentException
     *             if diagrams is null or contains null elements
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > countDiagrams()
     */
    public void addDiagrams(int index, Collection<Diagram> diagrams) {
        checkAddIndex(index, this.diagrams);
        checkCollection(diagrams, "diagrams");

        int toAddIndex = index;

        for (Diagram diagram : diagrams) {
            /*
             * add the elements of diagrams which is not in the this.diagram
             * list. Note that: the implementation suggested by the designer
             * will fail the test case like: Collection<Diagram> diagrams =
             * {diagram, diagram}; (The passing diagrams contains duplicate
             * elements).
             */
            if (!this.containsDiagram(diagram)) {
                this.addDiagram(toAddIndex, diagram);
                toAddIndex++;
            }
        }
    }

    /**
     * <p>
     * <strong>Usage: </strong>Sets the Diagram at the index position in the
     * diagrams list.
     * <p>
     * Duplicate and null values are not allowed.
     * </p>
     * <ol>
     * <li> If the diagram that should be set to the diagrams list already exist
     * in the list, do nothing. Add only Diagrams that does not exist in the
     * list to ensure that duplicates are not presented.
     *
     * @param index
     *            the position to set this Diagram in this list
     * @param diagram
     *            the Diagram to set in this list
     * @throws IllegalArgumentException
     *             if diagram is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= diagrams.size()
     */
    public void setDiagram(int index, Diagram diagram) {
        checkSetIndex(index, this.diagrams);
        // diagram is checked in containsDiagram().
        if (!this.containsDiagram(diagram)) {
            this.diagrams.set(index, diagram);
        }
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the Diagram instance at the index
     * position from the diagrams list.
     * </p>
     *
     * @param index
     *            the position of the Diagram in this list to remove
     * @return the removed Diagram
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= diagrams.size()
     */
    public Diagram removeDiagram(int index) {
        checkSetIndex(index, this.diagrams);
        return this.diagrams.remove(index);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the instance, by reference, of the passed
     * Diagram, from the diagrams list.
     * </p>
     *
     * @param diagram
     *            the Diagram to remove from this list
     * @return true if the instance was in the list and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         list
     * @throws IllegalArgumentException
     *             if diagram is null
     */
    public boolean removeDiagram(Diagram diagram) {
        checkNull(diagram, "diagram");
        return this.diagrams.remove(diagram);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes the instance, by reference, of each
     * passed Diagram from the contained diagrams list. It will iterate via the
     * passed collection using its iterator and remove the instance, by
     * reference, of each passed Diagram, from the contained diagrams list.
     * </p>
     *
     * @param diagrams
     *            Collection of Diagram instances to remove from the contained
     *            list
     * @return true if the state of the contained diagrams list has changed,
     *         false otherwise
     * @throws IllegalArgumentException
     *             if diagrams is null or it contains null elements
     */
    public boolean removeDiagrams(Collection<Diagram> diagrams) {
        checkCollection(diagrams, "diagrams");
        return this.diagrams.removeAll(diagrams);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Removes all elements from the diagrams list.
     * </p>
     */
    public void clearDiagrams() {
        this.diagrams.clear();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Returns a shallow copy of the diagrams list.
     * </p>
     *
     * @return shallow copy of the diagrams list
     */
    public List<Diagram> getDiagrams() {
        return new ArrayList<Diagram>(this.diagrams);
    }

    /**
     * <strong>Usage: </strong>Checks if the Diagram is contained in the
     * diagrams list. The check is done by reference.
     *
     * @param diagram
     *            the Diagram to check for its presence in this list
     * @return true if the Diagram is in the list, false otherwise
     * @throws IllegalArgumentException
     *             if diagram is null
     */
    public boolean containsDiagram(Diagram diagram) {
        checkNull(diagram, "diagram");
        return this.diagrams.contains(diagram);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Gets the index of the appearance of the Diagram,
     * by reference, in the diagrams list. It will return -1 if the Diagram
     * instance is not in the list.
     * </p>
     *
     * @param diagram
     *            Diagram instance to look for
     * @return the index of the Diagram instance in the list, or -1 if not found
     * @throws IllegalArgumentException
     *             if diagram is null
     */
    public int indexOfDiagram(Diagram diagram) {
        checkNull(diagram, "diagram");
        return this.diagrams.indexOf(diagram);
    }

    /**
     * <p>
     * <strong>Usage: </strong>Returns the size of the diagrams list.
     * </p>
     *
     * @return the number of elements in the diagrams list
     */
    public int countDiagrams() {
        return this.diagrams.size();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Tests if diagrams list has no elements.
     * </p>
     *
     * @return true if this list has no elements; false otherwise
     */
    public boolean isDiagramsEmpty() {
        return this.diagrams.isEmpty();
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply return the projectConfigurationManager
     * field. If it was not set (if it is null) throw a IllegalStateException.
     * </p>
     *
     * @return the ProjectConfigurationManager instance
     * @throws IllegalStateException
     *             if the projectConfigurationManager was not set yet
     */
    public ProjectConfigurationManager getProjectConfigurationManager() {
        if (this.projectConfigurationManager == null) {
            throw new IllegalStateException("projectConfigrurationManager has not been set yet.");
        }
        return this.projectConfigurationManager;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply set the projectConfigurationManager field.
     * </p>
     *
     * @param projectConfigurationManager
     *            the new projectConfigurationManager to use
     * @throws IllegalArgumentException
     *             if the projectConfigurationManager is null
     */
    public void setProjectConfigurationManager(ProjectConfigurationManager projectConfigurationManager) {
        checkNull(projectConfigurationManager, "projectConfigurationManager");
        this.projectConfigurationManager = projectConfigurationManager;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply return the projectLanguage field. Possible
     * null but can not be empty string.
     * </p>
     *
     * @return the projectLanguage field
     */
    public String getProjectLanguage() {
        return this.projectLanguage;
    }

    /**
     * <p>
     * <strong>Usage: </strong>Simply set the projectLanguage field. Can be set
     * to null but can not be empty.
     * </p>
     *
     * @param projectLanguage
     *            the new project language to use
     * @throws IllegalArgumentException
     *             if the projectLanguage is empty
     */
    public void setProjectLanguage(String projectLanguage) {
        if (projectLanguage != null) {
            checkEmpty(projectLanguage, "prjectLanguage");
        }
        this.projectLanguage = projectLanguage;
    }

    /**
     * Check if the String argument is empty.
     *
     * @param arg
     *            The argument to be check.
     * @param string
     *            The string used in the exception message.
     * @throws IllegalArgumentExcetpion
     *             if arg is empty.
     */
    private void checkEmpty(String arg, String string) {
        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(string + " cannot be empty.");
        }
    }

    /**
     * Check if the argument is null.
     *
     * @param arg
     *            The argument to be check.
     * @param string
     *            The string used in the exception message.
     * @throws IllegalArgumentExcetpion
     *             if arg is null.
     */
    private void checkNull(Object arg, String string) {
        if (arg == null) {
            throw new IllegalArgumentException(string + " cannot be null.");
        }
    }

    /**
     * Check if the index is valid when adding the element to the list.
     *
     * @param index
     *            The index to be checked.
     * @param list
     *            The list to be check.
     * @throws IndexOutOfBoundsException
     *             if index is smaller than 0 or larger than the size of the
     *             list.
     */
    private void checkAddIndex(int index, List list) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index should not be less than 0 when adding the element.");
        }
        if (index > list.size()) {
            throw new IndexOutOfBoundsException(
                "Index should not be larger than the size of the List when adding the element.");
        }
    }

    /**
     * Check if the index is valid when setting or removing the elements in the
     * list.
     *
     * @param index
     *            The index to be check.
     * @param list
     *            The list in which the element will be set.
     * @throws IndexOutOfBoundsException
     *             If index is smaller than 0.
     * @throws IndexOutOfBoundsException
     *             If index is equal or larger than the size of the list.
     */
    private void checkSetIndex(int index, List list) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(
                "The index should not be smaller than 0 when setting or removing the element.");
        }
        if (index >= list.size()) {
            throw new IndexOutOfBoundsException(
                "The index should not be equal or larger than the size of the list when setting or removing the element.");
        }
    }

    /**
     * Check if the Collection is valid.
     *
     * @param collection
     *            The collection to be check.
     * @param string
     *            The string which is used in exception message.
     * @throws IllegalArgumentException
     *             If the collection is null or contains null elements.
     */
    private void checkCollection(Collection collection, String string) {
        checkNull(collection, "collection");
        if (collection.contains(null)) {
            throw new IllegalArgumentException(string + " cannot contains null element.");
        }
    }
}
