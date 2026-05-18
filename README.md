Inventory Management System  
(Terminal Only)  
A program that utilizes arraylists to allow the user to store item names, quantities, and prices. The user may also remove items from the inventory and view them as well.

Built as a beginner Java project to practice ArrayLists (used in earlier versions),
object-oriented design, and terminal-based user interaction, and SQLite database implementation.

Example of menu:  
***************************
Inventory Management System
***************************
1. Add item to inventory
2. Remove item from inventory
3. View all items in inventory
4. Exit  
   What would you like to do:  
***********
Example of inventory view:  
********** Current Inventory **********  
Item: computer | Quantity: 10 | Price: \$1000.00  
Item: desk | Quantity: 5 | Price: \$300.00  
Item: office chair | Quantity: 15 | Price: \$350.00  
*******
Prerequisites:  
JDK 17 or higher 
*****
How to run this program:  
1. Clone the repository using Git:  
git clone https://github.com/Sarthi267/Inventory-Management-System-Terminal-.git
2. Then, move into the project directory:  
cd Inventory-Management-System-Terminal-
3. Download the SQLite JDBC driver:
      https://github.com/xerial/sqlite-jdbc/releases
      Download sqlite-jdbc-3.53.1.0.jar and place it in a /libs folder
4. Compile:   
javac -cp libs/sqlite-jdbc-3.53.1.0.jar *.java
5. Run (On windows the "." separator changes to ";"):  
 java -cp .:libs/sqlite-jdbc-3.53.1.0.jar Main
