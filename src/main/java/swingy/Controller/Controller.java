/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Controller.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:45:59 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/27 20:19:21 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

import Hero.Hero;
import Model.Model;
import View.View;
import Controller.States;

public class Controller {

	/*
	** Parameters
	*/
 
	public View view;
	public Model model;
	public States currentState;








	/*
	** M E T H O D S
	*/

	public Controller(String pGUI) {

		// Initialize classes

		view = new View(this, pGUI.equals("GUI") ? true : false);
		model = new Model();
		
		currentState = States.PRESENTGAME;
	}

	public void presentGame() {
		view.showPresentation();
	}

	public void setHeroName() {
		view.viewSetHeroName();
	}

	public void setHeroClass() {
		view.viewSetHeroClass();
	}

	public Hero createHeroController(String g_class, String g_name) {
		return model.ctNewHero(g_class, g_name);
	}










	/*
	** S A V E     S T A T E 
	*/

	public void StateSwitcher() {
		switch (currentState) {
			case PRESENTGAME:
				presentGame();
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