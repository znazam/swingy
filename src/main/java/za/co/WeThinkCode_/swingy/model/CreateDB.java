package za.co.WeThinkCode_.swingy.model;

//sqlite3 mydatabase.db to create a new database

import java.sql.*;


public class CreateDB {

    Statement stm = null;
    Connection conn = null;
    public CreateDB() {
        try {
            String url = "jdbc:sqlite:C:/Users/VladNazam/OneDrive/Desktop/wtc/swingy/SwingyDB.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("what the hell"+e.getMessage());
        }
    }

    public void ListDB(){
        try {
            this.stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Swing");

            while (rs.next()) {
                int id = rs.getInt("Id");
                int Atk = rs.getInt("Atk");
                int Def = rs.getInt("Def");
                int Dodge = rs.getInt("Dodge");
                int Exp = rs.getInt("Exp");
                int Level = rs.getInt("Level");
                int Hp = rs.getInt("Hp");
                String PlayerName = rs.getString("PlayerName");
                String CharacterName = rs.getString("CharacterName");
                String Helm = rs.getString("Helm");
                String Armour = rs.getString("Armour");
                String Weapon = rs.getString("Weapon");

                System.out.println(id + " " + Atk + " " + Def + " " + Dodge + " " + Exp + " " + Level + " " + Hp + " " + PlayerName + " " + CharacterName + " " + Helm + " " + Armour + " " + Weapon);
            }
        }
        catch (SQLException e){
            System.out.println("ListDB error occured "+e.getMessage());
        }

    }

    public void executeQ(String query){
        try {
            this.stm = conn.createStatement();
            stm.executeQuery(query);
        }
        catch (SQLException e){
            System.out.println("executeQ error occured "+e.getMessage());
        }
    }

    public void executeU(String query){
        try {
            this.stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        catch (SQLException e){
            System.out.println("executeU error occured "+e.getMessage());
        }
    }

    public void closeConn(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sql(String query, String condition){
//        query = "DELETE FROM Swing WHERE Id = '3'";
        CreateDB db = new CreateDB();
        System.out.println("this is before\n");
        db.ListDB();
//        execute update to delete and execute query to select
        if (condition.equals("add"))
            db.executeQ(query);
        else
            db.executeU(query);
        System.out.println("this is after\n");
        db.ListDB();
        db.closeConn();
    }
}
