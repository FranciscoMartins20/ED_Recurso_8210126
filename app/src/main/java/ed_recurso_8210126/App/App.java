/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ed_recurso_8210126.App;

import ed_recurso_8210126.API.Maps.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
    // Exemplo de uso da classe GameMap
    GameMap captureTheFlagMap = new GameMap();

    // Cria automaticamente um mapa de Capture the Flag com 5 localizações e densidade de arestas 0.5
    captureTheFlagMap.createCaptureTheFlagMap(5, 0.5);

    // Exibe o mapa gerado
    System.out.println("\nMapa Gerado:\n" + captureTheFlagMap.toString());
}

}
