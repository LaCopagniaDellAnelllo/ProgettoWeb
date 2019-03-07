package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Utente;
import util.DriverManagerConnectionPool;

public class UtenteManager {

	private static final String TABLE = "utente";
	
	private static final String FINDBYID = "SELECT * FROM " + TABLE + " WHERE id_utente = ?";
	private static final String FINDALL = "SELECT * FROM " + TABLE;
	private static final String INSERT = "INSERT INTO " + TABLE + "(id_utente, nome, cognome, username, password, e_mail, admin)" +
						"VALUES (? ,?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM " + TABLE + " WHERE id_utente = ?";	
	
	public Utente findById(String id) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		Utente bean = new Utente();
		try {
			ps = con.prepareStatement(FINDBYID);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bean.setIdUtente(rs.getString("id_utente"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setUsername(rs.getString("username"));
				bean.setMail(rs.getString("e_mail"));
				bean.setPassword(rs.getString("password"));
				bean.setAdmin(rs.getBoolean("admin"));
			}
		} finally {
			try {
				if(ps != null)
					ps.close();
			 } finally {
				DriverManagerConnectionPool.releaseConnection(con);
			 }	
		}
		return bean;
	}

	public List<Utente> findAll() throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		List<Utente> lista = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(FINDALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente bean = new Utente();
				bean.setIdUtente(rs.getString("id_utente"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setUsername(rs.getString("username"));
				bean.setMail(rs.getString("e_mail"));
				bean.setPassword(rs.getString("password"));
				bean.setAdmin(rs.getBoolean("admin"));

				lista.add(bean);
			}
			
		} finally {
			try {
				if(ps != null)
					ps.close();
			 } finally {
				DriverManagerConnectionPool.releaseConnection(con);
			 }
		}
		return lista;
	}

	public void insert(Utente bean) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(INSERT);
			ps.setString(1, bean.getIdUtente());
			ps.setString(2, bean.getNome());
			ps.setString(3, bean.getCognome());
			ps.setString(4, bean.getUsername());
			ps.setString(5, bean.getPassword());
			ps.setString(6, bean.getMail());
			ps.setBoolean(7, bean.isAdmin());
			
			ps.executeUpdate();	
		} finally {
			try {
				if(ps != null)
					ps.close();
			 } finally {
				DriverManagerConnectionPool.releaseConnection(con);
			 }
		}
		
	}

	public void delete(String id) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(DELETE);
			ps.setString(1, id);
			ps.executeUpdate();
		} finally {
			try {
				if(ps != null)
					ps.close();
			 } finally {
				DriverManagerConnectionPool.releaseConnection(con);
			 }
		}
	}
	
}
