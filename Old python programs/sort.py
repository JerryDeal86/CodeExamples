#Author: COP1000
#Date: 11-3-16
#Description: this program sort the content of an array (simulated by a list)
#--------------------------------------------------------------------------------
#
#
#declarations
num = [92, 14, 37, 9, 2, 25]
i = 0
j = i + 1
temp = 0
#print array as is
print("The unsorted content: \n", num)
#sort the array
while i < 5:
    while j < 6:
        if num[i] > num[j]:
            temp   = num[i] #I
            num[i] = num[j] #II
            num[j] = temp   #III
        #end if
        j = j + 1
    #end while j
    i = i + 1
    j = i + 1
#end while i
#print array sorted:
print("The sorted content: \n", num)
