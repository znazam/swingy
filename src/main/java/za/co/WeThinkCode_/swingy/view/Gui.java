package za.co.WeThinkCode_.swingy.view;

import za.co.WeThinkCode_.swingy.model.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements screens {

    protected JFrame f = new JFrame();
    protected JPanel p, StartP, LoadP, SelectHeroP,ArcherP, TankP, NecromancerP, AssassinP, StartBackP, DirectionP;
    protected JButton StartB, LoadB, ArcherB, TankB, NecromancerB, AssassinB, StartBackB, NorthB, WestB, EastB, SouthB;
    protected Container con;
    protected JLabel l = new JLabel("Swingy");
    protected Font TitleFont = new Font("Times New Roman", Font.PLAIN, 100);
    protected Font NormalFont = new Font("Times New Roman", Font.PLAIN, 30);;
    protected JTextArea SelectHeroT, ArcherT, TankT, NecromancerT, AssassinT;
    protected view viewMenu = new view();
    protected boolean SetupWindow = false;




//    DirectionB = new JPanel();
//    DirectionB.setBounds(250,350,300,150);
//    DirectionB.setBackground(Color.black);
//    DirectionB.setLayout(new GridLayout(4,1));
//    con.add(DirectionB);
//        NorthB = new JButton();
//        SouthB = new JButton();
//        EastB = new JButton();
//        WestB = new JButton();
//    NorthB.setBackground(Color.black);
//    NorthB.setForeground(Color.white);
//    NorthB.setFont(NormalFont);
//    SouthB.setBackground(Color.black);
//    SouthB.setForeground(Color.white);
//    SouthB.setFont(NormalFont);
//    WestB.setBackground(Color.black);
//    WestB.setForeground(Color.white);
//    WestB.setFont(NormalFont);
//    EastB.setBackground(Color.black);
//    EastB.setForeground(Color.white);
//    EastB.setFont(NormalFont);
//    DirectionB.add(NorthB);
//    DirectionB.add(WestB);
//    DirectionB.add(SouthB);
//    DirectionB.add(EastB);

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
//        font = new Font("Times New Roman", font.PLAIN, 100);
        if(!SetupWindow) {
            f.setSize(800, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().setBackground(Color.BLACK);
            f.setLayout(null);
            f.setVisible(true);
            SetupWindow = true;
        }


        p.setBounds(100, 100, 600, 150);
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

        LoadB.setBackground(Color.black);
        LoadB.setForeground(Color.red);
        LoadB.setFont(NormalFont);
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

    }

    @Override
    public void ContinueMenu() {

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
        ArcherT = new JTextArea("Atk: ??\nDef: ??\nDodge: ??");
        AssassinT = new JTextArea("Atk: ??\nDef: ??\nDodge: ??");
        NecromancerT = new JTextArea("Atk: ??\nDef: ??\nDodge: ??");
        TankT = new JTextArea("Atk: ??\nDef: ??\nDodge: ??");


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
        ArcherB.setFocusPainted(false);

        TankB.setBackground(Color.black);
        TankB.setForeground(Color.red);
        TankB.setFont(NormalFont);
        TankB.setFocusPainted(false);

        NecromancerB.setBackground(Color.black);
        NecromancerB.setForeground(Color.red);
        NecromancerB.setFont(NormalFont);
        NecromancerB.setFocusPainted(false);

        AssassinB.setBackground(Color.black);
        AssassinB.setForeground(Color.red);
        AssassinB.setFont(NormalFont);
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

    }

    @Override
    public void LoadGame() {

    }

    @Override
    public void SelectChar() {

    }

    @Override
    public void MoveMenu() {

    }

    @Override
    public void EnemyEncountered() {

    }

    @Override
    public void FightWon() {

    }

    @Override
    public void ItemDropped() {

    }

    @Override
    public void FightLost() {

    }

    @Override
    public void RanAway() {

    }

    @Override
    public void RunFail() {

    }

    @Override
    public void NewLevel() {

    }

    @Override
    public void QuitVerify() {

    }

    @Override
    public void QuitGame() {

    }

    void cpSM(){
        ArcherP.setVisible(false);
        AssassinP.setVisible(false);
        NecromancerP.setVisible(false);
        TankP.setVisible(false);
        SelectHeroP.setVisible(false);
        StartBackP.setVisible(false);
    }

    public class view implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (StartB.equals(e.getSource())) {
                cps();
                SelectClass();
            }
            else if (StartBackB.equals(e.getSource())) {
                cpSM();
                StartMenu();
            }
            else
                System.out.println("error going to different gui view when pressing button");
        }
    }

}