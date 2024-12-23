/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Archer.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 19:01:58 by ahernand         ###   ########.fr       */
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

    Archer(String Class, String name)
    {
        super(Class, name);
        attack = 7;
        defense = 3;
        HP = 10;
    }
}
