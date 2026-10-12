package com.example.pedrapapeltesoura

const val PEDRA = "pedra"
const val PAPEL = "papel"
const val TESOURA = "tesoura"

const val USUARIO = "usuario"
const val APP = "app"
const val EMPATE = "empate"

/**
 * Decide quem ganhou a rodada.
 * Todas as comparações usam .equals() (em vez de ==).
 */
fun verificarGanhador(escolhaUsuario: String, escolhaApp: String): String {
    if (escolhaUsuario.equals(escolhaApp)) {
        return EMPATE
    }

    val usuarioGanha =
        (escolhaUsuario.equals(PEDRA) && escolhaApp.equals(TESOURA)) ||
        (escolhaUsuario.equals(TESOURA) && escolhaApp.equals(PAPEL)) ||
        (escolhaUsuario.equals(PAPEL) && escolhaApp.equals(PEDRA))

    return if (usuarioGanha) USUARIO else APP
}
