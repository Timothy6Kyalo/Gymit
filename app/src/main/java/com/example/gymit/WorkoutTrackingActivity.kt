package com.example.gymit

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class WorkoutTrackingActivity : AppCompatActivity() {
    private lateinit var exerciseNameTextView: TextView
    private lateinit var workoutChronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var CSButton: Button

    private var isTracking = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_tracking)

        exerciseNameTextView = findViewById(R.id.exerciseNameTextView)
        workoutChronometer = findViewById(R.id.workoutChronometer)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)
        CSButton = findViewById(R.id.CSButton)

        startButton.setOnClickListener {
            startWorkoutTracking()
        }
        stopButton.setOnClickListener {
            stopWorkoutTracking()
        }
        resetButton.setOnClickListener {
            resetWorkoutTracking()
        }
        CSButton.setOnClickListener {
            val intent = Intent(this, CLassScheduleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startWorkoutTracking() {
        if (!isTracking) {
            exerciseNameTextView.text = "Running"

            workoutChronometer.base = SystemClock.elapsedRealtime()
            workoutChronometer.start()

            startButton.isEnabled = false
            stopButton.isEnabled = true
            resetButton.isEnabled = false

            isTracking = true
        }
    }

    private fun stopWorkoutTracking() {
        if (isTracking) {
           workoutChronometer.stop()

            startButton.isEnabled = true
            stopButton.isEnabled = false
            resetButton.isEnabled =true

            isTracking = false
        }
    }

    private fun resetWorkoutTracking() {
        workoutChronometer.base = SystemClock.elapsedRealtime()

        startButton.isEnabled = true
        stopButton.isEnabled = false
        resetButton.isEnabled = false

        isTracking = false
        }
}


