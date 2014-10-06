Fixed since 1.2.6:

Fixed an issue with non-ASCII characters in the file paths
Fixed issues with OS X Gatekeeper reporting that the app was corrupt
Updated OS X distribution as a zip file instead of disk image
Updated installation JAR for izpack

Fixed since 1.2.5:

Installation/uninstallation related bugs.

Fixed since 1.2.4:

Documentation is no longer corrupted when using the documentation panel

Error when loading certain documents with error "Error while loading diagrams: Occurred while loading TCUML file, 
cause by SAXException occurs during parsing, caused by the referenced REFID is not known: TC_UML_." has been fixed

When using the recent files menu a "&" in a path could cause the application to not work

Generic arguments are now parsed and generated in code correctly

When copying and pasting elements from sequence diagrams, the text could be pasted in the wrong location.

When generating code, classes or interfaces could be empty in the generated output.

Opening certain ZUML files with older sequence diagrams could cause the file not to load.  The ZUML files will now load, but certain sequence diagrams will not display correctly.

Various code generation items:

* Generating C# indexers
* Generating certain C# documentation
* Generating interface methods
* Generating C# sealed methods and classes
* Generating C# event properties
* Generating Java extension of interface
* Generating abstract methods
* Generating C# interface implementations
* Java indentation now meets TC standards.  Note that C# still does not

Fixed since 1.2.3:

Double clicking and editing a method or package would not work and would cause the text box not to close properly

C# properties generated from the right click menu weren't persisted properly.

Fixed since 1.2.2:

- Fixed a corrupt file issue that could cause files to not be saved or edited correctly
- Integrated new unit tests for code generation and ZUML import.  Assembly will follow shortly to fix issues found
- Updated the GUI to not take up quite as much space -- new files only
- The Create Property shortcut didn't set the correct type for C# projects
- Edge move didn't work for dependencies and existing projects
- Loading opens all diagrams, instead of just the diagrams that were open the last time the file was saved
- Comment connector functionality has changed slightly
- Text in Mac OS X for element names could be truncated -- This is an Apple / JDK bug, a workaround is in place
- UML Tool JAR Importer is integrated but not currently enabled, as more testing is needed.  If you want to try this out,
 download the source from SVN and uncomment lines 190 and 191 in com/topcoder/umltool/deploy/menus/FileMenu.java.  
You will need to set the dependency path in the SettingConfig.xml as well so the dependencies for imported JARs load correctly.  
See the UML Tool JAR Importer component documentation for more details. 
- The font size for the diagram view can now be set separately from the rest of the GUI

In addition, functionality has been added for classes to automatically populate operations when a realization 
relationship is drawn from a class to an interface, or an extends relationship is drawn from a concrete class to 
an abstract class.  This functionality will copy the required operations from the interface or abstract class to 
the extending class, as well as all documentation for those elements in the interface or abstract class.  
This functionality will not overwrite documentation that may already exist in the concrete class. 
This functionality can be turned off in the SettingConfig.xml file, property "AutoGenerateMethods".

Fixed since 1.2.1:
- 2 File corruption / loading errors have been resolved
- Sequence diagrams can appear empty with Java 1.6 and Windows
- Edges can now be moved from one element to another by dragging one end.  Due to some compatibility issues, this will only work with files created in 1.2.2+, for now.  1.2.3 will address this bug for past files
- A context menu has been added for lifelines in SD's so a name or type can be hidden / displayed
- Multiple elements can now be selected in OS X using the command key
- 2 shortcut keys have been added: CTRL / Command A for "Select all", and F2 for "Rename"
- Double-clicking an element for renaming doesn't work if the document tree section is undocked from the side menu

Fixed since 1.2.0:
- Certain mac-specific files are now conditionally built
- In OS X, if you double click a file with a file already loaded, the original file wasn't properly unloaded
- Copy/Cut/Paste now work for attributes and operations
- The menu disappears in certain conditions on Windows XP
- Export all images breaks the tab functionality
- Exporting all sequence diagrams wasn't exporting activations
- Generating C# code sometimes caused an empty "using;" line to be generated
- With the new title functionality, sequence diagram lifelines were overlapping the title slightly
- The layout has been tweaked to be more space-efficient
 
