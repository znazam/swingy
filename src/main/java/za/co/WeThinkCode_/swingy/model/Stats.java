package za.co.WeThinkCode_.swingy.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Random;

@Getter
@Setter
public class Stats{
    protected int Atk = 0;
    protected int Def = 0;
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


        public void RandomE (String Item){


            final String[] helm = {"VictorGoldenHelmet", "FaceGuardOfDivineGlory", "HeadCoverOfSacredFreedom", "SteelHelmOfBurningSorrow", "IronJawsOfCondemnedLands"};
            final String[] armor = {"DefenderOfSunlight", "BreastplateOfHellishPunishment", "TunicOfCondemnedHell", "RuggedLeatherGarments", "VestmentOfCursedMight"};
            final String[] weapon = {"LichTrinket", "Ash", "Enigma", "DefenderCore", "LoyalChalice"};

            Random random = new Random();
            Helm=(helm[random.nextInt(5)]);
            Armor=(armor[random.nextInt(5)]);
            Weapon=(weapon[random.nextInt(5)]);
            Equipmant(Item);
    }

    public void Equipmant(String Item){
        switch (Item) {
        case "Helm":
            switch (Helm) {
                case "VictorGoldenHelmet" -> {
                    Atk=Atk + 10;
                    Def=Def+10;
                    Dodge=Dodge+10;
                }
                case "FaceGuardOfDivineGlory" -> {
                    Atk=Atk+20;
                    Def=Def+10;
                    Dodge=Dodge+20;
                }
                case "HeadCoverOfSacredFreedom" -> {
                    Atk=Atk + 10;
                    Def=Def+20;
                    Dodge=Dodge+30;
                }
                case "SteelHelmOfBurningSorrow" -> {
                    Atk=Atk+15;
                    Def=Def+15;
                    Dodge=Dodge+40;
                }
                case "IronJawsOfCondemnedLands" -> {
                    Atk=Atk+20;
                    Def=Def+20;
                    Dodge=Dodge+50;
                }
            }
            break;
        case "Armor":
            switch (Armor) {
                case "DefenderOfSunlight" -> {
                    Atk=Atk + 10;
                    Def=Def+10;
                    Dodge=Dodge+10;
                }
                case "BreastplateOfHellishPunishment" -> {
                    Atk=Atk+20;
                    Def=Def+20;
                    Dodge=Dodge+10;
                }
                case "TunicOfCondemnedHell" -> {
                    Atk=Atk + 10;
                    Def=Def+30;
                    Dodge=Dodge+20;
                }
                case "RuggedLeatherGarments" -> {
                    Atk=Atk+15;
                    Def=Def+40;
                    Dodge=Dodge+15;
                }
                case "VestmentOfCursedMight" -> {
                    Atk=Atk+20;
                    Def=Def+50;
                    Dodge=Dodge+20;
                }
            }
            break;
        case "Weapon":
            switch (Weapon) {
                case "LichTrinket" -> {
                    Atk=Atk + 10;
                    Def=Def+10;
                    Dodge=Dodge+10;
                }
                case "Ash" -> {
                    Atk=Atk+20;
                    Def=Def+20;
                    Dodge=Dodge+10;
                }
                case "Enigma" -> {
                    Atk=Atk+30;
                    Def=Def+10;
                    Dodge=Dodge+20;
                }
                case "DefenderCore" -> {
                    Atk=Atk+40;
                    Def=Def+15;
                    Dodge=Dodge+15;
                }
                case "LoyalChalice" -> {
                    Atk=Atk+50;
                    Def=Def+20;
                    Dodge=Dodge+20;
                }
            }
            break;
    }}
}