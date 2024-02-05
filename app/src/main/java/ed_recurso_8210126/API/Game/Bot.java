package ed_recurso_8210126.API.Game;

import java.util.Random;

public class Bot implements Comparable<Bot> {

    private String nome;
    private int id;
    private Player player;

    public Bot(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.player = null; // O bot começa sem associação a um player
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void mover() {
        if (player != null) {
            // Aqui você pode implementar o algoritmo de movimentação
            // Exemplo simples: mover para uma posição aleatória
            Random random = new Random();
            int novaX = random.nextInt(100); // Substitua 100 pelo limite superior da posição X
            int novaY = random.nextInt(100); // Substitua 100 pelo limite superior da posição Y

            System.out.println("Bot " + nome + " moveu para: (" + novaX + ", " + novaY + ")");
        } else {
            System.out.println("Bot " + nome + " não está associado a nenhum jogador. Não pode se mover.");
        }
    }

    @Override
    public String toString() {
        return "Bot{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", player=" + (player != null ? player.getNome() : "Nenhum") +
                '}';
    }

    @Override
    public int compareTo(Bot o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
