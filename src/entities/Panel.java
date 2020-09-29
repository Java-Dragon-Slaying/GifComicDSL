package entities;

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

    // todo - setter methods for optional fields like text, textPosition, fontsize, or any additional ones added.

}
