import java.awt.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Labirinto labirinto = new Labirinto();
    static String jogador = new String(Character.toChars(0x1F6B6));
    static int posicaoJogador;

    public static void main(String[] args) {
        labirinto.getPosicoes().set(1, jogador);

        posicaoJogador = 1;

        do {
            mostrarTabuleiro();
            System.out.println("""
                    \n
                    w- para cima 
                    s- para baixo 
                    d- para lo lado direito 
                    a- para o lado esquerdo""");
            String opcao = scanner.next();
            int movimentoPossivel = 0;
            switch (opcao) {
                case "w":
                    movimentoPossivel = labirinto.moverParaCima(posicaoJogador, jogador);
                    break;
                case "s":
                    movimentoPossivel = labirinto.moverParaBaixo(posicaoJogador, jogador);
                    break;
                case "d":
                    movimentoPossivel = labirinto.moverParaDireita(posicaoJogador, jogador);
                    break;
                case "a":
                    movimentoPossivel = labirinto.moverParaEsquerda(posicaoJogador, jogador);
                    break;
            }
            if (movimentoPossivel == 0) {
                System.out.println("Você encontrou um obstáculo! ");

            } else if (movimentoPossivel == 151) {
                System.out.println("Você encontrou uma armadilha!");
                posicaoJogador = 1;

            } else {
                posicaoJogador = movimentoPossivel;
            }
        } while (!ganhou());


    }

    public static void mostrarTabuleiro() {
        for (int i = 0; i < labirinto.getPosicoes().size(); i++) {
            System.out.print(labirinto.getPosicoes().get(i) + " "); // Adicione um espaço entre as posições
            if ((i + 1) % 11 == 0) {
                System.out.println(); // Quebra de linha após cada linha de 8 posições
            }
        }
    }

    public static boolean ganhou() {
        if (posicaoJogador == 117) {
            mostrarTabuleiro();
            System.out.println("Você ganhou!");

            return true;
        }
        return false;
    }


}


