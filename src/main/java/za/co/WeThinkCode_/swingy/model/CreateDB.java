package za.co.WeThinkCode_.swingy.model;

//sqlite3 mydatabase.db to create a new database

import java.sql.*;


public class CreateDB {

    Statement stm = null;
    Connection conn = null;
    CreateDB() {
        try {
            String url = "jdbc:sqlite:C:/Users/VladNazam/OneDrive/Desktop/wtc/swingy/SwingyDB.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("what the hell"+e.getMessage());
        }
    }

    public void ListDB() throws SQLException {
        this.stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Swing");

        while(rs.next()) {
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

    public void executeQ(String query) throws SQLException {
        this.stm = conn.createStatement();
        stm.executeQuery(query);
    }

    public void executeU(String query) throws SQLException {
        this.stm = conn.createStatement();
        stm.executeUpdate(query);
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

//    public static void main(String[] args) throws SQLException {
//        String query = "DELETE FROM Swing WHERE Id = '3'";
//        CreateDB db = new CreateDB();
//        System.out.println("this is before\n");
//        db.ListDB();
////        execute update to delete and execute query to select
////        db.executeQ(query);
////        db.executeU(query);
//        System.out.println("this is after\n");
//        db.ListDB();
//        db.closeConn();
//    }
}