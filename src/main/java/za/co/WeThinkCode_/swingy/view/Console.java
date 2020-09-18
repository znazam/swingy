package za.co.WeThinkCode_.swingy.view;


import lombok.Builder;
import za.co.WeThinkCode_.swingy.control.Run;
import za.co.WeThinkCode_.swingy.model.screens;

import java.io.IOException;
import java.util.Scanner;


public class Console implements screens {

    Scanner scan = new Scanner(System.in);
    @Override
    public void StartMenu(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                            "*                                                                       *\n"+
                            "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                            "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                            "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                            "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                            "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                            "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                            "*   *****        *           *        *  *      *    **** *     *       *\n"+
                            "*                                                                       *\n"+
                            "*************************************************************************\n"+
                            "*                                                                       *\n"+
                            "*           (1)New Game          (2)Load Game          (3)Exit          *\n"+
                            "*                                                                       *\n"+
                            "*************************************************************************\n");

        switch (scan.nextInt()) {
            case 1:
                Run.Game(Run.view.NewGame);
                break;
            case 2:
                Run.Game(Run.view.LoadGame);
                break;
            case 3:
                Run.Game(Run.view.QuitGame);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scan.nextInt());
        }

    }

    @Override
    public void ContinueMenu(){
        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*    (1)New Game       (2)Load Game       (3)Continue       (4)Exit     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");

        switch (scan.nextInt()) {
            case 1:
                Run.Game(Run.view.NewGame);
                break;
            case 2:
                Run.Game(Run.view.LoadGame);
                break;
            case 3:
                Run.Game(Run.view.MoveMenu);
                break;
            case 4:
                Run.Game(Run.view.QuitGame);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scan.nextInt());
        }
    }
    @Override
    public void NewGame(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                 "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                 "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                 "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                 "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                 "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                 "*   *****        *           *        *  *      *    **** *     *       *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*           Whats your name?              (B)Back         (Q)Exit       *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");
        //            default:
        //                Run.Game(Run.view.MoveMenu, Run.view.ContinueMenu);
        //                break;
        switch (scan.nextLine()) {
            case "B":
                Run.Game(Run.view.LastGame);
                break;
            case "Q":
                Run.Game(Run.view.QuitGame);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scan.nextLine());
        }
    }
    @Override
    public void SelectClass(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                 "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                 "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                 "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                 "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                 "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                 "*   *****        *           *        *  *      *    **** *     *       *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*         (1)Assassin    (2)Tank      (3)Necromancer    (4)archer       *\n"+
                 "*         Atk 50        Atk 30       Atk 70             Atk 50          *\n"+
                 "*         Def 50        Def 70       Def 30             Def 30          *\n"+
                 "*         Agility 50    Agility 10   Agility 30         Agility 70      *\n"+
                 "*                                                                       *\n"+
                 "*         (B)Back                                       (Q)Exit         *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");

        switch (scan.nextLine()) {
            case "B":
                Run.Game(Run.view.LastGame);
                break;
            case "Q":
                Run.Game(Run.view.QuitGame);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scan.nextLine());
        }
    }
    @Override
    public void ClassName(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*           What name do you bestow upon this Hero?                     *\n"+
                "*                                                                       *\n"+
                "*           (B)Back                                                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void LoadGame(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n");

//                while(){// loop through database to get the length than pass it in as (i)){
//
//                    System.out.println("*           ("+i+") "+player+"                                          *\n"+);
//                }

                System.out.println("*           (B)Back                                                     *\n"+
                        "*                                                                       *\n"+
                        "*************************************************************************\n");
    }
    @Override
    public void SelectChar(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
             "*                                                                       *\n"+
             "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
             "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
             "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
             "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
             "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
             "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
             "*   *****        *           *        *  *      *    **** *     *       *\n"+
             "*                                                                       *\n"+
             "*************************************************************************\n"+
             "*                                                                       *\n");

//        while(){// loop through database to get the length and Characters names than pass it in as (i){
//
//             System.out.println("*           ("+i+") "+character+"                                          *\n"+);
//        }
        System.out.println("*           (B)Back                                                     *\n"+
                "*                                                                       *\n"+
                        "*************************************************************************\n");
    }
    @Override
    public void MoveMenu(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                 "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                 "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                 "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                 "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                 "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                 "*   *****        *           *        *  *      *    **** *     *       *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n"+
                 "*                                                                       *\n"+
                 "*          You are on level ????????? Which direction do you want to go *\n"+
                 "*      (1)North          (2)East          (3)South          (4)West     *\n"+
                 "*                                                                       *\n"+
                 "*      (B)Back                                                          *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");

    }
    @Override
    public void EnemyEncountered(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*      Enemy encountered!!!! Do you want to fight him or try to run?    *\n"+
                "*          His stats are ??????????? retrieve later                      *\n"+
                "*          (1)Fight                              (2)Run                 *\n"+
                "*                                                                       *\n"+
                "*           (B)Back                                                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void FightWon(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*                  Great job, you won the fight                         *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void FightLost(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*            Oh no, you were defeated.                                  *\n"+
                "*     You will lose all your exp and items gained in this level         *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void ItemDropped(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*     Oh the enemy dropped an item??????????. do you wanna keep it?     *\n"+
                "*     (1)Keep                              (2)Leave                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void RanAway(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*     You successfully ran away. That was either smart or shameful      *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void RunFail(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*            You weren't fast enough and was forced to fight            *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void NewLevel(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*            Well done!!! You made it through the level                 *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void QuitVerify(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*                    You sure you wish to quit?                         *\n"+
                "*                    (1)Yes               (2)No                         *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
    }
    @Override
    public void QuitGame(){

        clearScreen();

        System.out.println("*************************************************************************\n"+
                "*                                                                       *\n"+
                "*   *****  *           *           *  *  *      *    ****   *       *   *\n"+
                "*  *     *  *         * *         *   *  * *    *  *      *  *     *    *\n"+
                "*  *         *       *   *       *    *  *  *   *  *      *   *   *     *\n"+
                "*   *****     *     *     *     *     *  *   *  *  *           * *      *\n"+
                "*        *     *   *       *   *      *  *    * *  *   ****     *       *\n"+
                "*  *     *      * *         * *       *  *     **   *     *     *       *\n"+
                "*   *****        *           *        *  *      *    **** *     *       *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n"+
                "*                                                                       *\n"+
                "*            Thanks for playing SWINGY by Zaid Nazam                    *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
        try { Thread.sleep(250);} catch (InterruptedException ex) {ex.printStackTrace();}
        clearScreen();
    }

//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

    public static void clearScreen(){

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Screen was unable to clear");
        }


    }

}