# CE203-Assignment2
**Deadline:** 11:59:59, Wednesday 12th December 2018

## To-do list
- [X] it's wednesday my dudes
#### frog
- [X] Restrict the frog's movement so that it moves to the coordinates of the hexagons, rather than moving freely 
	- [X] Create 2 lists to hold x and y coordinates of the hexagons' center points - we only need to store 2 values each for x and y, as we only need these values to calculate the center of the hexagon
	- [X] Merge those lists together into an array, i.e. int\[]\[] positions = {\[0,0],\[2,2]}
	- [X] Use this array of x,y coordinates to check where the user can go. ~Say, when the left arrow key is pressed, the program checks the position of the user and then checks where the closest, left-most hexagon is (e.g. no more than 10 pixels to the left, on the x-axis, from the user's position). If user wants to go left or right, they'll always land on the north-west/east hexagon. If they want to go to a hexagon that is south-west/east, then they'll have to go left/right then down.~ The frog's position now changes by subtracting or adding to their current x,y coordinates.
- [X] Reset position of frog when the user wins/quits game and then starts a new one
- [X] Separate the frogListener to a new class file
- [X] If there's time, create a pixel sprite for the frog
#### flies
- [X] Create "flies" on the hexagon tiles. Their positions need to be randomised every time the user plays a new game.
- [X] Create MouseListener for frog's tongue so that it can "capture" the flies
- [X] If there's time, create pixel sprites for the flies
#### board
- [X] ~Make the code for painting hexagons neater~
#### game
- [X] Separate the paintComponent into its own class (see #2 below) - shapes should have their own abstract class if possible
- [X] Separate the JPanels into their own classes to make the code neater
- [X] Create a JPanel for the highscore page
- [X] Create a timer for the game - the foundation could be gameplay for 30 seconds
	- [ ] Expand on timer - how fast can the player collect flies in 30 seconds (10 flies + easy difficulty), 20 seconds (7 flies + medium difficulty), and 10 seconds (5 flies + hard difficulty)
- [X] Search for a way to log in the scores of players (i.e. get the player to enter their 'nickname' at the end of the game and record it with their score) - ~since this would probably use a text field, alpha-numeric characters should only be entered (or an exception could be thrown otherwise)~
### report
- [X] Clean up the code and ~make it neater@
- [X] The program should contain small, relevant comments that briefly explain a piece of code
- [ ] Once the game is complete, the report needs to be written. This repository can be used to help write the report

## Your Task
Applying what you've learned so far, you are asked to write your own 2-dimensional shape-based game. Examples of this would include Pong, Snack, Space Invaders, or other simple 2D games of your creation.

The first part of the assignment is to create an application capable of holding: a collection of different shapes, drawing these shapes to the screen, allowing these shapes to be moved by the user, and resized on the screen. 
The second part asks you to extend this basic set of building blocks to construct a simple game of your own design. This can be inspired by classic arcade games, as long as all the code is your own.

### Detailed Description of Tasks
Marks will be given for individual stages in the game development. The breakdown of marks are as follows:
1. Your user interface should be run as an application that can either:
	* Use a grid of filled squares in which shapes object(s) are moved or rotated. An example grid of squares could be 20 x 20.
	* Use a drawing panel area to animate (move and/or rotate shape object(s) in the game).
	
	The application should also display your registration number (in the title of the frame for example). **\[10%\]**
2. Shapes should be encapsulated in their own classes. An abstract class 'Shape' should first be created. This should then be extended to create classes to encapsulate the following types of shapes: Squares, Rectangles, Circles, Triangles, Pie shapes (portions of a circle). The shapes should all be stored in a single collection. Each shape should encapsulate methods to allow it to be draw to the screen at arbitrary positions, rotations, and sizes *(refer to Lab 3)* **\[10%\]**
3. Two event handler classes should be created to respond to keyboard events (e.g. pressing the arrow keys) and mouse events (e.g. pressing the mouse buttons). **\[10%\]**
4. The game should keep a record of scores. This should be done via a text file. A new class should be created to allow new scores to be entered into this text file. Methods should be added to return top 10 scores of all time. These scores should be displayed on-screen at the end of a round of your game. Appropriate exception handling should be used (for example for missing files). **\[10%\]**
5. A short report with testing your program should describe your solution (see below). **\[10%\]**
6. Do not simply put all code in a single class. You should apply the object-oriented principles we have studied this term and use appropriate comments throughout your code (see details below). **\[10%\]**
7. The remainder of the marks are allocated for developing a game using the basic building blocks. Your game should be 2D and use the Shape classes, event handlers, and score tracker developed above. The game can be based on classic arcade games (Pong, Space Invaders, Pacman etc.) or a board game (chess, snakes and ladders etc.) or one of your own design. After the end of a round your game, a score should be allocated (this could be based on some outcome of the game, e.g. in Pong you gain 1 point for winning, or the length of time you survive for). The total score should be displayed to players after finishing a game along with their all-time ranking. An interface should be available to allow the top 10 all-time best scores to be displayed. **\[40%\]**

### Commenting the Program
The program should contain brief comments  indicating precisely what each method does and what each instance variable is used for. You should not write any comments stating what individual lines do; but in places it may be appropriate to state what a block of code does (e.g. "received a mouse event").

Any code taken from elsewhere or based on ideas that are not your own (e.g. from a reference book or website) should be clearly indicated as such both in comments and in your report, see below. 

The program should be structured appropriately and laid out neatly with consistent indentation.

### Report and Testing Output
In addition to comments in the program, you should submit a short report (in PDF or Word format) that describes the structur and functionality of your system. Feel free to include any further comments that explain shortcomings or additional features of your solution.

The program produced should be fully tested to demonstrate that the features of your game(1 to 6) are working correctly and you have developed a basic game (7).

You are therefore asked to clearly should the correct output of your code. This can be shown as a series of screenshots that demonstrate the correct response of the program. Please briefly explain and label the screenshot(s) for each feature being tested.

The Word or PDF document should include your registration number and should be named according to the following naming convention: Assignment2_Testing_RegNo_<*registration number*>.

## Submission
You are required to submit the report, the source code files (the .java files), and all of the .class files generated by the compiler. You need to also include the Word/PDF file containing your program testing output. All the files should be placed in a single folder, which should then be zipped for submission to Faser.

You will also be required to demonstrate your submission in your regular scheduled CE203 lab in Week 11. You will be asked to demonstrate that you understand your own code by explaining how your code works and why you chose to develop it the way you did. 
