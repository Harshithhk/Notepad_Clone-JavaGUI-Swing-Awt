package Notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem miNew, miOpen, miSave, miSaveAs, miExit;

    Function_File file = new Function_File(this);

    public static void main(String[] args) {
        new App();
    }

    public App() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();

        window.setVisible(true);
    }

    public void createWindow() {

        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.isResizable();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {

        miNew = new JMenuItem("NEW");
        miNew.addActionListener(this);
        miNew.setActionCommand("New");
        menuFile.add(miNew);

        miOpen = new JMenuItem("Open");
        miOpen.addActionListener(this);
        miOpen.setActionCommand("Open");
        menuFile.add(miOpen);

        miSave = new JMenuItem("Save");
        miSave.addActionListener(this);
        miSave.setActionCommand("Save");
        menuFile.add(miSave);

        miSaveAs = new JMenuItem("SaveAs");
        miSaveAs.addActionListener(this);
        miSaveAs.setActionCommand("SaveAs");
        menuFile.add(miSaveAs);

        miExit = new JMenuItem("Exit");
        miExit.addActionListener(this);
        miExit.setActionCommand("Exit");
        menuFile.add(miExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command == "New") {
            file.newFile();
        } else if (command == "Open") {
            file.open();
        } else if (command == "Save") {
            file.save();
        } else if (command == "SaveAs") {
            file.saveAs();
        } else if (command == "Exit") {
            file.exit();
        }
    }
}
