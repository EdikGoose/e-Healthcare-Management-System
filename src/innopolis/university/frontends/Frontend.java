package innopolis.university.frontends;

import java.io.PrintWriter;

public abstract class Frontend {

    final PrintWriter writer;

    public Frontend(PrintWriter writer) {
        this.writer = writer;
    }

    /**
     * This method should load a new frontend page
     */
    abstract void start();

    public PrintWriter getWriter() {
        return writer;
    }
}
