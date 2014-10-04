JTree
=====

This is a simple Tree implementation for a generic tree. You can implement your
own node for the Tree. 

If you implement your own node you must override the
equals, hashCode and toString methods in order to work correctly with the Tree.

The Tree has the following functionality :
- add a Node
- find a Node
- delete a Node (if you delete a node all sub-nodes will be deleted as well)
- size
- clear (empty tree) 

Classes :
- Tree 
  The Tree class is the implementation of the tree
- Property
  The Property class can be used as a Node for the Tree

examples of Tree

Tree<String> tree = new Tree<String>() create a simple string Tree

Tree<Property> tree = new Tree<Property>() create a tree with a Property as node

If you have any suggestions please contact me at : johanj.denboer@gmail.com

Regards

Johan




