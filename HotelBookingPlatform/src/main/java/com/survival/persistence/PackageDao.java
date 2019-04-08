package com.survival.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.survival.entities.*;
import com.survival.entities.Package;

public interface PackageDao 
{
	
		Package getRecord(int packageID) throws ClassNotFoundException,SQLException;
		boolean insertRecord(Package pack) throws ClassNotFoundException,SQLException;
		boolean deleteRecord(int pID) throws ClassNotFoundException,SQLException;
		ResultSet getAllRecord(String location) throws ClassNotFoundException,SQLException;
		ResultSet getAllRecords(int ptype) throws ClassNotFoundException,SQLException;
    ResultSet getAllRecord() throws ClassNotFoundException,SQLException;
	

}
