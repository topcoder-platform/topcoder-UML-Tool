/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.collaborations.accuracytests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.core.Classifier;

/**
 * Accuracy tests for the {@link CollaborationInstanceSetImpl} class.
 * 
 * @author kr00tki
 * @version 1.0
 */
public class CollaborationInstanceSetImplAccuracyTest extends TestCase {

	/**
	 * The Instance instance used in tests.
	 */
	private static final Instance INSTANCE = new DummyInstance();
	
	/**
	 * The Link implementation used in tests.
	 */
	private static final Link LINK = new DummyLink();
	
	/**
	 * The CollaborationInstanceSetImpl instance to test on.
	 */
	private CollaborationInstanceSetImpl impl = null;
	
	/**
	 * Sets up test environment.
	 */
	protected void setUp() {
		impl = new CollaborationInstanceSetImpl();
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#CollaborationInstanceSetImpl() } constructor accuracy.
	 * Checks if the private field have correct default values. 
	 */
	public void testCollaborationInstanceSetImpl() {
		assertNull("Collaboration should be null.", impl.getCollaboration());
		assertNotNull("Participating instances collection should be initialized.", impl.getParticipatingInstances());
		assertNotNull("Participating links collection should be initialized.", impl.getParticipatingLinks());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#getCollaboration()} and 
	 * {@link CollaborationInstanceSetImpl#setCollaboration(Collaboration)} method accuracy. 
	 */
	public void testSetGetCollaboration() {
		Collaboration collab = new CollaborationImpl();
		impl.setCollaboration(collab);
		assertSame("The collaboration should be set.", collab, impl.getCollaboration());
		
		impl.setCollaboration(null);
		assertNull("Collaboration should be null.", impl.getCollaboration());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#addParticipatingInstance(Instance) } method accuracy. 
	 */
	public void testAddParticipatingInstance() {
		impl.addParticipatingInstance(INSTANCE);
		Collection<Instance> instances = impl.getParticipatingInstances();
		assertEquals("Should have one instance", 1, instances.size());
		assertSame("Incorrect instance", INSTANCE, instances.iterator().next());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl# addParticipatingInstances(Collection)} method accuracy. 
	 */
	public void testAddParticipatingInstances() {
		impl.addParticipatingInstance(INSTANCE);
		List<Instance> collection = new ArrayList<Instance>();
		collection.add(new DummyInstance());
		
		impl.addParticipatingInstances(collection);
		
		Collection<Instance> instances = impl.getParticipatingInstances();
		assertEquals("Should have 2 instances", 2, instances.size());
		assertTrue("Should contain instance", instances.contains(INSTANCE));
		assertTrue("Should contain instance", instances.contains(collection.get(0)));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#removeParticipatingInstance(Instance) } method accuracy. 
	 */
	public void testRemoveParticipatingInstance() {
		assertFalse("Should return false", impl.removeParticipatingInstance(INSTANCE));
		impl.addParticipatingInstance(INSTANCE);
		impl.addParticipatingInstance(INSTANCE);
		
		assertEquals("Should have 2 instances", 2, impl.getParticipatingInstances().size());
		
		assertTrue("The instance should be removed.", impl.removeParticipatingInstance(INSTANCE));
		assertEquals("Instances should be removed", 1, impl.getParticipatingInstances().size());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#removeParticipatingInstances(Collection) } method accuracy. 
	 */
	public void testRemoveParticipatingInstances() {
		Collection<Instance> instances = Collections.singleton(INSTANCE);
		assertFalse("Should return false", impl.removeParticipatingInstances(instances));
		
		impl.addParticipatingInstance(INSTANCE);
		impl.addParticipatingInstance(new DummyInstance());
		
		assertTrue("The instance should be removed.", impl.removeParticipatingInstances(instances));
		
		assertEquals("One instance should left.", 1, impl.getParticipatingInstances().size());
		assertFalse("The instance should be removed.", impl.containsParticipatingInstance(INSTANCE));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#addParticipatingInstances(Collection) } method accuracy. 
	 */
	public void testClearParticipatingInstances() {
		impl.addParticipatingInstance(INSTANCE);
		assertEquals("One instance should left.", 1, impl.countParticipatingInstances());
		impl.clearParticipatingInstances();
		assertEquals("Instances should be removed.", 0, impl.getParticipatingInstances().size());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#getParticipatingInstances() } method accuracy. 
	 */
	public void testGetParticipatingInstances() {
		assertNotSame("A shallow copy should be returned.", impl.getParticipatingInstances(), 
				impl.getParticipatingInstances());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#containsParticipatingInstance(Instance) } method accuracy. 
	 */
	public void testContainsParticipatingInstance() {
		assertFalse("Shouldn't contain instance", impl.containsParticipatingInstance(INSTANCE));
		impl.addParticipatingInstance(INSTANCE);
		assertTrue("Should contain instance", impl.containsParticipatingInstance(INSTANCE));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#countParticipatingInstances() } method accuracy. 
	 */
	public void testCountParticipatingInstances() {
		assertEquals("Should have 0 instances.", 0, impl.countParticipatingInstances());
		impl.addParticipatingInstance(INSTANCE);
		assertEquals("Should have one instance.", 1, impl.countParticipatingInstances());
	}


	/**
	 * Tests the {@link CollaborationInstanceSetImpl#addParticipatingLink(Link) } method accuracy. 
	 */
	public void testAddParticipatingLink() {
		impl.addParticipatingLink(LINK);
		Collection<Link> links = impl.getParticipatingLinks();
		assertEquals("Should have one link", 1, links.size());
		assertSame("Incorrect instance", LINK, links.iterator().next());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#addParticipatingLinks(Collection)} method accuracy. 
	 */
	public void testAddParticipatingLinks() {
		impl.addParticipatingLink(LINK);
		List<Link> collection = new ArrayList<Link>();
		collection.add(new DummyLink());
		
		impl.addParticipatingLinks(collection);
		
		Collection<Link> links = impl.getParticipatingLinks();
		assertEquals("Should have 2 instances", 2, links.size());
		assertTrue("Should contain link", links.contains(LINK));
		assertTrue("Should contain link", links.contains(collection.get(0)));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#removeParticipatingLink(Link)} method accuracy. 
	 */
	public void testRemoveParticipatingLink() {
		assertFalse("Should return false", impl.removeParticipatingLink(LINK));
		impl.addParticipatingLink(LINK);
		impl.addParticipatingLink(LINK);
		
		assertEquals("Should have 2 instances", 2, impl.getParticipatingLinks().size());
		
		assertTrue("The instance should be removed.", impl.removeParticipatingLink(LINK));
		assertEquals("Instances should be removed", 1, impl.getParticipatingLinks().size());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#removeParticipatingLinks(Collection)} method accuracy. 
	 */
	public void testRemoveParticipatingLinks() {
		Collection<Link> links = Collections.singleton(LINK);
		assertFalse("Should return false", impl.removeParticipatingLinks(links));
		
		impl.addParticipatingLink(LINK);
		impl.addParticipatingLink(new DummyLink());
		
		assertTrue("The link should be removed.", impl.removeParticipatingLinks(links));
		
		assertEquals("One link should left.", 1, impl.getParticipatingLinks().size());
		assertFalse("The link should be removed.", impl.containsParticipatingLink(LINK));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#clearParticipatingLinks() } method accuracy. 
	 */
	public void testClearParticipatingLinks() {
		impl.addParticipatingLink(LINK);
		assertEquals("One link should left.", 1, impl.countParticipatingLinks());
		impl.clearParticipatingLinks();
		assertEquals("Link should be removed.", 0, impl.getParticipatingLinks().size());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#getParticipatingLinks() } method accuracy. 
	 */
	public void testGetParticipatingLinks() {
		assertNotSame("A shallow copy should be returned.", impl.getParticipatingLinks(), 
				impl.getParticipatingLinks());
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#containsParticipatingLink(Link) } method accuracy. 
	 */
	public void testContainsParticipatingLink() {
		assertFalse("Shouldn't contain instance", impl.containsParticipatingLink(LINK));
		impl.addParticipatingLink(LINK);
		assertTrue("Should contain instance", impl.containsParticipatingLink(LINK));
	}

	/**
	 * Tests the {@link CollaborationInstanceSetImpl#countParticipatingLinks()} method accuracy. 
	 */
	public void testCountParticipatingLinks() {
		assertEquals("Should have 0 links.", 0, impl.countParticipatingLinks());
		impl.addParticipatingLink(LINK);
		assertEquals("Should have one link.", 1, impl.countParticipatingLinks());
	}
	
	/**
	 * Dummy implementation of the {@link Instance} interface. The methods may stay unimplemnted.
	 * 
	 * @author kr00tki
	 * @version 1.0
	 */
	private static class DummyInstance extends DummyModelElement implements Instance {

		public void addLinkEnd(LinkEnd linkEnd) {
			// TODO Auto-generated method stub
			
		}

		public void addLinkEnds(Collection<LinkEnd> linkEnds) {
			// TODO Auto-generated method stub
			
		}

		public void addOwnedLink(Link ownedLink) {
			// TODO Auto-generated method stub
			
		}

		public void addOwnedLinks(Collection<Link> ownedLinks) {
			// TODO Auto-generated method stub
			
		}

		public void addReceiveStimuli(Collection<Stimulus> receiveStimuli) {
			// TODO Auto-generated method stub
			
		}

		public void addReceiveStimulus(Stimulus receiveStimulus) {
			// TODO Auto-generated method stub
			
		}

		public void addSendStimuli(Collection<Stimulus> sendStimuli) {
			// TODO Auto-generated method stub
			
		}

		public void addSendStimulus(Stimulus sendStimulus) {
			// TODO Auto-generated method stub
			
		}

		public void clearLinkEnds() {
			// TODO Auto-generated method stub
			
		}

		public void clearOwnedLinks() {
			// TODO Auto-generated method stub
			
		}

		public void clearReceiveStimuli() {
			// TODO Auto-generated method stub
			
		}

		public void clearSendStimuli() {
			// TODO Auto-generated method stub
			
		}

		public boolean containsLinkEnd(LinkEnd linkEnd) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsOwnedLink(Link ownedLink) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsReceiveStimulus(Stimulus receiveStimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsSendStimulus(Stimulus sendStimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public int countLinkEnds() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countOwnedLinks() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countReceiveStimuli() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countSendStimuli() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Classifier getClassifier() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<LinkEnd> getLinkEnds() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Link> getOwnedLinks() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Stimulus> getReceiveStimuli() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Stimulus> getSendStimuli() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean removeLinkEnd(LinkEnd linkEnd) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeLinkEnds(Collection<LinkEnd> linkEnds) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeOwnedLink(Link ownedLink) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeOwnedLinks(Collection<Link> ownedLinks) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeReceiveStimuli(Collection<Stimulus> receiveStimuli) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeReceiveStimulus(Stimulus receiveStimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeSendStimuli(Collection<Stimulus> sendStimuli) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeSendStimulus(Stimulus sendStimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public void setClassifier(Classifier classifier) {
			// TODO Auto-generated method stub
			
		}

			
	}
	
	/**
	 * Dummy implementation of the {@link Link} interface. The methods may stay unimplemnted.
	 * 
	 * @author kr00tki
	 * @version 1.0
	 */
	private static class DummyLink extends DummyModelElement implements Link {

		public void addConnection(LinkEnd connection) {
			// TODO Auto-generated method stub
			
		}

		public void addConnection(int index, LinkEnd connection) {
			// TODO Auto-generated method stub
			
		}

		public void addConnections(Collection<LinkEnd> connections) {
			// TODO Auto-generated method stub
			
		}

		public void addConnections(int index, Collection<LinkEnd> connections) {
			// TODO Auto-generated method stub
			
		}

		public void addStimuli(Collection<Stimulus> stimuli) {
			// TODO Auto-generated method stub
			
		}

		public void addStimulus(Stimulus stimulus) {
			// TODO Auto-generated method stub
			
		}

		public void clearConnections() {
			// TODO Auto-generated method stub
			
		}

		public void clearStimuli() {
			// TODO Auto-generated method stub
			
		}

		public boolean containsConnection(LinkEnd connection) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsStimulus(Stimulus stimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public int countConnections() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countStimuli() {
			// TODO Auto-generated method stub
			return 0;
		}

		public List<LinkEnd> getConnections() {
			// TODO Auto-generated method stub
			return null;
		}

		public Instance getOwner() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<Stimulus> getStimuli() {
			// TODO Auto-generated method stub
			return null;
		}

		public int indexOfConnection(LinkEnd connection) {
			// TODO Auto-generated method stub
			return 0;
		}

		public LinkEnd removeConnection(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean removeConnection(LinkEnd connection) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeConnections(Collection<LinkEnd> connections) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeStimuli(Collection<Stimulus> stimuli) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeStimulus(Stimulus stimulus) {
			// TODO Auto-generated method stub
			return false;
		}

		public void setConnection(int index, LinkEnd connection) {
			// TODO Auto-generated method stub
			
		}

		public void setOwner(Instance owner) {
			// TODO Auto-generated method stub
			
		}

		
	}
}
