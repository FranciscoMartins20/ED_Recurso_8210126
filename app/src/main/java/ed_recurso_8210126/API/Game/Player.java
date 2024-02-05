package ed_recurso_8210126.API.Game;

public class Player {
    private String nome;
    private int bots;
    private Flag flag;

    public Player(String nome, int bots, Flag flag) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo!");
        }

        this.nome = nome;
        this.bots = bots;
        this.flag = flag;
    }

    public int getNumeroBots() {
        return bots;
    }

    public void setNumeroBots(int bots) {
        this.bots = bots;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setBandeira(Flag flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nome='" + nome + '\'' +
                ", bots=" + bots +
                ", bandeira=" + flag +
                '}';
    }
}
