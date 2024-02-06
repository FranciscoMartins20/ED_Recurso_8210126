package ed_recurso_8210126.API.Algorithms;

import java.util.*;

public class MinimumCost implements MovementAlgorithm {
    @Override
    public void move() {
        // Método move() não precisa ser modificado para esta implementação
    }

    public List<Integer> minimumCostMovement(int[][] graph) {
        int n = graph.length;
        List<Integer> movement = new ArrayList<>();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Iniciar a partir do vértice 0
        pq.offer(new Edge(0, -1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.to])
                continue;
            visited[edge.to] = true;
            movement.add(edge.to);

            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[edge.to][i] != 0) {
                    pq.offer(new Edge(i, edge.to, graph[edge.to][i]));
                }
            }
        }

        return movement;
    }

    // Classe auxiliar para representar uma aresta com peso
    static class Edge implements Comparable<Edge> {
        int to, from, weight;

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
