package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ColorFragment : Fragment(R.layout.fragment_color) {

    companion object {
        private var fragmentCount = 0

        fun newInstance(choice: Int): ColorFragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putInt("COLOR CHOICE", choice)
            fragment.arguments = args
            return fragment
        }
    }

    private var myIndex: Int = 0
    private val chosenColorTV: TextView?
        get() = view?.findViewById(R.id.mycolor)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myIndex = ++fragmentCount

        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0

        when (choiceId) {
            1 -> {
                chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }
}