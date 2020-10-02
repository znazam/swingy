package za.co.WeThinkCode_.swingy.view;

import lombok.Data;
import za.co.WeThinkCode_.swingy.control.Fight;
import za.co.WeThinkCode_.swingy.model.Stats;
import za.co.WeThinkCode_.swingy.model.screens;

import javax.swing.*;
import javax.validation.constraints.Size;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@Data
public class Gui implements screens {

    String saveFilePath = new File("").getAbsolutePath().concat("\\SaveFiles\\");
    protected int Atk,finish, Def,Dodge,Exp = 0;
    protected String className;
    @Size(min = 2, max = 10)
    protected String PlayerName,CharacterName,Dir;
    protected int Level = 1;
    protected int Hp = 100;
    protected String Helm = "Leather";
    protected String Armour = "Leather";
    protected String Weapon = "Leather";
    protected int[] Coordinates = {0,0};
    String outcome;
    String Invalid = "";

//    protected JEditorPane Dir;
    protected JFrame f = new JFrame();
    protected JPanel p,LevelP,CaughtP,RanP,LostP,ItemP,EnemyP,WonP,OptionP,LoadFileP, ContinueP, CBackP,NameP, StartP, LoadP, SelectHeroP,ArcherP, TankP, NecromancerP, AssassinP, StartBackP, DirectionP;
    protected JButton StartB,DropB,LeaveB,FightB,RunB, ContinueB,CBackB, NameB, LoadB, ArcherB, TankB, NecromancerB, AssassinB, StartBackB, NorthB, WestB, EastB, SouthB;
    protected Container con;
    protected JLabel l = new JLabel("Swingy");
    protected Font TitleFont = new Font("Times New Roman", Font.PLAIN, 100);
    protected Font NormalFont = new Font("Times New Roman", Font.PLAIN, 30);
    protected JTextArea FinishT,NameT,InvalidT,LoadT,LevelT,CaughtT,RanT,LostT,DropT,WonT,EnemyT, DirectionT,SelectHeroT, ArcherT, TankT, NecromancerT, AssassinT;
    protected JTextField InputT, LoadFileT;
    protected view viewMenu = new view();
    protected boolean SetupWindow = false;





//    to set a text from a variable use label.setText(variable); in a method and for number label.setText("" + variable); export DISPLAY=:0.0

//    public static void main(String[] args){
//        Gui run = new Gui();
//        run.MainMenu();
//    }
    @Override
    public void StartMenu() {
        //l = new JLabel("Swingy");
//        f = new JFrame();
        p = new JPanel();
        StartP = new JPanel();
        LoadP = new JPanel();
        LoadB = new JButton("Load");
        StartB = new JButton("Start");
        FinishT = new JTextArea("Sorry you already finished the game with that Character");
//        font = new Font("Times New Roman", font.PLAIN, 100);
        if(!SetupWindow) {
            f.setSize(1000, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().setBackground(Color.BLACK);
            f.setLayout(null);
            f.setVisible(true);
            SetupWindow = true;
        }

        FinishT.setBounds(0,0,800,100);
        FinishT.setBackground(Color.black);
        FinishT.setForeground(Color.red);
        FinishT.setFont(NormalFont);
        FinishT.setLineWrap(true);

        p.setBounds(100, 100, 800, 200);
        p.add(l);
        p.setBackground(Color.black);

        StartP.setBounds(100, 400, 200, 100);
        StartP.setBackground(Color.black);
        StartP.add(StartB);

        StartB.setBackground(Color.black);
        StartB.setForeground(Color.red);
        StartB.setFont(NormalFont);
        StartB.addActionListener(viewMenu);
        StartB.setFocusPainted(false);

        LoadP.setBounds(400, 400, 200, 100);
        LoadP.setBackground(Color.black);
        LoadP.add(LoadB);
        if (finish == 1) {
            p.add(FinishT);
            finish = 0;
        }

        LoadB.setBackground(Color.black);
        LoadB.setForeground(Color.red);
        LoadB.setFont(NormalFont);
        LoadB.addActionListener(viewMenu);
        LoadB.setFocusPainted(false);

        l.setForeground(Color.red);
        l.setFont(TitleFont);

        con = f.getContentPane();
        con.add(p);
        con.add(StartP);
        con.add(LoadP);


    }

    @Override
    public void NewGame() {
        NameP = new JPanel();
        NameT = new JTextArea("What's your name?");
        InputT = new JTextField(30);

        NameT.setBounds(50,50,600,100);
        NameT.setBackground(Color.black);
        NameT.setForeground(Color.red);
        NameT.setFont(NormalFont);
        NameT.setLineWrap(true);

        InputT.addActionListener(e -> {
            PlayerName = InputT.getText();
            cpNG();
            System.out.println(PlayerName);
            SelectClass();
        });

        NameP.setBounds(50,50,600,100);
        NameP.setBackground(Color.black);
        NameP.add(NameT);
        NameP.add(InputT);

        con.add(NameP);

    }

    void cpNG(){
        NameP.setVisible(false);
    }

    @Override
    public void ContinueMenu() {
        System.out.println("Entered ContinueMenu");
        p = new JPanel();
        StartP = new JPanel();
        LoadP = new JPanel();
        LoadB = new JButton("Load");
        StartB = new JButton("Start");
        ContinueP = new JPanel();
        ContinueB = new JButton("Continue");


        p.setBounds(100, 100, 600, 150);
        p.add(l);
        p.setBackground(Color.black);

        StartP.setBounds(100, 400, 200, 100);
        StartP.setBackground(Color.black);
        StartP.add(StartB);

        ContinueP.setBounds(20,500, 200, 100);
        ContinueP.setBackground(Color.black);
        ContinueP.add(ContinueB);

        ContinueB.setBackground(Color.black);
        ContinueB.setForeground(Color.RED);
        ContinueB.setFont(NormalFont);
        ContinueB.addActionListener(e -> {
            p.setVisible(false);
            StartP.setVisible(false);
            LoadP.setVisible(false);
            ContinueP.setVisible(false);
            MoveMenu();
        });
        ContinueB.setFocusPainted(false);

        StartB.setBackground(Color.black);
        StartB.setForeground(Color.red);
        StartB.setFont(NormalFont);
        StartB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                StartP.setVisible(false);
                LoadP.setVisible(false);
                ContinueP.setVisible(false);
                MoveMenu();
            }
        });
        StartB.setFocusPainted(false);

        LoadP.setBounds(400, 400, 200, 100);
        LoadP.setBackground(Color.black);
        LoadP.add(LoadB);

        LoadB.setBackground(Color.black);
        LoadB.setForeground(Color.red);
        LoadB.setFont(NormalFont);
        LoadB.setFocusPainted(false);
        LoadB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                StartP.setVisible(false);
                LoadP.setVisible(false);
                ContinueP.setVisible(false);
                LoadGame();
            }
        });

        con.add(p);
        con.add(StartP);
        con.add(LoadP);
        con.add(ContinueP);
    }

    void cps() {
        p.setVisible(false);
        StartP.setVisible(false);
        LoadP.setVisible(false);
    }

    @Override
    public void SelectClass(){

        ArcherB = new JButton("Archer");
        ArcherP = new JPanel();
        AssassinB = new JButton("Assassin");
        AssassinP = new JPanel();
        StartBackP = new JPanel();
        StartBackB = new JButton("Back");
        NecromancerB = new JButton("Necromancer");
        NecromancerP = new JPanel();
        TankB = new JButton("Tank");
        TankP = new JPanel();
        SelectHeroP = new JPanel();
        SelectHeroT = new JTextArea("Select a hero to start the game");
        ArcherT = new JTextArea("Atk: 50\nDef: 30\nDodge: 70");
        AssassinT = new JTextArea("Atk: 50\nDef: 50\nDodge: 50");
        NecromancerT = new JTextArea("Atk: 70\nDef: 30\nDodge: 30");
        TankT = new JTextArea("Atk: 30\nDef: 70\nDodge: 10");


        SelectHeroT.setBounds(50,50,600,100);
        SelectHeroT.setBackground(Color.black);
        SelectHeroT.setForeground(Color.red);
        SelectHeroT.setFont(NormalFont);
        SelectHeroT.setLineWrap(true);

        TankT.setBackground(Color.black);
        TankT.setForeground(Color.red);
        TankT.setFont(NormalFont);

        AssassinT.setBackground(Color.black);
        AssassinT.setForeground(Color.red);
        AssassinT.setFont(NormalFont);

        ArcherT.setBackground(Color.black);
        ArcherT.setForeground(Color.red);
        ArcherT.setFont(NormalFont);

        NecromancerT.setBackground(Color.black);
        NecromancerT.setForeground(Color.red);
        NecromancerT.setFont(NormalFont);


        StartBackP.setBounds(20,500, 70, 50);
        StartBackP.setBackground(Color.black);
        StartBackP.add(StartBackB);

        StartBackB.setBackground(Color.black);
        StartBackB.setForeground(Color.RED);
        StartBackB.setFont(NormalFont);
        StartBackB.addActionListener(viewMenu);
        StartBackB.setFocusPainted(false);


        SelectHeroP.setBounds(50,50,600,100);
        SelectHeroP.setBackground(Color.black);
        SelectHeroP.add(SelectHeroT);

        ArcherP.setBounds(20,200,180,200);
        ArcherP.setBackground(Color.black);
        ArcherP.add(ArcherB);
        ArcherP.add(ArcherT);

        AssassinP.setBounds(200,200,180,200);
        AssassinP.setBackground(Color.black);
        AssassinP.add(AssassinB);
        AssassinP.add(AssassinT);

        NecromancerP.setBounds(380,200,180,200);
        NecromancerP.setBackground(Color.black);
        NecromancerP.add(NecromancerB);
        NecromancerP.add(NecromancerT);

        TankP.setBounds(560,200,180,200);
        TankP.setBackground(Color.black);
        TankP.add(TankB);
        TankP.add(TankT);

        ArcherB.setBackground(Color.black);
        ArcherB.setForeground(Color.red);
        ArcherB.setFont(NormalFont);
        ArcherB.addActionListener(viewMenu);
        ArcherB.setFocusPainted(false);

        TankB.setBackground(Color.black);
        TankB.setForeground(Color.red);
        TankB.setFont(NormalFont);
        TankB.addActionListener(viewMenu);
        TankB.setFocusPainted(false);

        NecromancerB.setBackground(Color.black);
        NecromancerB.setForeground(Color.red);
        NecromancerB.setFont(NormalFont);
        NecromancerB.addActionListener(viewMenu);
        NecromancerB.setFocusPainted(false);

        AssassinB.setBackground(Color.black);
        AssassinB.setForeground(Color.red);
        AssassinB.setFont(NormalFont);
        AssassinB.addActionListener(viewMenu);
        AssassinB.setFocusPainted(false);

        con.add(SelectHeroP);
        con.add(AssassinP);
        con.add(TankP);
        con.add(NecromancerP);
        con.add(ArcherP);
        con.add(StartBackP);

    }

    @Override
    public void ClassName() {
        NameP = new JPanel();
        NameT = new JTextArea("What name do bestow upon this hero?");
        InputT = new JTextField(30);

        NameT.setBounds(50,50,600,100);
        NameT.setBackground(Color.black);
        NameT.setForeground(Color.red);
        NameT.setFont(NormalFont);
        NameT.setLineWrap(true);

        InputT.addActionListener(e -> {
            CharacterName = InputT.getText();

            System.out.println(CharacterName);
            NameP.setVisible(false);
            saveData();
            MoveMenu();
        });

        NameP.setBounds(50,50,600,100);
        NameP.setBackground(Color.black);
        NameP.add(NameT);
        NameP.add(InputT);

        con.add(NameP);
    }

    @Override
    public void LoadGame() {
        LoadFileT = new JTextField(30);
        LoadFileP = new JPanel();
        File file = new File(saveFilePath);

        LoadFileP = new JPanel();
        LoadT = new JTextArea("Type the name of your saved file will enter match when right file was entered\n");
        InputT = new JTextField(30);

        InvalidT = new JTextArea(Invalid);
        InvalidT.setBounds(100,50,600,100);
        InvalidT.setBackground(Color.black);
        InvalidT.setForeground(Color.red);
        InvalidT.setFont(NormalFont);
        InvalidT.setLineWrap(true);
        LoadT.setBounds(50,50,600,100);
        LoadT.setBackground(Color.black);
        LoadT.setForeground(Color.red);
        LoadT.setFont(NormalFont);
        LoadT.setLineWrap(true);


        LoadFileP.setBounds(50,50,900,900);
        LoadFileP.setBackground(Color.black);
        LoadFileP.add(LoadT);
        LoadFileP.add(LoadFileT);
        LoadFileP.add(InvalidT);
        File[] fileNames = file.listFiles();
        ArrayList<String> validInputs = new ArrayList<>();
        for (File fileName : fileNames) {

            validInputs.add(fileName.getName().split("\\.")[0]);

        }
        for (String validInput : validInputs) {
            LoadT.append("- "+validInput+"\n");
            System.out.println("*- ".concat(validInput));
        }

        LoadFileT.addActionListener(e -> {
            System.out.println("Came here ");
            String[] input = {""};
            input[0] = "";

                System.out.println("entered while ");
                input[0]  = LoadFileT.getText();

                if (validInputs.contains(input[0]))
                    {
//                        LoadFileT.setText("");
//                    System.out.println("entered if");
//                    Invalid = "\nInvalid choice";
//                    LoadFileP.setVisible(false);
//                    LoadGame();
                        LoadFileP.setVisible(false);
                        loadHero(input);
                        MoveMenu();
                }

            System.out.println("exit while ");
        });

        con.add(LoadFileP);
    }

    @Override
    public void MoveMenu() {
        DirectionP = new JPanel();
        DirectionP.setBounds(250,350,300,150);
        DirectionP.setBackground(Color.black);
        DirectionP.setLayout(new GridLayout(5,1));
        DirectionT = new JTextArea();
        DirectionT.setBounds(100,50,600,100);
        DirectionT.setBackground(Color.black);
        DirectionT.setForeground(Color.red);
        DirectionT.setFont(NormalFont);
        DirectionT.setLineWrap(true);
        CBackP = new JPanel();
        CBackB = new JButton("Back");
        NameP = new JPanel();
        NameP.setBounds(0,0,600,100);
        NameP.setBackground(Color.black);
        NameT = new JTextArea("Which Direction would you like to go?");
        NameT.setBounds(50,50,600,100);
        NameT.setBackground(Color.black);
        NameT.setForeground(Color.red);
        NameT.setFont(NormalFont);
        NameT.setLineWrap(true);


        int map = (Level-1)*5+10-(Level%2);
        NorthB = new JButton("North");
        SouthB = new JButton("South");
        EastB = new JButton("East");
        WestB = new JButton("West");
        NorthB.setBackground(Color.black);
        NorthB.setForeground(Color.red);
        NorthB.setFont(NormalFont);
        NorthB.addActionListener(e -> {
            Random rand = new Random();
            int chance = rand.nextInt(1000);
            boolean Fight = chance > 800;
            if (Fight) {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                EnemyEncountered(Coordinates);
            }
            if (!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map)) {
                Coordinates[0] += 1;
                System.out.println("this is After in north" + Coordinates[0] + Coordinates[1]);
                DirectionT.append(Dir);
//                DirectionP.setVisible(false);
//                NameP.setVisible(false);
//                CBackP.setVisible(false);
//                MoveMenu();
            }
            if ((Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map))
            {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                NewLevel();
            }
        });

        SouthB.setBackground(Color.black);
        SouthB.setForeground(Color.red);
        SouthB.setFont(NormalFont);
        SouthB.addActionListener(e -> {
            Random rand = new Random();
            int chance = rand.nextInt(1000);
            boolean Fight = chance > 800;
            System.out.println("this is After "+Coordinates[0]+Coordinates[1]);
            if (Fight) {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                EnemyEncountered(Coordinates);
            }
            if (!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map)) {
                Coordinates[0] -= 1;
                System.out.println("this is After in South" + Coordinates[0] + Coordinates[1]);
                Dir = "You moved South";
                DirectionT.append(Dir);
//                DirectionP.setVisible(false);
//                NameP.setVisible(false);
//                CBackP.setVisible(false);
//                MoveMenu();
            }
            if ((Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map))
            {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                NewLevel();
            }
        });

        WestB.setBackground(Color.black);
        WestB.setForeground(Color.red);
        WestB.setFont(NormalFont);
        WestB.addActionListener(e -> {
            Random rand = new Random();
            int chance = rand.nextInt(1000);
            boolean Fight = chance > 800;
            System.out.println("this is After "+Coordinates[0]+Coordinates[1]);
            if (Fight) {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                EnemyEncountered(Coordinates);
            }
            if (!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map)) {
                Coordinates[1] -= 1;
                System.out.println("this is After in west" + Coordinates[0] + Coordinates[1]);
                Dir = "You moved west";
                DirectionT.append(Dir);
//                DirectionP.setVisible(false);
//                NameP.setVisible(false);
//                CBackP.setVisible(false);
//                MoveMenu();
            }
            if ((Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map))
            {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                NewLevel();
            }
        });

        EastB.setBackground(Color.black);
        EastB.setForeground(Color.red);
        EastB.setFont(NormalFont);
        EastB.addActionListener(e -> {
            Random rand = new Random();
            int chance = rand.nextInt(1000);
            boolean Fight = chance > 800;
            System.out.println("this is After "+Coordinates[0]+Coordinates[1]);
            if (Fight) {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                EnemyEncountered(Coordinates);
            }
            if (!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map)) {
                Coordinates[1] += 1;
                System.out.println("this is After in East" + Coordinates[0] + Coordinates[1]);
                Dir = "You moved East";
                DirectionT.append(Dir);
//                DirectionP.setVisible(false);
//                NameP.setVisible(false);
//                CBackP.setVisible(false);
//                MoveMenu();
            }
            if ((Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map * -1)) || (Coordinates[1] >= map))
            {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                NewLevel();
            }
        });

        CBackP.setBounds(20,500, 70, 50);
        CBackP.setBackground(Color.black);
        CBackP.add(CBackB);

        CBackB.setBackground(Color.black);
        CBackB.setForeground(Color.RED);
        CBackB.setFont(NormalFont);
        CBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                ContinueMenu();
            }
        });

