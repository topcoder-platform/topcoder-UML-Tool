/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.awt.Robot;
import java.io.File;

import junit.framework.TestCase;
import swingunit.extensions.ExtendedRobotEventFactory;
import swingunit.framework.EventPlayer;
import swingunit.framework.FinderMethodSet;
import swingunit.framework.Scenario;

/**
 * Test Cases of Code Generation for Java.
 *
 * @author tweg
 * @version 1.0
 */
public class JavaTests extends TestCase {

    /** The scenario script used for testing. */
    private Scenario scenario;

    /** The scenario robot used for testing. */
    private Robot robot;

    /** The event player used for testing. */
    private EventPlayer player;

    /**
     * <p>
     * Test case number:1 REQ:2.96.1.3 Description: Verify that package is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test1() throws Exception {
        int index = wrapJavaCodeContain("com.topcoder.vault.facade.Test1",
            "package com.topcoder.vault.facade;");
        assertTrue("Test 1 failed." + "With class name:com.topcoder.vault.facade.Test1", index != -1);
        index = wrapJavaCodeContain("com.topcoder.vault.facade.VaultManager",
            "package com.topcoder.vault.facade;");
        assertTrue("Test 1 failed." + "With class name:package com.topcoder.vault.facade;", index != -1);
    }

    /**
     * <p>
     * Test case number:2 REQ:2.96.1.3 Description: Verify that the class document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test2() throws Exception {
        String content = "/**";
        int index = wrapJavaCodeContain("Package_2.VaultManager", content);
        assertTrue("Test 2 failed.With content:" + content, index != -1);

        content = "vault manager documentation";
        int index1 = wrapJavaCodeContain("Package_2.VaultManager", content);
        assertTrue("Test 2 failed.With content:" + content, index1 > index);
        content = "*/";
        int index2 = wrapJavaCodeContain("Package_2.VaultManager", content);
        assertTrue("Test 2 failed.With content:" + content, index2 > index1);
    }

    /**
     * <p>
     * Test case number:3 REQ:2.96.1.3 Description: Verify that class level tags are generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test3() throws Exception {
        // check @@ not presented
        String content = "@@";
        int index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@@ presented", index == -1);

        // check @author
        content = "@author";
        index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@author missing", index != -1);

        // check @version
        content = "@version";
        index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@version missing", index != -1);

        // check @see
        content = "@see";
        index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@see missing", index != -1);

        // check @since
        content = "@since";
        index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@since missing", index != -1);

        // check @deprecated
        content = "@deprecated";
        index = wrapJavaCodeContain("Package_3.VaultManager", content);
        assertTrue("Test 3 failed.@deprecated missing", index != -1);
    }

    /**
     * <p>
     * Test case number:4 REQ:2.96.1.3 Description: Verify that a public final class is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test4() throws Exception {
        String signature = "public final class VaultManager {";
        checkSignatureWithBraces("Package_4.VaultManager", signature, "Test 4 failed.");
    }

    /**
     * <p>
     * Test case number:5 REQ:2.96.1.3 Description: Verify that a package private class is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test5() throws Exception {
        String signature = "class VaultManager {";
        checkSignatureWithBraces("Package_5.VaultManager", signature, "Test 5 failed.");
    }

    /**
     * <p>
     * Test case number:6 REQ:2.96.1.3 Description: Verify that an abstract class is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test6() throws Exception {
        String signature = "public abstract class VaultManager {";
        checkSignatureWithBraces("Package_6.VaultManager", signature, "Test 6 failed.");
    }

    /**
     * <p>
     * Test case number:7 REQ:2.96.1.3 Description: Verify that an interface is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test7() throws Exception {
        String signature = "public interface EntityChangeListener {";
        checkSignatureWithBraces("Package_7.EntityChangeListener", signature, "Test 7 failed.");
    }

    /**
     * <p>
     * Test case number:8 REQ:2.96.1.3 Description: Verify that an enumeration is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test8() throws Exception {
        String signature = "enum EntitychangeEventType {";
        checkSignatureWithBraces("Package_8.EntitychangeEventType", signature, "Test 8 failed.");
    }

    /**
     * <p>
     * Test case number:9 REQ:2.96.1.3 Description: Verify that a class that extends another class is
     * generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test9() throws Exception {
        String signature = "public class EntityChangeListener extends Listener {";
        checkSignatureWithBraces("Package_9.EntityChangeListener", signature, "Test 9 failed.");
    }

    /**
     * <p>
     * Test case number:10 REQ:2.96.1.3 Description: Verify that a class that implements an interface is
     * generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test10() throws Exception {
        String signature = "public class EntityChangeListener implements Listener {";
        checkSignatureWithBraces("Package_10.EntityChangeListener", signature, "Test 10 failed.");
    }

    /**
     * <p>
     * Test case number:11 REQ:2.96.1.3 Description: Verify that an interface extends another interface is
     * generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test11() throws Exception {
        String signature = "interface IEntityChangeListener extends Ilistener {";
        checkSignatureWithBraces("Package_11.IEntityChangeListener", signature, "Test 11 failed.");
    }

    /**
     * <p>
     * Test case number:12 REQ:2.96.1.3 Description: Verify that attribute document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test12() throws Exception {
        String signature = "    /**" + TestHelper.LINE_SEP + "     * This is the comments" + TestHelper.LINE_SEP + "     */"
            + TestHelper.LINE_SEP + "    public String AttributeWithDocument;" + TestHelper.LINE_SEP;
        checkSignature("Package_12.Class_12", signature, "Test 12 failed.");
    }

    /**
     * <p>
     * Test case number:13 REQ:2.96.1.3 Description: Verify that a private attribute is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test13() throws Exception {
        String signature = "private String AttributeWithPrivacy;";
        checkSignature("Package_13.Class_13", signature, "Test 13 failed.");
    }

    /**
     * <p>
     * Test case number:14 REQ:2.96.1.3 Description: Verify that a private final attribute is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test14() throws Exception {
        String signature = "private final String AttributeWithPrivacy;";
        checkSignature("Package_14.Class_14", signature, "Test 14 failed.");
    }

    /**
     * <p>
     * Test case number:15 REQ:2.96.1.3 Description: Verify that a package private static final attribute is
     * generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test15() throws Exception {
        String signature = "static final String AttributeWithPrivacy;";
        checkSignature("Package_15.Class_15", signature, "Test 15 failed.");
    }

    /**
     * <p>
     * Test case number:16 REQ:2.96.1.3 Description: Verify that a default attribute value is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test16() throws Exception {
        String signature = "public String AttributeWithDefaultValue = \"This is default\";";
        checkSignature("Package_16.Class_16", signature, "Test 16 failed.");
    }

    /**
     * <p>
     * Test case number:17 REQ:2.96.1.3 Description: Verify that method document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test17() throws Exception {
        String signature = "    /**" + TestHelper.LINE_SEP + "     * This is method document" + TestHelper.LINE_SEP;
        checkSignature("Package_17.Class_17", signature, "Test 17 failed.");
        signature = "     */" + TestHelper.LINE_SEP + "    public void MethodWithDocument() {";
        checkSignatureWithBraces("Package_17.Class_17", signature, "Test 17 failed.");
    }

    /**
     * <p>
     * Test case number:18 REQ:2.96.1.3 Verify that method document is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test18() throws Exception {
        String signature = "MethodWithDocument()";
        int index = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index != -1);

        // check @@ not presented
        signature = "@@";
        int index1 = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index1 == -1);

        // check @param
        signature = "@param";
        index1 = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index1 != -1 && index1 < index);
        // check @deprecated
        signature = "@deprecated";
        index1 = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index1 != -1 && index1 < index);
        // check @since
        signature = "@since";
        index1 = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index1 != -1 && index1 < index);
        // check @return
        signature = "@throws";
        index1 = wrapJavaCodeContain("Package_18.Class_18", signature);
        assertTrue("Test 18 failed with signature:" + signature, index1 != -1 && index1 < index);
    }

    /**
     * <p>
     * Test case number:21 REQ:2.96.1.3 Description: Verify that a constructor is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test19() throws Exception {
        String signature = "public class EnityClass {";
        checkSignatureWithBraces("Package_19.EnityClass", signature, "Test 19 failed.");
        signature = "private EnityClass() {";
        checkSignatureWithBraces("Package_19.EnityClass", signature, "Test 19 failed.");
    }

    /**
     * <p>
     * Test case number:20 REQ:2.96.1.3 Description: Verify that a method signature is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test20() throws Exception {
        String signature = "String MethodWithSignature(int param1, int param2)";
        checkSignature("Package_20.EnityClass", signature, "Test 20 failed.");
    }

    /**
     * <p>
     * Test case number:21 REQ:2.96.1.3 Description: Verify that a static method signature is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test21() throws Exception {
        String signature = "static String MethodWithSignature(int param1, int param2)";
        checkSignature("Package_21.EnityClass", signature, "Test 21 failed.");
    }

    /**
     * <p>
     * Test case number:22 REQ:2.96.1.3 Description: Verify that a synchronized method signature is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test22() throws Exception {
        String signature = "synchronized String MethodWithSignature(int param1, int param2)";
        checkSignature("Package_22.EnityClass", signature, "Test 22 failed.");
    }

    /**
     * <p>
     * Test case number:23 REQ:2.96.1.3 Description: Verify that an abstract method signature is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test23() throws Exception {
        String signature = "abstract void MethodWithSignature();";
        checkSignature("Package_23.EnityClass", signature, "Test 23 failed.");
    }

    /**
     * <p>
     * Test case number:24 REQ:2.96.1.3 Description: Verify that a final method signature is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test24() throws Exception {
        String signature = "final void MethodWithSignature";
        checkSignature("Package_24.EnityClass", signature, "Test 24 failed.");
    }

    /**
     * <p>
     * Test case number:25 REQ:2.96.1.3 Description: Verify that a method with parameters is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test25() throws Exception {
        String signature = "public void MethodWithSignature(int param)";
        checkSignature("Package_25.EnityClass", signature, "Test 25 failed.");
    }

    /**
     * <p>
     * Test case number:26 REQ:2.96.1.3 Description: Verify that the type of an attribute is imported.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test26() throws Exception {
        String signature = "import java.sql.SQLException;";
        checkSignature("Package_26.Class_26", signature, "Test 26 failed.");
    }

    /**
     * <p>
     * Test case number:27 REQ:2.96.1.3 Description: Verify that the type of a parameter is imported.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test27() throws Exception {
        String signature = "import java.sql.SQLException;";
        checkSignature("Package_27.Class_27", signature, "Test 27 failed.");
    }

    /**
     * <p>
     * Test case number:28 REQ:2.96.1.3 Description: Verify that the type of a return value is imported.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test28() throws Exception {
        String signature = "import java.sql.SQLException;";
        checkSignature("Package_28.Class_28", signature, "Test 28 failed.");
    }

    /**
     * <p>
     * Test case number:29 REQ:2.96.1.3 Description: Verify that the exception is generated correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test29() throws Exception {
        String signature = "public class ExceptionForTest {";
        checkSignatureWithBraces("Package_29.ExceptionForTest", signature, "Test 29 failed.");

        signature = "public ExceptionForTest(String message)";
        checkSignature("Package_29.ExceptionForTest", signature, "Test 29 failed.");

        signature = "public ExceptionForTest(String message, Throwable cause)";
        checkSignature("Package_29.ExceptionForTest", signature, "Test 29 failed.");
    }

    /**
     * <p>
     * Test case number:31 REQ:2.96.1.3 Description: Verify that the method of interface is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test31() throws Exception {
        String signature = "public void InterfaceMethod();";
        checkSignature("Package_31.EnityInterface", signature, "Test 31 failed.");
    }

    /**
     * <p>
     * Test case number:32 REQ:2.96.1.3 Description: Verify that the enumeration attribute is generated
     * correctly.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test32() throws Exception {
        String signature = "enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};";
        checkSignature("Package_32.Day", signature, "Test 32 failed.");
    }

    /**
     * <p>
     * Test case number:34 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * public option is tagged as the visibility choice without Modifiers option like abstract, final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test34() throws Exception {
        String signature = "public class EnityClass {";
        checkSignatureWithBraces("Package_34.EnityClass", signature, "Test 34 failed.");
    }

    /**
     * <p>
     * Test case number:35 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Protected option is tagged as the visibility choice without Modifiers option like abstract, final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test35() throws Exception {
        String signature = "protected class EnityClass {";
        checkSignatureWithBraces("Package_35.EnityClass", signature, "Test 34 failed.");
    }

    /**
     * <p>
     * Test case number:36 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice without Modifiers option like abstract, final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test36() throws Exception {
        String signature = "class EnityClass {";
        checkSignatureWithBraces("Package_36.EnityClass", signature, "Test 36 failed.");
    }

    /**
     * <p>
     * Test case number:37 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice without Modifiers option like abstract, final and
     * static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test37() throws Exception {
        String signature = "private class EnityClass {";
        checkSignatureWithBraces("Package_37.EnityClass", signature, "Test 37 failed.");
    }

    /**
     * <p>
     * Test case number:38 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test38() throws Exception {
        String signature = "public abstract class EnityClass {";
        checkSignatureWithBraces("Package_38.EnityClass", signature, "Test 38 failed.");
    }

    /**
     * <p>
     * Test case number:39 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Public option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test39() throws Exception {
        String signature = "public final class EnityClass {";
        checkSignatureWithBraces("Package_39.EnityClass", signature, "Test 39 failed.");
    }

    /**
     * <p>
     * Test case number:46 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test46() throws Exception {
        String signature = "abstract class EnityClass {";
        checkSignatureWithBraces("Package_46.EnityClass", signature, "Test 46 failed.");
    }

    /**
     * <p>
     * Test case number:47 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Package option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test47() throws Exception {
        String signature = "final class EnityClass {";
        checkSignatureWithBraces("Package_47.EnityClass", signature, "Test 47 failed.");
    }

    /**
     * <p>
     * Test case number:48 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice with Modifiers option is Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test48() throws Exception {
        String signature = "private abstract class EnityClass {";
        checkSignatureWithBraces("Package_48.EnityClass", signature, "Test 48 failed.");
    }

    /**
     * <p>
     * Test case number:49 REQ:2.96.1.3 Description: For class signature, verify the generated code when
     * Private option is tagged as the visibility choice with Modifiers option is Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test49() throws Exception {
        String signature = "private final class EnityClass {";
        checkSignatureWithBraces("Package_49.EnityClass", signature, "Test 49 failed.");
    }

    /**
     * <p>
     * Test case number:50 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice and Changeable as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test50() throws Exception {
        String signature = "public int AttributeForTest;";
        checkSignature("Package_50.EnityClass", signature, "Test 50 failed.");
    }

    /**
     * <p>
     * Test case number:51 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice and Frozen as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test51() throws Exception {
        String signature = "public final int AttributeForTest;";
        checkSignature("Package_51.EnityClass", signature, "Test 51 failed.");
    }

    /**
     * <p>
     * Test case number:52 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice and Changeable as Changeability choice without Modifiers
     * options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test52() throws Exception {
        String signature = "protected int AttributeForTest;";
        checkSignature("Package_52.EnityClass", signature, "Test 52 failed.");
    }

    /**
     * <p>
     * Test case number:53 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice and Frozen as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test53() throws Exception {
        String signature = "protected final int AttributeForTest;";
        checkSignature("Package_53.EnityClass", signature, "Test 53 failed.");
    }

    /**
     * <p>
     * Test case number:54 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice and Changeable as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test54() throws Exception {
        String signature = "int AttributeForTest;";
        checkSignature("Package_54.EnityClass", signature, "Test 54 failed.");
    }

    /**
     * <p>
     * Test case number:55 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice and Frozen as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test55() throws Exception {
        String signature = "final int AttributeForTest;";
        checkSignature("Package_55.EnityClass", signature, "Test 55 failed.");
    }

    /**
     * <p>
     * Test case number:56 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice and Changeable as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test56() throws Exception {
        String signature = "private int AttributeForTest;";
        checkSignature("Package_56.EnityClass", signature, "Test 56 failed.");
    }

    /**
     * <p>
     * Test case number:57 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice and Frozen as Changeability choice without Modifiers options.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test57() throws Exception {
        String signature = "private final int AttributeForTest;";
        checkSignature("Package_57.EnityClass", signature, "Test 57 failed.");
    }

    /**
     * <p>
     * Test case number:58 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test58() throws Exception {
        String signature = "public static int AttributeForTest;";
        checkSignature("Package_58.EnityClass", signature, "Test 58 failed.");
    }

    /**
     * <p>
     * Test case number:59 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test59() throws Exception {
        String signature = "public int AttributeForTest;";
        checkSignature("Package_59.EnityClass", signature, "Test 59 failed.");
    }

    /**
     * <p>
     * Test case number:60 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Frozen as Changeability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test60() throws Exception {
        String signature = "public static final int AttributeForTest;";
        checkSignature("Package_60.EnityClass", signature, "Test 60 failed.");
    }

    /**
     * <p>
     * Test case number:61 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Public as the visibility choice, Frozen as Changeability choice and Modifiers option as Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test61() throws Exception {
        String signature = "public final int AttributeForTest;";
        checkSignature("Package_61.EnityClass", signature, "Test 61 failed.");
    }

    /**
     * <p>
     * Test case number:62 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test62() throws Exception {
        String signature = "protected static int AttributeForTest;";
        checkSignature("Package_62.EnityClass", signature, "Test 62 failed.");
    }

    /**
     * <p>
     * Test case number:63 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test63() throws Exception {
        String signature = "protected int AttributeForTest;";
        checkSignature("Package_63.EnityClass", signature, "Test 63 failed.");
    }

    /**
     * <p>
     * Test case number:64 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Frozen as Changeability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test64() throws Exception {
        String signature = "protected static final int AttributeForTest;";
        checkSignature("Package_64.EnityClass", signature, "Test 64 failed.");
    }

    /**
     * <p>
     * Test case number:65 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Protected as the visibility choice, Frozen as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test65() throws Exception {
        String signature = "protected final int AttributeForTest;";
        checkSignature("Package_65.EnityClass", signature, "Test 65 failed.");
    }

    /**
     * <p>
     * Test case number:66 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test66() throws Exception {
        String signature = "static int AttributeForTest;";
        checkSignature("Package_66.EnityClass", signature, "Test 66 failed.");
    }

    /**
     * <p>
     * Test case number:67 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test67() throws Exception {
        String signature = "int AttributeForTest;";
        checkSignature("Package_67.EnityClass", signature, "Test 67 failed.");
    }

    /**
     * <p>
     * Test case number:68 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Frozen as Changeability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test68() throws Exception {
        String signature = "static final int AttributeForTest;";
        checkSignature("Package_68.EnityClass", signature, "Test 68 failed.");
    }

    /**
     * <p>
     * Test case number:69 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Package as the visibility choice, Frozen as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test69() throws Exception {
        String signature = "final int AttributeForTest;";
        checkSignature("Package_69.EnityClass", signature, "Test 69 failed.");
    }

    /**
     * <p>
     * Test case number:70 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test70() throws Exception {
        String signature = "private static int AttributeForTest;";
        checkSignature("Package_70.EnityClass", signature, "Test 70 failed.");
    }

    /**
     * <p>
     * Test case number:71 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Changeable as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test71() throws Exception {
        String signature = "private int AttributeForTest;";
        checkSignature("Package_71.EnityClass", signature, "Test 71 failed.");
    }

    /**
     * <p>
     * Test case number:72 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Frozen as Changeability choice and Modifiers option as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test72() throws Exception {
        String signature = "private static final int AttributeForTest;";
        checkSignature("Package_72.EnityClass", signature, "Test 72 failed.");
    }

    /**
     * <p>
     * Test case number:73 REQ:2.96.1.3 Description: For class attribute signature, verify the generated code
     * when Private as the visibility choice, Frozen as Changeability choice and Modifiers option as
     * Transient.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test73() throws Exception {
        String signature = "private final int AttributeForTest;";
        checkSignature("Package_73.EnityClass", signature, "Test 73 failed.");
    }

    /**
     * <p>
     * Test case number:74 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test74() throws Exception {
        String signature = "public int MethodForTest() {";
        checkSignatureWithBraces("Package_74.EnityClass", signature, "Test 74 failed.");
    }

    /**
     * <p>
     * Test case number:75 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test75() throws Exception {
        String signature = "protected int MethodForTest() {";
        checkSignatureWithBraces("Package_75.EnityClass", signature, "Test 75 failed.");
    }

    /**
     * <p>
     * Test case number:76 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test76() throws Exception {
        String signature = "int MethodForTest() {";
        checkSignatureWithBraces("Package_76.EnityClass", signature, "Test 76 failed.");
    }

    /**
     * <p>
     * Test case number:77 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test77() throws Exception {
        String signature = "private int MethodForTest() {";
        checkSignatureWithBraces("Package_77.EnityClass", signature, "Test 77 failed.");
    }

    /**
     * <p>
     * Test case number:78 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test78() throws Exception {
        String signature = "public abstract int MethodForTest();";
        checkSignatureWithBraces("Package_78.EnityClass", signature, "Test 78 failed.");
    }

    /**
     * <p>
     * Test case number:79 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test79() throws Exception {
        String signature = "protected abstract int MethodForTest();";
        checkSignatureWithBraces("Package_79.EnityClass", signature, "Test 79 failed.");
    }

    /**
     * <p>
     * Test case number:80 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test80() throws Exception {
        String signature = "abstract int MethodForTest();";
        checkSignatureWithBraces("Package_80.EnityClass", signature, "Test 80 failed.");
    }

    /**
     * <p>
     * Test case number:81 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test81() throws Exception {
        String signature = "private abstract int MethodForTest();";
        checkSignatureWithBraces("Package_81.EnityClass", signature, "Test 81 failed.");
    }

    /**
     * <p>
     * Test case number:82 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test82() throws Exception {
        String signature = "public final int MethodForTest() {";
        checkSignatureWithBraces("Package_82.EnityClass", signature, "Test 82 failed.");
    }

    /**
     * <p>
     * Test case number:83 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test83() throws Exception {
        String signature = "protected final int MethodForTest() {";
        checkSignatureWithBraces("Package_83.EnityClass", signature, "Test 83 failed.");
    }

    /**
     * <p>
     * Test case number:84 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test84() throws Exception {
        String signature = "final int MethodForTest() {";
        checkSignatureWithBraces("Package_84.EnityClass", signature, "Test 84 failed.");
    }

    /**
     * <p>
     * Test case number:85 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test85() throws Exception {
        String signature = "private final int MethodForTest() {";
        checkSignatureWithBraces("Package_85.EnityClass", signature, "Test 85 failed.");
    }

    /**
     * <p>
     * Test case number:86 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test86() throws Exception {
        String signature = "public static int MethodForTest() {";
        checkSignatureWithBraces("Package_86.EnityClass", signature, "Test 86 failed.");
    }

    /**
     * <p>
     * Test case number:87 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test87() throws Exception {
        String signature = "protected static int MethodForTest() {";
        checkSignatureWithBraces("Package_87.EnityClass", signature, "Test 87 failed.");
    }

    /**
     * <p>
     * Test case number:88 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test88() throws Exception {
        String signature = "static int MethodForTest() {";
        checkSignatureWithBraces("Package_88.EnityClass", signature, "Test 88 failed.");
    }

    /**
     * <p>
     * Test case number:89 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Static.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test89() throws Exception {
        String signature = "private static int MethodForTest() {";
        checkSignatureWithBraces("Package_89.EnityClass", signature, "Test 89 failed.");
    }

    /**
     * <p>
     * Test case number:90 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Public as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test90() throws Exception {
        String signature = "public final static int MethodForTest() {";
        checkSignatureWithBraces("Package_90.EnityClass", signature, "Test 90 failed.");
    }

    /**
     * <p>
     * Test case number:91 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Protected as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test91() throws Exception {
        String signature = "protected final static int MethodForTest() {";
        checkSignatureWithBraces("Package_91.EnityClass", signature, "Test 91 failed.");
    }

    /**
     * <p>
     * Test case number:92 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Package as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test92() throws Exception {
        String signature = "final static int MethodForTest() {";
        checkSignatureWithBraces("Package_92.EnityClass", signature, "Test 92 failed.");
    }

    /**
     * <p>
     * Test case number:93 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when Private as the visibility choice with Modifiers as Static and Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test93() throws Exception {
        String signature = "private final static int MethodForTest() {";
        checkSignatureWithBraces("Package_93.EnityClass", signature, "Test 93 failed.");
    }

    /**
     * <p>
     * Test case number:94 REQ:2.96.1.3 Description: For class method signature, verify the generated code
     * when concurrency is selected.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test94() throws Exception {
        String signature = "public synchronized int MethodForTest() {";
        checkSignatureWithBraces("Package_94.EnityClass", signature, "Test 94 failed.");
    }

    /**
     * <p>
     * Test case number:95 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test95() throws Exception {
        String signature = "public interface InterfaceForTest {";
        checkSignatureWithBraces("Package_95.InterfaceForTest", signature, "Test 95 failed.");
    }

    /**
     * <p>
     * Test case number:96 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test96() throws Exception {
        String signature = "protected interface InterfaceForTest {";
        checkSignatureWithBraces("Package_96.InterfaceForTest", signature, "Test 96 failed.");
    }

    /**
     * <p>
     * Test case number:97 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test97() throws Exception {
        String signature = "interface InterfaceForTest {";
        checkSignatureWithBraces("Package_97.InterfaceForTest", signature, "Test 97 failed.");
    }

    /**
     * <p>
     * Test case number:98 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test98() throws Exception {
        String signature = "private interface InterfaceForTest {";
        checkSignatureWithBraces("Package_98.InterfaceForTest", signature, "Test 98 failed.");
    }

    /**
     * <p>
     * Test case number:99 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test99() throws Exception {
        String signature = "public abstract interface InterfaceForTest {";
        checkSignatureWithBraces("Package_99.InterfaceForTest", signature, "Test 99 failed.");
    }

    /**
     * <p>
     * Test case number:100 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test100() throws Exception {
        String signature = "protected abstract interface InterfaceForTest {";
        checkSignatureWithBraces("Package_100.InterfaceForTest", signature, "Test 100 failed.");
    }

    /**
     * <p>
     * Test case number:101 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test101() throws Exception {
        String signature = "abstract interface InterfaceForTest {";
        checkSignatureWithBraces("Package_101.InterfaceForTest", signature, "Test 101 failed.");
    }

    /**
     * <p>
     * Test case number:102 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test102() throws Exception {
        String signature = "private abstract interface InterfaceForTest {";
        checkSignatureWithBraces("Package_102.InterfaceForTest", signature, "Test 102 failed.");
    }

    /**
     * <p>
     * Test case number:103 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Public and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test103() throws Exception {
        String signature = "public interface InterfaceForTest {";
        checkSignatureWithBraces("Package_103.InterfaceForTest", signature, "Test 103 failed.");
    }

    /**
     * <p>
     * Test case number:104 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Protected and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test104() throws Exception {
        String signature = "protected interface InterfaceForTest {";
        checkSignatureWithBraces("Package_104.InterfaceForTest", signature, "Test 104 failed.");
    }

    /**
     * <p>
     * Test case number:105 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Package and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test105() throws Exception {
        String signature = "interface InterfaceForTest {";
        checkSignatureWithBraces("Package_105.InterfaceForTest", signature, "Test 105 failed.");
    }

    /**
     * <p>
     * Test case number:106 REQ:2.96.1.3 Description: For Interface signature, verify the generated code when
     * visibility as Private and with Modifiers as Final.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test106() throws Exception {
        String signature = "private interface InterfaceForTest {";
        checkSignatureWithBraces("Package_106.InterfaceForTest", signature, "Test 106 failed.");
    }

    /**
     * <p>
     * Test case number:111 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Public and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test111() throws Exception {
        String signature = "public int MethodForTest();";
        checkSignature("Package_111.InterfaceForTest", signature, "Test 111 failed.");
    }

    /**
     * <p>
     * Test case number:112 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Protected and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test112() throws Exception {
        String signature = "protected int MethodForTest();";
        checkSignature("Package_112.InterfaceForTest", signature, "Test 112 failed.");
    }

    /**
     * <p>
     * Test case number:113 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Package and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test113() throws Exception {
        String signature = "int MethodForTest();";
        checkSignature("Package_113.InterfaceForTest", signature, "Test 113 failed.");
    }

    /**
     * <p>
     * Test case number:114 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Private and without Modifiers option.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test114() throws Exception {
        String signature = "private int MethodForTest();";
        checkSignature("Package_114.InterfaceForTest", signature, "Test 114 failed.");
    }

    /**
     * <p>
     * Test case number:115 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Public and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test115() throws Exception {
        String signature = "public abstract int MethodForTest();";
        checkSignature("Package_115.InterfaceForTest", signature, "Test 115 failed.");
    }

    /**
     * <p>
     * Test case number:116 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Protected and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test116() throws Exception {
        String signature = "protected abstract int MethodForTest();";
        checkSignature("Package_116.InterfaceForTest", signature, "Test 116 failed.");
    }

    /**
     * <p>
     * Test case number:117 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Package and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test117() throws Exception {
        String signature = "abstract int MethodForTest();";
        checkSignature("Package_117.InterfaceForTest", signature, "Test 117 failed.");
    }

    /**
     * <p>
     * Test case number:118 REQ:2.96.1.3 Description: For Interface method signature, verify the generated
     * code when visibility as Private and with Modifiers as Abstract.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test118() throws Exception {
        String signature = "private abstract int MethodForTest();";
        checkSignature("Package_118.InterfaceForTest", signature, "Test 118 failed.");
    }

    /**
     * <p>
     * Test case number:119 REQ:2.96.1.3 Description: Verify that if a name with space is input as class name,
     * whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test119() throws Exception {
        testNScenario("java119");
    }

    /**
     * <p>
     * Test case number:120 REQ:2.96.1.3 Description: Verify that if a name with space is input as attribute
     * name, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test120() throws Exception {
        testNScenario("java120");
    }

    /**
     * <p>
     * Test case number:121 REQ:2.96.1.3 Description: Verify that if a name with space is input as method
     * name, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test121() throws Exception {
        testNScenario("java121");
    }

    /**
     * <p>
     * Test case number:122 REQ:2.96.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as class name, whether there is any
     * error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test122() throws Exception {
        testNScenario("java122");
    }

    /**
     * <p>
     * Test case number:123 REQ:2.96.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as attribute name, whether there is
     * any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test123() throws Exception {
        testNScenario("java123");
    }

    /**
     * <p>
     * Test case number:124 REQ:2.96.1.3 Description: Verify that if a name with
     * '~','!','@','#','$','%','^','&','*','(',')','+','=', '-' is input as method name, whether there is any
     * error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test124() throws Exception {
        testNScenario("java124");
    }

    /**
     * <p>
     * Test case number:125 REQ:2.96.1.3 Description: Verify that if a class name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test125() throws Exception {
        testNScenario("java125");
    }

    /**
     * <p>
     * Test case number:126 REQ:2.96.1.3 Description: Verify that if a method name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test126() throws Exception {
        testNScenario("java126");
    }

    /**
     * <p>
     * Test case number:127 REQ:2.96.1.3 Description: Verify that if a attribute name starting with digits is
     * input, whether there is any error message.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test127() throws Exception {
        testNScenario("java127");
    }

    /**
     * <p>
     * Test case number:128 REQ:2.96.1.3 Description: Verify that we cannot add subclass for a final class.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test128() throws Exception {
        testNScenario("java128");
    }

    /**
     * <p>
     * Test case number:129 REQ:2.96.1.3 Description: Verify that we cannot add 'realization' between two
     * classes.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test129() throws Exception {
        testNScenario("java129");
    }

    /**
     * <p>
     * Test case number:130 REQ:2.96.1.3 Description: Verify the output from the Java generation of the
     * GenerationRegistrationFraemworkArchitecture.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test130() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/java/130");
        File template = new File(TestHelper.getTemplateBase() + "/java/130");
        String msg = TestHelper.folderCheck(srcToCheck, template);
        assertNull(msg, msg);
    }

    /**
     * <p>
     * Test case number:132 REQ:2.96.1.3 Description: Verify the output from the Java generation of the
     * PrerequisiteService.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test132() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/java/132");
        File template = new File(TestHelper.getTemplateBase() + "/java/132");
        String msg = TestHelper.folderCheck(srcToCheck, template);
        assertNull(msg, msg);
    }

    /**
     * <p>
     * Test case number:133 REQ:2.96.1.3 Description: Verify the output from the Java generation of the
     * Studio_Contest_Manager.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test133() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/java/133");
        File template = new File(TestHelper.getTemplateBase() + "/java/133");
        String msg = TestHelper.folderCheck(srcToCheck, template);
        assertNull(msg, msg);
    }

    /**
     * <p>
     * Test case number:134 REQ:2.96.1.3 Description: Verify the output from the Java generation of the
     * Studio_Service.tcuml sample file is correct.
     * </P>
     *
     * @throws Exception if any error occurs
     */
    public void test134() throws Exception {
        File srcToCheck = new File(TestHelper.getCodeGenBase() + "/java/134");
        File template = new File(TestHelper.getTemplateBase() + "/java/134");
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
            scenario.read(TestHelper.getScriptBase() + "/JavaTest.xml");
            player = new EventPlayer(scenario);
        }
        player.run(robot, name);
    }

    /**
     * <p>
     * Wrap method for <code>TestHelper.CheckCodeContains</code> using Java Setting.
     * </p>
     *
     * @param className the className to check
     * @param context the context to check
     * @return -1 if not found. otherwise index of the position.
     * @throws Exception if any error occurs
     */
    private static int wrapJavaCodeContain(String className, String context) throws Exception {
        return TestHelper.checkCodeContains(TestHelper.getCodeGenBase() + "/java/mock", className,
            TestHelper.JAVA_SUFFIX, context, 0);
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
        int index = wrapJavaCodeContain(className, signature);
        assertTrue(errorMessage + " with signature:" + signature, index != -1);
        String context = "}";
        int index1 = wrapJavaCodeContain(className, context);
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
        int index = wrapJavaCodeContain(className, signature);
        assertTrue(errorMessage + " with signature:" + signature, index != -1);
    }
}
