import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Battleship {
    private char[][] grid = new char[10][10];
    private static final int NUMBER_SHIPS = 5;
    private static Scanner input = new Scanner(System.in);
    private Random randomNumber = new Random(System.currentTimeMillis());
    private int user_ships_remaining = 5;
    private int computer_ships_remaining = 5;


    public void createGrid(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = ' ';
            }
        }
    }

    public void displayGrid(char[][] grid){
        int num_rows = grid.length;
        int num_cols = grid[0].length;

        // print the header
        System.out.print("   ");
        for(int i = 0; i < num_cols; i++){
            System.out.print(" " + i);
        }
        System.out.print("\n");

        // print each row
        for(int i = 0; i < num_rows; i++){
            System.out.print(i + " |");

            for(int j = 0; j < num_cols; j++){
                if(grid[i][j] == '1'){
                    System.out.print(" @");
                } else if(grid[i][j] == '2'){
                    System.out.print("  ");
                } else if(grid[i][j] == 'c'){
                    System.out.print("  ");
                } else {
                    System.out.print(" " + grid[i][j]);
                }

            }

            System.out.print("| " + i);
            System.out.print("\n");
        }

        // print the header again
        System.out.print("   ");
        for(int i = 0; i < num_cols; i++){
            System.out.print(" " + i);
        }
        System.out.print("\n");
    }

    public void placeShips(char player) {
        System.out.println("You have " + NUMBER_SHIPS + " ships to place.");

        int ships_placed = 0;

        while (ships_placed < NUMBER_SHIPS) {
            System.out.print("enter your x coordinate (between 0 and 9) for your #" + ships_placed + " ship: ");
            int user_x = input.nextInt();
            System.out.print("enter your y coordinate (between 0 and 9) for your #" + ships_placed + " ship: ");
            int user_y = input.nextInt();
            while (!(checkMove(user_x, user_y))) {
                System.out.println("Invalid move!");
                System.out.print("enter your x coordinate (between 0 and 9) for your #" + ships_placed + " ship: ");
                user_x = input.nextInt();
                System.out.print("enter your y coordinate (between 0 and 9) for your #" + ships_placed + " ship: ");
                user_y = input.nextInt();
            }

            // if the move is valid place it into the map
            grid[user_y][user_x] = player;
            ships_placed += 1;
        }
    }

    public void placeComputerShips(){
        System.out.println("Computer is placing ships.");

        int ships_placed = 0;

        while (ships_placed < NUMBER_SHIPS) {
            int computer_x = randomNumber.nextInt(10);
            int computer_y = randomNumber.nextInt(10);
            while (!(checkMove(computer_x, computer_y))) {
                computer_x = randomNumber.nextInt(10);
                computer_y = randomNumber.nextInt(10);
            }
            System.out.println(ships_placed + " ship placed");
            // if the move is valid place it into the map
            grid[computer_y][computer_x] = '2';
            ships_placed += 1;
        }
    }

    // make sure the move is acceptable
    private boolean checkMove(int checkMoveX, int checkMoveY){
        // this method takes in two ints, the X and Y coordinates from either the player or computers ship placement
        // and makes sure that the coordinates are valid, and also that there is nothing there already.
        boolean goodMove = true;
        if(checkMoveX < 0 || checkMoveX > 9 || checkMoveY < 0 || checkMoveY > 9 || (grid[checkMoveY][checkMoveX] != ' ')) {
            goodMove = false;
        }
        return goodMove;
    }

    public void playMove(int x, int y){
        char target = grid[y][x];

        // evaluate and place the move
        if(target == '1'){
            System.out.println("You sunk your own ship!");
            grid[y][x] = 'x';
            user_ships_remaining--;
        } else if(target == '2'){
            System.out.println("You sunk the computer's ship!");
            grid[y][x] = '!';
            computer_ships_remaining--;
        } else {
            System.out.println("You missed!");
            grid[y][x] = '-';
        }
    }

    public void playersMove(){
        int user_x = -1;
        int user_y = -1;

        // get the input
        System.out.println("YOUR TURN!");
        while(user_x > 9 || user_x < 0){
            System.out.print("Enter x coordinate: ");
            user_x = input.nextInt();
        }
        while(user_y > 9 || user_y < 0) {
            System.out.print("Enter y coordinate: ");
            user_y = input.nextInt();
        }

        playMove(user_x, user_y);

    }

    public void computersMove(){
        int computer_x = -1;
        int computer_y = -1;
        boolean valid_guess = false;

        // get the input
        System.out.println("COMPUTER'S TURN!");
        while(!valid_guess){
            computer_x = randomNumber.nextInt(10);
            computer_y = randomNumber.nextInt(10);
//            System.out.println("Computer guesses " + computer_y + " " + computer_x);

            // is the target valid
            if(grid[computer_y][computer_x] != 'c' && grid[computer_y][computer_x] != '2' && grid[computer_y][computer_x] != '!'){
                valid_guess = true;
            }
        }

        char target = grid[computer_y][computer_x];

        // evaluate and place the move
        if(target == '2'){
            System.out.println("Computer sunk it's own ship!");
            grid[computer_y][computer_x] = 'x';
            computer_ships_remaining--;
        } else if(target == '1'){
            System.out.println("The computer sunk your ship!");
            grid[computer_y][computer_x] = '!';
            user_ships_remaining--;
        } else if(target == ' '){
            System.out.println("Computer missed!");
            grid[computer_y][computer_x] = 'c';
        }
    }

    public void playGame(){
        // display the grid
        displayGrid(grid);

        // loop through the moves
        while(user_ships_remaining > 0 && computer_ships_remaining > 0){
            // player's move
            playersMove();

            // computer's move
            computersMove();

            // display board
            displayGrid(grid);
        }
        System.out.println("Your ships: " + user_ships_remaining + " | Computer's ships " + computer_ships_remaining);
        if(user_ships_remaining == 0){
            System.out.println("The computer wins!");
        } else {
            System.out.println("You win!");
        }
    }

    public static void main(String[] args){
        System.out.println("Welcome to battleship!");
        System.out.println();

        Battleship game = new Battleship();

        // initialize the empty grid
        game.createGrid();

        // place the user's ships
        game.placeShips('1');

        // place the computer's ships
        game.placeComputerShips();

        game.playGame();

    }
}
