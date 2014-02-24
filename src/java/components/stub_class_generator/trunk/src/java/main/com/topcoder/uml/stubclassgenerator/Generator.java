/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.modelmanagement.Package;


/**
 * <p>
 * This interface represent all logic for connecting with model components. It
 * may get name of package, create code for {@link Classifier} or check if
 * {@link Classifier} is correct for this component (Class, Interface or
 * Enumeration).
 * </p>
 * <p>
 * <b>Thread safety:</b> Classes which implement this interface may be mutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 */
interface Generator {
    /**
     * <p>
     * Returns the full package name for the given {@link Package}. The full
     * package name is the combination of the name of the given package combined
     * with its containing parent packages.
     * </p>
     *
     * @param pack
     *            {@link Package} instance
     * @return the full package name for the given {@link Package}.
     * @throws IllegalArgumentException
     *             if pack is <code>null</code>
     */
    public String getPackage(Package pack);

    /**
     * <p>
     * Returns the full package name of the given {@link Classifier}. If the
     * given {@link Classifier} does not belong to some package this method
     * returns an empty {@link String}.
     * </p>
     *
     * @param classifier
     *            the {@link Classifier} instance to get the package name for
     * @return the full package name of the given {@link Classifier} or an empty
     *         {@link String} if the {@link Classifier} does not belong to a
     *         package.
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public String getPackage(Classifier classifier);

    /**
     * <p>
     * Creates the full code for the given {@link Classifier}.
     * </p>
     *
     * @param classifier
     *            the {@link Classifier} instance to create the code for
     * @return the full code for the given {@link Classifier}.
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public String createClassifierCode(Classifier classifier);

    /**
     * <p>
     * Checks if it is possible to create code for the given {@link Classifier}.
     * To generate code for a {@link Classifier} it has to be one of the
     * following kinds:
     * <ul>
     * <li> <code>Class</code>
     * <li> <code>Interface</code>
     * <li> <code>Enumeration</code>
     * </ul>
     * </p>
     *
     * @param classifier
     *            the {@link Classifier} instance to be checked
     * @return <code>true</code> if given {@link Classifier} is Class,
     *         Interface or Enumeration, otherwise <code>false</code>
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public boolean checkClassifier(Classifier classifier);
}
