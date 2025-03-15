package ortegabravo.maxsport.accesoDatos;

import ortegabravo.maxsport.modelo.Exercici;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("connectionUrlAzure"));
            //String connectionUrl = "jdbc:sqlserver://localhost:1433;database=simulapdb;user=sa;password=Pwd1234.;encrypt=false;loginTimeout=10;";
            //String connectionUrlAzure = "jdbc:sqlserver://simulapsqlserver.database.windows.net:1433;database=simulapdb;user=simulapdbadmin@simulapsqlserver;password=Pwd1234.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=simulabdb202417101926;user=sa;password=Noruega80;encrypt=false;loginTimeout=30;";
            //connection = DriverManager.getConnection(connectionUrl);
            //connection = DriverManager.getConnection(connectionUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Usuari getUser(String email) {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();

            user = null;
            while (resultSet.next()) {
                user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setFoto(resultSet.getBytes("Foto"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }
//he debido modificar este metodo, y añadir que busque por numero de instructor asiginado

    public static ArrayList<Usuari> getAllUsersByInstructor(int idInstructor) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idInstructor);

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto(resultSet.updateBytes(0x0,"Foto"));
                user.setFotoFilename(resultSet.getString("FotoFilename"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                user.setAssignedInstructor(resultSet.getInt("AssignedInstructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("flag1");
        return usuaris;
    }

    public static ArrayList<Workout> getWorkoutsPerUser(Usuari user) {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT Workouts.Id, Workouts.ForDate, Workouts.UserId, Workouts.Comments"
                + " FROM Workouts"
                + " WHERE Workouts.UserId=?"
                + " ORDER BY Workouts.ForDate";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Workout workout = new Workout();
                workout.setId(resultSet.getInt("Id"));
                workout.setForDate(resultSet.getDate("ForDate"));
                workout.setIdUsuari(resultSet.getInt("UserId"));
                workout.setComments(resultSet.getString("comments"));

                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;

    }

    public static ArrayList<Exercici> getExercicisPerWorkout(Workout workout) {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT ExercicisWorkouts.IdExercici,"
                + " Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM ExercicisWorkouts INNER JOIN Exercicis ON ExercicisWorkouts.IdExercici=Exercicis.Id"
                + " WHERE ExercicisWorkouts.IdWorkout=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, workout.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("IdExercici"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    public static ArrayList<Exercici> getAllExercicis() {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT Id, Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM Exercicis";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("Id"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    //aqui tb he tenido que añadir el assignedInstructor
    public static int registerUser(Usuari u) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Instructor,AssignedInstructor)"
                + " VALUES (?,?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.getInstructor());//aqui cambie a getIntructor ya que habia un isInstructor que siempre devolvia un true
            insertStatement.setInt(5, u.getAssignedInstructor());

            int newUserId = insertStatement.executeUpdate();

            return newUserId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void insertWorkout(Workout w, ArrayList<Exercici> exercicis) {
        // The following should be done in a SQL transaction
        int newWorkoutId = insertToWorkoutTable(w);
        insertExercisesPerWorkout(newWorkoutId, exercicis);
    }

    private static int insertToWorkoutTable(Workout w) {
        String sql = "INSERT INTO dbo.Workouts (ForDate, UserId, Comments)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            //me daba excepcion ya que el preparedStatemen estaba en setString y lo cambie a setDate, hice un cast a date pero no medejaba 
            //ya que el date resultante no era dateSql, tube que consultar internet para la respuesta IA de brave, 
            // pasar el date a localDate y Local date a sqlDate.
            LocalDate date = w.getForDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            insertStatement.setDate(1, sqlDate);

            insertStatement.setDate(1, sqlDate);
            insertStatement.setInt(2, w.getIdUsuari());
            insertStatement.setString(3, w.getComments());

            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();

                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int insertExercisesPerWorkout(int wId, ArrayList<Exercici> exercicis) {
        for (Exercici e : exercicis) {
            int rowsAffected = insertExerciciPerWorkout(wId, e);
            if (rowsAffected != 1) {
                return 0;
            }
        }
        return exercicis.size();
    }

    private static int insertExerciciPerWorkout(int wId, Exercici e) {
        String sql = "INSERT INTO dbo.ExercicisWorkouts (IdWorkout, IdExercici)"
                + " VALUES (?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setInt(1, wId);
            insertStatement.setInt(2, e.getId());
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int obtenerIdEjercicio(String ejercicioSelecionado) {

        String sentenciaGetID = "SELECT dbo.Exercicis.Id FROM dbo.Exercicis WHERE Exercicis.Descripcio=?";
        int idEjercicio = 0;

        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sentenciaGetID);) {
            selectStatement.setString(1, ejercicioSelecionado);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();

                idEjercicio = resultSet.getInt(1);
//                
//                exercici.setId(resultSet.getInt("IdExercici"));
//                exercici.setNomExercici(resultSet.getString("NomExercici"));
//                exercici.setDescripcio(resultSet.getString("Descripcio"));
//                exercici.setDemoFoto(resultSet.getString("DemoFoto"));
//                
//                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(idEjercicio);
        return idEjercicio;

    }

//    public static void eliminarEjercicio(int idEjercicio) {
//
//        //son dos sentencias para obtener el id del ejercicio con el String
//        // y luego para borrarla con el id de la tabla dbo.ExercicisWorkout
//        String sentenciaBorrado = "DELETE FROM dbo.ExercicisWorkouts WHERE dbo.ExercicisWorkouts.Id=?";
//        String sentenciaBorradoIntents="DELETE FROM dbo.Intents WHERE dbo.Intents.IdExerciciWorkout=?";
//        //
//        String sentenciaIdIntents="SELECT dbo.Intents,Id FROM dbo.Intents where Intents.idExerciciWorkout=?";
//        String sentenciaIdReview="SELECT dbo.Review.Id FROM dbo.Review WHERE Review.idIntent=?";
//        
//        
//        //como hay fk necesito borrar las relacionados
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sentenciaBorrado);
//                PreparedStatement psIntents = con.prepareStatement(sentenciaBorradoIntents)
//                ) {
//            psIntents.setInt(1,idEjercicio);
//            ps.setInt(1, idEjercicio);
//            psIntents.executeUpdate();
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace(); 
//        }
//        System.out.println("fin de borrado ? en dataaccess");
//    }
    public static void eliminarEjercicio(int idExercici, int idWorkout) {

        try {

            String sentenciaBorradoReview
                    = "DELETE FROM dbo.Review "
                    + "WHERE IdIntent IN ("
                    + "    SELECT Id "
                    + "    FROM dbo.Intents "
                    + "    WHERE IdExerciciWorkout IN ("
                    + "        SELECT Id "
                    + "        FROM dbo.ExercicisWorkouts "
                    + "        WHERE IdExercici = ? AND IdWorkout = ?"
                    + "    )"
                    + ");";

            String sentenciaBorradoIntents
                    = "DELETE FROM dbo.Intents "
                    + "WHERE IdExerciciWorkout IN ("
                    + "    SELECT Id "
                    + "    FROM dbo.ExercicisWorkouts "
                    + "    WHERE IdExercici = ? AND IdWorkout = ?"
                    + ");";

            String sentenciaBorradoExercicisWorkouts
                    = "DELETE FROM dbo.ExercicisWorkouts "
                    + "WHERE IdExercici = ? AND IdWorkout = ?;";

            String sentenciaBorradoExercici
                    = "DELETE FROM dbo.Exercicis "
                    + "WHERE Id = ? AND NOT EXISTS ("
                    + "    SELECT 1 "
                    + "    FROM dbo.ExercicisWorkouts "
                    + "    WHERE IdExercici = ?"
                    + ");";

            Connection conn = getConnection();

            // Sentencias preparadas
            PreparedStatement psBorradoReview = conn.prepareStatement(sentenciaBorradoReview);
            PreparedStatement psBorradoIntents = conn.prepareStatement(sentenciaBorradoIntents);
            PreparedStatement psBorradoExercicisWorkouts = conn.prepareStatement(sentenciaBorradoExercicisWorkouts);
            PreparedStatement psBorradoExercici = conn.prepareStatement(sentenciaBorradoExercici);

            try {
                // Inicia la transacción
                conn.setAutoCommit(false);

                // Establecer los parámetros para cada sentencia
                psBorradoReview.setInt(1, idExercici);
                psBorradoReview.setInt(2, idWorkout);
                psBorradoReview.executeUpdate();

                psBorradoIntents.setInt(1, idExercici);
                psBorradoIntents.setInt(2, idWorkout);
                psBorradoIntents.executeUpdate();

                psBorradoExercicisWorkouts.setInt(1, idExercici);
                psBorradoExercicisWorkouts.setInt(2, idWorkout);
                psBorradoExercicisWorkouts.executeUpdate();

                psBorradoExercici.setInt(1, idExercici);
                psBorradoExercici.setInt(2, idExercici);
                psBorradoExercici.executeUpdate();

                // Confirmar los cambios
                conn.commit();
            } catch (SQLException e) {
                // Si ocurre un error, revertir
                conn.rollback();
                e.printStackTrace();
            } finally {
                // Cerrar recursos
                psBorradoReview.close();
                psBorradoIntents.close();
                psBorradoExercicisWorkouts.close();
                psBorradoExercici.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarEntreno(int idEntreno, int idUsuario) {

        String borradoReview = "DELETE From dbo.Review WHERE idIntent IN(SELECT id FROM DBO.Intents WHERE idExerciciWorkout IN(SELECT Id FROM dbo.ExercicisWorkouts WHERE IdWorkout=?))";

        String borradoEjercicioIntents = "DELETE FROM dbo.Intents WHERE IdExerciciWorkout IN (SELECT Id FROM dbo.ExercicisWorkouts WHERE IdWorkout=?)";

        String borradoEjercicioEntreno = "DELETE FROM dbo.ExercicisWorkouts WHERE IdWorkout=?";

        String sentenciaBorradoEntreno = "DELETE FROM dbo.Workouts WHERE id=? AND UserId=?";

        try {

            Connection conn = getConnection();

            PreparedStatement psBorradoReview = conn.prepareStatement(borradoReview);

            PreparedStatement psBorrarIntents = conn.prepareStatement(borradoEjercicioIntents);

            PreparedStatement psBorradoEjercicioEntreno = conn.prepareStatement(borradoEjercicioEntreno);

            PreparedStatement psBorradoEntreno = conn.prepareStatement(sentenciaBorradoEntreno);

            try {

                conn.setAutoCommit(false);

                psBorradoReview.setInt(1, idEntreno);
                psBorradoReview.executeUpdate();

                psBorrarIntents.setInt(1, idEntreno);
                psBorrarIntents.executeUpdate();

                psBorradoEjercicioEntreno.setInt(1, idEntreno);
                psBorradoEjercicioEntreno.executeUpdate();

                psBorradoEntreno.setInt(1, idEntreno);
                psBorradoEntreno.setInt(2, idUsuario);
                psBorradoEntreno.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                // Si ocurre un error, revertir
                conn.rollback();
                e.printStackTrace();
            } finally {

                psBorradoReview.close();
                psBorradoEntreno.close();
                psBorradoEjercicioEntreno.close();
                psBorrarIntents.close();
                conn.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<String> getMailUsuarios() {
        ArrayList<String> emailUsuarios = new ArrayList<>();
        String sql = "SELECT Email FROM Usuaris;";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {

                emailUsuarios.add(resultSet.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emailUsuarios;
    }

    public static Usuari getUserNom(String nombre) {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Nom = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, nombre);
            ResultSet resultSet = selectStatement.executeQuery();

            user = null;
            while (resultSet.next()) {
                user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
//                user.setPasswordHash(resultSet.getString("PasswordHash"));
//                user.setFoto(resultSet.getBytes("Foto"));
//                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}//fin de clase 
