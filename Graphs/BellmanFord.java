package com.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

//This algorithm is used to find shortest distance. It does not work with negative weight cycles
//Time complexity: O(V*E)
public class BellmanFord {
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
    static void createGraph(ArrayList<ArrayList<Edge>> graph, int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Edge>());
        }
        graph.get(0).add(new Edge(0,1,2));
        graph.get(0).add(new Edge(0,2,4));

        graph.get(1).add(new Edge(1,2,-4));

        graph.get(2).add(new Edge(2,3,2));

        graph.get(3).add(new Edge(3,4,4));

        graph.get(4).add(new Edge(4,1,-1));
    }

    static void bellford(ArrayList<ArrayList<Edge>> graph,int[] dist, int V, int start)
    {
        for (int i = 0; i < V-1; i++)
        {
            for (int j = 0; j < graph.size(); j++) {
                for (int k = 0; k < graph.get(j).size(); k++)
                {
                    Edge e = graph.get(j).get(k);
                    if (dist[e.source]!= Integer.MAX_VALUE && dist[e.source]+ e.wt < dist[e.des])
                    {
                        dist[e.des] = dist[e.source]+ e.wt;
                    }
                }
            }
        }
        //for detecting the negative cycle
        //change the weight of edges so that it forms a negtive weight cycle to below line of codes working
        for (int j = 0; j < graph.size(); j++) {
            for (int k = 0; k < graph.get(j).size(); k++)
            {
                Edge e = graph.get(j).get(k);
                if (dist[e.source]!= Integer.MAX_VALUE  && dist[e.source]+ e.wt < dist[e.des])
                {
                    System.out.println("Negative weight cycle is present");
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
        createGraph(graph,V);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
        {
            if (i!=0)
            {
                dist[i]=Integer.MAX_VALUE;
            }
        }
        bellford(graph,dist,V,0);
        System.out.println(Arrays.toString(dist));
    }
}
