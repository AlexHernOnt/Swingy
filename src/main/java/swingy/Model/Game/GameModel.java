/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameModel.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:49:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/02 19:59:22 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import Hero.Hero;
import Model.GameMap;

public class GameModel {

	/*
	**		V A R I A B L E S
	*/

	private Hero _hero;
	private GameMap map;









	/*
	**		C O N S T R U C T O R
	*/

	public GameModel(Hero pHero) {
		_hero = pHero;
		map = new GameMap(_hero.getLevel());
		map.placeHero(pHero);
	}

	public Hero getHero() {
		return _hero;
	}
}