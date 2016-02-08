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

import dsa.common.data.Rasse;
import dsa.common.data.Vorteil;
import dsa.common.data.mappings.Rasse_Vorteil;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddRasse_VorteilPanel extends JPanel {
	List<Rasse_Vorteil> vorteile = new ArrayList<Rasse_Vorteil>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> vorteilItems;
	List<NameIdWrapper> typItems;
	ActionListener buttonListener;
	Rasse rasse;
	public AddRasse_VorteilPanel(Rasse r,Set<Rasse_Vorteil> vorteileI) {
		this.rasse = r;
		if(!vorteileI.isEmpty())
			this.vorteile.addAll(vorteileI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		vorteilItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Vorteil.class);
		typItems = Rasse_Vorteil.getTypNameIdWrapper();
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					vorteile.add(new Rasse_Vorteil(rasse));
				}
				else if(e.getActionCommand().startsWith("del")){
					vorteile.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Rasse_Vorteil> iter = vorteile.iterator();
		ii = 0;
		while(iter.hasNext()){
			Rasse_Vorteil curV = iter.next();
			
			NameIdComboBox vSF = new NameIdComboBox(vorteilItems);
			vSF.setSelectedIndex(curV.getVorteil().getId()!=null?curV.getVorteil().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(vSF);
			vSF.setPreferredSize(new Dimension(125,25));
			
			NameIdComboBox typSF = new NameIdComboBox(typItems);
			typSF.setSelectedIndex(curV.getTyp()!=null?curV.getTyp().intValue()-1:0);
			AutoCompleteDecorator.decorate(typSF);
			typSF.setPreferredSize(new Dimension(75,25));
			
			JSpinner vValue = new JSpinner();
			vValue.setValue(curV.getWert()!=null?curV.getWert().intValue():-1);
			vValue.setPreferredSize(new Dimension(50, 25));
			
			vSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						vorteile.get(pos).setVorteil(new Vorteil((long) ((NameIdWrapper)e.getItem()).getId()));
				}
			});
			typSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						vorteile.get(pos).setTyp((Byte) ((NameIdWrapper)e.getItem()).getId());
				}
			});
			vValue.addChangeListener(new ChangeListener() {
				int pos = ii;
				@Override
				public void stateChanged(ChangeEvent e) {
					vorteile.get(pos).setWert((Integer) vValue.getValue());
				}
			});
			
			JButton delButton = new JButton("-");
			delButton.setActionCommand("del_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			add(vSF,c);
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

	public Set<Rasse_Vorteil> getRasse_Vorteile() {
		Set<Rasse_Vorteil> retval = new HashSet<Rasse_Vorteil>();
		Iterator<Rasse_Vorteil> iter = vorteile.iterator();
		while(iter.hasNext()){
			Rasse_Vorteil curV = iter.next();
			curV.setVorteil(DbManager.getCurrentDbManager().loadInstanceById(curV.getVorteil(), curV.getVorteil().getId()));
			curV.setTyp(new Byte(curV.getTyp()));
			curV.setWert(new Integer(curV.getWert()));
			try {
				retval.add(curV);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
