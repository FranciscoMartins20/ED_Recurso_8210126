package ed_recurso_8210126.API.Maps;

import java.util.Random;

import ed_recurso_8210126.API.Game.Location;
import ed_recurso_8210126.API.StructureData.ArrayList;
import ed_recurso_8210126.API.StructureData.ArrayUnorderedList;
import ed_recurso_8210126.API.StructureData.Network;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class GameMap extends Network<Object> {

    private ArrayUnorderedList<Location> locations;

        public GameMap() {
        this.locations = new ArrayUnorderedList<>();
    }

    


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

        for (int i = 0; i < numLocations; i++) {
            addVertex();
            // Cria uma nova instância de Location e adiciona à lista
            Location location = new Location("Location " + (i + 1)); // Substitua com a lógica de nomenclatura desejada
            locations.addToRear(location);
        }
    
        // Adiciona vértices representando as localizações
        for (int i = 0; i < numLocations; i++) {
            addVertex();
        }
    
        // Adiciona arestas com base na densidade especificada e pesos aleatórios
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (random.nextDouble() < edgeDensity) {
                    // Gera um peso aleatório entre 1 e 15 (como mencionado nas suas instruções)
                    int pesoAresta = random.nextInt(15) + 1;
                    addEdge(i, j, pesoAresta);
                    if (bidirectionalPaths) {
                        addEdge(j, i, pesoAresta);
                    }
                }
            }
        }
    }

    /******************************************************************
     Exporta o mapa para um arquivo CSV.
    ******************************************************************/
    public void exportMapToCsv(String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    writer.write(adjMatrix[i][j] + ",");
                }
                writer.write("\n");
            }
            System.out.println("Mapa exportado com sucesso em formato CSV!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar o mapa para CSV: " + e.getMessage());
        }
    }

    

    /******************************************************************
     Limpa o grafo, removendo todos os vértices e arestas.
    ******************************************************************/
    public void clear() {
        numVertices = 0;
        adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = new Object[DEFAULT_CAPACITY];
    }
}

