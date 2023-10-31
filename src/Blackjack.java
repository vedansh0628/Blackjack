import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        //Give values so that amount of games played, player wins, dealer wins, and tie games can be measured.
        int gamesPlayed = 1;
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;

        //Scanner is created, startGame is set to true so game starts, random number generator is created.
        Scanner scanner = new Scanner(System.in);
        boolean startGame = true;
        P1Random rng = new P1Random();

        while (startGame) {

            //Random number is generated, playerTotal is created so hand can be measured, continue game is set to true so multiple games can be played.
            int myNumber = rng.nextInt(13) + 1;
            int playerTotal = 0;
            boolean continueGame = true;
            System.out.println("START GAME #" + gamesPlayed + "\n");

            //If card is an ace program executes this.
            if (myNumber == 1) {
                System.out.println("Your card is a ACE!");
                System.out.println("Your hand is: 1" + "\n");
                playerTotal += 1;
            }
            //If card is a jack program executes this.
            else if (myNumber == 11) {
                System.out.println("Your card is a JACK!");
                System.out.println("Your hand is: 10" + "\n");
                playerTotal += 10;
            }
            //If card is a queen program executes this.
            else if (myNumber == 12) {
                System.out.println("Your card is a QUEEN!");
                System.out.println("Your hand is: 10" + "\n");
                playerTotal += 10;
            }
            //If card is a king program executes this.
            else if (myNumber == 13) {
                System.out.println("Your card is a KING!");
                System.out.println("Your hand is: 10" + "\n");
                playerTotal += 10;
            }
            //If card is a number 2-10 program executes this.
            else if (myNumber > 1 && myNumber < 11) {
                System.out.println("Your card is a " + myNumber + "!");
                System.out.println("Your hand is: " + myNumber + "\n");
                playerTotal += myNumber;
            }
            while (continueGame) {

                //Options are printed and user input is taken.
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit" + "\n");
                System.out.println("Choose an option: ");
                int userInput = scanner.nextInt();
                System.out.print("\n");

                //PLayer gets another card.
                if (userInput == 1) {
                    myNumber = rng.nextInt(13) + 1;

                    //If card is an ace program executes this.
                    if (myNumber == 1) {
                        playerTotal += 1;
                        System.out.println("Your card is a ACE!");
                        System.out.println("Your hand is: " + playerTotal + "\n");
                    }
                    //If card is a jack program executes this.
                    else if (myNumber == 11) {
                        playerTotal += 10;
                        System.out.println("Your card is a JACK!");
                        System.out.println("Your hand is: " + playerTotal + "\n");
                    }
                    //If card is a queen program executes this.
                    else if (myNumber == 12) {
                        playerTotal += 10;
                        System.out.println("Your card is a QUEEN!");
                        System.out.println("Your hand is: " + playerTotal + "\n");
                    }
                    //If card is a king program executes this.
                    else if (myNumber == 13) {
                        playerTotal += 10;
                        System.out.println("Your card is a KING!");
                        System.out.println("Your hand is: " + playerTotal + "\n");
                    }
                    //If card is a number 2-10 program executes this.
                    else if (myNumber > 1 && myNumber < 11) {
                        playerTotal += myNumber;
                        System.out.println("Your card is a " + myNumber + "!");
                        System.out.println("Your hand is: " + playerTotal + "\n");
                    }
                    //When player's hand exceeds 21, 1 gets added to dealer wins and games played, and the second while loop ends.
                    if(playerTotal > 21) {
                        System.out.println("You exceeded 21! You lose." + "\n");
                        dealerWins++;
                        gamesPlayed++;
                        continueGame = false;
                    }
                    //When player's hand equals 21, 1 gets added to player wins and games played, and the second while loop ends.
                    if(playerTotal == 21) {
                        System.out.println("BLACKJACK! You win!" + "\n");
                        playerWins++;
                        gamesPlayed++;
                        continueGame = false;
                    }
                }

                //Dealer draws, player hand and dealer hand are compared and game ends. 1 is added to game's played.
                else if (userInput == 2) {

                    //Random number is generated for dealer.
                    int dealerNumber = rng.nextInt(11) + 16;

                    //When dealer hand is more than the player but less than or equal to 21, 1 gets added to dealer wins and second while loop ends.
                    if (dealerNumber > playerTotal && dealerNumber <= 21) {
                        System.out.println("Dealer's hand: " + dealerNumber);
                        System.out.println("Your hand is: " + playerTotal + "\n");
                        System.out.println("Dealer wins!" + "\n");
                        dealerWins++;
                        continueGame = false;
                    }
                    //When player hand is more than the dealer but less than or equal to 21, 1 gets added to player wins and second while loop ends.
                    else if (dealerNumber < playerTotal && playerTotal <= 21) {
                        System.out.println("Dealer's hand: " + dealerNumber);
                        System.out.println("Your hand is: " + playerTotal + "\n");
                        System.out.println("You win!" + "\n");
                        playerWins++;
                        continueGame = false;
                    }

                    //When dealer hand and player hand equal each other, 1 gets added to tie games and second while loop ends.
                    else if (dealerNumber == playerTotal) {
                        System.out.println("Dealer's hand: " + dealerNumber);
                        System.out.println("Your hand is: " + playerTotal + "\n");
                        System.out.println("It's a tie! No one wins!" + "\n");
                        tieGames++;
                        continueGame = false;
                    }

                    //When dealer hand exceeds 21, 1 gets added to player wins and second while loop ends.
                    else if (dealerNumber > 21) {
                        System.out.println("Dealer's hand: " + dealerNumber);
                        System.out.println("Your hand is: " + playerTotal + "\n");
                        System.out.println("You win!" + "\n");
                        playerWins++;
                        continueGame = false;
                    }
                    gamesPlayed++;
                }

                //Statistics are printed
                else if (userInput == 3) {

                    //Values are converted to double's for the percentage.
                    double a = playerWins;
                    double b = gamesPlayed - 1;
                    double percentageWins = ((a / b) * 100);
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + (gamesPlayed - 1));
                    System.out.println("Percentage of Player wins: " + percentageWins + "%" + "\n");
                }

                //Both while loops are set to false so program terminates.
                else if (userInput == 4) {
                    continueGame = false;
                    startGame = false;
                }

                //If the user input isn't a number between 1 and 4 inclusive.
                else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4." + "\n");
                }
            }
        }
    }
}