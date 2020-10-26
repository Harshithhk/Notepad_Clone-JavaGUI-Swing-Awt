package Notepad;

import java.awt.Font;

public class Function_Format {

    App app;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Function_Format(App app) {
        this.app = app;
    }

    public void wordWrap() {

        if (app.wordWrapOn == false) {
            app.wordWrapOn = true;
            app.textArea.setLineWrap(true);
            app.textArea.setWrapStyleWord(true);
            app.miWrap.setText("Word Wrap: On");
        } else if (app.wordWrapOn == true) {
            app.wordWrapOn = false;
            app.textArea.setLineWrap(false);
            app.textArea.setWrapStyleWord(false);
            app.miWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize) {

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {

        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                app.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                app.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                app.textArea.setFont(timesNewRoman);
        }

    }
}
