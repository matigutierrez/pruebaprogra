package capaNegocio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import orm.Membresia;
public class Contacto {

	private int uid;
	private String nombre;
	private String apellido;
	private String mail;
	private String telefono;
	private String imagenes;
	private String ciudad;
	private String empresa;

	public int getUid() {
		return this.uid;
	}

	/**
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return this.mail;
	}

	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImagenes() {
		return this.imagenes;
	}

	/**
	 * 
	 * @param imagenes
	 */
	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	/**
	 * 
	 * @param empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * 
	 * @param contacto
	 */
	public int agregarContactoCapaNegocio(Contacto contacto) throws PersistentException {
		int respuesta=0;
                PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
                try {
                    orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
                    lormContacto.setApellido(contacto.getApellido());           
                    lormContacto.setNombre(contacto.getNombre());            
                    lormContacto.setMail(contacto.getMail());            
                    lormContacto.setTelefono(contacto.getTelefono());  
                    lormContacto.setCiudad(contacto.getCiudad());
                    lormContacto.setEmpresa(contacto.getEmpresa());
                    lormContacto.setImagenes(contacto.getImagenes());
                    
                    orm.ContactoDAO.save(lormContacto);
                    t.commit();
                    respuesta = lormContacto.getUid();
            } catch (Exception e) {
                 t.rollback();
            }
                return respuesta;
	}

