package com.example.test.controller;

import com.example.test.entities.Todo;
import com.example.test.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo/api")


public class ToDoController {

    @Autowired
    private com.example.test.service.ToDoService toDoService;

    @GetMapping(value = {"","/"})
    public   ResponseEntity<List<Todo>> LisTodos()
    {

        List<Todo> result= toDoService.listsTodo();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = {"","/{id}"})
    public  ResponseEntity<Todo> getTodo(@PathVariable String id)
    {
        Todo result = toDoService.getToDo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value="/")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo t)
    {
      /*if(toDoService.save(t)!=null)
          return t;
      return null;*/
        Todo result=toDoService.save(t);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
         toDoService.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
