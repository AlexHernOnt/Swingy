/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Archer.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/03 16:45:17 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

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
