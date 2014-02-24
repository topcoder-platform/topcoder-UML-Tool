/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.collaborations.accuracytests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * The accuracy tests for the {@link CollaborationImpl} class.
 * 
 * @author kr00tki
 * @version 1.0
 */
public class CollaborationImplAccuracyTest extends TestCase {

	/**
	 * The CollaborationInstanceSet instance used in tests.
	 */
	private static final CollaborationInstanceSet SET = new CollaborationInstanceSetImpl();
	
	/**
	 * The ModelElement instance used in tests.
	 */
	private static final ModelElement ELEMENT = new DummyElement();
	
	/**
	 * The CollaborationImpl to test on.
	 */
	private CollaborationImpl impl = null;
	
	/**
	 * Sets up test environment.
	 */
	protected void setUp() {
		impl = new CollaborationImpl();
	}

	/**
	 * Tests the constructor accuracy. Checks if internal fields are initialized.
	 *
	 */
	public void testCollaborationImpl() {
		assertNotNull("The collabortion instancs set should not be null.", impl.getCollaborationInstanceSets());
	}

	/**
	 * Tests the{@link CollaborationImpl#addCollaborationInstanceSet(CollaborationInstanceSet)} method
	 * accuracy. Checks if the given object is added to internal collection.
	 *
	 */
	public void testAddCollaborationInstanceSet() {
		impl.addCollaborationInstanceSet(SET);
		Collection<CollaborationInstanceSet> sets = impl.getCollaborationInstanceSets();
		assertEquals("Should have one set", 1, sets.size());
		assertSame("Incorrect instance", SET, sets.iterator().next());
	}

	/**
	 * Tests the{@link CollaborationImpl#addCollaborationInstanceSets(Collection)} method
	 * accuracy. Checks if the given collection is copied to the internal one.
	 *
	 */
	public void testAddCollaborationInstanceSets() {
		impl.addCollaborationInstanceSet(SET);
		List<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
		collection.add(new CollaborationInstanceSetImpl());
		
		impl.addCollaborationInstanceSets(collection);
		
		Collection<CollaborationInstanceSet> sets = impl.getCollaborationInstanceSets();
		assertEquals("Should have 2 sets", 2, sets.size());
		assertTrue("Should contain instance", sets.contains(SET));
		assertTrue("Should contain instance", sets.contains(collection.get(0)));
	}

	/**
	 * Tests the {@link CollaborationImpl#removeCollaborationInstanceSet(CollaborationInstanceSet)}
	 * method accuracy.
	 *
	 */
	public void testRemoveCollaborationInstanceSet() {
		assertFalse("Should return false", impl.removeCollaborationInstanceSet(SET));
		impl.addCollaborationInstanceSet(SET);
		impl.addCollaborationInstanceSet(SET);
		
		assertEquals("Should have 2 sets", 2, impl.getCollaborationInstanceSets().size());
		
		assertTrue("The set should be removed.", impl.removeCollaborationInstanceSet(SET));
		assertEquals("Set should be removed", 1, impl.getCollaborationInstanceSets().size());
	}

	/**
	 * Tests the {@link CollaborationImpl#removeCollaborationInstanceSets(Collection)} method accuracy.
	 *
	 */
	public void testRemoveCollaborationInstanceSets() {
		Collection<CollaborationInstanceSet> instances = Collections.singleton(SET);
		assertFalse("Should return false", impl.removeCollaborationInstanceSets(instances));
		
		impl.addCollaborationInstanceSet(SET);
		impl.addCollaborationInstanceSet(new CollaborationInstanceSetImpl());
		
		assertTrue("The set should be removed.", impl.removeCollaborationInstanceSets(instances));
		
		assertEquals("One set should left.", 1, impl.getCollaborationInstanceSets().size());
		assertFalse("The instance should be removed.", impl.containsCollaborationInstanceSet(SET));
	}

	/**
	 * Tests the {@link CollaborationImpl#clearCollaborationInstanceSets()} method accuracy.
	 *
	 */
	public void testClearCollaborationInstanceSets() {
		impl.addCollaborationInstanceSet(SET);
		assertEquals("One set should left.", 1, impl.countCollaborationInstanceSets());
		impl.clearCollaborationInstanceSets();
		assertEquals("Instances should be removed.", 0, impl.getCollaborationInstanceSets().size());
	}

