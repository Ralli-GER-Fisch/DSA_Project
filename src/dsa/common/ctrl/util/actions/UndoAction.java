package dsa.common.ctrl.util.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.undo.UndoManager;

@SuppressWarnings("serial")
public class UndoAction extends AbstractAction {
	UndoManager manager;
	public UndoAction(UndoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		manager.undo();
	}

}
