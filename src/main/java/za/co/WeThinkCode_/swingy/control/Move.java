package za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import za.co.WeThinkCode_.swingy.model.Var;
import za.co.WeThinkCode_.swingy.view.Console;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Move {
    Scanner scan = new Scanner(System.in);
    Console direction = new Console();
//    int[] Coordinates = direction.getCoordinates();
    int map = (direction.getLevel()-1)*5+10-(direction.getLevel()%2);

    public int[] Direction(int[] Coordinates){

        while(!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map* -1)) || (Coordinates[1] >= map)) {
            switch (scan.nextLine()) {
                case "1" -> {
                    Coordinates[0] += 1;
                    //direction.setCoordinates(this.Coordinates);
                    System.out.println("you moved north");
                }
                case "2" -> {
                    Coordinates[1] += 1;
//                    direction.setCoordinates(this.Coordinates);
                    System.out.println("you moved east");
                }
                case "3" -> {
                    Coordinates[0] -= 1;
//                    direction.setCoordinates(this.Coordinates);
                    System.out.println("you moved south");
                }
                case "4" -> {
                    Coordinates[1] -= 1;
//                    direction.setCoordinates(this.Coordinates);
                    System.out.println("you moved west");
                }
                case "B" -> direction.StartMenu();
            }
            System.out.println(Arrays.toString(Coordinates));

            Random rand = new Random();
            int chance = rand.nextInt(1000);

            boolean Fight = chance > 800;
            if (Fight) {
                direction.EnemyEncountered(Coordinates);
            } else {
                Direction(Coordinates);
            }
            direction.NewLevel();
        }



//        public void endRound(){
//
////            Coordinates[0] = 0;
////            Coordinates[1] = 0;
////
////            if (Hp() <= 0){
////                setHp(this.hpLevel);
////                return false;
////            } else {
////                setHp(this.hpLevel);
////                this.exp += (level * 100);
////                if(this.exp >= (this.level * 1000 + ((level - 1) * (level - 1)) * 450)) {
////                    levelUp();
////                    return true;
////                }else{
////                    return false;
////                }
////            }
//        }


    return (Coordinates);
    }


}
