package com.example.test;

import com.example.test.entities.Todo;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.TodoRepository;
import com.example.test.service.ToDoService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class TodoServiceTest {

    @MockBean TodoRepository todoRepository;

    @Autowired  ToDoService todoService;
    @TestConfiguration
    public static class TestContextConfiguration {
        @Bean
        public ToDoService todoService()
        {
            return new ToDoService();
        }
    }

    @Test
    public void findAllTodoTest()
    {
        //Mockup: create simulation data
        Todo t1=new Todo("1","Titre1","desc1");
        Todo t2=new Todo("2","Titre2","desc2");
        Todo t3=new Todo("3","Titre3","desc3");
        Todo t4=new Todo("4","Titre4","desc4");
        List<Todo> fakeList= Arrays.asList(t1,t2,t3,t4);
        given(todoRepository.findAll()).willReturn(fakeList);

        assertThat(todoService.listsTodo()).hasSize(4).contains(t1,t2,t3,t4);
    }

    @Test
    public void getByIdTest()
    {
        Todo t1=new Todo("1","Titre1","desc1");
        given(todoRepository.findById(anyString())).willReturn(Optional.of(t1));


        Todo result=todoService.getToDo("1");
       // assertThat(result.getTitle()).isEqualTo("Titre1");
        assertThat(result.getTitle()).containsIgnoringCase("Titre1");

    }

    @Test
    public void TodoNotFounded()
    {
        given(todoRepository.findById(anyString())).willReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            todoService.getToDo("1");
        });


    }



}
