package za.co.WeThinkCode_.swingy.control;

import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.model.Var;
import za.co.WeThinkCode_.swingy.model.screens;

import za.co.WeThinkCode_.swingy.view.Console;

@Getter
@Setter
public class Run {

    public static enum view{
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
//        Gui displayGui = new Gui();
        Var stage = Var.builder().lastStage(view.StartMenu).build();
        System.out.println(stage.getGameView());
        switch (stage.getGameView()) {
            case "-console":
                switch (gameStage) {
                    case StartMenu:
                        displayCon.StartMenu();
                        break;
                    case NewGame:
                        displayCon.NewGame();
                        break;
                    case ContinueMenu:
                        displayCon.ContinueMenu();
                        break;
                    case SelectClass:
                        displayCon.SelectClass();
                        break;
                    case ClassName:
                        displayCon.ClassName();
                        break;
                    case LoadGame:
                        displayCon.LoadGame();
                        break;
                    case SelectChar:
                        displayCon.SelectChar();
                        break;
                    case MoveMenu:
                        displayCon.MoveMenu();
                        break;
                    case EnemyEncountered:
                        displayCon.EnemyEncountered();
                        break;
                    case FightWon:
                        displayCon.FightWon();
                        break;
                    case ItemDropped:
                        displayCon.ItemDropped();
                        break;
                    case FightLost:
                        displayCon.FightLost();
                        break;
                    case RanAway:
                        displayCon.RanAway();
                        break;
                    case RunFail:
                        displayCon.RunFail();
                        break;
                    case NewLevel:
                        displayCon.NewLevel();
                        break;
                    case QuitVerify:
                        displayCon.QuitVerify();
                        break;
                    case QuitGame:
                        displayCon.QuitGame();
                        break;
                    case LastGame:
                        displayCon.StartMenu();
                }
                break;
            case "-gui":
                switch (gameStage) {
                    case StartMenu:
                        displayCon.StartMenu();
                        break;
                    case NewGame:
                        displayCon.NewGame();
                        break;
                    case ContinueMenu:
                        displayCon.ContinueMenu();
                        break;
                    case SelectClass:
                        displayCon.SelectClass();
                        break;
                    case ClassName:
                        displayCon.ClassName();
                        break;
                    case LoadGame:
                        displayCon.LoadGame();
                        break;
                    case SelectChar:
                        displayCon.SelectChar();
                        break;
                    case MoveMenu:
                        displayCon.MoveMenu();
                        break;
                    case EnemyEncountered:
                        displayCon.EnemyEncountered();
                        break;
                    case FightWon:
                        displayCon.FightWon();
                        break;
                    case ItemDropped:
                        displayCon.ItemDropped();
                        break;
                    case FightLost:
                        displayCon.FightLost();
                        break;
                    case RanAway:
                        displayCon.RanAway();
                        break;
                    case RunFail:
                        displayCon.RunFail();
                        break;
                    case NewLevel:
                        displayCon.NewLevel();
                        break;
                    case QuitVerify:
                        displayCon.QuitVerify();
                        break;
                    case QuitGame:
                        displayCon.QuitGame();
                        break;
                    case LastGame:
                        displayCon.StartMenu();
                }
                break;
        }
    }
}

