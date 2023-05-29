package toilet.solitaire.design.patterns.vgnshiyer.views;

import java.io.IOException;
import java.util.List;

import jline.console.ConsoleReader;

/* Template Pattern : A template for creating views */
public abstract class View {
    public static ConsoleReader reader;

    static {
        try {
            reader = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void view() throws IOException;
}
