/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   TmlGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/01 18:08:49 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/01 20:02:22 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import View.MyFrame;
import Controller.GameController;

public class TmlGame {

	/*
    **	V A R I A B L E S
	*/
	
    private GameView view;
    private GameController controller;
    private MyFrame frame;










    /*
    **  C O N S T R U C T O R 
    */
	
	public TmlGame(GameController pController, GameView pView) {

		// Assign Constructor Variables

		view = pView;
		controller = pController;
	}










    /*
    **  W E L C O M E     S C R E E N
    */
    
    public void welcomeScreen() {

		// Text Prompt for name

		// JLabel TextToPrint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel TextToPrint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}
        
    public void walk() {

		// Text Prompt for name

		// JLabel TextToPrint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel TextToPrint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}
}
