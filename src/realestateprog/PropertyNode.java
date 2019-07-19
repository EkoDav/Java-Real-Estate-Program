/*
 * The PropertyNode class will be used to build Property nodes needed to insert
 * Property data into the TreeMap.
 */
package realestateprog;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class PropertyNode {
    private int key;
    private Property property;
    
    /**
     * Basic Constructor
     */
    public PropertyNode() {
        this.key = 0;
        this.property = null;
    }
    
    /**
     * Constructor with a Property object as parameter. Will set the key to the 
     * MLS number of the Property. 
     * 
     * @param property - The Property object to be inserted into the node.
     */
    public PropertyNode(Property property) {
        this.key = property.getMlsNum();
        this.property = property;
    }
    
    /**
     * Method to get the key for the PropertyNode.
     * 
     * @return int - The property key.
     */
    public int getKey() {
        return key;
    }
    
    /**
     * Method to set the key for a PropertyNode.
     * 
     * @param propertyMLS - The MLS number of the Property object. 
     */
    public void setKey(int propertyMLS) {
        this.key = propertyMLS;
    }
    
    /**
     * Method to get the Property from the PropertyNode.
     * 
     * @return Property - The requested Property Object. 
     */
    public Property getProperty() {
        return property;
    }
    
    /**
     * Method to set the Property object of the PropertyNode
     * 
     * @param property - The Property object to be set. 
     */
    public void setProperty(Property property) {
        this.property = property;
    }
}