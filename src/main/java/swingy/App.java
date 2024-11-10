/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/10 16:33:50 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import Controller.ControllerGame;


/*
** Hello world!
*/

public class App 
{
	public static void main(String[] args )
	{
		ControllerGame controller = new ControllerGame();

		controller.presentGame();
		controller.setHero();
	}
}