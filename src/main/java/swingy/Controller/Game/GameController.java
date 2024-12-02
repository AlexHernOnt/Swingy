/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameController.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:27:36 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/02 22:00:28 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

import Hero.Hero;
import Model.GameModel;
import View.GameView;
import View.MyFrame;
import Controller.StatesGame;

public class GameController {

	/*
	** Parameters
	*/
 
	private GameView view;
	private GameModel model;
	public StatesGame currentState;










	/*
	** M E T H O D S
	*/

	public GameController(Hero pH, boolean pGUI, MyFrame frame, boolean active) {

		// Initialize classes

		view = new GameView(this, pGUI, frame, active);
		model = new GameModel(pH);
		
		welcomeScreen();
		// currentState = States.PRESENTGAME;
	}

    public void welcomeScreen() {
        view.welcomeScreen();        
    }

	public void walk() {
		view.walk(model.getHero(), model.getMap());
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
		// 	case PRESENTGAME:
		// 		presentGame();
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