package ed_recurso_8210126.API.Game.Interface;

public interface IBot {

    /**
     * Move o bot usando o algoritmo atribuído, evitando colisões com outros bots.
     * 
     * @return O índice para onde foi atribuída a nova posição do bot.
     */
    int move();

    /**
     * Obtém o algoritmo de movimentação do bot.
     *
     * @return O algoritmo de movimentação do bot.
     */


    /**
     * Define o algoritmo de movimentação do bot.
     *
     * @param algorithm O novo algoritmo de movimentação do bot.
     */
    

    /**
     * Obtém o nome do bot.
     *
     * @return O nome do bot.
     */
    public String getName();

    /**
     * Define a bandeira inimiga a ser alcançada pelo bot.
     *
     * @param enemyFlag A nova bandeira inimiga.
     */


    /**
     * Obtém o número de vezes que o bot foi movido.
     *
     * @return O número de vezes que o bot foi movido.
     */
    public int getTimesMoved();

    /**
     * Obtém o índice antigo do bot no grafo.
     *
     * @return O índice do bot no grafo.
     */
    int getLastIndex();
}