Fixed since 1.1.9:
- Right click doesn't work on classes and interfaces in certain cases
- You can now export all images for a given file using the command line using the flags " -exportImages [path to ZUML or TCUML] [Output directory]"
- Mac OS X compatibility updates have been applied.  This should help with consistencies in program exit, shortcut keys, file associations, etc..  Also notice that a new disk image deployment has been provided for easy drag-and-drop installation, like a normal OS X application.  On OS X, new ant targets are available, as long as XCode 3.0 is installed: build_mac_appbundle, and build_mac_diskimage
- New icons have been applied to the application and .tcuml documents for Mac and Windows platforms  Icons are available for Linux as well in PNG format
- Initial values couldn't be removed without leaving a trailing "="
- Relationships that originate from a package could cause problems in placement
- GUI updates have been applied, including a new look and feel, and new components: Side Menu, Closable Tab, Vertical Label, and Section Layout
- You can now rename diagrams through a right-click menu in the document tree, directly on a diagram, or through the properties panel
- Backend code is now part of the SVN build
- Configuration is now editable through a window (Edit->Settings)

Fixed since 1.1.8:
- Added context menu options for attributes to quickly add Java getters and setters, and .NET properties
- Undoing a parameter deletion can reorder parameters. The deleted parameter needs to be replaced at the original location
- Creating void operations by typing into a diagram does not refresh the properties panel
- The calculation for stereotype and end name locations has been corrected to not be random, causing the names to be lost. This also affects different aspects of the tool, which should now be fixed.
- Editing operation parameters causes selection abnormalities
- Class and interface members should not be deselected when they are renamed
- Adding a method parameter or return value of type java.lang.String causes duplicate elements to appear in the document tree
- "Export all images" only exports those diagrams that are open in tabs, instead of all diagrams
- "Export all images" doesn't provide any visual feedback or progress
- Cannot delete basic types from class-centric document tree
- The create a new project window won't go away when "Accept" is clicked.
- Right click doesn't work for zoom levels other than 100%
- A new "Add enum" button has been added to the class diagram toolbar
- Visibilities are shown for relationship ends without names
- Classes and interfaces should be selected when they are created
- The user can't apply stereotypes to multiple elements at once

Two new configuration parameters have been added:

If "SwiftCreation" is on, the toolbar buttons will be "sticky". For instance, if you click the class button in the toolbar for class diagrams, each click on the diagram will add a class, until the toolbar button is clicked again. This gets around having to go back and forth to the toolbar for each new element, allowing multiple elements to be created quickly.

If "AddOperationAutomatic" is true, when adding operations, the text box for text entry will show immediately, allowing text entry, and when enter is pressed, a popup window is shown asking if another operation is to be added. If "Enter" is pressed, another operation is added, allowing the user to quickly enter multiple operations at once. If "Esc" is pressed when the popup is shown, no further operations are added. This way, a user can add an operation, hit "Enter" twice and add another operation, until they hit "Esc".


Fixed since 1.1.7:
- The JavaDocs section in the documentation panel can overwrite documentation
- Text wrapping has been applied to use case node text to fit into smaller bubbles
- There is now an "Open Recent" submenu that holds the last 10 most recently opened files
- Scrolling while dragging an element is "jerky" and not very predictable
- The diagram view can't be resized manually
- In the context menu for class elements, there is an "External" option that can be flagged to hide the attributes and operations section of a class or interface and resize it to a default size, making it easy to design classes that are not part of the component, but that only need to be shown in relationships.
- Types are shown now in the SD's, in addition to user-provided names
- You can now convert from ZUML to TCUML on the command line with the following syntax (or use the .bat file, for Windows): "sh run.sh -convert inputPath.zuml outputPath.tcuml"

Fixed since 1.1.6:

