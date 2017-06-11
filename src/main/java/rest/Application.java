package rest;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createReservation(String guestFirstName, String guestSecondName, int roomNumber, LocalDate startDate, LocalDate endDate) {
		return ReservationService.getInstance().createReservation(guestFirstName, guestSecondName, roomNumber, startDate, endDate);
	}

	@RequestMapping("/test")
	public String ReservationTest() {
		return "Test value";
	}

	@RequestMapping(value = "/test1/{id}", method = RequestMethod.GET)
	public String ReservationTest(@PathVariable("id") long id) {
		return "Another one. This time with param = " + id;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
