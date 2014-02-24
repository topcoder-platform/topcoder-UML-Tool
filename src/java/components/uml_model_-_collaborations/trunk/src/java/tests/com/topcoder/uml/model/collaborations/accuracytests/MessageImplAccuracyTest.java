/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.collaborations.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationroles.Message;
import com.topcoder.uml.model.collaborations.collaborationroles.MessageImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * Accuracy tests for the {@link MessageImpl} class.
 * 
 * @author kr00tki
 * @version 1.0
 */
public class MessageImplAccuracyTest extends TestCase {

	/**
	 * The Stimulus instance used in tests.
	 */
	private Stimulus stimulus = new DummyStimulus();
	
	/**
	 * Tests the {@link MessageImpl#MessageImpl())} constructor. Checks if no exception is thrown.
	 *
	 */
	public void testMessageImpl() {
		Message msg = new MessageImpl();
	}

	/**
	 * Tests the {@link MessageImpl#getConformingStimulus()} and
	 * the {@link MessageImpl#setConformingStimulus(Stimulus)} methods accuracy.
	 *
	 */
	public void testGetConformingStimulus() {
		Message msg = new MessageImpl();
		msg.setConformingStimulus(stimulus);
		assertSame("Incorrect stimulus returned.", stimulus, msg.getConformingStimulus());
		
		msg.setConformingStimulus(null);
		assertNull("The stimulus should be null.", msg.getConformingStimulus());
	}
	
	/**
	 * Dummy implementation of the Stimulus interface.It does nothing besides providing
	 * stubs for the methods.
	 * 
	 * @author kr00tki
	 * @version 1.0
	 */
	private class DummyStimulus extends DummyModelElement implements Stimulus {

		/**
		 * Not implemented.
		 * 
		 * @return null.
		 */
		public Link getCommunicationLink() {
			return null;
		}

		/**
		 * Not implemented.
		 * 
		 * @return null.
		 */
		public Procedure getDispatchAction() {
			return null;
		}

		/**
		 * Not impleneted.
		 * 
		 * @return null.
		 */
		public Instance getReceiver() {
			return null;
		}

		/**
		 * Not implemented.
		 * 
		 * @return null.
		 */
		public Instance getSender() {
			return null;
		}

		/**
		 * Not implemented.
		 * 
		 * @param communicationLink ignored.
		 */
		public void setCommunicationLink(Link communicationLink) {
		}

		/**
		 * Notimplemented.
		 * @param dispatchAction ignored.
		 */
		public void setDispatchAction(Procedure dispatchAction) {
		}

		/**
		 * Not implemented.
		 * @param receiver ignored.
		 */
		public void setReceiver(Instance receiver) {
		}

		/**
		 * Not implemented.
		 * @param ignored.
		 */
		public void setSender(Instance sender) {
		}
		
	}
}
