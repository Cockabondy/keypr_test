package entity;

import java.time.LocalDate;

public class Reservation {

	private String guestFirstName;
	private String guestSecondName;
	private Integer roomNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public Reservation() {
		super();
	}

	public Reservation(String guestFirstName, String guestSecondName, Integer roomNumber, LocalDate startDate, LocalDate endDate) {
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

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((guestFirstName == null) ? 0 : guestFirstName.hashCode());
		result = prime * result + ((guestSecondName == null) ? 0 : guestSecondName.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (guestFirstName == null) {
			if (other.guestFirstName != null)
				return false;
		} else if (!guestFirstName.equals(other.guestFirstName))
			return false;
		if (guestSecondName == null) {
			if (other.guestSecondName != null)
				return false;
		} else if (!guestSecondName.equals(other.guestSecondName))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [guestFirstName=" + guestFirstName + ", guestSecondName=" + guestSecondName + ", roomNumber=" + roomNumber + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
