/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   MyFrame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/10 16:15:43 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/01 19:33:04 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import Controller.Controller;
import Controller.GameController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends JFrame {

	public int WIDTH = 1600;
	public int HEIGHT = 1200;
	public String COLOR = "#69614c";
	public Controller controller;
	public GameController GController;
	
    public MyFrame()
    {
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
				controller.StateSwitcher();
            }
        });
    }

	public void CrazyIdea() {
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
				GController.StateSwitcher();
            }
        });
	}

	/*
	 * setters
	 */

	public void setController(Controller p_controller) {
		controller = p_controller;
	}

	public void setGameController(GameController p_controller) {
		GController = p_controller;
	}
} 
