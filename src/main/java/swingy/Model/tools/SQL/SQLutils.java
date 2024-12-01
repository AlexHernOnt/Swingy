/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   SQLutils.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/25 15:54:11 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/25 17:23:52 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Hero.Hero;

public class SQLutils {

	private static final String DATABASE_URL = "jdbc:sqlite:hero.db";

	public void createDB(Hero h) {

		Connection conn;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DATABASE_URL);
			System.out.println("Database connected or created successfully!");
			createTable(conn);
			cleanTable(conn);
			insertHero(conn, h);
			showDB(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("SQLite JDBC driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error while connecting or creating the database: " + e.getMessage());
		}
	}


	public void createTable(Connection conn) throws SQLException {
		String createTableSQL = """
			CREATE TABLE IF NOT EXISTS Hero (
				id INTEGER PRIMARY KEY AUTOINCREMENT,
				name TEXT NOT NULL,
				classType TEXT NOT NULL,
				level INTEGER NOT NULL,
				experience INTEGER NOT NULL,
				HP INTEGER NOT NULL,
				attack INTEGER NOT NULL,
				defense INTEGER NOT NULL
			);
		""";
		
		try (Statement statement = conn.createStatement()) {
			statement.execute(createTableSQL);
			System.out.println("Hero table created or already exists!");
		} catch (SQLException e) {
			System.out.println("Error while creating Hero table: " + e.getMessage());
		}
	}

	public void insertHero(Connection conn, Hero hero) {
		
		String insertSQL = "INSERT INTO Hero (name, classType, level, experience, HP, attack, defense) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = conn.prepareStatement(insertSQL)) {
			statement.setString(1, hero.getName());
			statement.setString(2, hero.getClassType());
			statement.setInt(3, hero.getLevel());
			statement.setInt(4, hero.getExperience());
			statement.setInt(5, hero.getHP());
			statement.setInt(6, hero.getAttack());
			statement.setInt(7, hero.getDefense());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Hero inserted successfully!");
			}
		} catch (SQLException e) {
			System.out.println("Error inserting hero: " + e.getMessage());
		}
	}

	public void showDB(Connection conn) {
		String query = "SELECT * FROM Hero";

		try (Statement statement = conn.createStatement();
			 ResultSet resultSet = statement.executeQuery(query)) {

			System.out.println("ID | Name      | ClassType | Level | Experience | HP  | Attack | Defense");
			System.out.println("-------------------------------------------------------------");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String classType = resultSet.getString("classType");
				int level = resultSet.getInt("level");
				int experience = resultSet.getInt("experience");
				int hp = resultSet.getInt("HP");
				int attack = resultSet.getInt("attack");
				int defense = resultSet.getInt("defense");

				System.out.printf("%-3d| %-9s| %-10s| %-5d| %-11d| %-4d| %-7d| %-7d%n",
						id, name, classType, level, experience, hp, attack, defense);
			}
		} catch (SQLException e) {
			System.out.println("Error displaying database: " + e.getMessage());
		}
	}

	public void cleanTable(Connection conn) {
		String deleteSQL = "DELETE FROM Hero";
		
		try (Statement statement = conn.createStatement()) {
			int rowsDeleted = statement.executeUpdate(deleteSQL);
			System.out.println("Hero table cleaned successfully! Rows affected: " + rowsDeleted);
		} catch (SQLException e) {
			System.out.println("Error cleaning Hero table: " + e.getMessage());
		}
	}
}
