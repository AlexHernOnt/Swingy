/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/02 18:14:44 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import java.util.Scanner;
import hero.Hero;
import hero.heroCreator;

/*
** Hello world!
*/

public class App 
{
	private static boolean classIsCorrect(String str) {
		return (str.equals("Warrior") || str.equals("Wizard") || str.equals("Knight") || str.equals("Archer"));
	}

	public static void main( String[] args )
	{
		String inputName = "";
		String inputClass = "";
		heroCreator creator = new heroCreator();

		System.err.println("Welcome to The Brighest Night");
		Scanner scanner = new Scanner(System.in);
		
		while (inputName.isEmpty()) {
			if (inputName.isEmpty())
				System.out.println("Write your hero's name:");
				inputName = scanner.nextLine();
		}

		System.out.println("The hero's name is '" + inputName + "'");

		while (inputClass.isEmpty() || !classIsCorrect(inputClass)) {
			if (inputClass.isEmpty())
				System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
			else if (!classIsCorrect(inputClass))
				System.out.println("Incorrect\nChoose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
			inputClass = scanner.nextLine();
		}

		creator.newHero(inputName, inputClass);
		System.out.println("The hero's class is '" + inputClass + "'");
		scanner.close();
	}
}