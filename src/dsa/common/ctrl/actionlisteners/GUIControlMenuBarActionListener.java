package dsa.common.ctrl.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dsa.common.gui.AttributeCreatorFrame;
import dsa.common.gui.MainMenuFrame;
import dsa.common.gui.NachteilCreatorFrame;
import dsa.common.gui.RasseCreatorFrame;
import dsa.common.gui.TalentCreatorFrame;
import dsa.common.gui.VorteilCreatorFrame;

public class GUIControlMenuBarActionListener implements ActionListener {
	
	public static final String ACTION_QUIT = "quitAction";
	public static final String ACTION_OPEN_ATTRIBUTE_EDITOR = "openAttribEditAction";
	public static final String ACTION_OPEN_TALENT_EDITOR = "openTalentEditAction";
	public static final String ACTION_OPEN_RASSE_EDITOR = "openRasseEditAction";
	public static final String ACTION_OPEN_VORTEIL_EDITOR = "openVorteilEditAction";
	public static final String ACTION_OPEN_NACHTEIL_EDITOR = "openNachteilEditAction";
	
	public GUIControlMenuBarActionListener() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case ACTION_QUIT:
				System.exit(0);
				break;
			case ACTION_OPEN_ATTRIBUTE_EDITOR:
				MainMenuFrame.getCurrentMainMenuFrame().setContentPanel(AttributeCreatorFrame.getCurrentAttributeCreatorFrame());
				break;
			case ACTION_OPEN_TALENT_EDITOR:
				MainMenuFrame.getCurrentMainMenuFrame().setContentPanel(TalentCreatorFrame.getCurrentTalentCreatorFrame());
				break;
			case ACTION_OPEN_RASSE_EDITOR:
				MainMenuFrame.getCurrentMainMenuFrame().setContentPanel(RasseCreatorFrame.getCurrentRasseCreatorFrame());
				break;
			case ACTION_OPEN_VORTEIL_EDITOR:
				MainMenuFrame.getCurrentMainMenuFrame().setContentPanel(VorteilCreatorFrame.getCurrentVorteilCreatorFrame());
				break;
			case ACTION_OPEN_NACHTEIL_EDITOR:
				MainMenuFrame.getCurrentMainMenuFrame().setContentPanel(NachteilCreatorFrame.getCurrentNachteilCreatorFrame());
				break;
			default:
				break;
		}

	}

}
