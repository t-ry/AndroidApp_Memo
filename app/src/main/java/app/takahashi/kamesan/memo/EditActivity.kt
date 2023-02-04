package app.takahashi.kamesan.memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.takahashi.kamesan.memo.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.fabSubmit.setOnClickListener{

            val memo = binding.inputText.text.toString()

            if(memo.isNotEmpty()){
                val mainPage = Intent(this, MainActivity::class.java)
                mainPage.putExtra("memo",memo)
                startActivity(mainPage)
                finish()
            }
        }
    }
}