package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.CopyPasteCutUtil;
import com.topcoder.util.actionmanager.ActionExecutionException;

public class AutoMethodGenerationAction extends UndoableAbstractAction {

    private final Classifier parent;

    private final Classifier child;

    private UpdateNodeContainerAction actions;

    private final Node startNode;

    private final String projectLanguage;

    public AutoMethodGenerationAction(MainFrame mainFrame, Classifier parent, Classifier child, Node startNode,
        String projectLanguage) {
        super("Auto method generated");
        this.parent = parent;
        this.child = child;
        this.startNode = startNode;
        this.projectLanguage = projectLanguage;
        actions = new UpdateNodeContainerAction(startNode, "Updating class due to specialization");
        actions.setEventManager(mainFrame.getEventManager());
    }

    public void executeAction() throws ActionExecutionException {

        List<Classifier> processingList = new ArrayList<Classifier>();
        List<List<Classifier>> middleList = new ArrayList<List<Classifier>>();

        // list initialization
        processingList.add(parent);
        middleList.add(new ArrayList<Classifier>());

        // processes the list until it is empty
        while (!processingList.isEmpty()) {
            Classifier parent = processingList.get(0);
            List<Classifier> middle = middleList.get(0);
            processingList.remove(0);
            middleList.remove(0);

            if (parent instanceof com.topcoder.uml.model.core.classifiers.Class
                && child instanceof com.topcoder.uml.model.core.classifiers.Class) {
                com.topcoder.uml.model.core.classifiers.Class parentClass =
                    (com.topcoder.uml.model.core.classifiers.Class) parent;

                if (parent.isAbstract()) {
                    com.topcoder.uml.model.core.classifiers.Class childClass =
                        (com.topcoder.uml.model.core.classifiers.Class) child;
                    for (Feature feature : parentClass.getFeatures()) {
                        if (feature instanceof Operation) {
                            Operation op = (Operation) feature;
                            if (op.isAbstract()) {

                                // checks the middle list if it already has the method
                                boolean alreadyImplemented = false;
                                for (GeneralizableElement generalizableElement : middle) {
                                    Classifier middleClass = (Classifier) generalizableElement;

                                    for (Feature middleFeature : middleClass.getFeatures()) {
                                        if (middleFeature instanceof Operation) {
                                            Operation middleOp = (Operation) middleFeature;
                                            if (DeployHelper.isSameOperation(op, middleOp)) {
                                                alreadyImplemented = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (alreadyImplemented) {
                                        break;
                                    }
                                }

                                if (alreadyImplemented) {
                                    continue;
                                }

                                boolean hasSameOperation = false;
                                Operation childOp = null;

                                // checks the child if it has the same operation
                                for (Feature childFeature : childClass.getFeatures()) {
                                    if (childFeature instanceof Operation) {
                                        childOp = (Operation) childFeature;
                                        if (DeployHelper.isSameOperation(op, childOp)) {
                                            hasSameOperation = true;
                                            break;
                                        }

                                    }
                                }

                                if (!hasSameOperation) {
                                    Operation dupl = CopyPasteCutUtil.copyOperation(op);
                                    dupl.setOwner(childClass);
                                    if (projectLanguage.equals("CSharp")
                                        && parent instanceof com.topcoder.uml.model.core.classifiers.Class) {
                                        StereotypeImpl stereotype = new StereotypeImpl();
                                        stereotype.setName("override");
                                        dupl.addStereotype(stereotype);
                                    }
                                    actions.put(new AddOperationAction(childClass, dupl), startNode);
                                }

                            }
                        }

                    }

                    retrieveMoreInformation(processingList, middleList, parent, middle, true);

                }
            } else if (parent instanceof Interface
                && child instanceof com.topcoder.uml.model.core.classifiers.Class) {
                Interface parentClass = (Interface) parent;

                com.topcoder.uml.model.core.classifiers.Class childClass =
                    (com.topcoder.uml.model.core.classifiers.Class) child;

                for (Feature feature : parentClass.getFeatures()) {
                    if (feature instanceof Operation) {
                        Operation op = (Operation) feature;

                        // checks the middle list if it already has the method
                        boolean alreadyImplemented = false;
                        for (GeneralizableElement generalizableElement : middle) {
                            Classifier middleClass = (Classifier) generalizableElement;

                            for (Feature middleFeature : middleClass.getFeatures()) {
                                if (middleFeature instanceof Operation) {
                                    Operation middleOp = (Operation) middleFeature;
                                    if (DeployHelper.isSameOperation(op, middleOp)) {
                                        alreadyImplemented = true;
                                        break;
                                    }
                                }
                            }
                            if (alreadyImplemented) {
                                break;
                            }
                        }

                        if (alreadyImplemented) {
                            continue;
                        }

                        boolean hasSameOperation = false;
                        Operation childOp = null;

                        // checks the child if it has the same operation
                        for (Feature childFeature : childClass.getFeatures()) {
                            if (childFeature instanceof Operation) {
                                childOp = (Operation) childFeature;
                                if (DeployHelper.isSameOperation(op, childOp)) {
                                    hasSameOperation = true;
                                    break;
                                }

                            }
                        }

                        if (!hasSameOperation) {

                            Operation dupl = CopyPasteCutUtil.copyOperation(op);
                            dupl.setOwner(childClass);
                            actions.put(new AddOperationAction(childClass, dupl), startNode);
                        }

                    }

                    retrieveMoreInformation(processingList, middleList, parent, middle, false);

                }
            }
        }

        actions.execute();
    }

    public void redoAction() {
        actions.redoAction();

    }

    public void undoAction() {
        actions.undoAction();

    }

    private void retrieveMoreInformation(List<Classifier> processingList, List<List<Classifier>> middleList,
        Classifier parent, List<Classifier> middle, boolean includeInterfaces) {
        Collection<Generalization> generalizations = parent.getGeneralizations();
        for (Generalization generalization : generalizations) {
            if (generalization.getParent() instanceof Classifier) {
                processingList.add((Classifier) generalization.getParent());
                List<Classifier> newMiddle = new ArrayList<Classifier>(middle);
                newMiddle.add(parent);
                middleList.add(newMiddle);
            }
        }

        if (includeInterfaces) {
            Collection<Dependency> clientDependencies = parent.getClientDependencies();
            for (Dependency dependency : clientDependencies) {
                if (dependency instanceof Abstraction) {
                    Abstraction abstraction = (Abstraction) dependency;
                    for (ModelElement element : abstraction.getSuppliers()) {
                        if (element instanceof Interface) {
                            Interface ifc = (Interface) element;
                            processingList.add(ifc);
                            List<Classifier> newMiddle = new ArrayList<Classifier>(middle);
                            if (parent instanceof com.topcoder.uml.model.core.classifiers.Class) {
                                newMiddle.add(parent);
                            }
                            middleList.add(newMiddle);
                        }
                    }

                }
            }
        }
    }

}
