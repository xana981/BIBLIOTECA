package biblioteca.demo.run;

   public class SocioEntity {
	      
       private int numSocio;
       private String nombreCompleto;
       private String esTrabajador;
       private String fechaNac;
       private String masInfo;
      
       // Constructor
       public SocioEntity(int numSocio,String nombreCompleto,String esTrabajador,String fechaNac,String masInfo) {
    	   
           this.numSocio = numSocio;
           this.nombreCompleto = nombreCompleto;
           this.esTrabajador = esTrabajador;
           this.fechaNac = fechaNac;
           this.masInfo = masInfo;
           
           // Getters y Setters
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

           public String getEsTrabajador() {
               return esTrabajador;
           }

           public void setEsTrabajador(String esTrabajador) {
               this.esTrabajador = esTrabajador;
           }

           public String getFechaNac() {
               return fechaNac;
           }

           public void setFechaNac(String fechaNac) {
               this.fechaNac = fechaNac;
           }

           public String getMasInfo() {
               return masInfo;
           }

           public void setMasInfo(String masInfo) {
               this.masInfo = masInfo;
           }
       }    
   }
       
