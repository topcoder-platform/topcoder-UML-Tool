/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.failuretests;

import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This is the failure test cases for EnumerationImpl class.
 *
 * @author Xuchen
 * @version 1.0
 */
public class EnumerationImplFailureTests extends TestCase {
    /** The Enumeration instance used for testing. */
    private Enumeration enumeration = null;

    /** The EnumerationLiteral instance used for testing. */
    private EnumerationLiteral literal = null;

    /** The Collection containing EnumerationLiteral instances used for testing. */
    private Collection<EnumerationLiteral> literals = null;

    /**
     * Set up testing envionment.
     */
    protected void setUp() {
        enumeration = new EnumerationImpl();
        literal = new EnumerationLiteralImpl();
        literals = new ArrayList<EnumerationLiteral>();
        literals.add(literal);
    }

    /**
     * Test addLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testAddLiteralNullLiteral1() {
        try {
            enumeration.addLiteral(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test addLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testAddLiteralNullLiteral2() {
        try {
            enumeration.addLiteral(0, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test addLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testAddLiteralInvalidIndex1() {
        try {
            enumeration.addLiteral(-1, literal);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test addLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testAddLiteralInvalidIndex2() {
        try {
            enumeration.addLiteral(1, literal);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test addLiterals with null argument. It should throw IllegalArgumentException.
     */
    public void testAddLiteralsNullLiterals1() {
        try {
            enumeration.addLiterals(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test addLiterals with literals argument containing null element. It should throw IllegalArgumentException.
     */
    public void testAddLiteralsNullElementLiterals1() {
        literals.add(null);

        try {
            enumeration.addLiterals(literals);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test addLiterals with literals argument containing null element. It should throw IllegalArgumentException.
     */
    public void testAddLiteralsNullElementLiterals2() {
        literals.add(null);

        try {
            enumeration.addLiterals(0, literals);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test addLiterals with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testAddLiteralsInvalidIndex1() {
        try {
            enumeration.addLiterals(-1, literals);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test addLiterals with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testAddLiteralsInvalidIndex2() {
        try {
            enumeration.addLiterals(1, literals);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test containsLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testContainsLiteralNullLiteral() {
        try {
            enumeration.containsLiteral(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test indexOfLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testIndexOfLiteralNullLiteral() {
        try {
            enumeration.indexOfLiteral(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test removeLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testRemoveLiteralNullLiteral() {
        try {
            enumeration.removeLiteral(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test removeLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testRemoveLiteralInvalidIndex1() {
        try {
            enumeration.removeLiteral(-1);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test removeLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testRemoveLiteralInvalidIndex2() {
        try {
            enumeration.removeLiteral(0);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test removeLiterals with null argument. It should throw IllegalArgumentException.
     */
    public void testRemoveLiteralsNullLiterals() {
        try {
            enumeration.removeLiterals(null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test removeLiterals with literals argument containing null element. It should throw IllegalArgumentException.
     */
    public void testAddLiteralsNullElementLiterals() {
        literals.add(null);

        try {
            enumeration.removeLiterals(literals);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test setLiteral with null argument. It should throw IllegalArgumentException.
     */
    public void testAddLiteralNullLiteral() {
        enumeration.addLiteral(literal);

        try {
            enumeration.setLiteral(0, null);
            fail("It should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test setLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testSetLiteralInvalidIndex1() {
        try {
            enumeration.setLiteral(-1, literal);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * Test setLiteral with invalid index argument. It should throw IndexOutOfBoundsException.
     */
    public void testSetLiteralInvalidIndex2() {
        try {
            enumeration.setLiteral(0, literal);
            fail("It should throw IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }
}