//        DirectionP.add(NameT);
        DirectionP.add(NorthB);
        DirectionP.add(WestB);
        DirectionP.add(SouthB);
        DirectionP.add(EastB);
        DirectionP.add(DirectionT);

        NameP.add(NameT);

        con.add(DirectionP);
        con.add(NameP);
        con.add(CBackP);


    }

    @Override
    public void EnemyEncountered(int[] tempCor) {
        Coordinates = tempCor;

        Random ran = new Random();
        int chance = ran.nextInt(100);
        boolean Fight = chance > 50;
        Stats stat = new Stats();
        stat.EnemyStats(Level);
        Fight result = new Fight();


        EnemyP = new JPanel();
        EnemyP.setBounds(0,0,1000,300);
        EnemyP.setBackground(Color.black);
        EnemyT = new JTextArea("You encountered an enemy! Do you wanna fight or run?\nHis stats are Atk: "+stat.getAtk()+" Def: "+stat.getDef()+" Dodge: "+stat.getDodge()+"\nYour stats for "+CharacterName+" who's a "+className+" with HP:"+Hp+" Atk: "+Atk+" Def: "+Def+" Dodge: "+Dodge);
        EnemyT.setBounds(50,50,1000,300);
        EnemyT.setBackground(Color.black);
        EnemyT.setForeground(Color.red);
        EnemyT.setFont(NormalFont);
        EnemyT.setLineWrap(true);
        FightB = new JButton("Fight");
        RunB = new JButton("Run");
        EnemyP.add(EnemyT);


        OptionP = new JPanel();
        OptionP.setBounds(100,400,300,150);
        OptionP.setBackground(Color.black);
        OptionP.setLayout(new GridLayout(2,1));
        OptionP.add(FightB);
        OptionP.add(RunB);


        FightB.setBackground(Color.black);
        FightB.setForeground(Color.red);
        FightB.setFont(NormalFont);
        FightB.addActionListener(e -> {
            outcome = result.Battle(Hp, Atk, Def, Dodge, Level);
            if (outcome.equals("won")) {
                Hp = result.getTmpHp();
                OptionP.setVisible(false);
                EnemyP.setVisible(false);
                FightWon();
            }
            if (outcome.equals("lost")) {
                OptionP.setVisible(false);
                EnemyP.setVisible(false);
                FightLost();
            }

        });
        FightB.setFocusPainted(false);



        RunB.setBackground(Color.black);
        RunB.setForeground(Color.red);
        RunB.setFont(NormalFont);
        RunB.setFocusPainted(false);
        RunB.addActionListener(e -> {
            OptionP.setVisible(false);
            EnemyP.setVisible(false);
            if (Fight) {
                RanAway();
            }
            else {
                RunFail();
            }
        });

        con.add(EnemyP);
        con.add(OptionP);
    }

    @Override
    public void FightWon() {
        Stats stat = new Stats();
        Exp += 50;
        String up = stat.LevelUp(Exp, Level);
        if (up.equals("LeveledUp")) {
            Hp = 100;
            Atk += stat.getAtk();
            Dodge += stat.getDodge();
            Def += stat.getDef();
            Exp += stat.getExp();
        }

        WonP = new JPanel();
        WonP.setBounds(0,0,1000,300);
        WonP.setBackground(Color.black);
        if(up.equals("LeveledUp")){
            WonT = new JTextArea("your exp leveled up and new stats are HP:"+Hp+" Atk: "+Atk+" Dodge: "+Dodge+" Def: "+Def+"\n Great job on winning the fight");
        }
        else if (up.equals("Highest"))
            WonT = new JTextArea("You cant Level up more because you on your highest level");
        else
            WonT = new JTextArea("Great job on winning the fight");
        WonT.setBounds(50,50,1000,300);
        WonT.setBackground(Color.black);
        WonT.setForeground(Color.red);
        WonT.setFont(NormalFont);
        WonT.setLineWrap(true);
        WonP.add(WonT);

        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}

            cpfw();

        con.add(WonP);
    }

    void cpfw(){WonP.setVisible(false);
        ItemDropped();}
    @Override
    public void ItemDropped() {
        Stats check = new Stats();
        String drop = check.RandomE();
        check.Equipment(drop);
        int tatk = check.getAtk();
        int tdef = check.getDef();
        int tdodge = check.getDodge();




        ItemP = new JPanel();
        ItemP.setBounds(0,0,1000,300);
        ItemP.setBackground(Color.black);
        DropT = new JTextArea("Oh the enemy dropped "+drop+" with Atk: "+tatk+" Def: "+tdef+" Dodge: "+tdodge+". do you wanna keep it?");
        DropT.setBounds(50,50,1000,300);
        DropT.setBackground(Color.black);
        DropT.setForeground(Color.red);
        DropT.setFont(NormalFont);
        DropT.setLineWrap(true);
        DropB = new JButton("Take");
        LeaveB = new JButton("Leave");
        ItemP.add(DropT);


        OptionP = new JPanel();
        OptionP.setBounds(100,400,300,150);
        OptionP.setBackground(Color.black);
        OptionP.setLayout(new GridLayout(2,1));
        OptionP.add(DropB);
        OptionP.add(LeaveB);


        DropB.setBackground(Color.black);
        DropB.setForeground(Color.red);
        DropB.setFont(NormalFont);
        DropB.addActionListener(e -> {
            OptionP.setVisible(false);
            ItemP.setVisible(false);
            if(drop.equals("Helm"))
                Helm = drop;
            if (drop.equals("Armour"))
                Armour = drop;
            if (drop.equals("Weapon"))
                Weapon = drop;
            Atk += tatk;
            Def += tdef;
            Dodge += tdodge;
            MoveMenu();

        });
        DropB.setFocusPainted(false);



        LeaveB.setBackground(Color.black);
        LeaveB.setForeground(Color.red);
        LeaveB.setFont(NormalFont);
        LeaveB.setFocusPainted(false);
        LeaveB.addActionListener(e -> {
            OptionP.setVisible(false);
            ItemP.setVisible(false);
            MoveMenu();
        });

        con.add(ItemP);
        con.add(OptionP);
    }

    @Override
    public void FightLost() {
        Coordinates[0] = 0;
        Coordinates[1] = 0;
        Hp = 100;

        LostP = new JPanel();
        LostP.setBounds(0,0,1000,300);
        LostP.setBackground(Color.black);
        LostT = new JTextArea("Oh no, you were defeated\nYou will lose all your exp and items gained in this level");
        LostT.setBounds(50,50,1000,300);
        LostT.setBackground(Color.black);
        LostT.setForeground(Color.red);
        LostT.setFont(NormalFont);
        LostT.setLineWrap(true);
        LostP.add(LostT);

        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
            cpfl();
        con.add(LostP);

    }

    void   cpfl(){LostP.setVisible(false);
        StartMenu();}
    @Override
    public void RanAway() {
        RanP = new JPanel();
        RanP.setBounds(0,0,1000,300);
        RanP.setBackground(Color.black);
        RanT = new JTextArea("You successfully ran away. That was either smart or shameful");
        RanT.setBounds(50,50,1000,300);
        RanT.setBackground(Color.black);
        RanT.setForeground(Color.red);
        RanT.setFont(NormalFont);
        RanT.setLineWrap(true);
        RanP.add(RanT);

        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}

            cpra();
        con.add(RanP);
    }

    void cpra(){RanP.setVisible(false);
        MoveMenu();}
    @Override
    public void RunFail() {
        CaughtP = new JPanel();
        CaughtP.setBounds(0,0,1000,300);
        CaughtP.setBackground(Color.black);
        CaughtT = new JTextArea("You weren't fast enough and was forced to fight");
        CaughtT.setBounds(50,50,1000,300);
        CaughtT.setBackground(Color.black);
        CaughtT.setForeground(Color.red);
        CaughtT.setFont(NormalFont);
        CaughtT.setLineWrap(true);
        CaughtP.add(CaughtT);
//        try { Thread.sleep(10000);} catch (InterruptedException ex) {ex.printStackTrace();}
//        CaughtP.setVisible(false);
        Fight result = new Fight();
        String outcome = result.Battle(Hp, Atk, Def, Dodge, Level);
        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
        if (outcome.equals("won")) {
            Hp = result.getTmpHp();
            CaughtP.setVisible(false);
            FightWon();
        }
        if (outcome.equals("lost")){
            CaughtP.setVisible(false);
            FightLost();}
        con.add(CaughtP);
    }

    @Override
    public void NewLevel() {
        Coordinates[0] = 0;
        Coordinates[1] = 0;
        Hp = 100;

        LevelP = new JPanel();
        LevelP.setBounds(0,0,1000,300);
        LevelP.setBackground(Color.black);
        Level += 1;
        saveData();
        if (Level == 6){
            LevelT = new JTextArea("Congrats on winning the game. You will be returned to Main Menu");
            LevelP.setVisible(false);
            StartMenu();
        }
        else
            LevelT = new JTextArea("Well done!!! You made it through the level");
        LevelT.setBounds(50,50,1000,300);
        LevelT.setBackground(Color.black);
        LevelT.setForeground(Color.red);
        LevelT.setFont(NormalFont);
        LevelT.setLineWrap(true);
        LevelP.add(LevelT);

        try { Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}

            cpnl();

        con.add(LevelP);

    }

    void cpnl(){LevelP.setVisible(false);
        MoveMenu();}

    @Override
    public void QuitVerify() {

    }

    @Override
    public void QuitGame() {

    }

    void cpSC(){
        ArcherP.setVisible(false);
        AssassinP.setVisible(false);
        NecromancerP.setVisible(false);
        TankP.setVisible(false);
        SelectHeroP.setVisible(false);
        StartBackP.setVisible(false);
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
                finish = 1;
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

    public class view implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (StartB.equals(e.getSource())) {
                cps();
                NewGame();
            }
            else if (LoadB.equals(e.getSource())){
                cps();
                LoadGame();
            }
            else if (ArcherB.equals(e.getSource())){
                cpSC();
                Stats stat = new Stats();
                stat.ArcherStats();
                setClassName("Archer");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(Atk+" "+Def+" "+Dodge);
                ClassName();
            }
            else if (AssassinB.equals(e.getSource())) {
                cpSC();
                Stats stat = new Stats();
                stat.AssassinStats();
                setClassName("Assassin");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk() + " " + getDef() + " " + getDodge());
                ClassName();
            }
            else if (TankB.equals(e.getSource())){
                cpSC();
                Stats stat = new Stats();
                stat.TankStats();
                setClassName("Tank");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk()+" "+getDef()+" "+getDodge());
                ClassName();
            }
            else if (NecromancerB.equals(e.getSource())){
                cpSC();
                Stats stat = new Stats();
                stat.NecromancerStats();
                setClassName("Necromancer");
                setAtk(stat.getAtk());
                setDef(stat.getDef());
                setDodge(stat.getDodge());
                System.out.println(getAtk()+" "+getDef()+" "+getDodge());
                ClassName();
            }
            else if (StartBackB.equals(e.getSource())) {
                cpSC();
                StartMenu();
            }
            else if (CBackB.equals(e.getSource())){
                DirectionP.setVisible(false);
                NameP.setVisible(false);
                CBackP.setVisible(false);
                ContinueMenu();
            }
            else
                System.out.println("error going to different gui view when pressing button");
        }
    }

}