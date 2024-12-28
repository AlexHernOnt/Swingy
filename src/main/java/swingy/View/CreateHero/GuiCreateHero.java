/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GuiCreateHero.java                                 :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/22 18:38:20 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/28 17:10:01 by ahernand         ###   ########.fr       */
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
import View.View;
import View.ToolsGUI;
import View.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; // delete this too after clean up
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import Model.SQLutils;


public class GuiCreateHero extends JFrame implements ActionListener {

    /*
    **  V A R I A B L E S
    */

	private static final String introImg = "/home/ahernand/swingy/src/main/java/swingy/View/CreateHero/imgs/intro.png";
	private static final String inputImg = "/home/ahernand/swingy/src/main/java/swingy/View/CreateHero/imgs/input.png";
	private static final String classImg = "/home/ahernand/swingy/src/main/java/swingy/View/CreateHero/imgs/class.png";

	private SQLutils sql = new SQLutils();

    private View view;
    private Controller controller;

    private MyFrame frame;
	private boolean active;
	private ToolsGUI toolsGui;

	private JPanel panelOnTop;
	private JPanel panelMiddle;
	private JPanel panelBottom;

	private JLabel labelOnTop;
	private JLabel labelMiddle;










    /*
    **  C O N S T R U C T O R
    */

	public GuiCreateHero(Controller pController, View pView) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
		active = false;

		toolsGui = new ToolsGUI();

		panelOnTop = new JPanel();
		panelMiddle = new JPanel();
		panelBottom = new JPanel();

		labelOnTop = new JLabel();
		labelMiddle = new JLabel();

		toolsGui.confLabel(labelOnTop, null);
		toolsGui.confLabel(labelMiddle, null);

