/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeDocumentationAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateDocumentationTagsAction;

/**
 * <p>
 * This implementation of TagListener will change a tag attached to an element and update the element.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class TagHandler implements TagListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private MainFrame mainFrame = null;

    /**
     * <p>
     * Creates an instance of DocumentationHandler with the mainframe.
     * </p>
     *
     * @param mainFrame
     *            the mainFrame
     */
    public TagHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Creates a new tag attached to the element.
     * </p>
     *
     * @param event
     *            the tag event
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void tagCreated(TagEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        TagDefinition tagDefinition = DeployHelper.getTagDefinition("documentation#@" + event.getTagName());
        TaggedValueImpl taggedValueImpl = new TaggedValueImpl();
        taggedValueImpl.setType(tagDefinition);
        taggedValueImpl.setDataValue(event.getCurrentDocumentation());
        Map<TaggedValue, String> newDocumentations = new HashMap<TaggedValue, String>();
        newDocumentations.put(taggedValueImpl, event.getCurrentDocumentation());
        UpdateDocumentationTagsAction updateDocumentationTagsAction =
            new UpdateDocumentationTagsAction(modelElement, newDocumentations,
                UpdateDocumentationTagsOperationType.ADD);
        mainFrame.handleActionEvent(updateDocumentationTagsAction, modelElement, "Change Documentation");
    }

    /**
     * <p>
     * Modifies the documentation for a tag attached to the element.
     * </p>
     *
     * @param event
     *            the tag event
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void tagUpdated(TagEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        Map<TaggedValue, String> newDocumentations = new HashMap<TaggedValue, String>();
        Collection<TaggedValue> taggedValues = modelElement.getTaggedValues();
        String tagName = event.getTagName();
        if (tagName.startsWith("@param")) {
            updateParameterDoc(event);
            return;
        }
        for (TaggedValue tv : taggedValues) {
            if (event.getTagObject().equals(tv)) {
                newDocumentations.put(tv, event.getCurrentDocumentation());
                break;
            }
        }
        UpdateDocumentationTagsAction updateDocumentationTagsAction =
            new UpdateDocumentationTagsAction(modelElement, newDocumentations,
                UpdateDocumentationTagsOperationType.UPDATE);
        mainFrame.handleActionEvent(updateDocumentationTagsAction, modelElement, "Change Documentation");
    }

    /**
     * <p>
     * Changes parameter's documentation.
     * </p>
     *
     * @param event
     *            the event
     */
    private void updateParameterDoc(TagEvent event) {
        Operation modelElement = (Operation) event.getModelElement();
        List<Parameter> parameters = modelElement.getParameters();
        Parameter parameter = null;
        String name = event.getTagName();
        name = name.substring(name.lastIndexOf(' ') + 1);
        for (Parameter param : parameters) {
            if (param.getName().equals(name)) {
                parameter = param;
                break;
            }
        }
        if (parameter.getBehavioralFeature() == null) {
            parameter.setBehavioralFeature(modelElement);
        }
        ChangeDocumentationAction changeDocumentationAction =
            new ChangeDocumentationAction(parameter, event.getCurrentDocumentation());
        // UML-558: Documentation panel is not updating
        mainFrame.handleActionEvent(changeDocumentationAction, parameter, "Change documentation");
    }

    /**
     * <p>
     * Removes a tag from the element.
     * </p>
     *
     * @param event
     *            the tag event
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void tagDeleted(TagEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        Map<TaggedValue, String> newDocumentations = new HashMap<TaggedValue, String>();
        Collection<TaggedValue> taggedValues = modelElement.getTaggedValues();
        String tagName = event.getTagName();
        for (TaggedValue tv : taggedValues) {
            // Check tag type, should equal tagName
            if (DocumentPanelHelper.checkTagType(tv, "documentation#" + tagName, true)) {
                newDocumentations.put(tv, event.getCurrentDocumentation());
                break;
            }
        }
        UpdateDocumentationTagsAction updateDocumentationTagsAction =
            new UpdateDocumentationTagsAction(modelElement, newDocumentations,
                UpdateDocumentationTagsOperationType.REMOVE);
        mainFrame.handleActionEvent(updateDocumentationTagsAction, modelElement, "Change Documentation");
    }
}
