package ed_recurso_8210126.API.Demo;

import ed_recurso_8210126.API.Game.Flag;
import ed_recurso_8210126.API.Game.Location;
import ed_recurso_8210126.API.Game.Player;
import ed_recurso_8210126.API.Game.Bot;
import ed_recurso_8210126.API.Maps.GameMap;

public class Jogo {

    private GameMap gameMap;
    private Player jogador1;
    private Player jogador2;

    public Jogo() {
        this.gameMap = new GameMap();
        this.gameMap.generateMap(10,true,1.0);

        // Crie instâncias de Flag e Location conforme necessário
        Flag flagJogador1 = new Flag("BandeiraJogador1");
        Location baseLocationJogador1 = new Location("BaseJogador1");
        this.jogador1 = new Player("Jogador1", 0, flagJogador1, baseLocationJogador1);

        Flag flagJogador2 = new Flag("BandeiraJogador2");
        Location baseLocationJogador2 = new Location("BaseJogador2");
        this.jogador2 = new Player("Jogador2", 0, flagJogador2, baseLocationJogador2);
    }

    public void iniciarJogo() {
        mostrarMapa();
        mostrarInfoJogadores();

        jogar();
    }


    private void mostrarMapa() {
        System.out.println("Mapa:");
        gameMap.exportMapToCsv("mapa.csv"); // Exporta o mapa para um arquivo CSV (altere conforme necessário)
    }

    private void mostrarInfoJogadores() {
        System.out.println("Informações dos Jogadores:");
        System.out.println(jogador1);
        System.out.println(jogador2);
    }

    private void jogar() {
        // Adicione a lógica principal do jogo aqui
        // Isso pode incluir movimento de bots, captura de bandeiras, etc.
        // Use os métodos da classe GameMap e outras classes conforme necessário
        // Lembre-se de atualizar a lógica do jogo de acordo com os requisitos específicos
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}
