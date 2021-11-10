package com.example.mongodbpoc.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    int V;
    List<Integer> adj[];

    public static void dfs() {
    }

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int start) {
        boolean visited[] = new boolean[V];
        DFSUtil(start, visited);

    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void bfs(int start) {
        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            System.out.print(temp + " ");
            List<Integer> adjstment = adj[temp];
            for (Integer num : adjstment) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                }
            }

        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.bfs(2);
        System.out.println();
        g.dfs(2);
    }
}
