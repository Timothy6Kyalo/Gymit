package com.example.gymit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CLassScheduleActivity : AppCompatActivity() {
    private lateinit var classListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_schedule)

        classListView = findViewById(R.id.classListView)

        val classSchedule = arrayOf(
            "Yoga - Monday 10:00 AM",
            "Zumba - Tuesday 6:00PM",
            "CrossFit - Wednesday 8:00 AM",
            "Pilates - Thursday 7:30 AM",
            "Boxing - Friday 5:00 PM"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, classSchedule)

        classListView.adapter = adapter

        classListView.setOnItemClickListener { parent, view, position, id ->
            val selectedClass = classSchedule[position]
            Toast.makeText(this, "Selected class: $selectedClass", Toast.LENGTH_SHORT).show()
        }
    }


}