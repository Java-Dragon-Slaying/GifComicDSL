package entities;

import ast.PanelStep;

import java.util.List;

public class Panel {
    Coordinate dimensions;
    Image background;
    List<PanelStep> stepList;
    String text;
    Coordinate textPosition; // maybe can provide a default value for this ?
    Integer fontSize; // should go in a config

    // may need to store default text color here as well?


    public Panel(Coordinate dimensions, Image background, List<PanelStep> stepList) {
        this.dimensions = dimensions;
        this.background = background;
        this.stepList = stepList;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCoordinate(Coordinate textPosition) {
        this.textPosition = textPosition;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return this.text;
    }

    public Coordinate getCoordinate() {
        return this.textPosition;
    }

    public Integer getFontSize() {
        return this.fontSize;
    }
}
