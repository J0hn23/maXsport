package ortegabravo.maxsport.modelo;

import java.util.Date;

/**
 * Clase que representa un entrenamiento en el sistema.
 */
public class Workout {

    int Id;
    Date ForDate;
    int IdUsuari;
    String comments;

    /**
     * Constructor con parámetros para inicializar un entrenamiento.
     *
     * @param Id el ID del entrenamiento
     * @param ForDate la fecha del entrenamiento
     * @param IdUsuari el ID del usuario que realizó el entrenamiento
     * @param comments los comentarios sobre el entrenamiento
     */
    public Workout(int Id, Date ForDate, int IdUsuari, String comments) {
        this.Id = Id;
        this.ForDate = ForDate;
        this.IdUsuari = IdUsuari;
        this.comments = comments;
    }

    /**
     * Constructor por defecto para crear un entrenamiento vacío.
     */
    public Workout() {
    }

    /**
     * Obtiene el ID del entrenamiento.
     *
     * @return el ID del entrenamiento
     */
    public int getId() {
        return Id;
    }

    /**
     * Obtiene la fecha del entrenamiento.
     *
     * @return la fecha del entrenamiento
     */
    public Date getForDate() {
        return ForDate;
    }

    /**
     * Obtiene el ID del usuario que realizó el entrenamiento.
     *
     * @return el ID del usuario
     */
    public int getIdUsuari() {
        return IdUsuari;
    }

    /**
     * Obtiene los comentarios sobre el entrenamiento.
     *
     * @return los comentarios sobre el entrenamiento
     */
    public String getComments() {
        return comments;
    }

    /**
     * Establece el ID del entrenamiento.
     *
     * @param Id el nuevo ID del entrenamiento
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Establece la fecha del entrenamiento.
     *
     * @param ForDate la nueva fecha del entrenamiento
     */
    public void setForDate(Date ForDate) {
        this.ForDate = ForDate;
    }

    /**
     * Establece el ID del usuario que realizó el entrenamiento.
     *
     * @param IdUsuari el nuevo ID del usuario
     */
    public void setIdUsuari(int IdUsuari) {
        this.IdUsuari = IdUsuari;
    }

    /**
     * Establece los comentarios sobre el entrenamiento.
     *
     * @param comments los nuevos comentarios sobre el entrenamiento
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
