package ru.perelyginva.composition.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.perelyginva.composition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}