/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/01 19:59:47 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import java.util.Scanner;

/*
** Hello world!
*/

public class App 
{
	public static void main( String[] args )
	{
		hero h1;
		String inputName = "";

		System.err.println("Welcome to The Brighest Night");
		Scanner scanner = new Scanner(System.in);
		while (inputName.isEmpty()) {
			if (inputName.isEmpty())
				System.out.println("Write your hero's name:");
				inputName = scanner.nextLine();
		}
		System.out.println("The hero name is '" + inputName + "'");


	}
}