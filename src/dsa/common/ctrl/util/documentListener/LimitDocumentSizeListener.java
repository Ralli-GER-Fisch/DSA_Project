package dsa.common.ctrl.util.documentListener;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class LimitDocumentSizeListener implements DocumentListener {
	private int maxSize;
	
	public LimitDocumentSizeListener(int maxSize) {
		this.maxSize = maxSize;
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		if(e.getDocument().getLength() > maxSize){
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
			        try{
			            e.getDocument().remove(maxSize,1);
			        }
			        catch(BadLocationException e){
			            e.printStackTrace();
			        }
				};
			});
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument().getLength() > maxSize){
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
			        try{
			            e.getDocument().remove(maxSize,1);
			        }
			        catch(BadLocationException e){
			            e.printStackTrace();
			        }
				};
			});
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

}
