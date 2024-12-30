/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Hero.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/30 17:11:50 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

import Model.SQLutils;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Hero.Artifact;

public class Hero {

	/*
	** Variables
	*/
	
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
	protected String name;
	protected int id;

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

	private SQLutils sql = new SQLutils();











	/*
	** Methods
	*/

	public Hero(String Class, String name) {
		this.classType = Class;
		this.name = name;
		level = 0;
	}

	public Hero(String Class, String name, Artifact WeaponArtifact, Artifact ArmorArtifact, Artifact HelmArtifact) {
		this.classType = Class;
		this.name = name;
		level = 0;

		this.weaponArtifact = WeaponArtifact;
		this.armorArtifact = ArmorArtifact;
		this.helmArtifact = HelmArtifact;
	}

	public Hero (int pId, String g_name, String g_class, int pLevel, int pXp, int pHp, int pAttack, int pDefense,
			boolean pWeaponArtifact, int weaponArtifactStat,
			boolean pArmorArtifact, int armorArtifactStat,
			boolean pHelmArtifact, int helmArtifactStat) {

		// Take the data

		this.id = pId;
		this.name = g_name;
		this.classType = g_class;

		this.level = pLevel;
		this.experience = pXp;
		
		this.HP = pHp;
		this.attack = pAttack;
		this.defense = pDefense;

		// Make the Artifacts

		if (pWeaponArtifact) {
			this.weaponArtifact = new Artifact(weaponArtifactStat, "Weapon");
		}
		if (pArmorArtifact) {
			this.armorArtifact = new Artifact(armorArtifactStat, "Armor");
		}
		if (pHelmArtifact) {
			this.helmArtifact = new Artifact(helmArtifactStat, "Helm");
		}
	}










	/*
	**	XP Managment
	*/

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
		sql.updateHero(this);
	}










	/*
	**	SQL request
	*/

	public void killHero() {
		sql.killHero(id);
	}


	






	/*
	** Getters
	*/

	public int getId() {
		return id;
	}

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

	public void setId(int num) {
		id = num;
	}
	public void setPosX(int num) {
		posX = num;
	}

	public void setPosY(int num) {
		posY = num;
	}

	public void setWeaponArtifact(Artifact art) {

		if (art.getType().equalsIgnoreCase("Weapon")) {
			weaponArtifact = art;
			sql.updateHero(this);
		}
	}

	public void setArmorArtifact(Artifact art) {

		if (art.getType().equalsIgnoreCase("Armor")) {
			armorArtifact = art;
			sql.updateHero(this);
		}
	}

	public void setHelmArtifact(Artifact art) {

		if (art.getType().equalsIgnoreCase("Helm")) {
			helmArtifact = art;
			sql.updateHero(this);
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
