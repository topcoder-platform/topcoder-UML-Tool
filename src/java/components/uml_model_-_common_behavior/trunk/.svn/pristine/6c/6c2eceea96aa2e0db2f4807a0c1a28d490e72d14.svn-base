/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.procedure;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.commonbehavior.Helper;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>This is a simple concrete implementation of Procedure interface and extends ModelElementAbstractImpl
 * from the Core Requirements component. A procedure is a coordinated set of actions that models a computation,
 * such as an algorithm. It can also be used without actions to express a procedure in a textual
 * language. In the metamodel, Procedure is a subclass of ModelElement. It can be linked to a
 * Method or Expression to model how the method is carried out or the expression is evaluated.
 *  As such, all methods in Procedure are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class ProcedureImpl extends ModelElementAbstractImpl implements Procedure {
    /**
     * <p>Represents the Names the language in which the body attribute is written.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter.
     * Null and empty values are acceptable. There is no validation performed on the setter.</p>
     *
     */
    private String language = null;

    /**
     * <p>Represents The text of the procedure written in the given language.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter.
     * Null and empty values are acceptable. There is no validation performed on the setter.</p>
     *
     */
    private String body = null;

    /**
     * <p>Determines whether the arguments to the procedure are passed as attribute of a single object,
     * or are passed separately.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter.</p>
     *
     */
    private boolean list = false;

    /**
     * <p>Represents An expression the value of which is calculated by the procedure. Used to provide a
     * detailed action model for an expression.</p>
     *
     * <p>This value is set in the setter, and accessed
     *  with the getter. Null values are acceptable. There is no validation performed on the setter.</p>
     *
     */
    private Expression expression = null;

    /**
     * <p>Represents A method which is performed by the procedure. Used to provide a detailed action
     * model for a method.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Method method = null;

    /**
     * <p>Represents a collection of stimuli related to this procedure. It will support Stimulus
     * elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the
     * collection. Note that the whole collection getter will only return a copy of the collection. Null
     * values will not be allowed.</p>
     *
     */
    private final Collection<Stimulus> stimuli = new ArrayList<Stimulus>();

    /**
     * <p>Represents the Action associated with this procedure.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Action action = null;

    /**
     * <p>Empty constructor.</p>
     *
     */
    public ProcedureImpl() {
        // empty
    }

    /**
     * Gets the language field value. Could be null/empty.
     *
     *
     * @return language field value
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language field value. Null/empty is allowed.
     *
     *
     * @param language language field value
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the body field value. Could be null/empty.
     *
     *
     * @return body field value
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body field value. Null/empty is allowed.
     *
     *
     * @param body body field value
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the boolean list field value.
     *
     *
     * @return list field value
     */
    public boolean isList() {
        return list;
    }

    /**
     * Sets the boolean list field value.
     *
     *
     * @param list list field value
     */
    public void setList(boolean list) {
        this.list = list;
    }

    /**
     * Gets the expression field value. Could be null.
     *
     *
     * @return expression field value
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Sets the expression field value. Null is allowed.
     *
     *
     * @param expression expression field value
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Gets the method field value. Could be null.
     *
     *
     * @return method field value
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets the method field value. Null is allowed.
     *
     *
     * @param method method field value
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Adds the Stimulus into the stimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param stimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public void addStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");
        stimuli.add(stimulus);
    }

    /**
     * Adds the Stimulus instances into the stimuli collection. It allows duplicates.
     * The collection must not be null or contain null elements.
     *
     *
     * @param stimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public void addStimuli(Collection<Stimulus> stimuli) {
        Helper.validateCollectionNotNullNotContainNull(stimuli, "stimuli");
        this.stimuli.addAll(stimuli);
    }

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the stimuli
     *  collection. Since this is a collection, this operation does not guarantee which instance
     *  of the referenced Stimulus will be removed if there are multiple references to the same
     *  instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if
     * it was not removed, or did not exist in the collection
     * @param stimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public boolean removeStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");

        return stimuli.remove(stimulus);
    }

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained stimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced Stimulus will be removed if there are multiple references to the same instance
     * in the collection. This equally applies to the case if there are multiple duplicates in the
     * passed collection.
     *
     *
     * @return boolean True if the state of the contained stimuli collection has changed, false otherwise.
     * @param stimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public boolean removeStimuli(Collection<Stimulus> stimuli) {
        Helper.validateCollectionNotNullNotContainNull(stimuli, "stimuli");

        return Helper.removeAllFromCollection(this.stimuli, stimuli);
    }

    /**
     * Removes all elements from the stimuli collection.
     *
     */
    public void clearStimuli() {
        stimuli.clear();
    }

    /**
     * Returns a shallow copy of the stimuli collection.
     *
     *
     * @return shallow copy of the stimuli collection
     */
    public Collection<Stimulus> getStimuli() {
        return new ArrayList<Stimulus>(stimuli);
    }

    /**
     * Checks if the Stimulus is contained in the stimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param stimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public boolean containsStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");

        return stimuli.contains(stimulus);
    }

    /**
     * Returns the size of the stimuli collection.
     *
     *
     * @return the number of elements in the stimuli collection
     */
    public int countStimuli() {
        return stimuli.size();
    }

    /**
     * Gets the action field value. Could be null.
     *
     *
     * @return action field value
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets the action field value. Null is allowed.
     *
     *
     * @param action action field value
     */
    public void setAction(Action action) {
        this.action = action;
    }
}
