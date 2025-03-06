package biblioteca.demo.run;

public class Socio {
	
	private int numSocio; //asociada a la clave primaria en la tabla de DB
	private String nombreCompleto;
	private int esTrabajador;
	private int fechaNac;
	private String masInfo;
	
	
	public int getNumSocio() {
		return numSocio;
	}
	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public int getEsTrabajador() {
		return esTrabajador;
	}
	public void setEsTrabajador(int esTrabajador) {
		this.esTrabajador = esTrabajador;
	}
	
	public int getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(int fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public String getMasInfo() {
		return masInfo;
	}
	public void setMasInfo(String masInfo) {
		this.masInfo = masInfo;
	}	

	
	
	
	
	
	
}
