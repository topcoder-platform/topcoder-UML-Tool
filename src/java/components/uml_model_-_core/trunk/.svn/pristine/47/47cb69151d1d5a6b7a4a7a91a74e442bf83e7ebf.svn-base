/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import junit.framework.TestCase;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * <p>
 * The UML metamodel contains a set of metaclasses (classes whose instances are classes themselves) that are grouped in
 * packages, whose members are logically homogeneous to manage language complexity. The "Foundation" package specifies
 * the static structure of models, that is, it contains the metaclasses whose instances are the fundamental entities
 * building up UML models (attributes, methods, and so on). The "Core" subpackage defines the very basic abstract and
 * concrete metamodel constructs needed for the development of object models.
 * </p>
 * <p>
 * This component is a consistent set of Java classes that represent the great part of the metaclasses contained in the
 * "Core" package of the UML 1.5 Specification. Not all metaclasses and attributes of the "Core" package are covered in
 * this design; the less used features are left to be implemented by a future version of the component. This component
 * is part of a greater group of components, the UML Model, that provides representations of the great part of the UML
 * metamodel.
 * </p>
 * <p>
 * This component, along with the rest of the UML Model "macrocomponent", can be easily used in a UML Tool that uses the
 * MVC (Model-View-Controller) architecture pattern. In particular, this component is intended to be used mainly in the
 * TopCoder UML Tool, so it follows its Architecture requirements and documentation.
 * </p>
 * <p>
 * This class provides the demo usage of this component.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * This class extends <code>NamespaceAbstractImpl</code>. It is only used in unit test.
     */
    private class NamespaceImpl extends NamespaceAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public NamespaceImpl() {
        }
    }

    /**
     * This class extends <code>ModelElementAbstractImpl</code>. It is only used in unit test.
     */
    private class ModelElementImpl extends ModelElementAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ModelElementImpl() {
        }
    }

    /**
     * <p>
     * This class extends the <code>ClassifierAbstractImpl</code>. It is only used in unit test.
     * </p>
     */
    private class ClassifierImpl extends ClassifierAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ClassifierImpl() {
        }
    }

    /**
     * This class extends the <code>FeatureAbstractImpl</code>. It is only used in unit test.
     */
    private class FeatureImpl extends FeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public FeatureImpl() {
        }
    }

    /**
     * This class implements a Core interface, make it can save all AssociationEnds and Expressions.
     */
    private class RegisteringAttribute extends StructuralFeatureAbstractImpl implements Attribute {

        /**
         * The value set.
         */
        private final Collection<Expression> values = new HashSet<Expression>();

        /**
         * The end set.
         */
        private final Collection<AssociationEnd> ends = new HashSet<AssociationEnd>();

        /**
         * Holds the initial value.
         */
        private Expression initialValue;

        /**
         * Holds the association end.
         */
        private AssociationEnd associationEnd;

        /**
         * The default constructor.
         */
        public RegisteringAttribute() {
        }

        /**
         * Sets the initial value.
         *
         * @param initialValue
         *            the initial value to set
         */
        public void setInitialValue(Expression initialValue) {
            if (initialValue != null) {
                values.add(initialValue);
            }
            this.initialValue = initialValue;
        }

        /**
         * Gets the initial value.
         *
         * @return the initial value
         */
        public Expression getInitialValue() {
            return initialValue;
        }

        /**
         * Sets the association end.
         *
         * @param associationEnd
         *            the association end to set
         */
        public void setAssociationEnd(AssociationEnd associationEnd) {
            if (associationEnd != null) {
                ends.add(associationEnd);
            }
            this.associationEnd = associationEnd;
        }

        /**
         * Gets the association end.
         *
         * @return the association end
         */
        public AssociationEnd getAssociationEnd() {
            return associationEnd;
        }

        /**
         * Gets all the initial values.
         *
         * @return all the initial values
         */
        public Collection<Expression> getAllInitialValues() {
            return new HashSet<Expression>(values);
        }

        /**
         * Gets all the association ends.
         *
         * @return all the association ends
         */
        public Collection<AssociationEnd> getAllAssociationEnds() {
            return new HashSet<AssociationEnd>(ends);
        }
    }

    /**
     * This class extends a Core class, it can't be created.
     */
    private class ImmutableNamespace extends NamespaceAbstractImpl {

        /**
         * Creates an <code>ImmutableNamespace</code> instance.
         *
         * @param elements
         *            the elements the <code>ImmutableNamespace</code> instance will hold
         */
        public ImmutableNamespace(Collection<ModelElement> elements) {
            Iterator<ModelElement> iter = elements.iterator();
            while (iter.hasNext()) {
                addOwnedElement(iter.next());
            }
        }

        /**
         * Adds owned element.
         *
         * @param ownedElement
         *            the owned element to add
         */
        public void addOwnedElement(ModelElement ownedElement) {
            throw new UnsupportedOperationException("Addition of elements not supported");
        }

        /**
         * Removes owned element.
         *
         * @param ownedElement
         *            the owned element to removed
         * @return true if removed, otherwise false
         */
        public boolean removeOwnedElement(ModelElement ownedElement) {
            throw new UnsupportedOperationException("Removal of elements not supported");
        }

        /**
         * Clears owned elements.
         */
        public void clearOwnedElements() {
            throw new UnsupportedOperationException("Removal of elements not supported");
        }
    }

    /**
     * This test case show the demo usage of this component.
     */
    public void testDemo() {
        // Create ImmutableNamespace object, should throw UnsupportedOperationException
        try {
            Collection<ModelElement> elements = new HashSet<ModelElement>();
            elements.add(new ModelElementImpl());
            new ImmutableNamespace(elements);
            fail("UnsupportedOperationException should be thrown.");
        } catch (UnsupportedOperationException e) {
            // success
        }

        RegisteringAttribute rAttribute = new RegisteringAttribute();
        rAttribute.setAssociationEnd(new AssociationEndImpl());
        rAttribute.setAssociationEnd(new AssociationEndImpl());
        System.out.println(rAttribute.getAllAssociationEnds().size());
        // Should be "2";

        // Instantiate Core objects
        Namespace com = new NamespaceImpl();
        Namespace topcoder = new NamespaceImpl();
        Namespace puzzle = new NamespaceImpl();
        ModelElement classesMdl = new ModelElementImpl();
        ModelElement usecasesMdl = new ModelElementImpl();
        Parameter retValue = new ParameterImpl();
        Operation addItems = new OperationImpl();

        // Set core objects non-collection attributes
        classesMdl.setName("Puzzle Classes");
        usecasesMdl.setName("Puzzle Use Cases");
        retValue.setKind(ParameterDirectionKind.RETURN);
        addItems.setConcurrency(CallConcurrencyKind.SEQUENTIAL);
        addItems.setLeaf(true);
        addItems.setAbstract(false);

        // Manipulate core objects' collections
        System.out.println(addItems.countMethods()); // Should output "0";

        com.addOwnedElement(topcoder);
        topcoder.addOwnedElement(puzzle);
        puzzle.addOwnedElement(classesMdl);
        puzzle.addOwnedElement(usecasesMdl);
        System.out.println(puzzle.countOwnedElements()); // Should print "2"

        Iterator<ModelElement> iter = puzzle.getOwnedElements().iterator();
        while (iter.hasNext()) {
            ModelElement e = iter.next();
            System.out.println(e.getName());
        }
        // This cycle should print "Puzzle Classes" and "Puzzle Use Cases".
        // The order is unspecified, since the collection of owned elements in Namespace is unordered.

        System.out.println(puzzle.containsOwnedElement(classesMdl));
        // Should output "true"

        System.out.println(puzzle.containsOwnedElement(com));
        // Should output "false", since "com" namespace is not contained in package "puzzle".

        puzzle.clearOwnedElements();
        System.out.println(puzzle.countOwnedElements());
        // Should output "0"

        topcoder.removeOwnedElement(puzzle);
        System.out.println(topcoder.countOwnedElements());
        // Should output "0", since "puzzle" was the only element in "topcoder" package

        // Manipulate core objects' ordered collections
        Classifier classifier = new ClassifierImpl();
        Feature featureA = new FeatureImpl();
        Feature featureB = new FeatureImpl();

        System.out.println(classifier.indexOfFeature(featureA));
        // Should print "-1"

        classifier.addFeature(featureA);
        System.out.println(classifier.indexOfFeature(featureA));
        // Should print "0"

        classifier.setFeature(0, featureB);
        System.out.println(classifier.countFeatures());
        // Should print "1", since feature B replaced A
    }
}
