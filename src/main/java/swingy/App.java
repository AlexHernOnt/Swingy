/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2025/01/03 17:27:28 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import Controller.Controller;

/*
 * There are helping prints around the program, look for //printf in the search box
 */

public class App 
{
	public static void main(String[] args ) {

		Controller controller;

		if (args.length == 1 && (args[0].equalsIgnoreCase("gui") || args[0].equalsIgnoreCase("console"))) {
			controller = new Controller(args[0]);
			controller.startGame();
		}
		else {
			System.err.println("Input error: \"java - jar console/gui\"");
		}
	}
}