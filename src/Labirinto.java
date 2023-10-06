import java.util.ArrayList;

public class Labirinto {
    private ArrayList<String> posicoes = new ArrayList<>();

    public Labirinto() {
        for (int i = 0; i < 64; i++) {
            {
            }
            if (i % 8 == 0) {
                posicoes.add(i, "|");
            } else if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55 || i == 63) {

                posicoes.add(i, "|");
            } else if (i >= 10 && i <= 13) {
                posicoes.add(i, "__");
            } else if (i >= 26 && i <= 30) {
                posicoes.add(i, "__");
            } else if (i >= 41 && i <= 45) {
                posicoes.add(i, "__");
            } else if (i >= 58 && i <= 62) {
                posicoes.add(i, "__");
            } else if (i == 14) {
                posicoes.add(i, "##");
            } else {
                posicoes.add(i, "  ");
            }
        }
    }

    public static int moverParaCima(Labirinto labirinto, int posicao, String jogador) {

            try{
                for (String s : labirinto.posicoes) {
                if (s.contains(labirinto.getPosicoes().get(posicao - 8))) {
                    if (s.equals("  ")) {
                        labirinto.posicoes.set(posicao, "  ");
                        labirinto.posicoes.set(posicao - 8, jogador);
                        return posicao - 8;
                    }
                }if(s.equals("##")){
                    return 65;
                }
                }
            }catch (IndexOutOfBoundsException e){
                return 0;
            }


        return 0;
    }

    public static int moverParaBaixo(Labirinto labirinto, int posicao, String jogador) {
        try {
            for (String s : labirinto.posicoes) {
                if (s.contains(labirinto.getPosicoes().get(posicao + 8))) {
                    if (s.equals("  ")) {
                        labirinto.posicoes.set(posicao, "  ");
                        labirinto.posicoes.set(posicao + 8, jogador);
                        return posicao + 8;
                    }
                }
                if (s.equals("##")) {
                    return 65;
                }
            }
        }catch (IndexOutOfBoundsException e ){
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
