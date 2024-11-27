/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ViewCreateHero.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/22 18:38:20 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/27 20:35:13 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Hero.Hero;
import View.View;
import swingy.View.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class ViewCreateHero extends JFrame implements ActionListener{

    // V A R I A B L E S

    public View view;
    public Controller controller;
    public MyFrame frame;






	public ViewCreateHero(Controller pController,View pView) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
	}



    /*
    **  N E W     G A M E     O R     C O N T I N U E
    */

	JButton setHeroButtonContinue;
	JButton setHeroButtonNewGame;
	
	public void GUIpromptForSelectHero() {

		reOpenWindow();
		ImageIcon img = new ImageIcon("/home/ahernand/swingy/src/main/java/swingy/View/tools/intro_img.png");

		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);


		// Welcome Label

		JLabel welcome = new JLabel("Welcome to Swingy!");
	
		welcome.setIcon(img);
		welcome.setHorizontalTextPosition(JLabel.CENTER);
		welcome.setVerticalTextPosition(JLabel.TOP);
		welcome.setFont(new Font("Monospaced", Font.PLAIN, 42));
		welcome.setIconTextGap(100);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setVerticalAlignment(JLabel.CENTER);
		welcome.setBackground(Color.decode(frame.COLOR));
		panel1.add(welcome);


		// Choose menu

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 500, 1600, 100);

		JLabel chooseSelectMode = new JLabel("Choose an option: ");
		chooseSelectMode.setHorizontalTextPosition(JLabel.CENTER);
		chooseSelectMode.setVerticalTextPosition(JLabel.BOTTOM);
		chooseSelectMode.setFont(new Font("Monospaced", Font.PLAIN, 42));
		chooseSelectMode.setBackground(Color.CYAN);
		panel2.add(chooseSelectMode);

		// Buttons

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 700, 1600, 500);

		// JButton[] setHeroButton = new JButton[2];
		setHeroButtonContinue = new JButton("Continue");
		setHeroButtonNewGame = new JButton("New Game");
		
		setHeroButtonContinue.setBounds(550, 0, 200, 70);
		setHeroButtonContinue.setFocusable(false);
		setHeroButtonContinue.setFont(new Font("Monospaced", Font.PLAIN, 21));
		setHeroButtonContinue.addActionListener(this);

		setHeroButtonNewGame.setBounds(850, 0, 200, 70);
		setHeroButtonNewGame.setFocusable(false);
		setHeroButtonNewGame.setFont(new Font("Monospaced", Font.PLAIN, 21));
		setHeroButtonNewGame.addActionListener(this);
		
		panel3.setLayout(null);
		panel3.add(setHeroButtonContinue);
		panel3.add(setHeroButtonNewGame);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		frame.setVisible(true);
	}










	/*
	**  S E T H E R ' S     N A M E
	*/

	JButton nameHeroButton;
	JTextField nameTextField;

	public void GUIpromptForName() {

		reOpenWindow();
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		
		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);

		// Text Prompt for name

		JLabel herosName = new JLabel("Write your hero's name:");
	
		herosName.setHorizontalTextPosition(JLabel.CENTER);
		herosName.setVerticalTextPosition(JLabel.TOP);
		herosName.setFont(new Font("Monospaced", Font.PLAIN, 42));
		herosName.setHorizontalAlignment(JLabel.CENTER);
		herosName.setVerticalAlignment(JLabel.CENTER);
		herosName.setBackground(Color.decode(frame.COLOR));
		panel1.add(herosName);

		// Panel 2

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 700, 1600, 300);

		// TextField 

		nameTextField = new JTextField();
		nameTextField.setBounds(450, 0, 500, 70); 
		nameTextField.setPreferredSize(new Dimension(500, 70));
		nameTextField.setFont(new Font("Monospaced", Font.PLAIN, 42));
		nameTextField.setHorizontalAlignment(JLabel.CENTER);

		// Buttons

		nameHeroButton = new JButton("Confirmar");
		nameHeroButton.setBounds(1000, 0, 200, 70);
		nameHeroButton.setFocusable(false);
		nameHeroButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		nameHeroButton.addActionListener(this);

		// Induction
		
		panel2.setLayout(null);
		panel2.add(nameTextField);
		panel2.add(nameHeroButton);

		frame.add(panel1);
		frame.add(panel2);

		frame.setVisible(true);
	}










	/*
	**  S E T     H E R O ' S     C L A S S
	*/

	JButton ClassWarriorButton;
	JButton ClassWizardButton;
	JButton ClassKnightButton;
	JButton ClassArcherButton;

	public void GUIpromptForClass() {

		reOpenWindow();
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		
		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);

		// Text Prompt for name

		JLabel herosName = new JLabel("Your name is : " + view.heroName);
	
		herosName.setHorizontalTextPosition(JLabel.CENTER);
		herosName.setVerticalTextPosition(JLabel.TOP);
		herosName.setFont(new Font("Monospaced", Font.PLAIN, 42));
		herosName.setHorizontalAlignment(JLabel.CENTER);
		herosName.setVerticalAlignment(JLabel.CENTER);
		herosName.setBackground(Color.decode(frame.COLOR));
		panel1.add(herosName);

		// Panel 2

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 500, 1600, 100);

		// Label: Choose a Class

		JLabel chooseClass = new JLabel("Choose a class:");
		chooseClass.setHorizontalTextPosition(JLabel.CENTER);
		chooseClass.setVerticalTextPosition(JLabel.BOTTOM);
		chooseClass.setFont(new Font("Monospaced", Font.PLAIN, 42));
		panel2.add(chooseClass);

		// Panel 3

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 700, 1600, 300);

		// Buttons

		ClassWarriorButton = new JButton("Warrior");
		ClassWarriorButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		ClassWarriorButton.setBounds(350, 0, 200, 70);
		ClassWarriorButton.addActionListener(this);
		ClassWarriorButton.setFocusable(false);
		
		ClassWizardButton = new JButton("Wizard");
		ClassWizardButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		ClassWizardButton.setBounds(600, 0, 200, 70);
		ClassWizardButton.addActionListener(this);
		ClassWizardButton.setFocusable(false);

		ClassKnightButton = new JButton("Knight");
		ClassKnightButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		ClassKnightButton.setBounds(850, 0, 200, 70);
		ClassKnightButton.addActionListener(this);
		ClassKnightButton.setFocusable(false);

		ClassArcherButton = new JButton("Archer");
		ClassArcherButton.setFont(new Font("Monospaced", Font.PLAIN, 21));
		ClassArcherButton.setBounds(1100, 0, 200, 70);
		ClassArcherButton.addActionListener(this);
		ClassArcherButton.setFocusable(false);

		// Induction
		
		panel3.setLayout(null);
		panel3.add(ClassWarriorButton);
		panel3.add(ClassWizardButton);
		panel3.add(ClassKnightButton);
		panel3.add(ClassArcherButton);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		frame.setVisible(true);
	}










    /*
    ** Start game (Delete, it's tmp)
    */

    public void GUIStartGame() {

		reOpenWindow();
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		
		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);

		// Text Prompt for name

		JLabel TextToPrint = new JLabel("Your name is: " + view.heroName + ", a true " + view.heroClass + ".");
		TextToPrint.setHorizontalTextPosition(JLabel.CENTER);
		TextToPrint.setVerticalTextPosition(JLabel.TOP);
		TextToPrint.setFont(new Font("Monospaced", Font.PLAIN, 42));
		TextToPrint.setHorizontalAlignment(JLabel.CENTER);
		TextToPrint.setVerticalAlignment(JLabel.CENTER);
		TextToPrint.setBackground(Color.decode(frame.COLOR));

		panel1.add(TextToPrint);
		frame.add(panel1);
		frame.setVisible(true);
	}










    /*
    ** E V E N T     L I S T E N E R
    */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == setHeroButtonContinue) {
			System.out.println("Na, im not coding this yet lol");
		}
		else if (e.getSource() == setHeroButtonNewGame) {
			controller.setHeroName();
		}
		else if (e.getSource() == nameHeroButton) {
			view.heroName = nameTextField.getText();
			controller.setHeroClass();
		}
		else if (e.getSource() == ClassWarriorButton) {
			view.heroClass = "Warrior";
			controller.createHeroController("Warrior", view.heroName);
			GUIStartGame();
		}
		else if (e.getSource() == ClassWizardButton) {
			view.heroClass = "Wizard";
			controller.createHeroController("Wizard", view.heroName);
			GUIStartGame();
		}
		else if (e.getSource() == ClassKnightButton) {
			view.heroClass = "Knight";
			controller.createHeroController("Knight", view.heroName);
			GUIStartGame();
		}
		else if (e.getSource() == ClassArcherButton) {
			view.heroClass = "Archer";
			controller.createHeroController("Archer", view.heroName);
			GUIStartGame();
		}
	}


	public void closeWindow() {
		view.GUI = false;
		frame.dispose();
		frame = null;
		controller.StateSwitcher();
	}

	public void reOpenWindow() {
		if (view.GUI == true) {
			System.err.println("Opening Window Again");
			frame = new MyFrame(controller);
		}
	}
}