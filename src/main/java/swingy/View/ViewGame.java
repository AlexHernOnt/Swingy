/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ViewGame.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/03 20:16:18 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;
import java.util.Scanner;

public class ViewGame {

	/*
	** Parameters
	*/
	
	Scanner scanner = new Scanner(System.in);

	/*
	** Methods
	*/

	public void printPresentGame() {
		System.err.println("Welcome to The Brighest Night");
	}

	public void printName(String str) {
		System.out.println("The hero's name is '" + str + "'");
	}

	public void printClass(String str) {
		System.out.println("The hero's class is '" + str + "'");
	}

	public String promptForName() {
		System.out.println("Write your hero's name:");
		String str = scanner.nextLine();
		return str;
	}

	public String promptForClass() {
		System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
		String str = scanner.nextLine();
		return str;
	}

	public void printErrorClass() {
		System.out.println("Please, input a valid class.");
	}
}
