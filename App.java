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
    boolean wordWrapOn = false;

    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuTheme;

    JMenuItem miNew, miOpen, miSave, miSaveAs, miExit;

    JMenuItem miWrap, miFontArial, miFontCSMS, miFontTNR, miFontSize12, miFontSize16, miFontSize20, miFontSize24;
    JMenu menuFont, menuFontSize;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);

    public static void main(String[] args) {
        new App();
    }

    public App() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

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

        menuTheme = new JMenu("Theme");
        menuBar.add(menuTheme);
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

    public void createFormatMenu() {

        miWrap = new JMenuItem("Word Wrap: Off");
        miWrap.addActionListener(this);
        miWrap.setActionCommand("Word Wrap");
        menuFormat.add(miWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        miFontArial = new JMenuItem("Arial");
        miFontArial.addActionListener(this);
        miFontArial.setActionCommand("Arial");
        menuFont.add(miFontArial);

        miFontCSMS = new JMenuItem("Comic Sans MS");
        miFontCSMS.addActionListener(this);
        miFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(miFontCSMS);

        miFontTNR = new JMenuItem("Times New Roman");
        miFontTNR.addActionListener(this);
        miFontTNR.setActionCommand("Times New Roman");
        menuFont.add(miFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        miFontSize12 = new JMenuItem("12");
        miFontSize12.addActionListener(this);
        miFontSize12.setActionCommand("font12");
        menuFontSize.add(miFontSize12);

        miFontSize16 = new JMenuItem("16");
        miFontSize16.addActionListener(this);
        miFontSize16.setActionCommand("font16");
        menuFontSize.add(miFontSize16);

        miFontSize20 = new JMenuItem("20");
        miFontSize20.addActionListener(this);
        miFontSize20.setActionCommand("font20");
        menuFontSize.add(miFontSize20);

        miFontSize24 = new JMenuItem("24");
        miFontSize24.addActionListener(this);
        miFontSize24.setActionCommand("font24");
        menuFontSize.add(miFontSize24);

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
        } else if (command == "Word Wrap") {
            format.wordWrap();
        } else if (command == "Arial") {
            format.setFont(command);
        } else if (command == "Comic Sans MS") {
            format.setFont(command);
        } else if (command == "Times New Roman") {
            format.setFont(command);
        } else if (command == "font12") {
            format.createFont(12);
        } else if (command == "font16") {
            format.createFont(16);
        } else if (command == "font20") {
            format.createFont(20);
        } else if (command == "font24") {
            format.createFont(24);
        }
    }
}
