/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Knight.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/03 16:45:27 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class Knight extends Hero{

    /*
    ** Parameters
    */
    
    /*
    ** Methods
    */

    Knight(String p_class, String p_name)
    {
        super(p_class, p_name);
        attack = 2;
        defense = 8;
        HP = 10;
    }
}
