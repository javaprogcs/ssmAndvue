package com.csw.dao;

import com.csw.entity.Todo;
import java.util.List;

public interface TodoMapper {
    List<Todo> getTodos();
    List<Todo> addTodo(Todo todo);
    List<Todo> deleteTodo(Todo todo);
    List<Todo> makeDone(Todo todo);
    List<Todo> makeCancle(Todo todo);
}