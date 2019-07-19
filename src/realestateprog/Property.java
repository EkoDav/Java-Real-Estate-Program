/*
 * The Property Class compliments the real estate program and will create objects 
 * for each unique property in the real estate office database. 
 */
package realestateprog;

import java.util.Objects;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class Property {
    private int mlsNum,zipCode,numBed;
    private String licenseNum,address,city,state;
    private double numBath,askingPrice;
    private boolean sold;

    //Constructors

    /**
     * Empty constructor to initialize a new instance of a Property object.
     */
    public Property() {
    }

    /**
     * Constructor using parameters to build an instance of a Property object.
     * 
     * @param mlsNum - Property MLS Number
     * @param licenseNum - Realtor License Number
     * @param address - Property Address
     * @param city - Property City
     * @param state - Property State
     * @param zipCode - Property ZipCode
     * @param numBed - Number of bedrooms on Property
     * @param numBath - Number of bathrooms on Property
     * @param sold - Boolean indicating whether Property has sold or not
     * @param askingPrice - Asking price for the Property.
     */
    public Property(int mlsNum, String licenseNum, String address, String city, 
            String state, int zipCode, int numBed, double numBath, 
            boolean sold, double askingPrice) {
        this.mlsNum = mlsNum;
        this.licenseNum = licenseNum;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.numBed = numBed;
        this.numBath = numBath;
        this.sold = sold;
        this.askingPrice = askingPrice;
    }

    //Getters and Setters

    /**
     * Getter for the asking price
     * @return askingPrice
     */
    public double getAskingPrice() {
        return askingPrice;
    }

    /**
     * Setter for the asking price
     * @param askingPrice
     */
    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    /**
     * Getter for MLS Number
     * @return
     */
    public int getMlsNum() {
        return mlsNum;
    }

    /**
     * Setter for MLS Number
     * @param mlsNum
     */
    public void setMlsNum(int mlsNum) {
        this.mlsNum = mlsNum;
    }

    /**
     * Getter for Realtor License Number
     * @return
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * Setter for Realtor License Number
     * @param licenseNum
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     * Getter for Property Address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for Property Address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for Property City
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for Property City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for Property State
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for Property State
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for Property ZipCode
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Setter for Property ZipCode
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter for Number of Bedrooms
     * @return
     */
    public int getNumBed() {
        return numBed;
    }

    /**
     * Setter for Number of Bedrooms
     * @param numBed
     */
    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }

    /**
     * Getter for Number of Bathrooms
     * @return
     */
    public double getNumBath() {
        return numBath;
    }

    /**
     * Setter for Number of Bathrooms
     * @param numBath
     */
    public void setNumBath(double numBath) {
        this.numBath = numBath;
    }

    /**
     * Getter for boolean sold or not
     * @return boolean sold
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Setter for boolean sold or not
     * 
     * @param sold
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }
    
    //Compare attributes for duplicates

    /**
     * The equals method will compare two Property objects and determine if they
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
        final Property other = (Property) obj;
        if (this.mlsNum != other.mlsNum) {
            return false;
        }
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (this.numBed != other.numBed) {
            return false;
        }
        if (Double.doubleToLongBits(this.numBath) 
                != Double.doubleToLongBits(other.numBath)) {
            return false;
        }
        if (this.sold != other.sold) {
            return false;
        }
        if (Double.doubleToLongBits(this.askingPrice) 
                != Double.doubleToLongBits(other.askingPrice)) {
            return false;
        }
        if (!Objects.equals(this.licenseNum, other.licenseNum)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return Objects.equals(this.state, other.state);
    }

    /**
     * Method to generate a hash code to store the property object in a set or map.
     * The code is generated based on the Property's MLS number.
     * 
     * @return hash - The property object's hash code. 
     */
    @Override
    public int hashCode() {
        int hash = this.getMlsNum();
        return hash;
    }
    
    /**
     * Method toString method to display data values
     * 
     * @return - All data values stored
     */
    @Override
    public String toString() {
        return "Property{" + "mlsNum=" + mlsNum + ", licenseNum=" + licenseNum 
                + ", address=" + address + ", city=" + city + ", state=" 
                + state + ", zipCode=" + zipCode + ", numBed=" + numBed 
                + ", numBath=" + numBath + ", sold=" + sold + ", askingPrice=" 
                + askingPrice + '}';
    }
    
    //Methods to test attributes for errors

    /**
     * Method to verify the length of the MLS number. 
     * @return - boolean true = valid
     */
    public boolean verifyMLSLength() {
        String mlsString = Integer.toString(mlsNum);
        int mlsLength = mlsString.length();
        return mlsLength == 7;
    }
    
    /**
     * Method to verify the State as either CO or WY
     * @return - boolean true = valid
     */
    public boolean verifyState() {
        return (state.equals("WY") || state.equals("CO"));
    }
    
    /**
     * Method to verify the length of the ZipCode
     * @return - boolean true = valid
     */
    public boolean verifyZipLength() {
        String zipString = Integer.toString(zipCode);
        return zipString.length() == 5;
    }
    
    /**
     * Method to verify the format of the ZipCode
     * @return - boolean true = valid
     */
    public boolean verifyZipFormat() {
        String zipString = Integer.toString(zipCode);
        String zipBegin = zipString.substring(0, 2);
        return (zipBegin.equals("80") || zipBegin.equals("81") || 
                zipBegin.equals("82") || zipBegin.equals("83"));
    }
}