- Visibility isn't shown properly on end names
- When importing from ZUML there are a bunch of 1..1 multiplicities shown for each relationship / edge
- Notes and free text now support CTRL+Enter to add a new line
- When resizing notes, the text will wrap to fit the note size
- You can now drag classes from the document tree onto the diagram, making "Delete Representation" a more usable option
- When you type a name of a known class into a diagram, the model creates a data type instead of using the class or the interface. The model element should be used, if it exists. 
- Sometimes when dragging a waypoint across class boundaries, multiple waypoints are created
- The look and feel selection for the application has been moved to the build file.

You just need modify this line in target "run" if you want to change look and feel.
 
<sysproperty key="swing.defaultlaf" value="javax.swing.plaf.metal.MetalLookAndFeel"/>

- Adding waypoints sometimes repositions the edge
- Exporting images seems to lock the directory until the application is closed
- Diagrams aren't sorted alphabetically in the document tree
- Documentation panel is adding whitespace 
- Version in the "about" box is wrong
- The logo at the bottom of the screen has been updated to not be quite so big

Fixed since 1.1.5:
- Code generation doesn't include the "@throws" tags defined in the documentation panel
- Copy and paste has been enhanced.  It should work much better now
- Code generation has been enhanced to better handle certain elements
- Element selection can select elements not clicked on in certain cases
- The documentation panel can throw exceptions in certain cases
- Additional tests have been added to prevent against file save issues
- You can now delete a "@throws" tag in the documentation panel by clearing its text
- The documentation panel doesn't properly maintain user defined spacing
- SD elements have been updated to remove gradients and shadows to be more consistent with the other tool elements.  The graphical look needs to be consistent for the UML Tool, but another implementation is planned that will be "flashier"
- The code generation dialog now defaults to the language of the project, instead of just Java
- Some ZUML converter updates have been added
- Style Panel and Properties Panel have been updated to be more space efficient, and to support upcoming graphical updates.


Fixed since 1.1.4:
- The antialiasing is now off by default, and the grid renderer has been reverted.  This should solve the slowdown problems seen by some users
- Operations can't have their font color changed
- Use case names aren't properly centered
- Documentation "undo" doesn't work correctly for the documentation panel

Fixed since 1.1.3:
- ZUML conversion errors that were causing three separate projects to not import correctly
- A bug was causing the stereotype panel to not show when a specific file was loaded
- The backup functionality has been fixed to work better.  If the backup directory isn't configured, it will default back to putting the backups next to the project file.


Fixed since 1.1.2.1:
- Antialiasing is a configurable option
- Grid renderer has been updated to be "nicer"
- Marking a class abstract doesn't add the stereotype needed
- The fragment loop button in the SDs does nothing, it should be removed for now
- Self-dependencies work for basic dependencies, but not for other edge types
- Deleting specific elements from an imported file can cause corruption
- The create a class diagram hotkey doesn't work
- Exporting graphics has problems with filenames with unsupported characters
- Java code generation outputs an invalid "import .*;"
- Better Mac / OS X integration with menu shortcuts and look and feel are added
- There is now a configurable backup directory to place project backups, instead of right next to the project file
- The ZUML importer should now handle activity diagrams more accurately.


Fixed since 1.1.2:
- AcceptEventActions, SendSignalActions, and FlowFinalNodes aren't working in activity diagrams

Fixed since 1.1.1:

- Activity diagrams are getting corrupted
- Pressing CTRL with the input tool open can cause it to apply changes as if "Enter" was pressed
- Namespaces from a previous project remain when a new project is created
- Spelling problem with "Create a Use Case Diagram" context menu
- "ServiceContract" needs to be an available stereotype in C# projects
- The right click menu doesn't always display properly, depending on where on the element the user right clicks
- Showing and hiding the Java-docs panel happens automatically but can cause problems.  It shouldn't be hid by the application
- The return lanes in SDs have strange font sizes
- Custom stereotypes in imported ZUML files don't show as available in the stereotypes popup
- An exception is seen sometimes when renaming a class
- Deleting a diagram doesn't always show immediately
- Operation name parsing needs tweaks, sometimes two colons are shown
- Self-dependencies don't work (this has been fixed for dependencies, but not other relationship types)
- Code generation fails for classes with generic parameters.  This has been fixed for now, but further, more robust generics support is planned.



