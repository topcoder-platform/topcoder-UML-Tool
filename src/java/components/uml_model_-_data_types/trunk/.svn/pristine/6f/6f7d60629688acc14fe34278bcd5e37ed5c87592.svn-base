/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.MappingExpression;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.TypeExpression;
import com.topcoder.uml.model.datatypes.expressions.TypeExpressionImpl;

/**
 * <p>
 * Component demonstration for UML Model Data Types 1.0. There are three demos: <br>
 * 1. Instantiation <br>
 * 2. Simple attribute management <br>
 * 3. Collection attribute management <br>
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * The demo for instantiation will demonstrate: <br>
     * 1. Create instance of <code>Multiplicity</code>; <br>
     * 2. Create instance of <code>MultiplicityRange</code>; <br>
     * 3. Create instance of <code>Expression</code>; <br>
     * 4. Create instance of <code>BooleanExpression</code>; <br>
     * 5. Create instance of <code>MappingExpression</code>; <br>
     * 6. Create instance of <code>ProcedureExpression</code>; <br>
     * 7. Create instance of <code>TypeExpression</code>; <br>
     * </p>
     */
    public void testDemoOfInstantiation() {
        // 1. Create instance of Multiplicity;
        Multiplicity multiplicity = new MultiplicityImpl();

        // 2. Create instance of MultiplicityRange;
        MultiplicityRange multiplicityRange = new MultiplicityRangeImpl();

        // 3. Create instance of Expression;
        Expression expression = new ExpressionImpl();

        // 4. Create instance of BooleanExpression;
        BooleanExpression booleanExpression = new BooleanExpressionImpl();

        // 5. Create instance of MappingExpression;
        MappingExpression mappingExpression = new MappingExpressionImpl();

        // 6. Create instance of ProcedureExpression;
        ProcedureExpression procedureExpression = new ProcedureExpressionImpl();

        // 7. Create instance of TypeExpression;
        TypeExpression typeExpression = new TypeExpressionImpl();
    }

    /**
     * <p>
     * The demo for <code>Multiplicity</code> simple attribute management demonstrates: <br>
     * 1. addRange to add a <code>MultiplicityRange</code> object; <br>
     * 2. removeRange to remove a <code>MultiplicityRange</code> object; <br>
     * 3. getRanges to get all ranges in this <code>Multiplicity</code> object; <br>
     * 4. countRanges to count the number of ranges in in this <code>Multiplicity</code> object;<br>
     * 5. containsRange to check if a range is in the collection; <br>
     * </p>
     */
    public void testDemoOfMultiplicitySimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        Multiplicity multiplicity = new MultiplicityImpl();

        // 1. addRange
        MultiplicityRange range1 = new MultiplicityRangeImpl();
        MultiplicityRange range2 = new MultiplicityRangeImpl();

        // add range1
        multiplicity.addRange(range1);
        // add range1, then we have two range1's in this multiplicity entity
        multiplicity.addRange(range1);

        // 5. containsRange
        boolean containsRange1 = multiplicity.containsRange(range1);
        // containsRange1 should be true, since we have added it in
        boolean containsRange2 = multiplicity.containsRange(range2);
        // containsRange2 should be false, since we have never added it

        // 4. countRanges
        // we have 2 ranges, so value of count1 equals 2.
        int count1 = multiplicity.countRanges();

        // 2. removeRange
        boolean removed1 = multiplicity.removeRange(range2);
        // since range2 does not exist, do nothing and return false

        boolean removed2 = multiplicity.removeRange(range1);
        // since range1 exists in the collection, remove one of the two range1's
        // now, we have only one range1 in the collection and the countRanges returns one

        // 5. containsRange
        containsRange1 = multiplicity.containsRange(range1);
        // containsRange1 should be true, since we still have one range1 object in it

        // 3. getRanges
        Collection<MultiplicityRange> retrievedRanges = multiplicity.getRanges();
        // the collection constains only one range1 now
    }

    /**
     * <p>
     * The demo for <code>Multiplicity</code> collection attribute management demonstrates: <br>
     * 1. addRanges <br>
     * 2. removeRanges <br>
     * 3. clearRanges <br>
     * </p>
     */
    public void testDemoOfMultiplicityCollectionAttributeManagement() {
        // Create sample entity with a collection attribute to manage
        Multiplicity multiplicity = new MultiplicityImpl();

        // Use single-entity add method
        MultiplicityRange ran1 = new MultiplicityRangeImpl();
        multiplicity.addRange(ran1);
        // There is now one range in the collection: {0}

        // Use multiple-entity add method
        Collection<MultiplicityRange> col1 = new ArrayList<MultiplicityRange>();
        // add another five different ranges, {1, 2, 3, 4, 5}
        MultiplicityRange[] colArray1 = new MultiplicityRange[5];
        for (int i = 0; i < colArray1.length; i++) {
            colArray1[i] = new MultiplicityRangeImpl();
            col1.add(colArray1[i]);
        }
        // now col1: {1, 2 ,3, 4, 5}
        // add duplicate ranges to col1
        for (int i = 0; i < 3; i++) {
            col1.add(colArray1[1]);
        }
        // now col1 : {1, 2, 3, 4, 5, 1, 2, 3}
        multiplicity.addRanges(col1);
        // There will now be 9 ranges in the collection: {0, 1, 2, 3, 4, 5, 1, 2, 3}

        // Use contains method to check for range presence
        boolean present = multiplicity.containsRange(ran1);
        // This will be true

        // Use count method to get the number of ranges
        int count = multiplicity.countRanges();
        // The count will be 9

        // Use single-entity remove method
        boolean removed = multiplicity.removeRange(ran1);
        // This will be true, and the collection size is 8, regardless
        // if ran1 has duplicates in this collection.
        // now collection: {1, 2, 3, 4, 5, 1, 2, 3}

        // Use multiple-entity remove method
        Collection<MultiplicityRange> col2 = new ArrayList<MultiplicityRange>();
        // add three ranges to col2, such that col2 is a subset of col1
        for (int i = 0; i < 3; i++) {
            col2.add(colArray1[i]);
        }
        // now col2: {1, 2, 3}
        boolean altered = multiplicity.removeRanges(col2);
        // This will be true, and the collection size is 5
        // the collection will be {4, 5, 1, 2, 3}, since the removeRanges is first-basis remove

        // Use clear method
        multiplicity.clearRanges();
        // The collection size is 0 and contains no ranges
        // now collection: {}

    }

    /**
     * <p>
     * The demo for <code>MultiplicityRange</code> simple attribute management demonstrates: <br>
     * 1. Setter/Getter of Lower property; <br>
     * 2. Setter/Getter of Upper property; <br>
     * 3. Setter/Getter of Muliplicity property; <br>
     * </p>
     */
    public void testDemoOfMultiplicityRangeSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        MultiplicityRange multiplicityRange = new MultiplicityRangeImpl();

        // 1. Setter/Getter of Lower property
        // lower should be non-negative
        int lower = 3;
        multiplicityRange.setLower(lower);
        int retrievedLower = multiplicityRange.getLower();

        // 2. Setter/Getter of Upper property
        // upper should be non-negative
        int upper = 30;
        multiplicityRange.setUpper(upper);
        int retrievedUpper = multiplicityRange.getUpper();

        // 3. Setter/Getter of Muliplicity property
        // multiplicity could be null
        Multiplicity multiplicity = new MultiplicityImpl();
        multiplicityRange.setMultiplicity(multiplicity);
        Multiplicity retrievedMultiplicity = multiplicityRange.getMultiplicity();
    }

    /**
     * <p>
     * The demo for <code>Expression</code> simple attribute management demonstrates: <br>
     * 1. Setter/Getter of Procedure property; <br>
     * 2. Setter/Getter of Body property; <br>
     * 3. Setter/Getter of Language property; <br>
     * </p>
     */
    public void testDemoOfExpressionSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        Expression expression = new ExpressionImpl();

        // 1. Setter/Getter of Procedure property
        // Use setter
        Procedure procedure = new ProcedureImpl();
        expression.setProcedure(procedure);
        // Use getter
        Procedure retrievedProcedure = expression.getProcedure();

        // 2. Setter/Getter of Body property
        // Use setter
        String body = "23*3-(3-2)/1";
        expression.setBody(body);
        // Use getter
        String retrievedBody = expression.getBody();

        // 3. Setter/Getter of Language property
        // Use setter
        String language = "java";
        expression.setLanguage(language);
        // Use getter
        String retrievedLanguage = expression.getLanguage();
    }

    /**
     * <p>
     * The demo for <code>BooleanExpression</code> simple attribute management demonstrates: <br>
     * 1. Setter/Getter of Procedure property; <br>
     * 2. Setter/Getter of Body property; <br>
     * 3. Setter/Getter of Language property; <br>
     * </p>
     */
    public void testDemoOfBooleanExpressionSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        BooleanExpression expression = new BooleanExpressionImpl();

        // 1. Setter/Getter of Procedure property
        // Use setter
        Procedure procedure = new ProcedureImpl();
        expression.setProcedure(procedure);
        // Use getter
        Procedure retrievedProcedure = expression.getProcedure();

        // 2. Setter/Getter of Body property
        // Use setter
        String body = "2 == 3";
        expression.setBody(body);
        // Use getter
        String retrievedBody = expression.getBody();

        // 3. Setter/Getter of Language property
        // Use setter
        String language = "java";
        expression.setLanguage(language);
        // Use getter
        String retrievedLanguage = expression.getLanguage();
    }

    /**
     * <p>
     * The demo for <code>MappingExpression</code> simple attribute management demonstrates: <br>
     * 1. Setter/Getter of Procedure property; <br>
     * 2. Setter/Getter of Body property; <br>
     * 3. Setter/Getter of Language property; <br>
     * </p>
     */
    public void testDemoOfMappingExpressionSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        MappingExpression expression = new MappingExpressionImpl();

        // 1. Setter/Getter of Procedure property
        // Use setter
        Procedure procedure = new ProcedureImpl();
        expression.setProcedure(procedure);
        // Use getter
        Procedure retrievedProcedure = expression.getProcedure();

        // 2. Setter/Getter of Body property
        // Use setter
        String body = "2 == 3";
        expression.setBody(body);
        // Use getter
        String retrievedBody = expression.getBody();

        // 3. Setter/Getter of Language property
        // Use setter
        String language = "java";
        expression.setLanguage(language);
        // Use getter
        String retrievedLanguage = expression.getLanguage();
    }

    /**
     * <p>
     * The demo for <code>ProcedureExpression</code> simple attribute management demonstrates:
     * <br>
     * 1. Setter/Getter of Procedure property; <br>
     * 2. Setter/Getter of Body property; <br>
     * 3. Setter/Getter of Language property; <br>
     * </p>
     */
    public void testDemoOfProcedureExpressionSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        ProcedureExpression expression = new ProcedureExpressionImpl();

        // 1. Setter/Getter of Procedure property
        // Use setter
        Procedure procedure = new ProcedureImpl();
        expression.setProcedure(procedure);
        // Use getter
        Procedure retrievedProcedure = expression.getProcedure();

        // 2. Setter/Getter of Body property
        // Use setter
        String body = "void hello(){}";
        expression.setBody(body);
        // Use getter
        String retrievedBody = expression.getBody();

        // 3. Setter/Getter of Language property
        // Use setter
        String language = "java";
        expression.setLanguage(language);
        // Use getter
        String retrievedLanguage = expression.getLanguage();
    }

    /**
     * <p>
     * The demo for <code>TypeExpression</code> simple attribute management demonstrates: <br>
     * 1. Setter/Getter of Procedure property; <br>
     * 2. Setter/Getter of Body property; <br>
     * 3. Setter/Getter of Language property; <br>
     * </p>
     */
    public void testDemoOfTypeExpressionSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        TypeExpression expression = new TypeExpressionImpl();

        // 1. Setter/Getter of Procedure property
        // Use setter
        Procedure procedure = new ProcedureImpl();
        expression.setProcedure(procedure);
        // Use getter
        Procedure retrievedProcedure = expression.getProcedure();

        // 2. Setter/Getter of Body property
        // Use setter
        String body = "public class A {}";
        expression.setBody(body);
        // Use getter
        String retrievedBody = expression.getBody();

        // 3. Setter/Getter of Language property
        // Use setter
        String language = "java";
        expression.setLanguage(language);
        // Use getter
        String retrievedLanguage = expression.getLanguage();
    }

}
