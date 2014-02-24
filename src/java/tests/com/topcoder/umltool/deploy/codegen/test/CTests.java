/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.awt.Robot;
import java.io.File;

import swingunit.extensions.ExtendedRobotEventFactory;
import swingunit.framework.EventPlayer;
import swingunit.framework.FinderMethodSet;
import swingunit.framework.Scenario;
import junit.framework.TestCase;

/**
 * <p>
 * Test Cases of Code Generation for C#.
 * </p>
 *
 * @author tweg
 * @version 1.0
 */
public class CTests extends TestCase {

    /** The scenario script used for testing. */
    private Scenario scenario;

    /** The scenario robot used for testing. */
    private Robot robot;

    /** The event player used for testing. */
    private EventPlayer player;

    /**
     * <p>
     * Wrap method for <code>TestHelper.CheckCodeContains</code> using C# Setting.
     * </p>
     *
     * @param className the className to check
     * @param context the context to check
     * @return -1 if not found. otherwise index of the position.
     * @throws Exception if any error occurs
     */
    private static int wrapCCodeContain(String className, String context) throws Exception {
        return TestHelper.checkCodeContains(TestHelper.getCodeGenBase() + "/c/mock", className,
            TestHelper.C_SUFFIX, context, 0);
    }

    private static int wrapCCodeContain(String className, String context, int index) throws Exception {
        return TestHelper.checkCodeContains(TestHelper.getCodeGenBase() + "/c/mock", className,
            TestHelper.C_SUFFIX, context, index);
    }

    /**
     * <p>
     * Check the signature with braces of a class/interface/enum and etc.
     * </p>
     *
     * @param className the full name of the class to check
     * @param signature the signature to check
     * @param errorMessage the errorMessage to show when failed
     * @throws Exception if any error occurs
     */
    private static void checkSignatureWithBraces(String className, String signature, String errorMessage)
        throws Exception {
        int index = wrapCCodeContain(className, signature);
        assertTrue(errorMessage + " with signature:" + signature, index != -1);
        String context = "}";
        int index1 = wrapCCodeContain(className, context, index);
        assertTrue(errorMessage + " with signature:" + signature, index1 > index);
    }

    /**
     * <p>
     * Check the signature of a class/interface/enum and etc.
     * </P>
     *
     * @param className the full name of the class to check
     * @param signature the signature to check
     * @param errorMessage the errorMessage to show when failed
     * @throws Exception if any error occurs
     */
    private static void checkSignature(String className, String signature, String errorMessage)
        throws Exception {
        int index = wrapCCodeContain(className, signature);
        assertTrue(errorMessage + " with signature:" + signature, index != -1);
    }

