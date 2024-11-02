/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Archer.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/02 17:43:44 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package hero;

public class Archer extends Hero{

    /*
    ** Parameters
    */
    
    /*
    ** Methods
    */

    Archer(String p_class, String p_name)
    {
        super(p_class, p_name);
        attack = 7;
        defense = 3;
        HP = 10;
    }
}
