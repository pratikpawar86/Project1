package com.example.cctvbackendservice.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;



















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cctvbackendservice.config.JdbcConnection;
import com.example.cctvbackendservice.entity.ContactUS;
import com.example.cctvbackendservice.entity.ResponseStatus;








@Service
public class CcctvService {

	@Autowired
	JdbcConnection jdbcConnection;

	public ResponseEntity<?> createContactUsService(ContactUS createContactUs) {

		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		ResponseStatus responseStatus = new ResponseStatus();

		try {
			connection = jdbcConnection.getConnection();

			connection.setAutoCommit(false);

			callableStatement = connection.prepareCall("{ ? = call create_contact_us(?,?,?) }");

			callableStatement.registerOutParameter(1, Types.OTHER);

			callableStatement.setString(2, createContactUs.getName());

			callableStatement.setString(3, createContactUs.getMobileNumber());

			callableStatement.setString(4, createContactUs.getMessage());

			callableStatement.execute();

			resultSet = (ResultSet) callableStatement.getObject(1);

			while (resultSet.next()) {
				Boolean status = resultSet.getBoolean("status");

				String message = resultSet.getString("message");

				System.out.println(status);
				System.out.println(message);

				responseStatus.setStatus(status);
				responseStatus.setMessage(message);

			}

			System.err.println(responseStatus);
			connection.commit();

			return ResponseEntity.ok(responseStatus);

		} catch (Exception e) {

			e.printStackTrace();

			try {

				if (connection != null) {
					connection.rollback();
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			return ResponseEntity.internalServerError().body(e.getMessage());

		} finally {

			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (callableStatement != null) {
					callableStatement.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getLead() {

		Connection connection = jdbcConnection.getConnection();

		System.out.println(connection);
		return "Lead";
	}

}
