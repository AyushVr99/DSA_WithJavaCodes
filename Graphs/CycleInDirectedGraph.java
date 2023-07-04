package com.Graphs;

import com.Data_Structures.Graphs.Cycle;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createGraph(graph,V);
        boolean vis[] = new boolean[V];
        boolean recur[] = new boolean[V];

        boolean CyclePresent=false;
        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                CyclePresent =isCycle(graph,vis,recur,i);
                if (CyclePresent)
                {
                    break;
                }
            }
        }
        if (CyclePresent)
        {
            System.out.println("Cycle is present");
        }else
        {
            System.out.println("No cycle");
        }
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> graph,boolean[] vis, boolean[] recur, int curr)
    {
        vis[curr]=true;
        recur[curr]=true;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (recur[des])
            {
                return true; //cycle is present
            }
            else if (!vis[des])
            {
                if (isCycle(graph,vis,recur,des))
                {
                    return true;
                }
            }
        }
        recur[curr]=false;
        return false;
    }
    static void createGraph(ArrayList<ArrayList<Integer>> graph, int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(2);

        graph.get(1).add(0);

        graph.get(2).add(3);

        graph.get(3).add(0);
    }
}
