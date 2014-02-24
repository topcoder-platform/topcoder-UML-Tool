/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * The Helper class for test.
 *
 * @author tweg
 * @version 1.0
 */
public class TestHelper {

    /**
     * <p>
     * Represents the line separator.
     * </p>
     */
    public static final String LINE_SEP = System.getProperty("line.separator");

    /**
     * <p>
     * Represents the file separator.
     * </p>
     */
    public static final String FILE_SEP = File.pathSeparator;

    /**
     * <p>
     * Represents the suffix of a java class file.
     * </p>
     */
    public static final String JAVA_SUFFIX = ".java";

    /**
     * <p>
     * Represents the suffix of a c# class file.
     * </p>
     */
    public static final String C_SUFFIX = ".cs";

    /**
     * The test config file.
     */
    private static final String TEST_CONFIG_FILE = "TestsConfig.xml";

    /**
     * <p>
     * Represents the source folder name.
     * </p>
     */
    private static final String SRC_FOLDER = "src";

    /**
     * <p>
     * Represents the template base.
     * </p>
     */
    private static final String TEMPLATE_BASE = "Template_base";

    /**
     * <p>
     * Represents the code generation base.
     * </p>
     */
    private static final String CODEGEN_BASE = "CodeGen_base";

    /**
     * <p>
     * Represents the code generation base.
     * </p>
     */
    private static final String UML_FILE_BASE = "UMLFile_base";

    /**
     * <p>
     * Represents the code generation base.
     * </p>
     */
    private static final String SCRIPT_BASE = "Script_base";

    /**
     * <p>
     * Represents the test namespace.
     * </p>
     */
    private static final String TEST_NAMESPACE = "com.topcoder.umltool.deploy.codegen.test";

    /**
     * Static initializer to load the config file.
     */
    static {
        try {
            ConfigManager configManager = ConfigManager.getInstance();
            configManager.add(TEST_CONFIG_FILE);
        } catch (Exception e) {
            // ignore this case
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Get the template base directory.
     * </p>
     *
     * @return the template base directory
     * @throws UnknownNamespaceException
     *             if namespace is not found
     */
    public static String getTemplateBase() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();

        return cm.getProperty(TEST_NAMESPACE, TEMPLATE_BASE).toString();
    }

    /**
     * <p>
     * Get the code generation base directory.
     * </p>
     *
     * @return the code generation base directory
     * @throws UnknownNamespaceException
     */
    public static String getCodeGenBase() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();

        return cm.getProperty(TEST_NAMESPACE, CODEGEN_BASE).toString();
    }

    /**
     * <p>
     * Get the uml file base directory.
     * </p>
     *
     * @return the uml file base directory
     * @throws UnknownNamespaceException
     */
    public static String getUMLBase() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();
        new ArrayList().toArray(new Object[0]);

        return cm.getProperty(TEST_NAMESPACE, UML_FILE_BASE).toString();
    }

    public static String getScriptBase() throws UnknownNamespaceException {
        ConfigManager cm = ConfigManager.getInstance();

        return cm.getProperty(TEST_NAMESPACE, SCRIPT_BASE).toString();
    }

    /**
     * <p>
     * Creates a new instance of <code>TestHelp</code> class. The private constructor prevents the creation of a
     * new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Check the existence of a package directory tree.
     * </p>
     *
     * @param base
     *            the base dir of the namespace
     * @param namespace
     *            the namespace to check
     * @return true if the directories exists. false otherwise.
     */
    static boolean checkPackage(String base, String namespace) {
        String namespacePath = namespace.replace('.', File.separatorChar);
        File disDir = new File(base, namespacePath);
        if (disDir.exists() && disDir.isDirectory())
            return true;
        return false;
    }

    /**
     * <p>
     * Check whether the class source code contains the context.
     * </p>
     *
     * @param codeBase
     *            the base directory of the code
     * @param classFName
     *            the full name of the class
     * @param fileSuffix
     *            the file suffix of the source file
     * @param context
     *            the context to be find.
     * @return -1 if not found. otherwise index of the position.
     */
    static int checkCodeContains(String codeBase, String classFName, String fileSuffix, String context, int index) {
        File codeDir = new File(codeBase + File.separator + SRC_FOLDER);
        String classPath = classFName.replace('.', File.separatorChar) + fileSuffix;
        File srcFile = new File(codeDir, classPath);
        if (!srcFile.isFile()) {
            return -1;
        }
        String srcContext = readFileContext(srcFile);
        if (srcContext == null) {
            return -1;
        } else {
            return srcContext.indexOf(context, index);
        }
    }

    /**
     * <p>
     * Read the context of a file.
     * </p>
     *
     * @param fileToRead
     *            the file to read
     * @return the context of the file
     */
    private static String readFileContext(File fileToRead) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileToRead));
            StringBuffer sb = new StringBuffer();
            String aline = bf.readLine();
            while (aline != null) {
                sb.append(aline);
                sb.append(LINE_SEP);
                aline = bf.readLine();
            }
            bf.close();
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * <p>
     * Recursive check the folder to a template folder. The directory paths and file contexts in the all the sub
     * folder are checked.
     * </p>
     *
     * @param srcToCheck
     *            the folder to check
     * @param template
     *            the folder to check with.
     * @return null if success, the first file/directory name which is not the same.
     */
    static String folderCheck(File srcToCheck, File template) {
        // check file or directory exists
        if (!srcToCheck.exists() || !template.exists()) {
            return srcToCheck.getName();
        }
        // check when is file.
        if (template.isFile()) {
            if (!srcToCheck.isFile()) {
                return srcToCheck.getName();
            } else {
                if (!srcToCheck.getName().equalsIgnoreCase(template.getName())) {
                    return srcToCheck.getName();
                }
            }
        } else if (template.isDirectory()) {
            // check is directory
            if (!srcToCheck.isDirectory()) {
                return srcToCheck.getName();
            }
            // name equal
            if (!srcToCheck.getName().equalsIgnoreCase(template.getName())) {
                return srcToCheck.getName();
            }
            File[] tChildren = template.listFiles();
            for (int i = 0; i < tChildren.length; i++) {
                File child = new File(srcToCheck, tChildren[i].getName());
                if (child.exists()) {
                    // check the folder recursively
                    String msg = folderCheck(child, tChildren[i]);
                    if (msg != null) {
                        return msg;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /**
     * <p>
     * Compare the context of two files.
     * </p>
     *
     * @param target
     *            the file to check
     * @param template
     *            the file which is use as template
     * @return true if the context is same, flase otherwise
     */
    static boolean compareFileContext(File target, File template) {
        String targetContext = readFileContext(target);
        String templateContext = readFileContext(template);
        if (targetContext == null || template == null) {
            return false;
        }
        return targetContext.equalsIgnoreCase(templateContext);
    }
}
