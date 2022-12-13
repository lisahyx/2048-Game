## Lisa Ho Yen Xin 20297507  

### How to compile
Download the zip file and open the innermost folder <code>COMP2042_CW_hfylh2</code> as a new project. 
Navigate to <code>COMP2042_CW_hfylh2\src\main\java\com\main</code> and run <code>main.java</code>

### Javadoc
<code>COMP2042_CW_hfylh2\javadoc</code>

### Maintenance and Extension:
Split large classes into multiple classes so that a class only has a single responsibility.
Cleaned up code by removing duplicated code and variable declarations.
Removed unused parameters for methods. 
Split classes that have similar functionality to  packages.
Set class visibility to package-private and improve encapsulation by using accessor and mutator methods for private 
variables. 

### Working features:
#### Start Menu:
1. Limit the length of the username to 1-6 characters (disable start button if minimum character length not reached)
2. Save a valid username to a text file (or create a new one if none exists). 
3. Change the color theme of the whole game (able to enable and disable a color button by clicking the button twice)
4. Different game levels (3x3, 4x4, 5x5, blackout)
   - Blackout: To make the game more difficult, some cells are rendered invisible or blacked out.
5. Play music upon opening the application (infinite loop)

#### Game Play:
1. Correct score calculation
2. Do not save the score if a user quits in the middle of the game (set score to 0 or save user's old score)
3. Only move cells by pressing the LEFT, RIGHT, UP, DOWN keys 
4. Start the timer upon starting the game

#### Game Over: 
1. Display user score, retry level, high score, and quit button
2. Retry the current level and take the highest score

#### High Score List:
1. Save user's score to the same file where the user's username is stored 
2. If the user is an old user, compare the old and new scores before saving into the file. 
3. Show a congratulations message if the user is among the top 10 users 
4. Display a sorted high score list for the top 10 users without changing the order of the contents in the file 
5. Display a quit button

### Not implemented features: 
1. Cell spawning condition is different from the original 2048 game to increase the pace of the game and decrease the time needed to complete a level
2. No different high score list for different game levels to reduce competition between users

### New classes:
<code>com/main</code>
- GameMusic.java

<code>com/cell</code>
- ModifyCell.java
- CellInterface.java

<code>com/player</code>
- Username.java
- Score.java

<code>com/ingame</code>
- Game.java
- GameStatus.java
- GameMovement.java
- MoveDirection.java
- PassDestination.java
- RandomNum.java
- Timer.java
- Blackout.java
- GameInterface.java

<code>com/endgame</code>
- HighScoreController.java

<code>com/startgame</code>
- MainMenuController.java
- GameModesController.java
- ButtonInterface.java
- ColorThemeController.java
- ChangeColor.java
  
### Modified classes:
- Main.java
- Cell.java
- TextMaker.java
- GameScene.java
- EndGame.java  
