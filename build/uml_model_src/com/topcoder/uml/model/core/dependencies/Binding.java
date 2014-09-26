/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ Binding.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;

/**
 * <p>This interface extends Dependency interface. A binding is a relationship between a template
 * (as supplier) and a model element generated from the template (as client). It includes a list of
 * arguments that match the template parameters. The template is a form that is cloned and modified
 * by substitution to yield an implicit model fragment that behaves as if it were a direct part of the
 * model. A Binding must have one supplier and one client; unlike a general Dependency, the supplier
 * and client may not be sets. In the metamodel, a Binding is a Dependency where the supplier is the
 * template and the client is the instantiation of the template that performs the substitution of
 * parameters of a template. A Binding has a list of arguments that replace the parameters of the
 * supplier to yield the client. The client is fully specified by the binding of the supplier's
 * parameters and does not add any information of its own. An element may participate as a supplier
 * in multiple Binding relationships to different clients. An element may participate in only one
 * Binding relationship as a client.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public interface Binding extends Dependency {
    /**
     * Appends the TemplateArgument to the arguments list. It allows duplicates. Null values are not
     * allowed.
     *
     * @param argument The TemplateArgument to add to this list
     * @throws IllegalArgumentException if argument is null
     */
    public void addArgument(TemplateArgument argument);

    /**
     * Adds the TemplateArgument at the index position in the arguments list. It allows duplicates.
     * Null values are not allowed.
     *
     * @param index the position to insert this TemplateArgument in this list
     * @param argument The TemplateArgument to add to this list
     * @throws IllegalArgumentException if argument is null
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt; arguments.size()
     */
    public void addArgument(int index, TemplateArgument argument);

    /**
     * Appends the TemplateArgument instance to the arguments list. It allows duplicates. Null values
     * are not allowed.
     *
     * @param arguments The TemplateArgument collection to add to this list
     * @throws IllegalArgumentException if arguments is null or contains null elements.
     */
    public void addArguments(Collection<TemplateArgument> arguments);

    /**
     * Adds the TemplateArgument instances at the index position in the contained arguments list. It
     * allows duplicates. Null values are not allowed.
     *
     * @param index the position to insert this TemplateArgument collection in this list
     * @param arguments The TemplateArgument collection to add to this list
     * @throws IllegalArgumentException if arguments is null or contains null elements
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt; countQualifiers()
     */
    public void addArguments(int index, Collection<TemplateArgument> arguments);

    /**
     * Sets the TemplateArgument at the index position in the arguments list. Null values are not
     * allowed.
     *
     * @param index the position to set this TemplateArgument in this list
     * @param argument The TemplateArgument to set in this list
     * @throws IllegalArgumentException if argument is null
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= arguments.size()
     */
    public void setArgument(int index, TemplateArgument argument);

    /**
     * Removes the TemplateArgument instance at the index position from the arguments list.
     *
     * @return TemplateArgument The removed TemplateArgument
     * @param index the position of the TemplateArgument in this list to remove
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= arguments.size()
     */
    public TemplateArgument removeArgument(int index);

    /**
     * Removes the first instance, by reference, of the passed TemplateArgument, from the arguments
     * list.
     *
     * @return true if the instance was in the list and was successfully removed, false if it was
     *  not removed, or did not exist in the list
     * @param argument The TemplateArgument to remove from this list
     * @throws IllegalArgumentException if argument is null
     */
    public boolean removeArgument(TemplateArgument argument);

    /**
     * Removes the first instance, by reference, of each passed TemplateArgument from the contained
     * arguments list. It will iterate via the passed collection using its iterator and remove the
     * first instance, by reference, of each passed TemplateArgument, from the contained arguments list.
     *
     * @return boolean True if the state of the contained arguments list has changed, false otherwise.
     * @param arguments Collection of TemplateArgument instances to remove from the contained list
     * @throws IllegalArgumentException if arguments is null or it contains null elements
     */
    public boolean removeArguments(Collection<TemplateArgument> arguments);

    /**
     * Removes all elements from the arguments list.
     */
    public void clearArguments();

    /**
     * Returns a shallow copy of the arguments list.
     *
     * @return shallow copy of the arguments list
     */
    public List<TemplateArgument> getArguments();

    /**
     * Checks if the TemplateArgument is contained in the arguments list. The check is done by reference.
     *
     * @return true if the TemplateArgument is in the list, false otherwise
     * @param argument The TemplateArgument to check for its presence in this list
     * @throws IllegalArgumentException if argument is null
     */
    public boolean containsArgument(TemplateArgument argument);

    /**
     * Gets the index of the appearance of the TemplateArgument, by reference, in the arguments list.
     * It will always return the index of the first instance of the TemplateArgument if there are
     * duplicates in the list. It will return -1 if the TemplateArgument instance is not in the list.
     *
     * @return the index of the TemplateArgument instance in the list, or -1 if not found
     * @param argument TemplateArgument instance to look for
     * @throws IllegalArgumentException if argument is null
     */
    public int indexOfArgument(TemplateArgument argument);

    /**
     * Returns the size of the arguments list.
     *
     * @return the number of elements in the list
     */
    public int countArguments();
}


