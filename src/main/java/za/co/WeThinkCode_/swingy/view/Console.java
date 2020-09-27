package za.co.WeThinkCode_.swingy.view;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.control.Fight;
import za.co.WeThinkCode_.swingy.control.Move;
import za.co.WeThinkCode_.swingy.model.CreateDB;
import za.co.WeThinkCode_.swingy.model.Stats;
import za.co.WeThinkCode_.swingy.model.screens;

import javax.validation.constraints.Size;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//@Data
public class Console implements screens {
    String saveFilePath = new File("").getAbsolutePath().concat("\\SaveFiles\\");
    protected int Atk;
    protected int Def;
    protected int Dodge;
    protected String className;
    @Size(min = 2, max = 10)
    protected String PlayerName;
    @Size(min = 2, max = 10)
    protected String CharacterName;
    protected int Exp;
    @Getter
    @Setter
    protected int Level = 1;
    protected int Hp = 100;
    protected String Helm = "Leather";
    protected String Armour = "Leather";
    protected String Weapon = "Leather";
    int[] Coordinates = {0,0};
//    CreateDB db = new CreateDB();

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
        System.out.println(welcome + PlayerName);
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
                className = "Assassin";
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "2"-> {stat.TankStats();
                className = "Tank";
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "3" -> {stat.NecromancerStats();
                className = "Necromancer";
                Atk = stat.getAtk();
                Def = stat.getDef();
                Dodge = stat.getDodge();
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            case "4" -> {stat.ArcherStats();
                className = "Archer";
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
           saveData();
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
        Scanner scan = new Scanner(System.in);
        File file = new File(saveFilePath);
        String[] list = {};

        File[] fileNames = file.listFiles();

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
                "*                                                                       *");
        ArrayList<String> validInputs = new ArrayList<String>();
        for (File fileName : fileNames) {

            validInputs.add(fileName.getName().split("\\.")[0]);

        }
        String[] input = {""};
        while (!(validInputs.contains(input[0]))){

            clearScreen();

            System.out.println("*             Type the name of your saved file or B to go back          *\n"+
                    "*           (B)Back                                                     *\n"+
                    "*                                                                       *\n"+
                    "*************************************************************************\n");

            for (String validInput : validInputs) {
                System.out.println("*- ".concat(validInput));
            }

            System.out.println("Please type name here: ");

            input[0] = scan.nextLine();
            if ("B".equals(input[0])) {
                StartMenu();
            }
            if (!(validInputs.contains(input[0])))
            {
                System.out.println("\nInvalid choice");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }
        loadHero(input);
        MoveMenu();

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
//        Scanner scan = new Scanner(System.in);
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
                 "*          You are on level "+Level+" Which direction do you want to go        *\n"+
                 "*      (1)North          (2)East          (3)South          (4)West     *\n"+
                 "*                                                                       *\n"+
                 "*      (B)Back                                                          *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");
        Move move = new Move();
        System.out.println("this is before "+Coordinates[0]+Coordinates[1]);
        Coordinates = move.Direction(Coordinates);
        System.out.println("this is After "+Coordinates[0]+Coordinates[1]);
    }
    @Override
    public void EnemyEncountered(int[] tempCor){
        Scanner scan = new Scanner(System.in);
        clearScreen();
        Coordinates = tempCor;
        Random ran = new Random();
        int chance = ran.nextInt(100);
        boolean Fight = chance > 50;
        Stats stat = new Stats();
        stat.EnemyStats(Level);
        Fight result = new Fight();

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
                "*          His stats are Atk: "+stat.getAtk()+" Def: "+stat.getDef()+" Dodge: "+stat.getDodge()+"                      *\n"+
                "*          (1)Fight                              (2)Run                 *\n"+
                "*                                                                       *\n"+
                "*           (B)Back                                                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
        switch (scan.nextLine()){
            case "1" -> result.Fight();
            case "2" -> {
//
//                System.out.println("this is before "+Coordinates[0]+Coordinates[1]);
                if (Fight)
                    MoveMenu();
                else
                    result.Fight();
            }
            case "B" -> StartMenu();
        }
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
        Level += 1;
        MoveMenu();
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
        clearScreen();System.exit(0);
    }

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

    public void saveData(){

        File file = new File(saveFilePath.concat(PlayerName).concat(".txt"));

        try {
            FileWriter writer = new FileWriter(file);
            writer.append(
                            className
                            .concat("\n")
                            .concat(CharacterName)
                            .concat("\n")
                            .concat(Integer.toString(Level))
                            .concat("\n")
                            .concat(Integer.toString(Exp))
                            .concat("\n")
                            .concat(Integer.toString(Dodge))
                            .concat("\n")
                            .concat(Integer.toString(Atk))
                            .concat("\n")
                            .concat(Integer.toString(Def))
                            .concat("\n")
                            .concat(Integer.toString(Hp))
                            .concat("\n")
                            .concat(Helm)
                            .concat("\n")
                            .concat(Armour)
                            .concat("\n")
                            .concat(Weapon)
            );
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHero(String[] name){
        Stats stat = new Stats();
        File file = new File(
                saveFilePath
                        .concat(name[0])
                        .concat(".txt")
        );

        try {
            Scanner scanner = new Scanner(file);
            System.out.println(file);
            className = scanner.nextLine();
            System.out.println(className);
            scanner.nextLine();
            Level = Integer.parseInt(scanner.nextLine());
            System.out.println(Level);
            Exp = Integer.parseInt(scanner.nextLine());
            System.out.println(Exp);
            Dodge = Integer.parseInt(scanner.nextLine());
            System.out.println(Dodge);
            Atk = Integer.parseInt(scanner.nextLine());
            System.out.println(Atk);
            Def = Integer.parseInt(scanner.nextLine());
            System.out.println(Def);
            Hp = Integer.parseInt(scanner.nextLine());
            System.out.println(Hp);

            Helm = scanner.nextLine();
            System.out.println(Helm);
            stat.Equipmant(Helm);
            Atk = Atk + stat.getAtk();
            System.out.println(Atk);
            Def = Def + stat.getDef();
            System.out.println(Def);
            Dodge = Dodge + stat.getDodge();
            System.out.println(Dodge);

            Armour = scanner.nextLine();
            stat.Equipmant(Armour);
            Atk = Atk + stat.getAtk();
            System.out.println(Atk);
            Def = Def + stat.getDef();
            System.out.println(Def);
            Dodge = Dodge + stat.getDodge();
            System.out.println(Dodge);

            Weapon = scanner.nextLine();
            stat.Equipmant(Weapon);
            Atk = Atk + stat.getAtk();
            System.out.println(Atk);
            Def = Def + stat.getDef();
            System.out.println(Def);
            Dodge = Dodge + stat.getDodge();
            System.out.println(Dodge);

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}