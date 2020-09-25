package za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import za.co.WeThinkCode_.swingy.model.Var;

import java.util.Scanner;

//@Getter
//@Setter
//public class move {
//    Scanner scan = new Scanner(System.in);
//    @Builder.Default protected int[] Coordinates = {0,0};
//    int number;
//
//    Var direction = Var.builder().North(1).East(2).South(3).West(4).build();
//    int map = (direction.getLevel()-1)*5+10-(direction.getLevel()%2);
//
//    public void Readinput(){
//        System.out.println("Enter direction. North for 1, east for 2, south for 3, west for 4");
//
//        number = scan.nextInt();
//
//        //direction.setCoordinates(direction.Coordinates[0] += 1);
//        //                direction.setCoordinates([1] += 1);
//        //                direction.setCoordinates([0] -= 1);
//        //                direction.setCoordinates([1] -= 1);
//        switch (number) {
//            case (1) -> {
//                this.Coordinates[0] += 1;
//                System.out.println("you moved north");
//            }
//            case (2) -> {
//                this.Coordinates[1] += 1;
//                System.out.println("you moved east");
//            }
//            case (3) -> {
//                this.Coordinates[0] -= 1;
//                System.out.println("you moved south");
//            }
//            case (4) -> {
//                this.Coordinates[1] -= 1;
//                System.out.println("you moved west");
//            }
//        }
//
//    }
//
//}
