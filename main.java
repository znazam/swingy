//TODO

//---------------------------------------

//research
// Respect the Model-View-Controller design pattern.
// Automated build with Maven.
// Annotation based user input validation
// Builder pattern
// Hibernate Validator
// Mavin plugin in ide
// java package naming conventions
// javax.validation specification
// relational database in java

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
