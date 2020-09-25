package za.co.WeThinkCode_.swingy.model;

import lombok.*;
import javax.validation.constraints.*;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NonNull
//@Builder
//@Data
public class Var{

   protected String Assassin; //equal defence and attack and dodge
   protected String Tank; //more defence
   protected String Necromancer; //more Attack
   protected String Archer; //higher chance to dodge
   protected String Enemy;
   @Size(min = 2, max = 10)
   protected String Player;
   protected int Dmg;
   protected String Artifacts;

//   @Builder.Default
   @Size(max = 100, min = 0)
   protected int Hp = 100;

//   @Builder.Default
   protected int Exp = 0;
//   @Builder.Default protected int[] Coordinates = {0,0};

   protected boolean Fight;
   protected boolean Run;
   protected boolean Keep;
   protected boolean Leave;


   protected int North;
   protected int West;
   protected int East;
   protected int South;

   /*public Var(String Assassin, String Tank, String Necromancer, String Archer, String Enemy, String ClassName, String Player, int Atk, int Def, int Dmg, int Dodge, String Artifacts,
           int Hp, String Helm, String Armor, String Weapon, int Exp, int Level,int[] Coordinates, boolean Fight, boolean Run, boolean Keep, boolean Leave, String North, String West,
            String East, String South){

      this.Assassin = Assassin;
      this.Tank = Tank;
      this.Necromancer = Necromancer;
      this.Archer = Archer;
      this.Enemy= Enemy;
      this.ClassName = ClassName;
      this.Player = Player;
      this.Atk = Atk;
      this.Def = Def;
      this.Dmg = Dmg;
      this.Dodge = Dodge;
      this.Artifacts = Artifacts;
      this.Hp = Hp;
      this.Helm = Helm;
      this.Armor = Armor;
      this.Weapon = Weapon;
      this.Exp = Exp;
      this.Level = Level;
      this.Coordinates = Coordinates;
      this.Fight = Fight;
      this.Run = Run;
      this .Keep = Keep;
      this.Leave = Leave;
      this.North = North;
      this.East = East;
      this.West = West;
      this.South = South;

   }*/

}

