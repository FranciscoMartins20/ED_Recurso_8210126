package ed_recurso_8210126.API.Game;

public class Bot implements Comparable<Bot> {

    private String nome;
    private int id;
    private Player player;

    public Bot(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.player = null; 
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
        // Implemente a lógica de comparação adequada para os seus bots
        // Por exemplo, compare com base no ID ou em outra propriedade relevante
        return Integer.compare(this.id, o.id);
    }
}
