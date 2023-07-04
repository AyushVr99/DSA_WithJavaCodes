package com.Graphs;

import com.Data_Structures.Graphs.Kosaraju;

import java.util.ArrayList;
import java.util.Stack;
// TC: O(V+E)
//This algorithm is used to find all the Strongly Connected Components(SCC) in a graph
// There are 3 basic steps to achiever this:
//   i) Get all the nodes of given graph in stack using topological sort
//  ii) Transpose the given graph
// iii) Perfrom the DFS on the stack nodes on the tranposed graph

public class KosarajuAlgo {

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(2);
        graph.get(0).add(3);

        graph.get(1).add(0);

        graph.get(2).add(1);

        graph.get(3).add(4);
    }
    static void kosaraju(ArrayList<ArrayList<Integer>> graph, int V)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        //step 1: Get nodes in stack using topo sort
        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                dfsTopo(graph,i,vis,st);
            }
        }

        //step 2: Tranpose the graph
        ArrayList<ArrayList<Integer>> transGraph = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
        {
            vis[i] = false;
            transGraph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < graph.get(i).size(); j++)
            {
                int des = graph.get(i).get(j);
                transGraph.get(des).add(i);
            }
        }
        //step 3: perform dfs on stack nodes

        while (!st.isEmpty())
        {
            int i = st.pop();
            if (!vis[i])
            {
                dfsOnTransgraph(transGraph,vis,i);
                System.out.println();
            }
        }
    }

    static void dfsOnTransgraph(ArrayList<ArrayList<Integer>> transGraph, boolean[] vis, int curr)
    {
        System.out.print(curr+ " ");
        vis[curr]=true;
        for (int i = 0; i < transGraph.get(curr).size(); i++)
        {
            int des = transGraph.get(curr).get(i);
            if (!vis[des])
            {
                dfsOnTransgraph(transGraph,vis,des);
            }
        }
    }
    static void dfsTopo(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] vis, Stack<Integer> st )
    {
        vis[curr]=true;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (!vis[des])
            {
                dfsTopo(graph,des,vis,st);
            }
        }
        st.add(curr);
    }
    
    public static void main(String[] args) {
        int V =5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createGraph(graph,V);
        kosaraju(graph,V);
    }
}
