package co.edu.utp.misiontic2022.c2.bookshops;

import org.sqlite.core.DB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class BookShop {

    private final BufferedReader input;

    public BookShop() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        var mainLoop = true;
        while (mainLoop) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println(" Gestor de Librería");
            System.out.println("==========================================");
            System.out.println("1. Listado de libros");
            System.out.println("2. Busqueda de libro");
            System.out.println("3. Consulta de existencias");
            System.out.println("4. Venta de libros");
            System.out.println("5. Agregar  libros");
            System.out.println("6. Modificar libros");
            System.out.println("7. Eliminar libros");
            System.out.println("0. Salir");
            System.out.println("==========================================");
            System.out.print("Ingrese su opción: ");
            try {
                var opcion = Integer.valueOf(input.readLine());
                switch (opcion) {
                    case 0:
                        mainLoop = false;
                        break;
                    case 1:
                        listadoLibros();
                        break;
                    case 2:
                        busquedaLibro();
                        break;
                    case 3:
                        consultaExistencias();
                        break;
                    case 4:
                        venta();
                        break;
                    case 5:
                        agregarLibros();
                        break;
                    case 6:
                        modificarLibros();
                        break;
                    case 7:
                        eliminarLibros();
                        break;

                    default:
                        System.err.println("Opción no válida");
                }
            } catch (NumberFormatException | IOException e) {
                System.err.println("Ha ocurrido un error: " + e);
            }
        }
    }


    private void listadoLibros() {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Listado de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            var books = manager.listBooks();
            books.forEach(System.out::println);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void busquedaLibro() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Búsqueda de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();

            Book book = manager.searchBook(isbn);
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void consultaExistencias() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Consulta de existencias");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();

            Book book = manager.searchBook(isbn);
            if (book != null) {
                int units = manager.getStock(book);
                System.out.println("Hay " + units + " copias de " + book);
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void venta() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Venta de libros");
        System.out.println("==========================================");
        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a consultar: ");
            var isbn = input.readLine();
            System.out.print("Ingrese la cantidad a vender: ");
            var units = Integer.valueOf(input.readLine());

            Book book = manager.searchBook(isbn);
            if (book != null) {
                boolean success = manager.sellBook(book, units);
                if (success) {
                    System.out.println("Libro vendido: " + units + " copias de " + book);
                } else {
                    System.out.println("No existen suficientes (" + units + ") copias de " + book);
                }
            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void agregarLibros() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Agregar libros");
        System.out.println("==========================================");


        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro");
            var isbn = input.readLine();

            System.out.print("Ingrese el TITULO del libro");
            var title = input.readLine();

            System.out.print("Ingrese el AÑO del libro");
            var year = Integer.valueOf(input.readLine());

            Book sBook = manager.save(title, isbn, year);
            if (sBook != null) {
                System.out.println("Libro Guardado Correctamente:" + sBook);
            } else {
                System.out.println("Libro No Guardado" + isbn);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }

    private void modificarLibros() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Modificar libros");
        System.out.println("==========================================");

        try (var manager = new DBManager()) {

            System.out.print("Ingrese el ISBN a modificar: ");
            var isbn = input.readLine();

            Book sBook = manager.searchBook(isbn);

            if (sBook != null) {
                var myId = sBook.getId();

                System.out.println("Modificar el TITULO del libro " + sBook.getTitle() + ": ");
                var myTitle = input.readLine();

                System.out.println("Modificar el ISBN del libro " + sBook.getIsbn() + ": ");
                var myIsbn = input.readLine();

                System.out.println("Modificar el AÑO del libro " + sBook.getYear() + ": ");
                var myYear = Integer.valueOf(input.readLine());

                Book myBook = manager.update(myId, myTitle, myIsbn, myYear);

                if (myBook != null) {
                    System.out.println("El libro fue modificado correctamente:" + myBook);
                } else {
                    System.out.println("Libro no modificado");
                }

            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }

    }

    private void eliminarLibros() throws IOException {
        System.out.println("");
        System.out.println("==========================================");
        System.out.println(" Elimnar libros");
        System.out.println("==========================================");

        try (var manager = new DBManager()) {
            System.out.print("Ingrese el ISBN del libro a eliminar: ");
            var isbn = input.readLine();

            Book book = manager.searchBook(isbn);

            if (book != null) {
                System.out.println("Desea eliminar el libre " + book.getTitle() + "(Y/N)");
                var confirmar = input.readLine();

                if (confirmar.equals("Y")) {
                    var rs = manager.delete(book.getId());
                    if (rs) {
                        System.out.print("Libro ELIMINADO correctamente");
                    } else {
                        System.out.print("Libro NO fue eliminado");
                    }
                }

            } else {
                System.out.println("Libro no encontrado: " + isbn);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Excepción SQL: " + ex.getMessage());
            System.out.println("Estado SQL: " + ex.getSQLState());
            System.out.println("Código de error: " + ex.getErrorCode());
        }
    }
}