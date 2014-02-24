package com.topcoder.gui.panels.properties;

import com.topcoder.diagraminterchange.Diagram;

public class DiagramStateEvent {

    private final Diagram diagram;

    public DiagramStateEvent(Diagram diagram) {
        this.diagram = diagram;
    }

    public Diagram getDiagram() {
        return diagram;
    }
}
