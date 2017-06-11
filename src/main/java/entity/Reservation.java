package entity;

import java.time.LocalDate;

public class Reservation {

	private String guestFirstName;
	private String guestSecondName;
	private int roomNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public Reservation() {
		super();
	}

	public Reservation(String guestFirstName, String guestSecondName, int roomNumber, LocalDate startDate, LocalDate endDate) {
		super();
		this.guestFirstName = guestFirstName;
		this.guestSecondName = guestSecondName;
		this.roomNumber = roomNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getGuestFirstName() {
		return guestFirstName;
	}

	public void setGuestFirstName(String guestFirstName) {
		this.guestFirstName = guestFirstName;
	}

	public String getGuestSecondName() {
		return guestSecondName;
	}

	public void setGuestSecondName(String guestSecondName) {
		this.guestSecondName = guestSecondName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [guestFirstName=" + guestFirstName + ", guestSecondName=" + guestSecondName + ", roomNumber=" + roomNumber + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
