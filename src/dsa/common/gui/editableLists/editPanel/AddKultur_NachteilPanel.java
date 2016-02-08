package dsa.common.gui.editableLists.editPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dsa.common.data.Kultur;
import dsa.common.data.Nachteil;
import dsa.common.data.mappings.Kultur_Nachteil;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddKultur_NachteilPanel extends JPanel {
	List<Kultur_Nachteil> nachteile = new ArrayList<Kultur_Nachteil>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> nachteilItems;
	List<NameIdWrapper> typItems;
	ActionListener buttonListener;
	Kultur kultur;
	public AddKultur_NachteilPanel(Kultur k,Set<Kultur_Nachteil> nachteileI) {
		this.kultur = k;
		if(!nachteileI.isEmpty())
			this.nachteile.addAll(nachteileI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		nachteilItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Nachteil.class);
		typItems = Kultur_Nachteil.getTypNameIdWrapper();
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					nachteile.add(new Kultur_Nachteil(kultur));
				}
				else if(e.getActionCommand().startsWith("del")){
					nachteile.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Kultur_Nachteil> iter = nachteile.iterator();
		ii = 0;
		while(iter.hasNext()){
			Kultur_Nachteil curN = iter.next();
			
			NameIdComboBox nSF = new NameIdComboBox(nachteilItems);
			nSF.setSelectedIndex(curN.getNachteil().getId()!=null?curN.getNachteil().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(nSF);
			nSF.setPreferredSize(new Dimension(125,25));
			
			NameIdComboBox typSF = new NameIdComboBox(typItems);
			typSF.setSelectedIndex(curN.getTyp()!=null?curN.getTyp().intValue()-1:0);
			AutoCompleteDecorator.decorate(typSF);
			typSF.setPreferredSize(new Dimension(75,25));
			
			JSpinner vValue = new JSpinner();
			vValue.setValue(curN.getWert()!=null?curN.getWert().intValue():-1);
			vValue.setPreferredSize(new Dimension(50, 25));
			
			nSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						nachteile.get(pos).setNachteil(new Nachteil((long) ((NameIdWrapper)e.getItem()).getId()));
				}
			});
			typSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						nachteile.get(pos).setTyp((Byte) ((NameIdWrapper)e.getItem()).getId());
				}
			});
			vValue.addChangeListener(new ChangeListener() {
				int pos = ii;
				@Override
				public void stateChanged(ChangeEvent e) {
					nachteile.get(pos).setWert((Integer) vValue.getValue());
				}
			});
			
			JButton delButton = new JButton("-");
			delButton.setActionCommand("del_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			add(nSF,c);
			c.gridx = 1;
			add(typSF,c);
			c.gridx = 2;
			add(vValue,c);
			c.gridx = 3;
			add(delButton,c);
			delButton.addActionListener(buttonListener);
			ii++;
		}
			JButton addButton = new JButton("+");
			addButton.setActionCommand("add");
			
			c.gridy = ii;
			c.gridx = 2;
			add(addButton,c);
			addButton.addActionListener(buttonListener);
			super.revalidate();
			super.repaint();
	}

	public Set<Kultur_Nachteil> getKultur_Nachteile() {
		Set<Kultur_Nachteil> retval = new HashSet<Kultur_Nachteil>();
		Iterator<Kultur_Nachteil> iter = nachteile.iterator();
		while(iter.hasNext()){
			Kultur_Nachteil curN = iter.next();
			curN.setNachteil(DbManager.getCurrentDbManager().loadInstanceById(curN.getNachteil(), curN.getNachteil().getId()));
			curN.setTyp(new Byte(curN.getTyp()));
			curN.setWert(new Integer(curN.getWert()));
			try {
				retval.add(curN);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
