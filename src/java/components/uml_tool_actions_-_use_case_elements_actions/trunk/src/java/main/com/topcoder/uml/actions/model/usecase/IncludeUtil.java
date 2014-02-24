/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
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
 * Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class IncludeUtil extends UsecaseToolUtil {
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
    public IncludeUtil() {
    }

    /**
     * <p>
     * This methods provides adding ModelElement instance(which is Include) from namespace and updating its attributes.
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
     * This methods provides removing ModelElement instance(which is Include) from namespace and updating its
     * attributes.
     * </p>
     *
     * @param modelElement ModelElement instance,  should not be null.
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

            Include includ = (Include) modelElement;
            UseCase base = includ.getBase();

            if (base != null) {
                base.removeInclude(includ);
                base.removeIncluder(includ);
            }

            UseCase addition = includ.getAddition();

            if (addition != null) {
                addition.removeInclude(includ);
                addition.removeIncluder(includ);
            }
        }

        return flag;
    }

    /**
     * <p>
     * This methods provides adding Include instance to clipboard.
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

        Include include = (Include) modelElement;
        ModelTransfer transfer = new ModelTransfer(include);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This methods copy special attributes of given modelElement (actually Include instance).
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return created Include instance.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public ModelElement copyElement(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Include oldInclude = (Include) modelElement;
        Include newInclude = new IncludeImpl();
        copyModelElementAttributes(oldInclude, newInclude);

        return newInclude;
    }

    /**
     * <p>
     * This method provides calculating and setting namespace of ModelElement ( which is Include).
     * </p>
     *
     * @param modelElement ModelElement instance, should not be null.
     *
     * @return calculated Namespace
     *
     * @throws IllegalArgumentException when parameter is null
     */
    private Namespace setCalculatedNamespace(ModelElement modelElement) {
        Helper.checkNull("modelElement", modelElement);

        Include include = (Include) modelElement;

        //get all namespaces of base
        List<Namespace> baseList = new ArrayList<Namespace>();
        Namespace namespace = (include.getBase() == null) ? null : include.getBase().getNamespace();

        while (namespace != null) {
            baseList.add(namespace);
            namespace = namespace.getNamespace();
        }

        //get all namespaces of addition
        List<Namespace> additionList = new ArrayList<Namespace>();
        namespace = (include.getAddition() == null) ? null : include.getAddition().getNamespace();

        while (namespace != null) {
            additionList.add(namespace);
            namespace = namespace.getNamespace();
        }

        isCalculated = true;

        return Helper.calculatedNamespace(baseList, additionList);
    }
}
