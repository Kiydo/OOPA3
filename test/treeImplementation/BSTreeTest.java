package treeImplementation;

// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import utilities.BSTreeADT;
import utilities.Iterator;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;

/**
 * Test cases for the Binary Search Tree implementation (BSTree).
 */
public class BSTreeTest {

    private BSTree<Integer> bst;

    /**
     * Sets up a new Binary Search Tree before each test.
     */
    @BeforeEach
    public void setUp() {
        bst = new BSTree<>();
    }

    /**
     * Tests the retrieval of the root node in the Binary Search Tree.
     * Verifies if the root node is appropriately retrieved or set to null.
     * Additionally, checks if the root node's data matches the expected value.
     */
    @Test
    public void testGetRoot() {
       assertNull(bst.getRoot());

        bst.add(10);
        assertEquals(10, bst.getRoot().getData().intValue());
        assertNotNull(bst.getRoot());
    }


    /**
     * Tests the calculation of the height of the Binary Search Tree.
     * Verifies if the height is correctly computed when nodes are added at different levels.
     */
    @Test
    public void testGetHeight() {
        assertEquals(0, bst.getHeight());

        bst.add(10);
        assertEquals(1, bst.getHeight());

        bst.add(5);
        bst.add(15);
        assertEquals(2, bst.getHeight());
    }

    /**
     * Tests the calculation of the size of the Binary Search Tree.
     * Verifies if the size is correctly computed when nodes are added.
     */
    @Test
    public void testSize() {
        assertEquals(0, bst.size());

        bst.add(10);
        assertEquals(1, bst.size());

        bst.add(5);
        bst.add(15);
        assertEquals(3, bst.size());
    }

    /**
     * Tests the isEmpty method of the Binary Search Tree.
     * Verifies if the method returns true when the tree is empty and false otherwise.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(bst.isEmpty());

        bst.add(10);
        assertFalse(bst.isEmpty());
    }

    /**
     * Tests the clear method of the Binary Search Tree.
     * Verifies if the method clears the tree and sets the root node to null.
     */
    @Test
    public void testClear() {
        bst.add(10);
        assertFalse(bst.isEmpty());

        bst.clear();
        assertTrue(bst.isEmpty());
    }

    /**
     * Tests the contains method of the Binary Search Tree.
     * Verifies if the method returns true when the tree contains the element and false otherwise.
     */
    @Test
    public void testContains() {
        assertFalse(bst.contains(10));

        bst.add(10);
        assertTrue(bst.contains(10));

        bst.add(5);
        assertFalse(bst.contains(15));
    }

    /**
     * Tests the add method of the Binary Search Tree.
     * Verifies if the method adds the element to the tree and increments the size.
     */
    @Test
    public void testAdd() {
        assertTrue(bst.isEmpty());

        bst.add(10);
        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());
    }

    /**
     * Tests the search method of the Binary Search Tree.
     * Verifies if the method returns the node with the element and null otherwise.
     */
    @Test
    public void testSearch() {
        assertNull(bst.search(10));

        bst.add(10);
        assertNotNull(bst.search(10));

        bst.add(5);
        assertNull(bst.search(15));
    }

    /**
     * Tests the removeMin method of the Binary Search Tree.
     * Verifies if the method removes the element from the tree and decrements the size.
     */
    @Test
    public void testRemoveMin() {
        assertNull(bst.removeMin());

        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertNotNull(bst.removeMin());
        assertEquals(2, bst.size());
    }

    /**
     * Tests the removeMax method of the Binary Search Tree.
     * Verifies if the method removes the element from the tree and decrements the size.
     */
    @Test
    public void testRemoveMax() {
        assertNull(bst.removeMax());

        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertNotNull(bst.removeMax());
        assertEquals(2, bst.size());
    }


    /**
     * Tests the functionality of the InorderIterator in the Binary Search Tree.
     * Verifies if the iterator correctly traverses elements in ascending order.
     */
    @Test
    public void testInorderIterator() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        Iterator<Integer> iterator = bst.inorderIterator();
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(15), iterator.next());
    }

    /**
     * Tests the functionality of the PreorderIterator in the Binary Search Tree.
     * Verifies if the iterator correctly traverses elements in pre-order traversal.
     */
    @Test
    public void testPreorderIterator() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        Iterator<Integer> iterator = bst.preorderIterator();
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(15), iterator.next());
    }

    /**
     * Tests the functionality of the PostorderIterator in the Binary Search Tree.
     * Verifies if the iterator correctly traverses elements in post-order traversal.
     */

    @Test
    public void testPostorderIterator() {
        bst.add(10);
    bst.add(5);
    bst.add(15);

    Iterator<Integer> iterator = bst.postorderIterator();

    // Print the post-order traversal for debugging purposes
    // ((PostOrderIterator<Integer>) iterator).printTraversal();

    // Now, assert the values
    assertTrue(iterator.hasNext());
    assertEquals(Integer.valueOf(5), iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(Integer.valueOf(15), iterator.next());

    assertTrue(iterator.hasNext());
    assertEquals(Integer.valueOf(10), iterator.next());

    // Ensure that there are no more elements
    assertFalse(iterator.hasNext());
    assertThrows(NoSuchElementException.class, iterator::next);


        // bst.printTree();
        // PostOrderIterator<Integer> iterator = new PostOrderIterator<>(bst.getRoot());
        // iterator.printTraversal();

        // bst.printTree();    
        // Iterator<Integer> iterator = bst.postorderIterator();
        // assertEquals(Integer.valueOf(10), iterator.next());
        // assertEquals(Integer.valueOf(5), iterator.next());
        // assertEquals(Integer.valueOf(15), iterator.next());
    }

}