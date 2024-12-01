/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameModel.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/29 19:49:26 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/01 17:46:40 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Model;

import Hero.Hero;

public class GameModel {

    /*
    **     Variables
    */

    Hero _hero;

    public GameModel(Hero pHero) {
        _hero = pHero;
    }

    public Hero getHero() {
        return _hero;
    }
}
