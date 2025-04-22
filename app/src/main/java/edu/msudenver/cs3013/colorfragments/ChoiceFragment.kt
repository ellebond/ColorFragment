package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ChoiceFragment : Fragment(R.layout.fragment_choice) {

    private var listener: OnColorSelectedListener? = null

    // This will be called when the fragment is attached to the activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Ensure the context is an instance of ChoiceListener
        if (context is OnColorSelectedListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement OnColorSelectedListener")
        }
    }

    // This will be called when the view is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextViews for blue and red choices
        val blueT: TextView = view.findViewById(R.id.blueText)
        val redT: TextView = view.findViewById(R.id.redText)

        // Set click listeners for blue and red TextViews
        blueT.setOnClickListener {
            listener?.onSelected(1) // 1 for blue
        }

        redT.setOnClickListener {
            listener?.onSelected(2) // 2 for red
        }
    }

    // This is the interface to communicate with the activity
    interface OnColorSelectedListener {
        fun onSelected(choice: Int)
    }

    // To create a new instance of this fragment
    companion object {
        @JvmStatic
        fun newInstance(): ChoiceFragment {
            return ChoiceFragment()
        }
    }
}