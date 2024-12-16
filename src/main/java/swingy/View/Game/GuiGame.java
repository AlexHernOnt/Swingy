/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GuiGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 20:32:04 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/16 21:02:07 by ahernand         ###   ########.fr       */
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
import java.util.Random;

import Hero.Hero;
import Model.GameMap;
import Controller.GameController;
import View.GameView;
import View.MyFrame;
import View.ToolsGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font; // DELETE AFTER TO GUI
import java.awt.GridLayout;
import java.awt.Image;




public class GuiGame extends JFrame implements ActionListener {

	/*
    **	V A R I A B L E S
	*/

	private Random rand = new Random();

	private static final String winImg = "/home/ahernand/swingy/src/main/java/swingy/View/Game/imgs/win.png";
	private static final String houseImg = "/home/ahernand/swingy/src/main/java/swingy/View/Game/imgs/house.png";
	private static final String worldImg = "/home/ahernand/swingy/src/main/java/swingy/View/Game/imgs/world.png";
	private static final String enemyImg = "/home/ahernand/swingy/src/main/java/swingy/View/Game/imgs/enemy.png";
	
    private GameView view;
    private GameController controller;
    private MyFrame frame;
	private boolean active;
	private GameMap ptr_map;
	private Hero h;
	private ToolsGUI toolsGui;

	private JPanel panelOnTop;
	private JPanel panelMiddle;
	private JPanel panelBottom;

	private JLabel labelOnTop;
	private JLabel labelMiddle;



    /*
    **  C O N S T R U C T O R 
    */
	
	public GuiGame(GameController pController, GameView pView, MyFrame pFrame, boolean pActive, Hero pHero, GameMap pMap) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
		frame = pFrame;
		active = pActive;
		h = pHero;
		ptr_map = pMap;

		toolsGui = new ToolsGUI();

		panelOnTop = new JPanel();
		panelMiddle = new JPanel();
		panelBottom = new JPanel();

		labelOnTop = new JLabel();
		labelMiddle = new JLabel();

		toolsGui.confLabel(labelOnTop, null);
		toolsGui.confLabel(labelMiddle, null);
		
