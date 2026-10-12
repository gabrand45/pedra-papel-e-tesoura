package com.example.pedrapapeltesoura

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {

    // Placar (no nível da classe para persistir entre as rodadas)
    private var vitorias = 0
    private var derrotas = 0
    private var empates = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        atualizarPlacar()
    }

    // Ligadas aos ImageViews imgPedra, imgPapel e imgTesoura via android:onClick
    fun selecionadoPedra(view: View) = jogar(PEDRA)
    fun selecionadoPapel(view: View) = jogar(PAPEL)
    fun selecionadoTesoura(view: View) = jogar(TESOURA)

    fun zerarPlacar(view: View) {
        vitorias = 0
        derrotas = 0
        empates = 0
        atualizarPlacar()

        findViewById<ImageView>(R.id.imgApp).setImageResource(R.drawable.padrao)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        txtResultado.setText("Faça sua jogada!")
        txtResultado.setTextColor(Color.BLACK)
    }

    private fun jogar(escolhaUsuario: String) {
        val opcoes = arrayOf(PEDRA, PAPEL, TESOURA)
        val escolhaApp = opcoes[Random().nextInt(3)]

        // Mostra a escolha do aplicativo
        val imgApp = findViewById<ImageView>(R.id.imgApp)
        when (escolhaApp) {
            PEDRA -> imgApp.setImageResource(R.drawable.pedra)
            PAPEL -> imgApp.setImageResource(R.drawable.papel)
            TESOURA -> imgApp.setImageResource(R.drawable.tesoura)
        }

        // Resultado e placar
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        when (verificarGanhador(escolhaUsuario, escolhaApp)) {
            USUARIO -> {
                vitorias++
                txtResultado.setText("Você ganhou!")
                txtResultado.setTextColor(Color.parseColor("#1E8449"))
            }
            APP -> {
                derrotas++
                txtResultado.setText("Você perdeu!")
                txtResultado.setTextColor(Color.parseColor("#C0392B"))
            }
            else -> {
                empates++
                txtResultado.setText("Empatamos!")
                txtResultado.setTextColor(Color.parseColor("#7F8C8D"))
            }
        }

        atualizarPlacar()
        println("Você: $escolhaUsuario | App: $escolhaApp | " +
            "V=$vitorias D=$derrotas E=$empates")
    }

    private fun atualizarPlacar() {
        findViewById<TextView>(R.id.txtVitorias).setText("Vitórias: $vitorias")
        findViewById<TextView>(R.id.txtDerrotas).setText("Derrotas: $derrotas")
        findViewById<TextView>(R.id.txtEmpates).setText("Empates: $empates")
    }
}
