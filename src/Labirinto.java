import java.util.ArrayList;

public class Labirinto {
    private ArrayList<String> posicoes = new ArrayList<>(121);

    public Labirinto() {
        for (int i = 0; i < 121; i++) {

            if (i % 11 == 0) {
                posicoes.add(i, "|");
            }
            else if (i >= 2 && i <= 10) {
                posicoes.add(i, "__");
            }
            else if (i >= 24 && i <= 27 || i == 30 || i == 29 || i == 34 || i == 40) {
                posicoes.add(i, "##");
            }
            else if (i == 46 || i == 47 || i >= 49 && i <= 52 || i == 56 || i == 60 || i == 64) {
                posicoes.add(i, "##");
            }
            else if (i >= 69 && i <= 71 || i == 73) {
                posicoes.add(i, "##");
            }
            else if (i == 79 || i == 84 || i == 85) {
                posicoes.add(i, "##");
            }
            else if (i == 90 || i == 92 || i == 94 || i == 96) {
                posicoes.add(i, "##");
            }
            else if (i == 104 || i == 105 ) {
                posicoes.add(i, "##");
            }
            else if (i >= 111 && i <= 116 || i == 118 || i == 119) {
                posicoes.add(i, "##");
            }else if(i==10 || i==21 || i==32 || i==43 || i==54 || i==65 || i==76 || i==87 || i==98 || i==109 || i==120){
                posicoes.add(i, "|");
            }
            else {
                posicoes.add(i, "  ");
            }
            
        }
    }

    public static int moverParaCima(Labirinto labirinto, int posicao, String jogador) {

        try {
            for (String s : labirinto.posicoes) {
                if (s.contains(labirinto.getPosicoes().get(posicao - 11))) {
                    if (s.equals("  ")) {
                        labirinto.posicoes.set(posicao, "  ");
                        labirinto.posicoes.set(posicao - 11, jogador);
                        return posicao - 11;
                    }
                }
                if (s.equals("##")) {
                    return 150;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }


        return 0;
    }

    public static int moverParaBaixo(Labirinto labirinto, int posicao, String jogador) {
        try {
            for (String s : labirinto.posicoes) {
                if (s.contains(labirinto.getPosicoes().get(posicao + 11))) {
                    if (s.equals("  ")) {
                        labirinto.posicoes.set(posicao, "  ");
                        labirinto.posicoes.set(posicao + 11, jogador);
                        return posicao + 11;
                    }
                }
                if (s.equals("##")) {
                    return 150;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return 0;
    }

    public static int moverParaDireita(Labirinto labirinto, int posicao, String jogador) {
        for (String s : labirinto.posicoes) {
            if (s.contains(labirinto.getPosicoes().get(posicao + 1))) {
                if (s.equals("  ")) {
                    labirinto.posicoes.set(posicao, "  ");
                    labirinto.posicoes.set(posicao + 1, jogador);
                    return posicao + 1;
                }
            }
        }
        return 0;
    }

    public static int moverParaEsquerda(Labirinto labirinto, int posicao, String jogador) {
        for (String s : labirinto.posicoes) {
            if (s.contains(labirinto.getPosicoes().get(posicao - 1))) {
                if (s.equals("  ")) {
                    labirinto.posicoes.set(posicao, "  ");
                    labirinto.posicoes.set(posicao - 1, jogador);
                    return posicao - 1;
                }
            }
        }
        return 0;
    }

    public ArrayList<String> getPosicoes() {
        return posicoes;
    }


}
