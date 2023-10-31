package com.Rough;
import java.util.*;

public class UnionFind {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public UnionFind(int len)
    {
        for (int i = 0; i <= len; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    int findParent(int node)
    {
        if (node == parent.get(node))
        {
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    void unionbyrank(int u , int v)
    {
        int top_u = findParent(u);
        int top_v = findParent(v);
        if (top_v==top_u) return;
        if (rank.get(top_u) < rank.get(top_v))
        {
            parent.set(top_u,top_v);
        }
        else if (rank.get(top_u) > rank.get(top_v))
        {
            parent.set(top_v,top_u);
        }
        else
        {
            parent.set(top_v,top_u);
            int rankofu = rank.get(top_u);
            rank.set(top_u,rankofu+1);
        }
    }

    void unionbysize(int u, int v)
    {
        int top_u = findParent(u);
        int top_v = findParent(v);
        if (top_u==top_v) return;
        if (size.get(top_u) < size.get(top_v))
        {
            parent.set(top_u,top_v);
            size.set(top_v,size.get(top_v)+size.get(top_u));
        }
        else
        {
            parent.set(top_v,top_u);
            size.set(top_u,size.get(top_u)+size.get(top_v));
        }
    }

    public static void main(String[] args) {
        UnionFind obj = new UnionFind(8);
        obj.unionbysize(1,2);
        obj.unionbysize(2,3);
        obj.unionbysize(4,5);
        obj.unionbysize(6,7);
        obj.unionbysize(5,6);

        if (obj.findParent(3) == obj.findParent(7))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("NO");
        }
        obj.unionbysize(3,7);
        if (obj.findParent(3) == obj.findParent(7))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
