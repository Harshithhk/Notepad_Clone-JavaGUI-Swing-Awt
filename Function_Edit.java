package Notepad;

public class Function_Edit {
    App app;

    public Function_Edit(App app) {
        this.app = app;
    }

    public void undo() {
        app.um.undo();
    }

    public void redo() {
        app.um.redo();
    }
}
