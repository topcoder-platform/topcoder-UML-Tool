/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This is the default implementation of the AssociationEnd interface. An association end is an endpoint of an
 * association, which connects the association to a classifier. Each association end is part of one association. This
 * class also extends ModelElementAbstractImpl to reuse the code that exists in the abstract class. This class has
 * several simple attributes(isNavigable, ordering, aggregation, targetKind, multiplicity, changeability,
 * association participant) that describe an association end. For these simple attributes setters and getters are
 * provided. This class also provides a list attribute(qualifiers) and a collection attribute(specifications) for which
 * a more powerful api is provided. This class is mutable and not thread safe. Since it is a data class it doesn't
 * really makes sense to make it thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public class AssociationEndImpl extends ModelElementAbstractImpl
    implements AssociationEnd {
    /**
     * Specifies whether the association is navigable or not. When placed on a target end, specifies whether traversal
     * from a source instance to its associated target instances is possible. A value of true means that the
     * association can be navigated by the source class. Initial value is false. It can be set using the setter and its
     * value can be queried using the isNavigable method. It is mutable.
     */
    private boolean isNavigable = false;

    /**
     * When placed on a target end, specifies whether the set of links from the source instance to the target instance
     * is ordered. Possibilities are:
     *  - UNORDERED - The links form a set with no inherent ordering.
     *  - ORDERED - A set of ordered links can be scanned in order.
     *  - Other possibilities (such as sorted) may be defined later by declaring additional fields to the OrderingKind
     * enumeration. OrderingKind enumeration has been defined(in UML Model Data Types component) to represent these
     * values. Initial value is null. It can be set using the setter and its value can be queried using the getter.
     * It can be set to null. It is mutable.
     */
    private OrderingKind ordering = null;

    /**
     * When placed on one end (the "target" end), specifies whether the class on the target end is an aggregation with
     * respect to the class on the other end (the "source" end). Only one end can be an aggregation. Possibilities are:
     * - NONE - The target class is not an aggregate.
     * - AGGREGATE - The target class is an aggregate; therefore, the source class is a part and must have the
     *  aggregation value of none. The part may be contained in other aggregates.
     * - COMPOSITE - The target class is a composite; therefore, the source class is a part and must have the
     *  aggregation value of none. The part is strongly owned by the composite and may not be part of any other
     *  composite.
     * AggregationKind enumeration has been defined(in UML Model Data Types component) to represent these values.
     * Initial value is null. It can be set using the setter and its value can be queried using the getter. It can be
     * set to null. It is mutable.
     */
    private AggregationKind aggregation = null;

    /**
     * Specifies whether the target value is an instance or a classifier. Possibilities are:
     *  - INSTANCE - An instance value is part of each link. This is the default.
     *  - CLASSIFIER - A classifier itself is part of each link. Normally this would be fixed at modeling time and need
     *   not be stored separately at run time.
     * ScopeKind enumeration has been defined(in UML Model Data Types component) to represent these values. Initial
     * value is null. It can be set using the setter and its value can be queried using the getter. It can be set to
     * null. It is mutable.
     */
    private ScopeKind targetKind = null;

    /**
     * When placed on a target end, specifies the number of target instances that may be associated with a single
     * source instance across the given Association. Initial value is null. It can be set using the setter and its
     * value can be queried using the getter. It can be set to null. It is mutable.
     */
    private Multiplicity multiplicity = null;

    /**
     * Specifies whether or not links may be created or destroyed after the initialization of objects at the opposite
     * ends. Possibilities are:
     *  - CHANGEABLE - No restrictions on creation and destruction of links.
     *  - FROZEN - No links may be destroyed after the objects at the opposite ends have been initialized, and no new
     *   links may be created after the objects that would participate in the new link at the opposite ends have been
     *   initialized.
     *  - ADD_ONLY - No link may be destroyed after the objects at the opposite ends have been initialized. Links may
     *   be created anytime.
     * ChangeableKind enumeration has been defined(in UML Model Data Types component) to represent these values.
     * Initial value is null. It can be set using the setter and its value can be queried using the getter. It can be
     * set to null. It is mutable.
     */
    private ChangeableKind changeability = null;

    /**
     * Represents the Association instance to which this association end belongs. It can be set using the setter and
     * its value can be queried using the getter. Initial value is null. It can be set to null. It is mutable.
     */
    private Association association = null;

    /**
     * Represents a list of qualifier Attributes for the association end. If the list is empty, then the association is
     * not qualified. For this field a powerful api has been provided to made the interaction easy (methods like
     * add,set,remove,clear, get,contains,indexOf, count have been provided). Initial value is an empty ArrayList.
     * Nulls are not allowed. The instance cannot be modified after initialization but the contents of the list can be
     * modified.
     */
    private final List<Attribute> qualifiers = new ArrayList<Attribute>();

    /**
     * Designates the Classifier participating in the association at the given end. A link of the Association contains
     * a reference to an instance of the class in the given position in the link. Initial value is null. It can be set
     * using the setter and its value can be queried using the getter. It can be set to null. It is mutable.
     */
    private Classifier participant = null;

    /**
     * Designates zero or more Classifiers that specify the Operations that may be applied to an Instance accessed by
     * the AssociationEnd across the Association. For this field a powerful api has been provided to made the
     * interaction easy (methods like add,remove,clear, get,contains, count have been provided). Initial value is an
     * empty ArrayList. Nulls are not allowed. The instance cannot be modified after initialization but the
     * contents of the collection can be modified.
     */
    private final Collection<Classifier> specifications = new ArrayList<Classifier>();

    /**
     * Empty constructor.
     */
    public AssociationEndImpl() {
    }

    /**
     * Setter for the isNavigable field.
     *
     * @param isNavigable this parameter says whether the association is navigable or not.
     */
    public void setNavigable(boolean isNavigable) {
        this.isNavigable = isNavigable;
    }

    /**
     * Tells the user if the association is navigable.
     *
     * @return true if the association is navigable, false otherwise.
     */
    public boolean isNavigable() {
        return this.isNavigable;
    }

    /**
     * Setter for the ordering field. Null is a valid value.
     *
     * @param ordering the new ordering to be set.
     */
    public void setOrdering(OrderingKind ordering) {
        this.ordering = ordering;
    }

    /**
     * Getter for the ordering field.
     *
     * @return the ordering of the current object.
     */
    public OrderingKind getOrdering() {
        return this.ordering;
    }

    /**
     * Setter for the aggregation field. Null is a valid value.
     *
     * @param aggregation the new aggregation to be set.
     */
    public void setAggregation(AggregationKind aggregation) {
        this.aggregation = aggregation;
    }

    /**
     * Getter for the aggregation field.
     *
     * @return the aggregation of the current object.
     */
    public AggregationKind getAggregation() {
        return this.aggregation;
    }

    /**
     * Setter for the targetKind field. Null is a valid value.
     *
     * @param targetKind the new targetKind to be set.
     */
    public void setTargetKind(ScopeKind targetKind) {
        this.targetKind = targetKind;
    }

    /**
     * Getter for the targetKind field.
     *
     * @return the targetKind of the current object.
     */
    public ScopeKind getTargetKind() {
        return this.targetKind;
    }

    /**
     * Setter for the multiplicity field. Null is a valid value.
     *
     * @param multiplicity the new multiplicity to be set.
     */
    public void setMultiplicity(Multiplicity multiplicity) {
        this.multiplicity = multiplicity;
    }

    /**
     * Getter for the multiplicity field.
     *
     * @return the multiplicity of the current object.
     */
    public Multiplicity getMultiplicity() {
        return this.multiplicity;
    }

    /**
     * Setter for the changeability field. Null is a valid value.
     *
     * @param changeability the new changeability to be set.
     */
    public void setChangeability(ChangeableKind changeability) {
        this.changeability = changeability;
    }

    /**
     * Getter for the changeability field.
     *
     * @return the changeability of the current object.
     */
    public ChangeableKind getChangeability() {
        return this.changeability;
    }

    /**
     * Setter for the association field. Null is a valid value.
     *
     * @param association the new association to be set.
     */
    public void setAssociation(Association association) {
        this.association = association;
    }

    /**
     * Getter for the association field.
     *
     * @return the association of the current object.
     */
    public Association getAssociation() {
        return this.association;
    }

    /**
     * Adds a qualifier to the end of the qualifiers list.
     *
     * @param qualifier the qualifier to be added.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addQualifier(Attribute qualifier) {
        checkNull(qualifier, "qualifier");
        this.qualifiers.add(qualifier);
    }

    /**
     * Adds a qualifier at the specified index in the qualifiers list.
     *
     * @param index the index of the qualifier to be added.
     * @param qualifier the qualifier to be added.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > the size of the qualifiers
     *             list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addQualifier(int index, Attribute qualifier) {
        checkNull(qualifier, "qualifier");
        checkOutOfBounds(index, false);
        this.qualifiers.add(index, qualifier);
    }

    /**
     * Replaces the qualifier at the specified position in the qualifiers list with the specified element.
     *
     * @param index the index of the qualifier to be set.
     * @param qualifier the qualifier to be set.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= the size of the qualifiers
     *             list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void setQualifier(int index, Attribute qualifier) {
        checkNull(qualifier, "qualifier");
        checkOutOfBounds(index, true);
        this.qualifiers.set(index, qualifier);
    }

    /**
     * Removes the qualifier at the specified index from the qualifiers list.
     *
     * @return the qualifier at the specified index.
     * @param index the index of qualifier to be removed.
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= the size of the qualifiers
     *             list).
     */
    public Attribute removeQualifier(int index) {
        checkOutOfBounds(index, true);

        return this.qualifiers.remove(index);
    }

    /**
     * Removes the specified qualifier from the qualifiers list.
     *
     * @return true if the qualifier has been removed, false otherwise.
     * @param qualifier the qualifier to be removed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean removeQualifier(Attribute qualifier) {
        checkNull(qualifier, "qualifier");

        return this.qualifiers.remove(qualifier);
    }

    /**
     * Clears the qualifiers list.
     */
    public void clearQualifiers() {
        this.qualifiers.clear();
    }

    /**
     * Retrieves the qualifiers list.
     *
     * @return a shallow copy of qualifiers.
     */
    public List<Attribute> getQualifiers() {
        // Return a copy of the qualifiers list.
        return new ArrayList<Attribute>(this.qualifiers);
    }

    /**
     * Checks whether the specified qualifier is contained in the qualifiers list.
     *
     * @return true if the qualifier is contained,false otherwise.
     * @param qualifier the qualifier to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsQualifier(Attribute qualifier) {
        checkNull(qualifier, "qualifier");

        return this.qualifiers.contains(qualifier);
    }

    /**
     * Gets the index of the specified qualifier in the qualifiers list.
     *
     * @return the index of the qualifier or -1 if not found.
     * @param qualifier the qualifier to be found.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public int indexOfQualifier(Attribute qualifier) {
        checkNull(qualifier, "qualifier");

        return this.qualifiers.indexOf(qualifier);
    }

    /**
     * Retrieves the quantity of qualifiers hold in the qualifiers list.
     *
     * @return the quantity of qualifiers
     */
    public int countQualifiers() {
        return this.qualifiers.size();
    }

    /**
     * Setter for the participant field. Null is a valid value.
     *
     * @param participant the new participant to be set.
     */
    public void setParticipant(Classifier participant) {
        this.participant = participant;
    }

    /**
     * Getter for the participant field.
     *
     * @return the participant of the current object.
     */
    public Classifier getParticipant() {
        return this.participant;
    }

    /**
     * Adds a specification to the end of the specifications collection.
     *
     * @param specification the specification to be added.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addSpecification(Classifier specification) {
        checkNull(specification, "specification");
        this.specifications.add(specification);
    }

    /**
     * Removes the specified specification from the specifications collection.
     *
     * @return true if the specification has been removed, false otherwise.
     * @param specification the specification to be removed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean removeSpecification(Classifier specification) {
        checkNull(specification, "specification");

        return this.specifications.remove(specification);
    }

    /**
     * Clears the specifications collection.
     */
    public void clearSpecifications() {
        this.specifications.clear();
    }

    /**
     * Retrieves the specifications collection.
     *
     * @return a shallow copy of the specifications collection.
     */
    public Collection<Classifier> getSpecifications() {
        // Return a copy of the specifications list.
        return new ArrayList<Classifier>(this.specifications);
    }

    /**
     * Checks whether the specified specification is contained in the specification collection.
     *
     * @return true if the specification is contained, false otherwise.
     * @param specification the specification to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsSpecification(Classifier specification) {
        checkNull(specification, "specification");

        return this.specifications.contains(specification);
    }

    /**
     * Retrieves the quantity of specifications hold in the specifications collection.
     * Simply use the size method from the specifications collection.
     *
     * @return the quantity of specifications.
     */
    public int countSpecifications() {
        return this.specifications.size();
    }

    /**
     * Checks whether the given Object is null.
     *
     * @param obj the obj to be checked.
     * @param name the name of obj.
     * @throws IllegalArgumentException if the obj is null.
     */
    private void checkNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " is null.");
        }
    }

    /**
     * Checks whether the given index is out of bounds.
     *
     * @param index the index to be checked.
     * @param containBound check index whether contain upper bound.
     * @throws IndexOutOfBoundsException if index out of range. the lower bound is 0, the upper bound can be two case:
     * if containBound is true, it should be the size of the connections list, otherwise the size - 1.
     */
    private void checkOutOfBounds(int index, boolean containBound) {
        if (containBound) {
            if (index < 0 || index >= this.qualifiers.size()) {
                throw new IndexOutOfBoundsException("index should not be out of bounds "
                        + "between 0 and the size of qualifiers(both inclusive)");
            }
        } else if (index < 0 || index > this.qualifiers.size()) {
            throw new IndexOutOfBoundsException("index should not be out of bounds "
                + "between 0 and the size of qualifiers(0 inclusive)");
        }
    }
}
