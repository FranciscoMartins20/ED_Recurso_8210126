package ed_recurso_8210126.API.StructureData;
import ed_recurso_8210126.API.ADTs.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightGraph<T> implements WeightGraphADT<T> {
    private Map<T, Map<T, Integer>> adjacencyMap;

    public WeightGraph() {
        this.adjacencyMap = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    @Override
    public void addEdge(T source, T destination, int weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyMap.get(source).put(destination, weight);
        adjacencyMap.get(destination).put(source, weight);
    }

    @Override
    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

    @Override
    public Map<T, Integer> getNeighbors(T vertex) {
        return adjacencyMap.get(vertex);
    }

    @Override
    public int getWeight(T source, T destination) {
        return adjacencyMap.get(source).get(destination);
    }
}
