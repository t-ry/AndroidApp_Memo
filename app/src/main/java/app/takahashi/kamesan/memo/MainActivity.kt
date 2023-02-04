package app.takahashi.kamesan.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import app.takahashi.kamesan.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val memolist = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{ setContentView(this.root) }

        /*
        // editactivityからデータを受け取る
        val memo = intent.getStringExtra("memo")
        // memolistにデータを追加
        if (memo != null) memolist.add(memo)



        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memolist)
        binding.listView.adapter = adapter
         */

        binding.fabAdd.setOnClickListener{
            val editPage = Intent(this, EditActivity::class.java)
            startActivity(editPage)
        }
    }

    override fun onResume() {
        super.onResume()
        // editactivityからデータを受け取る
        val memo = intent.getStringExtra("memo")
        // memolistにデータを追加
        if (memo != null) memolist.add(memo)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memolist)
        binding.listView.adapter = adapter
    }
}