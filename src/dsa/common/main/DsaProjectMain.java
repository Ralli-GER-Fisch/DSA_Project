package dsa.common.main;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import dsa.common.gui.MainMenuFrame;
import dsa.common.manage.DbManager;

public class DsaProjectMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		JWindow window = new JWindow();
		window.setBackground(new Color(0,0,0,0));
		window.getContentPane().add(new JLabel("",new ImageIcon(Image.class.getResource("/resources/splash.gif")),SwingConstants.CENTER));
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				new DbManager();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new MainMenuFrame();
				window.dispose();
			}
		}).run();
	}

}
