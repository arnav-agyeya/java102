
package com.survival.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.survival.entities.Reservation;

public interface ReservationService {

/*public Reservation searchReservation(String userEmail) throws SQLException;
		
	public ResultSet getAllReservations() throws SQLException;
	
	public boolean updateReservation(String userEmail) throws SQLException;
}
*/	
	
	/**ADD BOOKING DETAILS
	 * @param reservation
	 * @return
	 * @throws SQLException
	 */
	public boolean bookHotel(Reservation reservation) throws SQLException;
	
	/**SHOW BOOKINGS MADE BY A PARTICULAR USER
	 * @param u_id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Reservation> checkBooking(int u_id)throws SQLException;
	
	/**SHOW ALL THE BOOKINGS
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllBookings()throws SQLException;
	
	/**UPDATE STATUS OF BOOKING
	 * @param u_id
	 * @return
	 * @throws SQLException
	 */
	public boolean updateBooking(int u_id)throws SQLException;
	
	/**CHECK IF ROOMS ARE AVAILABLE BETWEEN A PARTICULAR DATE
	 * @param reservation
	 * @return
	 * @throws SQLException
	 */
	public boolean checkAvailablity(Reservation reservation)throws SQLException;
	
	/**CHECK THE NUMBER OF BOOKINGS MADE BY A PERSON
	 * @param u_id
	 * @return
	 * @throws SQLException
	 */
	public int checkNoOfBooked(int u_id)throws SQLException;
	
	public int maxReservationId()throws SQLException;
	
	public int getHid(int pid);
	
	
}

