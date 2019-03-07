package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Vino;
import util.DriverManagerConnectionPool;

public class VinoManager {
	
	private static final String FINDBYID = "SELECT * FROM vino WHERE id = ?";
	private static final String FINDALL = "SELECT * FROM vino";
	private static final String INSERT = "INSERT INTO vino(id_vino, descrizione, immagine, centilitri, prezzo, vino_sfuso_nome, vino_sfuso_anno)" +
						"VALUES (? ,?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM vino WHERE id_vino = ?";	
	
	
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
				
				/* da modificare */
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
				bean.setVinoSfusoAnno("vino_sfuso_anno");
				bean.setVinoSfusoNome("vino_sfuso_nome");
				
				/* da modificare */
				bean.setImmagine("immagine");
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

	public void insert(Vino vino) throws SQLException {
		Connection con = DriverManagerConnectionPool.getConnection(DriverManagerConnectionPool.DATABASE, DriverManagerConnectionPool.USERNAME, DriverManagerConnectionPool.PASSWORD);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(INSERT);
			ps.setString(1, vino.getIdVino());
			ps.setString(2, vino.getDescrizione());
			
			/* da modificare */
			ps.setString(3, vino.getImmagine());
			
			ps.setDouble(4, vino.getCentilitri());
			ps.setDouble(5, vino.getPrezzo());
			ps.setString(6, vino.getVinoSfusoNome());
			ps.setString(7, vino.getVinoSfusoAnno());
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

