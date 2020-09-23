package za.co.WeThinkCode_.swingy.control;

import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.model.Var;
import za.co.WeThinkCode_.swingy.model.screens;

import za.co.WeThinkCode_.swingy.view.Console;
import za.co.WeThinkCode_.swingy.view.Gui;

@Getter
@Setter
public class Run {

    public enum view{
        StartMenu,
        NewGame,
        ContinueMenu,
        SelectClass,
        ClassName,
        LoadGame,
        SelectChar,
        MoveMenu,
        EnemyEncountered,
        FightWon,
        ItemDropped,
        FightLost,
        RanAway,
        RunFail,
        NewLevel,
        QuitVerify,
        QuitGame,
        LastGame
    }

//    private screens display = (gameView.equalsIgnoreCase("-console"))
//            Console();
//            Gui();

    public static void Game(view gameStage){


        Console displayCon = new Console();
        Gui displayGui = new Gui();
        Var stage = Var.builder().build();
        String s = stage.getGameView();
        System.out.println(s);
        switch (stage.getGameView()) {
            case "-console":
                switch (gameStage) {
                    case StartMenu, LastGame -> {
                        displayCon.StartMenu();
                        System.out.println("accesses case StartMenu");
                    }
                    case NewGame -> displayCon.NewGame();
                    case ContinueMenu -> displayCon.ContinueMenu();
                    case SelectClass -> displayCon.SelectClass();
                    case ClassName -> displayCon.ClassName();
                    case LoadGame -> displayCon.LoadGame();
                    case SelectChar -> displayCon.SelectChar();
                    case MoveMenu -> displayCon.MoveMenu();
                    case EnemyEncountered -> displayCon.EnemyEncountered();
                    case FightWon -> displayCon.FightWon();
                    case ItemDropped -> displayCon.ItemDropped();
                    case FightLost -> displayCon.FightLost();
                    case RanAway -> displayCon.RanAway();
                    case RunFail -> displayCon.RunFail();
                    case NewLevel -> displayCon.NewLevel();
                    case QuitVerify -> displayCon.QuitVerify();
                    case QuitGame -> displayCon.QuitGame();
                }
                break;
            case "-gui":
                switch (gameStage) {
                    case StartMenu, LastGame -> displayGui.StartMenu();
//                    case NewGame -> displayGui.NewGame();
//                    case ContinueMenu -> displayGui.ContinueMenu();
//                    case SelectClass -> displayGui.SelectClass();
//                    case ClassName -> displayGui.ClassName();
//                    case LoadGame -> displayGui.LoadGame();
//                    case SelectChar -> displayGui.SelectChar();
//                    case MoveMenu -> displayGui.MoveMenu();
//                    case EnemyEncountered -> displayGui.EnemyEncountered();
//                    case FightWon -> displayGui.FightWon();
//                    case ItemDropped -> displayGui.ItemDropped();
//                    case FightLost -> displayGui.FightLost();
//                    case RanAway -> displayGui.RanAway();
//                    case RunFail -> displayGui.RunFail();
//                    case NewLevel -> displayGui.NewLevel();
//                    case QuitVerify -> displayGui.QuitVerify();
//                    case QuitGame -> displayGui.QuitGame();
                }
                break;
        }
    }
}

