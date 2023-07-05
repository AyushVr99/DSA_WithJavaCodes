import java.util.ArrayList;

public class TarjansAlgo {
    static class Edge{
        int src;
        int des;

        public Edge(int s, int d)
        {
            this.src=s;
            this.des=d;
        }
    }
    static void createGraph(ArrayList<ArrayList<Edge>> graph, int V)
    {
        for (int i = 0; i < V; i++)
        {
            graph.add(new ArrayList<Edge>());
        }
        graph.get(0).add(new Edge(0,1));
        graph.get(0).add(new Edge(0,2));
        graph.get(0).add(new Edge(0,3));

        graph.get(1).add(new Edge(1,2));
        graph.get(1).add(new Edge(1,0));

        graph.get(2).add(new Edge(2,0));
        graph.get(2).add(new Edge(2,1));

        graph.get(3).add(new Edge(3,0));
        graph.get(3).add(new Edge(3,4));

        graph.get(4).add(new Edge(4,3));

    }

    static void getAp(ArrayList<ArrayList<Edge>> graph, int V)
    {
        int[] dt = new int[V];
        int[] lowdt = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                dfs(graph,vis,dt,lowdt,i,-1,0,ap);
            }
        }
        for (int i = 0; i < V; i++)
        {
            if (ap[i])
            {
                System.out.println("Articulation Point: "+ i);
            }
        }
    }
    static void dfs(ArrayList<ArrayList<Edge>> graph, boolean[] vis, int[] dt, int[] lowdt, int curr, int parent, int time,boolean[] ap)
    {
        vis[curr]=true;
        dt[curr]=lowdt[curr]=++time;
        int chldren=0;
        for (int i = 0; i < graph.get(curr).size(); i++)
        {
            Edge e = graph.get(curr).get(i);
            if (!vis[e.des])
            {
                dfs(graph,vis,dt,lowdt,e.des,curr,time,ap);
                lowdt[curr] = Math.min(lowdt[curr],lowdt[e.des]);

                if (dt[curr] <= lowdt[e.des] && parent != -1)
                {
                    ap[curr] = true;
                }
                chldren++;
            }
            else if(vis[e.des] && parent != e.des)
            {
                lowdt[curr] = Math.min(lowdt[curr],dt[e.des]);
            }
        }
        if (parent == -1 && chldren>=2)
        {
            ap[curr]=true;
        }
    }


    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
        createGraph(graph,V);
        getAp(graph,V);
    }
}
