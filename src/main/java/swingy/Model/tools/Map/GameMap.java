/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameMap.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/02 16:29:11 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 17:14:09 by ahernand         ###   ########.fr       */
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
	
	public GameMap() {

		// Assign Constructor Variables
	}










    /*
    **  C R E A T E     M A P
    */

	private Random rand = new Random();

	public void createMap(int lvl) {

		int size;

		size = (lvl - 1) * 5 + 10 - (lvl % 2);
		System.out.println("Size of map = " + size + ".");
		
		map = new int[size][size];

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = -9;
		}
	}

	private void fillWithEnemys(int lvl) {

		// Fill, baby, fill

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; j++) {

				int rnd = rand.nextInt(12) + 1;
				
				if (rnd < 2  ) {
					map[i][j] = (lvl - 1) < 0 ? 0 : lvl - 1;
				}
				if (rnd == 5) {
					map[i][j] = lvl;
				}
				if (rnd == 10) {
					map[i][j] = lvl + 1;
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

	public int enemy(int y, int x) {
		
		if (map[y][x] >= 0) {
			return map[y][x];
		}
		return -1;
	}







    /*
    **  C R E A T E     M A P
    */

	public void placeHeroStart(Hero hero) {

		createMap(hero.getLevel());
		fillWithEnemys(hero.getLevel());
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
		for (int y = 0; y < map.length; ++y) {
			System.err.print("Y "+ y + ": ");

			for (int x = 0; x < map[y].length; x++)
			{
				if (map[y][x] >= 0 )
				{
					System.err.print(" " + map[y][x] + " ");
				}
				else
					System.err.print(map[y][x] + " ");

			}
			System.out.println();
		}
	}










    /*
    **  G E T T E R S
    */

	public int getSize() {
		return map.length;
	}
}
