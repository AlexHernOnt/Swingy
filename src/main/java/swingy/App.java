/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/01 18:54:10 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/08 18:20:02 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import Controller.ControllerGame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;


/*
** Hello world!
*/

public class App 
{
	public static void main(String[] args )
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		JButton[] classButtons = new JButton[4];
		classButtons[0] = new JButton("Warrior");
		classButtons[1] = new JButton("Wizard");
		classButtons[2] = new JButton("Knight");
		classButtons[3] = new JButton("Archer");

		JLabel label = new JLabel("Welcome to The Brighest Night");
		JLabel label2 = new JLabel("Choose a class: ");

		panel.setBorder(BorderFactory.createEmptyBorder(720, 1080, 720, 1080));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(label2);

		for (int i = 0; i < classButtons.length; ++i) {
			panel.add(classButtons[i]);
		}

		frame.add(panel, BorderLayout.CENTER);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DeathIsGood");
		frame.pack();
		frame.setVisible(true);




		// ControllerGame controller = new ControllerGame();

		// controller.presentGame();
		// controller.setHero();
	}
}