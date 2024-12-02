/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameView.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 18:51:52 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/02 22:00:34 by ahernand         ###   ########.fr       */
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

    private GameController controller;
	protected boolean GUI;
	private GuiGame GuiG;
	private TmlGame TmlG;

	public GameView(GameController _controller, boolean pGUI, MyFrame pFrame, boolean pActive) {

		// Constructor Variables

		controller = _controller;
		GUI = pGUI;

		// Initialization

		GuiG = new GuiGame(controller, this, pFrame, pActive);
		TmlG = new TmlGame(controller, this);
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

	public void walk(Hero pHero, GameMap pMap) {
		
		if (GUI) {
			GuiG.walk(pHero, pMap);
		}
		else {
			TmlG.walk(pHero, pMap);
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
}
