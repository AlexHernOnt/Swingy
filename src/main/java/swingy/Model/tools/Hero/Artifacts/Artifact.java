/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Artifact.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/18 18:37:13 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 19:01:46 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Hero;

public class Artifact {

    private int stat;
    private String type;

    public Artifact(int stat, String type){
        this.stat = stat;
        this.type = type;
    }

    public int getStat() {
        return stat;
    }

    public String getType() {
        return type;
    }
}
