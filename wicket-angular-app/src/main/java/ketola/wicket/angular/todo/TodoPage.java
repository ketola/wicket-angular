package ketola.wicket.angular.todo;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class TodoPage extends WebPage {

	private static final Locale FI_FI = new Locale("fi", "FI");
	private static final Locale EN_US = new Locale("en", "US");
	private static final long serialVersionUID = 1L;
	
	public TodoPage() {
		add(new LanguageLink("langEn", EN_US));
		add(new LanguageLink("langFi", FI_FI));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forUrl("https://ajax.googleapis.com/ajax/libs/angularjs/1.0.5/angular.min.js"));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(TodoPage.class, "todo.js")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(TodoPage.class, "todo.css")));
	}
	
	private static class LanguageLink extends Link<Void>{
		
		private static final long serialVersionUID = 1L;
		private Locale locale;
		
		public LanguageLink(String id, Locale locale) {
			super(id);
			this.locale = locale;
		}

		@Override
		public void onClick() {
			Session.get().setLocale(locale);
		}
		
		@Override
		public boolean isEnabled() {
			return !Session.get().getLocale().equals(locale);
		}

	}

}
