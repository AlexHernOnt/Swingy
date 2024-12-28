/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameController.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:27:36 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/28 18:41:47 by ahernand         ###   ########.fr       */
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

	private boolean fightResult;










	/*
	** M E T H O D S
	*/

	public GameController(Hero hero, boolean isGUI, MyFrame frame, boolean active, Controller mainController) {

		// Initialize classes

		this.model = new GameModel(this, hero);
		this.view = new GameView(this, isGUI, frame, active, hero, model.getMap());
		this.mainController = mainController;

		welcomeScreen();
		currentState = StatesGame.WELCOMESCREEN;
	}

	public void goStart() {
		mainController.startGame();
	}

    public void welcomeScreen() {
		currentState = StatesGame.WELCOMESCREEN;
		
		model.resetHeroInMap();
        view.welcomeScreen();
    }

	public void walk() {
		currentState = StatesGame.WALK;
		view.walk();
	}

	public void confrontation() {
		currentState = StatesGame.CONFRONTATION;
		view.confrontation();
	}

	public void fight() {
		currentState = StatesGame.FIGHT;
		view.fight();
	}

	public void looting() {
		currentState = StatesGame.LOOTING;
		view.looting();
	}
	
	public void win() {
		currentState = StatesGame.WIN;
		view.win();
	}







	/*
	** Connect with logic
	*/

	public void positionCheck() {
		model.positionCheck();
	}

	public void runChancesResolve() {
		model.runChancesResolve();
	}

	public boolean  fightAlgo() {
		return model.fightAlgo();
	}




	/*
	** S A V E     S T A T E 
	*/

	public Hero getHero() {
		return model.getHero();
	}

	public boolean getFightResult() {
		return fightResult;
	}





	




	/*
	** S A V E     S T A T E 
	*/

	public void StateSwitcher() {

		view.closeWindows();

		switch (currentState) {
			case WELCOMESCREEN:
				welcomeScreen();
				break;
			case WALK:
				walk();
				break;
			case CONFRONTATION:
				confrontation();
				break;
			case FIGHT:
				fight();
				break;
			case LOOTING:
				looting();
				break;
			case WIN:
				win();
				break;
		}
	}
}