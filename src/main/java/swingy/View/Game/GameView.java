/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameView.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 18:51:52 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 18:23:58 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;
import Model.GameMap;
import View.MyFrame;
import View.TmlGame;
import View.GuiGame;
import View.MyFrame;
import Hero.Hero;

public class GameView {

	/*
	**	V A R I A B L E S
	*/

    public GameController controller;
	public boolean GUI;
	public GuiGame GuiG;
	private TmlGame TmlG;
	private Hero hero;
	private GameMap map;


	public GameView(GameController controller, boolean GUI, MyFrame frame, boolean active, Hero hero, GameMap map) {

		// Constructor Variables

		this.controller = controller;
		this.GUI = GUI;

		// Initialization

		GuiG = new GuiGame(controller, this, frame, active, hero, map);
		TmlG = new TmlGame(controller, this, hero, map);
	}








	
	/*
	**	G A M E     L E V E L S
	*/
	
	public void welcomeScreen() {
		
		if (GUI) {
			GuiG.welcomeScreen();
		}
		else {
			TmlG.welcomeScreen();
		}
	}

	public void walk() {
		
		if (GUI) {
			GuiG.walk();
		}
		else {
			TmlG.walk();
		}
	}

	public void win() {
		
		if (GUI) {
			GuiG.win();
		}
		else {
			TmlG.win();
		}
	}

	public void confrontation() {
		
		if (GUI) {
			GuiG.confrontation();
		}
		else {
			TmlG.confrontation();
		}
	}

	public void fight() {
		
		if (GUI) {
			GuiG.fight();
		}
		else {
			TmlG.fight();
		}
	}

	public void looting() {
		
		if (GUI) {
			GuiG.looting();
		}
		else {
			TmlG.looting();
		}
	}

	
	


	/*
	**  Utils
	*/

	public void closeWindows() 	{
		GuiG.closeWindow();
	}










	/*
	**  Getters
	*/

	public boolean getGUI() {
		return GUI;
	}

	public GameController getController() {
		return controller;
	}
}
