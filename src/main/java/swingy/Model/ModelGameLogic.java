/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ModelGameLogic.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 16:43:54 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/07 16:12:30 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import Hero.Hero;
import Hero.heroCreator;

public class ModelGameLogic {

	/*
	** Parameters
	*/

	heroCreator creator = new heroCreator();
		
	/*
	** Methods
	*/

	public Hero ctNewHero(String p_class, String p_name) {
		return creator.newHero(p_class, p_name);
	}
}
