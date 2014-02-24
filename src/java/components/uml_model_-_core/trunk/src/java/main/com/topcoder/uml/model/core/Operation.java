/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import java.util.Collection;

/**
 * <p>
 * An operation is a service that can be requested from an object to effect behavior. An operation has a signature,
 * which describes the actual parameters that are possible (including possible return values).
 * </p>
 * <p>
 * In the meta model, an Operation is a BehavioralFeature that can be applied to the Instances of the Classifier that
 * contains the Operation.
 * </p>
 * <p>
 * An Operation has the following properties:
 * <ul>
 * <li>concurrency: Specifies the semantics of concurrent calls to the same passive instance (i.e., an Instance
 * originating from a Classifier with isActive=false). Active instances control access to their own Operations so this
 * property is usually (although not required in UML) set to sequential. Possibilities include:
 *
 * <pre>
 *     (1) sequential - Callers must coordinate so that only one call to an Instance
 *         (on any sequential Operation) may be outstanding at once. If simultaneous
 *         calls occur, then the semantics and integrity of the system cannot be guaranteed.
 *     (2) guarded - Multiple calls from concurrent threads may occur simultaneously
 *         to one Instance (on any guarded Operation), but only one is allowed to commence.
 *         The others are blocked until the performance of the first Operation is complete.
 *         It is the responsibility of the system designer to ensure that deadlocks do not occur
 *         due to simultaneous blocks. Guarded Operations must perform correctly (or block themselves)
 *         in the case of a simultaneous sequential Operation or guarded semantics cannot be claimed.
 *     (3) concurrent - Multiple calls from concurrent threads may occur simultaneously to
 *         one Instance (on any concurrent Operation). All of them may proceed concurrently
 *         with correct semantics. Concurrent Operations must perform correctly in the case
 *         of a simultaneous sequential or guarded Operation or concurrent semantics cannot be claimed.
 * </pre>
 *
 * </li>
 * <li>isAbstract: If true, then the operation does not have an implementation, and one must be supplied by a
 * descendant. If false, the operation must have an implementation in the class or inherited from an ancestor. </li>
 * <li>isLeaf: If true, then the implementation of the operation may not be overriden by a descendant class. If false,
 * then the implementation of the operation may be overridden by a descendant class (but it need not be overridden).
 * </li>
 * <li>isRoot: If true, then the class must not inherit a declaration of the same operation. If false, then the class
 * may (but need not) inherit a declaration of the same operation. (But the declaration must match in any case; a class
 * may not modify an inherited operation declaration.) </li>
 * <li>specification: A String specification for the Operation.</li>
 * <li>method: An unordered collection of Methods owned by the Operation.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface Operation extends BehavioralFeature {
    /**
     * <p>
     * Sets the concurrency of the current object.
     * </p>
     *
     * @param concurrency
     *            the concurrency to be set for this object.
     */
    void setConcurrency(CallConcurrencyKind concurrency);

    /**
     * <p>
     * Gets the concurrency of the current object.
     * </p>
     *
     * @return the concurrency of this object.
     */
    CallConcurrencyKind getConcurrency();

    /**
     * <p>
     * Sets if the current object is root.
     * </p>
     *
     * @param isRoot
     *            a boolean value stating if the current object is root.
     */
    void setRoot(boolean isRoot);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is root.
     * </p>
     *
     * @return <code>true</code> if the current object is root, otherwise <code>false</code>.
     */
    boolean isRoot();

    /**
     * <p>
     * Sets if the current object is leaf.
     * </p>
     *
     * @param isLeaf
     *            a boolean value stating if the current object is leaf.
     */
    void setLeaf(boolean isLeaf);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is leaf.
     * </p>
     *
     * @return <code>true</code> if the current object is leaf, otherwise <code>false</code>.
     */
    boolean isLeaf();

    /**
     * <p>
     * Sets if the current object is abstract.
     * </p>
     *
     * @param isAbstract
     *            a boolean value stating if the current object is abstract.
     */
    void setAbstract(boolean isAbstract);

    /**
     * <p>
     * Gets a boolean value that is true if the current object is abstract.
     * </p>
     *
     * @return <code>true</code> if the current object is abstract, otherwise <code>false</code>
     */
    boolean isAbstract();

    /**
     * <p>
     * Sets the specification of the current object.
     * </p>
     *
     * @param specification
     *            the specification to be set for this object.
     */
    void setSpecification(String specification);

    /**
     * <p>
     * Gets the specification of the current object.
     * </p>
     *
     * @return the specification of this object.
     */
    String getSpecification();

    /**
     * <p>
     * Adds a method to the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be added.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     */
    void addMethod(Method method);

    /**
     * <p>
     * Removes a method from the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be removed.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    boolean removeMethod(Method method);

    /**
     * <p>
     * Removes all the objects of type "method" from the collection of the current object.
     * </p>
     */
    void clearMethods();

    /**
     * <p>
     * Gets all the objects of type "method" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type <code>Method</code>
     *         added to the collection of current object.
     */
    Collection<Method> getMethods();

    /**
     * <p>
     * Checks if a method is contained in the collection of the current object.
     * </p>
     *
     * @param method
     *            the method to be tested.
     * @throws IllegalArgumentException
     *             if <code>method</code> is null.
     * @return <code>true</code> if <code>method</code> is contained in the collection of the current object.
     */
    boolean containsMethod(Method method);

    /**
     * <p>
     * Returns the number of objects of type "method" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>Method</code> inserted in the collection of the current object.
     */
    int countMethods();
}
