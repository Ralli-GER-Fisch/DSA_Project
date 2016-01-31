package dsa.common.gui.editableLists.tables;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import dsa.common.data.wrapper.CollectionGenericWrapper;
import dsa.common.gui.editableLists.tableModels.AbstractCustomTableModel;
import dsa.common.gui.editableLists.tables.cellrenderer.GenericCollectionTCR;
import dsa.common.gui.editableLists.tables.cellrenderer.LongTCR;
import dsa.common.gui.editableLists.tables.cellrenderer.StringTCR;

@SuppressWarnings("serial")
public class CustomRenderedTable<T> extends JTable {
	private static final TableCellRenderer	TCR_DEFAULT = new DefaultTableCellRenderer(),
											TCR_LONG = new LongTCR(),
											TCR_STRING = new StringTCR(),
											TCR_GENERICCOLLECTION = new GenericCollectionTCR();
	private int mouseOverRow = -1, mouseOverCol = -1;
	public CustomRenderedTable() {
		super();
	}

	public CustomRenderedTable(AbstractCustomTableModel<T> aTM) {
		super(aTM);
		//Set custom renderers.
		for(Class<?> c :aTM.getColumnClasses()){
			setDefaultRenderer(c, getCustomRendererByClass(c));
		}
		super.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseOverRow = rowAtPoint(e.getPoint());
				mouseOverCol = columnAtPoint(e.getPoint());
				if(mouseOverRow>=0&&mouseOverCol>=0)
					repaint();
			}
		});
	}

	private TableCellRenderer getCustomRendererByClass(Class<?> c) {
		if(c.equals(Long.class)){
			return TCR_LONG;
		}
		if(c.equals(String.class)){
			return TCR_STRING;
		}
		if(c.equals(CollectionGenericWrapper.class)){
			return TCR_GENERICCOLLECTION;
		}
		return TCR_DEFAULT;
	}

	public int getMouseOverRow() {
		return mouseOverRow;
	}
	public void setMouseOverRow(int mouseOverRow) {
		this.mouseOverRow = mouseOverRow;
	}
	public int getMouseOverCol() {
		return mouseOverCol;
	}
	public void setMouseOverCol(int mouseOverCol) {
		this.mouseOverCol = mouseOverCol;
	}
	/*
	private Object toProbenString(Set<Probe> proben) {
		String retval = "";
		for(Probe p : proben){
			if(!retval.isEmpty())
				retval+=", ";
			retval += p.getEigenschaft1().getKuerzel()+"/"+
					p.getEigenschaft2().getKuerzel()+"/"+
					p.getEigenschaft3().getKuerzel();
		}
		return retval;
	}*/
}
