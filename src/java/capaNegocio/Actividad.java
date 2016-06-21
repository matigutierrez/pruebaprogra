package capaNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import javax.jws.WebMethod;
import javax.jws.WebParam;

public class Actividad {

	private int uid;
	private Date fecha;
	private String nombre;
	private String descripcion;
	private int uid_grupo;

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

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public int getUid_grupo() {
		return this.uid_grupo;
	}

	/**
	 * 
	 * @param uid_grupo
	 */
	public void setUid_grupo(int uid_grupo) {
		this.uid_grupo = uid_grupo;
	}
        public int agregarActividadCapaNegocio(Actividad actividad,Grupo grupo) throws PersistentException {
		int respuesta=0;
                PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
                try {
                    orm.Actividad lormActividad = orm.ActividadDAO.createActividad();
                    lormActividad.setNombre(actividad.getNombre()); 
                    lormActividad.setDescripcion(actividad.getDescripcion());
                    lormActividad.setFecha(Calendar.getInstance().getTime());
                    orm.Grupo grupoOrm = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
                    lormActividad.setGrupo(grupoOrm);
                    grupoOrm.actividad.add(lormActividad);
                    
                    orm.ActividadDAO.save(lormActividad);
                    t.commit();
                    respuesta = lormActividad.getUid();
            } catch (Exception e) {
                 t.rollback();
            }
                return respuesta;
	}
        public int agregarActividadAGrupo(Actividad actividad,Contacto contacto) throws PersistentException {
        int respuesta = 0;
        PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
        try {
            orm.Actividad_leida lormActividad = new orm.Actividad_leida();
            orm.Actividad actividadOrm = orm.ActividadDAO.loadActividadByORMID(actividad.getUid());
                      
            orm.Contacto grupoOrm = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());
            
            
            lormActividad.setActividad(actividadOrm);
            lormActividad.setContacto(grupoOrm);
            lormActividad.setVisto("0");
            actividadOrm.actividad_leida.add(lormActividad);
            
            
           
            t.commit();
            respuesta = lormActividad.getUid();
        } catch (Exception e) {
            t.rollback();
        }
        return respuesta;
    }
        public List<orm.Actividad_leida> busquedaActividadLeidaGrupo(Actividad actividad) throws PersistentException {
                String busqueda="1";
		List<orm.Actividad_leida> listaActividadesleidas = new ArrayList<orm.Actividad_leida>();
                List<orm.Actividad> listaActividades = new ArrayList<orm.Actividad>();
                 List<orm.Actividad_leida> listas = new ArrayList<orm.Actividad_leida>(); 
                
                //listaNotificacionesleidas = orm.Notificacion_leidaDAO.queryNotificacion_leida("notificacion_leida.visto='" + busqueda + "'  or notificacion_leida.notificacion_id='"+notificacion.getUid()+"' ", null);
                listaActividades=orm.ActividadDAO.queryActividad("Actividad.uid='" + actividad.getUid() + "' ", null);
                orm.Actividad_leida [] listaMC = new orm.Actividad_leida[listaActividades.size()];
                if (listaActividades != null) {
                    for (orm.Actividad actividadesOrm  : listaActividades) {
                        
                        listaMC = actividadesOrm.actividad_leida.toArray();
                        
                    }
                    
                }
            listaActividadesleidas = Arrays.asList(listaMC);
            for(int i=0; i<listaActividadesleidas.size(); i++){
            if(listaActividadesleidas.get(i).getVisto().equals("1")){
              listas.add(listaActividadesleidas.get(i));
            }
            }
  
            return listas;    
	}
        public List<Contacto> busquedaContactoleidoActividad (List<orm.Actividad_leida>busquedaNotificacionLeida){
            List<Contacto>listaContacto = new ArrayList<Contacto>();
            for (int i = 0; i < busquedaNotificacionLeida.size(); i++) {
                Contacto contacto = new Contacto();
                contacto.setUid(busquedaNotificacionLeida.get(i).getContacto().getUid());
                contacto.setNombre(busquedaNotificacionLeida.get(i).getContacto().getNombre());
                contacto.setApellido(busquedaNotificacionLeida.get(i).getContacto().getApellido());
                contacto.setTelefono(busquedaNotificacionLeida.get(i).getContacto().getTelefono());
                contacto.setMail(busquedaNotificacionLeida.get(i).getContacto().getMail());
                contacto.setCiudad(busquedaNotificacionLeida.get(i).getContacto().getCiudad());
                contacto.setEmpresa(busquedaNotificacionLeida.get(i).getContacto().getEmpresa());
                contacto.setImagenes(busquedaNotificacionLeida.get(i).getContacto().getImagenes());
                
                listaContacto.add(contacto);
            }
            return listaContacto;
        }

}