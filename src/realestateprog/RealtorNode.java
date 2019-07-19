/*
 * The RealtorNode class will be used to build Realtor nodes needed to insert
 * Realtor data into the Binary Search Tree.
 */
package realestateprog;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class RealtorNode {
    private String key;
    private Realtor realtor;
    private RealtorNode left;
    private RealtorNode right;
    
    /**
     * Basic Constructor 
     */
    public RealtorNode() {
        this.key = null;
        this.realtor = null;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Constructor with Realtor object as parameter. Will set the key to the 
     * Realtor license number. 
     * 
     * @param realtor - The Realtor object to be added. 
     */
    public RealtorNode(Realtor realtor) {
        this.key = realtor.getLicenseNum();
        this.realtor = realtor;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Method to get the key of the RealtorNode. 
     * 
     * @return String - The key of the RealtorNode.
     */
    public String getKey() {
        return key;
    }
    
    /**
     * Method to get a Realtor object from a RealtorNode. 
     * 
     * @return Realtor - The Realtor object from the RealtorNode. 
     */
    public Realtor getRealtor() {
        return realtor;
    }
    
    /**
     * Method to set the Realtor object for a RealtorNode. 
     * 
     * @param realtor - The Realtor object to be set into the RealtorNode. 
     */
    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }
    
    /**
     * Method to get the left node of the current RealtorNode. 
     * 
     * @return RealtorNode - The left node. 
     */
    public RealtorNode getLeftNode() {
        return left;
    }
    
    /**
     * Method to set the left node of the current RealtorNode. 
     * 
     * @param left - The node to be set as left of current. 
     */
    public void setLeftNode (RealtorNode left) {
        this.left = left;
    }
    
    /**
     * Method to get the right node of the current RealtorNode.
     * 
     * @return RealtorNode - The right node.
     */
    public RealtorNode getRightNode() {
        return right;
    }
    
    /**
     * Method to set the right node of the current RealtorNode.
     * 
     * @param right - The node to be set as right of current.
     */
    public void setRightNode (RealtorNode right) {
        this.right = right;
    }
}
