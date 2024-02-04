package ed_recurso_8210126.App;

import java.util.Map;
import java.util.Set;

public interface WeightGraphADT<T> {

    /**
     * Adiciona um vértice ao grafo.
     * 
     * @param vertex o vértice a ser adicionado
     */
    void addVertex(T vertex);

    /**
     * Adiciona uma aresta ponderada entre dois vértices do grafo.
     * 
     * @param source      o vértice de origem
     * @param destination o vértice de destino
     * @param weight      o peso da aresta
     */
    void addEdge(T source, T destination, int weight);

    /**
     * Obtém o conjunto de vértices no grafo.
     * 
     * @return conjunto de vértices
     */
    Set<T> getVertices();

    /**
     * Obtém os vizinhos de um vértice no grafo, juntamente com os pesos das arestas.
     * 
     * @param vertex o vértice
     * @return mapa de vizinhos com pesos das arestas
     */
    Map<T, Integer> getNeighbors(T vertex);

    /**
     * Obtém o peso de uma aresta entre dois vértices no grafo.
     * 
     * @param source      o vértice de origem
     * @param destination o vértice de destino
     * @return peso da aresta
     */
    int getWeight(T source, T destination);
}
