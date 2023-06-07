# Author: Alvin Cruz
# Date: 09/29/2016
# Description: This program will generate two random numbers between 1 and 20.
#   It will then prompt the user to guess two numbers. Then it will determine if
#   the users numbers match the randomly generated numbers. If they match the
#   program will print "You won!" and "Sorry try again." when they do not match.
#   Finally it will ask the user if they want to try again. If yes the program
#   will repeat. If no the program will end
#
#------------------------------------------------------------------------------
#
# Importing the random number generator
import random
#
# Declarations:
random1 = 0
random2 = 0
user1 = 0
user2 = 0
games = 0
win = 0
lose = 0
end = " "
#
# General Welcome Message
print ( "Welcome to the Guessing Games. Let's play a game." )
#
# Loop the program to continue until user decides to end program
while end != "no" :
    #
    # Inputs
    # Generate random numbers
    random1 = random.randint(1,20)
    random2 = random.randint(1,20)
    #
    # Prompt user to guess
    print ( "I have selected two numbers. \nTime for you to guess!" )
    user1 = int ( input ( "Please enter your first guess between 1 to 20: " ) )
    user2 = int ( input ( "Please enter your second guess between 1 to 20: " ) )
    #
    # Process and Output
    # Compares the numbers to determine if the user wins
    if (user1 == random1 and user2 == random2) or (user1 == random2 and user2 == random1) :
        print ( "Congratulations you have won the game!")
        win = win + 1 # Tracking number of wins
    else :
        print ( "Sorry you lost. =[" )
        lose = lose + 1 # Tracking number of loses
    # End IF loop
    #
    # Tracking number of games
    games = games + 1
    # Ask the user if they want to try again
    end = input ( "Would you like to try again? yes or no: " )
# End WHILE LOOP
#
# Display results
print ( "Your results! \nYou played: " , games , "\nYou won: " , win , "\nYou lost: " , lose )
