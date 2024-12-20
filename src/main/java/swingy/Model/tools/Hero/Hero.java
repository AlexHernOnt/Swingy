/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Hero.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/20 14:41:11 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Hero.Artifact;

public class Hero {

	/*
	** Variables
	*/
	
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
	protected String name;
	
	protected String classType;
	protected int level;
	protected int experience;
	protected int HP;
	protected int attack;
	protected int defense;

	protected Artifact weaponArtifact;
	protected Artifact armorArtifact;
	protected Artifact helmArtifact;
	
	//  Map

	protected int posX;
	protected int posY;










	/*
	** Methods
	*/

	public Hero(String p_class, String p_name) {
		classType = p_class;
		name = p_name;
		level = 0;
	}

	public void addXP(int xp) {
		System.out.println("XP received: " + xp);

		experience += xp;
		levelUp();
	}

	public int formulaLevelUp() {
		return ((level + 1) * 1000 + (int) Math.pow(((level + 1) - 1), 2) * 450);
	}

	private void levelUp() {
		System.out.println("Current xp: " + experience + " / " + formulaLevelUp());
		
		if (experience > formulaLevelUp()) {
			level++;
			experience = 0;
		}
	}










	/*
	** Getters
	*/
	
	public String getName() {
		return name;
	}

	public String getClassType() {
		return classType;
	}

	public int getLevel() {
		return level;
	}

	public int getExperience() {
		return experience;
	}

	public int getHP() {
		return HP;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	// Artifacts

	public Artifact getWeaponArtifact() {
		return weaponArtifact;
	}
	
	public Artifact getArmorArtifact() {
		return armorArtifact;
	}

	public Artifact getHelmArtifact() {
		return helmArtifact;
	}





	/*
	** S E T T E R S
	*/


	public void setPosX(int num) {
		posX = num;
	}

	public void setPosY(int num) {
		posY = num;
	}
	
	public void setWeaponArtifact(Artifact art) {

		if (art.getType().equals("Weapon")) {
			weaponArtifact = art;
		}
	}

	public void setArmorArtifact(Artifact art) {

		if (art.getType().equals("Armor")) {
			armorArtifact = art;
		}
	}

	public void setHelmArtifact(Artifact art) {

		if (art.getType().equals("Helm")) {
			helmArtifact = art;
		}
	}










	/*
	** P R I N T 
	*/

    public void goNorth() {
        posY--;
    }

	public void goEast() {
        posX++;
    }

	public void goSouth() {
        posY++;
    }

	public void goWest() {
        posX--;
    }









	/*
	** P R I N T 
	*/

	@Override
	public String toString() {
		return "Hero:         " + name + "\n" +
			   "Class:        " + classType + "\n\n" +
			   "Level:        " + level + "\n" +
			   "XP:           " + experience + "\n\n" +
			   "Health:       " + HP + "\n" +
			   "Attack Power: " + attack + "\n"+
			   "Defense: " + defense
			   ;
	}
}
