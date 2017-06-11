package rest;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/create/{roomId}", method = RequestMethod.GET)
	public String createReservation(@PathVariable("roomId") int roomId,
			@RequestParam(value = "name", required = true) String guestFirstName,
			@RequestParam(value = "surname", required = true) String guestSecondName,
			@RequestParam(value = "from", required = true) String fromDate,
			@RequestParam(value = "to", required = true) String toDate) {
		LocalDate startDate = LocalDate.parse(fromDate);
		LocalDate endDate = LocalDate.parse(toDate);
		
		return ReservationService.getInstance().createReservation(guestFirstName, guestSecondName, roomId, startDate, endDate);
	}

	@RequestMapping("/listReservations")
	public String printReservationsList() {
		return ReservationService.getInstance().listReservations();
	}

	@RequestMapping(value = "/listReservationsByDate/", method = RequestMethod.GET)
	public String printReservation(@RequestParam(value = "from", required = true) String fromDate,
			@RequestParam(value = "to", required = true) String toDate) {
		LocalDate startDate = LocalDate.parse(fromDate);
		LocalDate endDate = LocalDate.parse(toDate);

		return ReservationService.getInstance().getReservationsByDateRange(startDate, endDate);
	}

	@RequestMapping("/test")
	public String reservationTest() {
		return "Test value";
	}

	@RequestMapping(value = "/test1/{id}", method = RequestMethod.GET)
	public String reservationTest(@PathVariable("id") long id) {
		return "Another one. This time with param = " + id;
	}

}
