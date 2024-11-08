/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Hero.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:45:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/07 16:13:45 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Hero {

    /*
    ** Parameters
    */
    
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
    protected String name;
    
    protected String classType;
    protected int level;
    protected int experience;
    protected int HP;
    protected int attack;
    protected int defense;
        
    /*
    ** Methods
    */

    public Hero(String p_class, String p_name)
    {
        classType = p_class;
        name = p_name;
    }


    /*
    ** Getters
    */
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hero:         " + name + "\n" +
               "Class:        " + classType + "\n\n" +
               "Level:        " + level + "\n" +
               "XP:           " + experience + "\n\n" +
               "Health:       " + HP + "\n" +
               "Attack Power: " + attack + "\n"+
               "Defense: " + defense
               ;
    }
}
