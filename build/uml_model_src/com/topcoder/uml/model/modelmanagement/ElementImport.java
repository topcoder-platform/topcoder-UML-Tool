/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.io.Serializable;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * Simple, base interface. An element import defines the visibility and alias of
 * a model element included in the namespace within a package, as a result of
 * the package importing another package. In the metamodel, an ElementImport
 * reifies the relationship between a Package and an imported ModelElement.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method
 * synchronization is discouraged. Thread safety will be provided by the
 * application using these implementations.
 * </p>
 * @author argolite, vilain
 * @version 1.0
 */
public interface ElementImport extends Serializable {

    /**
     * Gets the Package package field value. Could be null.
     * @return package field value
     */
    public Package getPackage();

    /**
     * Sets the Package package field value. Null is allowed.
     * @param aPackage package field value
     */
    public void setPackage(Package aPackage);

    /**
     * Gets the VisibilityKind visibility field value. Could be null.
     * @return visibility field value
     */
    public VisibilityKind getVisibility();

    /**
     * Sets the VisibilityKind visibility field value. Null is allowed.
     * @param visibility visibility field value
     */
    public void setVisibility(VisibilityKind visibility);

    /**
     * Gets the String alias field value. Could be null/empty.
     * @return alias field value
     */
    public String getAlias();

    /**
     * Sets the String alias field value. Null/empty is allowed.
     * @param alias alias field value
     */
    public void setAlias(String alias);

    /**
     * Gets the boolean specification field value.
     * @return specification field value
     */
    public boolean isSpecification();

    /**
     * Sets the boolean specification field value.
     * @param specification specification field value
     */
    public void setSpecification(boolean specification);

    /**
     * Gets the ModelElement importedElement field value. Could be null.
     * @return importedElement field value
     */
    public ModelElement getImportedElement();

    /**
     * Sets the ModelElement importedElement field value. Null is allowed.
     * @param importedElement importedElement field value
     */
    public void setImportedElement(ModelElement importedElement);
}
