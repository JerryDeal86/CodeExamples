#Author: COP1000
#Date: 9-27-16
#Description:  with boolean type
#========================================
#
import random
#declaration:
a = 0
b = 0
d = False 

#
while d ==  False:  # d False measn a is still  not divisible by b
    a = random.randint(100,1000)
    b = random.randint(100,1000)
    r = a % b
    if r == 0:
        d = True
    #end if
    print("a = ", a, "--------- b = ", b)
#end while
print("\n\nprogram stopped...a is divisible by b!")
