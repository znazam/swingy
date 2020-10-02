package za.co.WeThinkCode_.swingy.control;

import za.co.WeThinkCode_.swingy.view.Console;
import za.co.WeThinkCode_.swingy.view.Gui;

public class Run {

    public static void Game(String gameView){

        Console displayCon = new Console();

        Gui displayGui = new Gui();


        switch (gameView) {
            case "-console" -> displayCon.StartMenu();
            case "-gui" -> displayGui.StartMenu();
        }
    }
}

