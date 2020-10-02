package za.co.WeThinkCode_.swingy.control;

import lombok.Getter;
import za.co.WeThinkCode_.swingy.model.Stats;

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
//        Hp += Def;
//        enemyHp += enemyDef;
        while (enemyHp >= 0 && Hp >= 0){
            hit = random.nextInt(200) < Dodge;
            miss = random.nextInt(200) < enemyDodge;
            if (hit){
                if (enemyDef >= 1)
                    enemyDef -= Atk;
                else
                    enemyHp -= Atk;}
            else
            enemyHp -= 0;
            if (miss) {
                if (Def >= 1)
                    Def -= enemyAtk;
                else
                    Hp -= enemyAtk;
            }
            else Hp -= 0;
        }
        if (enemyHp <= 0) {
            tmpHp = Hp;
            return "won";
        }
        else
            return "lost";



    }
}