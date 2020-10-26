package Notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    App app;
    String fileName;
    String fileAddress;

    public Function_File(App app) {

        this.app = app;
    }

    public void newFile() {
        app.textArea.setText("");
        app.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(app.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            app.window.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            app.textArea.setText("");
            String line = null;

            while ((line = br.readLine()) != null) {
                app.textArea.append(line + "\n");
            }

            br.close();
        } catch (Exception e) {
            System.out.println("FILE NOT OPENED");
        }
    }

    public void save() {

        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(app.textArea.getText());
                fw.close();
            } catch (Exception e) {
                System.out.println("SOMETHING WENT WRONG");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(app.window, "Open", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            app.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName + ".txt");
            fw.write(app.textArea.getText());
            fw.close();

        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
        }
    }

    public void exit() {

        System.exit(0);
    }

}
