package com.Graphs;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.PriorityQueue;

//TC: O(E(logV))
public class PrimsAlgo {
    static class Edge{
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
        int node;
        int cost;
        public Pair(int n, int c)
        {
            this.node=n;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.cost - p2.cost;
        }
    }
    static void createGraph(ArrayList<ArrayList<Edge>> graph , int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Edge>());
        }
        graph.get(0).add(new Edge(0,1,10));
        graph.get(0).add(new Edge(0,2,15));
        graph.get(0).add(new Edge(0,3,30));

        graph.get(1).add(new Edge(1,0,10));
        graph.get(1).add(new Edge(1,3,40));

        graph.get(2).add(new Edge(2,0,15));
        graph.get(2).add(new Edge(2,3,50));

        graph.get(3).add(new Edge(3,1,40));
        graph.get(3).add(new Edge(3,0,30));
        graph.get(3).add(new Edge(3,2,50));
    }
    static int prims(ArrayList<ArrayList<Edge>> graph , int V,ArrayList<Integer> costList)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        boolean[] vis = new boolean[V];
        int cost = 0;
        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if (!vis[curr.node])
            {
                vis[curr.node]=true;
                cost += curr.cost;
                costList.add(curr.cost);
                for (int i = 0; i < graph.get(curr.node).size(); i++)
                {
                    Edge e = graph.get(curr.node).get(i);
                    if (!vis[e.des])
                    {
                        pq.add(new Pair(e.des,e.wt));
                    }
                }
            }

        }
        return cost;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
        createGraph(graph,V);
        ArrayList<Integer> costList = new ArrayList<>();
        System.out.println("Minimum cost is: " + (prims(graph,V,costList)));
        System.out.println(costList);
    }
}
