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


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnColorSelectedListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement OnColorSelectedListener")
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val blueT: TextView = view.findViewById(R.id.blueText)
        val redT: TextView = view.findViewById(R.id.redText)


        blueT.setOnClickListener {
            listener?.onSelected(1)
        }

        redT.setOnClickListener {
            listener?.onSelected(2)
        }
    }


    interface OnColorSelectedListener {
        fun onSelected(choice: Int)
    }


    companion object {
        @JvmStatic
        fun newInstance(): ChoiceFragment {
            return ChoiceFragment()
        }
    }
}