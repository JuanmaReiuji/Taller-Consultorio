import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Consultorio{
	private String nombre;
	private String nit;
	private List<Odontologo> listaOdontologos;
	private List<Paciente> listaPacientes;

	public Consultorio(String nombre, String nit){
		this.nombre = nombre;
		this.nit = nit;
		this.listaOdontologos = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
	}

	public Consultorio(){
		this.listaOdontologos = new ArrayList<>();
		this.listaPacientes = new ArrayList<>();
	}
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public List<Odontologo> getListaOdontologos() {
        return listaOdontologos;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setListaOdontologos(List<Odontologo> listaOdontologos) {
        this.listaOdontologos = listaOdontologos;
    }

    @Override
    public String toString(){
    	return "Consultorio: " + nombre + ". NIT: " + nit + 
    	"\nOdontologos: " + listaOdontologos + "\nPacientes: " + listaPacientes;
    }

    public Paciente buscarPaciente(String id){
        Paciente encontrado = null;
        for(Paciente aux : listaPacientes){
            if(aux.id().equals(id)){
                return aux;
            }
        }
        return encontrado;
    }

    public String registrarPaciente(String nombre, String id, int edad, String telefono, 
    LocalDate fechaUltimaConsulta, int cantTratamientosRealizados, String direccion, 
    String infoHistoriaClinica){
    String mensaje = "";

    Paciente encontrado = buscarPaciente(id);
    if(encontrado != null){
        mensaje = "El paciente " + nombre +" ya existe en el consultorio";
        return mensaje;
        }
    Paciente nuevoPaciente = new Paciente(nombre, id, edad, telefono, fechaUltimaConsulta, cantTratamientosRealizados, direccion, infoHistoriaClinica);
    listaPacientes.add(nuevoPaciente);
    mensaje = "El paciente fue registrado exitosamente";
    return mensaje;
    }

    public List<Paciente> obtenerPacientesEspeciales(){
        List<Paciente> pacientesEspeciales = new ArrayList<>();

        for(Paciente aux : listaPacientes){
            if(aux.cantTratamientosRealizados() > 5){
                pacientesEspeciales.add(aux);
            }
        }
        return pacientesEspeciales;
    }
}