package Cricket;

import java.util.*;

public class game {
    static String Bat_or_Ball_User;
    static int overs;
    static int wkts;
    static int wktscount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String Toss_Result = r.nextBoolean() ? "h" : "t";
        String Bat_or_Ball = r.nextBoolean() ? "bat" : "ball";

        System.out.print("Choose h/t : ");
        String tosschoose = sc.nextLine();

        // System.out.println("Enter number of overs : ");
        // int overs = sc.nextInt();

        if (tosschoose.equals(Toss_Result)) {
            System.out.println("You won the toss");
            System.out.print("You decide to (bat/ball) : ");
            String tosschoice = sc.nextLine();
            Bat_or_Ball_User = tosschoice;
            System.out.println("You decided to " + tosschoice);
            System.out.print("Enter number of wicktes : ");
            wkts = sc.nextInt();
            if (tosschoice.equals("bat") || (Bat_or_Ball.equals("ball"))) {
                UserBatting(Bat_or_Ball_User,5);
            } else if (tosschoice.equals("ball")) {
                AIBatting(Bat_or_Ball_User,5);
            }

        } else if (Toss_Result.equals("t") || Toss_Result.equals("h")) {
            System.out.println("AI won the toss");
            Bat_or_Ball = r.nextBoolean() ? "bat" : "ball";
            System.out.println("AI choose to " + Bat_or_Ball);
            System.out.print("Enter number of wickets : ");
            wkts = sc.nextInt();
            if (Bat_or_Ball.equals("bat")) {
                AIBatting(Bat_or_Ball,5);
            } else if (Bat_or_Ball.equals("ball")) {
                UserBatting(Bat_or_Ball,5);
            }

        } else {
            System.out.println("Enter a valid choice");
        }

    }

    // AI
    // Batting---------------------------------------------------------------------------------------------------------------
    public static void AIBatting(String Bat_or_Ball,int overs) {
        int runs = 0;
        int chase = 0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        wktscount = 0;
        // ----------------------------------------AI batting----------------------------------------------------------
        while (wktscount < wkts) {

            int AIruns = r.nextInt(6);
            System.out.print("User Bowls : ");
            int UserBowl = sc.nextInt();
            System.out.println("AI Runs : " + AIruns);
            System.out.println();
            if (AIruns != UserBowl) {
                runs = runs + AIruns;
                System.out.print("Runs by AI : " + runs + "/" + wktscount);
                System.out.println();
              
                System.out.println("___________________");
                System.out.println();

            } else if (AIruns == UserBowl) {
                System.out.println("Wicket!!!!!!");
                wktscount++;
                System.out.println(wktscount + " wicket fall");
                
                System.out.println("-------------------------------");

                if (wktscount == wkts) {
                    wktscount = 0;
                    break;
                }
            }

        }
        System.out.print("Total runs of AI is: " + runs);
        System.out.println();
        System.out.println("Runs need by User to win : " + (runs + 1));

        System.out.println();

        //-------------------------- User batting------------------------------------
        while (true) {

            int AIbowl = r.nextInt(6);
            System.out.print("User bats : ");
            int UserBat = sc.nextInt();
            System.out.println("AI bowls : " + AIbowl);
            System.out.println();
            if (AIbowl != UserBat) {

                chase = chase + UserBat;
                System.out.println("Runs by USer : " + chase + "/" + wktscount);
                
                System.out.println("___________________");
                System.out.println("Runs need to win is " + ((runs - chase)));
                if (chase > runs) {
                    System.out.println("User is winner");
                    break;
                }

            } else if (AIbowl == UserBat) {

                System.out.println("Wicket!!!!!!");
                wktscount++;
                System.out.println(wktscount + " wicket fall"); 
                System.out.println("-------------------------------");
                if (wktscount == wkts) {
                    if (chase < runs) {
                        System.out.println("User loose by " + (runs - chase) + " runs");
                        break;
                    }
                    break;
                }

            }
        }
    }

    // User
    // Batting---------------------------------------------------------------------------------------------------------
    public static void UserBatting(String Bat_or_Ball_User, int overs) {
        int runs = 0;
        int chase = 0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        wktscount = 0;
        //----------------- User batting-----------------------

        while (true) {

            int AIball = r.nextInt(6);
            System.out.print("User bats : ");
            int UserBat = sc.nextInt();
            System.out.println("AI bowls : " + AIball);
            System.out.println();
            
            if (AIball != UserBat) {
                runs = runs + UserBat;
                System.out.println("Runs by USer : " + runs + "/" + wktscount);
            
                System.out.println("___________________");

            } else if (AIball == UserBat) {
                System.out.println("Wicket!!!!!!");
                wktscount++;
                System.out.println(wktscount + " wicket fall");
                
                System.out.println("--------------------------------------");
                if (wktscount == wkts) {
                    wktscount = 0;
                    break;
                }
            }

        }
        System.out.println("Total runs of user is : " + runs);

        System.out.println();
        System.out.println("Runs need by AI to win :" + (runs + 1));

        //--------------------------------- AI Batting-------------------------------------------
        while (true) {

            int AIruns = r.nextInt(6);
            System.out.print("user Bowls : ");
            int UserBowl = sc.nextInt();
            System.out.println("AI Runs : " + AIruns);
            System.out.println();
            if (AIruns != UserBowl) {
                chase = chase + AIruns;
                System.out.print("Runs by AI : " + chase + "/" + wktscount);
                System.out.println();
               
                System.out.println("___________________");
                System.out.println("Runs need to win is " + (runs - chase));

                if (chase > runs) {
                    System.out.println("AI is winner");
                    break;
                }
            } else if (AIruns == UserBowl) {
                System.out.println("Wicket!!!!!!");
                wktscount++;
                System.out.println(wktscount + " wicket fall");
                   
                System.out.println("---------------------------------");
                if (wktscount == wkts) {
                    if (chase < runs) {
                        System.out.println("AI loose by " + (runs - chase) + " runs");
                        break;
                    }
                    break;
                }
            }
        }

    }
 }


