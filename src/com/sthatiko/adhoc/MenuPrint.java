package com.sthatiko.adhoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MenuPrint {

    static class NaryTreeNode{
        String name;
        List<NaryTreeNode> children;
        public NaryTreeNode(String name){
            this.name = name;
            this.children = new ArrayList<>();
        }

        public NaryTreeNode addChild(NaryTreeNode child){
            this.children.add(child);
            return this;
        }
    }
    public static void main(String[] args) {
        NaryTreeNode root = new NaryTreeNode("Menu");
        NaryTreeNode node1 = new NaryTreeNode("Veg");
        NaryTreeNode node1c1 = new NaryTreeNode("Paneer");
        NaryTreeNode node1c1c1 = new NaryTreeNode("Manchurian");
        node1c1.addChild(node1c1c1);
        NaryTreeNode node1c2 = new NaryTreeNode("Rice");
        node1.addChild(node1c1).addChild(node1c2);
        NaryTreeNode node2 = new NaryTreeNode("Non Veg");
        NaryTreeNode node3 = new NaryTreeNode("Ice Creams");
        root.addChild(node1).addChild(node2).addChild(node3);
        dfs(root,"");

    }

    public static void dfs(NaryTreeNode root, String spaces){
        if(root == null) return;
        System.out.println(spaces+root.name);
        for(NaryTreeNode node: root.children){
            dfs(node,spaces+"  ");
        }
    }
}
