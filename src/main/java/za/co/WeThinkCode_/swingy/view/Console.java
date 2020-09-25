package za.co.WeThinkCode_.swingy.view;


import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.model.CreateDB;
import za.co.WeThinkCode_.swingy.model.Stats;
import za.co.WeThinkCode_.swingy.model.screens;

import javax.validation.constraints.Size;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

@Getter
@Setter
public class Console implements screens {
    protected int Atk;
    protected int Def;
    protected int Dodge;
    @Size(min = 2, max = 10)
    protected String PlayerName;
    @Size(min = 2, max = 10)
    protected String CharacterName;
    protected int Exp;
    protected int Level;
    protected int Hp;
    protected String Helm;
    protected String Armour;
    protected String Weapon;
    CreateDB db = new CreateDB();

    @Override
    public void StartMenu(){
        Scanner scan = new Scanner(System.in);

        clearScreen();
        System.out.println("accesses StartMenu");
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
            case 1 -> NewGame();
            case 2 -> LoadGame();
            case 3 -> QuitVerify();
            default -> throw new IllegalStateException("Unexpected value: " + scan.nextInt());
        }

    }

    @Override
    public void ContinueMenu(){
        Scanner scan = new Scanner(System.in);
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
            case 1 -> NewGame();
            case 2 -> LoadGame();
            case 3 -> MoveMenu();
            case 4 -> QuitVerify();
            default -> throw new IllegalStateException("Unexpected value: " + scan.nextInt());
        }
    }
    @Override
    public void NewGame(){
        Scanner scan = new Scanner(System.in);

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
                 "*                           Whats your name?                            *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");

        String welcome = "Welcome to Swingy ";

        PlayerName = scan.nextLine();
        System.out.println(welcome + getPlayerName());
        SelectClass();
    }

    @Override
    public void SelectClass(){
        Scanner scan = new Scanner(System.in);
        Stats stat = new Stats();
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
                 "*         (1)Assassin   (2)Tank      (3)Necromancer     (4)archer       *\n"+
                 "*         Atk 50        Atk 30       Atk 70             Atk 50          *\n"+
                 "*         Def 50        Def 70       Def 30             Def 30          *\n"+
                 "*         Agility 50    Agility 10   Agility 30         Agility 70      *\n"+
                 "*                                                                       *\n"+
                 "*         (B)Back                                       (Q)Exit         *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");

        switch (scan.nextLine()) {
            case "1" -> {stat.AssassinStats();
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "2"-> {stat.TankStats();
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "3" -> {stat.NecromancerStats();
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "4" -> {stat.ArcherStats();
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();}
            case "B" -> StartMenu();
            case "Q" -> QuitVerify();
            default -> throw new IllegalStateException("Unexpected value: " + scan.nextLine());
        }
    }
    @Override
    public void ClassName(){
        Scanner scan = new Scanner(System.in);
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
       while(!scan.hasNext("B")){
           CharacterName = scan.nextLine();
           System.out.println(CharacterName);
           db.sql("INSERT INTO Swing(PlayerName,Atk,Def,Dodge,Level,Exp,Hp,CharacterName,Helm,Armour,Weapon) VALUES('PlayerName','Atk','Def','Dodge','Level','Exp','Hp','CharacterName','Helm','Armour','Weapon')", "add");
           MoveMenu();
       }
       SelectClass();
//        if ("B".equals(scan.nextLine())) {
//                SelectClass();
//            } else {
//                ClassName = scan.nextLine();
//                System.out.println(ClassName);
//            }
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
        Scanner scan = new Scanner(System.in);
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
        switch (scan.nextLine()){
            case "B" -> StartMenu();
        }
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
        Scanner scan = new Scanner(System.in);

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

        switch (scan.nextInt()){
            case 1 -> QuitGame();
            case 2 -> StartMenu();
        }
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