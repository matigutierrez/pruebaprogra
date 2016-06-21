package capaNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Grupo {

	private int uid;
	private String nombre;
	private String descripcion;
        private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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

	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @param grupo
	 */
	public int agregarGrupoCapaNegocio(Grupo grupo) throws PersistentException {
		int respuesta=0;
                PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
                try {
                    orm.Grupo lormGrupo = orm.GrupoDAO.createGrupo();
                    lormGrupo.setNombre(grupo.getNombre()); 
                    lormGrupo.setDescripcion(grupo.getDescripcion());
                    lormGrupo.setFecha(Calendar.getInstance().getTime());
                    
                    orm.GrupoDAO.save(lormGrupo);
                    t.commit();
                    respuesta = lormGrupo.getUid();
            } catch (Exception e) {
                 t.rollback();
            }
                return respuesta;
	}

	/**
	 * 
	 * @param grupo
	 */
	public int eliminarGrupoCapaNegocio(Grupo grupo) throws PersistentException {
            int respuesta = 0;
            PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
            
            try {
                orm.Grupo lormGrupo = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
                orm.GrupoDAO.delete(lormGrupo);
                
                t.commit();
                return lormGrupo.getUid();
            } catch (Exception e) {
                t.rollback();
            }
            return respuesta;
	}

	/**
	 * 
	 * @param grupo
	 */
	public int editarGrupoCapanegocio(Grupo grupo) throws PersistentException {
            int respuesta = 0;

           PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
           
            try {
                orm.Grupo lormGrupo = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
                if(grupo.getNombre()!=null){
                    lormGrupo.setNombre(grupo.getNombre());
                }
                if(grupo.getDescripcion()!=null){
                    lormGrupo.setDescripcion(grupo.getDescripcion());
                }
                if(grupo.getFecha()!=null){
                    lormGrupo.setFecha(Calendar.getInstance().getTime());
                }
                
                
                orm.GrupoDAO.save(lormGrupo);
                t.commit();
                respuesta = lormGrupo.getUid();
            } catch (Exception e) {
                t.rollback();
            }
            return respuesta;
	}

	/**
	 * 
	 * @param grupo
	 */
	public List<Grupo> busquedaAvanzadaGrupo(Grupo grupo) {
		
		return null;
	}

	/**
	 * 
	 * @param grupo
	 */
	public List<Grupo> busqueaSimpleGrupo(String busqueda) throws PersistentException {
            List<Grupo> listagrupo = new ArrayList<Grupo>();
            List<orm.Grupo> listaGrupos = new ArrayList<orm.Grupo>();
            if (busqueda != null || !busqueda.equals("")) {
                listaGrupos = orm.GrupoDAO.queryGrupo("Grupo.nombre='"+busqueda+"' ", null);
                
            }
            if (listaGrupos != null) {
                for (orm.Grupo grupoOrm : listaGrupos) {
                    Grupo grupoNegocio = new Grupo();
                    
                    grupoNegocio.setNombre(grupoOrm.getNombre());
                    listagrupo.add(grupoNegocio);
                }
                
            }
            return  listagrupo;
	}
        
	
	public List<orm.Membresia> busquedaMembresiaGrupo(Grupo grupo) throws PersistentException {
		List<orm.Membresia > listaMembresia = new ArrayList<orm.Membresia>();
                List<orm.Grupo> listaGrupos = new ArrayList<orm.Grupo>();
                
                listaGrupos = orm.GrupoDAO.queryGrupo("Grupo.uid='" + grupo.getUid() + "' ", null);
                orm.Membresia [] listaMC = new orm.Membresia[listaGrupos.size()];
                if (listaGrupos != null) {
                    for (orm.Grupo grupoOrm  : listaGrupos) {
                        
                        listaMC = grupoOrm.membresia.toArray();
                    }
                    
                }
            listaMembresia = Arrays.asList(listaMC);
            
  
            return listaMembresia;    
	}
        
        public List<Contacto> busquedaContactoGrupo (List<orm.Membresia>busquedaMembresia){
            List<Contacto>listaContacto = new ArrayList<Contacto>();
            for (int i = 0; i < busquedaMembresia.size(); i++) {
                Contacto contacto = new Contacto();
                contacto.setUid(busquedaMembresia.get(i).getContacto().getUid());
                contacto.setNombre(busquedaMembresia.get(i).getContacto().getNombre());
                contacto.setApellido(busquedaMembresia.get(i).getContacto().getApellido());
                contacto.setTelefono(busquedaMembresia.get(i).getContacto().getTelefono());
                contacto.setMail(busquedaMembresia.get(i).getContacto().getMail());
                contacto.setCiudad(busquedaMembresia.get(i).getContacto().getCiudad());
                contacto.setEmpresa(busquedaMembresia.get(i).getContacto().getEmpresa());
                contacto.setImagenes(busquedaMembresia.get(i).getContacto().getImagenes());
                
                listaContacto.add(contacto);
            }
            return listaContacto;
        }
        
        
        public int agregarContactoAGrupo(Contacto contacto, Grupo grupo) throws PersistentException {
        int respuesta = 0;
        PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
        try {
            
            orm.Membresia membresiaOrm = new orm.Membresia();
             
                      
            orm.Contacto contactoOrm = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());
            orm.Grupo grupoOrm = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
            
            membresiaOrm.setContacto(contactoOrm);
            membresiaOrm.setGrupo(grupoOrm);
            grupoOrm.membresia.add(membresiaOrm);
            
            
           
            t.commit();
            respuesta = membresiaOrm.getUid();
        } catch (Exception e) {
            t.rollback();
        }
        return respuesta;
    }
        
}