package com.example.test.service;

import com.example.test.entities.Todo;
import com.example.test.exception.ConflictException;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ToDoService {
    @Autowired
    TodoRepository todoRepository;
    
         public ToDoService()
         {
//           
         }


        public List<Todo> listsTodo()
        {
          return todoRepository.findAll();
        }



        public Todo getToDo(String i)
        {
            try {
                return todoRepository.findById(i).get();
            }catch (NoSuchElementException e)
            {
                throw new NotFoundException(String.format("Element with %s not found", i));
            }

        }

        public Todo save(Todo t)
        {

           if(todoRepository.findByTitle(t.getTitle())!=null) {
               throw new ConflictException(String.format("Element with %s already exists", t.getTitle()));
            }
            return todoRepository.insert(t);



        }

        public void delete(String id)
        {
            try {
                todoRepository.deleteById(id);
            }catch (NoSuchElementException e)
            {
                throw new NotFoundException(String.format("Can't delete Element with id %s not found", id));
            }
        }


}