		panelOnTop.setBounds(0, 100, 1600, 500);
		panelMiddle.setBounds(0, 500, 1600, 100);
		panelBottom.setBounds(0, 700, 1600, 300);
	}










    /*
    **  S T A R T     G A M E
    */

	JButton ContinueButton;
	JButton NewGameButton;
	JButton exitGameButton;


	public void startGame() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(introImg));
		labelOnTop.setText("Welcome to Swingy!");
		labelMiddle.setText("Choose an option: ");

		// Making Buttons
		
		ContinueButton = toolsGui.confButton(ContinueButton, "Continue", 450, 0, this);
		NewGameButton = toolsGui.confButton(NewGameButton, "New Game", 700, 0, this);
		exitGameButton = toolsGui.confButton(exitGameButton, "Exit", 950, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(ContinueButton);
		panelBottom.add(NewGameButton);
		panelBottom.add(exitGameButton);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}










    /*
    **  L A O D     S A V E
    */

	JButton GoBack;
	JButton saveFile1;
	JButton saveFile2;
	JButton saveFile3;

	public void loadSave() {

		toolsGui.reOpenWindow(this);
		
		// Making Text
		
		labelOnTop.setIcon(new ImageIcon("nothing"));
		labelOnTop.setText("Choose a save file.");


		// Making Buttons

		saveFile1 = toolsGui.confFullButton(saveFile1, sql.getNameFromSave(1) + " - " + "Level " + sql.getLevelFromSave(1) + " " + sql.getArtifactsPrintable(1), 465, 200, 650, 70, this);
		saveFile2 = toolsGui.confFullButton(saveFile2, sql.getNameFromSave(2) + " - " + "Level " + sql.getLevelFromSave(2) + " " + sql.getArtifactsPrintable(2), 465, 300, 650, 70, this);
		saveFile3 = toolsGui.confFullButton(saveFile3, sql.getNameFromSave(3) + " - " + "Level " + sql.getLevelFromSave(3) + " " + sql.getArtifactsPrintable(3), 465, 400, 650, 70, this);
		
		GoBack = toolsGui.confButton(GoBack, "Go back", 697, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		
		panelOnTop.setLayout(null);
		panelOnTop.add(saveFile1);
		panelOnTop.add(saveFile2);
		panelOnTop.add(saveFile3);

		panelBottom.setLayout(null);
		panelBottom.add(GoBack);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}










	/*
	**  S E T    H E R O     N A M E
	*/

	JButton nameHeroButton;
	JTextField nameTextField;

	public void SetHeroName() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(inputImg));
		labelOnTop.setText("Write your hero's name:");
		
		// Button

		nameHeroButton = toolsGui.confButton(nameHeroButton, "Confirmar", 1000, 0, this);

		// TextField

		nameTextField = toolsGui.confTextField(nameTextField, 450, 0, 500);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelBottom.setLayout(null);
		panelBottom.add(nameTextField);
		panelBottom.add(nameHeroButton);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelBottom);
		frame.setVisible(true);
	}










	/*
	**  S E T     H E R O     C L A S S
	*/

	JButton ClassWarriorButton;
	JButton ClassWizardButton;
	JButton ClassKnightButton;
	JButton ClassArcherButton;

	public void SetHeroClass() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(classImg));
		labelOnTop.setText("Your name is : " + view.heroName);
		labelMiddle.setText("Choose a class:");

		// Making Buttons

		ClassWarriorButton = toolsGui.confButton(ClassWarriorButton, "Warrior", 350, 0, this);
		ClassWizardButton = toolsGui.confButton(ClassWizardButton, "Wizard", 600, 0, this);
		ClassKnightButton = toolsGui.confButton(ClassKnightButton, "Knight", 850, 0, this);
		ClassArcherButton = toolsGui.confButton(ClassArcherButton, "Archer", 1100, 0, this);

		// Adding to panels
		
		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(ClassWarriorButton);
		panelBottom.add(ClassWizardButton);
		panelBottom.add(ClassKnightButton);
		panelBottom.add(ClassArcherButton);


		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}









    /*
    ** E V E N T     L I S T E N E R
    */

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		**	tartGame()
		*/

		if (e.getSource() == ContinueButton) {
			controller.loadSave();
		}
		else if (e.getSource() == NewGameButton) {
			controller.setHeroName();
		}
		else if (e.getSource() == exitGameButton) {
			System.exit(0);
		}





		/*
		**	loadSave()
		*/

		else if (e.getSource() == saveFile1) {
			controller.saveHero(sql.createHeroObjFromEntry(1));
			controller.goToGame();

		} else if (e.getSource() == saveFile2) {
			controller.saveHero(sql.createHeroObjFromEntry(2));
			controller.goToGame();

		} else if (e.getSource() == saveFile3) {
			controller.saveHero(sql.createHeroObjFromEntry(3));
			controller.goToGame();
		} else if (e.getSource() == GoBack) {
			controller.startGame();
		}





		/*
		**	SetHeroName()
		*/

		else if (e.getSource() == nameHeroButton) {
			
			if (nameTextField.getText().trim().isEmpty()) {
 			   JOptionPane.showMessageDialog(this, "Name cannot be empty!");
			}
			else {
				view.heroName = nameTextField.getText();
				controller.setHeroClass();
			}
		}





		/*
		**	SetHeroClass()
		*/

		else if (e.getSource() == ClassWarriorButton) {
			view.heroClass = "Warrior";
			controller.createHeroController("Warrior", view.heroName);
			controller.goToGame();
		}
		else if (e.getSource() == ClassWizardButton) {
			view.heroClass = "Wizard";
			controller.createHeroController("Wizard", view.heroName);
			controller.goToGame();
		}
		else if (e.getSource() == ClassKnightButton) {
			view.heroClass = "Knight";
			controller.createHeroController("Knight", view.heroName);
			controller.goToGame();
		}
		else if (e.getSource() == ClassArcherButton) {
			view.heroClass = "Archer";
			controller.createHeroController("Archer", view.heroName);
			controller.goToGame();
		}
	}

	protected void closeWindow() {
		view.GUI = false;
		active = false;
		frame.dispose();
		frame = null;
	}










	/*
	** Getters
	*/

	public MyFrame getFrame() {
		return frame;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean newActive) {
		active = newActive;
	}

	public void setFrame(MyFrame newFrame) {
		frame = newFrame;
		frame.setController(controller);
	}

	public boolean getGUI() {
		return view.GUI;
	}





	// 	Panel Getters

	public JPanel getPanelOnTop() {
		return panelOnTop;
	}

	public JPanel getPanelMiddle() {
		return panelMiddle;
	}

	public JPanel getPanelBottom() {
		return panelBottom;
	}

}