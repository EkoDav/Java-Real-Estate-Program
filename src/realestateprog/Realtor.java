/*
 * The Realtor Class compliments the real estate program and will create objects 
 * for each unique realtor in the real estate office database.
 */
package realestateprog;

import java.util.Objects;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class Realtor {
    private String licenseNum,firstName,lastName,phoneNum;
    private double commPercent;

    //Constructors

    /**
     * Empty constructor to initialize a new instance of a Realtor object.
     */
    public void Realtor() {
    }

    /**
     * Constructor using parameters to build an instance of a Realtor object.
     * 
     * @param licenseNum - Realtor License Number
     * @param firstName - Realtor First Name
     * @param lastName - Realtor Last Name
     * @param phoneNum - Realtor Phone Number
     * @param commPercent - Realtor Commission Percentage
     */
    public void Realtor(String licenseNum, String firstName, String lastName, 
            String phoneNum, double commPercent) {
        this.licenseNum = licenseNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.commPercent = commPercent;
    }

    //Getters and Setters

    /**
     * Getter for the Commission Percent
     * @return
     */
    public double getCommPercent() {
        return commPercent;
    }

    /**
     * Setter for the Commission Percent
     * @param commPercent
     */
    public void setCommPercent(double commPercent) {
        this.commPercent = commPercent;
    }

    /**
     * Getter for the License Number
     * @return
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * Setter for the License Number
     * @param licenseNum
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     * Getter for the First Name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the First Name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the Last Name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the Last Name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the Phone Number
     * @return
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Setter for the Phone Number
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    /**
     * The equals method will compare two Realtor objects and determine if they
     * are equal to each other.
     * 
     * @param obj - The object to be compared to this object.
     * @return - Boolean true = objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Realtor other = (Realtor) obj;
        if (Double.doubleToLongBits(this.commPercent) 
                != Double.doubleToLongBits(other.commPercent)) {
            return false;
        }
        if (!Objects.equals(this.licenseNum, other.licenseNum)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.phoneNum, other.phoneNum);
    }

    /**
     * Method to generate the hash code to store the object in a set or map. 
     * 
     * @return hash - The hash code 
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i < this.licenseNum.length(); i++) {
            char oneChar = this.licenseNum.charAt(i);
            hashCode += oneChar;
        }
        return hashCode;
    }
    
    /**
     * Method toString method to display data values
     * 
     * @return - All data values stored
     */
    @Override
    public String toString() {
        return "Realtor{" + "licenseNum=" + licenseNum + ", firstName=" 
                + firstName + ", lastName=" + lastName + ", phoneNum=" 
                + phoneNum + ", commPercent=" + commPercent + '}';
    }
    
    //Methods to test attributes for errors

    /**
     * Method to verify the length of the License Number
     * 
     * @return - boolean true = valid
     */
    public boolean verifyLicenseLength() {
        int licenseLength = licenseNum.length();
        return licenseLength == 9;
    }
    
    /**
     * Method to verify the alphanumeric values of license number.
     * 
     * @return - boolean true = valid
     */
    public boolean verifyLicenseAlpha() {
        String alphTest = licenseNum.substring(0, 2);
        return alphTest.matches("[a-zA-Z]+");
    }
    
    /**
     * Method to verify the numeric values of license number.
     * 
     * @return - boolean true = valid
     */
    public boolean verifyLicenseNum() {
        String numTest = licenseNum.substring(2);
        return numTest.matches("[0-9]+");
    }
    
    /**
     * Method to verify the length of phone number. 
     * 
     * @return - boolean true = valid
     */
    public boolean verifyPhoneLength() {
        int phoneLength = phoneNum.length();
        return phoneLength == 12;
    }
    
    /**
     * Method to verify the format of the phone number. 
     * 
     * @return - boolean true = valid
     */
    public boolean verifyPhoneFormat() {
        if (phoneNum.charAt(3) != '-') {
            return false;
        } else return phoneNum.charAt(7) == '-';
    }
    
    /**
     * Method to verify the numeric values of phone number.
     * 
     * @return - boolean true = valid
     */
    public boolean verifyPhoneNum() {
        String phoneNum1 = phoneNum.substring(0, 3);
        String phoneNum2 = phoneNum.substring(4, 7);
        String phoneNum3 = phoneNum.substring(8);
        
        if (!phoneNum1.matches("[0-9]+")) {
            return false;
        } else if (!phoneNum2.matches("[0-9]+")) {
            return false;
        } else return phoneNum3.matches("[0-9]+");
    }
}