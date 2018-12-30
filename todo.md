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
