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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dsa.common.data.Kultur;
import dsa.common.data.Profession;
import dsa.common.data.mappings.Kultur_Profession;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.gui.util.NameIdComboBox;
import dsa.common.manage.DbManager;

@SuppressWarnings("serial")
public class AddKultur_ProfessionPanel extends JPanel {
	List<Kultur_Profession> profession_mods = new ArrayList<Kultur_Profession>();
	GridBagConstraints c;
	int ii;
	List<NameIdWrapper> professionItems;
	ActionListener buttonListener;
	Kultur kultur;
	public AddKultur_ProfessionPanel(Kultur k,Set<Kultur_Profession> profession_modsI) {
		this.kultur = k;
		if(!profession_modsI.isEmpty())
			this.profession_mods.addAll(profession_modsI);
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0;
		professionItems = DbManager.getCurrentDbManager().getNameIdWrapperByClass(Profession.class);
		buttonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().startsWith("add")){
					profession_mods.add(new Kultur_Profession(kultur));
				}
				else if(e.getActionCommand().startsWith("del")){
					profession_mods.remove(new Integer(e.getActionCommand().split("_")[1]).intValue());
				}
				reCreate();
			}
		};
		reCreate();
		
	}
	private void reCreate() {
		removeAll();
		Iterator<Kultur_Profession> iter = profession_mods.iterator();
		ii = 0;
		while(iter.hasNext()){
			Kultur_Profession curEM = iter.next();
			
			NameIdComboBox eSF = new NameIdComboBox(professionItems);
			eSF.setSelectedIndex(curEM.getProfession().getId()!=null?curEM.getProfession().getId().intValue()-1:0);
			AutoCompleteDecorator.decorate(eSF);
			eSF.setPreferredSize(new Dimension(75,25));
			
			eSF.addItemListener(new ItemListener() {
				int pos = ii;
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						profession_mods.get(pos).setProfession(new Profession((long) ((NameIdWrapper)e.getItem()).getId()));
				}
			});
			
			JButton delButton = new JButton("-");
			delButton.setActionCommand("del_"+ii);
			
			c.gridy = ii;
			c.gridx = 0;
			add(eSF,c);
			c.gridx = 1;
			add(delButton,c);
			delButton.addActionListener(buttonListener);
			ii++;
		}
			JButton addButton = new JButton("+");
			addButton.setActionCommand("add");
			
			c.gridy = ii;
			c.gridx = 1;
			add(addButton,c);
			addButton.addActionListener(buttonListener);
			super.revalidate();
			super.repaint();
	}

	public Set<Kultur_Profession> getKultur_Professionen() {
		Set<Kultur_Profession> retval = new HashSet<Kultur_Profession>();
		Iterator<Kultur_Profession> iter = profession_mods.iterator();
		while(iter.hasNext()){
			Kultur_Profession curEM = iter.next();
			curEM.setProfession(DbManager.getCurrentDbManager().loadInstanceById(curEM.getProfession(), curEM.getProfession().getId()));
			try {
				retval.add(curEM);
			} catch (Exception e) {
			}
		}
		return retval;
	}

}
