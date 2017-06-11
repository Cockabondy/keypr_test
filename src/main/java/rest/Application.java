package rest;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Reservation;

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

	// read
	// delete
	// those methods currently would work only by equals. Required all fields.
	// It's better to create map (but we don't have business logic which will tell us what exactly we can pair).
	// meaning that every value might be unique, so we won't be able to process anything. Need to stick with some IDs.

	// update work also by equals (for simplicity). So need to provide all initial fields.
	@RequestMapping(value = "/read/", method = RequestMethod.GET)
	public String readReservation(@RequestParam(value = "roomId", required = true) int roomId,
			@RequestParam(value = "name", required = true) String guestFirstName,
			@RequestParam(value = "surname", required = true) String guestSecondName,
			@RequestParam(value = "from", required = true) String fromDate,
			@RequestParam(value = "to", required = true) String toDate) {
		LocalDate startDate = LocalDate.parse(fromDate);
		LocalDate endDate = LocalDate.parse(toDate);

		return ReservationService.getInstance().readReservation(new Reservation(guestFirstName, guestSecondName, roomId, startDate, endDate));
	}

	// update work also by equals (for simplicity). So need to provide all initial fields.
	@RequestMapping(value = "/update/", method = RequestMethod.GET)
	public String updateReservation(@RequestParam(value = "originalRoomId", required = true) int originalRoomId,
			@RequestParam(value = "originalName", required = true) String originalGuestFirstName,
			@RequestParam(value = "originalSurname", required = true) String originalGuestSecondName,
			@RequestParam(value = "originalFrom", required = true) String originalFromDate,
			@RequestParam(value = "originalTo", required = true) String originalToDate,
			@RequestParam(value = "roomId", required = false) int roomId,
			@RequestParam(value = "name", required = false) String guestFirstName,
			@RequestParam(value = "surname", required = false) String guestSecondName,
			@RequestParam(value = "from", required = false) String fromDate,
			@RequestParam(value = "to", required = false) String toDate) {
		LocalDate startDate = LocalDate.parse(fromDate);
		LocalDate endDate = LocalDate.parse(toDate);

		return ReservationService.getInstance()
				.updateReservation(
						new Reservation(originalGuestFirstName, originalGuestSecondName, originalRoomId, LocalDate.parse(originalFromDate), LocalDate.parse(originalToDate)),
						guestFirstName, guestSecondName, roomId, startDate, endDate);
	}

	// update work also by equals (for simplicity). So need to provide all initial fields.
	@RequestMapping(value = "/delete/", method = RequestMethod.GET)
	public String deleteReservation(@RequestParam(value = "roomId", required = true) int roomId,
			@RequestParam(value = "name", required = true) String guestFirstName,
			@RequestParam(value = "surname", required = true) String guestSecondName,
			@RequestParam(value = "from", required = true) String fromDate,
			@RequestParam(value = "to", required = true) String toDate) {
		LocalDate startDate = LocalDate.parse(fromDate);
		LocalDate endDate = LocalDate.parse(toDate);

		return ReservationService.getInstance().deleteReservation(new Reservation(guestFirstName, guestSecondName, roomId, startDate, endDate));
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
		return "Test";
	}

}
