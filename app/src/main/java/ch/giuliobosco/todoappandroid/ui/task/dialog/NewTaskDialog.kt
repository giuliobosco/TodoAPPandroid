package ch.giuliobosco.todoappandroid.ui.task.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ch.giuliobosco.todoappandroid.R
import ch.giuliobosco.todoappandroid.util.Validator
import kotlinx.android.synthetic.main.dialog_task.*
import java.lang.ClassCastException

class NewTaskDialog : DialogFragment() {
    private lateinit var listener: NewTaskListener
    private val validator = Validator()

    companion object {
        const val TAG = "new_dialog"
        fun newInstance(): NewTaskDialog {
            return NewTaskDialog()
        }
    }

    override fun onStart() {
        super.onStart()

        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            it.window?.setLayout(width, height)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validator.add(inputLayoutTitle)
        btnOk.setOnClickListener {
            val title = inputLayoutTitle.editText?.text.toString()
            val description = inputLayoutDescription.editText?.text.toString()

            if (validator.result()) {
                listener.createTask(title, description)
                dismiss()
            }
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as NewTaskListener
        } catch (error: ClassCastException) {
            throw ClassCastException(error.message)
        }
    }
}

interface NewTaskListener {
    fun createTask(title: String, description:String)
}