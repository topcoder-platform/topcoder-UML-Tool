/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * <p>
 * Accuracy test for <code>{@link ObjectUtil}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ObjectUtilAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>ObjectUtil</code> instance used in tests.
     * </p>
     */
    private ObjectUtil objectUtil = new ObjectUtil();

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#addObjectToCollaboration(Object)} method.
     * </p>
     */
    public void testAddObjectToCollaborationAccuracy() {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        objectUtil.addObjectToCollaboration(object);
        // check whether the object is added to the owned element of namespace
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaboration.getOwnedElements())
            .get(0), object);
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingInstances()).get(0), object);
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingInstances()).get(0), object);
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#removeObjectFromCollaboration(Object)} method.
     * </p>
     */
    public void testRemoveObjectFromCollaborationAccuracy() {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        collaboration.addOwnedElement(object);
        collaborationInstanceSet.addParticipatingInstance(object);
        collaborationInstanceSet1.addParticipatingInstance(object);
        objectUtil.removeObjectFromCollaboration(object);
        // check whether the object is removed from the owned element of namespace
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaboration
            .getOwnedElements()).size(), 0);
        // check whether the communication link is removed from the participatory link.
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingInstances()).size(), 0);
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingInstances()).size(), 0);
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#addObjectToClipboard(Object, Clipboard)} method.
     * </p>
     */
    public void testAddObjectToClipboardAccuracy() throws Exception {
        Object object = new ObjectImpl();
        object.setName("test");
        objectUtil.addObjectToClipboard(object, Toolkit.getDefaultToolkit().getSystemClipboard());
        assertEquals("addObjectToClipboard failed", ((Object) Toolkit.getDefaultToolkit().getSystemClipboard()
            .getContents(null).getTransferData(CollaborationTransfer.OBJECT_FLAVOR)).getName(), "test");
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#checkObjectNamespace(Object)} method.
     * </p>
     */
    public void testCheckObjectNamespaceAccuracy() {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        collaboration.addOwnedElement(object);
        assertTrue("checkObjectNamespace failed", objectUtil.checkObjectNamespace(object));

        object = new ObjectImpl();
        object.setNamespace(new CollaborationImpl());
        assertFalse("checkObjectNamespace failed", objectUtil.checkObjectNamespace(object));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ObjectUtil#copyObject(Object)}</code> method.
     * </p>
     */
    public void testCopyObjectAccuracy() {
        Object object = new ObjectImpl();
        object.setName("Hello");
        object.setSpecification(true);
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("Data");
        taggedValue.setName("TopCoder");
        object.addTaggedValue(taggedValue);
        Object copiedObject = objectUtil.copyObject(object);
        assertNotSame("copyStimulus failed", copiedObject, object);
        assertEquals(object.getName(), copiedObject.getName());
        assertTrue(copiedObject.isSpecification());
        assertEquals(copiedObject.getTaggedValues().size(), object.getTaggedValues().size());
        TaggedValue copiedTaggedValue = copiedObject.getTaggedValues().toArray(new TaggedValue[0])[0];
        assertNotSame(taggedValue, copiedTaggedValue);
        assertNotNull("data value not copied", copiedTaggedValue.getDataValue());
        assertEquals("data value not copied", taggedValue.getDataValue(), copiedTaggedValue.getDataValue());
        assertNotNull("name not copied", copiedTaggedValue.getName());
        assertEquals("name not copied", taggedValue.getName(), copiedTaggedValue.getName());
    }
}
