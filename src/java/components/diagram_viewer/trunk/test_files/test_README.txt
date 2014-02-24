1. Modify the the path of dependencies in "build.xml".

2. THIS NOTE IS IMPORTANT FOR BUILD AND TEST.
   Note that, "Diagram Viewer", "Diagram Elements" and "Diagram Edges" are components which are dependencies to each other,
   so here are several suggestions for build and test.
   If you are a builder, you'd better read from 1; but if you are a developer, you can jump to the 3 for reading, thanks.

   1) You can put the main code of "Diagram Viewer" and "Diagram Edges", which are under "src\java\main" into the main of
      "Diagram Elements", then you can compile and test "Diagram Elements" successfully.
      But in this way, you would get the "diagram_elements.jar" with classes of "Diagram Viewer" and "Diagram Edges" inside,
      so you need to delete all the classes of "Diagram Viewer" and "Diagram Edges" from the jar.
      And also, the coverage of the tests are not correct in this way, as other components codes would be counted into the
      coverage report.
      SO, THIS IS ONLY THE BASIC BUILD FOR GETTING THE THRUM FROM A CLEW. :)

   2) By the method mentioned above, you can get a "clean" "diagram_elements.jar" only with the classes itself, and you can get
      the same "clean" "diagram_edges.jar" in the same way.
      And then, use these two "clean" jars to build the "Diagram Viewer", it would be easier as the common build task, so finally we
      get a really clean "diagram_viewer.jar".
      Remember remove the code files of "Diagram Viewer" and "Diagram Edges" from the "Diagram Elements" component, and remove the
      code files of "Diagram Viewer" from the "Diagram Edges" component.
      And use the jars created above as dependencies to build and test these components AGAIN.
      After that, we get the results we need.

   3) If you can download "diagram_edges.jar" and "diagram_elements.jar" from catalog directly, then ignore the suggestion above,
      and use the libs to build and test this component easily.
