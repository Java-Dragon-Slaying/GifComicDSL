package resources;
import ast.*;
import entities.Image;
import entities.ImageLibrary;
import visitor.GifComicVisitor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Render implements GifComicVisitor {

    String outFile;
    PrintWriter html;
    private HashMap<String, BufferedImage> imageMap;

    public Render(String outFile) throws FileNotFoundException, UnsupportedEncodingException {
        this.html = new PrintWriter(outFile+".html", "UTF-8");
        this.imageMap = new HashMap<>();
        this.imageLibrary = new ImageLibrary();
    }

    @Override
    public Object visit(Object context, GifComicProgram gfc) {
        for(Statement s: gfc.getStatements()){
            s.accept(context, this);
        }
        return null;
    }

    @Override
    public Object visit(Object context, CreateImage createImage) {
        String source;
        if(imageLibrary.)
        File img = new File();
        try {
            imageMap.put(createImage.getName(), ImageIO.read(img));
        } catch (java.io.IOException e){
            System.out.println(e);
        }
        return context;
    }

    @Override
    public Object visit(Object context, AddImage addImage) {
        return null;
    }

    @Override
    public Object visit(Object context, MoveImage m) {
        return null;
    }

    @Override
    public Object visit(Object context, PanelStep ps) {
        return null;
    }

    @Override
    public Object visit(Object context, RemoveImage r) {
        return null;
    }

    @Override
    public Object visit(Object context, CreatePanel createPanel) {
        return null;
    }

    // class for rendering the comic! iterate through the panels and then return a list of GIFs
    public List<Object> renderComic(String output) {

        return new ArrayList<Object>();
    }

    // create an html file called name, populate with the given GIFs, and save iut at the given filepath
    public void renderHtml(String name, String output_filepath, List<Object> output) {

    }

}