	/**
	 * Tests the {@link CollaborationImpl#getCollaborationInstanceSets()} method accuracy.
	 *
	 */
	public void testGetCollaborationInstanceSets() {
		assertNotSame("A shallow copy should be returned.", impl.getCollaborationInstanceSets(), 
				impl.getCollaborationInstanceSets());
	}

	/**
	 * Tests the {@link CollaborationImpl#containsCollaborationInstanceSet(CollaborationInstanceSet)}
	 * method accuracy.
	 *
	 */
	public void testContainsCollaborationInstanceSet() {
		assertFalse("Shouldn't contain set", impl.containsCollaborationInstanceSet(SET));
		impl.addCollaborationInstanceSet(SET);
		assertTrue("Should contain instance", impl.containsCollaborationInstanceSet(SET));
	}

	/**
	 * Tests the {@link CollaborationImpl#countCollaborationInstanceSets()} method accuracy.
	 *
	 */
	public void testCountCollaborationInstanceSets() {
		assertEquals("Should have 0 instances.", 0, impl.countCollaborationInstanceSets());
		impl.addCollaborationInstanceSet(SET);
		assertEquals("Should have one instance.", 1, impl.countCollaborationInstanceSets());
	}

	/**
	 * Tests the {@link CollaborationImpl#addOwnedElement(ModelElement)} method accuracy.
	 *
	 */
	public void testAddOwnedElement() {
		impl.addOwnedElement(ELEMENT);
		assertSame("Incorrect element", ELEMENT, impl.getOwnedElements().toArray()[0]);
	}

	/**
	 * Tests the {@link CollaborationImpl#removeOwnedElement(ModelElement)} method accuracy.
	 *
	 */
	public void testRemoveOwnedElement() {
		assertFalse("Should not remove element", impl.removeOwnedElement(ELEMENT));
		impl.addOwnedElement(ELEMENT);
		assertTrue("Should remove element", impl.removeOwnedElement(ELEMENT));
		assertEquals("Should be empty.", 0, impl.countOwnedElements());
	}

	/**
	 * Tests the {@link CollaborationImpl#countOwnedElements()} method accuracy.
	 *
	 */
	public void testClearOwnedElements() {
		impl.addOwnedElement(ELEMENT);
		assertEquals("Should have one element.", 1, impl.countOwnedElements());
		impl.clearOwnedElements();
		assertEquals("Should be empty.", 0, impl.countOwnedElements());
	}

	/**
	 * Tests the {@link CollaborationImpl#getOwnedElements()} method accuracy.
	 */
	public void testGetOwnedElements() {
		assertNotSame("A shallow copy should be returned.", impl.getOwnedElements(), 
				impl.getOwnedElements());
	}

	/**
	 * Tests the {@link CollaborationImpl#containsOwnedElement(ModelElement)} method accuracy.
	 */
	public void testContainsOwnedElement() {
		assertFalse("Should not contain element", impl.containsOwnedElement(ELEMENT));
		impl.addOwnedElement(ELEMENT);
		assertTrue("Should contain element", impl.containsOwnedElement(ELEMENT));
	}

	/**
	 * Dummy implementation of the {@link ModelElement} interface. All the method may be empty.
	 * 
	 * @author kr00tki
	 * @version 1.0
	 */
	private static class DummyElement implements ModelElement {

		public void addBehavior(StateMachine behavior) {
			// TODO Auto-generated method stub
			
		}

		public void addClientDependency(Dependency clientDependency) {
			// TODO Auto-generated method stub
			
		}

		public void addComment(Comment comment) {
			// TODO Auto-generated method stub
			
		}

		public void addDefaultParameter(TemplateParameter defaultParameter) {
			// TODO Auto-generated method stub
			
		}

		public void addElementImport(ElementImport elementImport) {
			// TODO Auto-generated method stub
			
		}

		public void addReferenceTag(TaggedValue referenceTag) {
			// TODO Auto-generated method stub
			
		}

		public void addStereotype(Stereotype stereotype) {
			// TODO Auto-generated method stub
			
		}

