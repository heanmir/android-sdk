package cloud.shoplive.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val text = intent.getStringExtra("url") ?: ""
        val textView = findViewById<TextView>(R.id.text)
        textView.text = text
    }
}