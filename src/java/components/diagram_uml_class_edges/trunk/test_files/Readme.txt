
Hi, here are some notes:

1) the real depends are used(provided by the build manager), please refer to 
   test_files/depends.rar, test_files/diagram_viewer.jar,
   test_files/diagram_edges.jar and build.xml

2) Utils#updateTextFieldSizeLocationVisibility has been updated
   according to the suggestion from the assembly team.
   Following code has been added:

        // when the text of a text field is an empty string, the graph node should be set invisible first.
        if (textField.getText().length() == 0) {
            graphNode.setVisible(false);
        }


