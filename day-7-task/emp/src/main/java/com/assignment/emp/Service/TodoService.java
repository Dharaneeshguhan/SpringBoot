package com.assignment.emp.Service;

import com.assignment.emp.Model.Todo;
import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> getTodosByUser(Long userId) {
        return todoRepository.findByUserId(userId);
    }
    public Todo createTodoForUser(Todo todo, User user) {
        todo.setUser(user);
        return todoRepository.save(todo);
    }
}
