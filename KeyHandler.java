package Notepad;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    App app;

    public KeyHandler(App app) {
        this.app = app;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            app.file.save();
        }
        if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
            app.file.saveAs();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
            app.menuFile.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E) {
            app.menuEdit.doClick();
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_T) {
            app.menuColor.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
