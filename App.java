import java.sql.*;

public class App {
        public static void main(String[] args) throws Exception {
                String url = "jdbc:postgresql://localhost:5432/Movie_db";
                String username = "postgres";
                String password = "password";
                try {
                        // create connection
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement statement = conn.createStatement();
                        PreparedStatement preparedStatement;
                        System.out.println("Connection established");

                        // inserting tuple to each table without parameters

                        String birthLocation = "INSERT INTO public.\"BirthLocation\" (country, city, state) VALUES ('Switzerland','Emmen', 'Lucerne')";

                        String movie = "INSERT INTO public.\"Movie\" " +
                                        "(title, release_time, release_date, rating, budget, gross) " +
                                        "VALUES ('Batman', '2010-07-16 14:00:00', '2010-07-16', 9, 160000000, 829895144)";

                        String university = "INSERT INTO public.\"University\" (name, is_private, color) " +
                                        "VALUES ('Brown University', true, 'Brown')";

                        String director = "INSERT INTO public.\"Director\" (first_name, surname, year_of_birth, \"id_BirthLocation\", \"id_Movie\", \"id_University\") "
                                        +
                                        "VALUES ('Mel', 'Brooks', 1926, 1, 1, 1)";

                        String actor = "INSERT INTO public.\"Actor\" (first_name, surname, year_of_birth, \"id_BirthLocation\", eye_color) "
                                        +
                                        "VALUES ('Emily', 'Blunt', 1980, 1, 'Green')";

                        String department = "INSERT INTO public.\"Department\" (\"id_University\", name) " +
                                        "VALUES (6, 'Engineering Department')";

                        String movieActor = "INSERT INTO public.\"MovieActor\" (\"id_Movie\", \"id_Actor\") " +
                                        "VALUES (6, 2)";

                        String genreInsert = "INSERT INTO public.\"Genre\" (type) VALUES ('Action')";

                        String movieGenre = "INSERT INTO public.\"MovieGenre\" (\"id_Movie\", \"id_Genre\") " +
                                        "VALUES (1, 4)";

                        String cinema = "INSERT INTO public.\"Cinema\" (cinema_name, location, type) " +
                                        "VALUES ('Cineplex', 'Oshawa', 'IMAX')";

                        String ticket = "INSERT INTO public.\"Ticket\" (price, \"id_Cinema\") " +
                                        "VALUES (12.99, 1)";

                        String show = "INSERT INTO public.\"ShowTime\" (show_name, show_time, show_duration, \"id_Cinema_Ticket\", \"id_Movie\") "
                                        +
                                        "VALUES ('Avengers: Endgame', '2023-12-25 19:30:00', 180, 1, 2)";

                        String award = "INSERT INTO public.\"Award\" (award_name, \"id_Movie\")  VALUES ('Oscar', 5)";

                        String category = "INSERT INTO public.\"Category\" (category_name, \"award_id_Award\", \"id_Movie_Award\") "
                                        +
                                        "VALUES ('Best Picture', 1, 101)";

                        // inserting tuple to each table with parameters
                        String birthLocation2 = "INSERT INTO public.\"BirthLocation\"(country, city, state) VALUES (?, ?, ?)";
                        preparedStatement = conn.prepareStatement(birthLocation2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Boulder");
                        preparedStatement.setString(2, "Colorado");
                        preparedStatement.setString(3, "USA");

                        String movie2 = "INSERT INTO public.\"Movie\" (title, release_time, release_date, rating, budget, gross) "
                                        + "VALUES (?, ?, ?, ?, ?, ?)";

                        preparedStatement = conn.prepareStatement(movie2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Batman2");
                        preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf("2010-07-16 14:00:00"));
                        preparedStatement.setDate(3, java.sql.Date.valueOf("2010-07-16"));
                        preparedStatement.setShort(4, (short) 9);
                        preparedStatement.setFloat(5, 160000000);
                        preparedStatement.setFloat(6, 829895144);

                        String university2 = "INSERT INTO public.\"University\"(name, is_private, color) VALUES (?, ?, ?)";
                        preparedStatement = conn.prepareStatement(university2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "University of Calgary");
                        preparedStatement.setBoolean(2, false);
                        preparedStatement.setString(3, "Yellow");

                        String director2 = "INSERT INTO public.\"Director\" (first_name, surname, year_of_birth, \"id_BirthLocation\", \"id_Movie\", \"id_University\") "
                                        +
                                        "VALUES (?, ?, ?, ?, ?, ?)";
                        preparedStatement = conn.prepareStatement(director2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "James");
                        preparedStatement.setString(2, "Cameron");
                        preparedStatement.setInt(3, 1970);
                        preparedStatement.setInt(4, 1);
                        preparedStatement.setInt(5, 1);
                        preparedStatement.setInt(6, 1);

                        String actor2 = "INSERT INTO public.\"Actor\" (first_name, surname, year_of_birth, \"id_BirthLocation\", eye_color) "
                                        +
                                        "VALUES (?, ?, ?, ?, ?)";
                        preparedStatement = conn.prepareStatement(actor2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "John");
                        preparedStatement.setString(2, "Doe");
                        preparedStatement.setInt(3, 1985);
                        preparedStatement.setInt(4, 1);
                        preparedStatement.setString(5, "hazel");

                        String department2 = "INSERT INTO public.\"Department\" (\"id_University\", name) " +
                                        "VALUES (?, ?)";

                        preparedStatement = conn.prepareStatement(department2);

                        // sets the parameters for the query
                        preparedStatement.setInt(1, 8);
                        preparedStatement.setString(2, "Music");

                        String movieActor2 = "INSERT INTO public.\"MovieActor\" (\"id_Movie\", \"id_Actor\") VALUES (?, ?)";
                        preparedStatement = conn.prepareStatement(movieActor2);

                        // sets the parameters for the query
                        preparedStatement.setInt(1, 1);
                        preparedStatement.setInt(2, 2);

                        String genre2 = "INSERT INTO public.\"Genre\" (type) VALUES (?)";
                        // sets the parameters for the query
                        preparedStatement = conn.prepareStatement(genre2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Action");

                        String movieGenre2 = "INSERT INTO public.\"MovieGenre\" (\"id_Movie\", \"id_Genre\") VALUES (?, ?)";
                        preparedStatement = conn.prepareStatement(movieGenre2);

                        // sets the parameters for the query
                        preparedStatement.setInt(1, 1);
                        preparedStatement.setInt(2, 2);

                        String cinema2 = "INSERT INTO public.\"Cinema\" (cinema_name, location, type) VALUES (?, ?, ?)";
                        preparedStatement = conn.prepareStatement(cinema2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Cineplex Toronto");
                        preparedStatement.setString(2, "Toronto, Ontario");
                        preparedStatement.setString(3, "IMAX");

                        String ticket2 = "INSERT INTO public.\"Ticket\" (price, \"id_Cinema\") VALUES (?, ?)";
                        preparedStatement = conn.prepareStatement(ticket2);

                        // sets the parameters for the query
                        preparedStatement.setDouble(1, 20.00);
                        preparedStatement.setInt(2, 1);

                        String showTime2 = "INSERT INTO public.\"ShowTime\" " +
                                        "(show_name, show_time, show_duration, \"id_Cinema_Ticket\", \"id_Movie\") " +
                                        "VALUES (?, ?, ?, ?, ?)";

                        preparedStatement = conn.prepareStatement(showTime2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Avengers: Endgame");
                        preparedStatement.setString(2, "2024-12-15 18:30:00");
                        preparedStatement.setInt(3, 180);
                        preparedStatement.setInt(4, 1);
                        preparedStatement.setInt(5, 101);

                        String award2 = "INSERT INTO public.\"Award\" (award_name, \"id_Movie\") VALUES (?, ?)";
                        preparedStatement = conn.prepareStatement(award2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Oscar");
                        preparedStatement.setInt(2, 1);

                        String category2 = "INSERT INTO public.\"Category\" (category_name, \"award_id_Award\", \"id_Movie_Award\") "
                                        +
                                        "VALUES (?, ?, ?)";
                        preparedStatement = conn.prepareStatement(category2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Best Director");
                        preparedStatement.setInt(2, 1);
                        preparedStatement.setInt(3, 101);

                        // select directors born in Canada query
                        String query1 = "SELECT first_name, surname " +
                                        "FROM public.\"Director\" AS dir " +
                                        "JOIN public.\"BirthLocation\" AS birth_loc " +
                                        "ON dir.\"id_BirthLocation\" = birth_loc.id " +
                                        "WHERE birth_loc.country = 'Canada'";

                        statement = conn.createStatement();

                        // object stores rows returned by the query
                        ResultSet resultSet = statement.executeQuery(query1);

                        // prints out result in query
                        System.out.println("Directors born in Canada:");
                        while (resultSet.next()) {
                                String firstName = resultSet.getString("first_name");
                                String surname = resultSet.getString("surname");
                                System.out.printf("%-20s %-20s\n", firstName, surname);
                        }
                        System.out.println();

                        // list movies all directed by David Lynch
                        String query2 = "SELECT mov.title " +
                                        "FROM public.\"Movie\" AS mov " +
                                        "JOIN public.\"Director\" AS dir ON mov.id = dir.\"id_Movie\" " +
                                        "WHERE dir.first_name = ? AND dir.surname = ?";
                        preparedStatement = conn.prepareStatement(query2);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "David");
                        preparedStatement.setString(2, "Lynch");

                        // object stores rows returned by the query
                        ResultSet resultSet2 = preparedStatement.executeQuery();

                        // prints out result of query
                        System.out.println("Movies by David Lynch:");
                        while (resultSet2.next()) {
                                String title = resultSet2.getString("title");
                                System.out.println(title);
                        }
                        System.out.println();

                        // list directors whose last name starts with A or D
                        String query3 = "SELECT first_name, surname " +
                                        "FROM public.\"Director\" " +
                                        "WHERE surname LIKE ? OR surname LIKE ?";

                        preparedStatement = conn.prepareStatement(query3);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "A%");
                        preparedStatement.setString(2, "D%");

                        // object stores rows returned by the query
                        ResultSet resultSet3 = preparedStatement.executeQuery();

                        // prints out result of query
                        System.out.println("Directors with surname starting with A or D:");
                        while (resultSet3.next()) {
                                String firstName = resultSet3.getString("first_name");
                                String surname = resultSet3.getString("surname");
                                System.out.printf("%-20s %-20s\n", firstName, surname);
                        }
                        System.out.println();

                        // count number of actors with Green eyes
                        String query4 = "SELECT COUNT(*) FROM public.\"Actor\" WHERE eye_color = ?";
                        preparedStatement = conn.prepareStatement(query4);

                        // sets the parameters for the query
                        preparedStatement.setString(1, "Green");

                        // object stores rows returned by the query
                        ResultSet resultSet4 = preparedStatement.executeQuery();
                        // prints out result of query
                        while (resultSet4.next()) {
                                int count = resultSet4.getInt(1);
                                System.out.println("Number of actors with green eye color: " + count);
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
