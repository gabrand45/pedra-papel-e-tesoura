# Pedra, Papel e Tesoura (Android Studio · Kotlin)

Abra a pasta no Android Studio (File > Open) e rode no emulador.

## O que foi feito
1. **`.equals()` no `verificarGanhador`** — todas as comparações de `==` foram trocadas por
   `.equals()` (arquivo `Jogo.kt`). O teste `JogoTest` cobre as 9 combinações possíveis
   (3 empates, 3 vitórias, 3 derrotas): rode com botão direito em `JogoTest` > Run.
2. **Placar** — `vitorias`, `derrotas` e `empates` são contadores da classe, atualizados a cada
   rodada e exibidos em `txtVitorias`, `txtDerrotas` e `txtEmpates`. Botão extra "Zerar placar".
3. **Desafio: nomes padronizados** — os ImageViews de escolha são `imgPedra`, `imgPapel` e
   `imgTesoura` (e `imgApp` para a jogada do aplicativo), com funções `selecionadoPedra`,
   `selecionadoPapel` e `selecionadoTesoura` ligadas por `android:onClick`.

Os ícones são vetores em `res/drawable` (pedra, papel, tesoura, padrao).
