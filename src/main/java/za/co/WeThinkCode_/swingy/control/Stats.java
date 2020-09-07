package control;

import za.co.WeThinkCode_.swingy.model.Var;

@Getter
@Setter
public class Stats{
    private Characters stats;

    public class AssasinStats{
        stats.Hp = 100;
        stats.Atk = 50;
        stats.Def = 50;
        stats.Dodge = 50;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    public class TankStats{
        stats.Hp = 100;
        stats.Atk = 30;
        stats.Def = 70;
        stats.Dodge = 10;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    public class NecromancerStats{
        stats.Hp = 100;
        stats.Atk = 70;
        stats.Def = 30;
        stats.Dodge = 30;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    public class ArcherStats{
        stats.Hp = 100;
        stats.Atk = 50;
        stats.Def = 30;
        stats.Dodge = 70;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    public class EnemyStats{
        stats.Hp = 100;
        stats.Atk = 30;
        stats.Def = 30;
        stats.Dodge = 30;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }
}