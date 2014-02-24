package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;

import junit.framework.TestCase;

/**
 * Failure tests for GroupTextField class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class GroupTextFieldFailureTests extends TestCase {
    /**
     * The GroupTextField instance to test against.
     */
    private GroupTextField groupTextField;

    /**
     * The StereotypeTextField items for testing.
     */
    private ArrayList<StereotypeTextField> items = new ArrayList<StereotypeTextField>();

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false,
                false);
        graphNode.setContainer(new GraphNode());

        items.clear();
        items.add(new StereotypeTextField(graphNode));
        groupTextField = new GroupTextField(items);
    }

    /**
     * Tests the constructor GroupTextField(ArrayList&lt;StereotypeTextField&gt;) with null items, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullItems() throws Exception {
        try {
            new GroupTextField(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor GroupTextField(ArrayList&lt;StereotypeTextField&gt;) with null item, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullItem() throws Exception {
        items.add(null);
        try {
            new GroupTextField(items);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method setItems(ArrayList&lt;StereotypeTextField&gt;) with null items, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testSetItems_NullItems() throws Exception {
        try {
            groupTextField.setItems(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method setItems(ArrayList&lt;StereotypeTextField&gt;) with null item, expected
     * IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testSetItems_NullItem() throws Exception {
        items.add(null);
        try {
            groupTextField.setItems(items);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method findItem(Point) with null pos, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testFindItem_NullPos() throws Exception {
        try {
            groupTextField.findItem(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
