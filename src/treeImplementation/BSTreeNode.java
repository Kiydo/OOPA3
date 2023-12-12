package treeImplementation;


/**
 * Represents a node in a binary search tree.
 *
 * @param <E> The type of data stored in the node, must implement Comparable.
 */

public class BSTreeNode<E extends Comparable<? super E>> {
    private E data;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;
    private BSTreeNode<E> parent;


    /**
     * Constructs a BSTreeNode with the specified data.
     *
     * @param data The data to be stored in the node.
     */
    public BSTreeNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }


    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data stored in the node.
     *
     * @param data The data to be stored in the node.
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Gets the left child node.
     *
     * @return The left child node.
     */
    public BSTreeNode<E> getLeft() {
        return left;
    }
    
    /**
     * Sets the left child node.
     *
     * @param left The left child node.
     */
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    /**
     * Gets the right child node.
     *
     * @return The right child node.
     */
    public BSTreeNode<E> getRight() {
        return right;
    }

    /**
     * Sets the right child node.
     *
     * @param right The right child node.
     */
    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    /**
     * Gets the parent node.
     *
     * @return The parent node.
     */
    public BSTreeNode<E> getParent() {
        return parent;
    }

    /**
     * Sets the parent node.
     *
     * @param parent The parent node.
     */
    public void setParent(BSTreeNode<E> parent) {
        this.parent = parent;
    }

}
