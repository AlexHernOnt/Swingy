/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ControllerGame.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:45:59 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/03 20:26:32 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Controller;

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

	public void presentGame() {
		view.printPresentGame();
	}

	public void setHero() {

		String name;
		String class_i;

	    // Prompt for hero name until a valid one is provided
		do {
			name = view.promptForName();
		} while (name.isEmpty());
		view.printName(name);

		// Prompt for hero class until a valid one is provided
		do {
			class_i = view.promptForClass();
		} while (class_i.isEmpty() || !classOk(class_i));
		view.printClass(class_i);

   		// Create new hero in the model
		model.ctNewHero(name, class_i);
	}

	/*
	** Parsing
	*/
	
	private boolean classOk(String str) {
		if (str.equals("Warrior") || str.equals("Wizard") || str.equals("Knight") || str.equals("Archer")) {
			return true;
		}
		view.printErrorClass();
		return (false);
	}
}
