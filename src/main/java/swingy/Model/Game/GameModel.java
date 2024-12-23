/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameModel.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:49:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 18:59:06 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import java.util.Random;

import Controller.GameController;
import Hero.Hero;
import Model.GameMap;

public class GameModel {

	/*
	**	V A R I A B L E S
	*/

	private Hero hero;
	private GameMap map;
	private GameController Controller;
	private Random rand = new Random();









	/*
	**	C O N S T R U C T O R
	*/

	public GameModel(GameController Controller, Hero hero) {
		
		this.hero = hero;
		this.Controller = Controller;
	
		map = new GameMap();
	}

	public Hero getHero() {
		return hero;
	}

	public GameMap getMap() {
		return map;
	}

	public void resetHeroInMap() {
		map.placeHeroStart(hero);
	}










	/*
	**	M E T H O D S
	*/

	public void positionCheck() {
		
		System.out.println("Y: " + hero.getPosY() + " _ X: " + hero.getPosX());

		if (map.offLimits(hero.getPosY(), hero.getPosX())) {
			Controller.win();
		} else if (map.enemy(hero.getPosY(), hero.getPosX()) >= 0) {
			Controller.confrontation();
		} else {
			Controller.walk();
		}
	}	




	public void runChancesResolve() {

		if (rand.nextInt(2) == 1) { // from 0 includive to 2 exclusive)
			Controller.fight();
		} else {
			Controller.walk();
		}
	}
}