    /**
     * <p>
     * Test case number:1 REQ:2.95.1.3 Description: Verify that package is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test1() throws Exception {
        int index = wrapCCodeContain("TopCoder.WPF.KeyProviderImpl.Class_1", "TopCoder.WPF.KeyProviderImpl {");
        assertTrue("Test 1 failed.In class:TopCoder.WPF.KeyProviderImpl.Class_1", index != -1);
    }

    /**
     * <p>
     * Test case number:2 REQ:2.95.1.3 Description: Verify that class document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test2() throws Exception {
        String context = "/// <p>" + TestHelper.LINE_SEP + "/// WindowSizeManager documentation"
            + TestHelper.LINE_SEP + "/// </p>";
        int index = wrapCCodeContain("Package_2.WindowSizeManager", context);
        assertTrue("Test 2 failed.With conext:" + context, index != -1);
    }

    /**
     * <p>
     * Test case number:3 REQ:2.95.1.3 Description: Verify that class header is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test3() throws Exception {
        String context = "public class Class_3{";
        int index = wrapCCodeContain("Package_3.Class_3", context);
        assertTrue("Test 3 failed.With context:" + context, index != -1);

        context = "/// <author>TCSDEVELOPER</author>";
        int index1 = wrapCCodeContain("Package_3.Class_3", context);
        assertTrue("Test 3 failed.With context:" + context, index1 != -1 && index1 < index);

        context = "/// <version>1.0</version>";
        index1 = wrapCCodeContain("Package_3.Class_3", context);
        assertTrue("Test 3 failed.With context:" + context, index1 != -1 && index1 < index);

        context = "/// <see>...</see>";
        index1 = wrapCCodeContain("Package_3.Class_3", context);
        assertTrue("Test 3 failed.With context:" + context, index1 != -1 && index1 < index);

        context = "/// <since>...</since>";
        index1 = wrapCCodeContain("Package_3.Class_3", context);
        assertTrue("Test 3 failed.With context:" + context, index1 != -1 && index1 < index);
    }

    /**
     * <p>
     * Test case number:4 REQ:2.95.1.3 Description: Verify that an abstract class is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test4() throws Exception {
        String signature = "public abstract class WindowSizeManager{";
        checkSignatureWithBraces("Package_4.WindowSizeManager", signature, "Test 4 failed.");
    }

    /**
     * <p>
     * Test case number:5 REQ:2.95.1.3 Description: Verify that a package private class is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test5() throws Exception {
        String signature = "class WindowSizeManager{";
        checkSignatureWithBraces("Package_5.WindowSizeManager", signature, "Test 5 failed.");
    }

    /**
     * <p>
     * Test case number:6 REQ:2.95.1.3 Description: Verify that an interface is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test6() throws Exception {
        String signature = "public interface EntityChangeListener{";
        checkSignatureWithBraces("Package_6.EntityChangeListener", signature, "Test 5 failed.");
    }

    /**
     * <p>
     * Test case number:7 REQ:2.95.1.3 Description: Verify that an enumeration is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test7() throws Exception {
        String signature = "enum EntityChangeListener{";
        checkSignatureWithBraces("Package_7.EntityChangeEventType", signature, "Test 7 failed.");
    }

    /**
     * <p>
     * Test case number:8 REQ:2.95.1.3 Description: Verify that a class that extends another class is
     * generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test8() throws Exception {
        String signature = "public class ChildClass : BaseClass{";
        checkSignatureWithBraces("Package_8.ChildClass", signature, "Test 8 failed.");
    }

    /**
     * <p>
     * Test case number:9 REQ:2.95.1.3 Description: Verify that a class that implements interface is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test9() throws Exception {
        String signature = "public class ChildClass : baseInterface{";
        checkSignatureWithBraces("Package_9.ChildClass", signature, "Test 9 failed.");
    }

    /**
     * <p>
     * Test case number:10 REQ:2.95.1.3 Description: Verify that a struct is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test10() throws Exception {
        String signature = "public struct Class_10{";
        checkSignatureWithBraces("Package_10.Class_10", signature, "Test 10 failed.");
    }

    /**
     * <p>
     * Test case number:11 REQ:2.95.1.3 Description: Verify that an attribute document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test11() throws Exception {
        String signature = "private int demoAttribute;";
        int index = wrapCCodeContain("Package_11.Class_11", signature);
        assertTrue("Test 11 failed: attribute not found ", index != -1);

        signature = "/// Sample attribute document";
        int index1 = wrapCCodeContain("Package_11.Class_11", signature);
        assertTrue("Test 11 failed: attribute document not found ", index > index1);
    }

    /**
     * <p>
     * Test case number:12 REQ:2.95.1.3 Description: Verify that a private attribute is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test12() throws Exception {
        String signature = "private string demoAttribute;";
        checkSignature("Package_12.Class_12", signature, "Test 11 failed.");
    }

    /**
     * <p>
     * Test case number:13 REQ:2.95.1.3 Description: Verify that a private attribute is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test13() throws Exception {
        String signature = "private const int demoAttribute;";
        checkSignature("Package_13.Class_13", signature, "Test 13 failed.");
    }

    /**
     * <p>
     * Test case number:14 REQ:2.95.1.3 Description: Verify that a const static attribute is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test14() throws Exception {
        String signature = "private static const int demoAttribute;";
        checkSignature("Package_14.Class_14", signature, "Test 14 failed.");
    }

    /**
     * <p>
     * Test case number:15 REQ:2.95.1.3 Description: Verify that an attribute with a default value is
     * generated correctly. correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test15() throws Exception {
        String signature = "private int sample = 1000;";
        checkSignature("Package_15.Class_15", signature, "Test 15 failed.");
    }

    /**
     * <p>
     * Test case number:16 REQ:2.95.1.3 Description: Verify that an internal static attribute is generated
     * correctly. generated correctly. correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test16() throws Exception {
        String signature = "static string demoAttribute;";
        checkSignature("Package_16.Class_16", signature, "Test 16 failed.");
    }

    /**
     * <p>
     * Test case number:17 REQ:2.95.1.3 Description: Verify that method document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test17() throws Exception {
        String signature = "public void MethodForTest() {";
        int index = wrapCCodeContain("Package_17.Class_17", signature);
        assertTrue("Test 17 faild.With signature:" + signature, index != -1);

        signature = "/// method document";
        int index1 = wrapCCodeContain("Package_17.Class_17", signature);
        assertTrue("Test 17 faild.With signature:" + signature, index1 != -1 && index1 < index);
    }

    /**
     * <p>
     * Test case number:18 REQ:2.95.1.3 Description: Verify that a method with tags is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test18() throws Exception {
        String signature = "/// <exception>";
        int index = wrapCCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 faild.With context:" + signature, index != -1);
        
        signature = "if the <paramref name=\"value\"/> or <paramref name=\"pattern\"/> is null";
        int index1 = wrapCCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 faild.With context:" + signature, index1 > index);
        index = index1;

        signature = "</exception>";
        index1 = wrapCCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 faild.With context:" + signature, index1 > index);
    }

    /**
     * <p>
     * Test case number:19 REQ:2.95.1.3 Description: Verify that the method return document is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test19() throws Exception {
        String signature = "/// <returns>" + TestHelper.LINE_SEP + "/// return documentz"
            + TestHelper.LINE_SEP + "/// </returns>" + TestHelper.LINE_SEP;
        int index = wrapCCodeContain("Package_19.Class_19", signature);
        assertTrue("Test 19 faild.With signature:" + signature, index != -1);
    }

    /**
     * <p>
     * Test case number:20 REQ:2.95.1.3 Description: Verify that a constructor is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test20() throws Exception {
        String signature = "public Class_20() {";
        checkSignatureWithBraces("Package_20.Class_20", signature, "Test 20 faild.");
    }

    /**
     * <p>
     * Test case number:21 REQ:2.95.1.3 Description: Verify that the method signature is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test21() throws Exception {
        String signature = "public void method1() {";
        checkSignatureWithBraces("Package_21.Class_21", signature, "Test 21 faild.");
    }

    /**
     * <p>
     * Test case number:22 REQ:2.95.1.3 Description: Verify that the method return is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test22() throws Exception {
        String signature = "public string method1() {";
        checkSignatureWithBraces("Package_22.Class_22", signature, "Test 22 faild.");
    }

    /**
     * <p>
     * Test case number:23 REQ:2.95.1.3 Description: Verify that a static method is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test23() throws Exception {
        String signature = "public static void method1() {";
        checkSignatureWithBraces("Package_23.Class_23", signature, "Test 23 faild.");
    }

    /**
     * <p>
     * Test case number:24 REQ:2.95.1.3 Description: Verity that an abstract method is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test24() throws Exception {
        String signature = "public abstract void method1();";
        checkSignature("Package_24.Class_24", signature, "Test 24 faild.");
    }

    /**
     * <p>
     * Test case number:25 REQ:2.95.1.3 Description: Verify that the method parameters are generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test25() throws Exception {
        String signature = "public void method1(int a, string b, double c) {";
        checkSignatureWithBraces("Package_25.Class_25", signature, "Test 25 faild.");
    }

    /**
     * <p>
     * Test case number:26 REQ:2.95.1.3 Description: Verify that an override method is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test26() throws Exception {
        String signature = "public override void method1() {";
        checkSignatureWithBraces("Package_26.ChildClass", signature, "Test 26 faild.");
    }

    /**
     * <p>
     * Test case number:27 REQ:2.95.1.3 Description: Verify that a destructor is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test27() throws Exception {
        String signature = "~Class_27() {";
        checkSignatureWithBraces("Package_27.Class_27", signature, "Test 27 faild.");
    }

    /**
     * <p>
     * Test case number:28 REQ:2.95.1.3 Description: Verify that property document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test28() throws Exception {
        String signature = "/// property document";
        int index = wrapCCodeContain("Package_28.Class_28", signature);
        assertTrue("Test 28 failed.With context:" + signature, index != -1);

        signature = "private int attribute1{";
        int index1 = wrapCCodeContain("Package_28.Class_28", signature);
        assertTrue("Test 28 failed." + signature, index1 > index);
    }

    /**
     * <p>
     * Test case number:29 REQ:2.95.1.3 Description: Verify that property accessors are generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test29() throws Exception {
        String signature = "private String Name{" + TestHelper.LINE_SEP + "set{}"
        	+ TestHelper.LINE_SEP + "get{" + TestHelper.LINE_SEP
            + "return null;" + TestHelper.LINE_SEP + "}" + TestHelper.LINE_SEP +  "}";
        checkSignatureWithBraces("Package_29.Class_29", signature, "Test 29 faild.");
    }

    /**
     * <p>
     * Test case number:30 REQ:2.95.1.3 Description: Verify that an attribute data type is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test30() throws Exception {
        String signature = "using TopCoder.WPF.KeyProviderImpl;";
        checkSignature("Package_30.Class_30", signature, "Test 30 faild.");
    }

    /**
     * <p>
     * Test case number:31 REQ:2.95.1.3 Description: Verify that a returned data type is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test31() throws Exception {
        String signature = "using TopCoder.WPF.KeyProviderImpl;";
        checkSignature("Package_31.Class_31", signature, "Test 31 faild.");
    }

    /**
     * <p>
     * Test case number:32 REQ:2.95.1.3 Description: Verify that a parameter data type is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test32() throws Exception {
        String signature = "using TopCoder.WPF.KeyProviderImpl;";
        checkSignature("Package_32.Class_32", signature, "Test 32 faild.");
    }

    /**
     * <p>
     * Test case number:32 REQ:2.95.1.3 Description: Verify that the exception is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test33() throws Exception {
        String signature = "public ExceptionForTest(string message) {";
        checkSignatureWithBraces("Package_33.ExceptionForTest", signature, "Test 33 faild.");

        signature = "public ExceptionForTest(string message, Exception cause) {";
        checkSignatureWithBraces("Package_33.ExceptionForTest", signature, "Test 33 faild.");

        signature = "protected ExceptionForTest(SerializationInfo info, StreamingContext context) {";
        checkSignatureWithBraces("Package_33.ExceptionForTest", signature, "Test 33 faild.");
    }

    /**
     * <p>
     * Test case number:34 REQ:2.95.1.3 Description: Verify that the enumeration attribute is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test34() throws Exception {
        String signature = "enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};";
        checkSignature("Package_34.Class_34", signature, "Test 34 faild.");
    }

    /**
     * <p>
     * Test case number:36 REQ:2.95.1.3 Description: Verify the event stereotype is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test36() throws Exception {
        String signature = "private event SampleEventHandler SampleEvent;";
        checkSignature("Package_36.Class_36", signature, "Test 36 faild.");
    }

    /**
     * <p>
     * Test case number:37 REQ:2.95.1.3 Description: Verify the indexer stereotype is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test37() throws Exception {
        String signature = "public T this[int i]";
        checkSignatureWithBraces("Package_37.Class_37", signature, "Test 37 faild.");

        signature = "get";
        checkSignatureWithBraces("Package_37.Class_37", signature, "Test 37 faild.");

        signature = "set";
        checkSignatureWithBraces("Package_37.Class_37", signature, "Test 37 faild.");
    }

    /**
     * <p>
     * Test case number:38 REQ:2.95.1.3 Description: Verify the delegate stereotype is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test38() throws Exception {
        String signature = "public delegate void SampleDelegate";
        checkSignature("Package_38.Class_38", signature, "Test 38 faild.");
    }

    /**
     * <p>
     * Test case number:39 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * public option is tagged as the visibility choice without Modifiers option like abstract,final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test39() throws Exception {
        String signature = "public class EnityClass{";
        checkSignatureWithBraces("Package_39.EnityClass", signature, "Test 39 faild.");
    }

    /**
     * <p>
     * Test case number:40 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice without Modifiers option like abstract,final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test40() throws Exception {
        String signature = "protected class EnityClass{";
        checkSignatureWithBraces("Package_40.EnityClass", signature, "Test 40 faild.");
    }

    /**
     * <p>
     * Test case number:41 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice without Modifiers option like abstract,final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test41() throws Exception {
        String signature = "class EnityClass{";
        checkSignatureWithBraces("Package_41.EnityClass", signature, "Test 41 faild.");
    }

    /**
     * <p>
     * Test case number:42 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice without Modifiers option like abstract,final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test42() throws Exception {
        String signature = "private class EnityClass{";
        checkSignatureWithBraces("Package_42.EnityClass", signature, "Test 42 faild.");
    }

    /**
     * <p>
     * Test case number:43 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test43() throws Exception {
        String signature = "public abstract class EnityClass{";
        checkSignatureWithBraces("Package_43.EnityClass", signature, "Test 43 faild.");
    }

    /**
     * <p>
     * Test case number:43 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test44() throws Exception {
        String signature = "public sealed class EnityClass{";
        checkSignatureWithBraces("Package_44.EnityClass", signature, "Test 44 faild.");
    }

    /**
     * <p>
     * Test case number:45 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test45() throws Exception {
        String signature = "public static class EnityClass{";
        checkSignatureWithBraces("Package_45.EnityClass", signature, "Test 45 faild.");
    }

    /**
     * <p>
     * Test case number:46 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test46() throws Exception {
        String signature = "public static sealed class EnityClass{";
        checkSignatureWithBraces("Package_46.EnityClass", signature, "Test 46 faild.");
    }

    /**
     * <p>
     * Test case number:47 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test47() throws Exception {
        String signature = "protected abstract class EnityClass{";
        checkSignatureWithBraces("Package_47.EnityClass", signature, "Test 47 faild.");
    }

    /**
     * <p>
     * Test case number:48 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test48() throws Exception {
        String signature = "protected sealed class EnityClass{";
        checkSignatureWithBraces("Package_48.EnityClass", signature, "Test 48 faild.");
    }

    /**
     * <p>
     * Test case number:49 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice with Modifiers option is Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test49() throws Exception {
        String signature = "protected class EnityClass{";
        checkSignatureWithBraces("Package_49.EnityClass", signature, "Test 49 faild.");
    }

    /**
     * <p>
     * Test case number:50 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice with Modifiers option is Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test50() throws Exception {
        String signature = "protected sealed class EnityClass{";
        checkSignatureWithBraces("Package_50.EnityClass", signature, "Test 50 faild.");
    }

    /**
     * <p>
     * Test case number:51 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test51() throws Exception {
        String signature = "abstract class EnityClass{";
        checkSignatureWithBraces("Package_51.EnityClass", signature, "Test 51 faild.");
    }

    /**
     * <p>
     * Test case number:52 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test52() throws Exception {
        String signature = "sealed class EnityClass{";
        checkSignatureWithBraces("Package_52.EnityClass", signature, "Test 52 faild.");
    }

    /**
     * <p>
     * Test case number:53 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test53() throws Exception {
        String signature = "private abstract class EnityClass{";
        checkSignatureWithBraces("Package_53.EnityClass", signature, "Test 53 faild.");
    }

    /**
     * <p>
     * Test case number:54 REQ:2.95.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test54() throws Exception {
        String signature = "private sealed class EnityClass{";
        checkSignatureWithBraces("Package_54.EnityClass", signature, "Test 54 faild.");
    }

    /**
     * <p>
     * Test case number:55 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice and Changeable as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test55() throws Exception {
        String signature = "public int AttributeForTest;";
        checkSignature("Package_55.EnityClass", signature, "Test 55 faild.");
    }

    /**
     * <p>
     * Test case number:56 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice and Frozen as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test56() throws Exception {
        String signature = "public const int AttributeForTest;";
        checkSignature("Package_56.EnityClass", signature, "Test 56 faild.");
    }

    /**
     * <p>
     * Test case number:57 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice and Changeable as Changability choice without Modifiers
     * options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test57() throws Exception {
        String signature = "protected int AttributeForTest;";
        checkSignature("Package_57.EnityClass", signature, "Test 57 faild.");
    }

    /**
     * <p>
     * Test case number:58 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice and Frozen as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test58() throws Exception {
        String signature = "protected const int AttributeForTest;";
        checkSignature("Package_58.EnityClass", signature, "Test 58 faild.");
    }

    /**
     * <p>
     * Test case number:59 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice and Changeable as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test59() throws Exception {
        String signature = "int AttributeForTest;";
        checkSignature("Package_59.EnityClass", signature, "Test 59 faild.");
    }

    /**
     * <p>
     * Test case number:60 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice and Frozen as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test60() throws Exception {
        String signature = "const int AttributeForTest;";
        checkSignature("Package_60.EnityClass", signature, "Test 60 faild.");
    }

    /**
     * <p>
     * Test case number:61 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Priavte as the visibility choice and Changeable as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test61() throws Exception {
        String signature = "private int AttributeForTest;";
        checkSignature("Package_61.EnityClass", signature, "Test 61 faild.");
    }

    /**
     * <p>
     * Test case number:62 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice and Frozen as Changability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test62() throws Exception {
        String signature = "private const int AttributeForTest;";
        checkSignature("Package_62.EnityClass", signature, "Test 62 faild.");
    }

    /**
     * <p>
     * Test case number:63 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Changeable as Changability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test63() throws Exception {
        String signature = "public static int AttributeForTest;";
        checkSignature("Package_63.EnityClass", signature, "Test 63 faild.");
    }

    /**
     * <p>
     * Test case number:64 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test64() throws Exception {
        String signature = "public int AttributeForTest;";
        checkSignature("Package_64.EnityClass", signature, "Test 64 faild.");
    }

    /**
     * <p>
     * Test case number:65 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Frozen as Changability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test65() throws Exception {
        String signature = "public static const int AttributeForTest;";
        checkSignature("Package_65.EnityClass", signature, "Test 65 faild.");
    }

    /**
     * <p>
     * Test case number:66 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Frozen as Changability choice and Modifiers option as Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test66() throws Exception {
        String signature = "public const int AttributeForTest;";
        checkSignature("Package_66.EnityClass", signature, "Test 66 faild.");
    }

    /**
     * <p>
     * Test case number:67 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test67() throws Exception {
        String signature = "protected static int AttributeForTest;";
        checkSignature("Package_67.EnityClass", signature, "Test 67 faild.");
    }

    /**
     * <p>
     * Test case number:68 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test68() throws Exception {
        String signature = "protected int AttributeForTest;";
        checkSignature("Package_68.EnityClass", signature, "Test 68 faild.");
    }

    /**
     * <p>
     * Test case number:69 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Frozen as Changability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test69() throws Exception {
        String signature = "protected static const int AttributeForTest;";
        checkSignature("Package_69.EnityClass", signature, "Test 69 faild.");
    }

    /**
     * <p>
     * Test case number:70 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Frozen as Changability choice and Modifiers option as
     * Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test70() throws Exception {
        String signature = "protected const int AttributeForTest;";
        checkSignature("Package_70.EnityClass", signature, "Test 70 faild.");
    }

    /**
     * <p>
     * Test case number:71 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test71() throws Exception {
        String signature = "static int AttributeForTest;";
        checkSignature("Package_71.EnityClass", signature, "Test 71 faild.");
    }

    /**
     * <p>
     * Test case number:72 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test72() throws Exception {
        String signature = "int AttributeForTest;";
        checkSignature("Package_72.EnityClass", signature, "Test 72 faild.");
    }

    /**
     * <p>
     * Test case number:73 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Frozen as Changability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test73() throws Exception {
        String signature = "static const int AttributeForTest;";
        checkSignature("Package_73.EnityClass", signature, "Test 73 faild.");
    }

    /**
     * <p>
     * Test case number:74 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Frozen as Changability choice and Modifiers option as Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test74() throws Exception {
        String signature = "const int AttributeForTest;";
        checkSignature("Package_74.EnityClass", signature, "Test 74 faild.");
    }

    /**
     * <p>
     * Test case number:75 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test75() throws Exception {
        String signature = "private static int AttributeForTest;";
        checkSignature("Package_75.EnityClass", signature, "Test 75 faild.");
    }

    /**
     * <p>
     * Test case number:76 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Changeable as Changability choice and Modifiers option as
     * Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test76() throws Exception {
        String signature = "private int AttributeForTest;";
        checkSignature("Package_76.EnityClass", signature, "Test 76 faild.");
    }

    /**
     * <p>
     * Test case number:77 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Frozen as Changability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test77() throws Exception {
        String signature = "private static const int AttributeForTest;";
        checkSignature("Package_77.EnityClass", signature, "Test 77 faild.");
    }

    /**
     * <p>
     * Test case number:78 REQ:2.95.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Frozen as Changability choice and Modifiers option as Trasient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test78() throws Exception {
        String signature = "private const int AttributeForTest;";
        checkSignature("Package_78.EnityClass", signature, "Test 78 faild.");
    }

    /**
     * <p>
     * Test case number:79 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test79() throws Exception {
        String signature = "public int MethodForTest() {";
        checkSignatureWithBraces("Package_79.EnityClass", signature, "Test 79 faild.");
    }

    /**
     * <p>
     * Test case number:80 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test80() throws Exception {
        String signature = "protected int MethodForTest() {";
        checkSignatureWithBraces("Package_80.EnityClass", signature, "Test 80 faild.");
    }

    /**
     * <p>
     * Test case number:81 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test81() throws Exception {
        String signature = "int MethodForTest() {";
        checkSignatureWithBraces("Package_81.EnityClass", signature, "Test 81 faild.");
    }

    /**
     * <p>
     * Test case number:82 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test82() throws Exception {
        String signature = "private int MethodForTest() {";
        checkSignatureWithBraces("Package_82.EnityClass", signature, "Test 82 faild.");
    }

    /**
     * <p>
     * Test case number:83 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test83() throws Exception {
        String signature = "public abstract int MethodForTest();";
        checkSignatureWithBraces("Package_83.EnityClass", signature, "Test 83 faild.");
    }

    /**
     * <p>
     * Test case number:84 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test84() throws Exception {
        String signature = "protected abstract int MethodForTest();";
        checkSignatureWithBraces("Package_84.EnityClass", signature, "Test 84 faild.");
    }

    /**
     * <p>
     * Test case number:85 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test85() throws Exception {
        String signature = "abstract int MethodForTest();";
        checkSignatureWithBraces("Package_85.EnityClass", signature, "Test 85 faild.");
    }

    /**
     * <p>
     * Test case number:86 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test86() throws Exception {
        String signature = "private abstract int MethodForTest();";
        checkSignatureWithBraces("Package_86.EnityClass", signature, "Test 86 faild.");
    }

    /**
     * <p>
     * Test case number:87 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test87() throws Exception {
        String signature = "public sealed int MethodForTest() {";
        checkSignatureWithBraces("Package_87.EnityClass", signature, "Test 87 faild.");
    }

    /**
     * <p>
     * Test case number:88 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test88() throws Exception {
        String signature = "protected sealed int MethodForTest() {";
        checkSignatureWithBraces("Package_88.EnityClass", signature, "Test 88 faild.");
    }

    /**
     * <p>
     * Test case number:89 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test89() throws Exception {
        String signature = "sealed int MethodForTest() {";
        checkSignatureWithBraces("Package_89.EnityClass", signature, "Test 89 faild.");
    }

    /**
     * <p>
     * Test case number:90 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test90() throws Exception {
        String signature = "private sealed int MethodForTest() {";
        checkSignatureWithBraces("Package_90.EnityClass", signature, "Test 90 faild.");
    }

    /**
     * <p>
     * Test case number:91 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test91() throws Exception {
        String signature = "public static int MethodForTest() {";
        checkSignatureWithBraces("Package_91.EnityClass", signature, "Test 91 faild.");
    }

    /**
     * <p>
     * Test case number:92 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test92() throws Exception {
        String signature = "protected static int MethodForTest() {";
        checkSignatureWithBraces("Package_92.EnityClass", signature, "Test 92 faild.");
    }

    /**
     * <p>
     * Test case number:93 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test93() throws Exception {
        String signature = "static int MethodForTest() {";
        checkSignatureWithBraces("Package_93.EnityClass", signature, "Test 93 faild.");
    }

    /**
     * <p>
     * Test case number:94 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test94() throws Exception {
        String signature = "private static int MethodForTest() {";
        checkSignatureWithBraces("Package_94.EnityClass", signature, "Test 94 faild.");
    }

    /**
     * <p>
     * Test case number:95 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test95() throws Exception {
        String signature = "public sealed static int MethodForTest() {";
        checkSignatureWithBraces("Package_95.EnityClass", signature, "Test 95 faild.");
    }

    /**
     * <p>
     * Test case number:96 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test96() throws Exception {
        String signature = "protected sealed static int MethodForTest() {";
        checkSignatureWithBraces("Package_96.EnityClass", signature, "Test 96 faild.");
    }

    /**
     * <p>
     * Test case number:97 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test97() throws Exception {
        String signature = "sealed static int MethodForTest() {";
        checkSignatureWithBraces("Package_97.EnityClass", signature, "Test 97 faild.");
    }

    /**
     * <p>
     * Test case number:98 REQ:2.95.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test98() throws Exception {
        String signature = "private sealed static int MethodForTest() {";
        checkSignatureWithBraces("Package_98.EnityClass", signature, "Test 98 faild.");
    }

    /**
     * <p>
     * Test case number:99 REQ:2.95.1.3 Description: For class method signature,verify the generated code when
     * concurrency is selected.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test99() throws Exception {
        String signature = "public int MethodForTest() {";
        checkSignatureWithBraces("Package_99.EnityClass", signature, "Test 99 faild.");
    }

    /**
     * <p>
     * Test case number:100 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test100() throws Exception {
        String signature = "public interface InterfaceForTest{";
        checkSignatureWithBraces("Package_100.InterfaceForTest", signature, "Test 100 faild.");
    }

    /**
     * <p>
     * Test case number:101 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test101() throws Exception {
        String signature = "protected interface InterfaceForTest{";
        checkSignatureWithBraces("Package_101.InterfaceForTest", signature, "Test 101 faild.");
    }

    /**
     * <p>
     * Test case number:102 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test102() throws Exception {
        String signature = "interface InterfaceForTest{";
        checkSignatureWithBraces("Package_102.InterfaceForTest", signature, "Test 102 faild.");
    }

    /**
     * <p>
     * Test case number:103 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test103() throws Exception {
        String signature = "private interface InterfaceForTest{";
        checkSignatureWithBraces("Package_103.InterfaceForTest", signature, "Test 103 faild.");
    }

    /**
     * <p>
     * Test case number:104 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test104() throws Exception {
        String signature = "InterfaceForTest{";
        checkSignatureWithBraces("Package_104.InterfaceForTest", signature, "Test 104 faild.");
    }

    /**
     * <p>
     * Test case number:105 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test105() throws Exception {
        String signature = "protected abstract interface InterfaceForTest{";
        checkSignatureWithBraces("Package_105.InterfaceForTest", signature, "Test 105 faild.");
    }

    /**
     * <p>
     * Test case number:106 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test106() throws Exception {
        String signature = "abstract interface InterfaceForTest{";
        checkSignatureWithBraces("Package_106.InterfaceForTest", signature, "Test 106 faild.");
    }

    /**
     * <p>
     * Test case number:107 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test107() throws Exception {
        String signature = "private abstract interface InterfaceForTest{";
        checkSignatureWithBraces("Package_107.InterfaceForTest", signature, "Test 107 faild.");
    }

    /**
     * <p>
     * Test case number:108 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test108() throws Exception {
        String signature = "public interface InterfaceForTest{";
        checkSignatureWithBraces("Package_108.InterfaceForTest", signature, "Test 108 faild.");
    }

    /**
     * <p>
     * Test case number:109 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test109() throws Exception {
        String signature = "protected interface InterfaceForTest{";
        checkSignatureWithBraces("Package_109.InterfaceForTest", signature, "Test 109 faild.");
    }

    /**
     * <p>
     * Test case number:110 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test110() throws Exception {
        String signature = "interface InterfaceForTest{";
        checkSignatureWithBraces("Package_110.InterfaceForTest", signature, "Test 110 faild.");
    }

    /**
     * <p>
     * Test case number:111 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test111() throws Exception {
        String signature = "private interface InterfaceForTest{";
        checkSignatureWithBraces("Package_111.InterfaceForTest", signature, "Test 111 faild.");
    }

    /**
     * <p>
     * Test case number:112 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test112() throws Exception {
        String signature = "public static interface InterfaceForTest{";
        checkSignatureWithBraces("Package_112.InterfaceForTest", signature, "Test 112 faild.");
    }

    /**
     * <p>
     * Test case number:113 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test113() throws Exception {
        String signature = "protected static interface InterfaceForTest{";
        checkSignatureWithBraces("Package_113.InterfaceForTest", signature, "Test 113 faild.");
    }

    /**
     * <p>
     * Test case number:114 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test114() throws Exception {
        String signature = "static interface InterfaceForTest{";
        checkSignatureWithBraces("Package_114.InterfaceForTest", signature, "Test 114 faild.");
    }

    /**
     * <p>
     * Test case number:115 REQ:2.95.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test115() throws Exception {
        String signature = "private static interface InterfaceForTest{";
        checkSignatureWithBraces("Package_115.InterfaceForTest", signature, "Test 115 faild.");
    }

    /**
     * <p>
     * Test case number:116 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Public and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test116() throws Exception {
        String signature = "public int MethodForTest();";
        checkSignatureWithBraces("Package_116.InterfaceForTest", signature, "Test 116 faild.");
    }

    /**
     * <p>
     * Test case number:117 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Protected and without Modifiers option.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test117() throws Exception {
        String signature = "protected int MethodForTest();";
        checkSignatureWithBraces("Package_117.InterfaceForTest", signature, "Test 117 faild.");
    }

    /**
     * <p>
     * Test case number:118 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Protected and without Modifiers option.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test118() throws Exception {
        String signature = "int MethodForTest();";
        checkSignatureWithBraces("Package_118.InterfaceForTest", signature, "Test 118 faild.");
    }

    /**
     * <p>
     * Test case number:120 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Public and with Modifiers as Abstract.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test120() throws Exception {
        String signature = "public abstract int MethodForTest();";
        checkSignatureWithBraces("Package_120.InterfaceForTest", signature, "Test 120 faild.");
    }

    /**
     * <p>
     * Test case number:121 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Public and with Modifiers as Abstract.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test121() throws Exception {
        String signature = "protected abstract int MethodForTest();";
        checkSignatureWithBraces("Package_121.InterfaceForTest", signature, "Test 121 faild.");
    }

    /**
     * <p>
     * Test case number:122 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Package and with Modifiers as Abstract.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test122() throws Exception {
        String signature = "abstract int MethodForTest();";
        checkSignatureWithBraces("Package_122.InterfaceForTest", signature, "Test 122 faild.");
    }

    /**
     * <p>
     * Test case number:123 REQ:2.95.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Private and with Modifiers as Abstract.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void test123() throws Exception {
        String signature = "private abstract int MethodForTest();";
        checkSignatureWithBraces("Package_123.InterfaceForTest", signature, "Test 123 faild.");
    }

    /**
     * <p>
     * Test case number:124 REQ:2.95.1.3 Description: Verify that if a name with space is input as class name,
     * whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test124() throws Exception {
        testNScenario("c124");
    }

    /**
     * <p>
     * Test case number:125 REQ:2.95.1.3 Description: Verify that if a name with space is input as attribute
     * name, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test125() throws Exception {
        testNScenario("c125");
    }

    /**
     * <p>
     * Test case number:126 REQ:2.95.1.3 Description: Verify that if a name with space is input as method
     * name, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test126() throws Exception {
        testNScenario("c126");
    }

    /**
     * <p>
     * Test case number:127 REQ:2.95.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as class name, whether there is any
     * error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test127() throws Exception {
        testNScenario("c127");
    }

    /**
     * <p>
     * Test case number:128 REQ:2.95.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as attribute name, whether there is
     * any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test128() throws Exception {
        testNScenario("c128");
    }

    /**
     * <p>
     * Test case number:129 REQ:2.95.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as method name, whether there is any
     * error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test129() throws Exception {
        testNScenario("c129");
    }

    /**
     * <p>
     * Test case number:130 REQ:2.95.1.3 Description: Verify that if a class name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test130() throws Exception {
        testNScenario("c130");
    }

    /**
     * <p>
     * Test case number:131 REQ:2.95.1.3 Description: Verify that if a method name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test131() throws Exception {
        testNScenario("c131");
    }

    /**
     * <p>
     * Test case number:132 REQ:2.95.1.3 Description: Verify that if a attribute name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test132() throws Exception {
        testNScenario("c132");
    }

    /**
     * <p>
     * Test case number:133 REQ:2.95.1.3 Description: Verify that we cannot add subclass for a final class.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test133() throws Exception {
        testNScenario("c133");
    }

    /**
     * <p>
     * Test case number:134 REQ:2.95.1.3 Description: Verify that we cannot add 'realization' between two
     * classes.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test134() throws Exception {
        testNScenario("c134");
    }

    /**
     * <p>
     * Test case number:131(The second one) Description: Verify the output from the C# generation of the
     * Mdx_Slicer_NET_1.0.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test131i() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/c/131");
        File template = new File(TestHelper.getTemplateBase() + "/c/131");
        String msg = TestHelper.folderCheck(srcToCheck, template);
        assertNull(msg, msg);
    }

    /**
     * <p>
     * Test case number:134(The second one) Description: Verify the output from the C# generation of the
     * WindowSizeManager.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test134i() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/c/134");
        File template = new File(TestHelper.getTemplateBase() + "/c/134");
        String msg = TestHelper.folderCheck(srcToCheck, template);
        assertNull(msg, msg);
    }

    /**
     * <p>
     * Wrapper method for running a test scenario.
     * </p>
     *
     * @param name scenario name
     * @throws Exception if any error occurs
     */
    private void testNScenario(String name) throws Exception {
        // setup swingunit robot/scenario only when need. This would be fast.
        if (robot == null) {
            robot = new Robot();
        }
        if (scenario == null) {
            scenario = new Scenario(new ExtendedRobotEventFactory(), new FinderMethodSet());
            scenario.read(TestHelper.getScriptBase() + "/CTest.xml");
            player = new EventPlayer(scenario);
        }
        player.run(robot, name);
    }
}
