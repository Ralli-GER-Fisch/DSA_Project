package dsa.common.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dsa.common.main.DsaProjectMain;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame {
	public LoginScreen() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Image.class.getResource("/resources/icon.png")));
		//setDefaultLookAndFeelDecorated(true);
		setTitle("DSA-Project Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(250,100));
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel nameLabel = new JLabel("Benutzer");
		JLabel pwLabel = new JLabel("Password");
		JTextField nameField = new JTextField();
		JPasswordField pwField = new JPasswordField();
		JButton loginButton = new JButton("Login");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		getContentPane().add(nameLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		getContentPane().add(nameField, c);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(pwLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		getContentPane().add(pwField, c);
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		getContentPane().add(Box.createHorizontalGlue(), c);
		c.weightx = 0;
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		getContentPane().add(loginButton, c);
		KeyAdapter enterPressed = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					loginButton.doClick();
				}
			}
		};
		loginButton.setActionCommand("login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("login")){
					DsaProjectMain.startProgram(nameField.getText(),String.copyValueOf(pwField.getPassword()));
					dispose();
				}
			}
		});
		getContentPane().addKeyListener(enterPressed);
		loginButton.addKeyListener(enterPressed);
		pwField.addKeyListener(enterPressed);
		nameField.addKeyListener(enterPressed);
		setVisible(true);
	}
}
