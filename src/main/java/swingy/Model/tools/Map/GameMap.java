/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameMap.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/02 16:29:11 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/15 20:19:41 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import java.util.Random;
import Hero.Hero;

public class GameMap {

	/*
    **	V A R I A B L E S
	*/
	
    private int map[][];










    /*
    **  C O N S T R U C T O R 
    */
	
	public GameMap(int lvl) {

		// Assign Constructor Variables
		createMap(lvl);
		fillWithEnemies();
	}










    /*
    **  C R E A T E     M A P
    */

	private Random rand = new Random();

	private void createMap(int lvl) {

		int size;

		size = (lvl - 1) * 5 + 10 - (lvl % 2);
		System.err.println("Size of map = " + size + ".");
		
		map = new int[size][size];
	}

	private void fillWithEnemies() {

		// Fill, baby, fill

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; j++) {

				int rnd = rand.nextInt(20) + 1;
				
				if (rnd == 1) {
					map[i][j] = 1;
				}
				if (rnd == 5) {
					map[i][j] = 2;
				}
				if (rnd == 10) {
					map[i][j] = 3;
				}
				if (rnd == 15) {
					map[i][j] = 4;
				}
			}
		}
		printMap();
	}

	public boolean offLimits(int x, int y) {

		int size = map.length;
		
		if (x < 0 || x >= size || y < 0 || y >= size ) {
			return true;
		}
		return false;
	}

	public int enemie(int x, int y) {
		
		if (map[x][y] != 0) {
			System.err.println("Enemies");
			return map[x][y];
		}
		return -1;
	}







    /*
    **  C R E A T E     M A P
    */

	public void placeHeroStart(Hero hero) {

		int pos = (int)Math.floor(map.length / 2);
		
		hero.setPosX(pos);
		hero.setPosY(pos);
	}

	public void placeHero(Hero hero, int x, int y) {

		// hero.setPosX(y);
		
		// hero.setPosX(pos);
		// hero.setPosY(pos);
	}








    /*
    **  S H O W
    */

	public void printMap() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; j++)
				System.err.print(map[i][j] + " ");
			System.err.println();
		}
	}










    /*
    **  G E T T E R S
    */

	public int getSize() {
		return map.length;
	}
}
