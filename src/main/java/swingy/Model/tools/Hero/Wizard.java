/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Wizard.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/17 15:22:51 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class Wizard extends Hero{

    /*
    ** Parameters
    */
    
    /*
    ** Methods
    */

    Wizard(String p_class, String p_name)
    {
        super(p_class, p_name);
        attack = 9;
        defense = 1;
        HP = 10;
    }
}
