/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import java.util.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Enumeration extends DataType {
    /**
     * Appends the EnumerationLiteral to the literals list. It allows
     * duplicates. Null values are not allowed. This is equivalent to using
     * addLiteral(countLiterals(), literal).
     *
     * @param literal
     *            The EnumerationLiteral to add to this list
     * @throws IllegalArgumentException
     *             if literal is null
     */
    public void addLiteral(EnumerationLiteral literal);

    /**
     * Adds the EnumerationLiteral at the index position in the literals list.
     * It allows duplicates. Null values are not allowed. Note that adding at
     * index = countLiterals() is equivalent to calling addLiteral(literal).
     *
     * @param index
     *            the position to insert this EnumerationLiteral in this list
     * @param literal
     *            The EnumerationLiteral to add to this list
     * @throws IllegalArgumentException
     *             if literal is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > literals.size()
     */
    public void addLiteral(int index, EnumerationLiteral literal);

    /**
     * Appends the EnumerationLiteral instance to the literals list. It allows
     * duplicates. Null values are not allowed. This is equivalent to using
     * addLiterals(countLiterals(), literals).
     *
     * @param literals
     *            The EnumerationLiteral collection to add to this list
     * @throws IllegalArgumentException
     *             if literals is null or contains null elements.
     */
    public void addLiterals(Collection<EnumerationLiteral> literals);

    /**
     * Adds the EnumerationLiteral instances at the index position in the
     * contained literals list. It allows duplicates. Null values are not
     * allowed. Note that adding at index = countLiterals() is equivalent to
     * calling addLiterals(literals).
     *
     * @param index
     *            the position to insert this EnumerationLiteral collection in
     *            this list
     * @param literals
     *            The EnumerationLiteral collection to add to this list
     * @throws IllegalArgumentException
     *             if literals is null or contains null elements
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index > countQualifiers()
     */
    public void addLiterals(int index, Collection<EnumerationLiteral> literals);

    /**
     * Sets the EnumerationLiteral at the index position in the literals list.
     * Null values are not allowed.
     *
     * @param index
     *            the position to set this EnumerationLiteral in this list
     * @param literal
     *            The EnumerationLiteral to set in this list
     * @throws IllegalArgumentException
     *             if literal is null
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= literals.size()
     */
    public void setLiteral(int index, EnumerationLiteral literal);

    /**
     * Removes the EnumerationLiteral instance at the index position from the
     * literals list.
     *
     * @return EnumerationLiteral The removed EnumerationLiteral
     * @param index
     *            the position of the EnumerationLiteral in this list to remove
     * @throws IndexOutOfBoundsException
     *             if index < 0 or index >= literals.size()
     */
    public EnumerationLiteral removeLiteral(int index);

    /**
     * Removes the first instance, by reference, of the passed
     * EnumerationLiteral, from the literals list.
     *
     * @return true if the instance was in the list and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         list
     * @param literal
     *            The EnumerationLiteral to remove from this list
     * @throws IllegalArgumentException
     *             if literal is null
     */
    public boolean removeLiteral(EnumerationLiteral literal);

    /**
     * Removes the first instance, by reference, of each passed
     * EnumerationLiteral from the contained literals list. It will iterate via
     * the passed collection using its iterator and remove the first instance,
     * by reference, of each passed EnumerationLiteral, from the contained
     * literals list.
     *
     * @return boolean True if the state of the contained literals list has
     *         changed, false otherwise.
     * @param literals
     *            Collection of EnumerationLiteral instances to remove from the
     *            contained list
     * @throws IllegalArgumentException
     *             if literals is null or it contains null elements
     */
    public boolean removeLiterals(Collection<EnumerationLiteral> literals);

    /**
     * Removes all elements from the literals list.
     */
    public void clearLiterals();

    /**
     * Returns a shallow copy of the literals list.
     *
     * @return shallow copy of the literals list
     */
    public List<EnumerationLiteral> getLiterals();

    /**
     * Checks if the EnumerationLiteral is contained in the literals list. The
     * check is done by reference.
     *
     * @return true if the EnumerationLiteral is in the list, false otherwise
     * @param literal
     *            The EnumerationLiteral to check for its presence in this list
     * @throws IllegalArgumentException
     *             if literal is null
     */
    public boolean containsLiteral(EnumerationLiteral literal);

    /**
     * Gets the index of the appearance of the EnumerationLiteral, by reference,
     * in the literals list. It will always return the index of the first
     * instance of the EnumerationLiteral if there are duplicates in the list.
     * It will return -1 if the EnumerationLiteral instance is not in the list.
     *
     * @return the index of the EnumerationLiteral instance in the list, or -1
     *         if not found
     * @param literal
     *            EnumerationLiteral instance to look for
     */
    public int indexOfLiteral(EnumerationLiteral literal);

    /**
     * Returns the size of the literals list.
     *
     * @return the number of elements in the list
     */
    public int countLiterals();
}