Fixed since 1.1:

- Importer issues, including right click menu not always showing and incorrect namespaces
- Synchronous messages in sequence diagram should automatically add a return message
- An exception can occur in the diagram tree
- The signature for Java exceptions should contain a Throwable cause, not Exception
- Static methods aren't shown underlined
- C# projects aren't properly remembering their project type.  When reloading, Java options are shown
- The additions of margins to classes and interfaces was causing operation and attribute text to be truncated
- In certain conditions, changes are immediately visible in the class diagram
- In SD's, the Z-order for shapes isn't loaded correctly, causing shapes to be displayed over the messages
- There need to be more fine-grained controls for sequence diagram shapes in regards to Z-order
- Adding stereotypes to a converted ZUML file can cause exceptions
- The locations of edge text in SD's can be corrupted, resulting in random placement

Fixed since 1.0.3:

- Poseidon import has been integrated in
- Shape colors aren't persistent
- The "Javadocs" section of the documentation panel doesn't allow multiple "throws" tags and causes problems with parameter documentation for multiple parameters
- There needs to be an internal margin for interfaces and classes so the modifier doesn't bump right up to the edge of the containing element
- The default return value should be of type "void", not "int"
- Attributes don't remember their set visibility when being renamed directly, defaulting back to private.
- When loading SD's, certain edges can have their direction reversed.
- When importing a ZUML file, the diagram tree can fail to load correctly 

Fixed since 1.0.2:

- Copying can cause errors while saving
- Null pointer exceptions are occurring
- An error log (log.txt) has been added, instead of outputting to the command line
- Exceptions occur when leaving the tool open for a long period of time, breaking core functionality
- Right clicking can be problematic, with the wrong state being read in certain cases for the show* checkboxes
- The "Create" stereotype appears multiple times if multiple constructors are created.

Fixed since 1.0.1:

