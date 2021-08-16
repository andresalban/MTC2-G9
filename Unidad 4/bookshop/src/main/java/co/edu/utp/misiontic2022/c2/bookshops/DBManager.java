package co.edu.utp.misiontic2022.c2.bookshops;

import java.io.File;
import java.sql.*;
import java.util.List;

public class DBManager implements AutoCloseable {
    private static final String DATABASE_LOCATION = "BookShop.db";
    private Connection connection;

    public DBManager() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {

        String url = "jdbc:sqlite:" + DATABASE_LOCATION;
        try {
            connection = DriverManager.getConnection(url);
            File fileDB = new File(DATABASE_LOCATION);
            if (fileDB.length() == 0) {
                var stmt = this.connection.createStatement();
                stmt.execute("CREATE TABLE books(id INTEGER  NOT NULL PRIMARY KEY ,tittle VARCHAR(20) NOT NULL ,isbn " +
                        "varchar(10) NOT NULL ,years INTEGER (4) NOT NULL );");


            }
        } catch (SQLException e) {
            System.out.println("Error de conexion : " + e);
        }
    }

    /**
     * Close the connection to the database if it is still open.
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param book The book object.
     * @return The number of units in stock, or 0 if the book does not
     * exist in the database.
     * @throws SQLException If somthing fails with the DB.
     */
    public int getStock(Book book) throws SQLException {
        return getStock(book.getId());
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param bookId The book identifier in the database.
     * @return The number of units in stock, or 0 if the book does not
     * exist in the database.
     */
    public int getStock(int bookId) throws SQLException {
        // TODO: program this method
        return 0;
    }

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
        // TODO: program this method
        Book book = null;
        Connection connection = this.connection;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            var sql = "SELECT id,tittle,isb,years FROM books WHERE isbn=?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, isbn);
            rs = stmt.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("isbn"),
                        rs.getInt("years")
                );
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL- " + e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return book;
    }

    /**
     * Sell a book.
     *
     * @param book  The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     * (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    /**
     * Sell a book.
     *
     * @param book  The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     * (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int book, int units) throws SQLException {
        // TODO: program this method
        return false;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        // TODO: program this method
        //return new ArrayList<Book>();
    return null;
    }
}




