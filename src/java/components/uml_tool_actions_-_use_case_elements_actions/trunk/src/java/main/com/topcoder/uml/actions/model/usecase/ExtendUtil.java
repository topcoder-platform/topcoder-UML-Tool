/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;

import java.awt.datatransfer.Clipboard;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This class extends from UsecaseToolUtil. It overrides some method which is unique for current instance of
 * ModelElement Include.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class ExtendUtil extends UsecaseToolUtil {
    /**
     * Method setCalculatedNamespace() should be called only once.  For this target use isCalculated, which should be
     * added to class.  By default it false and after first run setCalculatedNamespace() it should be set to true and
     * should not be changed any more.
     */
    private boolean isCalculated = false;

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ExtendUtil() {
    }

    /**
     * <p>
     * This methods provides adding ModelElement instance(which is Extend) to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public void addElementToModel(ModelElement modelElement, Namespace namespace) {
        Helper.checkNull("modelElement", modelElement);
        Helper.checkNull("namespace", namespace);

        if (!isCalculated) {
            Namespace calculatedNamespace = setCalculatedNamespace(modelElement);

            if (calculatedNamespace != null) {
                modelElement.setNamespace(calculatedNamespace);
            } else {
                modelElement.setNamespace(namespace);
            }
        }

        modelElement.getNamespace().addOwnedElement(modelElement);
    }

    /**
     * <p>
     * This methods provides removing ModelElement instance(which is Extend) to namespace and updating its attributes.
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return If method super.removeElementFromModel() return true this method also return true, otherwise false
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public boolean removeElementFromModel(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        boolean flag = false;

        if (super.removeElementFromModel(modelElement)) {
            flag = true;

            Extend extend = (Extend) modelElement;
            UseCase base = extend.getBase();

            if (base != null) {
                base.removeExtend(extend);
                base.removeExtender(extend);
            }

            UseCase extension = extend.getExtension();

            if (extension != null) {
                extension.removeExtend(extend);
                extension.removeExtender(extend);
            }
        }

        return flag;
    }

    /**
     * <p>
     * This methods provides adding Extend instance to clipboard.
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

        Extend extend = (Extend) modelElement;
        ModelTransfer transfer = new ModelTransfer(extend);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually Extend instance).
     * </p>
     *
     * @param modelElement copied ModelElement instance, should not be null.
     *
     * @return created Extend instance.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Extend oldExtend = (Extend) modelElement;
        Extend newExtend = new ExtendImpl();
        copyModelElementAttributes(oldExtend, newExtend);

        return newExtend;
    }

    /**
     * <p>
     * This method provides calculating and setting namespace of ModelElement  ( which is Extend).
     * </p>
     *
     * @param modelElement ModelElement instance, null impossible
     *
     * @return calculated Namespace
     *
     * @throws IllegalArgumentException when parameter is null
     */
    private Namespace setCalculatedNamespace(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Extend extend = (Extend) modelElement;

        //get all namespaces of base
        List<Namespace> baseList = new ArrayList<Namespace>();
        Namespace namespace = (extend.getBase() == null) ? null : extend.getBase().getNamespace();

        while (namespace != null) {
            baseList.add(namespace);
            namespace = namespace.getNamespace();
        }

        //get all namespaces of extension
        List<Namespace> extensionList = new ArrayList<Namespace>();
        namespace = (extend.getExtension() == null) ? null : extend.getExtension().getNamespace();

        while (namespace != null) {
            extensionList.add(namespace);
            namespace = namespace.getNamespace();
        }

        isCalculated = true;

        return Helper.calculatedNamespace(baseList, extensionList);
    }
}
