package ed_recurso_8210126.API.Algorithms;

import java.util.Random;

public class Movement implements MovementAlgorithm {
    private Random random;

    public Movement() {
        this.random = new Random();
    }

    @Override
    public void move() {
        // Aqui você pode implementar a lógica específica de movimento usando a classe Movement.
        // Por exemplo, você pode chamar getRandomMove() para obter um movimento aleatório.
        int randomMove = getRandomMove();
        System.out.println("Executando movimento: " + randomMove);
        // Implemente o restante da lógica de movimento conforme necessário.
    }

    public int getRandomMove() {
        return random.nextInt(4);
    }
}
