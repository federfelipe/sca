package br.cefetrj.sca.dominio;

import java.sql.SQLException;
import java.sql.Time;

//import javax.persistence.Embedded;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.mysql.jdbc.Statement;

@Entity
public class ItemHorario {
	@Id
	@GeneratedValue
	private Long id;

	private int dia_semana;
	
	private Time hora_inicio;
	
	private Time hora_fim;
	
	private int tempo;
	
	private int turno;
	
	public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        insertion();
        
     }
	
	public static void insertion() throws SQLException {
          Statement stmt = null;
          try {
              stmt = con.createStatement();
              stmt.executeUpdate(
                  "insert into " + "scadb" +
                  ".itemhorario " +
                  "values(2, 'felipe', 'diogo', 11, 22)");

              /*stmt.executeUpdate(
                  "insert into " + dbName +
                  ".COFFEES " +
                  "values('French_Roast', " +
                  "00049, 8.99, 0, 0)");*/
              
          } catch (SQLException e) {
              printSQLException(e);
          } finally {
              if (stmt != null) {
                stmt.close();
              }
          }
      }

	private static void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
/*	@Embedded
	private IntervaloTemporal tempoAula;

	@Enumerated(EnumType.ORDINAL)
	EnumDiaSemana dia;

	@SuppressWarnings("unused")
	private ItemHorario() {
	}

	public ItemHorario(EnumDiaSemana dia, IntervaloTemporal tempoAula) {
		this.tempoAula = tempoAula;
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public String getFim() {
		return this.tempoAula.getFim();
	}

	public String getInicio() {
		return this.tempoAula.getInicio();
	}
	
	public boolean colide(ItemHorario item) {
		return this.tempoAula.colide(item.tempoAula);
	}*/
}