	/**
	 * 
	 * @param contacto
	 */
	public int eliminarContactoCapaNegocio(Contacto contacto) throws PersistentException {
            int respuesta = 0;
            PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
            
            try {
                orm.Membresia membresiaOrm = new orm.Membresia();
                orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());
                orm.ContactoDAO.delete(lormContacto);
                
                t.commit();
                return lormContacto.getUid();
            } catch (Exception e) {
                t.rollback();
            }
            return respuesta;
	}

	/**
	 * 
	 * @param contacto
	 */
	public int editarContactoCapanegocio(Contacto contacto) throws PersistentException {
		
            int respuesta = 0;
            PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
 
            
            try {
                orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());
                
                if(contacto.getApellido()!=null) {
                    lormContacto.setApellido(contacto.getApellido());
                }
                if(contacto.getMail()!=null){
                    lormContacto.setMail(contacto.getMail());
                }
                if(contacto.getNombre()!=null){
                    lormContacto.setNombre(contacto.getNombre());
                }
                if(contacto.getTelefono()!=null){
                    lormContacto.setTelefono(contacto.getTelefono());
                }
                if(contacto.getEmpresa()!=null){
                    lormContacto.setEmpresa(contacto.getEmpresa());
                }
                if(contacto.getCiudad()!=null){
                    lormContacto.setCiudad(contacto.getCiudad());
                }
                if(contacto.getImagenes()!=null){
                    lormContacto.setImagenes(contacto.getImagenes());
                }
                
            orm.ContactoDAO.save(lormContacto);
            t.commit();
            respuesta = lormContacto.getUid();
            
            } catch (Exception e) {
                t.rollback();
            }
            return respuesta;
	}

	/**
	 * 
	 * @param busqueda
	 */
	public List<Contacto> busquedaSimpleContacto(String busqueda) throws PersistentException {
            List<Contacto> listaContacto = new  ArrayList<Contacto>();
            List<orm.Contacto> listaContactos = new ArrayList<orm.Contacto>();
             if (busqueda != null || !busqueda.equals("")) {
            listaContactos=orm.ContactoDAO.queryContacto("Contacto.nombre='" + busqueda + "'or Contacto.apellido='"
            + busqueda+ "' or Contacto.telefono='"+busqueda+"'  or Contacto.mail='"+busqueda+"'  or Contacto.ciudad='"
                    +busqueda+"'  or Contacto.empresa='"+busqueda+"' ", null);
            }
            if (listaContactos!=null) {
            for (orm.Contacto contactoOrm : listaContactos) {
                Contacto contactoNegocio = new Contacto();
                
                contactoNegocio.setNombre(contactoOrm.getNombre());
                contactoNegocio.setApellido(contactoOrm.getApellido());
                contactoNegocio.setTelefono(contactoOrm.getTelefono());
                contactoNegocio.setMail(contactoOrm.getMail());
                contactoNegocio.setUid(contactoOrm.getUid());
                contactoNegocio.setCiudad(contactoOrm.getCiudad());
                contactoNegocio.setEmpresa(contactoOrm.getEmpresa());
                listaContacto.add(contactoNegocio);
            }
            
        }
        return listaContacto;
	}

	/**
	 * 
	 * @param contacto
	 */
	public List<Contacto> busquedaAvanzadaContacto(Contacto contacto) throws PersistentException {
            
            List<Contacto> listaContacto = new  ArrayList<Contacto>();
            List<orm.Contacto> listaContactos = new ArrayList<orm.Contacto>();
            String query="";
            if (contacto.getNombre()!=null && !contacto.getNombre().equals("")) {
                query+="Contacto.nombre='"+contacto.getNombre()+"' ";

            }
            if ((contacto.getNombre()!=null && !contacto.getNombre().equals("")) && (contacto.getApellido()!=null && !contacto.getApellido().equals("")) ) {
                query+="and ";
            }
            if ((contacto.getApellido()!=null && !contacto.getApellido().trim().equals(""))) {
                query+="Contacto.apellido='" + contacto.getApellido()+"' ";

            }
            if (((contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")) || contacto.getApellido()!=null && !contacto.getApellido().trim().equals("")) && 
                (contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals(""))){
                query+="and ";
            }
            if (contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals("")) {
                query+="Contacto.telefono='" + contacto.getTelefono()+ "' ";

            }
            if (((contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")) || contacto.getApellido()!=null && !contacto.getApellido().trim().equals("") || 
                contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals("")) && contacto.getMail()!=null && !contacto.getMail().trim().equals("")){
                query+="and ";
            }
            if (contacto.getMail()!=null && !contacto.getMail().trim().equals("")) {
                query+="Contacto.mail='"+contacto.getMail()+"'";
            }
            
            if (((contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")) || contacto.getApellido()!=null && !contacto.getApellido().trim().equals("") || 
                contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals("") || contacto.getMail()!=null && !contacto.getMail().trim().equals("")) &&
                (contacto.getCiudad()!=null && !contacto.getCiudad().trim().equals("")) ) {
                query+="and ";
            }
            if (contacto.getCiudad()!=null && !contacto.getCiudad().trim().equals("")) {
                query+="Contacto.ciudad='"+contacto.getCiudad()+"'";
            }
            if (((contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")) || contacto.getApellido()!=null && !contacto.getApellido().trim().equals("") || 
                contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals("") || contacto.getMail()!=null && !contacto.getMail().trim().equals("") ||
                contacto.getCiudad()!=null && !contacto.getCiudad().trim().equals("")) && (contacto.getEmpresa()!=null && !contacto.getEmpresa().trim().equals("")) ) {
                
                query+="and ";
            }
            if (contacto.getEmpresa()!=null && !contacto.getEmpresa().trim().equals("")) {
                query+="Contacto.empresa='"+contacto.getEmpresa()+"'";
            }
            if (((contacto.getNombre()!=null && !contacto.getNombre().trim().equals("")) || contacto.getApellido()!=null && !contacto.getApellido().trim().equals("") || 
                contacto.getTelefono()!=null && !contacto.getTelefono().trim().equals("") || contacto.getMail()!=null && !contacto.getMail().trim().equals("") ||
                contacto.getCiudad()!=null && !contacto.getCiudad().trim().equals("") || contacto.getEmpresa()!=null && !contacto.getEmpresa().trim().equals("") )&&
                contacto.getImagenes()!=null && !contacto.getImagenes().trim().equals(""))  {
                
                query+="and ";
            }
            if (contacto.getImagenes()!=null && !contacto.getImagenes().trim().equals("")) {
                query+="Contacto.imagenes='"+contacto.getImagenes()+"'";
            }
            
            listaContactos = orm.ContactoDAO.queryContacto(query,null);
            if (listaContactos!=null) {
                for (orm.Contacto contactoOrm : listaContactos) {
                    
                    Contacto contactoNegocio = new Contacto();
                    
                    contactoNegocio.setUid(contactoOrm.getUid());
                    contactoNegocio.setNombre(contactoOrm.getNombre());
                    contactoNegocio.setApellido(contactoOrm.getApellido());
                    contactoNegocio.setTelefono(contactoOrm.getTelefono());
                    contactoNegocio.setMail(contactoOrm.getMail());
                    contactoNegocio.setCiudad(contactoOrm.getCiudad());
                    contactoNegocio.setEmpresa(contactoOrm.getEmpresa());
                    
                    
                    listaContacto.add(contactoNegocio);
                }

            }
            return listaContacto;
        }
	

	
	public List<Membresia> busquedaMembresiaContacto(Contacto contacto) throws PersistentException {
            
            List<Membresia> listaMembresia = new ArrayList<Membresia>();
            List<orm.Contacto> listaContactos = new ArrayList<orm.Contacto>();
             
            listaContactos=orm.ContactoDAO.queryContacto("Contacto.uid='" + contacto.getUid()+"' ", null);
            Membresia [] listaMC = new Membresia[listaContactos.size()];
            if (listaContactos!=null) {
                for (orm.Contacto contactoOrm : listaContactos) {
                 listaMC =    contactoOrm.membresia.toArray();
            
                }
            
            }
            
            listaMembresia = Arrays.asList(listaMC);
            
  
            return listaMembresia;
	}
                    
         public List<Grupo> busquedaGruposContacto (List <Membresia> busquedaMembresia) throws PersistentException{
             
             List<Grupo> listaGrupo = new ArrayList<Grupo>();
             
             
             for (int i = 0; i < busquedaMembresia.size(); i++) {
                 
                     Grupo grupo = new Grupo ();
                     grupo.setNombre(busquedaMembresia.get(i).getGrupo().getNombre());
                     grupo.setDescripcion(busquedaMembresia.get(i).getGrupo().getDescripcion());
                     grupo.setUid(busquedaMembresia.get(i).getGrupo().getUid());
                     
                     listaGrupo.add(grupo);
         }
                 
             
             return  listaGrupo;
         } 
}