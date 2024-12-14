/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ToolsGUI.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/10 20:52:57 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/14 20:26:37 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import View.GuiCreateHero;
import View.GuiGame;
import View.MyFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.Controller;
import Controller.GameController;
import java.awt.Font;

public class ToolsGUI {

    /*
    ** W I N D O W     M A N A G M E N T
    */

	// Open frame if it's closed

	public void reOpenWindow(GuiCreateHero gui) {
		if (gui.getGUI() == true &&  gui.getActive() == false) {
			System.err.println("Opening Window Again");
			gui.setActive(true);
			gui.setFrame(new MyFrame());
		}
		cleanScreen(gui);
	}

	public void reOpenWindow(GuiGame gui) {
		if (gui.getGUI() == true &&  gui.getActive() == false) {
			System.err.println("Opening Window Again");
			gui.setActive(true);
			gui.setFrame(new MyFrame());
		}
		cleanScreen(gui);
	}

	// Remove all from screen

	protected void cleanScreen(GuiGame gui) {
		gui.getFrame().getContentPane().removeAll();
		gui.getFrame().revalidate();
		gui.getFrame().repaint();

		gui.panelOnTop.removeAll();
		gui.panelMiddle.removeAll();
		gui.panelBottom.removeAll();


	}

	protected void cleanScreen(GuiCreateHero gui) {
		gui.getFrame().getContentPane().removeAll();
		gui.getFrame().revalidate();
		gui.getFrame().repaint();
	}
    
	// Set Buttons Position and settings

	public JButton confButton(JButton button, String text, int x, int y, GuiGame gui) {

		button = new JButton();
		button.setText(text);
		button.setFont(new Font("Monospaced", Font.PLAIN, 21));
		button.setBounds(x, y, 200, 70);
		button.addActionListener(gui);
		button.setFocusable(false);
		return button;
	}

	// Set Label's position

	public JLabel confLabel(JLabel label, ImageIcon img) {
		
		label.setIconTextGap(100);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setFont(new Font("Monospaced", Font.PLAIN, 42));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		if (img != null){
			label.setIcon(img);
		}
		return label;
	}
}
