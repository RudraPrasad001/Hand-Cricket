import java.util.Random;
import java.util.Scanner;

public class HandCricket {
    String choice ;int compBallNo =1;int playerBallNo = 1;int compRun = 0;int playerRun =0;int balls;int count =0;
    public void startGame()
    {Scanner s = new Scanner(System.in);
        String tails = "TAILS";boolean toss;boolean loop = true;

        System.out.println("The Hand Cricket World Championship is going to start. \nHow many overs do you want");
        int overs = s.nextInt();
        if(overs<0)
            overs =1;
        if (overs>6)
            overs = 6;
        balls = overConvertor(overs);
        System.out.printf("the number of overs is %d ,so the number of balls is %d \n",overs,balls);
        while(loop)
        {
            System.out.println("Heads or Tails?");
            Scanner sa = new Scanner(System.in);
            choice = sa.nextLine();
            switch (choice.toUpperCase().charAt(0)) {
                case 'H' :  {
                }
                case 'T' :  {choice = tails;loop =false;}
                default: {System.out.println(" ");}
            }
        }
        toss = whoseTurn(choice);
        if(toss)
            choiceTab();
        else
            noChoiceTab();
        if(playerRun>compRun)
        {
            System.out.printf("\nYou won the computer by %d runs!!!",playerRun-compRun);
        }
        else if (compRun>playerRun){
            System.out.printf("\n You are defeated by the computer by %d runs...",compRun-playerRun);
        }
        else
        {
            System.out.printf("\nIt is a TIE!!! You both scored %d ",playerRun);
        }
    }
    public int overConvertor(int overs)
    {
        overs= overs*6;
        return overs;
    }
    public void playerTurn()
    {boolean out = false;
        count++;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int playerChoice;int compBall;
        while(!out)
        {
            compBall=r.nextInt(0,6);
            if(compBallNo >balls)
            {
                System.out.printf("\n\n%d balls has been over , Match over.\n Total runs scored by you : %d",balls,playerRun);break;
            }

            System.out.printf("Ball no : %d,Runs = %d,\nSelect your choice from zero to six in digits "
                    , compBallNo,playerRun);
            playerChoice = s.nextInt();
            if(playerChoice>6)
                playerChoice=6;
            if(playerChoice<0)
                playerChoice=0;
            if(playerChoice==compBall)
            {
                System.out.printf("""
                        
                        
                        You chose %d,Computer chose %d . Match over .
                         Wicket at ball no :%d \
                        
                         Total runs scored : %d""",playerChoice,compBall, compBallNo,playerRun);break;
            }

            compBallNo++;
            playerRun+=playerChoice;
        }
        if(count ==1)
        {
            System.out.println("\n\n Now Opponent batting");
            compTurn();
        }
    }
    public void compTurn()
    {
        count++;
        boolean out = false;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int compChoice;int playerBall;
        while(!out)
        {
            compChoice =r.nextInt(0,6);
            if(playerBallNo >balls)
            {
                System.out.printf("\n\n%d balls has been over , Match over.\n Total runs scored by opponent : %d",balls,compRun);break;
            }

            System.out.printf("\nBall no : %d,Opponent Runs = %d,\nSelect your choice from zero to six in digits "
                    , playerBallNo,compRun);
            playerBall = s.nextInt();
            if(playerBall >6)
                playerBall =6;
            if(playerBall <0)
                playerBall =0;
            if(compChoice == playerBall)
            {
                System.out.printf("""
                        
                        
                        Computer chose %d,You chose %d . Match over .
                         You took Wicket at ball no :%d \
                        
                         Total runs scored by opponent: %d""", compChoice, playerBall, playerBallNo,compRun);break;
            }

            playerBallNo++;
            compRun+= compChoice;

        }
        if(count ==1)
        {
            System.out.println("\n\n Now Player batting");
            playerTurn();
        }
    }
    public boolean whoseTurn(String choice)
    {
        Random r = new Random();
        int coinRand =r.nextInt(1,3);
        String coinChoice = coinRand ==1?"HEADS":"TAILS";
        return choice.equals(coinChoice);
    }
    public void choiceTab()
    {
        Scanner s = new Scanner(System.in);
        boolean loop =true;
        while(loop) {
            System.out.print("\n\nYou won!! \n Do you want to choose Batting or Bowling?");
            String bow = s.nextLine();
            switch (bow.toUpperCase().charAt(1)) {
                case 'A' -> {loop = false;playerTurn();}
                case 'O' -> {loop = false;compTurn();}
                default -> System.out.println("Try again");
            }
        }
    }
    public void noChoiceTab()
    {
        System.out.print("You lost the toss.. \n The computer chose ");
        Random r = new Random();
        int coinRand =r.nextInt(1,3);
        String compChoice = coinRand ==1?"Batting\n":"Bowling\n";
        System.out.print(compChoice);
        if(coinRand==1)
        {
            compTurn();
        }
        else {
            playerTurn();
        }
    }
}
