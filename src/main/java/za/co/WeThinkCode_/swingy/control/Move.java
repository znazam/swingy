package za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import za.co.WeThinkCode_.swingy.model.Var;
import za.co.WeThinkCode_.swingy.view.Console;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;

public class Move extends Console{
//    Console direction = new Console();
//    int[] Coordinates = direction.Coordinates();


    public static String Direction(int[] Coordinates, int Level){
        Scanner scan = new Scanner(System.in);
        int map = (Level-1)*5+10-(Level%2);
        String data = scan.nextLine();
        while(!(Coordinates[0] >= map) || (Coordinates[0] <= (map * -1)) || (Coordinates[1] <= (map* -1)) || (Coordinates[1] >= map)) {
            switch (data) {
                case "1" -> {
                    Coordinates[0] += 1;
                    System.out.println("you moved north");
                    return (data);
                }
                case "2" -> {
                    Coordinates[1] += 1;
                    System.out.println("you moved east");
                    return (data);
                }
                case "3" -> {
                    Coordinates[0] -= 1;
                    System.out.println("you moved south");
                    return (data);
                }
                case "4" -> {
                    Coordinates[1] -= 1;
                    System.out.println("you moved west");
                    return (data);
                }
                case "B" -> {
                    return (data);
                }
            }
            System.out.println("Should level up now");
        }
        return"LevelUp";
    }
}
