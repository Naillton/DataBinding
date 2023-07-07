package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
// lembrar sempre de adcionar o binding no module app em build.gradle
class MainActivity : AppCompatActivity() {
    // criando conexao com o dataBinding, onde referenciaremos o layout usado no activity main
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Quando usamos dataBinding nos paramos de usar o setContentView desta forma
        // usaremos agora o setContentView de outra maneira sendo referenciada pelo dataBindingUtil
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // o mesmo acontece com a nossa referencia antiga de elementos pelo id, como pela hierarquia
        // nos temos a nossa view e o binding agora é a nossa view usaremos o binding para acessar elementos
        //val edtText: EditText = findViewById(R.id.editTextId)
        //val textV: TextView = findViewById(R.id.textView)
        //val btn: Button = findViewById(R.id.btnId)

       /*binding.btnId.setOnClickListener {
            val editedText: String = binding.editTextId.text.toString()
            binding.textView.text = editedText
        }*/

        // Para evitarmos de usar o binding muitas vezes podemos chamar o metodo apply do binding
        // que vai nos permiter acessar elementos sem adcionar o binding.

        binding.apply {
            btnId.setOnClickListener {
                val editedText: String = editTextId.text.toString()
                textView.text = editedText
            }
        }
    }
}