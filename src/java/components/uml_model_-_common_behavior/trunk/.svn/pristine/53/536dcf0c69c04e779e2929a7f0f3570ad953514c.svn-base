/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.procedure;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.expressions.Expression;

import java.util.Collection;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the
 * Core Requirements component. A procedure is a coordinated set of actions that models a computation,
 * such as an algorithm. It can also be used without actions to express a procedure in a textual
 * language. In the metamodel, Procedure is a subclass of ModelElement. It can be linked to a
 * Method or Expression to model how the method is carried out or the expression is evaluated.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Procedure extends ModelElement {
    /**
     * Gets the  language field value. Could be null/empty.
     *
     *
     * @return language field value
     */
    String getLanguage();

    /**
     * Sets the language field value. Null/empty is allowed.
     *
     *
     * @param language language field value
     */
    void setLanguage(String language);

    /**
     * Gets the body field value. Could be null/empty.
     *
     *
     * @return body field value
     */
    String getBody();

    /**
     * Sets the body field value. Null/empty is allowed.
     *
     *
     * @param body body field value
     */
    void setBody(String body);

    /**
     * Gets the list field value.
     *
     *
     * @return list field value
     */
    boolean isList();

    /**
     * Sets the list field value.
     *
     *
     * @param list list field value
     */
    void setList(boolean list);

    /**
     * Gets the expression field value. Could be null.
     *
     *
     * @return expression field value
     */
    Expression getExpression();

    /**
     * Sets the expression field value. Null is allowed.
     *
     *
     * @param expression expression field value
     */
    void setExpression(Expression expression);

    /**
     * Gets the method field value. Could be null.
     *
     *
     * @return method field value
     */
    Method getMethod();

    /**
     * Sets the method field value. Null is allowed.
     *
     *
     * @param method method field value
     */
    void setMethod(Method method);

    /**
     * Adds the Stimulus into the stimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param stimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    void addStimulus(Stimulus stimulus);

    /**
     * Adds the Stimulus instances into the stimuli collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     *
     * @param stimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    void addStimuli(Collection<Stimulus> stimuli);

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the stimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Stimulus will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     * was not removed, or did not exist in the collection
     * @param stimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    boolean removeStimulus(Stimulus stimulus);

    /**
     * Removes the first instance, by reference, of each passed Stimulus from the contained stimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Stimulus will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained stimuli collection has changed, false otherwise.
     * @param stimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    boolean removeStimuli(Collection<Stimulus> stimuli);

    /**
     * Removes all elements from the stimuli collection.
     *
     */
    void clearStimuli();

    /**
     * Returns a shallow copy of the stimuli collection.
     *
     *
     * @return shallow copy of the stimuli collection
     */
    Collection<Stimulus> getStimuli();

    /**
     * Checks if the Stimulus is contained in the stimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param stimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    boolean containsStimulus(Stimulus stimulus);

    /**
     * Returns the size of the stimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countStimuli();

    /**
     * Gets the action field value. Could be null.
     *
     *
     * @return action field value
     */
    Action getAction();

    /**
     * Sets the action field value. Null is allowed.
     *
     *
     * @param action action field value
     */
    void setAction(Action action);
}
