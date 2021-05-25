package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.*


class MainActivity : AppCompatActivity() {
    val db by lazy{
        Room.databaseBuilder(this,
            AppDatabase::class.java,
            "User.db")                                                     //.allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //db.userDao()
        button.setOnClickListener {
            GlobalScope.launch (Dispatchers.IO){db.userDao().insert(User("Deepali Verma", "8076516981", "pandav Nagar", 20))}
          //  db.userDao().insert(User("Deepali Verma", "8076516981", "pandav Nagar", 20))

        }
  button2.setOnClickListener {
        runBlocking {
            val list: Deferred<List<User>> =
                GlobalScope.async(Dispatchers.IO) { db.userDao().getAllUser() }
            if (list.await().isNotEmpty()) {
                with(list.await()[0]) {
                    tv1.text = name
                    tv2.text = number
                    tv3.text = address
                    tv4.text = age.toString()
                }
            }

        }


    }




        }

    }
