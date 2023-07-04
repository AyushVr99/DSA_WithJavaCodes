package com.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//Time complexity: With number of vertices V and number of edes E
//             TC: O(E+ElogV)
public class DijkshtraAlgo {
    static class Edge
    {
        int source;
        int des;
        int wt;
        public Edge(int s, int d, int w)
        {
            this.source=s;
            this.des=d;
            this.wt=w;
        }
    }
    static class Pair implements Comparable<Pair>
    {
        int dis;
        int node;
        public Pair(int d, int n)
        {
            this.dis=d;
            this.node=n;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.dis-p2.dis;
        }
    }
    static void createGraph(ArrayList<ArrayList<Edge>> graph, int V)
    {
        //draw the graph on paper and dry run
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Edge>());
        }
        graph.get(0).add(new Edge(0,1,2));
        graph.get(0).add(new Edge(0,2,4));

        graph.get(1).add(new Edge(1,2,1));
        graph.get(1).add(new Edge(1,3,7));

        graph.get(2).add(new Edge(2,4,3));

        graph.get(3).add(new Edge(3,5,1));

        graph.get(4).add(new Edge(4,3,2));
        graph.get(4).add(new Edge(4,5,5));
    }
    static void dijkshtra(ArrayList<ArrayList<Edge>> graph, boolean[] vis, int[] dist)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if (!vis[curr.node])
            {
                vis[curr.node]=true;
                for (int i = 0; i < graph.get(curr.node).size(); i++)
                {
                    Edge e = graph.get(curr.node).get(i);

                    if (dist[e.source] + e.wt < dist[e.des])
                    {
                        dist[e.des] = dist[e.source] + e.wt;
                        pq.add(new Pair(dist[e.des],e.des));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i!=0)
            {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        createGraph(graph,V);
        dijkshtra(graph,vis,dist);

        System.out.println(Arrays.toString(dist));
    }
}
