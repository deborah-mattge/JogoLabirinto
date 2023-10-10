import java.util.ArrayList;

public class Labirinto {
    private ArrayList<String> posicoes = new ArrayList<>(121);

    public Labirinto() {
        for (int i = 0; i < 121; i++) {

            if (i % 11 == 0) {
                posicoes.add(i, "|");
            } else if (i >= 2 && i <= 10) {
                posicoes.add(i, "__");
            } else if (i >= 24 && i <= 27 || i == 30 || i == 29 || i == 34 || i == 40) {
                posicoes.add(i, "##");
            } else if (i == 46 || i == 47 || i == 49 || i == 51 || i == 52 || i == 56 || i == 60 || i == 64) {
                posicoes.add(i, "##");
            } else if (i >= 69 && i <= 71 || i == 73) {
                posicoes.add(i, "##");
            } else if (i == 79 || i == 84 || i == 85) {
                posicoes.add(i, "##");
            } else if (i == 90 || i == 92 || i == 94) {
                posicoes.add(i, "##");
            } else if (i == 105) {
                posicoes.add(i, "##");
            } else if (i >= 111 && i <= 116 || i == 118 || i == 119) {
                posicoes.add(i, "##");
            } else if (i == 10 || i == 21 || i == 32 || i == 43 || i == 54 || i == 65 || i == 76 || i == 87 || i == 98 || i == 109 || i == 120) {
                posicoes.add(i, "|");
            } else {
                posicoes.add(i, "  ");
            }
        }
    }

    public int moverParaCima(int posicao, String jogador) {
        try {
            for (String s : this.posicoes) {
                if (verificarArmadilha(posicao - 11)) {
                    mudarPosicao(posicao, 1, jogador);
                    return 151;
                } else {
                    if (s.contains(getPosicoes().get(posicao - 11))) {
                        if (s.equals("  ")) {
                            mudarPosicao(posicao, posicao - 11, jogador);
                            return posicao - 11;
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }


        return 0;
    }

    public int moverParaBaixo(int posicao, String jogador) {
        try {
            for (String s : this.posicoes) {
                if (verificarArmadilha(posicao + 11)) {
                    mudarPosicao(posicao, 1, jogador);
                    return 151;
                } else {
                    if (s.contains(getPosicoes().get(posicao + 11))) {
                        if (s.equals("  ")) {
                            mudarPosicao(posicao, posicao + 11, jogador);
                            return posicao + 11;
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return 0;
    }

    public int moverParaDireita(int posicao, String jogador) {
        for (String s : this.posicoes) {
            if (verificarArmadilha(posicao + 1)) {
                mudarPosicao(posicao, 1, jogador);
                return 151;
            } else {
                if (s.contains(getPosicoes().get(posicao + 1))) {
                    if (s.equals("  ")) {
                        mudarPosicao(posicao, posicao + 1, jogador);
                        return posicao + 1;
                    }
                }
            }
        }
        return 0;
    }

    public int moverParaEsquerda(int posicao, String jogador) {
        for (String s : this.posicoes) {
            if (verificarArmadilha(posicao - 1)) {
                mudarPosicao(posicao, 1, jogador);
                return 151;
            } else {
                if (s.contains(getPosicoes().get(posicao - 1))) {
                    if (s.equals("  ")) {
                        mudarPosicao(posicao, posicao - 1, jogador);
                        return posicao - 1;
                    }
                }
            }
        }
        return 0;
    }

    private void mudarPosicao(int posicaoAtual, int posicaoDestino, String jogador) {
        this.posicoes.set(posicaoAtual, "  ");
        this.posicoes.set(posicaoDestino, jogador);
    }

    public boolean verificarArmadilha(int posicao) {
        if (posicao == 35 || posicao == 41 || posicao == 50 || posicao == 96 || posicao == 104) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getPosicoes() {
        return posicoes;
    }


}
