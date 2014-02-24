/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;


/**
 * <p>
 * This class is responsible for working with directories and files. It provides
 * the creation of necessary directories which structure reflect Java packages
 * and C# name-spaces. It also provides the functionality of writing *.java and
 * *.cs files. The names of the written files are created according to their
 * classifiers.
 * </p>
 * <p>
 * <b>Thread safety:</b> This class is immutable and therefore thread safe.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class CodeWriter {
    /**
     * <p>
     * Creates a new {@link CodeWriter} instance.
     * </p>
     */
    public CodeWriter() {
        // nothing to do here
    }

    /**
     * <p>
     * Checks if the given location exists and is a directory.
     * </p>
     *
     * @param location
     *            path to directory to be checked
     * @return <code>true</code> if directory exist otherwise
     *         <code>false</code>
     * @throws IllegalArgumentException
     *             if location is <code>null</code> or empty
     */
    public boolean existDirectory(String location) {
        this.checkStringNotNullNotEmpty("Location", location);

        return new File(location).isDirectory();
    }

    /**
     * <p>
     * Creates a directory structure according to the given packageName in the
     * given location. The given packageName represents the name of a package in
     * a format like &quot;com.topcoder.test&quot;.
     * </p>
     *
     * @param location
     *            the location where to create the directory structure
     * @param packageName
     *            path to be created in the format described above, may be empty
     * @return <code>true</code> if directory structure exists when this
     *         method is left, otherwise <code>false</code>
     * @throws IllegalArgumentException
     *             if location is <code>null</code> or empty
     * @throws IllegalArgumentException
     *             if packageName is <code>null</code>
     */
    public boolean createDirectory(String location, String packageName) {
        if (packageName == null) {
            throw new IllegalArgumentException("Package name must not be null");
        }

        if (!this.existDirectory(location)) {
            return false;
        }

        String packagePath = this.packageToPath(packageName);

        if (packagePath == null) {
            return false;
        }

        File f = new File(location, packagePath);
        f.mkdirs();

        return f.isDirectory();
    }

    /**
     * <p>
     * Deletes everything which is contained in the location directory. If the
     * parameter deleteCurrent is <code>true</code> then the location
     * directory itself is also deleted.
     * </p>
     *
     * @param location
     *            location of directory
     * @param deleteCurrent
     *            if <code>true</code> the location directory itself is also
     *            deleted.
     * @return <code>true</code> if deleted, otherwise <code>false</code>
     * @throws IllegalArgumentException
     *             if location is <code>null</code> or empty
     */
    public boolean deleteDirectory(String location, boolean deleteCurrent) {
        this.checkStringNotNullNotEmpty("Location", location);

        File dir = new File(location);

        if (!dir.isDirectory()) {
            return false;
        }

        this.deleteDirectoryRec(new File(location));

        if (deleteCurrent) {
            return dir.delete();
        }

        return dir.list().length == 0;
    }

    /**
     * Deletes all files and sub directories in the given directory recursively. It will
     * delete all children of the given directory. If a child of the directory is a directory
     * itself then the method calls itself on the child directory. After this call returns
     * the child directory is empty and will be deleted too.
     *
     * @param dir
     *            directory
     */
    private void deleteDirectoryRec(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                this.deleteDirectoryRec(file);
            }
            file.delete();
        }
    }

    /**
     * <p>
     * Writes the content to a file with the given location, packageName and
     * fileName. The given packageName represents the name of a package in a
     * format like &quot;com.topcoder.test&quot;.
     * </p>
     *
     * @param location
     *            location of  the file to which to write
     * @param packageName
     *            name of the package where the file should be located, may be
     *            empty
     * @param fileName
     *            name of the file to be created
     * @param content
     *            content of file to be written
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code>
     * @throws IllegalArgumentException
     *             if location, fileName or content are empty
     * @throws IOException
     *             when there is an IO problem when writing the file
     */
    public void writeFile(String location, String packageName, String fileName, String content)
        throws IOException {
        this.checkStringNotNullNotEmpty("Location", location);
        this.checkStringNotNullNotEmpty("File name", fileName);
        this.checkStringNotNullNotEmpty("Content", content);

        if (packageName == null) {
            throw new IllegalArgumentException("Package name must not be null");
        }

        String packagePath = this.packageToPath(packageName);

        if (packagePath == null) {
            throw new IOException("Invalid package name: " + packageName);
        }

        File f = new File(new File(location, packagePath), fileName);

        // UML-562: Code generation: Duplicate classes cause empty output
        if (f.exists()) {
            BufferedReader b = new BufferedReader(new FileReader(f));
            String line = null;
            int size = 0;
            while((line = b.readLine()) != null) {
                size += line.length() + 1;
            }
            if (size > content.length()) {
                return;
            }
        }
        
        PrintWriter p = new PrintWriter(new FileWriter(f));
        p.println(content);
        p.close();
    }

    /**
     * Checks the string for validity.
     *
     * @param name
     *            name of the string
     * @param string
     *            {@link String} to be checked.
     * @throws IllegalArgumentException
     *             if location is <code>null</code> or empty
     */
    private void checkStringNotNullNotEmpty(String name, String string) {
        if (string == null) {
            throw new IllegalArgumentException(name + " must not be null");
        }

        if (string.trim().length() == 0) {
            throw new IllegalArgumentException(name + " must not be empty");
        }
    }

    /**
     * Translates the given package name into a path.
     *
     * @param packageName
     *            package name to be translated
     * @return the given package name as a path or <code>null</code> if the
     *         package is not valid.
     */
    private String packageToPath(String packageName) {
        if (packageName.length() == 0) {
            return packageName;
        }

        StringBuilder builder = new StringBuilder();
        String[] splitted = packageName.split("\\.");
        boolean isFirst = true;

        for (String split : splitted) {
            if (!isFirst) {
                builder.append(File.separatorChar);
            } else {
                isFirst = false;
            }

            if ((split.length() == 0) || !split.equals(split.trim())) {
                // invalid package, just return null
                return null;
            }

            builder.append(split);
        }

        return builder.toString();
    }
}
