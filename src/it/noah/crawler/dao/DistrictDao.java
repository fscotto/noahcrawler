package it.noah.crawler.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.noah.crawler.model.District;

public class DistrictAccess {

	public void insertDistricts(List<District> districts) throws SQLException {
		Connection conn = null;
		PreparedStatement regions = null;
		PreparedStatement stmt = null;
		ResultSet region = null;

		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			for (District district : districts) {
				regions = conn.prepareStatement(
						"select id from regioni where nome = ?");
				regions.setString(1, district.getRegion());
				region = regions.executeQuery();
				region.next();
				stmt = conn.prepareStatement(
						"insert into province (idRegione, nome, sigla) values (?, ?, ?)");
				stmt.setInt(1, region.getInt("id"));
				stmt.setString(2, district.getName());
				stmt.setString(3, district.getInitial());
				stmt.executeUpdate();
				if (stmt != null && region != null) {
					region.close();
					stmt.close();
				}
			}
			conn.commit();
		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
