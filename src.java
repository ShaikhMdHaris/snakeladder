package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class SnakeLaddderGame {
    final static int WINPOINT = 100;

    /*
     Defining globally two map, one for Snake values and another for ladder value.
     */
    static Map<Integer,Integer> snake = new HashMap<Integer,Integer>(); // For snake
    static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();// For Ladder

    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);

        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }

    // Making Constructor for SnakeLaddrGame
    public class SnakeNLadderGameTest {

        public  void main(String[] args) {
            SnakeLaddderGame s = new SnakeLaddderGame();
            s.startTheGame();
        }

    }

    // Function to return Dice value after rolling
    public int RollingDice()
    {
        int n = 0;
        Random r = new Random(); // Using Random method to generate the Dice value
        n=r.nextInt(7);
        return n==0 ? 1 : n;
    }

    // Function Where we start our Game......
    public void startTheGame()
    {
        int player1 =0, player2=0;
        int currentPlayer=-1; // Using this integer to store the turn of players
        Scanner s = new Scanner(System.in);
        String str;
        int diceValue =0;
        do
        {
            System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
            System.out.println("Press r to roll Dice");
            str = s.next();
            diceValue = RollingDice();


            if(currentPlayer == -1)
            {
                player1 = getPlayerValue(player1,diceValue);
                System.out.println("Dice Value for Player-1 :: " + diceValue );
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
                System.out.println("------------------");
                if(isWin(player1))
                {
                    System.out.println("First player won");
                    return;
                }
            }
            else
            {
                player2 = getPlayerValue(player2,diceValue);
                System.out.println("First Player :: " + player1);
                System.out.println("Dice Value for Player-2 :: " + diceValue );
                System.out.println("Second Player :: " + player2);
                System.out.println("------------------");
                if(isWin(player2))
                {
                    System.out.println("Second player won");
                    return;
                }
            }

            currentPlayer= -currentPlayer;



        }while("r".equals(str));
    }

    public int getPlayerValue(int player, int diceValue)
    {
        player = player + diceValue;

        if(player > WINPOINT)
        {
            player = player - diceValue;
            return player;
        }

        if(null != snake.get(player))
        {
            System.out.println("swallowed by snake");
            player= snake.get(player);
        }

        if(null != ladder.get(player))
        {
            System.out.println("climb up the ladder");
            player= ladder.get(player);
        }
        return player;
    }
    public boolean isWin(int player)
    {
        return WINPOINT == player;
    }

    public static void main(String[] args) {
        SnakeLaddderGame SNL = new SnakeLaddderGame();
        SNL.startTheGame();
    }

}
