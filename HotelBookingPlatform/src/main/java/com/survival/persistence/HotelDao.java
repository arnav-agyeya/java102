
package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.survival.entities.Hotel;

public interface HotelDao {


	/** ADD HOTEL
	 * @param hotel
	 * @return
	 * @throws SQLException
	 */
	public boolean insertHotel(Hotel hotel)throws SQLException;	
	/** REMOVE HOTEL
	 * @param hid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteHotel(Integer hid) throws SQLException;
	/** SEARCH FOR A HOTEL
	 * @param hid
	 * @return
	 * @throws SQLException
	 */
	public Hotel searchHotel(Integer hid) throws SQLException;
	
	/**RETURN ALL HOTELS
	 * @return
	 * @throws SQLException
	 */

	public ResultSet getAllHotels() throws SQLException;
	
}
