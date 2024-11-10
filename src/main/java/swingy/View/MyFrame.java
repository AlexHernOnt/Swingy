/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   MyFrame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/10 16:15:43 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/10 16:35:44 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;


public class MyFrame {

    public MyFrame()
    {
		JFrame winndow = new JFrame("Swingy");
		JPanel panel = new JPanel();

		// Window Settings

		winndow.setSize(640,480);
		winndow.setResizable(false);
		winndow.setLocationRelativeTo(null);
		winndow.setVisible(true);

		// Panel Settings

		panel.setBorder(BorderFactory.createEmptyBorder(720, 1080, 720, 1080));
		panel.setLayout(new GridLayout(0, 1));

		// Elements

		JButton[] classButtons = new JButton[4];
		classButtons[0] = new JButton("Warrior");
		classButtons[1] = new JButton("Wizard");
		classButtons[2] = new JButton("Knight");
		classButtons[3] = new JButton("Archer");

		JLabel label = new JLabel("Welcome to The Brighest Night");
		JLabel label2 = new JLabel("Choose a class: ");
 
		panel.add(label);
		panel.add(label2);

		for (int i = 0; i < classButtons.length; ++i) {
			panel.add(classButtons[i]);
		}
		winndow.add(panel, BorderLayout.CENTER);
		// winndow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		winndow.pack();
		winndow.repaint();
		winndow.revalidate();
		// ImageIcon
    }
}
