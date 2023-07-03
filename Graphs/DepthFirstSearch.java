package com.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Time complexity: With number of vertices V and number of edes E
//             TC: O(V+E)
public class DepthFirstSearch {

    public static void main(String[] args) {
/*  undirected graph
*             1------3
*           / |      | \
*         0   |      |   5
*           \ |      |  /
*             2------4
* */
        int V =6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        boolean[] vis = new boolean[V];
        createGraph(graph,V);

        //if the graph is disconnected, then the loop will make a call for it
        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                dfs(graph,vis,i);
            }
        }

    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr)
    {
        System.out.print(curr + " ");
        vis[curr]=true;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (!vis[des])
            {
                dfs(graph,vis,des);
            }
        }
    }
    static void createGraph(ArrayList<ArrayList<Integer>> graph, int V)
    {
        //adding empty arraylist list inside graph
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);
    }
}
