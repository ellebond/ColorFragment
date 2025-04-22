package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceFragment.OnColorSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choiceID: Int) {
        val colorFragment = ColorFragment.newInstance(choiceID)
        val lowerContainer = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        supportFragmentManager.beginTransaction()
            .replace(lowerContainer.id, colorFragment)
            .commit()
    }
}