package com.csw.controller;

import com.csw.dao.TodoMapper;
import com.csw.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> home() {
        return todoMapper.getTodos();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public List<Todo> add(@RequestBody Todo todo){
        return  todoMapper.addTodo(todo);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public List<Todo> delete(@RequestBody Todo todo){
        return  todoMapper.deleteTodo(todo);
    }

    @RequestMapping(value = "/upDone",method = RequestMethod.POST)
    public List<Todo> updatemakeDone(@RequestBody Todo todo){
        return  todoMapper.makeDone(todo);
    }


    @RequestMapping(value = "/Cancle",method = RequestMethod.POST)
    public List<Todo> updatemakeCancle(@RequestBody Todo todo){
        return  todoMapper.makeCancle(todo);
    }
}
