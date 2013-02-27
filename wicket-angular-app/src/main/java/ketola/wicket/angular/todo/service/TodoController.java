package ketola.wicket.angular.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
	
	@RequestMapping( value = "/todos", method = RequestMethod.GET )
	@ResponseBody
	public List<Todo> fetchTodos(){
		List<Todo> todos = new ArrayList<Todo>();
		
		todos.add(createTodo("Create Wicket base application", true));
		todos.add(createTodo("Add Angular todo example", true));
		todos.add(createTodo("Create a restful webservice to serve todos", true));
		todos.add(createTodo("Create a restful webservice to create new todos", false));
		todos.add(createTodo("Create a restful webservice to delete todos ", false));
		
		return todos;
	}
	
	private Todo createTodo(String text, boolean done){
		Todo todo = new Todo();
		todo.setDone(done);
		todo.setText(text);
		return todo;
	}
}

