/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This is the basic implementation of the UseCase interface, representing a Use Case
 * in the UML Modeling tool.
 * </p>
 *
 * <p>
 * Aside from extending the ClassifierAbstractImpl class, it supports four relationship types:
 * <ol>
 * <li>Includes, where this UseCase includes another;</li>
 * <li>Includers where another UseCase includes this one;</li>
 * <li>Extends, where this UseCase is the extension ("extension extends base");</li>
 * <li>Extenders where this UseCase is the base (is extended by another).</li>
 * </ol>
 *
 * <p>
 * In addition, there is an additional method, getActors, which traverses the various relationships
 * attached to the Classifier that this interface extends, to find the Actors that can invoke this
 * UseCase.
 * </p>
 *
 * <p>
 * Thread Safety - This class is mutable and not thread safety.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseImpl extends ClassifierAbstractImpl implements UseCase {
    /**
     * <p>
     * These are the 'includes' relationships, where this UseCase is the base UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * This variable will never be null but may be empty.
     * Entries will never be null.
     * </p>
     *
     * <p>
     * Note, there may be duplicate entries on this list.
     * </p>
     */
    private final Collection<Include> includes = new ArrayList<Include>();

    /**
     * <p>
     * These are the 'includers' relationships, where this UseCase is the addition
     * UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * This variable will never be null but may be empty. Entries will never be null.
     * </p>
     *
     * <p>
     * Note, there may be duplicate entries on this list.
     * </p>
     */
    private final Collection<Include> includers = new ArrayList<Include>();

    /**
     * <p>
     * These are the 'extends' relationships, where this UseCase is the extension UseCase
     * in the Extend relationship.
     * </p>
     *
     * <p>
     * This variable will never be null but may be empty. Entries will never be null.
     * </p>
     *
     * <p>
     * Note, there may be duplicate entries on this list.
     * </p>
     */
    private final Collection<Extend> extendRelationships = new ArrayList<Extend>();

    /**
     * <p>
     * These are the 'extenders' relationships, where this UseCase is the base UseCase
     * in the Extend relationship.
     * </p>
     *
     * <p>
     * This variable will never be null but may be empty. Entries will never be null.
     * </p>
     *
     * <p>
     * Note, there may be duplicate entries on this list.
     * </p>
     *
     */
    private final Collection<Extend> extenders = new ArrayList<Extend>();

    /**
     * <p>
     * Construct this object. Does nothing.
     * </p>
     */
    public UseCaseImpl() {
        // empty
    }

    /**
     * <p>
     * Add the given relationship to the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * If the given entry already exists on the list, it will be added again.
     * </p>
     *
     * @param include the relationship to add.
     * @throws IllegalArgumentException if include is null or if include.getBase() is not current use case
     */
    public void addInclude(Include include) {
        if (include == null) {
            throw new IllegalArgumentException("include is null.");
        }
        if (include.getBase() != this) {
            throw new IllegalArgumentException("this use case is not the base use case in the include relationship.");
        }

        includes.add(include);
    }

    /**
     * <p>
     * Remove the given relationship from the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * If the given relationship is on the list more than once, only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param include the relationship to remove.
     * @throws IllegalArgumentException if include is null
     */
    public boolean removeInclude(Include include) {
        if (include == null) {
            throw new IllegalArgumentException("include is null.");
        }

        return includes.remove(include);
    }

    /**
     * <p>
     * Remove all Include relationships from this UseCase, where this UseCase is the <b>base</b>
     * UseCase in the relationship.
     * If there were none, nothing happens.
     * </p>
     */
    public void clearIncludes() {
        includes.clear();
    }

    /**
     * <p>
     * Retrieve all the Include relationships of this UseCase, where this UseCase is the <b>base</b>
     * UseCase in each Include relationship.
     * </p>
     *
     * @return a copy of the collection of Include relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Include> getIncludes() {
        return new ArrayList<Include>(includes);
    }

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Include relationships of
     * this UseCase, where this UseCase is the <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param include the relationship to find
     * @throws IllegalArgumentException if include is null
     */
    public boolean containsInclude(Include include) {
        if (include == null) {
            throw new IllegalArgumentException("include is null.");
        }

        return includes.contains(include);
    }

    /**
     * <p>
     * Determine if this use case includes the given UseCase (there exists an Include relationship
     * in <b>this</b> UseCase where this UseCase is the <b>base</b> and the given UseCase is the <b>addition</b>.)
     * </p>
     *
     * <p>
     * Note that the reverse is usually also true, but not necessarily due to intermediate
     * inconsistent states.
     * </p>
     *
     * @return true if found, false if not found.
     * @param useCase the UseCase to find
     * @throws IllegalArgumentException if includes is null
     */
    public boolean containsInclude(UseCase useCase) {
        if (useCase == null) {
            throw new IllegalArgumentException("useCase is null.");
        }

        for (Include include : includes) {
            if (include.getAddition() == useCase) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Count the number of Include relationships that this UseCase has, where this UseCase is the
     * <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Includes relationships that this UseCase has, or zero if none.
     */
    public int countIncludes() {
        return includes.size();
    }

    /**
     * <p>
     * Return a collection of the UseCases that this UseCase includes, as defined by the Include
     * relationships of this UseCase. This is a simplified version of the collection that the
     * getIncludes method returns.
     * </p>
     *
     * @return a collection of the UseCases that this UseCase includes.
     */
    public Collection<UseCase> getIncludedUseCases() {
        Collection<UseCase> includedUseCases = new ArrayList<UseCase>();
        for (Include include : includes) {
            includedUseCases.add(include.getAddition());
        }
        return includedUseCases;
    }

    /**
     * <p>
     * Add the given relationship to the collection of Include relationships of this UseCase, where
     * this UseCase is the <b>addition</b> UseCase in the Include relationship.
     * </p>
     *
     * <p>
     * If the given entry already exists on the list, it will be added again.
     * </p>
     *
     * @param includer the relationship to add.
     * @throws IllegalArgumentException if include is null or if include.getAddition() is not current
     * use case
     */
    public void addIncluder(Include includer) {
        if (includer == null) {
            throw new IllegalArgumentException("includer is null.");
        }
        if (includer.getAddition() != this) {
            throw new IllegalArgumentException(
                "this use case is not the addition use case in the include relationship.");
        }

        includers.add(includer);
    }

    /**
     * <p>
     * Remove the given relationship from the collection of Include relationships of this UseCase, where
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
    public boolean removeIncluder(Include includer) {
        if (includer == null) {
            throw new IllegalArgumentException("includer is null.");
        }

        return includers.remove(includer);
    }

    /**
     * <p>
     * Remove all Include relationships from this UseCase, where this UseCase is the <b>addition</b>
     * UseCase in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearIncluders() {
        includers.clear();
    }

    /**
     * <p>
     * Retrieve all the Include relationships of this UseCase, where this UseCase is the <b>addition</b>
     * UseCase in each Include relationship.
     * </p>
     *
     * @return a copy of the collection of Includer relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Include> getIncluders() {
        return new ArrayList<Include>(includers);
    }

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Include relationships of this
     * UseCase, where this UseCase is the <b>addition</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param includer the relationship to find
     * @throws IllegalArgumentException if includer is null
     */
    public boolean containsIncluder(Include includer) {
        if (includer == null) {
            throw new IllegalArgumentException("includer is null.");
        }

        return includers.contains(includer);
    }

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
     * @param useCase the UseCase to find
     * @throws IllegalArgumentException if included is null
     */
    public boolean containsIncluder(UseCase useCase) {
        if (useCase == null) {
            throw new IllegalArgumentException("useCase is null.");
        }

        for (Include includer : includers) {
            if (includer.getBase() == useCase) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Count the number of Include relationships that this UseCase has, where this UseCase is the
     * <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Includer relationships that this UseCase has, or zero if none.
     */
    public int countIncluders() {
        return includers.size();
    }

    /**
     * <p>
     * Return a collection of the UseCases that include this UseCase, as defined by the Includer
     * relationships of this UseCase.
     * </p>
     *
     * @return a collection of the UseCases that include this UseCase.
     */
    public Collection<UseCase> getIncludingUseCases() {
        Collection<UseCase> includingUseCases = new ArrayList<UseCase>();
        for (Include includer : includers) {
            includingUseCases.add(includer.getBase());
        }
        return includingUseCases;
    }

    /**
     * <p>
     * Add the given relationship to the collection of Extends relationships of this UseCase, where
     * this UseCase is the <b>extension</b> UseCase in the relationship.
     * </p>
     *
     * <p>
     * If the given entry already exists on the list, it will be added again.
     * </p>
     *
     * @param extendRelationship the relationship to add. Note to reviewers and developers:
     * this argument could not be called 'extends' because that is a reserved word in Java.
     * @throws IllegalArgumentException if extendRelationship is null or if extendRelationship.getExtension()
     * is not the current use case.
     */
    public void addExtend(Extend extendRelationship) {
        if (extendRelationship == null) {
            throw new IllegalArgumentException("extendRelationship is null.");
        }
        if (extendRelationship.getExtension() != this) {
            throw new IllegalArgumentException("this use case is not the extension use case in the relationship.");
        }

        extendRelationships.add(extendRelationship);
    }

    /**
     * <p>
     * Remove the given relationship from the collection of Extends of this UseCase, where
     * this UseCase is the <b>extension</b> UseCase in the relationship.
     * </p>
     *
     * <p>
     * Note, if the given relationship is on the list more than once, only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param extendRelationship the relationship to remove.
     * @throws IllegalArgumentException if extendRelationship is null
     */
    public boolean removeExtend(Extend extendRelationship) {
        if (extendRelationship == null) {
            throw new IllegalArgumentException("extendRelationship is null.");
        }

        return extendRelationships.remove(extendRelationship);
    }

    /**
     * <p>
     * Remove all Extend relationships from this UseCase, where this UseCase is the <b>extension</b>
     * UseCase in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearExtends() {
        extendRelationships.clear();
    }

    /**
     * <p>
     * Retrieve all the Extend relationships of this UseCase, where this UseCase is the <b>extension</b>
     * UseCase in each Extend relationship.
     * </p>
     *
     * @return a copy of the collection of Extend relationships of this UseCase.
     *  If there are none, returns an empty collection.
     */
    public Collection<Extend> getExtends() {
        return new ArrayList<Extend>(extendRelationships);
    }

    /**
     * <p>
     * Determine if the given relationship exists in the collection of Extends relationships of this UseCase,
     * this UseCase is the <b>extension</b> UseCase in the relationship.
     * </p>
     *
     * @return true if found, false if not found.
     * @param extendRelationship the relationship to find. Note to reviewers and developers:
     * this argument could not be called 'extends' because that is a reserved word in Java.
     * @throws IllegalArgumentException if extendRelationship is null
     */
    public boolean containsExtend(Extend extendRelationship) {
        if (extendRelationship == null) {
            throw new IllegalArgumentException("extendRelationship is null.");
        }

        return extendRelationships.contains(extendRelationship);
    }

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
     * @param useCase the UseCase to find
     * @throws IllegalArgumentException if extendsUseCase is null
     */
    public boolean containsExtend(UseCase useCase) {
        if (useCase == null) {
            throw new IllegalArgumentException("extendsUseCase is null.");
        }

        for (Extend extend : extendRelationships) {
            if (extend.getBase() == useCase) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Count the number of Extends relationships that this UseCase has, where this UseCase is the
     * <b>extension</b> UseCase in each relationship.
     * </p>
     *
     * @return the number of Extends relationships that this UseCase has, or zero if none.
     */
    public int countExtends() {
        return extendRelationships.size();
    }

    /**
     * <p>
     * Return a collection of the UseCases that this UseCase extends, as defined by the Extend relationships
     * of this UseCase.
     * </p>
     *
     * @return a collection of the UseCases that this UseCase extends.
     */
    public Collection<UseCase> getBaseUseCases() {
        Collection<UseCase> baseUseCases = new ArrayList<UseCase>();
        for (Extend extend : extendRelationships) {
            baseUseCases.add(extend.getBase());
        }
        return baseUseCases;
    }

    /**
     * <p>
     * Add the given Extender relationship to the collection of Extenders relationships of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * Note, if the given entry already exists on the list, it will be added again.
     * </p>
     *
     * @param extender the relationship to add.
     * @throws IllegalArgumentException if extender is null or if extender.getBase() is not the current use
     * case.
     */
    public void addExtender(Extend extender) {
        if (extender == null) {
            throw new IllegalArgumentException("extender is null.");
        }
        if (extender.getBase() != this) {
            throw new IllegalArgumentException("this use case is not the base use case in the relationship.");
        }

        extenders.add(extender);
    }

    /**
     * <p>
     * Remove the given Extender relationship from the collection of Extenders of this UseCase, where
     * this UseCase is the <b>base</b> UseCase in the Extend relationship.
     * </p>
     *
     * <p>
     * If the given relationship is on the list more than once, only the first one is removed.
     * </p>
     *
     * @return true if removed, false if not found.
     * @param extender the relationship to remove.
     * @throws IllegalArgumentException if extender is null
     */
    public boolean removeExtender(Extend extender) {
        if (extender == null) {
            throw new IllegalArgumentException("extender is null.");
        }

        return extenders.remove(extender);
    }

    /**
     * <p>
     * Remove all Extender relationships from this UseCase, where this UseCase is the <b>base</b>
     * UseCase in the relationship. If there were none, nothing happens.
     * </p>
     */
    public void clearExtenders() {
        extenders.clear();
    }

    /**
     * <p>
     * Retrieve all the Extender relationships of this UseCase as added by addExtender, where
     * this UseCase is the <b>base</b> UseCase in each Extender relationship.
     * </p>
     *
     * @return a copy of the collection of Extender relationships of this UseCase.
     * If there are none, returns an empty collection.
     */
    public Collection<Extend> getExtenders() {
        return new ArrayList<Extend>(extenders);
    }

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
    public boolean containsExtender(Extend extender) {
        if (extender == null) {
            throw new IllegalArgumentException("extender is null.");
        }

        return extenders.contains(extender);
    }

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
    public boolean containsExtender(UseCase useCase) {
        if (useCase == null) {
            throw new IllegalArgumentException("useCase is null.");
        }

        for (Extend extend : extenders) {
            if (extend.getExtension() == useCase) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Count the number of Extender relationships that this UseCase has, where this UseCase is the
     * <b>base</b> UseCase in the relationship.
     * </p>
     *
     * @return the number of Extender relationships that this UseCase has, or zero if none.
     */
    public int countExtenders() {
        return extenders.size();
    }

    /**
     * <p>
     * Return a collection of the UseCases that extend this UseCase, as defined by the Extender relationships
     * of this UseCase.
     * </p>
     *
     * @return a collection of the UseCases that extend this UseCase.
     */
    public Collection<UseCase> getSubUseCases() {
        Collection<UseCase> subUseCases = new ArrayList<UseCase>();
        for (Extend extend : extenders) {
            subUseCases.add(extend.getExtension());
        }
        return subUseCases;
    }

    /**
     * <p>
     * Return a collection of the Actors that can invoke this UseCase.
     * </p>
     *
     * @return a collection of the Actors that can invoke this UseCase
     */
    public Collection<Actor> getActors() {
        Collection<Classifier> classfiers = UseCaseUtil.findAssociatedEnd(this, Actor.class);

        // convert the Classifier collection to its UseCase collection, cast operation is used
        Collection<Actor> actors = new ArrayList<Actor>();
        for (Classifier classfier : classfiers) {
            actors.add((Actor) classfier);
        }
        return actors;
    }
}
