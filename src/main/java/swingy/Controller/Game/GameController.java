/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameController.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:27:36 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/20 15:28:54 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

import Hero.Hero;
import Model.GameModel;
import View.GameView;
import View.MyFrame;
import Controller.Controller;
import Controller.StatesGame;

public class GameController {

	/*
	** Parameters
	*/
 
	private GameView view;
	private GameModel model;
	private Controller mainController;
	public StatesGame currentState;










	/*
	** M E T H O D S
	*/

	public GameController(Hero pH, boolean pGUI, MyFrame frame, boolean active, Controller pMainController) {

		// Initialize classes

		model = new GameModel(pH);
		view = new GameView(this, pGUI, frame, active, pH, model.getMap());
		mainController = pMainController;

		welcomeScreen();
		// currentState = States.STARTGAME;
	}

    public void welcomeScreen() {
	
		model.resetHeroInMap();
        view.welcomeScreen();
    }

	public void walk() {
		view.walk();
	}

	public void win() {
		view.win();
	}

	public void confrontation() {
		view.confrontation();
	}

	public void fight() {
		view.fight();
	}

	public void looting() {
		view.looting();
	}
	
	public void goStart() {
		mainController.startGame();
	}









	/*
	** S A V E     S T A T E 
	*/

	public Hero getHero() {
		return model.getHero();
	}










	/*
	** S A V E     S T A T E 
	*/

	public void StateSwitcher() {

		System.out.println("INCREDIBLE WORK !");
		// view.closeWindows();
		// switch (currentState) {
		// 	case STARTGAME:
		// 		startGame();
		// 		break;
		// 	case SETHERONAME:
		// 		setHeroName();
		// 		break;
		// 	case SETHEROCLASS:
		// 		setHeroClass();
		// 		break;
		// }
	}










	/*
	** Setters
	*/
}