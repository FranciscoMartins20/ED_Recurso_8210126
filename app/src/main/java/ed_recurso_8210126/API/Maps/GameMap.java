package ed_recurso_8210126.API.Maps;

import ed_recurso_8210126.API.StructureData.WeightGraph;
import ed_recurso_8210126.App.Interface;

import javax.swing.*;

import java.util.Random;

public class GameMap<T> extends WeightGraph<T> {

    private final int MIN_DISTANCE = 1;
    private final int MAX_DISTANCE = 15;

    public GameMap() {
        super();
    }

    public void generateRandomMap(int numVertices, boolean bidirectional, double density) {

        if (density < 0 || density > 1) {
            throw new IllegalArgumentException("A densidade deve estar no intervalo de 0 a 1.");
        }

        initializeGraph(numVertices);
        double totalEdges = calculateTotalEdges(numVertices, bidirectional, density);
        fillAdjacencyMatrix(numVertices, bidirectional, density, totalEdges);
    }

    private void initializeGraph(int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            addVertex((T) Integer.valueOf(i)); // Assuming vertices are of type Integer
        }
    }

    private double calculateTotalEdges(int numVertices, boolean bidirectional, double density) {
        if (bidirectional) {
            return (numVertices * (numVertices - 1) * density) / 2.0;
        } else {
            return numVertices * (numVertices - 1) * density;
        }
    }

    private void fillAdjacencyMatrix(int numVertices, boolean bidirectional, double density, double totalEdges) {
        Random random = new Random();
        int generatedEdges = 0;
    
        while (generatedEdges < totalEdges) {
            int i = random.nextInt(numVertices);
            int j = random.nextInt(numVertices);
    
            if (i != j && !adjacencyMap.get((T) Integer.valueOf(i)).containsKey((T) Integer.valueOf(j))) {
                int distance = random.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
                addEdge((T) Integer.valueOf(i), (T) Integer.valueOf(j), distance);
    
                if (bidirectional) {
                    addEdge((T) Integer.valueOf(j), (T) Integer.valueOf(i), distance);
                }
    
                generatedEdges++;
            }
        }
    }

    public void generateRandomMapAndDisplay(int numVertices, boolean bidirectional, double density) {
        if (density < 0 || density > 1) {
            throw new IllegalArgumentException("A densidade deve estar no intervalo de 0 a 1.");
        }

        initializeGraph(numVertices);
        double totalEdges = calculateTotalEdges(numVertices, bidirectional, density);
        fillAdjacencyMatrix(numVertices, bidirectional, density, totalEdges);

        SwingUtilities.invokeLater(() -> {
            Interface<T> graphGUI = new Interface<>(this);
            graphGUI.setVisible(true);
        });
    }
    
}
