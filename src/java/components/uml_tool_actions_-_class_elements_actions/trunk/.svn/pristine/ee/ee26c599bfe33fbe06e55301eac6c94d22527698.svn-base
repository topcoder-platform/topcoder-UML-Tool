package com.topcoder.uml.model.core.relationships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;

/**
 * This is the default implementation of the AssociationEnd interface. An
 * association end is an endpoint of an association, which connects the
 * association to a classifier. Each association end is part of one association.
 * This class also extends ModelElementAbstractImpl to reuse the code that
 * exists in the abstract class. This class has several simple
 * attributes(isNavigable, ordering, aggregation, targetKind,
 * multiplicity,changeability,associationparticipant) that describe an
 * association end. For these simple attributes setters and getters are
 * provided. This class also provides a list attribute(qualifiers) and a
 * collection attribute(specifications) for which a more powerful api is
 * provided. This class is mutable and not thread safe. Since it is a data class
 * it doesn't realy makes sense to make it thread safe.
 * 
 * @poseidon-object-id [I1c30dfam10b52245c5fmm7d25]
 */
public class AssociationEndImpl extends com.topcoder.uml.model.core.ModelElementAbstractImpl implements
        com.topcoder.uml.model.core.relationships.AssociationEnd {

    /**
     * Specifies wether the asoociation is navigable or not. When placed on a
     * target end, specifies whether traversal from a source instance to its
     * associated target instances is possible. A value of true means that the
     * association can be navigated by the source class. Initial value is null.
     * It can be set using the setter and its value can be queried using the
     * isNavigable method. It is mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7b68]
     */
    private boolean isNavigable = false;

    /**
     * Specifies whether the target value is an instance or a classifier.
     * Possibilities are: ? INSTANCE. An instance value is part of each link.
     * This is the default. ? CLASSIFIER. A classifier itself is part of each
     * link. Normally this would be fixed at modeling time and need not be
     * stored separately at run time. ScopeKind enumeration has been defined(in
     * UML Model Data Types component) to represent these values. Initial value
     * is null. It can be set using the setter and its value can be queried
     * using the getter. It can be set to null. It is mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7b2a]
     */
    private com.topcoder.uml.model.datatypes.ScopeKind targetKind = null;

    /**
     * When placed on a target end, specifies the number of target instances
     * that may be associated with a single source instance across the given
     * Association. Initial value is null. It can be set using the setter and
     * its value can be queried using the getter. It can be set to null. It is
     * mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7b19]
     */
    private com.topcoder.uml.model.datatypes.Multiplicity multiplicity = null;

    /**
     * Specifies whether or not links may be created or destroyed after the
     * initialization of objects at the opposite ends. Possibilities are: ?
     * CHANGEABLE - No restrictions on creation and destruction of links. ?
     * FROZEN - No links may be destroyed after the objects at the opposite ends
     * have been initialized, and no new links may be created after the objects
     * that would participate in the new link at the opposite ends have been
     * initialized. ? ADD_ONLY - No link may be destroyed after the objects at
     * the opposite ends have been initialized. Links may be created anytime.
     * ChangeableKind enumeration has been defined(in UML Model Data Types
     * component) to represent these values. Initial value is null. It can be
     * set using the setter and its value can be queried using the getter. It
     * can be set to null. It is mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7b08]
     */
    private com.topcoder.uml.model.datatypes.ChangeableKind changeability = null;

    /**
     * Represents the Association instance to which this association end
     * belongs. It can be set using the setter and its value can be queried
     * using the getter. Initial value is null. It can be set to null. It is
     * mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7af7]
     */
    private com.topcoder.uml.model.core.relationships.Association association = null;

    /**
     * Represents a list of qualifier Attributes for the association end. If the
     * list is empty, then the association is not qualified. For this field a
     * powerful api has been provided to made the interaction easy (methods like
     * add,set,remove,clear, get,contains,indexOf, count have been provided).
     * Initial value is an empty ArrayList<Attribute>. Nulls are not allowed.
     * The instance cannot be modified after initialization but the contents of
     * the list can be modified.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7ae6]
     */
    private final List<Attribute> qualifiers = new ArrayList<Attribute>();

    /**
     * Designates the Classifier participating in the association at the given
     * end. A link of the Association contains a reference to an instance of the
     * class in the given position in the link. Initial value is null. It can be
     * set using the setter and its value can be queried using the getter. It
     * can be set to null. It is mutable.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7ad4]
     */
    private com.topcoder.uml.model.core.Classifier participant = null;

    /**
     * Designates zero or more Classifiers that specify the Operations that may
     * be applied to an Instance accessed by the AssociationEnd across the
     * Association. For this field a powerful api has been provided to made the
     * interaction easy (methods like add,remove,clear, get,contains, count have
     * been provided). Initial value is an empty ArrayList<Classifier>. Nulls
     * are not allowed. The instance cannot be modified after initialization but
     * the contents of the collection can be modified.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7ac3]
     */
    private final Collection<Classifier> specifications = new ArrayList<Classifier>();

    /**
     * Empty constructor.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7092]
     */
    public AssociationEndImpl() {
        // your code here
    }

    /**
     * Setter for the isNavigable field. Simply set the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm7070]
     * @param isNavigable
     *            this parameter says wether the association is navigable or not
     */
    public void setNavigable(boolean isNavigable) {
        // your code here
    }

    /**
     * Tells the user if the association is navigable. Simply return the value
     * of the isNavigable field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm702b]
     * @return true if the association is navigable, false otherwise
     */
    public boolean isNavigable() {
        // your code here
        return false;
    }

    /**
     * Setter for the targetKind field. Simply set the field.Null is a valid
     * value.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6de9]
     * @param targetKind
     *            the targetKind
     */
    public void setTargetKind(com.topcoder.uml.model.datatypes.ScopeKind targetKind) {
        // your code here
    }

    /**
     * Getter for the targetKind field. Simply return the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6da4]
     * @return the targetKind
     */
    public com.topcoder.uml.model.datatypes.ScopeKind getTargetKind() {
        // your code here
        return null;
    }

    /**
     * Setter for the multiplicity field. Simply set the field.Null is a valid
     * value.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6d17]
     * @param multiplicity
     *            the multiplicity
     */
    public void setMultiplicity(com.topcoder.uml.model.datatypes.Multiplicity multiplicity) {
        // your code here
    }

    /**
     * Getter for the multiplicity field. Simply return the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6cd2]
     * @return the multiplicity
     */
    public com.topcoder.uml.model.datatypes.Multiplicity getMultiplicity() {
        // your code here
        return null;
    }

    /**
     * Setter for the changeability field. Simply set the field.Null is a valid
     * value.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6c45]
     * @param changeability
     *            the changeability
     */
    public void setChangeability(com.topcoder.uml.model.datatypes.ChangeableKind changeability) {
        // your code here
    }

    /**
     * Getter for the changeability field. Simply return the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6c00]
     * @return the changeability
     */
    public com.topcoder.uml.model.datatypes.ChangeableKind getChangeability() {
        // your code here
        return null;
    }

    /**
     * Setter for the association field. Simply set the field.Null is a valid
     * value.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6b73]
     * @param association
     *            the association
     */
    public void setAssociation(com.topcoder.uml.model.core.relationships.Association association) {
        // your code here
    }

    /**
     * Getter for the association field. Simply return the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6b2e]
     * @return the association
     */
    public com.topcoder.uml.model.core.relationships.Association getAssociation() {
        // your code here
        return null;
    }

    /**
     * Adds a qualifier to the end of the qualifiers list. Simply use the
     * corresponding add method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6aa1]
     * @param qualifier
     *            the qualifier
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addQualifier(com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
    }

    /**
     * Adds a qualifier at the specified index in the qualifiers list. Simply
     * use the corresponding add method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6a5c]
     * @param index
     *            the index
     * @param qualifier
     *            the qualifier
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             qualifiers list
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addQualifier(int index, com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
    }

    /**
     * Replaces the qualifier at the specified position in the qualifiers list
     * with the specified element. Simply use the set method from the qualifiers
     * list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm69e8]
     * @param index
     *            the index
     * @param qualifier
     *            the qualifier
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             qualifiers list
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void setQualifier(int index, com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
    }

    /**
     * Removes the qualifier at the specified index from the qualifiers list.
     * Simply use the corresponding remove method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6974]
     * @return the removed qualifier
     * @param index
     *            the index
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             qualifiers list
     */
    public com.topcoder.uml.model.core.Attribute removeQualifier(int index) {
        // your code here
        return null;
    }

    /**
     * Removes the specified qualifier from the qualifiers list. Simply use the
     * corresponding remove method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm692f]
     * @return true if the quelifier has been removed, false otherwise
     * @param qualifier
     *            the qualifier
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean removeQualifier(com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
        return false;
    }

    /**
     * Clears the qualifiers list. Simply use the clear method from the
     * qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm68d4]
     */
    public void clearQualifiers() {
        // your code here
    }

    /**
     * Retrieves the qualifiers list. A copy of the qualifiers list should be
     * returned.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm68bc]
     * @return a copy of the qualifiers list
     */
    public List<Attribute> getQualifiers() {
        // your code here
        return null;
    }

    /**
     * Checks wether the specified qualifier is contained in the qualifiers
     * list. Simply use the contains method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm688b]
     * @return true if the qualifier is contained,false otherwise
     * @param qualifier
     *            the qualifier
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean containsQualifier(com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
        return false;
    }

    /**
     * Gets the index of the specified qualifier in the qualifiers list. Simply
     * use the indexOf method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6830]
     * @return the index of the qualifier or -1 if not found
     * @param qualifier
     *            the qualifier
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public int indexOfQualifier(com.topcoder.uml.model.core.Attribute qualifier) {
        // your code here
        return 0;
    }

    /**
     * Retrieves the number of qualifiers hold in the qualifiers list. Simply
     * use the size method from the qualifiers list.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm67d5]
     * @return the number of qualifiers
     */
    public int countQualifiers() {
        // your code here
        return 0;
    }

    /**
     * Setter for the participant field. Simply set the field.Null is a valid
     * value.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm67b1]
     * @param participant
     *            the participant
     */
    public void setParticipant(com.topcoder.uml.model.core.Classifier participant) {
        // your code here
    }

    /**
     * Getter for the participant field. Simply return the field.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm676c]
     * @return the participant
     */
    public com.topcoder.uml.model.core.Classifier getParticipant() {
        // your code here
        return null;
    }

    /**
     * Adds a specification to the end of the specifications collection. Simply
     * use the add method from the specifications collection.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6748]
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addSpecification(com.topcoder.uml.model.core.Classifier specification) {
        // your code here
        this.specifications.add(specification);
    }

    /**
     * Removes the specified specification from the specifications collection
     * Simply use the remove method from the specifications collection.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6703]
     * @return true if the specification has been removed, false otherwise
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean removeSpecification(com.topcoder.uml.model.core.Classifier specification) {
        // your code here
        return this.specifications.remove(specification);
    }

    /**
     * Clears the specifications collection.. Simply use the clear method from
     * the specifications collection.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm66a8]
     */
    public void clearSpecifications() {
        // your code here
    }

    /**
     * Retrieves the specifications collection. A copy of the specifications
     * collection should be returned.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6690]
     * @return a copy of the specifications collection
     */
    public Collection<Classifier> getSpecifications() {
        // your code here
        return this.specifications;
    }

    /**
     * Checks wether the specified specification is contained in the
     * specification collection. Simply use the contains method from the
     * specifications collection
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm666c]
     * @return true if the specification is contained, false otherwise
     * @param specification
     *            the specification
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean containsSpecification(com.topcoder.uml.model.core.Classifier specification) {
        // your code here
        return this.specifications.contains(specification);
    }

    /**
     * Retrieves the number of specifications hold in the specifications
     * collection Simply use the size method from the specifications collection.
     * 
     * @poseidon-object-id [I1c30dfam10b52245c5fmm6611]
     * @return the number of specifications
     */
    public int countSpecifications() {
        // your code here
        return 0;
    }
}
