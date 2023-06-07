#Author:
#Date due:
#Date submitted:
#Description:
#------------------------------------------------------
#
#
def main():
    #parallel arrays (simulated with list to store customer data:
        #declare all needed arrays
    #parallel arrays simulated with lists to store tool data:
        #declare all needed arrays
    #working variables: any variable you need within main: i.e. answer, i, ...etc...etc
    #start a while loop that ends when user select option 3 from menu
        #call main menu
        #based on selection (1 or 2 or 3)
        #if selection 1 then process customer (display a short sub menu of your choice with 'create' or 'search'
            #if create then call getCustomer() otherwise call getSearch followed with a call to searchCustomer
            #and in this case call the dispCustomer
        #if selection is 2, then (display a short sub menu with 'initiate' , 'search' ,  or 'add' (this one is optional)
            #if 'initiate' then call the function 'rent tool', if 'search' then call the getsearchToolID
            #if add then call the fucntion addTool()
        #prompt user to continue or abort application
        #get user answer
    #the end
    #good bye!
#end main
#====================customers process section=====================
def getCustomer(????):
    #input the field for one single customer
#end getCustomer
#-------------------------------------------------------------------
def getSearchCustomerID(????):
    #prompt for a customer search ID
    #return it
#end getSEarchID
#-------------------------------------------------------------------
def searchCustomer(????):
    #search for this ID inside the array of customer ID's
    #return position if found
    #return -1 if not
#end searchCustomer
def dispCustomer(????????????????):
    #display, using a suitable format i.e. a given customer data
#end dispCustomer
#-------------------------------------------------------------------
#
#=====================tools process section=========================
def addTool(???????):
    #this is optional and for XC
#end addTool
#-------------------------------------------------------------------
def getSearchToolID(???????):
    #prompt for a tool search ID
    #return it
#end getSearchToolID
#-------------------------------------------------------------------
def searchTool(???????):
    #search for this ID inside the array of tool ID's
    #return position if found
    #return -1 if not
#end searchtoolID
#-------------------------------------------------------------------
def dispTool(???????):
    #disply all data about a given tool
#end dispTool
#-------------------------------------------------------------------
def rentTool(?????????????):
    #prompt user for customer ID
    #search for customer ID
    #if found:
    #prompt for a tool : yiou may want to display all tools data or assume the ID is known to user
    #search for tool ID, and if found:
    #chekc if it is available ( field 'rented' still set to 'False'
    #ask for rental term: full day or half day
    #depending on if full or half assign the correct value and add it to cutoemr balanc,
    #then reset 'rented' to 'True'
#end rentTool
#-------------------------------------------------------------------
def generateReport(????????????????????): #passs customer references to all arrays and the same for tools
    #print a report that display all rented equipements and the customers
#end generateReport
#====================================================================
#calling main
main()
    
