
package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.survival.entities.Reservation;



public interface ReservationDao {

	
	
	/**ENTER RESERVATION DETAILS
	 * @param reservation
	 * @return
	 * @throws SQLException
	 */
	public boolean insertReservation(Reservation reservation) throws SQLException;
	
	/**GET ALL RESERVATIONS OF A PARTICULAR USER
	 * @param u_id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Reservation> searchAllReservation(int u_id) throws SQLException;
		
	/**CHECK THE NUMBER OF RESERVATIONS MADE BY A USER
	 * @param u_id
	 * @return
	 * @throws SQLException
	 */
	public int noOfReservation(int u_id) throws SQLException;
	
	/**GET ALL THE RESERVATIONS 
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getAllReservations() throws SQLException;
	
	/**CHANGE STATUS OF RESERVATION
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean updateReservation(int id) throws SQLException;
	
	/**CHECK IF ROOMS ARE AVAILABLE FOR BOOKING
	 * @param reservation
	 * @return
	 * @throws SQLException
	 */
	public boolean checkAvailable(Reservation reservation)throws SQLException;
	
	public  int getMaxReservationId();
	
	public int getHotelId(int pid);
	
}
