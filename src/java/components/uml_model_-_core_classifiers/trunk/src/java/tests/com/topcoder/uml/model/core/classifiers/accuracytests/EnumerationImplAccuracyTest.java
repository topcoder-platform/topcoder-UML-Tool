/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>The accuracy tests of the <code>EnumerationImpl</code> class. It addresses the
 * functionality provided by the <code>EnumerationImpl</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class EnumerationImplAccuracyTest extends TestCase {
    /**
     * <p>The instance of <code>EnumerationLiteral</code> for test.</p>
     */
    private EnumerationLiteral lit1 = null;

    /**
     * <p>The instance of <code>EnumerationLiteral</code> for test.</p>
     */
    private EnumerationLiteral lit2 = null;

    /**
     * <p>The instance of <code>EnumerationLiteral</code> for test.</p>
     */
    private EnumerationLiteral lit3 = null;

    /**
     * <p>The instance of <code>EnumerationImpl</code> for test.</p>
     */
    private EnumerationImpl enumImpl = null;

    /**
     * <p>Test suite of <code>EnumerationImplAccuracyTest</code>.</p>
     *
     * @return Test suite of <code>EnumerationImplAccuracyTest</code>.
     */
    public static Test suite() {
        return new TestSuite(EnumerationImplAccuracyTest.class);
    }

    /**
     * <p>Set up the accuracy testing environment.</p>
     */
    protected void setUp() {
        lit1 = new EnumerationLiteralImpl();
        lit2 = new EnumerationLiteralImpl();
        lit3 = new EnumerationLiteralImpl();
    }

    /**
     * <p>Accuracy test of the <code>EnumerationImpl</code> class' Inheritance.</p>
     */
    public void testInheritance_EnumerationImpl() {
        assertTrue("EnumerationImpl class should extend from the Enumeration.",
            Enumeration.class.isAssignableFrom(EnumerationImpl.class));
        assertTrue("EnumerationImpl class should extend from the DataTypeImpl.",
            DataTypeImpl.class.isAssignableFrom(EnumerationImpl.class));
    }

    /**
     * <p>Detail test of <code>EnumerationImpl()</code> constructor. Creates a instance and
     * get its attributes for test.</p>
     */
    public void testCtor_EnumerationImpl() {
        enumImpl = new EnumerationImpl();

        // check null here.
        assertNotNull("Create EnumerationImpl failed.", enumImpl);

        // check the value here.
        assertEquals("Create EnumerationImpl failed.", 0, enumImpl.countLiterals());
        assertEquals("Create EnumerationImpl failed.", 0, enumImpl.getLiterals().size());
    }

    /**
     * <p>Basic test of the <code>addLiteral(EnumerationLiteral literal)</code> method.</p>
     */
    public void testMethod_addLiteral1() {
        enumImpl = new EnumerationImpl();

        // add one literal here.
        enumImpl.addLiteral(lit1);
        assertEquals("The addLiteral() method is incorrect.", 1, enumImpl.countLiterals());

        // add some literals here.
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        assertEquals("The addLiteral() method is incorrect.", 3, enumImpl.countLiterals());

        // add same literal here.
        enumImpl.addLiteral(lit2);
        assertEquals("The addLiteral() method is incorrect.", 4, enumImpl.countLiterals());

        // get all literals and test it.
        List literalList = enumImpl.getLiterals();
        assertEquals("The addLiteral() method is incorrect.", 4, literalList.size());
        assertEquals("The addLiteral() method is incorrect.", lit1, literalList.get(0));
        assertEquals("The addLiteral() method is incorrect.", lit2, literalList.get(1));
        assertEquals("The addLiteral() method is incorrect.", lit3, literalList.get(2));
        assertEquals("The addLiteral() method is incorrect.", lit2, literalList.get(3));
    }

    /**
     * <p>Basic test of the <code>addLiteral(int index, EnumerationLiteral literal)</code>
     * method.</p>
     */
    public void testMethod_addLiteral2() {
        enumImpl = new EnumerationImpl();

        // add one literal here.
        enumImpl.addLiteral(0, lit1);
        assertEquals("The addLiteral() method is incorrect.", 1, enumImpl.countLiterals());

        // add some literals here.
        enumImpl.addLiteral(0, lit2);
        enumImpl.addLiteral(1, lit3);
        assertEquals("The addLiteral() method is incorrect.", 3, enumImpl.countLiterals());

        List literalList = enumImpl.getLiterals();
        assertEquals("The addLiteral() method is incorrect.", 3, literalList.size());
        assertEquals("The addLiteral() method is incorrect.", lit2, literalList.get(0));
        assertEquals("The addLiteral() method is incorrect.", lit3, literalList.get(1));
        assertEquals("The addLiteral() method is incorrect.", lit1, literalList.get(2));

        // add same literal here.
        enumImpl.addLiteral(3, lit3);
        enumImpl.addLiteral(2, lit2);
        assertEquals("The addLiteral() method is incorrect.", 5, enumImpl.countLiterals());

        literalList = enumImpl.getLiterals();
        assertEquals("The addLiteral() method is incorrect.", 5, literalList.size());
        assertEquals("The addLiteral() method is incorrect.", lit2, literalList.get(0));
        assertEquals("The addLiteral() method is incorrect.", lit3, literalList.get(1));
        assertEquals("The addLiteral() method is incorrect.", lit2, literalList.get(2));
        assertEquals("The addLiteral() method is incorrect.", lit1, literalList.get(3));
        assertEquals("The addLiteral() method is incorrect.", lit3, literalList.get(4));
    }

    /**
     * <p>Basic test of the <code>addLiterals(Collection&lt;EnumerationLiteral&gt;
     * literals)</code> method.</p>
     */
    public void testMethod_addLiterals1() {
        enumImpl = new EnumerationImpl();

        List<EnumerationLiteral> addList = new ArrayList<EnumerationLiteral>();

        // add one literal here.
        addList.add(lit1);
        enumImpl.addLiterals(addList);
        assertEquals("The addLiterals() method is incorrect.", 1, enumImpl.countLiterals());

        // add some literals here.
        addList.clear();
        addList.add(lit2);
        addList.add(lit3);
        enumImpl.addLiterals(addList);
        assertEquals("The addLiterals() method is incorrect.", 3, enumImpl.countLiterals());

        // add same literal here.
        addList.clear();
        addList.add(lit2);
        enumImpl.addLiterals(addList);
        assertEquals("The addLiterals() method is incorrect.", 4, enumImpl.countLiterals());

        List literalList = enumImpl.getLiterals();
        assertEquals("The addLiterals() method is incorrect.", 4, literalList.size());
        assertEquals("The addLiterals() method is incorrect.", lit1, literalList.get(0));
        assertEquals("The addLiterals() method is incorrect.", lit2, literalList.get(1));
        assertEquals("The addLiterals() method is incorrect.", lit3, literalList.get(2));
        assertEquals("The addLiterals() method is incorrect.", lit2, literalList.get(3));
    }

    /**
     * <p>Basic test of the <code>addLiterals(int index,
     * Collection&lt;EnumerationLiteral&gt; literals)</code> method.</p>
     */
    public void testMethod_addLiterals2() {
        enumImpl = new EnumerationImpl();

        enumImpl = new EnumerationImpl();

        List<EnumerationLiteral> addList = new ArrayList<EnumerationLiteral>();

        // add one literal here.
        addList.add(lit1);
        enumImpl.addLiterals(0, addList);
        assertEquals("The addLiterals() method is incorrect.", 1, enumImpl.countLiterals());

        // add some literals here.
        addList.clear();
        addList.add(lit2);
        addList.add(lit3);
        enumImpl.addLiterals(0, addList);
        assertEquals("The addLiterals() method is incorrect.", 3, enumImpl.countLiterals());

        List literalList = enumImpl.getLiterals();
        assertEquals("The addLiterals() method is incorrect.", 3, literalList.size());
        assertEquals("The addLiterals() method is incorrect.", lit2, literalList.get(0));
        assertEquals("The addLiterals() method is incorrect.", lit3, literalList.get(1));
        assertEquals("The addLiterals() method is incorrect.", lit1, literalList.get(2));

        // add same literal here.
        addList.clear();
        addList.add(lit1);
        addList.add(lit2);
        enumImpl.addLiterals(1, addList);
        assertEquals("The addLiterals() method is incorrect.", 5, enumImpl.countLiterals());

        literalList = enumImpl.getLiterals();
        assertEquals("The addLiterals() method is incorrect.", 5, literalList.size());
        assertEquals("The addLiterals() method is incorrect.", lit2, literalList.get(0));
        assertEquals("The addLiterals() method is incorrect.", lit1, literalList.get(1));
        assertEquals("The addLiterals() method is incorrect.", lit2, literalList.get(2));
        assertEquals("The addLiterals() method is incorrect.", lit3, literalList.get(3));
        assertEquals("The addLiterals() method is incorrect.", lit1, literalList.get(4));
    }

    /**
     * <p>Basic test of the <code>setLiteral(int index, EnumerationLiteral literal)</code>
     * method.</p>
     */
    public void testMethod_setLiteral() {
        enumImpl = new EnumerationImpl();

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit2);

        // set the literal here.
        enumImpl.setLiteral(1, lit1);
        assertEquals("The setLiteral() method is incorrect.", 4, enumImpl.getLiterals().size());
        assertEquals("The setLiteral() method is incorrect.", lit1, enumImpl.getLiterals().get(1));
    }

    /**
     * <p>Basic test of the <code>removeLiteral(int index)</code> method.</p>
     */
    public void testMethod_removeLiteral1() {
        enumImpl = new EnumerationImpl();

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        // remove the literal and test it.
        assertEquals("The removeLiteral() method is incorrect.", lit2, enumImpl.removeLiteral(1));
        assertEquals("The removeLiteral() method is incorrect.", 3, enumImpl.getLiterals().size());
        assertEquals("The removeLiteral() method is incorrect.", lit1, enumImpl.removeLiteral(2));
        assertEquals("The removeLiteral() method is incorrect.", 2, enumImpl.getLiterals().size());
        assertEquals("The removeLiteral() method is incorrect.", lit1, enumImpl.removeLiteral(0));
        assertEquals("The removeLiteral() method is incorrect.", 1, enumImpl.getLiterals().size());
        assertEquals("The removeLiteral() method is incorrect.", lit3, enumImpl.removeLiteral(0));
        assertEquals("The removeLiteral() method is incorrect.", 0, enumImpl.getLiterals().size());
    }

    /**
     * <p>Basic test of the <code>removeLiteral(EnumerationLiteral literal)</code> method.</p>
     */
    public void testMethod_removeLiteral2() {
        enumImpl = new EnumerationImpl();

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        // remove the literal and test it.
        assertTrue("The removeLiteral() method is incorrect.", enumImpl.removeLiteral(lit1));
        assertEquals("The removeLiteral() method is incorrect.", 2, enumImpl.getLiterals().size());

        // remove the inexient literal and test it.
        assertFalse("The removeLiteral() method is incorrect.", enumImpl.removeLiteral(lit2));
        assertEquals("The removeLiteral() method is incorrect.", 2, enumImpl.getLiterals().size());

        // remove the literal and test it.
        assertTrue("The removeLiteral() method is incorrect.", enumImpl.removeLiteral(lit1));
        assertEquals("The removeLiteral() method is incorrect.", 1, enumImpl.getLiterals().size());
        assertTrue("The removeLiteral() method is incorrect.", enumImpl.removeLiteral(lit3));
        assertEquals("The removeLiteral() method is incorrect.", 0, enumImpl.getLiterals().size());
    }

    /**
     * <p>Basic test of the <code>removeLiterals(Collection&lt;EnumerationLiteral&gt;
     * literals)</code> method.</p>
     */
    public void testMethod_removeLiterals() {
        enumImpl = new EnumerationImpl();

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        List<EnumerationLiteral> addList = new ArrayList<EnumerationLiteral>();

        // remove the inexient literal and test it.
        addList.add(new EnumerationLiteralImpl());
        assertFalse("The removeLiterals() method is incorrect.", enumImpl.removeLiterals(addList));

        // add some literals here.
        addList.add(lit1);
        addList.add(lit3);

        // remove the literal and test it.
        assertTrue("The removeLiterals() method is incorrect.", enumImpl.removeLiterals(addList));
        assertEquals("The removeLiterals() method is incorrect.", 2, enumImpl.getLiterals().size());

        List literalList = enumImpl.getLiterals();
        assertEquals("The removeLiterals() method is incorrect.", 2, literalList.size());
        assertEquals("The removeLiterals() method is incorrect.", lit2, literalList.get(0));
        assertEquals("The removeLiterals() method is incorrect.", lit1, literalList.get(1));

        // remove the literal and test it.
        assertTrue("The removeLiterals() method is incorrect.", enumImpl.removeLiterals(addList));
        assertEquals("The removeLiterals() method is incorrect.", 1, enumImpl.getLiterals().size());

        literalList = enumImpl.getLiterals();
        assertEquals("The removeLiterals() method is incorrect.", 1, literalList.size());
        assertEquals("The removeLiterals() method is incorrect.", lit2, literalList.get(0));

        // add one literal here.
        addList.add(lit2);
        addList.add(lit3);
        assertTrue("The removeLiterals() method is incorrect.", enumImpl.removeLiterals(addList));
        assertEquals("The removeLiterals() method is incorrect.", 0, enumImpl.getLiterals().size());
    }

    /**
     * <p>Basic test of the <code>clearLiterals()</code> method.</p>
     */
    public void testMethod_clearLiterals() {
        enumImpl = new EnumerationImpl();

        // clear empty list here.
        enumImpl.clearLiterals();
        assertEquals("The clearLiterals() method is incorrect.", 0, enumImpl.getLiterals().size());

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        // clear  list here.
        enumImpl.clearLiterals();
        assertEquals("The clearLiterals() method is incorrect.", 0, enumImpl.getLiterals().size());
    }

    /**
     * <p>Basic test of the <code>getLiterals()</code> method.</p>
     */
    public void testMethod_getLiterals() {
        enumImpl = new EnumerationImpl();

        // clear empty list here.
        assertEquals("The getLiterals() method is incorrect.", 0, enumImpl.getLiterals().size());

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        List literalList = enumImpl.getLiterals();
        assertEquals("The getLiterals() method is incorrect.", 4, literalList.size());
        assertEquals("The getLiterals() method is incorrect.", lit1, literalList.get(0));
        assertEquals("The getLiterals() method is incorrect.", lit2, literalList.get(1));
        assertEquals("The getLiterals() method is incorrect.", lit3, literalList.get(2));
        assertEquals("The getLiterals() method is incorrect.", lit1, literalList.get(3));
    }

    /**
     * <p>Basic test of the <code>containsLiteral(EnumerationLiteral literal)</code>
     * method.</p>
     */
    public void testMethod_containsLiteral() {
        enumImpl = new EnumerationImpl();

        // test with empty list.
        assertFalse("The containsLiteral() method is incorrect.", enumImpl.containsLiteral(lit1));

        // add some literals here.
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit3);

        assertFalse("The containsLiteral() method is incorrect.", enumImpl.containsLiteral(lit1));
        assertTrue("The containsLiteral() method is incorrect.", enumImpl.containsLiteral(lit2));
        assertTrue("The containsLiteral() method is incorrect.", enumImpl.containsLiteral(lit3));
    }

    /**
     * <p>Basic test of the <code>indexOfLiteral(EnumerationLiteral literal)</code> method.</p>
     */
    public void testMethod_indexOfLiteral() {
        enumImpl = new EnumerationImpl();

        // test with empty list.
        assertEquals("The indexOfLiteral() method is incorrect.", -1, enumImpl.indexOfLiteral(lit1));
        assertEquals("The indexOfLiteral() method is incorrect.", -1, enumImpl.indexOfLiteral(lit3));

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit1);

        assertEquals("The indexOfLiteral() method is incorrect.", 0, enumImpl.indexOfLiteral(lit1));
        assertEquals("The indexOfLiteral() method is incorrect.", -1, enumImpl.indexOfLiteral(lit2));
        assertEquals("The indexOfLiteral() method is incorrect.", 1, enumImpl.indexOfLiteral(lit3));
    }

    /**
     * <p>Basic test of the <code>countLiterals()</code> method.</p>
     */
    public void testMethod_countLiterals() {
        enumImpl = new EnumerationImpl();

        // test with empty list.
        assertEquals("The countLiterals() method is incorrect.", 0, enumImpl.countLiterals());

        // add some literals here.
        enumImpl.addLiteral(lit1);
        enumImpl.addLiteral(lit3);
        enumImpl.addLiteral(lit2);
        enumImpl.addLiteral(lit1);
        assertEquals("The countLiterals() method is incorrect.", 4, enumImpl.countLiterals());
    }
}
