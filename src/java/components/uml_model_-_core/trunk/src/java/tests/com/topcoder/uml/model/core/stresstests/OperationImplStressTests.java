package com.topcoder.uml.model.core.stresstests;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

/**
 * <p>
 * Title: Simple Test Stress for UML Core Model
 * </p>
 * <p>
 * Description: Stress Test
 * </p>
 * This is a simple stress test that takes all the Collection or List based API
 * for a ModelElement based implementation and tests it for repeated class of
 * 1000 items. Here we test adding, clearing, and getting items.
 */
public class OperationImplStressTests extends TestCase {
    private OperationImpl operationImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(OperationImplStressTests.class);

        return suite;
    }

    public OperationImplStressTests(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        operationImpl = new OperationImpl();
    }

    protected void tearDown() throws Exception {
        operationImpl = null;
        super.tearDown();
    }

    /**
     * Stress test adding a method 1000 times
     */
    public void testAddMethod() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Method[] testarray = new Method[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new MethodImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addMethod(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Method 1000 times took " + (end - start) + " ms.");
    }

    public void testGetMethods() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addMethod(new MethodImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getMethods();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 methods took " + (end - start) + " ms.");
    }

    public void testAddBehavior() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        StateMachine[] testarray = new StateMachine[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StateMachineImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addBehavior(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Behavior 1000 times took " + (end - start) + " ms.");
    }

    public void testAddClientDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addClientDependency(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Client Dependency 1000 times took " + (end - start) + " ms.");
    }

    public void testAddComment() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Comment[] testarray = new Comment[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new CommentImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addComment(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Comment 1000 times took " + (end - start) + " ms.");
    }

    public void testAddDefaultParameter() {

        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addDefaultParameter(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Default Parameter 1000 times took " + (end - start) + " ms.");
    }

    public void testAddElementImport() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        ElementImport[] testarray = new ElementImport[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new ElementImportImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addElementImport(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding an Element Import 1000 times took " + (end - start) + " ms.");
    }

    public void testAddReferenceTag() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addReferenceTag(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Reference Tag 1000 times took " + (end - start) + " ms.");
    }

    public void testAddStereotype() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Stereotype[] testarray = new Stereotype[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StereotypeImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addStereotype(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Comment 1000 times took " + (end - start) + " ms.");
    }

    public void testAddSupplierDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addSupplierDependency(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Supplier Dependency 1000 times took " + (end - start) + " ms.");
    }

    public void testAddTaggedValue() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTaggedValue(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Tagged Value 1000 times took " + (end - start) + " ms.");
    }

    public void testAddTemplateArgument() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateArgument[] testarray = new TemplateArgument[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateArgumentImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateArgument(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Template Argument 1000 times took " + (end - start) + " ms.");
    }

    public void testAddTemplateParameter() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateParameter(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Template Parameter 1000 times took " + (end - start) + " ms.");
    }

    public void testAddTemplateParameter1() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateParameter(i, testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Adding a Template Parameter with index 1000 times took " + (end - start) + " ms.");
    }

    public void testClearBehaviors() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addBehavior(new StateMachineImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearBehaviors();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Behavior Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearClientDependencies() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addClientDependency(new DependencyImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearClientDependencies();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Client Dependency Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearComments() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addComment(new CommentImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearComments();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Comment Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearDefaultParameters() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addDefaultParameter(new TemplateParameterImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearDefaultParameters();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Default Parameter Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearElementImports() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addElementImport(new ElementImportImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearElementImports();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Element Import Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearReferenceTags() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addReferenceTag(new TaggedValueImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearReferenceTags();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Reference Tag Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearStereotypes() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addStereotype(new StereotypeImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearStereotypes();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Steretype Collection with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearSupplierDependencies() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addSupplierDependency(new DependencyImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearSupplierDependencies();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Suplier Dependency with 1000 items took " + (end - start) + " ms.");
    }

    public void testClearTaggedValues() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTaggedValue(new TaggedValueImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearTaggedValues();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Clearing a Tagged Value 1000 items took " + (end - start) + " ms.");
    }

    public void testClearTemplateArguments() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateArgument[] testarray = new TemplateArgument[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateArgument(new TemplateArgumentImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearTemplateArguments();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Crealing a Template Argument with index 1000 times took " + (end - start) + " ms.");
    }

    public void testClearTemplateParameters() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateParameter(new TemplateParameterImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.clearTemplateParameters();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Crealing a Template Parameter with index 1000 times took " + (end - start) + " ms.");
    }

    public void testGetBehaviors() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addBehavior(new StateMachineImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getBehaviors();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Comment took " + (end - start) + " ms.");
    }

    public void testGetClientDependencies() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addClientDependency(new DependencyImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getClientDependencies();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Comment took " + (end - start) + " ms.");
    }

    public void testGetComments() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addComment(new CommentImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getComments();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Comment took " + (end - start) + " ms.");
    }

    public void testGetDefaultParameters() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateParameter(new TemplateParameterImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getTemplateParameters();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Element Imports Tags took " + (end - start) + " ms.");
    }

    public void testGetElementImports() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addElementImport(new ElementImportImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getElementImports();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Element Imports Tags took " + (end - start) + " ms.");
    }

    public void testGetReferenceTags() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addReferenceTag(new TaggedValueImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getReferenceTags();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Reference Tags took " + (end - start) + " ms.");
    }

    public void testGetStereotypes() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addStereotype(new StereotypeImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getStereotypes();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Stereotypes took " + (end - start) + " ms.");
    }

    public void testGetSupplierDependencies() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addSupplierDependency(new DependencyImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getSupplierDependencies();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Supplier Dependencies took " + (end - start) + " ms.");
    }

    public void testGetTaggedValues() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTaggedValue(new TaggedValueImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getTaggedValues();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 Tagged Values took " + (end - start) + " ms.");
    }

    public void testGetTemplateArguments() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        // Initialize
        for (int i = 0; i < 1000; i++) {
            operationImpl.addTemplateArgument(new TemplateArgumentImpl());
        }
        // Test begins
        start = System.currentTimeMillis();
        Collection actualReturn = operationImpl.getTemplateArguments();
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Getting 1000 methods took " + (end - start) + " ms.");
    }

    public void testGetTemplateParameters() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        StateMachine[] testarray = new StateMachine[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StateMachineImpl();
            operationImpl.addBehavior(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeBehavior(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Behavior from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveBehavior() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        StateMachine[] testarray = new StateMachine[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StateMachineImpl();
            operationImpl.addBehavior(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeBehavior(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Behavior from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveClientDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
            operationImpl.addClientDependency(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeClientDependency(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Client Dependency from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveComment() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Comment[] testarray = new Comment[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new CommentImpl();
            operationImpl.addComment(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeComment(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Comment Tag from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveDefaultParameter() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
            operationImpl.addDefaultParameter(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeDefaultParameter(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Default Parameter Tag from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveElementImport() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        ElementImport[] testarray = new ElementImport[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new ElementImportImpl();
            operationImpl.addElementImport(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeElementImport(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Element Import Tag from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveReferenceTag() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
            operationImpl.addReferenceTag(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeReferenceTag(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Reference Tag from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveStereotype() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Stereotype[] testarray = new Stereotype[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StereotypeImpl();
            operationImpl.addStereotype(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeStereotype(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Stereotype from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveSupplierDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
            operationImpl.addSupplierDependency(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeSupplierDependency(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Supplier Dependency from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveTaggedValue() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
            operationImpl.addTaggedValue(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeTaggedValue(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Tagged Value from a Collection with 1000 times took " + (end - start) + " ms.");
    }

    public void testRemoveTemplateArgument() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateArgument[] testarray = new TemplateArgument[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateArgumentImpl();
            operationImpl.addTemplateArgument(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeTemplateArgument(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Template Argument from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveTemplateParameter() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
            operationImpl.addTemplateParameter(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeTemplateParameter(testarray[i]);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Template Parameter from a Collection with 1000 times took " + (end - start)
            + " ms.");
    }

    public void testRemoveTemplateParameter1() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
            operationImpl.addTemplateParameter(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            operationImpl.removeTemplateParameter(0);
        }
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Removing Template Parameter from a Collection with index 1000 times took " + (end - start)
            + " ms.");
    }

    public void testContainsMethod() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Method[] testarray = new Method[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new MethodImpl();
            operationImpl.addMethod(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsMethod(testarray[0]);
        operationImpl.containsMethod(testarray[50]);
        operationImpl.containsMethod(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Method is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsBehavior() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        StateMachine[] testarray = new StateMachine[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StateMachineImpl();
            operationImpl.addBehavior(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsBehavior(testarray[0]);
        operationImpl.containsBehavior(testarray[50]);
        operationImpl.containsBehavior(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Behavior is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");

    }

    public void testContainsClientDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
            operationImpl.addClientDependency(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsClientDependency(testarray[0]);
        operationImpl.containsClientDependency(testarray[50]);
        operationImpl.containsClientDependency(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Dependency is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsComment() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Comment[] testarray = new Comment[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new CommentImpl();
            operationImpl.addComment(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsComment(testarray[0]);
        operationImpl.containsComment(testarray[50]);
        operationImpl.containsComment(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Comment is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsDefaultParameter() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
            operationImpl.addDefaultParameter(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsDefaultParameter(testarray[0]);
        operationImpl.containsDefaultParameter(testarray[50]);
        operationImpl.containsDefaultParameter(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        // Test ends
        System.out.println("Contains tests to see if a Template Parameter is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsElementImport() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        ElementImport[] testarray = new ElementImport[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new ElementImportImpl();
            operationImpl.addElementImport(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsElementImport(testarray[0]);
        operationImpl.containsElementImport(testarray[50]);
        operationImpl.containsElementImport(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Element Import is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");

    }

    public void testContainsReferenceTag() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
            operationImpl.addReferenceTag(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsReferenceTag(testarray[0]);
        operationImpl.containsReferenceTag(testarray[50]);
        operationImpl.containsReferenceTag(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Reference Tag is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsStereotype() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Stereotype[] testarray = new Stereotype[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new StereotypeImpl();
            operationImpl.addStereotype(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsStereotype(testarray[0]);
        operationImpl.containsStereotype(testarray[50]);
        operationImpl.containsStereotype(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Stereotype is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsSupplierDependency() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        Dependency[] testarray = new Dependency[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new DependencyImpl();
            operationImpl.addSupplierDependency(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsSupplierDependency(testarray[0]);
        operationImpl.containsSupplierDependency(testarray[50]);
        operationImpl.containsSupplierDependency(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Dependency is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsTaggedValue() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TaggedValue[] testarray = new TaggedValue[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TaggedValueImpl();
            operationImpl.addTaggedValue(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsTaggedValue(testarray[0]);
        operationImpl.containsTaggedValue(testarray[50]);
        operationImpl.containsTaggedValue(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Tagged Value is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsTemplateArgument() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateArgument[] testarray = new TemplateArgument[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateArgumentImpl();
            operationImpl.addTemplateArgument(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsTemplateArgument(testarray[0]);
        operationImpl.containsTemplateArgument(testarray[50]);
        operationImpl.containsTemplateArgument(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Template Argument is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

    public void testContainsTemplateParameter() {
        /** start of test * */
        long start;
        /** end of test * */
        long end;
        // test array for test1
        TemplateParameter[] testarray = new TemplateParameter[1000];
        // Initialize
        for (int i = 0; i < 1000; i++) {
            testarray[i] = new TemplateParameterImpl();
            operationImpl.addTemplateParameter(testarray[i]);
        }
        // Test begins
        start = System.currentTimeMillis();
        operationImpl.containsTemplateParameter(testarray[0]);
        operationImpl.containsTemplateParameter(testarray[50]);
        operationImpl.containsTemplateParameter(testarray[100]);
        end = System.currentTimeMillis();
        // Test ends
        System.out.println("Contains tests to see if a Template Parameter is contained in the model - took"
            + " index 1000 times took " + (end - start) + " ms.");
    }

}