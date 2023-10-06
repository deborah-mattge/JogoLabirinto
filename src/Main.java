import java.awt.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Labirinto labirinto = new Labirinto();
    static String jogador = new String(Character.toChars(0x1F6B6));
    static int posicaoJogador;

    public static void main(String[] args) {
        labirinto.getPosicoes().set(57, jogador);

        posicaoJogador = 57;

        do {
            System.out.println(labirinto.getPosicoes().size());
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
                    movimentoPossivel = Labirinto.moverParaCima(labirinto, posicaoJogador, jogador);
                    break;
                case "s":
                    movimentoPossivel = Labirinto.moverParaBaixo(labirinto, posicaoJogador, jogador);
                    break;
                case "d":
                    movimentoPossivel = Labirinto.moverParaDireita(labirinto, posicaoJogador, jogador);
                    break;
                case "a":
                    movimentoPossivel = Labirinto.moverParaEsquerda(labirinto, posicaoJogador, jogador);
                    break;
            }
            if (movimentoPossivel == 0) {
                System.out.println("Jogada inválida!");
            }else if(movimentoPossivel==65){
                System.out.println("Você encontrou um obstaculo! ");

            }else{
                posicaoJogador= movimentoPossivel;
            }
        } while (!ganhou());


    }

    public static void mostrarTabuleiro() {
        for (int i = 0; i < labirinto.getPosicoes().size(); i++) {
            System.out.print(labirinto.getPosicoes().get(i) + " "); // Adicione um espaço entre as posições
            if ((i + 1) % 8 == 0) {
                System.out.println(); // Quebra de linha após cada linha de 8 posições
            }
        }
    }

    public static boolean ganhou() {
        if (posicaoJogador == 6){
            mostrarTabuleiro();
            System.out.println("Você ganhou!");

            return  true;
        }
        return false;
    }


}


