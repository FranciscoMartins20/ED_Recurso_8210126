package ed_recurso_8210126.App;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Interface<T> extends JFrame {

    private WeightGraphADT<T> graph;

    public Interface(WeightGraphADT<T> graph) {
        this.graph = graph;

        setTitle("Graph GUI");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        GraphPanel graphPanel = new GraphPanel();
        mainPanel.add(graphPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private class GraphPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawGraph(g);
        }

        private void drawGraph(Graphics g) {
            Map<T, Integer> vertexPositions = calculateVertexPositions();
            Set<T> vertices = graph.getVertices();

            for (T vertex : vertices) {
                int x = vertexPositions.get(vertex);
                int y = 50; // You can adjust the y-coordinate as needed
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 30, 30); // Draw a circle for each vertex

                g.setColor(Color.BLACK);
                g.drawString(vertex.toString(), x + 10, y + 20); // Display vertex label
            }

            for (T source : vertices) {
                Map<T, Integer> neighbors = graph.getNeighbors(source);
                int x1 = vertexPositions.get(source);

                for (Map.Entry<T, Integer> entry : neighbors.entrySet()) {
                    T destination = entry.getKey();
                    int x2 = vertexPositions.get(destination);

                    int weight = entry.getValue();
                    drawEdge(g, x1, x2, weight);
                }
            }
        }

        private Map<T, Integer> calculateVertexPositions() {
            // You can implement a logic to calculate x-coordinates based on the number of vertices
            // For simplicity, let's assume vertices are evenly spaced
            Map<T, Integer> vertexPositions = new HashMap<>();
            Set<T> vertices = graph.getVertices();

            int x = 50;
            for (T vertex : vertices) {
                vertexPositions.put(vertex, x);
                x += 50; // Adjust this value based on your needs
            }

            return vertexPositions;
        }

        private void drawEdge(Graphics g, int x1, int x2, int weight) {
            g.setColor(Color.RED);
            g.drawLine(x1 + 15, 80, x2 + 15, 80); // Draw a line between vertices

            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(weight), (x1 + x2) / 2, 80); // Display edge weight
        }
    }

    public static void main(String[] args) {
        WeightGraphADT<String> graph = new WeightGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 8);

        SwingUtilities.invokeLater(() -> {
            Interface<String> graphGUI = new Interface<>(graph);
            graphGUI.setVisible(true);
        });
    }
}

