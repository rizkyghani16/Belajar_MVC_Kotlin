package com.uwacoding.belajarkotlin.presenter

import com.uwacoding.belajarkotlin.model.Todo
import com.uwacoding.belajarkotlin.repository.DbHelper

class TodoPresenter(todoView: TodoMvp.TodoView, db: DbHelper) : TodoMvp.TodoPresenter{


    val mTodoView: TodoMvp.TodoView = todoView
    val mDb : DbHelper = db

    override fun insertData(todo: Todo) {
        if(mDb.insertData(todo)){
            mTodoView.setResult("New data added")
            getAllData()
        }else{
            mTodoView.setResult("Failed add data")
        }
    }

    override fun getAllData(){
        val ls: List<Todo> = mDb.getAllTodo()
        mTodoView.onLoad(true)

        if(ls.size > 0)
            mTodoView.setData(ls)
        else
            mTodoView.setEmpty()

        mTodoView.onLoad(false)
    }

    override fun deleteData(id: Int) {
        if(mDb.deleteData(id)){
            mTodoView.setResult("Data deleted")
            getAllData()
        }else{
            mTodoView.setResult("Failed delete data")
        }
    }

    override fun updateData(todo: Todo) {
        if(mDb.updateData(todo)){
            mTodoView.setResult("Data updated")
            getAllData()
        }else{
            mTodoView.setResult("Failed update data")
        }
    }
}