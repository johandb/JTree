package com.jdbsoftware.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to hold a generic tree structure.
 *
 * @author Johan
 * 
 * @param <T>
 */
public class Tree<T> {

    private List<Tree<T>> children = null;
    private Tree<T> parent;
    private T data;

    /**
     * Construct a Tree with default root name '/'
     */
    public Tree() {
        this(null, null);
    }

    /**
     * Constructs a Tree
     *
     * @param data
     */
    public Tree(T data) {
        this(data, null);
    }

    private Tree(T data, Tree<T> parent) {
        this.data = data;
        this.parent = parent;
        this.children = new LinkedList<>();
    }

    /**
     * Add a Node to the Tree
     *
     * @param data
     * @param parent
     * @return tree - The new inserted Tree or null
     */
    public Tree<T> add(T data, Tree<T> parent) {
        Tree<T> tree = new Tree<T>(data, parent);
        if (parent != null) {
            parent.children.add(tree);
        }
        return tree;
    }

    /**
     * Add a Node to this Tree
     *
     * @param data
     * @return tree - The new inserted Tree or null
     */
    public Tree<T> add(T data) {
        Tree<T> tree = new Tree<T>(data, this);
        this.children.add(tree);
        return tree;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    /**
     * Is Tree empty
     *
     * @return true - Tree is empty, else false
     */
    public boolean isEmpty() {
        return !(getChildren().size() > 0);
    }
    
    /**
     * Return the size of the tree
     * 
     * @return
     * 		- size of tree
     */
    public int getSize() {
    	return getChildren().size();
    }

    /**
     * Clear a Tree
     */
    public void clear() {
        children.clear();
        this.parent = null;
        this.data = null;
    }

    /**
     * Find a tree node by node value
     *
     * @param data
     * @return null - not found tree - Tree
     */
    public Tree<T> find(T data) {
        for (Tree<T> tree : this.getChildren()) {
            if (tree.getChildren() != null) {
                Tree<T> node = tree.find(data);
                if (node != null) {
                    return node;
                }
            }
            if (tree.data.equals(data)) {
                return tree;
            }
        }
        return null;
    }

    /**
     * Delete a node from Tree
     *
     * @param data
     * @return true - Node deleted else false
     */
    public boolean delete(T data) {
        Tree<T> node = find(data);
        if (node == null) {
            return false;
        }
        node.parent.children.remove(node);
        return true;
    }

    /**
     * Build Tree as String
     *
     * @return String containing tree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (data != null) {
            sb.append(data.toString()).append("\n");
        } else { 
            if(parent == null) {
                sb.append("/\n");
            }
        }
        for (Tree<T> tree : this.getChildren()) {
            if (tree.getChildren() != null) {
                // Indent child nodes
                Tree<T> node = tree;
                while(node.parent != null) {
                    sb.append("  ");
                    node = node.parent;
                }
                sb.append(tree.toString());
            }
        }
        return sb.toString();
    }
}
