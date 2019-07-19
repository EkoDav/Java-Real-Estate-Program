/*
 * The RealtorLogImpl class will implement a log of realtor objects contained
 * within a Binary Search Tree.
 */
package realestateprog;

/**
 * @author Erik Davis
 * @version 6.0
 */
public class RealtorLogImpl {
    private RealtorNode root;
    private Realtor[] realtorArray;
    private int realtorIdx;
    private int nodeCount;
    
    /**
     * Basic Constructor
     */
    public RealtorLogImpl() {
        this.root = null;
        this.realtorArray = null;
        this.realtorIdx = 0;
        this.nodeCount = 0;
    }
    
    /**
     * Method to get the number of nodes in the tree.
     * 
     * @return int - The number of nodes. 
     */
    public int getNumNodes() {
        return nodeCount;
    }
    
    /**
     * Method to get the current root of the tree. 
     * 
     * @return RealtorNode - The node that is the current root of the tree. 
     */
    public RealtorNode getRoot() {
        return root;
    }
    
    /**
     * Method to set the root of the tree. 
     * 
     * @param root - New node to become the root. 
     */
    public void setRoot(RealtorNode root) {
        this.root = root;
    }
    
    /**
     * Method to get the Realtor Array when the tree needs to be rebalanced. 
     * 
     * @return Realtor[] - The Realtor array
     */
    public Realtor[] getRealtorArray() {
        return realtorArray;
    }
    
    /**
     * Method to set the Realtor Array.
     * 
     * @param realtorArray - The Realtor array to be set.
     */
    public void setRealtorArray(Realtor[] realtorArray) {
        this.realtorArray = realtorArray;
    } 
    
    /**
     * Method to get a Realtor object from the tree. 
     * 
     * @param root - The current root node of the tree. 
     * @param realtorLN - The license number of the realtor being searched for.
     * @return - Realtor object found, return null if not found. 
     */
    public Realtor getRealtor(RealtorNode root, String realtorLN) {
        if (root == null) {
            return null;
        } 
        if (root.getKey().compareTo(realtorLN) > 0) {
            return getRealtor(root.getLeftNode(), realtorLN);
        } else if (root.getKey().compareTo(realtorLN) == 0) {
            return root.getRealtor();
        } else {
            return getRealtor(root.getRightNode(), realtorLN);
        }
    }
    
    /**
     * Method to insert a new Realtor object into the tree. Will create a new 
     * RealtorNode and set the key to the Realtor license number. 
     * 
     * @param root - The current root of the tree. 
     * @param realtor - The Realtor object to be inserted into the tree. 
     */
    public void insert (RealtorNode root, Realtor realtor) {
        if (root != null) {
            if (root.getKey().compareTo(realtor.getLicenseNum()) > 0) {
                if (root.getLeftNode() != null) {
                    insert(root.getLeftNode(), realtor);
                } else {
                    RealtorNode newNode = new RealtorNode(realtor);
                    root.setLeftNode(newNode);
                }
            } else {
                if (root.getRightNode() != null) {
                    insert(root.getRightNode(), realtor);
                } else {
                    RealtorNode newNode = new RealtorNode(realtor);
                    root.setRightNode(newNode);
                }
            }
        } else {
            RealtorNode newNode = new RealtorNode(realtor);
            setRoot(newNode);
        }
    }
    
    /**
     * Method to rebuild the Binary Search Tree when it is unbalanced. 
     * 
     * @param realtorArray - The Realtor array containing the realtor data from 
     * the previous tree. 
     */
    public void rebuildTree(Realtor[] realtorArray) {
        int midPoint = realtorArray.length / 2;
        
        insert(this.getRoot(), realtorArray[midPoint]);
        Realtor[] leftArray = new Realtor[midPoint];
        if (leftArray.length > 0) {
            for (int idx = 0; idx < leftArray.length; idx++) {
                leftArray[idx] = realtorArray[idx];
            }
            
            rebuildTree(leftArray);
            
            Realtor[] rightArray = new Realtor[(realtorArray.length) -
                    (midPoint + 1)];
            if (rightArray.length > 0) {
                int idxR = 0;
                for (int idx = midPoint+1; idx < realtorArray.length; idx++) {
                    rightArray[idxR] = realtorArray[idx];
                    idxR++;
                }
                rebuildTree(rightArray);
            }
        }
    }
    
    /**
     * Method to check if the tree is balanced or not. 
     * 
     * @param root - The current root of the tree. 
     * @return boolean - True if the tree is balanced, false otherwise. 
     */
    public boolean isTreeBalanced(RealtorNode root) {
        boolean isBalanced = false;
        if (root == null) {
            isBalanced = true;
        } else if (getTreeHeight(root) != -1) {
            isBalanced = true;
        }
        return isBalanced;
    }
    
    /**
     * Method to get the height of the tree. Used to determine if tree is balanced.
     * 
     * @param root - The current root of the tree. 
     * @return int - The tree height
     */
    public int getTreeHeight(RealtorNode root) {
        int height = 0;
        if (root != null) {
            int leftNode = getTreeHeight(root.getLeftNode());
            int rightNode = getTreeHeight(root.getRightNode());
            
            if (leftNode == -1 || rightNode == -1) {
                height = -1;
            } else if (Math.abs(leftNode - rightNode) > 1) {
                height = -1;
            } else {
                height = Math.max(leftNode, rightNode) + 1;
            }
        }
        return height;
    }
    
    /**
     * Method to dump the current tree data into an array in order to rebalance it.
     * 
     * @param root - The current root of the tree. 
     */
    public void dumpTree (RealtorNode root) {
        if (root != null) {
          dumpTree (root.getLeftNode());
          realtorArray[realtorIdx++] = root.getRealtor();
          dumpTree (root.getRightNode());
        }
    }
    
    /**
     * Method to add a Realtor object into the tree. This method will also keep
     * track of the node count in the tree, and check if the tree needs to be 
     * rebalanced after every addition. 
     * 
     * @param obj - The Realtor object to be inserted into the tree. 
     */
    public void add (Object obj) {
        Realtor realtor = (Realtor)obj;
        insert(this.root, realtor);
        System.out.println("ADDED: Realtor with license number " + realtor.
                getLicenseNum());
        nodeCount++;
        if (!(isTreeBalanced(this.root))) {
            System.out.println("   (Rebalancing Realtor Tree...)");
            realtorArray = new Realtor[nodeCount];
            realtorIdx = 0;
            dumpTree(root);
            this.setRoot(null);
            rebuildTree(realtorArray);
        }
    }
    
    /**
     * Method to determine if the tree is empty. 
     * 
     * @return boolean - True if the tree is empty, false otherwise. 
     */
    public boolean isEmpty() {
        return (root == null);
    }
    
    /**
     * Method to traverse all the data in the current tree and display it to the 
     * system output. 
     * 
     * @param root - The current root of the tree. 
     */
    public void traverseDisplay(RealtorNode root) {
        if (root != null) {
            traverseDisplay(root.getLeftNode());
            System.out.println(root.getRealtor().toString());
            traverseDisplay(root.getRightNode());
        }
    }
}