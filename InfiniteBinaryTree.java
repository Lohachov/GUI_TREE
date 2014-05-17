import javax.swing.*;
import javax.swing.tree.*; 

public class InfiniteBinaryTree implements TreeModel {
    public Object getRoot()  {
        return new Integer(1); 
    }
    public int getChildCount(Object parent)  { 
        return 2; 
    }
    public Object getChild(Object parent, int index) {
        return new Integer(2 * valueOf(parent) + index); // the magic formula
    }
    public int getIndexOfChild(Object parent, Object child) {
        return valueOf(child) % 2;
    }
    public boolean isLeaf(Object node) {       return false;
    }
    public void addTreeModelListener(javax.swing.event.TreeModelListener l) {}
    public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {}
    public void valueForPathChanged(TreePath path, Object newValue) {}
    private int valueOf(Object obj)  {
        return ((Integer)obj).intValue();
    }  
    public static void main(String args[])  {
        JTree binTree = new JTree(new InfiniteBinaryTree());
        binTree.setShowsRootHandles(true);
        JFrame frame = new JFrame("Бінарне дерево");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(binTree));
        frame.setSize(new java.awt.Dimension(400, 400));
        frame.setVisible(true);
    }
}