package za.co.WeThinkCode_.swingy.control;

import lombok.Getter;
import za.co.WeThinkCode_.swingy.model.Stats;
import za.co.WeThinkCode_.swingy.view.Console;

import java.util.Random;

public class Fight{
    Random random = new Random();
    boolean miss, hit;
    Stats enemyStat = new Stats();
    int enemyHp = 100;
    @Getter
    protected int tmpHp;
    public String Battle(int Hp, int Atk, int Def, int Dodge, int Level){
        enemyStat.EnemyStats(Level);
        int enemyAtk = enemyStat.getAtk();
        int enemyDef = enemyStat.getDef();
        int enemyDodge = enemyStat.getDodge();
        System.out.println(Hp+"  "+Atk+"   "+Def+"  "+Dodge+"   "+Level);
        Hp += Def;
        enemyHp += enemyDef;
        while (enemyHp >= 0 && Hp >= 0){
            System.out.println("Problem is at hit random");
            hit = random.nextInt(200) < Dodge;
            System.out.println("Problem is at miss random");
            miss = random.nextInt(200) < enemyDodge;
            System.out.println("Problem is at if hit");
            if (hit){
                System.out.println("this is enemyhp now: "+enemyHp);
                enemyHp -= Atk;}
            else
            enemyHp -= 0;
            System.out.println("Problem is at miss if");
            if (miss){
                Hp -= enemyAtk;
                System.out.println("this is hero hp now: "+Hp);}
            else Hp -= 0;
        }
        System.out.println("Problem is at if enemyhp");
        System.out.println("enemy "+enemyHp);
        System.out.println("Hero "+Hp);
        if (enemyHp <= 0) {
            tmpHp = Hp;
            return "won";
        }
        else
            return "lost";



    }
}