/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Artifact.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/18 18:37:13 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/18 19:05:39 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class Artifact {

    private int stat;
    private String type;

    public Artifact(int pStat, String pType){
        stat = pStat;
        type = pType;
    }

    public int getStat() {
        return stat;
    }

    public String getType() {
        return type;
    }
}
