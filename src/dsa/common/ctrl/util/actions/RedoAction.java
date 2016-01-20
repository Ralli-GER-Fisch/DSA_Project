package dsa.common.ctrl.util.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.undo.UndoManager;

@SuppressWarnings("serial")
public class RedoAction extends AbstractAction {
	UndoManager manager;
	public RedoAction(UndoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		manager.redo();
	}

}
