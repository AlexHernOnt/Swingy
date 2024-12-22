/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   heroCreator.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/02 15:24:00 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/22 18:59:35 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class heroCreator {
	
	public Hero newHero(String p_class, String p_name)
	{
		switch (p_class) {
			case "Warrior":
				return new Warrior(p_class, p_name);
			case "Wizard":
				return new Wizard(p_class, p_name);
			case "Knight":
				return new Knight(p_class, p_name);
			case "Archer":
				return new Archer(p_class, p_name);
			default:
				return null;
		}
	}
}
