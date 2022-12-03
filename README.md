## Lisa Ho Yen Xin 20297507  

### How to compile
Download the zip file and navigate to <code>COMP2042_CW_hfylh2\src\main\java\com\main</code> and run <code>main.java</code>

### Javadoc
<code>COMP2042_CW_hfylh2\javadoc</code>

### Working features:
#### Start Menu:
1. Limit username characters to 1-5 characters (disable start button if minimum character length not reached)
2. Save valid username to a file
3. Change color theme of whole game (able to enable and disable a color button by clicking the button twice)
4. Different game levels (3x3, 4x4, 5x5)
5. Play music upon opening application (infinite loop)

#### Game Play:
1. Correct score calculation
2. Do not save the score if a user quits in the middle of the game (set score to 0 or save user's old score)
3. Only move cells by pressing LEFT, RIGHT, UP, DOWN keys

#### Game Over: 
1. Display user score, back to menu, retry level, high score, and quit button
2. Retry current level and take highest score
3. Only allow the user to exit the application by using the quit button

#### High Score List:
1. Save user's score to the file where the user's username is stored
2. If user is old user, compare user's old score and new score before saving into the file
3. Display sorted high score list for top 10 users without changing the order of the contents in the file

### Not working features: 

### Not implemented features: 
1. Cell spawning condition is different from the original 2048 game to increase the pace of the game and decrease the time needed to complete a level
2. No different high score list for different game levels

### New classes: 
- Username.java
- Score.java
- HighScore.java
- Game.java
- GameStatus.java
- GameMovement.java
- MoveDirection.java
- PassDestination.java
- RandomNum.java
- GameInterface.java
- ModifyCell.java
- CellInterface.java
- MainMenuController.java
- GameMusic.java
- GameModesController.java
- ButtonListener.java
- ColorThemeController.java
- ChangeColor.java
  
### Modified classes:
- Main.java
- Cell.java
- TextMaker.java
- GameScene.java
- EndGame.java  
