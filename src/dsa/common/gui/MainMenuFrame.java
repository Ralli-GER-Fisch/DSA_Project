package dsa.common.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import dsa.common.ctrl.actionlisteners.GUIControlMenuBarActionListener;

@SuppressWarnings("serial")
public class MainMenuFrame extends JFrame {
	
	public static final JLabel LOADING_GIF = new JLabel("",new ImageIcon(Image.class.getResource("/resources/load.gif")),SwingConstants.CENTER);;
	private static MainMenuFrame currentMainMenuFrame;
	private static GUIControlMenuBarActionListener menuBarActionListener;
	private static JPanel contentPanel;
	
	public MainMenuFrame() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Image.class.getResource("/resources/icon.png")));
		setTitle("DSA-Project");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(800,600));
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		
		menuBarActionListener = new GUIControlMenuBarActionListener();
		JMenuBar menuBar = new JMenuBar();
		//Menus
		JMenu menuFile = new JMenu("Datei");
		JMenu menuEdit = new JMenu("Bearbeiten");
		JMenu menuCreator = new JMenu("Tools");
		
		//Menu Items
				
		JMenuItem menuFileExit = new JMenuItem("Beenden");
		menuFileExit.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK, true));
		menuFileExit.addActionListener(menuBarActionListener);
		menuFileExit.setArmed(true);
		menuFileExit.setActionCommand(GUIControlMenuBarActionListener.ACTION_QUIT);
		menuFile.add(menuFileExit);
		
		//menuCreator Items
		JMenuItem menuCreatorEigenschaft = new JMenuItem("Eigenschaften");
		menuCreatorEigenschaft.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK, true));
		menuCreatorEigenschaft.addActionListener(menuBarActionListener);
		menuCreatorEigenschaft.setArmed(true);
		menuCreatorEigenschaft.setActionCommand(GUIControlMenuBarActionListener.ACTION_OPEN_ATTRIBUTE_EDITOR);
		menuCreator.add(menuCreatorEigenschaft);
		
		JMenuItem menuCreatorTalent = new JMenuItem("Talente");
		menuCreatorTalent.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK, true));
		menuCreatorTalent.addActionListener(menuBarActionListener);
		menuCreatorTalent.setArmed(true);
		menuCreatorTalent.setActionCommand(GUIControlMenuBarActionListener.ACTION_OPEN_TALENT_EDITOR);
		menuCreator.add(menuCreatorTalent);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuCreator);
		add(menuBar,BorderLayout.NORTH);
		add(contentPanel,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setCurrentMainMenuFrame(this);
	}

	/**
	 * @return The current center content panel. __NOT the content pane__
	 * */
	public static JPanel getContentPanel() {
		if(contentPanel == null)
			contentPanel = new JPanel();
		return contentPanel;
	}
	/**
	 * To set the center content panel. __NOT the content pane__
	 * */
	public void setContentPanel(JPanel contentPanel) {
		MainMenuFrame.getCurrentMainMenuFrame().remove(MainMenuFrame.getContentPanel());
		MainMenuFrame.contentPanel = contentPanel;
		MainMenuFrame.getCurrentMainMenuFrame().add(MainMenuFrame.getContentPanel(),BorderLayout.CENTER);
		MainMenuFrame.currentMainMenuFrame.validate();
	}

	public static MainMenuFrame getCurrentMainMenuFrame() {
		if(currentMainMenuFrame == null)
			new MainMenuFrame();
		return currentMainMenuFrame;
	}

	private static void setCurrentMainMenuFrame(MainMenuFrame currentMainMenuFrame) {
		MainMenuFrame.currentMainMenuFrame = currentMainMenuFrame;
	}
}
