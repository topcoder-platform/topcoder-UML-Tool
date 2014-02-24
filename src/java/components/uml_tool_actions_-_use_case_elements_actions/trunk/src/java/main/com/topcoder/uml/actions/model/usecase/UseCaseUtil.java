/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from UsecaseToolUtil.  It overrides some method which is unique for current instance of
 * ModelElement UseCase.
 * </p>
 *
 * <p>
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class UseCaseUtil extends UsecaseToolUtil {
    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public UseCaseUtil() {
    }

    /**
     * <p>
     * This method provides adding UseCase instance to clipboard.
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

        UseCase useCase = (UseCase) modelElement;
        ModelTransfer transfer = new ModelTransfer(useCase);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given  modelElement (actually UseCase instance).
     * </p>
     *
     * @param modelElement copied ModelElement instance, should not be null.
     *
     * @return created UseCase instance
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        UseCase oldUseCase = (UseCase) modelElement;
        UseCase newUseCase = new UseCaseImpl();
        copyModelElementAttributes(oldUseCase, newUseCase);
        copyClassifierAttributes(oldUseCase, newUseCase);

        return newUseCase;
    }
}
