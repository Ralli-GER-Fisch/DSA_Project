package dsa.common.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dsa.common.gui.LoginScreen;
import dsa.common.gui.MainMenuFrame;
import dsa.common.manage.DbManager;

public class DsaProjectMain {
	//private static JWindow window;
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					new LoginScreen();
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void startProgram(String username, String password) {
		new SwingWorker<Object, Object>() {
			private JWindow window;
			@Override
			protected Object doInBackground(){
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						window = new JWindow();
						window.setLocationByPlatform(true);
						window.setAlwaysOnTop(true);
						window.setBackground(new Color(0,0,0,0));
						window.getContentPane().add(new JLabel("",new ImageIcon(Image.class.getResource("/resources/splash.gif")),SwingConstants.CENTER));
						window.pack();
						window.setLocationRelativeTo(null);
						window.setVisible(true);
					}
				});
				DbManager.getNewDbManager(username,password);
				new MainMenuFrame();
				return null;
			}
			@Override
			protected void done() {
				Timer timer = new Timer(250, new ActionListener(){
				    public void actionPerformed(ActionEvent e){
				        window.setVisible(false);
				        window.dispose();
				    }
				});
				timer.setRepeats(false);
				timer.start();
			}
		}.execute();
	}
}
