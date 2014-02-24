/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.Collection;

import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * This interface represents a Use Case in the UML Modeling tool.
 * </p>
 *
 * <p>
 * Aside from extending the Classifier interface,
 * it supports four relationship types:
 * <ol>
 * <li>Includes, where this UseCase includes another;</li>
 * <li>Includers, where another UseCase includes this one;</li>
 * <li>Extends, where this UseCase is the extension ("extension extends base");</li>
 * <li>Extenders where this UseCase is the base (is extended by another).</li>
 * </ol>
 * </p>
 *
 * <p>
 * In addition, there is an additional method, getActors, which traverses
 * the various relationships attached to the Classifier that this interface extends,
 * to find the Actors that can invoke this UseCase.
 * </p>
 *
 * <p>
 * Thread Safety - Implementations of this interface is required to be thread-safe,
 * since thread safety should be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public interface UseCase extends Classifier {
    /**
     * <p>
     * Add the given relationship to the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * Note, If the given relationship is already on the list, it will be added again.
     * </p>
     *
     * @param include the relationship to add.
     * @throws IllegalArgumentException if include is null or if include.getBase() is not the current use
     * case instance
     */
    public void addInclude(Include include);

    /**
     * <p>
     * Remove the given relationship from the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * If the given entry is on the list more than once, only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param include the relationship to remove.
     * @throws IllegalArgumentException if include is null
     */
    public boolean removeInclude(Include include);

    /**
     * <p>
     * Remove all Include relationships from this UseCase, where this UseCase is the <b>base</b> UseCase in
     * the relationship.
     * </p>
     */
    public void clearIncludes();

    /**
     * <p>
     * Retrieve all the Include relationships of this UseCase, where this UseCase is the <b>base</b> UseCase
     * in each Include relationship.
     * </p>
     *
     * @return a copy of the collection of Include relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Include> getIncludes();

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Include relationships of this UseCase,
     * where this UseCase is the <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param include the relationship to find
     * @throws IllegalArgumentException if include is null
     */
    public boolean containsInclude(Include include);

    /**
     * <p>
     * Determine if this use case includes the given UseCase (there exists an Include relationship
     * in <b>this</b> UseCase where this UseCase is the <b>base</b> and the given UseCase is the <b>addition</b>.)
     * </p>
     *
     * <p>
     * Note that the reverse is usually also true, but not necessarily due to intermediate inconsistent states.
     * </p>
     *
     * @return true if found, false if not found.
     * @param include the UseCase to find
     * @throws IllegalArgumentException if includes is null
     */
    public boolean containsInclude(UseCase include);

    /**
     * <p>
     * Count the number of Include relationships that this UseCase has, where this UseCase is the
     * <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Includes relationships that this UseCase has, or zero if none.
     */
    public int countIncludes();

    /**
     * <p>
     * Return a collection of the UseCases that this UseCase includes, as defined by the Include
     * relationships of this UseCase. This is a simplfied version of the collection that the
     * getIncludes method returns.
     * </p>
     *
     * @return a collection of the UseCases that this UseCase includes.
     */
    public Collection<UseCase> getIncludedUseCases();

    /**
     * <p>
     * Add the given relationship to the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>addition</b> UseCase in the Include relationship. If the given
     * relationship is already on the list, it will be added again.
     * </p>
     *
     * @param includer the relationship to add.
     * @throws IllegalArgumentException if include is null or if include.getAddition() is not the current
     * use case.
     */
    public void addIncluder(Include includer);

    /**
     * <p>
     * Remove the given relationship from the collection of Include relatinships of this UseCase, where
     * this UseCase is the <b>addition</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * If the given relationship is on the list more than once, only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param includer the relationship to remove.
     * @throws IllegalArgumentException if includer is null
     */
    public boolean removeIncluder(Include includer);

    /**
     * <p>
     * Remove all Include relationships from this UseCase, where this UseCase is the <b>addition</b>
     * UseCase in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearIncluders();

    /**
     * <p>
     * Retrieve all the Include relationships of this UseCase, where this UseCase is the <b>addition</b>
     * UseCase in each Include relationship.
     * </p>
     *
     * @return a copy of the collection of Includer relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Include> getIncluders();

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Include relationships of this UseCase,
     * where this UseCase is the <b>addition</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param includer the relationship to find
     * @throws IllegalArgumentException if includer is null
     */
    public boolean containsIncluder(Include includer);

    /**
     * <p>
     * Determine if the given UseCase includes this use case (there exists an Includer relationship
     * in <b>this</b> UseCase where this UseCase is the <b>addition</b> and the given UseCase is the <b>base</b>.)
     * </p>
     *
     * <p>
     * Note that the reverse is usually also true, but not necessarily due to intermediate inconsistent states.
     * </p>
     *
     * @return true if found, false if not found.
     * @param includer the UseCase to find
     * @throws IllegalArgumentException if included is null
     */
    public boolean containsIncluder(UseCase includer);

    /**
     * <p>
     * Count the number of relationships that this UseCase has, where this UseCase is the
     * <b>addition</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Includer relationships that this UseCase has, or zero if none.
     */
    public int countIncluders();

    /**
     * <p>
     * Return a collection of the UseCases that include this UseCase, as defined by the Includer
     * relationships of this UseCase. This is a simplfied version of the collection that the
     * getIncluders method returns.
     * </p>
     *
     * @return a collection of the UseCases that include this UseCase.
     */
    public Collection<UseCase> getIncludingUseCases();

    /**
     * <p>
     * Add the given relationship to the collection of Extends relationships of this UseCase, where
     * this UseCase is the <b>extension</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * Note, If the given relationship is already on the list, it will be added again.
     * </p>
     *
     * @param extendRelationship the relationship to add. Note to reviewers and developers:
     * this argument could not be called 'extends' because that is a reserved word in Java.
     * @throws IllegalArgumentException if extendRelationship is null or if extendRelationship.getBase() is
     * not the current use case.
     */
    public void addExtend(Extend extendRelationship);

    /**
     * <p>
     * Remove the given relationship from the collection of Extends of this UseCase, where
     * this UseCase is the <b>extension</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * If the given relationship is on the list more than once,
     * only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param extendRelationship the relationship to remove. Note to reviewers and developers:
     * this argument could not be called 'extends' because that is a reserved word in Java.
     * @throws IllegalArgumentException if extendRelationship is null
     */
    public boolean removeExtend(Extend extendRelationship);

    /**
     * <p>
     * Remove all Extend relationships from this UseCase, where this UseCase is the <b>extension</b>
     * UseCase in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearExtends();

    /**
     * <p>
     * Retrieve all the Extend relationships of this UseCase, where this UseCase is the <b>extension</b>
     * UseCase in each Extend relationship.
     * </p>
     *
     * @return a copy of the collection of Extend relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Extend> getExtends();

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Extends relationships of this UseCase,
     * where this UseCase is the <b>extension</b> UseCase in the Extend relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param extendRelationship the relationship to find. Note to reviewers and developers:
     * this argument could not be called 'extends' because that is a reserved word in Java.
     * @throws IllegalArgumentException if extendRelationship is null
     */
    public boolean containsExtend(Extend extendRelationship);

    /**
     * <p>
     * Determine if this use case extends the given UseCase (there exists an Extend relationship
     * in <b>this</b> UseCase where this UseCase is the <b>extension</b> and the given UseCase is the <b>base</b>.)
     * </p>
     *
     * <p>
     * Note that the reverse is usually also true, but not necessarily due to intermediate inconsistent states.
     * </p>
     *
     * @return true if found, false if not found.
     * @param extendsUseCase the UseCase to find
     * @throws IllegalArgumentException if extendsUseCase is null
     */
    public boolean containsExtend(UseCase extendsUseCase);

    /**
     * <p>
     * Count the number of Extends relationships that this UseCase has, where this UseCase is the
     * <b>extension</b> UseCase in each relationship.
     * </p>
     *
     * @return the number of Extends relationships that this UseCase has, or zero if none.
     */
    public int countExtends();

    /**
     * <p>
     * Return a collection of the UseCases that this UseCase extends, as defined by the Extend relationships
     * of this UseCase.
     * </p>
     *
     * @return a collection of the UseCases that this UseCase extends.
     */
    public Collection<UseCase> getBaseUseCases();

    /**
     * <p>
     * Add the given Extender relationship to the collection of Extenders relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * If the given relationship is already on the list, it will be added again.
     * </p>
     *
     * @param extender the relationship to add.
     * @throws IllegalArgumentException if extender is null or if extender.getExtension() != this object
     */
    public void addExtender(Extend extender);

    /**
     * <p>
     * Remove the given Extender relationship from the collection of Extenders of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * If the given relationship is on the list more than once, only the first one is removed.
     *
     * @return true if removed, false if not found.
     * @param extender the relationship to remove.
     * @throws IllegalArgumentException if extender is null
     */
    public boolean removeExtender(Extend extender);

    /**
     * <p>
     * Remove all Extender relationships from this UseCase, where this UseCase is the <b>base</b> UseCase
     * in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearExtenders();

    /**
     * <p>
     * Retrieve all the Extender relationships of this UseCase as added by addExtender, where
     * this UseCase is the <b>base</b> UseCase in each Extender relationship.
     * </p>
     *
     * @return a copy of the collection of Extender relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Extend> getExtenders();

    /**
     * <p>
     * Determine if the given Extend relationship exists in the collection of Extenders of this UseCase,
     * where this UseCase is the <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param extender the relationship to find
     * @throws IllegalArgumentException if extender is null
     */
    public boolean containsExtender(Extend extender);

    /**
     * <p>
     * Determine if the given UseCase extends this use case (there exists an Extender relationship
     * in <b>this</b> UseCase where this UseCase is the <b>base</b> and the given UseCase is the <b>extension</b>.)
     * </p>
     *
     * <p>
     * Note that the reverse is usually also true, but not necessarily due to intermediate inconsistent states.
     * </p>
     *
     * @return true if found, false if not found.
     * @param extender the UseCase to find
     * @throws IllegalArgumentException if extender is null
     */
    public boolean containsExtender(UseCase extender);

    /**
     * <p>
     * Count the number of Extender relationships that this UseCase has, where this UseCase is the
     * <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Extender relationships that this UseCase has, or zero if none.
     */
    public int countExtenders();

    /**
     * <p>
     * Return a collection of the UseCases that extend this UseCase, as defined by the Extender relationships
     * of this UseCase. This is a simplfied version of the collection that the getExtenders method returns.
     * </p>
     *
     * @return a collection of the UseCases that extend this UseCase.
     */
    public Collection<UseCase> getSubUseCases();

    /**
     * <p>
     * Return a collection of the Actors that can invoke this UseCase.
     * </p>
     *
     * @return a collection of the Actors that can invoke this UseCase
     */
    public Collection<Actor> getActors();
}
