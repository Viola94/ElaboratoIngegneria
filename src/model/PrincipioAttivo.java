package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PrincipioAttivo {
	protected static Connection c = null;
    protected static Statement stmt = null;
	private String nome;
	
	public PrincipioAttivo(String nome){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrincipioAttivo;" );
		      while ( rs.next() ) {
		         if(nome==rs.getString(1)){
		        	 this.nome=nome;
		        	 break;
		         }
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrincipioAttivo "
		      		+ "SET Nome='"+ k +"' WHERE Nome='"+ this.nome +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.nome=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public String toString(){
		return "Principio Attivo"+this.nome;
	}
	
	public static void main(String[] args) {
		

	}

}
