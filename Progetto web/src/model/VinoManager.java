package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Vino;
import util.DriverManagerConnectionPool;

public class VinoManager {
	
	private static final String TABLE = "vino";
	
	private static final String FINDBYID = "SELECT * FROM " + TABLE + " WHERE id = ?";
	private static final String FINDALL = "SELECT * FROM " + TABLE;
	private static final String INSERT = "INSERT INTO " + TABLE + "(id_vino, descrizione, immagine, centilitri, prezzo, vino_sfuso_nome, vino_sfuso_anno)" +
						"VALUES (? ,?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM " + TABLE + " WHERE id_vino = ?";	
	
	public VinoManager() {
		
	}
	
	
	public Vino findById(String id) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		Vino bean = new Vino();
		try {
			ps = con.prepareStatement(FINDBYID);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bean.setIdVino(rs.getString("id_vino"));
				bean.setCentilitri(rs.getDouble("centilitri"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setVinoSfusoAnno("vino_sfuso_anno");
				bean.setVinoSfusoNome("vino_sfuso_nome");
				bean.setImmagine("immagine");
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
	
	public List<Vino> findAll() throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		List<Vino> lista = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(FINDALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vino bean = new Vino();
				bean.setIdVino(rs.getString("id_vino"));
				bean.setCentilitri(rs.getDouble("centilitri"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setVinoSfusoAnno(rs.getString("vino_sfuso_anno"));
				bean.setVinoSfusoNome(rs.getString("vino_sfuso_nome"));			
				bean.setImmagine(rs.getString("immagine"));
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

	public void insert(Vino bean) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(INSERT);
			ps.setString(1, bean.getIdVino());
			ps.setString(2, bean.getDescrizione());
			ps.setString(3, bean.getImmagine());
			ps.setDouble(4, bean.getCentilitri());
			ps.setDouble(5, bean.getPrezzo());
			ps.setString(6, bean.getVinoSfusoNome());
			ps.setString(7, bean.getVinoSfusoAnno());
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

