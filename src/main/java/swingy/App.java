/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/28 17:27:11 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import Controller.Controller;

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