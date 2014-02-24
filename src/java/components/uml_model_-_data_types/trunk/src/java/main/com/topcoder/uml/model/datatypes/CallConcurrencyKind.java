/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

/**
 * <p>
 * An enumeration that denotes the semantics of multiple concurrent calls to the same passive
 * instance (i.e., an Instance originating from a Classifier with isActive=false).
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public enum CallConcurrencyKind {

    /**
     * <p>
     * Callers must coordinate so that only one call to an Instance (on any sequential Operation)
     * may be outstanding at once. If simultaneous calls occur, then the semantics and integrity of
     * the system cannot be guaranteed.
     * </p>
     */
    SEQUENTIAL,

    /**
     * <p>
     * Multiple calls from concurrent threads may occur simultaneously to one Instance (on any
     * guarded Operation), but only one is allowed to commence. The others are blocked until the
     * performance of the first Operation is complete. It is the responsibility of the system
     * designer to ensure that deadlocks do not occur due to simultaneous blocks. Guarded Operations
     * must perform correctly (or block themselves) in the case of a simultaneous sequential
     * Operation or guarded semantics cannot be claimed.
     * </p>
     */
    GUARDED,

    /**
     * <p>
     * Multiple calls from concurrent threads may occur simultaneously to one Instance (on any
     * concurrent Operation). All of them may proceed concurrently with correct semantics.
     * Concurrent Operations must perform correctly in the case of a simultaneous sequential or
     * guarded Operation or concurrent semantics cannot be claimed.
     * </p>
     */
    CONCURRENT
}
