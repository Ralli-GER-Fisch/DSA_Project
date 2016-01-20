package dsa.common.ctrl.util;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class CustomUndoableEditListener implements UndoableEditListener {
	UndoManager manager;
	public CustomUndoableEditListener(UndoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		manager.addEdit(e.getEdit());
	}
}
