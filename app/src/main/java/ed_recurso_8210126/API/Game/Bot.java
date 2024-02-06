package ed_recurso_8210126.API.Game;

import ed_recurso_8210126.API.Algorithms.*;

public class Bot implements Comparable<Bot> {

    private String nome;
    private int id;
    private Player player;
    private MovementAlgorithm movementAlgorithm;

    public Bot(String nome, int id, MovementAlgorithm movementAlgorithm) {
        this.nome = nome;
        this.id = id;
        this.player = null; 
        this.movementAlgorithm = movementAlgorithm;
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

    public MovementAlgorithm getMovementAlgorithm() {
        return movementAlgorithm;
    }

    public void setMovementAlgorithm(MovementAlgorithm movementAlgorithm) {
        this.movementAlgorithm = movementAlgorithm;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", player=" + (player != null ? player.getNome() : "Nenhum") +
                ", movementAlgorithm=" + movementAlgorithm.getClass().getSimpleName() +
                '}';
    }

    @Override
    public int compareTo(Bot o) {
        // Implemente a lógica de comparação adequada para os seus bots
        // Por exemplo, compare com base no ID ou em outra propriedade relevante
        return Integer.compare(this.id, o.id);
    }
}
