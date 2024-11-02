/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Warrior.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/02 17:43:45 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package hero;

public class Warrior extends Hero{

    /*
    ** Parameters
    */
    
    /*
    ** Methods
    */

    Warrior(String p_class, String p_name)
    {
        super(p_class, p_name);
        attack = 6;
        defense = 4;
        HP = 10;
    }
}
