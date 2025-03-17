package ortegabravo.maxsport.modelo;

/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuari {

    private int Id;
    private String nom;
    private String email;
    private String passwordHash;
    private byte[] foto;
    private String fotoFilename;
    private boolean instructor;
    private int assignedInstructor;

    /**
     * Constructor con parámetros para inicializar un usuario.
     *
     * @param Id el ID del usuario
     * @param nom el nombre del usuario
     * @param email el correo electrónico del usuario
     * @param passwordHash el hash de la contraseña del usuario
     * @param foto la foto del usuario en formato de bytes
     * @param fotoFilename el nombre del archivo de la foto del usuario
     * @param instructor indica si el usuario es un instructor
     * @param assignedInstructor el ID del instructor asignado al usuario
     */
    public Usuari(int Id, String nom, String email, String passwordHash, byte[] foto, String fotoFilename, boolean instructor, int assignedInstructor) {
        this.Id = Id;
        this.nom = nom;
        this.email = email;
        this.passwordHash = passwordHash;
        this.foto = foto;
        this.fotoFilename = fotoFilename;
        this.instructor = instructor;
        this.assignedInstructor = assignedInstructor;
    }

    /**
     * Constructor por defecto para crear un usuario vacío.
     */
    public Usuari() {
    }

    /**
     * Obtiene el nombre del archivo de la foto del usuario.
     *
     * @return el nombre del archivo de la foto
     */
    public String getFotoFilename() {
        return fotoFilename;
    }

    /**
     * Establece el nombre del archivo de la foto del usuario.
     *
     * @param fotoFilename el nuevo nombre del archivo de la foto
     */
    public void setFotoFilename(String fotoFilename) {
        this.fotoFilename = fotoFilename;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return el ID del usuario
     */
    public int getId() {
        return Id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el hash de la contraseña del usuario.
     *
     * @return el hash de la contraseña del usuario
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Obtiene la foto del usuario en formato de bytes.
     *
     * @return la foto del usuario
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Obtiene si el usuario es un instructor.
     *
     * @return true si el usuario es un instructor, de lo contrario false
     */
    public boolean getInstructor() {
        return instructor;
    }

    /**
     * Obtiene el ID del instructor asignado al usuario.
     *
     * @return el ID del instructor asignado
     */
    public int getAssignedInstructor() {
        return assignedInstructor;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param Id el nuevo ID del usuario
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nom el nuevo nombre del usuario
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email el nuevo correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece el hash de la contraseña del usuario.
     *
     * @param passwordHash el nuevo hash de la contraseña del usuario
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Establece la foto del usuario en formato de bytes.
     *
     * @param foto la nueva foto del usuario
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * Establece si el usuario es un instructor.
     *
     * @param instructor true si el usuario es un instructor, de lo contrario
     * false
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    /**
     * Establece el ID del instructor asignado al usuario.
     *
     * @param assignedInstructor el nuevo ID del instructor asignado
     */
    public void setAssignedInstructor(int assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    /**
     * Comprueba si el usuario es un instructor.
     *
     * @return true si el usuario es un instructor (actualmente siempre devuelve
     * true)
     */
    public boolean isInstructor() {
        return true;
        //esto no es asi

    }

}
