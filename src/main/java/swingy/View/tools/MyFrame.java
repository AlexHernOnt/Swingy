/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   MyFrame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/10 16:15:43 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/27 19:10:47 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.View;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import Controller.Controller;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends JFrame {

	public int WIDTH = 1600;
	public int HEIGHT = 1200;
	public String COLOR = "#69614c";
	public Controller controller;

    public MyFrame(Controller pController)
    {
		// Assign Constructor Variables

		controller = pController;

		// Window Settings
		
		setTitle("Swingy");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		// getContentPane().setBackground(Color.decode(COLOR));
		repaint();
		revalidate();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
				if (controller != null) {
					controller.view.VCHero.closeWindow();
				}
            }
        });
    }
} 
