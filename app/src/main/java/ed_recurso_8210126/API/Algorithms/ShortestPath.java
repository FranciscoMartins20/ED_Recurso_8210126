package ed_recurso_8210126.API.Algorithms;

import java.util.*;

public class ShortestPath implements MovementAlgorithm {
    private int[][] graph;
    private int numVertices;
    private MovementAlgorithm movementAlgorithm;

    public ShortestPath(int numVertices, MovementAlgorithm movementAlgorithm) {
        this.numVertices = numVertices;
        this.graph = new int[numVertices][numVertices];
        this.movementAlgorithm = movementAlgorithm;
    }

    public void addEdge(int source, int destination, int weight) {
        graph[source][destination] = weight;
        graph[destination][source] = weight;
    }

    public List<Integer> dijkstra(int source, int destination) {
        int[] distance = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] parent = new int[numVertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distance[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] > 0 && !visited[v] && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    parent[v] = u;
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        return buildPath(parent, destination);
    }

    private List<Integer> buildPath(int[] parent, int destination) {
        List<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);
        return path;
    }

    @Override
    public void move() {
        // Aqui você pode chamar a lógica de movimento específica que deseja usar.
        movementAlgorithm.move();
    }

    private static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