		panelOnTop.setBounds(0, 100,1600, 300);
		panelMiddle.setBounds(0, 500, 1600, 100);
		panelBottom.setBounds(0, 700, 1600, 300);

	}











    /*
    **  W E L C O M E     S C R E E N
    */

	JButton comenzarButton;

    public void welcomeScreen() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(houseImg));
		labelOnTop.setText("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClassType() + ".");
		labelMiddle.setText("You come out of your house looking for an adventure!");

		// Making Buttons
		
		comenzarButton = toolsGui.confButton(comenzarButton, " Start!", 697, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(comenzarButton);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}










    /*
    **  W A L K
    */
	

	JButton NorthButton;
	JButton EastButton;
	JButton SouthButton;
	JButton WestButton;

    public void walk() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(worldImg));
		labelOnTop.setText("You are at X " + (h.getPosX() + 1) + " / " + (ptr_map.getSize() + 1) + ". And Y " + (h.getPosY() + 1) + " / " + (ptr_map.getSize() + 1) + ".");
		labelMiddle.setText("Which direction will you walk?");
		
		// Making Buttons

		NorthButton = toolsGui.confButton(NorthButton, "North", 350, 0, this);
		EastButton = toolsGui.confButton(EastButton, "East", 600, 0, this);
		SouthButton = toolsGui.confButton(SouthButton, "South", 850, 0, this);
		WestButton = toolsGui.confButton(WestButton, "West", 1100, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(NorthButton);
		panelBottom.add(EastButton);
		panelBottom.add(SouthButton);
		panelBottom.add(WestButton);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}








    /*
    **  C O N F R O N T A T I O N
    */

	JButton FightButton;
	JButton RunButton;

    public void confrontation() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(enemyImg));
		labelOnTop.setText("You face a terrible lvl " + ptr_map.enemy(h.getPosX(), h.getPosY()) + " creature before you.");
		labelMiddle.setText("Do you want to face it? (You're level) " + h.getLevel() + ".");

		// Making Buttons

		FightButton = toolsGui.confButton(FightButton, "Yes, Fight!", 550, 0, this);
		RunButton = toolsGui.confButton(RunButton, "No, Run!", 850, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(FightButton);
		panelBottom.add(RunButton);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}










    /*
    **  F I G H T
    */

	JButton FightResult;
	boolean fightWon;

    public void fight() {

		toolsGui.reOpenWindow(this);

		if (fightAlgo(h) == true) {

			fightWon = true;
			
			// Making Text
		
			labelOnTop.setIcon(new ImageIcon("enemyImg"));
			labelOnTop.setText("The fight was fierced, intense and deadly.");
			labelMiddle.setText("You see your foe's desecreated body.");

			// Making Buttons

			FightResult = toolsGui.confButton(FightResult, "Loot it", 697, 0, this);
		
		} else {

			fightWon = false;

			// Making Text

			labelOnTop.setIcon(new ImageIcon("nothing"));
			labelOnTop.setText("You gave all you had in the fight, however you failed");
			labelMiddle.setText("You know this is the last second of your life.");
			
			// Making Buttons

			FightResult = toolsGui.confButton(FightResult, "Bye...", 697, 0, this);
		}

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(FightResult);

		// Adding to frames

		frame.add(panelOnTop);
		frame.add(panelMiddle);
		frame.add(panelBottom);
		frame.setVisible(true);
	}

	private boolean fightAlgo(Hero h) {





		
		return (false);
	}







	/*
    **  W I N
    */

	JButton NextLevelButton;
	JButton MainMenuButton;

    public void win() {

		toolsGui.reOpenWindow(this);
		
		// Making Text

		labelOnTop.setIcon(new ImageIcon(winImg));
		labelOnTop.setText("You have discovered the end frontier.");
		labelMiddle.setText("Will you start a new adventure?");

		// Making Buttons

		NextLevelButton = toolsGui.confButton(NextLevelButton, "Yes!", 550, 0, this);
		MainMenuButton = toolsGui.confButton(MainMenuButton, "Main Menu", 850, 0, this);

		// Adding to panels

		panelOnTop.add(labelOnTop);
		panelMiddle.add(labelMiddle);

		panelBottom.setLayout(null);
		panelBottom.add(NextLevelButton);
		panelBottom.add(MainMenuButton);

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

		// Walk
System.err.println("Clicked!");
		if (e.getSource() == comenzarButton) {
			controller.walk();
			positionCheck();
		}

		// Directions
		
		else if (e.getSource() == NorthButton) {
			h.goNorth();
			positionCheck();
		}
		else if (e.getSource() == EastButton) {
			h.goEast();
			positionCheck();
		}
		else if (e.getSource() == SouthButton) {
			h.goSouth();
			positionCheck();
		}
		else if (e.getSource() == WestButton) {
			h.goWest();
			positionCheck();
		}

		// Confrontation

		else if (e.getSource() == FightButton) {
			controller.fight();
		}
		else if (e.getSource() == RunButton) {
			
			if (rand.nextInt(2) == 1) { // from 0 includive to 2 exclusive)
				controller.fight();
			} else {
				controller.walk();
			}
		}

		// Fight
		
		else if (e.getSource() == FightResult) {
			if (fightWon == true) {
				controller.walk();
			}
			else {
				controller.goStart();
			}
		}

		// Win

		else if (e.getSource() == NextLevelButton) {
			controller.welcomeScreen();
		}
		else if (e.getSource() == MainMenuButton) {
			controller.goStart();
		}
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

	private void positionCheck() {
		
		System.err.println("Y: " + h.getPosY() + " _ X: " + h.getPosX());

		if (ptr_map.offLimits(h.getPosY(), h.getPosX())) {
			controller.win();
		} else if (ptr_map.enemy(h.getPosY(), h.getPosX()) >= 0) {
			System.out.println("got into confrontation");
			controller.confrontation();
		} else {
			System.out.println("got into walk");
			controller.walk();
		}
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
	}

	public boolean getGUI() {
		return view.GUI;
	}










	/*
	**	Panel Getters
	*/

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
