
/**
 * Write a description of class Administrator here.
 *
 * @author Muhammad Hasan Qasim
 * @version 17/9/2018
 */
public class Administrator extends User
{
    // instance variables - replace the example below with your own
    private boolean accountStatus;

    /**
     * Constructor for objects of class Administrator
     */
    public Administrator()
    {
        // initialise instance variable
        accountStatus = false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean getAccountStatus()
    {
        // put your code here
        return accountStatus;
    }
    
    public void setAccountStatus(boolean status)
    {
        // put your code here
        accountStatus = status;
    }
    
    /**
    * This method is used to covert variables to String and 
    * add commas between each variable integers to be easly saved in csv file.
    * @return String This returns a string of all Administrator and User classes variables.
    */
    public String toString()
    {
        return (this.getUId() + "," + this.getFName() + "," + this.getLName() + "," + this.getAddress()
                 + "," + this.getSuburb() + "," + this.getPostcode() + "," + this.getState() + "," + 
                 this.getEmail() + "," + this.getPassword() + "," + accountStatus);
    }
}
