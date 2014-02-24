package com.topcoder.umltool.deploy;

import com.topcoder.gui.panels.properties.DiagramChangeListener;
import com.topcoder.gui.panels.properties.DiagramStateEvent;

public class DiagramChangeHandler implements DiagramChangeListener {

    private final MainFrame mainFrame;

    public DiagramChangeHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void diagramStateChanged(DiagramStateEvent evt) {
        mainFrame.getDocumentTree().updateTree();
        mainFrame.getDiagramViewer().openDiagramView(evt.getDiagram());
    }

}
