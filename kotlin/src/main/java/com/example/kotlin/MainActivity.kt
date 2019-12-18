package com.example.kotlin


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTest:RecyclerView
    private val data = arrayListOf("砸瓦鲁多","黑蚊子多","欧拉欧拉","木大木大","基拉奎因","败者食尘")
    private var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }



    private fun initView() {
        rvTest = findViewById(R.id.rv_test)
        rvTest.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvTest.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = MyAdapter(this,data)
        adapter?.setOnItemClickListener{
            position, _ -> Toast.makeText(this,"position:$position",Toast.LENGTH_SHORT).show()
        }
        rvTest.adapter = adapter
    }


}
