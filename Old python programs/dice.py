#Author: COP1000
#Date: 9-27-16
#Description: generating random numbers: simulating a dice throwing events
#throwi9ng dice 10 times
#========================================
#
#
import random
#declarations:
dice = 0
count = 0
while count < 10:
    #throw the dice
    dice = random.randint(1,6)
    #display outcome
    print(dice)
    count = count + 1
#end while
