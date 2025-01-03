/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Model.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 16:43:54 by ahernand          #+#    #+#             */
/*   Updated: 2025/01/03 14:46:16 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import Hero.Hero;
import Hero.heroCreator;
import Model.SQLutils;

public class Model {

	/*
	** Parameters
	*/

	private heroCreator creator = new heroCreator();
	private SQLutils sql = new SQLutils();
	public Hero hero;
		
	/*
	** Methods
	*/

	public Hero ctNewHero(String p_class, String p_name) {

		hero = creator.newHero(p_class, p_name);
		sql.createDB(hero);
		return hero;
	}

	public void saveHero(Hero pHero) {
		hero = pHero;
	}

	public Hero getHero() {
		return hero;
	}
}
