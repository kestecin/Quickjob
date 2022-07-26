package com.example.quickjob

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickjob.activity.ProfileActivity
import com.example.quickjob.adapter.PersonListAdapter
import com.example.quickjob.manager.LoginManager
import com.example.quickjob.viewModel.MainActivityViewModel
import com.google.firebase.FirebaseApp
import dmax.dialog.SpotsDialog


class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: PersonListAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        recyclerView = findViewById(R.id.recycler)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getUserList.observe(this) { personModels ->
            Log.e("MainActivity", "PersonList: " + personModels[1].user_nicename)

            if (personModels != null) {
                adapter = PersonListAdapter(this, personModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }

        if (LoginManager.getUserName(this).isNullOrEmpty()) {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
        } else {
//            email = findViewById(R.id.helloUser)
//            email.text = LoginManager.getUserName(this)
        }
        initializeViews()
//        loadPeople()
    }

    private fun initializeViews() {
//        email = findViewById(R.id.helloUser)
//        email.setOnClickListener {
//            profile()
    }

    private fun profile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

//    private fun loadPeople() {
//        disposable = RestClient(this).getPeople().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { (personRecycler.adapter as ItemRecyclerAdapter).people = it },
//                {
//                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
//                })
//    }

}