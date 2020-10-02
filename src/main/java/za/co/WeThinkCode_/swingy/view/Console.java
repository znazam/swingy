package za.co.WeThinkCode_.swingy.view;


import lombok.Data;
import za.co.WeThinkCode_.swingy.control.Fight;
import za.co.WeThinkCode_.swingy.control.Move;
import za.co.WeThinkCode_.swingy.model.Stats;
import za.co.WeThinkCode_.swingy.model.screens;

import javax.validation.constraints.Size;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Data
public class Console implements screens {
    String saveFilePath = new File("").getAbsolutePath().concat("\\SaveFiles\\");
    protected int Atk = 0;
    protected int Def = 0;
    protected int Dodge = 0;
    protected String className;
    @Size(min = 2, max = 10)
    protected String PlayerName;
    @Size(min = 2, max = 10)
    protected String CharacterName;
    protected int Exp;
    protected int Level = 1;
    protected int Hp = 100;
    protected String Helm = "Leather";
    protected String Armour = "Leather";
    protected String Weapon = "Leather";
    protected int[] Coordinates = {0,0};

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
            default -> {System.out.println("Wrong input\n");StartMenu();}
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
            default -> {System.out.println("Wrong input\n");ContinueMenu();}
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

        setPlayerName(scan.nextLine());
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
                 "*         Dodge 50      Dodge 10     Dodge 30           Dodge 70        *\n"+
                 "*                                                                       *\n"+
                 "*         (B)Back                                       (Q)Exit         *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");

        switch (scan.nextLine()) {
            case "1" -> {stat.AssassinStats();
                setClassName("Assassin");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk()+" "+getDef()+" "+getDodge());
                ClassName();
            }
            case "2"-> {stat.TankStats();
                setClassName("Tank");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk()+" "+getDef()+" "+getDodge());
                ClassName();
            }
            case "3" -> {stat.NecromancerStats();
                setClassName("Necromancer");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk()+" "+getDef()+" "+getDodge());
                ClassName();
            }
            case "4" -> {stat.ArcherStats();
                setClassName("Archer");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();}
            case "B" -> StartMenu();
            case "Q" -> QuitVerify();
            default -> {System.out.println("Wrong input\n");SelectClass();}
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
    }
    @Override
    public void LoadGame(){
        Scanner scan = new Scanner(System.in);
        File file = new File(saveFilePath);

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
        ArrayList<String> validInputs = new ArrayList<>();
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
            }
        }
        loadHero(input);
        MoveMenu();

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
                 "*          You are on level "+Level+" Which direction do you want to go         *\n"+
                 "*      (1)North          (2)East          (3)South          (4)West     *\n"+
                 "*                                                                       *\n"+
                 "*      (B)Back                                                          *\n"+
                 "*                                                                       *\n"+
                 "*************************************************************************\n");
//        Move move = new Move();

        System.out.println("this is before "+Coordinates[0]+Coordinates[1]);
        String data = Move.Direction(Coordinates, Level);
        while(!data.equals("B")){
            System.out.println("(1)North          (2)East          (3)South          (4)West "+
                    "(B)Back");
            Random rand = new Random();
            int chance = rand.nextInt(1000);
            boolean Fight = chance > 800;
            System.out.println("this is After "+Coordinates[0]+Coordinates[1]);
            switch (data) {
                case "1", "2", "3", "4" -> {
                    if (Fight) {
                        EnemyEncountered(Coordinates);
                    } else {
                        System.out.println(Arrays.toString(Coordinates));
                        data = Move.Direction(Coordinates, Level);
                    }
                }
                case "LevelUp" -> NewLevel();
                default -> {System.out.println("Wrong input\n");MoveMenu();}
            }
        }
        ContinueMenu();
    }
    @Override
    public void EnemyEncountered(int[] tempCor){
        Scanner scan = new Scanner(System.in);
        clearScreen();
        Coordinates = tempCor;
        Random ran = new Random();
        String outcome;
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
                "* Your stats for "+CharacterName+" who's a "+className+" with HP:"+Hp+" Atk: "+Atk+" Def: "+Def+" Dodge: "+Dodge+"*\n"+
                "*          (1)Fight                              (2)Run                 *\n"+
                "*                                                                       *\n"+
                "*           (B)Back                                                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
        switch (scan.nextLine()){
            case "1" -> {
                outcome = result.Battle(Hp, Atk, Def, Dodge, Level);
                if (outcome.equals("won")) {
                    Hp = result.getTmpHp();
                    FightWon();
                }
                if (outcome.equals("lost"))
                    FightLost();
            }
            case "2" -> {
                if (Fight)
                    RanAway();
                else {
                    RunFail();
                }
            }
            case "B" -> StartMenu();
            default -> {System.out.println("Wrong input\n");EnemyEncountered(Coordinates);}
        }
    }


