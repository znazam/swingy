//TODO

//---------------------------------------

//research
// Annotation based user input validation
// javax.validation specification
// sql lite

//----------------------------------------

//RUN using 'mvn clean package'
// should be able to switch between console view and gui view at runtime:
// player can have multiple heroes of differen't types
// must name the types and give them starting stats
// when starting he can create a hero or use previously made one
// player must be able to see hero stats(Hero name, Hero class, Level, Experience, Attack, Defense, Hit Points)
// hero level and artifects increase stats(weapon- attack, armor- defence, helm- hit points)
// map size formula  (level-1)*5+10-(level%2)
// wins if he reaches boarder.
// turn based game
// starts at center
// moves north, east, west or south
// villains varying in power randomly on the map
// when moved to a place occupied he either fights or runs which he has a 50% chance of success and if odds isn't on his side he must fight
// must present the outcome of the battle
// if hero dies he losses mission
// if he wins he gains exp and level up if exp is full, an artifact he can keep or leave no guarantee though
// formular for leveling up level*1000+(level − 1)2*450
// must be run as java -jar swingy.jar console, java -jar swingy.jar gui
// save data in a relational database
// respect mvc patterns

//1 Main that can handle the actual execution of the command and flags
//2 Setup all of your classes, i.e all hero, enemy and items
//3 start setting up your logic controller
//4 build the console view
//5 build the interface
//6 add logic to all classes and controllers for the more advanced stuff the game needs to do
//7 add saving and loading characters
//8 build the gui view
//9 drink a fat beer
package za.co.WeThinkCode_.swingy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.control.Run;
import za.co.WeThinkCode_.swingy.model.Var;

@Builder
@Getter
@Setter
public class Main {

    public static void main(String[] args) {

        if (args.length == 1) {
            if (args[0].toLowerCase().equals("-gui") || args[0].toLowerCase().equals("-console")) {
                Var test = Var.builder().gameView(args[0].toLowerCase()).build();
                //System.out.println(test.getGameView());
                Run.Game(test.getGameStage());
                System.out.println("Works fine");

            }
            else
                System.out.println("check that you spelt -gui or -console right and using the dash");
        } else {
            System.out.println("You need to tell me via flag if you'd like a console view of the game or a gui view");
        }
    }
}