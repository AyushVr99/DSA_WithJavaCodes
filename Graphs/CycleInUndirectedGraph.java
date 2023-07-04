package com.Graphs;

import com.Data_Structures.Graphs.CycleUndirected;

import java.util.ArrayList;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        boolean vis[] = new boolean[V];
        creategraph(graph,V);
        boolean CyclePresnt = isCycle(graph,vis,0,-1);
        if (CyclePresnt)
        {
            System.out.println("Cycle is present");
        }else
        {
            System.out.println("No cycle");
        }
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, int parent)
    {
        vis[curr]=true;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (vis[des] && parent!=des)
            {
                return true;
            }
            else if (!vis[des])
            {
                if (isCycle(graph,vis,des,curr))
                {
                    return true;
                }
            }
        }
        return false;
    }
    static void creategraph(ArrayList<ArrayList<Integer>> graph, int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(4);

        graph.get(1).add(0);
        graph.get(1).add(4);
        graph.get(1).add(2);

        graph.get(2).add(3);
        graph.get(2).add(1);

        graph.get(3).add(2);

        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(4).add(5);

        graph.get(5).add(0);
    }
}
