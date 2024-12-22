/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Controller.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:45:59 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/22 20:42:55 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

import Hero.Hero;
import Model.Model;
import View.View;
import Controller.States;
import Controller.GameController;

public class Controller {

	/*
	** Parameters
	*/
 
	public View view;
	private Model model;
	public States currentState;








	/*
	** M E T H O D S
	*/

	public Controller(String pGUI) {

		// Initialize classes

		view = new View(this, pGUI.equals("gui") ? true : false);
		model = new Model();
		
		currentState = States.STARTGAME;
	}

	public void startGame() {
		view.startGame();
	}

	public void loadSave() {
		view.loadSave();
	}

	public void setHeroName() {
		view.viewSetHeroName();
	}

	public void setHeroClass() {
		view.viewSetHeroClass();
	}





	/*
	**  Create hero before starting game
	*/

	public Hero createHeroController(String g_class, String g_name) {
		return model.ctNewHero(g_class, g_name);
	}

	public void saveHero(Hero pHero) {
		model.saveHero(pHero);
	}





	/*
	**  Starting game
	*/

	public void goToGame() {
		new GameController(model.getHero(), view.getGUIOnOff(), view.getFrame(), view.getActive(), this);
	}










	/*
	** S A V E     S T A T E 
	*/

	public void StateSwitcher() {

		view.closeWindows();

		switch (currentState) {
			case STARTGAME:
				startGame();
				break;
			case SETHERONAME:
				setHeroName();
				break;
			case SETHEROCLASS:
				setHeroClass();
				break;
		}
	}
}