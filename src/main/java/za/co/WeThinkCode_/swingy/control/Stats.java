package control;

import za.co.WeThinkCode_.swingy.model;

class Stats{
    private Characters stats;

    class AssasinStats{
        stats.Hp = 100;
        stats.Atk = 50;
        stats.Def = 50;
        stats.Dodge = 50;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    class TankStats{
        stats.Hp = 100;
        stats.Atk = 30;
        stats.Def = 70;
        stats.Dodge = 10;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    class NecromancerStats{
        stats.Hp = 100;
        stats.Atk = 70;
        stats.Def = 30;
        stats.Dodge = 30;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    class ArcherStats{
        stats.Hp = 100;
        stats.Atk = 50;
        stats.Def = 30;
        stats.Dodge = 70;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }

    class EnemyStats{
        stats.Hp = 100;
        stats.Atk = 30;
        stats.Def = 30;
        stats.Dodge = 30;
        stats.Helm = 0;
        stats.Armor = 0;
        stats.Weapon = 0;
    }
}