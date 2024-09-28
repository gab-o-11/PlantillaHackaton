package email;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
    private final String email;

    public EmailEvent(String email) {
        super(email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
