package jorn.hiel.calculator.business;

import jorn.hiel.calculator.frontend.MainPage;
import jorn.hiel.calculator.frontend.controllers.MainpageController;
import jorn.hiel.calculator.service.managers.ChrecheManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Runner {

    private static void createAndShowGUI() {
        JFrame jFrame = new JFrame("Chreche calculator");

        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLACK);


        JButton button = new JButton("Start");
        button.setBorder(border);
        button.setPreferredSize((new Dimension(120,20)));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.addActionListener(e -> startWorking());


        jFrame.add(button,BorderLayout.CENTER);
        jFrame.setVisible(true);
    }

    private static void  startWorking(){
        MainPage mainPage=new MainPage();
        ChrecheManager manager=new ChrecheManager();
        MainpageController controller= new MainpageController(mainPage, manager);

        System.out.println("working");
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}
