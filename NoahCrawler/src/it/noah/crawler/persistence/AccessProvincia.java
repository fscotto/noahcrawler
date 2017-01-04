package it.noah.crawler.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.noah.crawler.model.Provincia;

public class AccessProvincia {

	public void insertProvince(List<Provincia> province) throws SQLException {
		Connection conn = null;
		PreparedStatement regioni = null;
		PreparedStatement stmt = null;
		ResultSet regione = null;

		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
			for (Provincia provincia : province) {
				regioni = conn.prepareStatement(
						"select id from regioni where nome = ?");
				regioni.setString(1, provincia.getRegione());
				regione = regioni.executeQuery();
				regione.next();
				stmt = conn.prepareStatement(
						"insert into province (idRegione, nome, sigla) values (?, ?, ?)");
				stmt.setInt(1, regione.getInt("id"));
				stmt.setString(2, provincia.getNome());
				stmt.setString(3, provincia.getSigla());
				stmt.executeUpdate();
				if (stmt != null && regione != null) {
					regione.close();
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
