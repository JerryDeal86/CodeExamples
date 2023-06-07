#Author: COP1000
#Date: 9-27-16
#Description:  w/o boolean type
#========================================
#
import random
#declaration:
a = 1
b = 2

#
while a % b != 0:  # a%b means remainder of a divided by b
    a = random.randint(100,1000)
    b = random.randint(100,1000)
    print("a = ", a, "--------- b = ", b)
#end while
print("\n\nprogram stopped...a is divisible by b!")
