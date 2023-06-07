#Author: COP1000
#Date: 11-3-16
#Description: this program sort the content of an array (simulated by a list)
#this program uses functions.
#--------------------------------------------------------------------------------
#
#
def main():
    #declarations
    num = [92, 14, 37, 9, 2, 25]
    #print array as is
    print("The unsorted content: \n")
    disp(num)
    #sort the array
    sort(num)
    #print array sorted:
    print("The sorted content: \n")
    disp(num)
    

#end main
#=====================================
def sort(num):
    i = 0
    j = i + 1
    temp = 0
    #let's sort
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
#=======================================
def disp(num):
    print(num)
#end disp
#=======================================
#calling main
main()































 



