import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    private UndoManager undoManager;

    public UndoAction(UndoManager manager) {
        this.undoManager = manager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }
}
