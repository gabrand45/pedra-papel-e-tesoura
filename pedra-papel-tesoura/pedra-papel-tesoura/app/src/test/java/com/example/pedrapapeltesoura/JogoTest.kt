package com.example.pedrapapeltesoura

import org.junit.Assert.assertEquals
import org.junit.Test

class JogoTest {

    @Test
    fun empates() {
        for (e in listOf(PEDRA, PAPEL, TESOURA)) {
            assertEquals(EMPATE, verificarGanhador(e, e))
        }
    }

    @Test
    fun usuarioGanha() {
        assertEquals(USUARIO, verificarGanhador(PEDRA, TESOURA))
        assertEquals(USUARIO, verificarGanhador(TESOURA, PAPEL))
        assertEquals(USUARIO, verificarGanhador(PAPEL, PEDRA))
    }

    @Test
    fun appGanha() {
        assertEquals(APP, verificarGanhador(TESOURA, PEDRA))
        assertEquals(APP, verificarGanhador(PAPEL, TESOURA))
        assertEquals(APP, verificarGanhador(PEDRA, PAPEL))
    }
}
