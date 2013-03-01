package ketola.wicket.angular.todo;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class TodoPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public TodoPage() {
		
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forUrl("https://ajax.googleapis.com/ajax/libs/angularjs/1.0.5/angular.min.js"));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(TodoPage.class, "todo.js")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(TodoPage.class, "todo.css")));
	}

}
