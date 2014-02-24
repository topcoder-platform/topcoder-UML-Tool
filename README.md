topcoder UML Tool
=================

We're proud to introduce the TopCoder UML Tool: An easy to use, consistent modeling tool for use in Design and Development competitions. The new tool was designed and developed entirely by the TopCoder Community to model sequence, class, use case, and activity diagrams. On top of that, all those elements can have documentation easily attached to them. 

Install the UML tool on Linux and Windows
=============================================
Make sure the machine you are installing on has the proper version of Java (1.7).

Execute installer jar. The OS may support doing this in the GUI, or you can use the command line:

java -jar TopCoder_UML_Tool_Installer-1.2.6.jar

Follow instructions on installer screen.

If you have any questions or you would just like to discuss the UML Tool, go to the forums.
	Installer issue
Some operating systems supposedly don't support creating shortcuts (icons) according to izPack documentation.

Install the UML tool on Mac OS X
==================================
Drag the application from the disk image to your "Applications" folder. When the application is first run, the file associations for XMI, TCUML, and ZUML will be added.

Uninstall the UML tool
========================
An icon should be created for the uninstaller (if you selected to install icons, and if the izPack installer supports icons for your OS).

If there is no icon, or for some reason you wish to uninstall manually, go to wherever you installed the app and run the Uninstaller\uninstaller.jar file. This can be done in the GUI if your OS supports it, or else run java -jar uninstaller.jar from the Uninstaller directory.

Build
========================
The build.xml is a development contest like build file. To use it you need at least
Ant 1.6.5 installed and ready to run.

The available targets used in this assembly are:

  + ant compile
    Compiles all classes from this assembly
    
  + ant run
    Run the UML Tool to use.


Configuration File
========================
Valid configuration files are kept under the config directory and the configmanager.properties file is given such that
the config files are loaded while instantiating.
