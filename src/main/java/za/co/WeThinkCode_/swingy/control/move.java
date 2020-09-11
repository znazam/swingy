package main.java.za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import main.java.za.co.WeThinkCode_.swingy.model.Var;

import java.util.Scanner;

@Getter
@Setter
public class move {
    Scanner scan = new Scanner(System.in);
    @Builder.Default protected int[] Coordinates = {0,0};
    int number;

    Var direction = Var.builder().North(1).East(2).South(3).West(4).build();
    int map = (direction.getLevel()-1)*5+10-(direction.getLevel()%2);

    public void Readinput(){
        System.out.println("Enter direction. North for 1, east for 2, south for 3, west for 4");

        number = scan.nextInt();

        switch(number){
            case(1):
                //direction.setCoordinates(direction.Coordinates[0] += 1);
                this.Coordinates[0] += 1;
                System.out.println("you moved north");
                break;
            case(2):
//                direction.setCoordinates([1] += 1);
                this.Coordinates[1] += 1;
                System.out.println("you moved east");
                break;
            case(3):
//                direction.setCoordinates([0] -= 1);
                this.Coordinates[0] -= 1;
                System.out.println("you moved south");
                break;
            case(4):
//                direction.setCoordinates([1] -= 1);
                this.Coordinates[1] -= 1;
                System.out.println("you moved west");
                break;
        }

    }

}
