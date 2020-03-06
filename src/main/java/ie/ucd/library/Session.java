package ie.ucd.library;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Session {
	private User currentUser;

	public void setUser(User currentUser) {
		this.currentUser = currentUser;	
	}
	public User getCurrentUser() {
		return this.currentUser;
	}
	public int getCurrentUserId() {
		return this.currentUser.getId();
	}
}