		public void addSupplierDependency(Dependency supplierDependency) {
			// TODO Auto-generated method stub
			
		}

		public void addTaggedValue(TaggedValue taggedValue) {
			// TODO Auto-generated method stub
			
		}

		public void addTemplateArgument(TemplateArgument templateArgument) {
			// TODO Auto-generated method stub
			
		}

		public void addTemplateParameter(TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			
		}

		public void addTemplateParameter(int index, TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			
		}

		public void clearBehaviors() {
			// TODO Auto-generated method stub
			
		}

		public void clearClientDependencies() {
			// TODO Auto-generated method stub
			
		}

		public void clearComments() {
			// TODO Auto-generated method stub
			
		}

		public void clearDefaultParameters() {
			// TODO Auto-generated method stub
			
		}

		public void clearElementImports() {
			// TODO Auto-generated method stub
			
		}

		public void clearReferenceTags() {
			// TODO Auto-generated method stub
			
		}

		public void clearStereotypes() {
			// TODO Auto-generated method stub
			
		}

		public void clearSupplierDependencies() {
			// TODO Auto-generated method stub
			
		}

		public void clearTaggedValues() {
			// TODO Auto-generated method stub
			
		}

		public void clearTemplateArguments() {
			// TODO Auto-generated method stub
			
		}

		public void clearTemplateParameters() {
			// TODO Auto-generated method stub
			
		}

		public boolean containsBehavior(StateMachine behavior) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsClientDependency(Dependency clientDependency) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsComment(Comment comment) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsDefaultParameter(TemplateParameter defaultParameter) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsElementImport(ElementImport elementImport) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsReferenceTag(TaggedValue referenceTag) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsStereotype(Stereotype stereotype) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsSupplierDependency(Dependency supplierDependency) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsTaggedValue(TaggedValue taggedValue) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsTemplateArgument(TemplateArgument templateArgument) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsTemplateParameter(TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			return false;
		}

		public int countBehaviors() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countClientDependencies() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countComments() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countDefaultParameters() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countElementImports() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countReferenceTags() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countStereotypes() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countSupplierDependencies() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countTaggedValues() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countTemplateArguments() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countTemplateParameters() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Collection<StateMachine> getBehaviors() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Dependency> getClientDependencies() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Comment> getComments() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<TemplateParameter> getDefaultParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<ElementImport> getElementImports() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public Namespace getNamespace() {
			// TODO Auto-generated method stub
			return null;
		}

		public TemplateParameter getParameterTemplate() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<TaggedValue> getReferenceTags() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Stereotype> getStereotypes() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Dependency> getSupplierDependencies() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<TaggedValue> getTaggedValues() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<TemplateArgument> getTemplateArguments() {
			// TODO Auto-generated method stub
			return null;
		}

		public List<TemplateParameter> getTemplateParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		public VisibilityKind getVisibility() {
			// TODO Auto-generated method stub
			return null;
		}

		public int indexOfTemplateParameter(TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			return 0;
		}

		public boolean isSpecification() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeBehavior(StateMachine behavior) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeClientDependency(Dependency clientDependency) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeComment(Comment comment) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeDefaultParameter(TemplateParameter defaultParameter) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeElementImport(ElementImport elementImport) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeReferenceTag(TaggedValue referenceTag) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeStereotype(Stereotype stereotype) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeSupplierDependency(Dependency supplierDependency) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeTaggedValue(TaggedValue taggedValue) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeTemplateArgument(TemplateArgument templateArgument) {
			// TODO Auto-generated method stub
			return false;
		}

		public TemplateParameter removeTemplateParameter(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean removeTemplateParameter(TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			return false;
		}

		public void setName(String name) {
			// TODO Auto-generated method stub
			
		}

		public void setNamespace(Namespace namespace) {
			// TODO Auto-generated method stub
			
		}

		public void setParameterTemplate(TemplateParameter parameterTemplate) {
			// TODO Auto-generated method stub
			
		}

		public void setSpecification(boolean isSpecification) {
			// TODO Auto-generated method stub
			
		}

		public void setTemplateParameter(int index, TemplateParameter templateParameter) {
			// TODO Auto-generated method stub
			
		}

		public void setVisibility(VisibilityKind visibility) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
