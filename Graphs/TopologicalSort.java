package com.Graphs;

import java.util.ArrayList;
import java.util.Stack;

//Topological sort is used for Directed Acyclic Graphs (DAGs)
public class TopologicalSort {
    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        boolean[] vis = new boolean[V];
        createGraph(graph,V);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                topoSort(graph,vis,i,st);
            }
        }

        while (!st.isEmpty())
        {
            System.out.print(st.pop() + " ");
        }
    }
    static void topoSort(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr,Stack<Integer> st)
    {
        vis[curr]=true;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (!vis[des])
            {
                topoSort(graph,vis,des,st);
            }
        }
        st.add(curr);
    }
    static void createGraph(ArrayList<ArrayList<Integer>> graph, int V) {
        //adding empty arraylist list inside graph
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(5).add(0);
        graph.get(5).add(2);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);
        graph.get(3).add(1);

    }
}
