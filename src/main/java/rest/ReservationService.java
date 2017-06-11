package rest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import entity.Reservation;

public class ReservationService {

	private static ReservationService service;
	private static List<Reservation> reservationList;
	private static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
	
	static {
		//Initialize some default values for usage (it's easier to use some kind of in-memory data for testing)
		reservationList = new ArrayList<>();
		reservationList.add(new Reservation("Error", "Server", 404, LocalDate.of(1999, 1, 1), LocalDate.of(2001, 1, 1)));
		reservationList.add(new Reservation("Arnold", "Schwarz", 3, LocalDate.of(2017, 7, 13), LocalDate.of(2017, 9, 15)));
		reservationList.add(new Reservation("My", "Mom", 12, LocalDate.of(2017, 6, 11), LocalDate.of(2017, 6, 21)));
	}

	/**
	 * Gets the single instance of ReservationService to manage Reservation instances.
	 *
	 * @see com.mybookingpal.shared.Reservation
	 *
	 * @return single instance of ReservationService
	 */
	public static synchronized ReservationService getInstance() {
		if (service == null) {
			synchronized (ReservationService.class) {
				if (service == null) {
					service = new ReservationService();
				}
			}
		}
		return service;
	}

	public String getReservationsByDateRange(LocalDate startDate, LocalDate endDate) {
		List<Reservation> resultList = reservationList.stream().filter(r -> inDateRange(startDate, endDate, r))
				.collect(Collectors.toList());

		return resultList.toString();
	}

	private boolean inDateRange(LocalDate startDate, LocalDate endDate, Reservation r) {
		return !r.getStartDate().isBefore(startDate) && !r.getEndDate().isAfter(endDate);
	}

	public String listReservations() {
		return Arrays.toString(reservationList.toArray());
	}

	public String createReservation(String guestFirstName, String guestSecondName, Integer roomNumber, LocalDate startDate, LocalDate endDate) {
		reservationList.add(new Reservation(guestFirstName, guestSecondName, roomNumber, startDate, endDate));
		return "Your reservation succesfully created!";
	}

	// TODO: maybe use Optional to generate response.
	public String updateReservation(String guestFirstName, String guestSecondName, Integer roomNumber, LocalDate startDate, LocalDate endDate) {
		if (true) {
			// if found reservation, return successful response
		} else {
			// otherwise tell that could not find any matching entries.
		}
		return "";
	}
	
	public String deleteReservation(String guestFirstName, String guestSecondName, Integer roomNumber, LocalDate startDate, LocalDate endDate) {
		if (true) {
			// if found reservation, return successful response
		} else {
			// otherwise tell that could not find any matching entries.
		}
		return "";
	}
}
