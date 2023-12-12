package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;

/**
 * A binary search tree implementation that implements the BSTreeADT interface.
 *
 * @param <E> The type of elements in the binary search tree.
 */

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;

    /**
     * Prints the structure of the tree. for debugging purposes.
     */
    public void printTree() {
        System.out.println("Printing Tree Structure:");
        printTree(root);
    }

    public void printTree(BSTreeNode<E> node) {
        if (node != null) {
            System.out.println("Node: " + node.getData() +
                    ", Left: " + (node.getLeft() != null ? node.getLeft().getData() : null) +
                    ", Right: " + (node.getRight() != null ? node.getRight().getData() : null));
            printTree(node.getLeft());
            printTree(node.getRight());
        }
    }
    // End of Debugging

    /**
     * Returns the root node of the binary search tree.
     *
     * @return The root node of the tree.
     */
    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    /**
     * Gets the height of the binary search tree.
     *
     * @return The height of the tree.
     */
    @Override
    public int getHeight() {
        return calculateHeight(root);
    }

    /**
     * Gets the number of nodes in the binary search tree.
     *
     * @return The number of nodes in the tree.
     */

    @Override
    public int size() {
        return calculateSize(root);
    }


    /**
     * Checks if the binary search tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */

    @Override
    public boolean isEmpty() {
        return root == null;
    }


     /**
     * Clears the binary search tree.
     */

    @Override
    public void clear() {
        root = null;

    }


    /**
     * Checks if the tree contains a specific element.
     *
     * @param entry The element to search for.
     * @return True if the element is found, false otherwise.
     * @throws NullPointerException if the entry is null.
     */

    @Override
    public boolean contains(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException("Cannot search for a null value.");
        }
        return searchNode(root, entry) != null;
    }


    /**
     * Adds a new element to the tree.
     *
     * @param newEntry The element to add.
     * @return True if the element is added, false otherwise.
     * @throws NullPointerException if the entry is null.
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException("Cannot add a null value to the tree.");
        }
        root = insert(root, newEntry);
        return true;
    }

    /**
     * Calculates the height of the tree.
     *
     * @param node The node to start calculating the height from.
     * @return The height of the tree.
     */
    private int calculateHeight(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.getLeft());
            int rightHeight = calculateHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Calculates the size of the tree.
     *
     * @param node The node to start calculating the size from.
     * @return The size of the tree.
     */

    private int calculateSize(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return calculateSize(node.getLeft()) + calculateSize(node.getRight()) + 1;
        }
    }



    /**
     * Searches for a specific element in the tree and returns its node.
     *
     * @param node  The node to start searching from.
     * @param entry The element to search for.
     * @return The node containing the element, or null if not found.
     */
    private BSTreeNode<E> searchNode(BSTreeNode<E> node, E entry) {
        if (node == null || entry.equals(node.getData())) {
            return node;
        }

        if (entry.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), entry);
        } else {
            return searchNode(node.getRight(), entry);
        }
    }


    /**
     * Inserts a new element into the tree.
     *
     * @param node     The node to start inserting from.
     * @param newEntry The element to insert.
     * @return The node containing the element.
     */
    private BSTreeNode<E> insert(BSTreeNode<E> node, E newEntry) {
        if (node == null) {
            return new BSTreeNode<>(newEntry);
        }

        int comparisonResult = newEntry.compareTo(node.getData());

        if (comparisonResult < 0) {
            node.setLeft(insert(node.getLeft(), newEntry));
        } else if (comparisonResult > 0) {
            node.setRight(insert(node.getRight(), newEntry));
        }

        return node;
    }


    /**
     * Searches for a specific element in the tree and returns its node.
     *
     * @param entry The element to search for.
     * @return The node containing the element, or null if not found.
     * @throws NullPointerException if the entry is null.
     */

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException("Cannot search for a null value in the tree.");
        }
        return searchEntry(root, entry);
    }


    /**
     * Searches for a specific element in the tree and returns its node.
     *
     * @param node  The node to start searching from.
     * @param entry The element to search for.
     * @return The node containing the element, or null if not found.
     */
    public BSTreeNode<E> searchEntry(BSTreeNode<E> node, E entry) {
        if (node == null || entry.compareTo(node.getData()) == 0) {
            return node;
        }

        if (entry.compareTo(node.getData()) < 0) {
            return searchEntry(node.getLeft(), entry);
        } else {
            return searchEntry(node.getRight(), entry);
        }
    }


     /**
     * Removes the node with the smallest element in the tree.
     *
     * @return The node with the smallest element, or null if the tree is empty.
     */
    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> minNode = findMin(root);
        root = removeEntry(root, minNode.getData());
        return minNode;
    }

    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Removes the node with the largest element in the tree.
     *
     * @return The node with the largest element, or null if the tree is empty.
     */
    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> maxNode = findMax(root);
        root = removeEntry(root, maxNode.getData());
        return maxNode;
    }


    /**
     * Finds the node with the largest element in the tree.
     * @param node
     * @return
     */
    private BSTreeNode<E> findMax(BSTreeNode<E> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    
    /**
     * Removes a specific element from the tree.
     *
     * @param entry The element to remove.
     * @return The node containing the element, or null if not found.
     * @throws NullPointerException if the entry is null.
     */
    private BSTreeNode<E> removeEntry(BSTreeNode<E> node, E entry) {
        if (node == null) {
            return null;
        }

        int comparison = entry.compareTo(node.getData());
        if (comparison < 0) {
            node.setLeft(removeEntry(node.getLeft(), entry));
        } else if (comparison > 0) {
            node.setRight(removeEntry(node.getRight(), entry));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(findMin(node.getRight()).getData());
            node.setRight(removeEntry(node.getRight(), node.getData()));
        }

        return node;
    }

    /**
     * Returns an iterator for traversing the tree in in-order.
     *
     * @return An iterator for in-order traversal.
     */
    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator<E>(root);
    }

    /**
     * Returns an iterator for traversing the tree in pre-order.
     *
     * @return An iterator for pre-order traversal.
     */
    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator<E>(root);
    }

    /**
     * Returns an iterator for traversing the tree in post-order.
     *
     * @return An iterator for post-order traversal.
     */
    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator<E>(root);
    }
}
