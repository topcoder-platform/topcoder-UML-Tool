/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ BindingImpl.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;

/**
 * <p>This is a simple concrete implementation of Binding interface and extends DependencyImpl. As such,
 * all methods in Binding are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class BindingImpl extends DependencyImpl implements Binding {
    /**
     * <p>Represents A list of arguments. Each argument is a TemplateArgument element. The model element
     * attached to the TemplateArgument by the modelElement association replaces the corresponding supplier
     * parameter in the supplier definition, and the result represents the definition of the client as if
     * it had been defined directly. It will support Attribute elements.</p>
     *
     * <p>This list will be initialized upon construction, and will have many accessor methods, including
     * adding and removing an element or elements by reference or position, checking if the element is in
     * the list (by reference), counting the number of the elements, getting an element at a position, and
     * finally clearing and getting the list. Note that the whole list getter will only return a copy of
     * the list. Null values will not be allowed.</p>
     */
    private final List<TemplateArgument> arguments = new ArrayList<TemplateArgument>();

    /**
     * <p>Empty constructor.</p>
     */
    public  BindingImpl() {
    }

    /**
     * Appends the TemplateArgument to the arguments list. It allows duplicates. Null values are
     * not allowed.
     *
     * @param argument The TemplateArgument to add to this list
     * @throws IllegalArgumentException if argument is null
     */
    public void addArgument(TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");

        arguments.add(argument);
    }

    /**
     * Adds the TemplateArgument at the index position in the arguments list. It allows duplicates.
     * Null values are not allowed.
     *
     * @param index the position to insert this TemplateArgument in this list
     * @param argument The TemplateArgument to add to this list
     * @throws IllegalArgumentException if argument is null
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt; arguments.size()
     */
    public void addArgument(int index, TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");
        // Check if index is out of range
        CoreDependenciesHelper.checkIndexAddRange(index, arguments.size(), "index");

        arguments.add(index, argument);
    }

    /**
     * Appends the TemplateArgument instance to the arguments list. It allows duplicates. Null values
     * are not allowed.
     *
     * @param arguments The TemplateArgument collection to add to this list
     * @throws IllegalArgumentException if arguments is null or contains null elements.
     */
    public void addArguments(Collection<TemplateArgument> arguments) {
        // Check if arguments is null or contains null argument
        CoreDependenciesHelper.checkCollection(arguments, "arguments");

        this.arguments.addAll(arguments);
    }

    /**
     * Adds the TemplateArgument instances at the index position in the contained arguments list.
     * It allows duplicates. Null values are not allowed.
     *
     * @param index the position to insert this TemplateArgument collection in this list
     * @param arguments The TemplateArgument collection to add to this list
     * @throws IllegalArgumentException if arguments is null or contains null elements
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt; countQualifiers()
     */
    public void addArguments(int index, Collection<TemplateArgument> arguments) {
        // Check if arguments is null or contains null argument
        CoreDependenciesHelper.checkCollection(arguments, "arguments");
        // Check if index is out of range
        CoreDependenciesHelper.checkIndexAddRange(index, this.arguments.size(), "index");

        this.arguments.addAll(index, arguments);
    }

    /**
     * Sets the TemplateArgument at the index position in the arguments list. Null values are not
     * allowed.
     *
     * @param index the position to set this TemplateArgument in this list
     * @param argument The TemplateArgument to set in this list
     * @throws IllegalArgumentException if argument is null
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= arguments.size()
     */
    public void setArgument(int index, TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");
        // Check if index is out of range
        CoreDependenciesHelper.checkIndexRange(index, arguments.size(), "index");

        arguments.set(index, argument);
    }

    /**
     * Removes the TemplateArgument instance at the index position from the arguments list.
     *
     * @return TemplateArgument The removed TemplateArgument
     * @param index the position of the TemplateArgument in this list to remove
     * @throws IndexOutOfBoundsException if index &lt; 0 or index &gt;= arguments.size()
     */
    public TemplateArgument removeArgument(int index) {
        // Check if index is out of range
        CoreDependenciesHelper.checkIndexRange(index, arguments.size(), "index");

        return arguments.remove(index);
    }

    /**
     * Removes the first instance, by reference, of the passed TemplateArgument, from the arguments
     * list.
     *
     * @return true if the instance was in the list and was successfully removed, false if it was
     *  not removed, or did not exist in the list
     * @param argument The TemplateArgument to remove from this list
     * @throws IllegalArgumentException if argument is null
     */
    public boolean removeArgument(TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");

        return arguments.remove(argument);
    }

    /**
     * Removes the first instance, by reference, of each passed TemplateArgument from the contained
     * arguments list. It will iterate via the passed collection using its iterator and remove the
     * first instance, by reference, of each passed TemplateArgument, from the contained arguments list.
     *
     * @return boolean True if the state of the contained arguments list has changed, false otherwise.
     * @param arguments Collection of TemplateArgument instances to remove from the contained list
     * @throws IllegalArgumentException if arguments is null or it contains null elements
     */
    public boolean removeArguments(Collection<TemplateArgument> arguments) {
        // Check if arguments is null or contains null argument
        CoreDependenciesHelper.checkCollection(arguments, "arguments");

        boolean ret = false;
        // Remove each one in Collection
        for (Object obj : arguments) {
            if (this.arguments.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the arguments list.
     */
    public void clearArguments() {
        arguments.clear();
    }

    /**
     * Returns a shallow copy of the arguments list.
     *
     * @return shallow copy of the arguments list
     */
    public List<TemplateArgument> getArguments() {
        return new ArrayList<TemplateArgument>(arguments);
    }

    /**
     * Checks if the TemplateArgument is contained in the arguments list. The check is done by
     * reference.
     *
     * @return true if the TemplateArgument is in the list, false otherwise
     * @param argument The TemplateArgument to check for its presence in this list
     * @throws IllegalArgumentException if argument is null
     */
    public boolean containsArgument(TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");

        return arguments.contains(argument);
    }

    /**
     * Gets the index of the appearance of the TemplateArgument, by reference, in the arguments list.
     * It will always return the index of the first instance of the TemplateArgument if there are
     * duplicates in the list. It will return -1 if the TemplateArgument instance is not in the list.
     *
     * @return the index of the TemplateArgument instance in the list, or -1 if not found
     * @param argument TemplateArgument instance to look for
     * @throws IllegalArgumentException if argument is null
     */
    public int indexOfArgument(TemplateArgument argument) {
        // Check if argument is null
        CoreDependenciesHelper.checkNotNull(argument, "argument");

        return arguments.indexOf(argument);
    }

    /**
     * Returns the size of the arguments list.
     *
     * @return the number of elements in the list
     */
    public int countArguments() {
        return arguments.size();
    }
}
