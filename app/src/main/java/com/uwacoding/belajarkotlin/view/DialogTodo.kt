package com.uwacoding.belajarkotlin.view

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.uwacoding.belajarkotlin.R
import com.uwacoding.belajarkotlin.model.Todo
import com.uwacoding.belajarkotlin.presenter.TodoPresenter

class DialogTodo : Dialog {
    val ctx: Context = context
    val btnSubmit:Button
    val etTitle:EditText
    val etDesc:EditText
    val etDate:EditText
    var mIsEdit:Boolean = false
    var mTodo: Todo? = null

    constructor(context: Context, presenter: TodoPresenter) : super(context) {

        setContentView(R.layout.create_dialog)

        btnSubmit = findViewById(R.id.btnSubmit) as Button
        etTitle = findViewById(R.id.etTitle) as EditText
        etDesc= findViewById(R.id.etDesc) as EditText
        etDate = findViewById(R.id.etDate) as EditText

        btnSubmit.setOnClickListener {
            if(etTitle.text.length > 0 && etDesc.text.length > 0){
                if(!mIsEdit) {
                    val todo: Todo = Todo(0, etTitle.text.toString(), etDesc.text.toString(), etDate.text.toString())
                    presenter.insertData(todo)
                }else{
                    val todo: Todo = Todo(mTodo!!.mId, etTitle.text.toString(), etDesc.text.toString(), etDate.text.toString())
                    presenter.updateData(todo)
                }
                dismiss()
            }

        }
    }

    fun clear(){
        etTitle.setText("")
        etDesc.setText("")
        etDate.setText("")
    }

    fun showDialog(isEdit: Boolean, todo: Todo?){
        mTodo = todo

        if(mTodo != null){
            Log.d("AF", "todo "+todo)
            etTitle.setText(todo?.mTitle)
            etDesc.setText(todo?.mDesc)
            etDate.setText(mTodo?.mDate)
        }else{
            clear()
        }

        mIsEdit = isEdit
        show()
    }
}