/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   SQLutils.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/25 15:54:11 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/22 20:51:15 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import Hero.Hero;

public class SQLutils {

	private static final String DATABASE_URL = "jdbc:sqlite:hero.db";
	private Connection conn;




	/*
	**	C O N S T R U C T O R
	*/

	public SQLutils() {

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DATABASE_URL);
			System.out.println("Database connected or created successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLite JDBC driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error while connecting or creating the database: " + e.getMessage());
		}
	}










	/*
	**	D B     C R E A T I O N
	*/
	
	public void createDB(Hero h) {

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DATABASE_URL);
			System.out.println("Database connected or created successfully!");
			createTable();
			insertHero( h);
			showDB();
		} catch (ClassNotFoundException e) {
			System.out.println("SQLite JDBC driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error while connecting or creating the database: " + e.getMessage());
		}
	}










	/*
	**	C R E A T E     T A B L E
	*/

	public void createTable() throws SQLException {
		String createTableSQL = """
			CREATE TABLE IF NOT EXISTS Hero (
				id INTEGER PRIMARY KEY AUTOINCREMENT,

				name TEXT NOT NULL,
				classType TEXT NOT NULL,

				level INTEGER NOT NULL,
				experience INTEGER NOT NULL,
				
				HP INTEGER NOT NULL,
				attack INTEGER NOT NULL,
				defense INTEGER NOT NULL,

				weaponArtifact INTEGER NOT NULL,
				weaponArtifactStat INTEGER NOT NULL,
				weaponArtifactType TEXT NOT NULL,
				
				armorArtifact INTEGER NOT NULL,
				armorArtifactStat INTEGER NOT NULL,
				armorArtifactType TEXT NOT NULL,
				
				helmArtifact INTEGER NOT NULL,
				helmArtifactStat INTEGER NOT NULL,
				helmArtifactType TEXT NOT NULL
			);
		""";
		
		try (Statement statement = conn.createStatement()) {

			statement.execute(createTableSQL);
			System.out.println("Hero table created or already exists!");

		} catch (SQLException e) {
			System.out.println("Error while creating Hero table: " + e.getMessage());
		}
	}










	/*
	**	I N S E R T     E L E M E N T
	*/

	public void insertHero(Hero hero) {
		
		if (checkHeroEntries() > 2) {
			deleteOldestEntry();
		}

		String insertSQL =
			"""
			INSERT INTO Hero
				(name, classType, level, experience, HP, attack, defense,
				weaponArtifact, weaponArtifactStat, weaponArtifactType,
				armorArtifact, armorArtifactStat, armorArtifactType,
				helmArtifact, helmArtifactStat, helmArtifactType)
			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";

		try (PreparedStatement statement = conn.prepareStatement(insertSQL)) {
			statement.setString(1, hero.getName());
			statement.setString(2, hero.getClassType());
			statement.setInt(3, hero.getLevel());
			statement.setInt(4, hero.getExperience());
			statement.setInt(5, hero.getHP());
			statement.setInt(6, hero.getAttack());
			statement.setInt(7, hero.getDefense());

			// Set Weapon if excist

			if (hero.getWeaponArtifact() != null) {
				statement.setInt(8, 1);
				statement.setInt(9, hero.getWeaponArtifact().getStat());
				statement.setString(10, hero.getWeaponArtifact().getType());
			} else {
				statement.setInt(8, 0);
				statement.setInt(9, 0);
				statement.setInt(10, 0);
			}
			
			// Set Armor if exist

			if (hero.getArmorArtifact() != null) {
				statement.setInt(11, 1);
				statement.setInt(12, hero.getArmorArtifact().getStat());
				statement.setString(13, hero.getArmorArtifact().getType());
			} else {
				statement.setInt(11, 0);
				statement.setInt(12, 0);
				statement.setInt(13, 0);
			}

			// Set Helm if exist

			if (hero.getHelmArtifact() != null) {
				statement.setInt(14, 1);
				statement.setInt(15, hero.getHelmArtifact().getStat());
				statement.setString(16, hero.getHelmArtifact().getType());
			} else {
				statement.setInt(14, 0);
				statement.setInt(15, 0);
				statement.setInt(16, 0);
			}

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Hero inserted successfully!");
			}
			
		} catch (SQLException e) {
			System.out.println("Error inserting hero: " + e.getMessage());
		}
		giveIdtoHero(hero);
	}





	/*
	** Count the entries
	*/



	public int checkHeroEntries() {

		String countEntriesSQL = "SELECT COUNT(*) AS total FROM Hero";

		try (PreparedStatement statement = conn.prepareStatement(countEntriesSQL)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				System.out.println("Successfully read " + resultSet.getInt("total") + " elements.");
				return resultSet.getInt("total");
			}
			
		} catch (Exception e) {
			System.out.println("Error counting on hero: " + e.getMessage());
		}
		return 0;
	}





	/*
	** Count the entries
	*/

	public void giveIdtoHero(Hero hero) {

		String getNewestId = "SELECT MAX(id) as newestId FROM Hero";

		try (PreparedStatement statement = conn.prepareStatement(getNewestId)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				hero.setId(resultSet.getInt("newestId"));
				System.out.println("Successfully set hero's id to " + hero.getId() + ".");
			}
			
		} catch (Exception e) {
			System.out.println("Error getting id" + e.getMessage());
		}
	}




	/*
	**	Delete the oldest
	*/

	public void deleteOldestEntry() {
		
		String deleteSQL = "DELETE FROM Hero WHERE id = (SELECT MIN(id) FROM Hero)";
		
		try (PreparedStatement statement = conn.prepareStatement(deleteSQL)) {
			
			statement.executeUpdate();
			System.out.println("Successfully deleted the oldest entry.");

		} catch (SQLException e) {
			System.out.println("Error deleting the oldest entry: " + e.getMessage());
		}
	}










	/*
	**	U P D A T E     E N T R Y
	*/

	public void updateHero(Hero hero) {

		String insertSQL =
			"""
			UPDATE Hero
			
			SET
			
				level = ?,
				experience = ?,
			
				HP = ?,
				attack = ?,
				defense = ?,

				weaponArtifact = ?,
				weaponArtifactStat = ?,
				weaponArtifactType = ?,

				armorArtifact = ?,
				armorArtifactStat = ?,
				armorArtifactType = ?,
			
				helmArtifact = ?,
				helmArtifactStat = ?,
				helmArtifactType = ?
			
			WHERE id = ?
			""";

		try (PreparedStatement stmUpdate = conn.prepareStatement(insertSQL)) {

			stmUpdate.setInt(1, hero.getLevel());
			stmUpdate.setInt(2, hero.getExperience());
			
			stmUpdate.setInt(3, hero.getHP());
			stmUpdate.setInt(4, hero.getAttack());
			stmUpdate.setInt(5, hero.getDefense());

			// Set Weapon if excist

			if (hero.getWeaponArtifact() != null) {
				stmUpdate.setInt(6, 1);
				stmUpdate.setInt(7, hero.getWeaponArtifact().getStat());
				stmUpdate.setString(8, hero.getWeaponArtifact().getType());
			} else {
				stmUpdate.setInt(6, 0);
				stmUpdate.setInt(7, 0);
				stmUpdate.setInt(8, 0);
			}
			
			// Set Armor if exist

			if (hero.getArmorArtifact() != null) {
				stmUpdate.setInt(9, 1);
				stmUpdate.setInt(10, hero.getArmorArtifact().getStat());
				stmUpdate.setString(11, hero.getArmorArtifact().getType());
			} else {
				stmUpdate.setInt(9, 0);
				stmUpdate.setInt(10, 0);
				stmUpdate.setInt(11, 0);
			}

			// Set Helm if exist

			if (hero.getHelmArtifact() != null) {
				stmUpdate.setInt(12, 1);
				stmUpdate.setInt(13, hero.getHelmArtifact().getStat());
				stmUpdate.setString(14, hero.getHelmArtifact().getType());
			} else {
				stmUpdate.setInt(12, 0);
				stmUpdate.setInt(13, 0);
				stmUpdate.setInt(14, 0);
			}
			stmUpdate.setInt(15, hero.getId());

			int rowsInserted = stmUpdate.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Hero updated successfully!");
			}
			
		} catch (SQLException e) {
			System.out.println("Error updating hero: " + e.getMessage());
		}
	}










	/*
	**	G E T     N A M E
	*/

	public String getNameFromSave(int order) {
	
		String getAll = "SELECT * FROM hero";

		try (PreparedStatement statement = conn.prepareStatement(getAll)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			int i = 1;
			
			while (resultSet.next()) {

				if (i == order) {
					return resultSet.getString("name");
				}
				++i;
			}
			
		} catch (Exception e) {
			System.out.println("Error getting id" + e.getMessage());
		}
		return null;
	}










	/*
	**	G E T     L E V E L
	*/

	public String getLevelFromSave(int order) {
	
		String getAll = "SELECT * FROM hero";

		try (PreparedStatement statement = conn.prepareStatement(getAll)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			int i = 1;
			
			while (resultSet.next()) {

				if (i == order) {
					return resultSet.getString("level");
				}
				++i;
			}
			
		} catch (Exception e) {
			System.out.println("Error getting id" + e.getMessage());
		}
		return null;
	}









	/*
	**	C R E A T E     H E R O     O B J     F R O M     E N T R Y
	*/

	public Hero createHeroObjFromEntry(int order) {
	
		String getAll = "SELECT * FROM hero";

		try (PreparedStatement statement = conn.prepareStatement(getAll)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			int i = 1;
			
			while (resultSet.next()) {

				if (i == order) {

					boolean boolWeaponArtifact = resultSet.getInt("weaponArtifact") == 1 ? true : false;
					int	finalStatWeaponArtifact = boolWeaponArtifact ? resultSet.getInt("weaponArtifactStat") : 0;

					boolean boolArmorArtifact = resultSet.getInt("armorArtifact") == 1 ? true : false;
					int finalStatarmorArtifact = boolArmorArtifact ? resultSet.getInt("armorArtifactStat") : 0;

					boolean boolHelmArtifact = resultSet.getInt("helmArtifact") == 1 ? true : false;
					int finalStathelmArtifact = boolHelmArtifact ? resultSet.getInt("helmArtifactStat") : 0;


					return new Hero(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("classType"),

						resultSet.getInt("level"),
						resultSet.getInt("experience"),
						
						resultSet.getInt("HP"),
						resultSet.getInt("attack"),
						resultSet.getInt("defense"),

						boolWeaponArtifact,
						finalStatWeaponArtifact,

						boolArmorArtifact,
						finalStatarmorArtifact,
				
						boolHelmArtifact,
						finalStathelmArtifact
					);
				}
				++i;
			}
			
		} catch (Exception e) {
			System.out.println("Error getting id" + e.getMessage());
		}
		return null;
	}










	/*
	**	GET ARTIFACTS
	*/

	public String getArtifactsPrintable(int order) {

		String getAll = "SELECT * FROM hero";

		try (PreparedStatement statement = conn.prepareStatement(getAll)) {
			
			ResultSet resultSet = statement.executeQuery();
			
			int i = 1;
			
			while (resultSet.next()) {

				if (i == order) {

					boolean boolWeaponArtifact = resultSet.getInt("weaponArtifact") == 1 ? true : false;
					int	finalStatWeaponArtifact = boolWeaponArtifact ? resultSet.getInt("weaponArtifactStat") : 0;

					boolean boolArmorArtifact = resultSet.getInt("armorArtifact") == 1 ? true : false;
					int finalStatarmorArtifact = boolArmorArtifact ? resultSet.getInt("armorArtifactStat") : 0;

					boolean boolHelmArtifact = resultSet.getInt("helmArtifact") == 1 ? true : false;
					int finalStathelmArtifact = boolHelmArtifact ? resultSet.getInt("helmArtifactStat") : 0;

					return("(" + finalStatWeaponArtifact + ", "+ finalStatarmorArtifact + ", "+ finalStathelmArtifact + ")");
				}
				++i;
			}
			
		} catch (Exception e) {
			System.out.println("Error getting tables" + e.getMessage());
		}
		return null;
	}










	/*
	**	P R I N T     D B
	*/

	public void showDB() {
		String query = "SELECT * FROM Hero";

		try (Statement statement = conn.createStatement();
			 ResultSet resultSet = statement.executeQuery(query)) {

			System.out.println("ID | Name      | ClassType | Level| Experience | HP  | Attack | Defense | Weapon  | Armor  | Helm");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String classType = resultSet.getString("classType");
				int level = resultSet.getInt("level");
				int experience = resultSet.getInt("experience");
				int hp = resultSet.getInt("HP");
				int attack = resultSet.getInt("attack");
				int defense = resultSet.getInt("defense");

				String weapon;
				String armor;
				String helm;

				// Fetch artifact details (using null checks for optional data)
				if (resultSet.getInt("weaponArtifact") == 1){
					weapon = String.valueOf(resultSet.getInt("weaponArtifactStat"));
				}
				else {
					weapon = "none";
				}

				if (resultSet.getInt("armorArtifact") == 1){
					armor = String.valueOf(resultSet.getInt("armorArtifactStat"));
				}
				else {
					armor = "none";
				}
				
				if (resultSet.getInt("helmArtifact") == 1){
					helm = String.valueOf(resultSet.getInt("helmArtifactStat"));
				}
				else {
					helm = "none";
				}
				System.out.printf(
                    "%-3d| %-10s| %-10s| %-5d| %-10d| %-5d| %-7d| %-10d| %-10s| %-10s| %-10s%n",
                    id, name, classType, level, experience, hp, attack, defense, weapon, armor, helm);
			}
		} catch (SQLException e) {
			System.out.println("Error displaying database: " + e.getMessage());
		}
	}

	
	

	
	




	/*
	**	C L E A N
	*/

	public void cleanTable() {
		String deleteSQL = "DELETE FROM Hero";
		
		try (Statement statement = conn.createStatement()) {
			int rowsDeleted = statement.executeUpdate(deleteSQL);
			System.out.println("Hero table cleaned successfully! Rows affected: " + rowsDeleted);
		} catch (SQLException e) {
			System.out.println("Error cleaning Hero table: " + e.getMessage());
		}
	}
}
