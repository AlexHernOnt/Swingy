/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GuiGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 20:32:04 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/02 22:05:06 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Hero.Hero;
import Model.GameMap;
import Controller.GameController;
import View.GameView;
import View.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class GuiGame extends JFrame implements ActionListener {

	/*
    **	V A R I A B L E S
	*/
	
    private GameView view;
    private GameController controller;
    private MyFrame frame;
	private boolean active;










    /*
    **  C O N S T R U C T O R 
    */
	
	public GuiGame(GameController pController, GameView pView, MyFrame pFrame, boolean pActive) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
		frame = pFrame;
		active = pActive;
	}










    /*
    **  W E L C O M E     S C R E E N
    */

	JButton comenzarButton;

    public void welcomeScreen() {

		reOpenWindow();
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		
		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);
		ImageIcon img = new ImageIcon("/home/ahernand/swingy/src/main/java/swingy/View/Game/imgs/house.png");


		// Text to say your name

		JLabel textName = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClassType() + ".");

		textName.setIcon(img);
		textName.setHorizontalTextPosition(JLabel.CENTER);
		textName.setVerticalTextPosition(JLabel.TOP);
		textName.setFont(new Font("Monospaced", Font.PLAIN, 42));
		textName.setIconTextGap(100);
		textName.setHorizontalAlignment(JLabel.CENTER);
		textName.setVerticalAlignment(JLabel.CENTER);
		textName.setBackground(Color.decode(frame.COLOR));
		panel1.add(textName);


		// Text to give some setting

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 500, 1600, 100);
		JLabel textSetting = new JLabel("You come out of your house looking for an adventure!");
		textSetting.setHorizontalTextPosition(JLabel.CENTER);
		textSetting.setVerticalTextPosition(JLabel.BOTTOM);
		textSetting.setFont(new Font("Monospaced", Font.PLAIN, 42));
		textSetting.setBackground(Color.CYAN);
		panel2.add(textSetting);

		// Buttom to start

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 700, 1600, 500);

		comenzarButton = new JButton("Start!");
		comenzarButton.setBounds(697, 0, 200, 70);
		comenzarButton.setFocusable(false);
		comenzarButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		comenzarButton.addActionListener(this);
		panel3.add(comenzarButton);
		panel3.setLayout(null);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.setVisible(true);
	}










    /*
    **  W A L K
    */

	JButton NorthButton;
	JButton EastButton;
	JButton SouthButton;
	JButton WestButton;

    public void walk(Hero pHero, GameMap pMap) {

		reOpenWindow();
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		
		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);

		// Text to present

		JLabel textName = new JLabel("You're standing in an open field.");

		textName.setHorizontalTextPosition(JLabel.CENTER);
		textName.setVerticalTextPosition(JLabel.TOP);
		textName.setFont(new Font("Monospaced", Font.PLAIN, 42));
		textName.setHorizontalAlignment(JLabel.CENTER);
		textName.setVerticalAlignment(JLabel.CENTER);
		textName.setBackground(Color.decode(frame.COLOR));
		panel1.add(textName);

		// Text to ask

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 500, 1600, 100);
		JLabel textSetting = new JLabel("Which direction will you walk?");
		textSetting.setHorizontalTextPosition(JLabel.CENTER);
		textSetting.setVerticalTextPosition(JLabel.BOTTOM);
		textSetting.setFont(new Font("Monospaced", Font.PLAIN, 42));
		textSetting.setBackground(Color.CYAN);
		panel2.add(textSetting);

		// Buttons

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 700, 1600, 300);

		NorthButton = new JButton("North");
		NorthButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		NorthButton.setBounds(350, 0, 200, 70);
		NorthButton.addActionListener(this);
		NorthButton.setFocusable(false);
		
		EastButton = new JButton("East");
		EastButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		EastButton.setBounds(600, 0, 200, 70);
		EastButton.addActionListener(this);
		EastButton.setFocusable(false);

		SouthButton = new JButton("South");
		SouthButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		SouthButton.setBounds(850, 0, 200, 70);
		SouthButton.addActionListener(this);
		SouthButton.setFocusable(false);

		WestButton = new JButton("West");
		WestButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		WestButton.setBounds(1100, 0, 200, 70);
		WestButton.addActionListener(this);
		WestButton.setFocusable(false);

		panel3.setLayout(null);
		panel3.add(NorthButton);
		panel3.add(EastButton);
		panel3.add(SouthButton);
		panel3.add(WestButton);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.setVisible(true);
	}




















    /*
    ** O N     M A P
    */










    /*
    ** E V E N T     L I S T E N E R
    */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == comenzarButton) {
			System.out.println("Kill yourself");
			controller.walk();
		}

		// if (e.getSource() == setHeroButtonContinue) {
		// 	System.out.println("Na, im not coding this yet lol");
		// }
		// else if (e.getSource() == setHeroButtonNewGame) {
		// 	controller.setHeroName();
		// }
		// else if (e.getSource() == nameHeroButton) {
		// 	view.heroName = nameTextField.getText();
		// 	if (nameTextField.getText().trim().isEmpty()) {
 		// 	   JOptionPane.showMessageDialog(this, "Name cannot be empty!");
		// 	}
		// 	else {
		// 		controller.setHeroClass();
		// 	}
		// }
		// else if (e.getSource() == ClassWarriorButton) {
		// 	view.heroClass = "Warrior";
		// 	controller.createHeroController("Warrior", view.heroName);
		// 	controller.goToGame();
		// }
		// else if (e.getSource() == ClassWizardButton) {
		// 	view.heroClass = "Wizard";
		// 	controller.createHeroController("Wizard", view.heroName);
		// 	controller.goToGame();
		// }
		// else if (e.getSource() == ClassKnightButton) {
		// 	view.heroClass = "Knight";
		// 	controller.createHeroController("Knight", view.heroName);
		// 	controller.goToGame();
		// }
		// else if (e.getSource() == ClassArcherButton) {
		// 	view.heroClass = "Archer";
		// 	controller.createHeroController("Archer", view.heroName);
		// 	controller.goToGame();
		// }
	}










    /*
    ** W I N D O W     M A N A G M E N T
    */


	protected void closeWindow() {
		view.GUI = false;
		active = false;
		frame.dispose();
		frame = null;
		// controller.StateSwitcher();
	}

	public void reOpenWindow() {
		if (view.GUI == true && !active) {
			System.err.println("Opening Window Again");
			active = true;
			frame = new MyFrame();
			frame.setGameController(controller);
		}
	}
}
