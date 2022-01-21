package com.example.firstprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.github.barteksc.pdfviewer.PDFView
class pdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        val pdfView = findViewById<PDFView>(R.id.pdfView)
        val s =
        pdfView.fromAsset("python.pdf").load()
    }
}