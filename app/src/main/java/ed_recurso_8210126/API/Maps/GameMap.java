package ed_recurso_8210126.API.Maps;

import java.util.Random;

import ed_recurso_8210126.API.StructureData.Network;

public class GameMap extends Network<String> {
    
    /******************************************************************
     Cria automaticamente o mapa de Capture the Flag.
    ******************************************************************/
    public void createCaptureTheFlagMap(int numLocations, double edgeDensity) {
        // Verifica se os parâmetros são válidos
        if (numLocations <= 0 || edgeDensity < 0 || edgeDensity > 1) {
            System.out.println("Parâmetros inválidos para a criação do mapa.");
            return;
        }

        // Gera o mapa utilizando o método da classe Network
        generateMap(numLocations, true, edgeDensity);

        // Adiciona lógica adicional específica para Capture the Flag, se necessário
        // Por exemplo, adicionar bases, bandeiras, etc.
        // ...

        System.out.println("Mapa de Capture the Flag criado com sucesso!");
    }

    /******************************************************************
     Gera um mapa de acordo com as características definidas no enunciado.
    ******************************************************************/
    public void generateMap(int numLocations, boolean bidirectionalPaths, double edgeDensity) {
        // Verifica se os parâmetros são válidos
        if (numLocations <= 0 || edgeDensity < 0 || edgeDensity > 1) {
            System.out.println("Parâmetros inválidos para a geração do mapa.");
            return;
        }

        // Limpa o grafo existente
        clear();

        // Adiciona vértices representando as localizações
        for (int i = 0; i < numLocations; i++) {
            addVertex();
        }

        // Adiciona arestas com base na densidade especificada
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (random.nextDouble() < edgeDensity) {
                    addEdge(i, j, 1);  // Peso da aresta (distância) definido como 1 para simplificar
                    if (bidirectionalPaths) {
                        addEdge(j, i, 1);
                    }
                }
            }
        }
    }

    /******************************************************************
     Limpa o grafo, removendo todos os vértices e arestas.
    ******************************************************************/
    public void clear() {
        numVertices = 0;
        adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (String[])(new Object[DEFAULT_CAPACITY]);
    }
}
