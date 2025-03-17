package ortegabravo.maxsport.modelo;

/**
 * Clase que representa un ejercicio en el sistema.
 */
public class Exercici {

    private int Id;
    private String nomExercici;
    private String descripcio;
    private String demoFoto;

    /**
     * Constructor con parámetros para inicializar un ejercicio.
     *
     * @param id el ID del ejercicio
     * @param NomExercici el nombre del ejercicio
     * @param Descripcio la descripción del ejercicio
     * @param DemoFoto la foto de demostración del ejercicio
     */
    public Exercici(int id, String NomExercici, String Descripcio, String DemoFoto) {
        this.Id = id;
        this.nomExercici = NomExercici;
        this.descripcio = Descripcio;
        this.demoFoto = DemoFoto;
    }

    /**
     * Devuelve una representación en cadena del objeto Ejercicio.
     *
     * @return una cadena que representa el ejercicio
     */
    @Override
    public String toString() {
        return Id + " - " + nomExercici + "  " + descripcio;
    }

    /**
     * Constructor por defecto para crear un ejercicio vacío.
     */
    public Exercici() {
    }

    /**
     * Obtiene el ID del ejercicio.
     *
     * @return el ID del ejercicio
     */
    public int getId() {
        return Id;
    }

    /**
     * Obtiene el nombre del ejercicio.
     *
     * @return el nombre del ejercicio
     */
    public String getNomExercici() {
        return nomExercici;
    }

    /**
     * Obtiene la descripción del ejercicio.
     *
     * @return la descripción del ejercicio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Obtiene la foto de demostración del ejercicio.
     *
     * @return la foto de demostración del ejercicio
     */
    public String getDemoFoto() {
        return demoFoto;
    }

    /**
     * Establece el ID del ejercicio.
     *
     * @param id el nuevo ID del ejercicio
     */
    public void setId(int id) {
        this.Id = id;
    }

    /**
     * Establece el nombre del ejercicio.
     *
     * @param NomExercici el nuevo nombre del ejercicio
     */
    public void setNomExercici(String NomExercici) {
        this.nomExercici = NomExercici;
    }

    /**
     * Establece la descripción del ejercicio.
     *
     * @param Descripcio la nueva descripción del ejercicio
     */
    public void setDescripcio(String Descripcio) {
        this.descripcio = Descripcio;
    }

    /**
     * Establece la foto de demostración del ejercicio.
     *
     * @param DemoFoto la nueva foto de demostración del ejercicio
     */
    public void setDemoFoto(String DemoFoto) {
        this.demoFoto = DemoFoto;
    }

}
