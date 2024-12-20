/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/20 15:28:05 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import Controller.Controller;

public class App 
{
	public static void main(String[] args ) {

		Controller controller;

		if (args.length == 1 && (args[0].equals("gui")|| args[0].equals("console"))) {
			controller = new Controller(args[0]);
			controller.startGame();
		}
		else {
			System.err.println("Input error: \"java - jar console/gui\"");
		}
	}
}