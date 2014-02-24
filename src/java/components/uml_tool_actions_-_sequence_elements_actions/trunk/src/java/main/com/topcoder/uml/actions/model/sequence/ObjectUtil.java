/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * This class is base for implementation logic of each Object instance action. It contains methods which
 * provide ability to encapsulate all operation with collaboration and clipboard. Its instance contains each
 * Object action.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
final class ObjectUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ObjectUtil() {
        // Empty constructor
    }

    /**
     * <p>
     * Adds the object to the collaboration.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public void addObjectToCollaboration(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUtil#addObjectToCollaboration");
        // get the namespace of the stimulus
        Collaboration collaboration = (Collaboration) object.getNamespace();
        // add the object to the collaboration owned element
        collaboration.addOwnedElement(object);
        // set ParticipatingInstance as object for the instance sets in the collaboration
        for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
            set.addParticipatingInstance(object);
        }
    }

    /**
     * <p>
     * Removes the object from the collaboration.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public void removeObjectFromCollaboration(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUtil#removeObjectFromCollaboration");
        // get the namespace of the stimulus
        Collaboration collaboration = (Collaboration) object.getNamespace();
        // add the object to the collaboration owned element
        collaboration.removeOwnedElement(object);
        // remove Participating Instance as object for the instance sets in the collaboration
        for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
            set.removeParticipatingInstance(object);
        }
    }

    /**
     * <p>
     * This method copies the Object to the clipboard.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object, clipboard</code> is <code>null</code>.
     */
    public void addObjectToClipboard(Object object, Clipboard clipboard) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUtil#addObjectToClipboard");
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in ObjectUtil#addObjectToClipboard");
        CollaborationTransfer transfer = new CollaborationTransfer(object);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This method checks if Object instance is present in collaboration(namespace).
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @return true - if Object instance present in collaboration, otherwise - false
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public boolean checkObjectNamespace(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUtil#checkObjectNamespace");
        return object.getNamespace().containsOwnedElement(object);
    }

    /**
     * <p>
     * This method copies the given <code>object</code> into a new instance and all the attributes would be
     * copied into it. There are some specific attributes to the relating to the owner which is not copied.
     * Below is the list of attributes that are not copied.
     * </p>
     * <p>
     * <ol>
     * <li>ownedElements</li>
     * <li>namespace</li>
     * <li>supplierDependencies</li>
     * <li>clientDependencies</li>
     * <li>comments</li>
     * <li>ownedLinks</li>
     * <li>linkEnds</li>
     * <li>sendStimuli</li>
     * <li>receiveStimuli</li>
     * </ol>
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @return created Object instance
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public Object copyObject(Object object) {
        // check if object is null
        Helper.checkObjectNotNull(object, "object in ObjectUtil#copyObject");
        Object copyObject = new ObjectImpl();
        // If there is a classifier present copy it bi-directional.
        if (object.getClassifier() != null) {
            copyObject.setClassifier(object.getClassifier());
            copyObject.getClassifier().addInstance(copyObject);
        }
        // copy other basic attributes
        Helper.copyBasicAttributes(object, copyObject);
        return copyObject;
    }
}
