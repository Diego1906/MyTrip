package com.example.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btn_calcular)
            handleCalculate()
    }

    private fun showMessage(message: String) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG).show()
    }

    private fun handleCalculate() {
        if (isValid()) {

            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                var result = ((distance * price) / autonomy)
                textResult.setText("Total: R$ $result")

            } catch (ex: NumberFormatException) {
                showMessage(getString(R.string.valores_validos))
            }
        } else
            showMessage(getString(R.string.valores_validos))
    }

    private fun isValid(): Boolean {
        return editDistance.text.toString().isNotEmpty()
                && editPrice.text.toString().isNotEmpty()
                && editAutonomy.text.toString().isNotEmpty()
                && editAutonomy.text.toString() != "0"
    }
}
