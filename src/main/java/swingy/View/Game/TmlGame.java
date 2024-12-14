/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   TmlGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/01 18:08:49 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/14 15:18:46 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import View.MyFrame;
import Controller.GameController;
import Model.GameMap;
import Hero.Hero;
import Model.GameMap;

public class TmlGame {

	/*
    **	V A R I A B L E S
	*/
	
    private GameView view;
    private GameController controller;
    private MyFrame frame;
	Hero Hero;
	GameMap Map;









    /*
    **  C O N S T R U C T O R 
    */
	
	public TmlGame(GameController pController, GameView pView, Hero pHero, GameMap pMap) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
		Hero = pHero;
		Map = pMap;
	}










    /*
    **  W E L C O M E     S C R E E N
    */
    
    public void welcomeScreen() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}
        
    public void walk() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}

    public void win() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}
}