- NoSuchMethod exceptions cause issues with removing edges and moving elements in files
- SD edges were swapping directions during persistence (this has been fixed, but files exhibiting the problem can't be fixed)
- Edge names can be moved, but the location isn't persistent
- End names marked "static" aren't shown as underlined

Fixed since 1.0.0:

- Loading a file made in 0.1.13 can cause a crash
- The color shortcut choices don't contain a value for aggregate use cases
- Reported in the forum: generated code can contain an invalid "import *;" line
- Deleting shapes is not persistent, so if a shape is deleted from a diagram, when the file is saved and reloaded, the shape will return
- An exception is thrown when drawing an edge that crosses another edge
- The default shape size should be 80x40
- The icons for cut representation and copy representation shouldn't be on the main tool bar, as it is confusing
- The tool should open at a maximized state if no saved size is available

Fixed since 0.1.13:

- TC color choices are now provided in the color box
- The type drop down is now editable
- The font list isn't sorted alphabetically
- There is no way to remove a namespace from an element
- When changing comment text style, the change isn't always immediately visible
- The width and height values in the style panel aren't properly updated when an element is resized
- The last character in a method signature can be lost after editing, depending on cursor position when "Enter" is pressed
- The popup edit box for entering element names doesn't properly size, sometimes not showing the entire text of the element name
- Certain elements don't respond to double clicks for renaming, like an interface inside of a package
- Adding attributes to a C# interface is problematic
- "bool" should be used instead of "boolean" for C# project types, as should "string" instead of "String"
- Issues are present when adding a stereotype to an attribute with existing documentation
 

Fixed since 0.1.12.1:

- Context menus don't display properly on opened files
- Automatic backups on save so user can revert back 
- Abstract classes aren't colored correctly
- Selection corners still aren't rendering correctly, and the edge corners in SD's don't match the others
- Unicode errors can cause errors
- Package display on elements has been updated to match forum comments
- Showing / hiding attributes for class elements can be problematic
- Loading SD's doesn't show the entire area 

Fixed since 0.1.12:

- Renaming a class doesn't rename the constructors
- Reported issues with scrolling from the forum
- Tooltips don't pop up fast enough
- You can't add free text over a shape easily, as Z-orders are messed up
- Lanes can't be colored in SD's
- File corruption / load issue with return parameters not being saved correctly to the model 

Fixed since 0.1.11.1:

- Mouse over events can leave artifacts and cause shortcut buttons not to work in class diagrams
- Issues are noticed when trying to perform use case and sequence diagram actions at a zoomed in view (>100%)
- Shapes are not deletable
- Print dialog is displayed for every page printed
- Rendering for selection corners needs to be tweaked
- Use case diagram subsystem size is now more usable
- There needs to be support for lane coloring in SD's
- The stereotype popup window isn't modal.
- The text for SD selfcalls is rendered at the top-left portion of the diagram view
- When adding stereotypes, if one is added and then unchecked, it won't show up in subsequent popups
- There is no way to color individual lanes in a sequence diagram
- Unable to delete elements from an SD after a file is opened (this now also works for older files as well)
- Some sort of option is needed to not load all diagrams on startup (the tool now remembers what diagrams were opened in the file last, instead of loading all diagrams)
- Some buttons in the properties panel are missing tooltips
- * is not a default multiplicity


Fixed since 0.1.11:

- Documentation panel not properly updating. 
- File corruption issue mentioned in the forum.  An error is still raised, but previously corrupt files can now be loaded.
- Stereotype popup panel can be displayed in random locations, behind start bars and docks
- It's possible to open up multiple stereotype windows
- File->New doesn't properly clear the opened file
- Child windows don't have the proper icon
- You can add blank and duplicate stereotypes

Fixed since 0.1.10:

- Preliminary language selection support has been added, with C# default stereotypes added
- When adding free text to a diagram, the text should be immediately selected for user input, like adding any other named element.
- Issues with print file name 
- Frozen modifier applies to all attributes in an entity, not just the one selected
- When an element is copied by representation and its pasted value's name is updated, the original doesn't properly show the change
- Exporting via image or code doesn't remember the path chosen
- Exporting via an image needs to apply a default file name to the exported image.
- Hovering over a tab needs to show the full text of the tab name.

Fixed since 0.1.9:

- Expansion of the entire diagram tree happens when a diagram is selected
- The static modifier doesn't show in the diagram
- Selecting elements from the document tree doesn't work
- There is no way to add an exception to a diagram
- Copy and paste doesn't work for all elements
- Class diagram elements can loose their set Z-order
- Aggregations / compositions don't render correctly sometimes
- When editing the text for a guard name, typing overwrites the existing text rather than inserting
- When assigning a type for an attribute, the drop down contains the names of all use cases in the document.
- Loading a file with an empty string SD stimulus name fails
- Reordering attributes and operations with the keyboard shortcuts doesn't work
- Automatic "create" stereotype applied to SD lanes isn't persistent
- Code generation issue with specific path names
- Deleting elements from an opened file doesn't work sometimes

Fixed since 0.1.8:

- Sequence diagram spacing needs to be tweaked
- Adding lifelines to an SD can cause problems if the diagram is moved up or down between adding lifelines
- Documentation isn't included in generated code
- Loading sequence diagrams is buggy
- Multiple drag of lifelines in an SD doesn't work
- Saving with copied items can cause the application to halt and no data to be saved
- Renaming a lifeline is problematic
- Context menu on a copied class doesn't show
- Floats and primitive arrays aren't shown in the type drop down
- Stereotypes aren't properly persistent, as they can be added, but when the file is reopened, the shown stereotypes aren't available as choices in the stereotypes panel.
- Realization relationships don't load correctly.
- Canceling a print operation can cause the grid to disappear and editing functions to fail.
- Can't reorder parameters / stereotypes
- Generating code from an opened file doesn't work

Fixed since 0.1.7:

- Free text nodes don't resize correctly
- Missing font size choices
- Creating a package loop freezes the application (A is a subpackage of A)
- Adding a long note doesn't properly show the entire text added
- When adding a class directly to a package, the class name edit popup isn't properly shown
- Adding a package with a long name can cause an initial rendering bug
- Multiplicities applied to aggregations / compositions aren't persistent
- Speed for diagram creation is slow (simple cache issue)
- Dragging a relationship waypoint past the bounds of the diagram view won't resize the view
- Abstract elements aren't shown with italicized text

Fixed since 0.1.6:

- Minor issues with namespace drop down scaling
- Loading files with activity diagrams 
- Populating the document tree with information loaded from a TCUML file
- Namespace list resize width is too big

Fixed since 0.1.5:

- Open file dialog remembers the last folder opened
- Package display fixes
- Namespace list is too comprehensive
- Problems saving 
- Double-click popup text boxes should select the entire text
- Closing the tool now doesn't ask to save every time, only when there are unsaved changes
- Code generation issues
- Errors with modifying end documentation for aggregation / compositions, including name and multiplicity
- Inserting text is an overwrite instead of an insert

Fixed since 0.1.4:

- Note resizing doesn't work
- Sane use case resizing
- Document tree vertical scrolling
- Printing error that causes the diagram grid to disappear
- Resizing an actor doesn't work well
- Stereotypes are now tied to element type
- When dragging an edge, the diagram view scrolls automatically 
- Add a constructor adds the appropriate stereotype
- Attributes and operations can be reordered using the keyboard arrows
- Aggregation / compositions can now have an initial value
- There are non-labeled buttons in the GUI
- Deleting an element can cause problems with the document tree
- Method / attribute text isn't parsed correctly
- Right click menu has been added
- Opening files with activity diagrams now works
- Changed the edit text behavior to apply changes when clicking outside an element.

Fixed since 0.1.3:

- You can't deselect all elements by clicking in the diagram view
- Selection corners should have a black outline
- Selection arrows not shown
- Z-order manipulation is better
- Rectangles can't have properties like color
- The zoom buttons need to be removed from the bottom toolbar, now that they are in the top tool bar
- Adding things at different zoom levels doesn't work
- Open file dialog remembers the last folder opened now
- Diagram renaming has been fixed
- Guard labels aren't shown
- Aggregations / compositions relationships don't work and need shortcut buttons
- Attribute ordering / deletion doesn't work
- Relationship labels are shown at all times, not just when a stereotype is applied
- The tool needs to "remember" the window size so it opens to the same size after being closed
- Sequence diagram create lines don't have a <<create>> stereotype
- Sequence diagram self-calls are hard to create
- In the sequence diagrams, if you drag an existing item outside the visible area, it will expand; however, part of the item (lifeline, for instance) will not be fully visible.
- The description of sequence diagram calls don't line up correctly

Fixed since 0.1.2:

- Group dragging / moving
- Zoom is going to be refactored into buttons on the tool bar
- Zoom slider is added
- Automatic view resizing and scrolling don't work
- You can't add attributes to an interface
- Z-ordering has been added
- Package display is going to be updated to be less redundant
- The save prompt text needs to be fixed
- You can't hide or show compartments of classes / interfaces
- The font size needs to be customizable

Fixed since 0.1.1:

- Documentation panel is now a tab, along with the properties panel
- Void is now a built in type
- Relationships can now be deleted
- Creating a relationship automatically selects the relationship after it is added
- Default color for a note has been added
- You can now double click on a method or attribute to change its text
- Model fixes have been added to aid with Poseidon import


Fixed since 0.1.0:

- Image export will paint background color first
- Edge dragging should work better
- Relationships are now drawn with an arrow
- Text can now be fully entered in the diagram, instead of being truncated
- Edge stereotypes, like "extends" now stay showing, instead of having to select the edge 



