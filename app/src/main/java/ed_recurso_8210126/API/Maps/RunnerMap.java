

package ed_recurso_8210126.API.Maps;

public class RunnerMap {

    public static void main(String[] args) {
        // Exemplo de uso da classe GameMap
        GameMap captureTheFlagMap = new GameMap();

        // Cria automaticamente um mapa de Capture the Flag com 8 localizações e densidade de arestas 0.4
        captureTheFlagMap.createCaptureTheFlagMap(8, 0.4);

        // Exibe o mapa gerado
        System.out.println("\nMapa Gerado:\n" + captureTheFlagMap.toString());
    }
}

