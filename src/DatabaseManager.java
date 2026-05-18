import java.sql.*;

public class DatabaseManager{
   static void initializeDatabase(Connection conn) throws SQLException{
       String sql = """
               CREATE TABLE IF NOT EXISTS items(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    quantity INTEGER NOT NULL,
                    price REAL NOT NULL
               );
               
               """;

       Statement stmt = conn.createStatement();
       stmt.execute(sql);
       System.out.println("Database created successfully");
   }
   public static void addItem(Connection conn, Item item ) throws SQLException{
       var sql = "INSERT INTO items(name, quantity, price) VALUES (?, ?, ?)";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1, item.getName());
       stmt.setInt(2, item.getQuantity());
       stmt.setDouble(3, item.getPrice());
       stmt.executeUpdate();

       System.out.println("Item added successfully");

   }
   static void viewItems(Connection conn) throws SQLException, InterruptedException {
       String sql = "SELECT * FROM items;";
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(sql);

       System.out.println("********** Current Inventory **********");
       boolean empty = true;
      while (rs.next()) {
          empty = false;
          System.out.printf("Item: %s | Quantity: %d | Price: $%.2f\n",
                  rs.getString("name"),
                  rs.getInt("quantity"),
                  rs.getDouble("price"));
           }
      if (empty) System.out.println("Inventory is empty");
      Thread.sleep(2000);
       }
       static void removeItem(Connection conn, String name) throws SQLException, InterruptedException {
       String sql = "DELETE FROM items WHERE name = ?";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1, name);
       int rows = stmt.executeUpdate();

       if (rows > 0) {
           System.out.println("Item has been removed successfully");
           Thread.sleep(2000);
             }

       else{
           System.out.println("Item not found in inventory");
           Thread.sleep(2000);
        }
       }

   }

