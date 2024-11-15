/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ControllerGame.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:45:59 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/15 20:57:05 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

import Hero.Hero;
import Model.ModelGameLogic;
import View.ViewGame;

public class ControllerGame {

	/*
	** Parameters
	*/

	private ViewGame view = new ViewGame();
	private ModelGameLogic model = new ModelGameLogic();

	/*
	** Methods
	*/

	public ControllerGame() {
		
	}

	/*
	**  Start Screen & Select Hero
	*/

	public void presentGame() {

		String str;

		// Prompt for hero name until a valid one is provided
		
		if (view.GUI) {
			view.GUIpromptForSelectHero();
		}
		else {
			view.printPresenteAndSelectHero();
			str = view.promptForSelectHero();
			do {
				str = view.promptForSelectHero();
			} while (!selectHeroOk(str));
			setHero();
		}
		// Redirects to creation or continue game
	}

	private boolean selectHeroOk(String str) {
		view.cleanScreen();
		if (str.equals("Continue") || str.equals("New Game")) {
			return true;
		}
		return (false);
	}


	/*
	**  Create Hero
	*/

	public void setHero() {

		String name;
		String class_i;

		// Prompt for hero name until a valid one is provided

		do {
			name = view.promptForName();
		} while (!nameOK(name));
		view.printName(name);

		// Prompt for hero class until a valid one is provided

		do {
			class_i = view.promptForClass();
		} while (!classOk(class_i));
		view.printClass(class_i);

		// Create new hero in the model

		Hero h = model.ctNewHero(class_i, name);
		view.printHeroData(h);
	}

	private boolean nameOK(String str) {
		if (str.isEmpty()) {
			view.printErrorName();
			return (false);
		}
		return true;
	}

	private boolean classOk(String str) {
		if (str.equals("Warrior") || str.equals("Wizard") || str.equals("Knight") || str.equals("Archer")) {
			return true;
		}
		else if (!str.isEmpty()) {
			view.printErrorClass();
		}
		view.cleanScreen();
		return (false);
	}
}
