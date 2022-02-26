import java.util.Scanner;

public class Connecta4 {

    // ## VARS and UTILS ## //

    // utils
    public static Scanner kbd = new Scanner(System.in);

    // board variables
    public static int rows = 6;
    public static int columns = 7;
    public static String[][] board = new String[6][7];

    // players variables
    public static String PlayerName1 = "P1";
    public static String PlayerName2 = "P2";
    public static boolean turn = false;
    public static String symbol = "_";

    // selected column variables
    public static String columnChar = "";
    public static int lastPosition = -1; // this var will be checked to print the player symbol

    // win variables
    public static boolean win = false;
    public static String again = "";

    // ## FUNCTIONS ## //

    public static void askColumn(boolean invalidPos) {

        if (invalidPos == true) {
            System.out.println("Sorry, this column is full!");
            System.out.println();
        }

        if (turn == true) {
            System.out.println(PlayerName1 + " is your turn");
        } else {
            System.out.println(PlayerName2 + " is your turn");
        }

        System.out.println("Select a column: ");

        columnChar = kbd.nextLine();

        // char coflumnChar = (char) kbd.nextLine().toCharArray()[0];

        convertColumn();

    }

    public static void convertColumn() {

        switch (columnChar.toUpperCase()) {
        case "A":
            lastPosition = 0;
            break;
        case "B":
            lastPosition = 1;
            break;
        case "C":
            lastPosition = 2;
            break;
        case "D":
            lastPosition = 3;
            break;
        case "E":
            lastPosition = 4;
            break;
        case "F":
            lastPosition = 5;
            break;
        case "G":
            lastPosition = 6;
            break;
        default:

            System.out.println("Invalid letter! Try again...");
            askColumn(false);

            if (turn == true) { // restart turn if letter is invalid
                turn = false;
            } else {
                turn = true;
            }

        }

        addPiece();

    }

    // change turn and symbol
    public static void chgTurn() {

        if (turn == true) {

            symbol = "O";
            turn = false;

        } else if (turn == false) {

            symbol = "X";
            turn = true;

        }

        askColumn(false);

    }

    // add piece
    public static void addPiece() {

        for (int i = rows - 1; i >= 0; i--) {

            if (board[i][lastPosition] != "X" && board[i][lastPosition] != "O") {
                board[i][lastPosition] = symbol;
                checkWinner(i, lastPosition);
            } else if (i <= 0) {
                askColumn(true);
            }

        }
        drawBoard(false);
    }

    public static void checkWinner(int i, int j) {

        for (int chk = 0; chk < columns-4; chk++) { //check column

            if (board[chk][j] == symbol && board[chk+1][j] == symbol && board[chk+2][j] == symbol
                    && board[chk+3][j] == symbol) {

                win = true;
                break;

            }

        }

        for (int index = 0; index < rows-2; index++) { //check row

            if (board[i][index] == symbol && board[i][index+1] == symbol && board[i][index+2] == symbol
                    && board[i][index+3] == symbol) {

                win = true;
                break;

            }

        }
        
        int rowLimit = i;
        int colLimit = j;
        int rowLimit2 = i;
        int colLimit2 = j;

        while (rowLimit>0 && colLimit > 0) {
            rowLimit--;
            colLimit--;
        }

        int nextRow = rowLimit;
        int nextCol = colLimit;

        while (nextRow < rows-3  && nextCol < columns-3){ // check diagonal -\-

            if (board[nextRow][nextCol] == symbol && board[nextRow+1][nextCol+1] == symbol && board[nextRow+2][nextCol+2] == symbol
                    && board[nextRow+3][nextCol+3] == symbol) {

                win = true;
                break;

            }
            nextRow++;
            nextCol++;
            
        }

        while (rowLimit2>0 && colLimit2 < columns-1) {
            rowLimit2--;
            colLimit2++;
        }

        nextRow = rowLimit2;
        nextCol = colLimit2;

        while (nextRow < rows-3  && nextCol > 2){ // check diagonal -/-

            if (board[nextRow][nextCol] == symbol && board[nextRow+1][nextCol-1] == symbol && board[nextRow+2][nextCol-2] == symbol
                    && board[nextRow+3][nextCol-3] == symbol) {

                win = true;
                break;

            }
            nextRow++;
            nextCol--;
            
        }
        
        drawBoard(false);
    }

    // draw tabletop
    public static void drawBoard(boolean firstGame) {

        System.out.print("\033[H\033[2J");

        for (int row = 0; row < rows; row++) {

            if (row == 0)
                System.out.println("[A][B][C][D][E][F][G]");

            for (int column = 0; column < columns; column++) {

                // insert empty spaces inside array --> "_"
                if (firstGame == true) {

                    board[row][column] = "_";
                }

                // draw board
                if (column == columns - 1) {
                    System.out.print("[" + board[row][column] + "]");
                    System.out.println(" [" + row + "]"); // print column number (WILL BE rows NUMBER) & carriage return
                } else {
                    System.out.print("[" + board[row][column] + "]");

                }
            }
            if (row == rows-1 && win == true) {

                System.out.println("#####################");
    
                if (turn == true) {
                    System.out.println("       ¡"+PlayerName1 + " WINS!");
                } else {
                    System.out.println("       ¡"+PlayerName2 + " WINS!");
                }
                playAgain(false);
            }
        }


        chgTurn();
    }

    public static void playAgain(boolean par) {

        if (par == true) System.out.println("Invalid input! Try again...");

        System.out.println("Do you want to play again? (Y/N)");
        again = kbd.next();

        if (again.toUpperCase().equals("Y")) {
            win = false;
            drawBoard(true);
        } if (again.toUpperCase().equals("N")){
            System.exit(0);
        } else {
            playAgain(true);
        }
        
    }

    //////////////////////////////////

    public static void main(String[] args) {

        drawBoard(true);

    }
}