//    carry on here
    @Override
    public void FightWon(){
        Stats stat = new Stats();
        Exp += 20;
        String up = stat.LevelUp(Exp, Level);
        if (up.equals("LeveledUp")) {
            Hp = 100;
            Atk += stat.getAtk();
            Dodge += stat.getDodge();
            Def += stat.getDef();
            Exp += stat.getExp();
        }
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
        if(up.equals("LeveledUp")){System.out.println("your exp leveled up and new stats are HP:"+Hp+" Atk: "+Atk+" Dodge: "+Dodge+" Def: "+Def);}
                System.out.println("*                  Great job, you won the fight                         *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");
        if (up.equals("Highest"))
            System.out.println("You cant Level up more because you on your highest level");
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
        ItemDropped();
    }
    @Override
    public void FightLost(){
        Coordinates[0] = 0;
        Coordinates[1] = 0;
        Hp = 100;
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
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
        StartMenu();
    }
    @Override
    public void ItemDropped(){
        Scanner scan = new Scanner(System.in);
        Stats check = new Stats();
        String drop = check.RandomE();
        check.Equipment(drop);
        int tatk = check.getAtk();
        int tdef = check.getDef();
        int tdodge = check.getDodge();
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
                "*     Oh the enemy dropped "+drop+" with Atk: "+tatk+" Def: "+tdef+" Dodge: "+tdodge+". do you wanna keep it?     *\n"+
                "*     (1)Keep                              (2)Leave                     *\n"+
                "*                                                                       *\n"+
                "*************************************************************************\n");

        switch(scan.nextLine()) {
            case "1" -> {
                if (drop.equals("Helm"))
                    Helm = drop;
                if (drop.equals("Armour"))
                    Armour = drop;
                if (drop.equals("Weapon"))
                    Weapon = drop;
                Atk += tatk;
                Def += tdef;
                Dodge += tdodge;
                MoveMenu();
            }
            case "2" -> MoveMenu();
            default -> {
                System.out.println("Wrong input\n");
                ItemDropped();
            }
        }
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
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
        MoveMenu();
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
        Fight result = new Fight();
        String outcome = result.Battle(Hp, Atk, Def, Dodge, Level);
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
        if (outcome.equals("won")) {
            Hp = result.getTmpHp();
            FightWon();
        }
        if (outcome.equals("lost"))
            FightLost();
    }
    @Override
    public void NewLevel(){

        clearScreen();
        Coordinates[0] = 0;
        Coordinates[1] = 0;
        Hp = 100;
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
        saveData();
        if (Level == 6){
            System.out.println("Congrats on winning the game. You will be returned to Main Menu");
            StartMenu();
        }
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
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
            default -> {System.out.println("Wrong input\n");QuitVerify();}
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
        System.out.println(className+"  "+CharacterName+"  "+Level+"  "+Exp+"  "+Dodge+"  "+Atk+"  "+Def+"  "+Hp+"  "+Helm+"  "+Armour+"  "+Weapon);
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
        PlayerName = name[0];
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(file);
            setClassName(scanner.nextLine());
            System.out.println(className);
            setCharacterName(scanner.nextLine());
            System.out.println(CharacterName);
            setLevel(Integer.parseInt(scanner.nextLine()));
            System.out.println(Level);
            if (Level == 6) {
                System.out.println("Sorry this Character has already finished the game");
                scanner.close();
                StartMenu();
            }
            setExp(Integer.parseInt(scanner.nextLine()));
            System.out.println(Exp);
            setDodge(Integer.parseInt(scanner.nextLine()));
            System.out.println(Dodge);
            setAtk(Integer.parseInt(scanner.nextLine()));
            System.out.println(Atk);
            setDef(Integer.parseInt(scanner.nextLine()));
            System.out.println(Def);
            setHp(Integer.parseInt(scanner.nextLine()));
            System.out.println(Hp);

            setHelm(scanner.nextLine());
            System.out.println(Helm);
            stat.Equipment(Helm);
            setAtk(Atk + stat.getAtk());
            System.out.println(Atk);
            setDef(Def + stat.getDef());
            System.out.println(Def);
            setDodge(Dodge + stat.getDodge());
            System.out.println(Dodge);

            setArmour(scanner.nextLine());
            stat.Equipment(Armour);
            setAtk(Atk + stat.getAtk());
            System.out.println(Atk);
            setDef(Def + stat.getDef());
            System.out.println(Def);
            setDodge(Dodge + stat.getDodge());
            System.out.println(Dodge);

            setWeapon(scanner.nextLine());
            stat.Equipment(Weapon);
            setAtk(Atk + stat.getAtk());
            System.out.println(Atk);
            setDef(Def + stat.getDef());
            System.out.println(Def);
            setDodge(Dodge + stat.getDodge());
            System.out.println(Dodge);

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}