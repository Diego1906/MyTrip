package com.example.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val ZERO: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcular)
            handleCalculate()
    }

    private fun handleCalculate() {
        if (isValid()) {
            try {
                val distance = editDistancia.text.toString().toFloat()
                val price = editPreco.text.toString().toFloat()
                val autonomy = editAutonomia.text.toString().toFloat()

                var result = ((distance * price) / autonomy)
                labelResult.text = "R$ " + result

            } catch (ex: NumberFormatException) {
                showMessage(getString(R.string.valores_validos))
            }
        } else
            showMessage(getString(R.string.valores_validos))
    }

    private fun isValid(): Boolean {
        return editDistancia.text.toString().isNotEmpty()
                && editPreco.text.toString().isNotEmpty()
                && editAutonomia.text.toString().isNotEmpty()
                && editAutonomia.text.toString() != ZERO
    }

    private fun showMessage(message: String) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG).show()
    }
}
