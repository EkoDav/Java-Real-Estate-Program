/*
 * The PropertyLogImpl class will implement a log of property objects contained
 * within a TreeMap.
 */
package realestateprog;

import java.util.TreeMap;
import java.util.Map;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class PropertyLogImpl {
    private PropertyNode root;
    private TreeMap<Integer,PropertyNode> propertyTree;
    
    //Basic Constructor
    PropertyLogImpl() {
        this.root = null;
        this.propertyTree = new TreeMap();
    }
    
    /**
     * Method to return the number of nodes currently in the tree.
     * 
     * @return int - Number of nodes in the tree. 
     */
    public int getNumNodes() {
        return propertyTree.size();
    }
    
    /**
     * Method to get the root of the tree. 
     * 
     * @return PropertyNode - The tree root.
     */
    public PropertyNode getRoot() {
        return root;
    }
    
    /**
     * Method to add a property to the tree by creating a PropertyNode and then
     * using the TreeMap class method to add it.
     * 
     * @param property - The property object to be added to the tree. 
     */
    public void add(Property property) {
        PropertyNode propertyNode = new PropertyNode(property);
        int key = propertyNode.getKey();
        propertyTree.put(key,propertyNode);
        System.out.println("ADDED: Property with MLS number " + key);
    }
    
    /**
     * Method to get a property from the TreeMap. 
     * 
     * @param key - The MLS number of the property being searched for.
     * @return Property - The property found, returns null if not found.
     */
    public Property getProperty(int key) {
        PropertyNode property = (PropertyNode) propertyTree.get(key);
        return property.getProperty();
    }
    
    /**
     * Method to determine if a property is in the TreeMap.
     * 
     * @param key - The MLS number of the property being searched for.
     * @return boolean - True if the property was found, false otherwise.
     */
    public boolean contains(int key) {
        return propertyTree.containsKey(key);
    }
    
    /**
     * Method to traverse all data in the tree and display it to the output. 
     */
    public void traverseDisplay() {
        for (Map.Entry<Integer,PropertyNode> property : propertyTree.entrySet()) {
            System.out.println(property.getValue().getProperty().toString());
        }
    }
}