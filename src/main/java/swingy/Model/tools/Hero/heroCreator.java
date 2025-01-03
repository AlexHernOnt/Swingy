/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   heroCreator.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/02 15:24:00 by ahernand          #+#    #+#             */
/*   Updated: 2025/01/03 14:47:18 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class heroCreator {
	
	public Hero newHero(String p_class, String p_name)
	{
		if (p_class.equalsIgnoreCase("Warrior")) {
			return new Warrior(p_class, p_name);
		} else if (p_class.equalsIgnoreCase("Wizard")) {
			return new Wizard(p_class, p_name);
		} else if (p_class.equalsIgnoreCase("Knight")) {
			return new Knight(p_class, p_name);
		} else if (p_class.equalsIgnoreCase("Archer")) {
				return new Archer(p_class, p_name);
		} else {
			return null;
		}
	}
}
