package email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void RideEvent(EmailEvent event) {
        emailService.sendSimpleMessage(event.getEmail(), "¡Tu viaje ha sido creado con exito!", "El viaje que has agendado ha sido creado con exito, por favor, vaya alistandose para no tener inconvenientes.");
    }
}
