package co.edu.utp.misiontic2022.c2.bookshops;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
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
                stmt.execute("CREATE TABLE books(id INTEGER  NOT NULL PRIMARY KEY ,title VARCHAR(100) NOT NULL ,isbn" +
                        " varchar(10) NOT NULL ,years INTEGER (4) NOT NULL );");

                String sqlDatos = "INSERT INTO books (id,title,isbn,years) Values(?,?,?,?)";
                PreparedStatement PreStmt = this.connection.prepareStatement(sqlDatos);

                PreStmt.setInt(1, 1);
                PreStmt.setString(2, "El coronel no tiene quien le escriba");
                PreStmt.setString(3, "0101");
                PreStmt.setInt(4, 1976);

                PreStmt.executeUpdate();


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
        var cantidad = 0;
        connect();

        //Connection connection =this.connection;
        PreparedStatement PreStmt = null;
        ResultSet rs = null;
        try {
            String sqlStock = "SELECT COUNT(id)as cantidad FROM books WHERE id=? LIMIT 1";
            PreStmt = connection.prepareStatement(sqlStock);
            PreStmt.setInt(1, bookId);
            rs = PreStmt.executeQuery();

            if (rs.next()) {
                cantidad = rs.getInt(1);

            }


        } catch (SQLException e) {
            System.out.println("" + e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return cantidad;
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

        connect();
        //Connection connection = this.connection;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,title,isbn,years FROM books WHERE isbn=?";
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
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
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
        boolean validarLibro = false;
        var unidades = this.getStock(book);

        if (unidades >= units) {
            validarLibro = true;
        } else {
            validarLibro = false;
        }

        return validarLibro;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        // TODO: program this method
        var listaBook = new ArrayList<Book>();
        connect();
        //Connection connection = this.connection;
        PreparedStatement PreStmt = null;
        ResultSet rs = null;

        try {
            String sqlLista = "SELECT id, title,isbn,years FROM books";
            PreStmt = connection.prepareStatement(sqlLista);
            rs = PreStmt.executeQuery();

            while (rs.next()) {
                var myBook = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("isbn"),
                        rs.getInt("years")
                );
                listaBook.add(myBook);
            }

        } catch (SQLException e) {
            System.out.println("ErrorDB-:" + e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (PreStmt != null) {
                PreStmt.close();
            }
        }

        return listaBook;
    }

    public Book save(String title, String isbn, int year) throws SQLException {
        Book myBook = null;
        var nuevoConsecutivo = consecutivo();

        connect();
        PreparedStatement PreStmt = null;
        try {
            myBook = new Book(
                    nuevoConsecutivo,
                    title,
                    isbn,
                    year
            );

            String sqlCrearLibro = "INSERT INTO books (id,title,isbn,years) Values(?,?,?,?)";
            PreStmt = connection.prepareStatement(sqlCrearLibro);

            PreStmt.setInt(1, nuevoConsecutivo);
            PreStmt.setString(2, myBook.getTitle());
            PreStmt.setString(3, myBook.getIsbn());
            PreStmt.setInt(4, myBook.getYear());

            PreStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("" + e);
        } finally {
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return myBook;
    }

    public int consecutivo() throws SQLException {
        var maximo = 1;
        connect();
        PreparedStatement PreStmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT MAX(ID) AS mayor FROM books LIMIT 1; ";
            PreStmt = connection.prepareStatement(sql);

            rs = PreStmt.executeQuery();

            if (rs.next()) {
                maximo += rs.getInt("mayor");

            }

        } catch (SQLException e) {
            System.out.println("EEE" + e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return maximo;
    }

    public Book update(int id, String title, String isbn, int year) throws SQLException {
        Book myBook = null;

        connect();
        PreparedStatement PreStmt = null;

        try {
            myBook = new Book(
                    id,
                    title,
                    isbn,
                    year
            );
            String sqlUpdate = "UPDATE books SET title=?,isbn=?,years=? WHERE id=?";
            PreStmt = connection.prepareStatement(sqlUpdate);

            PreStmt.setString(1, myBook.getTitle());
            PreStmt.setString(2, myBook.getIsbn());
            PreStmt.setInt(3, myBook.getYear());
            PreStmt.setInt(4, myBook.getId());

            PreStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR--" + e);
        } finally {
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return myBook;
    }

    public boolean delete(int id) throws SQLException {
        boolean resultado =false;

        connect();
        PreparedStatement PreStmt = null;

        try {
            String sqlDelete = "DELETE FROM books WHERE id=?";
            PreStmt = connection.prepareStatement(sqlDelete);
            PreStmt.setInt(1, id);

            PreStmt.executeUpdate();
            resultado =true;

        } catch (SQLException e) {
            System.out.println("ERROR--" + e);
        } finally {
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultado;
    }

    public String deleteString(int id) throws SQLException {
        String resultado = "";

        connect();
        PreparedStatement PreStmt = null;

        try {
            String sqlDelete = "DELETE FROM books WHERE id=?";
            PreStmt = connection.prepareStatement(sqlDelete);
            PreStmt.setInt(1, id);

            PreStmt.executeUpdate();
            resultado ="Libro eliminado correctamente";

        } catch (SQLException e) {
            System.out.println("ERROR--" + e);
        } finally {
            if (PreStmt != null) {
                PreStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultado;
    }

}






