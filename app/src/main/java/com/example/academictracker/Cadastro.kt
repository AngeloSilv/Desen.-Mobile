package com.example.academictracker

import android.os.Bundle
import android.content.Intent
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Iniciando variáveis para salvar as informações de cadastro (serão utilizadas posteriormente na confirmação de dados)
        val nomeCompleto = findViewById<EditText>(R.id.nomeCompleto)
        val userName = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.Email)
        val senhaUsuario = findViewById<EditText>(R.id.Senha)


        // Botão para avançar e voltar
        val buttonAvancar = findViewById<Button>(R.id.avancar)
        val buttonVoltar = findViewById<Button>(R.id.voltar)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, PaginaInicial::class.java)
            startActivity(intent)
            finish()
        }

        buttonAvancar.setOnClickListener {
            val intent = Intent(this, PaginaDeValidacaoDeDados::class.java)
            startActivity(intent)
            finish()
        }

        // Mostrar e esconder senha
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val senha = findViewById<TextInputLayout>(R.id.Senha)
        val confirmarSenha = findViewById<TextInputLayout>(R.id.ConfirmeSenha)

        // Criando variáveis para EditText de Senha e Confirmação de Senha também
        val senhaEditText = senha.editText as TextInputEditText
        val confirmarSenhaEditText = confirmarSenha.editText as TextInputEditText

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Mostrar senha
                senhaEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                confirmarSenhaEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                // Ocultar senha
                senhaEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                confirmarSenhaEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
}