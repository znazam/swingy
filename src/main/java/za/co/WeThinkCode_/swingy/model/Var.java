package model;

class Var{

    class Characters{
        private String Assasin; //equal defence and attack and dodge
        private String Tank; //more defence
        private String Necromancer; //more Attack
        private String Archer; //higher chance to dodge
        private String Enemy;
        private String ClassName;
        private String Player;
        private String Atk;
        private String Def;
        private String Hp;
        private String Dmg;
        private String Dodge;
        private String Artifects;
        private ArrayList<String> Helm = new ArrayList<String>();
        private ArrayList<String> Armour = new ArrayList<String>();
        private ArrayList<String> Weapon = new ArrayList<String>();
        private String Exp;
        private String Level;
        private String Fight;
        private String Run;
        private String Keep;
        private String Leave;
    }

    class Directions {
        private String North;
        private String West;
        private String East;
        private String South;
        private String[][] StartPos;
    }

    class Items{
         Armour.add("Breastplate of Hellish Punishment","Tunic of Condemned Hell","Rugged Leather Garments","Vestment of Cursed Might","Defender of Sunlight");

         Helm.add("Faceguard of Divine Glory","Headcover of Sacred Freedom","Steel Helm of Burning Sorrow","Iron Jaws of Condemned Lands","Victor Golden Helmet");

        Weapon.add("Ash","Enigma","Defender Core","Loyal Chalice","Lich Trinket");
    }
}

