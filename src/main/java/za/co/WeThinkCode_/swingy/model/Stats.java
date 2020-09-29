package za.co.WeThinkCode_.swingy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Stats{
    protected int Atk = 0;
    protected int Def = 0;
    protected int Exp;
    protected int Dodge = 0;
//    protected int Level = 1;
    protected String Helm = "Leather";
    protected String Armor = "Leather";
    protected String Weapon = "Leather";

    public void AssassinStats(){ Atk=50;Def=50;Dodge=50;}

        public void TankStats(){
            Atk=30;Def=70;Dodge=10;
        }

        public void NecromancerStats(){
            Atk=70;Def=30;Dodge=30;
        }

        public void ArcherStats(){
            Atk=50;Def=30;Dodge=70;
        }

        public void EnemyStats(int Level){

            switch (Level) {
                case 1 -> {
                    Atk=30;
                    Def=30;
                    Dodge=30;
                }
                case 2 -> {
                    Atk=40;
                    Def=40;
                    Dodge=40;
                }
                case 3 -> {
                    Atk=50;
                    Def=50;
                    Dodge=50;
                }
                case 4 -> {
                    Atk=60;
                    Def=60;
                    Dodge=60;
                }
                case 5 -> {
                    Atk=70;
                    Def=70;
                    Dodge=70;
                }
            }
        }


        public String RandomE (){


            final String[] helm = {"VictorGoldenHelmet", "FaceGuardOfDivineGlory", "HeadCoverOfSacredFreedom", "SteelHelmOfBurningSorrow", "IronJawsOfCondemnedLands"};
            final String[] armor = {"DefenderOfSunlight", "BreastplateOfHellishPunishment", "TunicOfCondemnedHell", "RuggedLeatherGarments", "VestmentOfCursedMight"};
            final String[] weapon = {"LichTrinket", "Ash", "Enigma", "DefenderCore", "LoyalChalice"};

            Random random = new Random();
            Helm=(helm[random.nextInt(5)]);
            Armor=(armor[random.nextInt(5)]);
            Weapon=(weapon[random.nextInt(5)]);
            int count = random.nextInt(3);
            if (count == 1) {
                return Helm;
            }
            else if (count == 2) {
                return Armor;
            }
            else {
                return Weapon;
            }
    }

    public void Equipment(String Item) {
        switch (Item) {
            case "VictorGoldenHelmet", "DefenderOfSunlight", "LichTrinket" -> {
                Atk = Atk + 10;
                Def = Def + 10;
                Dodge = Dodge + 10;
            }
            case "FaceGuardOfDivineGlory" -> {
                Atk = Atk + 20;
                Def = Def + 10;
                Dodge = Dodge + 20;
            }
            case "HeadCoverOfSacredFreedom" -> {
                Atk = Atk + 10;
                Def = Def + 20;
                Dodge = Dodge + 30;
            }
            case "SteelHelmOfBurningSorrow" -> {
                Atk = Atk + 15;
                Def = Def + 15;
                Dodge = Dodge + 40;
            }
            case "IronJawsOfCondemnedLands" -> {
                Atk = Atk + 20;
                Def = Def + 20;
                Dodge = Dodge + 50;
            }
            case "BreastplateOfHellishPunishment", "Ash" -> {
                Atk = Atk + 20;
                Def = Def + 20;
                Dodge = Dodge + 10;
            }
            case "TunicOfCondemnedHell" -> {
                Atk = Atk + 10;
                Def = Def + 30;
                Dodge = Dodge + 20;
            }
            case "RuggedLeatherGarments" -> {
                Atk = Atk + 15;
                Def = Def + 40;
                Dodge = Dodge + 15;
            }
            case "VestmentOfCursedMight" -> {
                Atk = Atk + 20;
                Def = Def + 50;
                Dodge = Dodge + 20;
            }
            case "Enigma" -> {
                Atk = Atk + 30;
                Def = Def + 10;
                Dodge = Dodge + 20;
            }
            case "DefenderCore" -> {
                Atk = Atk + 40;
                Def = Def + 15;
                Dodge = Dodge + 15;
            }
            case "LoyalChalice" -> {
                Atk = Atk + 50;
                Def = Def + 20;
                Dodge = Dodge + 20;
            }
        }
    }


    public String LevelUp(int E,int Level){
        switch (Level){
            case 1 -> {
                if (E == 100){
                    Exp = 0;
                    Atk += 10;
                    Def += 10;
                    Dodge += 10;
                    return ("leveledUp");}
                else
                    return ("Nope");
            }
            case 2 -> {
                if (E == 200){
                    Exp = 0;
                    Atk += 10;
                    Def += 10;
                    Dodge += 10;
                    return ("leveledUp");}
                else
                    return ("Nope");
            }
            case 3 -> {
                if (E == 300){
                    Exp = 0;
                    Atk += 10;
                    Def += 10;
                    Dodge += 10;
                    return ("leveledUp");}
                else
                    return ("Nope");
            }
            case 4 -> {
                if (E == 400){
                    Exp = 0;
                    Atk += 10;
                    Def += 10;
                    Dodge += 10;
                    return ("leveledUp");}
                else
                    return ("Nope");
            }
            case 5 -> {
                if (E == 500){
                    Exp = 0;
                    Atk += 10;
                    Def += 10;
                    Dodge += 10;
                    return ("leveledUp");}
                else
                    return ("Nope");
            }
        }
        return "Highest";
    }
}
