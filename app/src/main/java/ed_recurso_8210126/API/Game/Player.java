package ed_recurso_8210126.API.Game;

import ed_recurso_8210126.API.StructureData.ArrayOrderedList;

public class Player {
    private String nome;
    private int bots;
    private Flag flag;
    private ArrayOrderedList<Bot> botsList; // Lista ordenada de bots
    private Location baseLocation;

    public Player(String nome, int bots, Flag flag, Location baseLocation) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo!");
        }

        this.nome = nome;
        this.bots = 0;
        this.flag = flag;
        this.botsList = new ArrayOrderedList<>();
        this.baseLocation = baseLocation;
    }

    public Location getBaseLocation() {
        return baseLocation;
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

    public ArrayOrderedList<Bot> getBotsList() {
        return botsList;
    }

    // Método para adicionar um bot à lista ordenada de bots
    public void addBot(Bot bot) {
        botsList.add(bot);
    }


    @Override
    public String toString() {
        return "Player{" +
                "nome='" + nome + '\'' +
                ", bots=" + bots +
                ", bandeira=" + flag +
                ", botsList=" + botsList +
                ", baseLocation=" + baseLocation +
                '}';
    }
}
