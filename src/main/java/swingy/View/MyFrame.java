/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   MyFrame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/10 16:15:43 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/12 20:35:47 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.View;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JFrame;




public class MyFrame extends JFrame {

	public int WIDTH = 1600;
	public int HEIGHT = 1200;
	public String COLOR = "#69614c";

    public MyFrame()
    {
		// Window Settings
		setTitle("Swingy");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		// getContentPane().setBackground(Color.decode(COLOR));
		// setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refresh();
    }

	public void refresh() {
		// pack();
		repaint();
		revalidate();
	}
} 
