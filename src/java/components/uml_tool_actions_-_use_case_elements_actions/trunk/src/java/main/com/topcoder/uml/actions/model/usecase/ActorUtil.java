/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from UsecaseToolUtil. It overrides some method which is unique for current instance of
 * ModelElement Actor.
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class ActorUtil extends UsecaseToolUtil {
    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ActorUtil() {
    }

    /**
     * <p>
     * This methods provides adding Actor instance to clipboard.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public void addElementToClipboard(ModelElement modelElement, Clipboard clipboard) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("clipboard", clipboard);

        Actor actor = (Actor) modelElement;
        ModelTransfer transfer = new ModelTransfer(actor);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually Actor instance).
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return created ModelElement instance.
     *
     * @throws IllegalArgumentException when modelElement parameter is null.
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Actor oldActor = (Actor) modelElement;
        Actor newActor = new ActorImpl();
        copyModelElementAttributes(oldActor, newActor);
        copyClassifierAttributes(oldActor, newActor);

        return newActor;
    }
}
