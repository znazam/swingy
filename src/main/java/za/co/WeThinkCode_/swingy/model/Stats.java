package za.co.WeThinkCode_.swingy.model;

import java.util.Random;

//@Getter
//@Setter
//@Builder
public class Stats{
    Var test = Var.builder().build();
    public void AssassinStats(){ Var.builder().Atk(50).Def(50).Dodge(50).build(); }

        public void TankStats(){
            Var.builder().Atk(30).Def(70).Dodge(10).build();
        }

        public void NecromancerStats(){
            Var.builder().Atk(70).Def(30).Dodge(30).build();
        }

        public void ArcherStats(){
            Var.builder().Atk(50).Def(30).Dodge(70).build();
        }

        public void EnemyStats(){
            int lev = Var.builder().build().getLevel();

            switch (lev){
                case 1:
                    Var.builder().Atk(30).Def(30).Dodge(30).build();
                    break;
                case 2:
                    Var.builder().Atk(40).Def(40).Dodge(40).build();
                    break;
                case 3:
                    Var.builder().Atk(50).Def(50).Dodge(50).build();
                    break;
                case 4:
                    Var.builder().Atk(60).Def(60).Dodge(60).build();
                    break;
                case 5:
                    Var.builder().Atk(70).Def(70).Dodge(70).build();
                    break;
            }
        }


        public void equipment (String Item){


            final String[] helm = {"VictorGoldenHelmet", "FaceGuardOfDivineGlory", "HeadCoverOfSacredFreedom", "SteelHelmOfBurningSorrow", "IronJawsOfCondemnedLands"};
            final String[] armor = {"DefenderOfSunlight", "BreastplateOfHellishPunishment", "TunicOfCondemnedHell", "RuggedLeatherGarments", "VestmentOfCursedMight"};
            final String[] weapon = {"LichTrinket", "Ash", "Enigma", "DefenderCore", "LoyalChalice"};

            Random random = new Random();
            Var equip = Var.builder().Helm(helm[random.nextInt(5)]).Armor(armor[random.nextInt(5)]).Weapon(weapon[random.nextInt(5)]).build();

            switch (Item) {
                case "Helm":
                    switch (equip.Helm) {
                        case "VictorGoldenHelmet":
                            equip.setAtk(equip.Atk + 10);
                            equip.setDef(equip.Def + 10);
                            equip.setDodge(equip.Dodge + 10);
                            break;
                        case "FaceGuardOfDivineGlory":
                            equip.setAtk(equip.Atk + 20);
                            equip.setDef(equip.Def + 10);
                            equip.setDodge(equip.Dodge + 20);

                            break;
                        case "HeadCoverOfSacredFreedom":
                            equip.setAtk(equip.Atk + 10);
                            equip.setDef(equip.Def + 20);
                            equip.setDodge(equip.Dodge + 30);
                            break;
                        case "SteelHelmOfBurningSorrow":
                            equip.setAtk(equip.Atk + 15);
                            equip.setDef(equip.Def + 15);
                            equip.setDodge(equip.Dodge + 40);
                            break;
                        case "IronJawsOfCondemnedLands":
                            equip.setAtk(equip.Atk + 20);
                            equip.setDef(equip.Def + 20);
                            equip.setDodge(equip.Dodge + 50);
                            break;
                    }
                    break;
                case "Armor":
                    switch (equip.Armor) {
                        case "DefenderOfSunlight":
                            equip.setAtk(equip.Atk + 10);
                            equip.setDef(equip.Def + 10);
                            equip.setDodge(equip.Dodge + 10);
                            break;
                        case "BreastplateOfHellishPunishment":
                            equip.setAtk(equip.Atk + 20);
                            equip.setDef(equip.Def + 20);
                            equip.setDodge(equip.Dodge + 10);
                            break;
                        case "TunicOfCondemnedHell":
                            equip.setAtk(equip.Atk + 10);
                            equip.setDef(equip.Def + 30);
                            equip.setDodge(equip.Dodge + 20);
                            break;
                        case "RuggedLeatherGarments":
                            equip.setAtk(equip.Atk + 15);
                            equip.setDef(equip.Def + 40);
                            equip.setDodge(equip.Dodge + 15);
                            break;
                        case "VestmentOfCursedMight":
                            equip.setAtk(equip.Atk + 20);
                            equip.setDef(equip.Def + 50);
                            equip.setDodge(equip.Dodge + 20);
                            break;
                    }
                    break;
                case "Weapon":
                    switch (equip.Weapon) {
                        case "LichTrinket":
                            equip.setAtk(equip.Atk + 10);
                            equip.setDef(equip.Def + 10);
                            equip.setDodge(equip.Dodge + 10);
                            break;
                        case "Ash":
                            equip.setAtk(equip.Atk + 20);
                            equip.setDef(equip.Def + 20);
                            equip.setDodge(equip.Dodge + 10);
                            break;
                        case "Enigma":
                            equip.setAtk(equip.Atk + 30);
                            equip.setDef(equip.Def + 10);
                            equip.setDodge(equip.Dodge + 20);
                            break;
                        case "DefenderCore":
                            equip.setAtk(equip.Atk + 40);
                            equip.setDef(equip.Def + 15);
                            equip.setDodge(equip.Dodge + 15);
                            break;
                        case "LoyalChalice":
                            equip.setAtk(equip.Atk + 50);
                            equip.setDef(equip.Def + 20);
                            equip.setDodge(equip.Dodge + 20);
                            break;
                    }
                    break;
            }
    }
}