package com.Graphs;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {
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

        //list to store all possible answers
        List<String> list = new ArrayList<>(V);

        PrintPaths(graph,vis,"0", list,0,5);

        for (String st : list)
        {
            System.out.println(st);
        }
    }
    static void PrintPaths(ArrayList<ArrayList<Integer>> graph,boolean[] vis, String ans,List<String> list, int curr, int last)
    {
        if (curr==last)
        {
            list.add(ans);
            return;
        }

        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            int des = graph.get(curr).get(i);
            if (!vis[des])
            {
                vis[curr]=true;
                PrintPaths(graph,vis,ans+des,list,des,last);
                vis[curr]=false;
            }
        }
    }
    static void createGraph(ArrayList<ArrayList<Integer>> graph, int V)
    {
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
