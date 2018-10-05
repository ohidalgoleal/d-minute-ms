package cl.usach.dminute.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.dto.EntradaLista;
import cl.usach.dminute.dto.EstadoElemento;
import cl.usach.dminute.dto.ListarActaDialogica;
import cl.usach.dminute.dto.ProyectoDto;
import cl.usach.dminute.dto.ProyectoUsuariosDto;
import cl.usach.dminute.dto.TemaDto;
import cl.usach.dminute.dto.UsuarioActaDto;
import cl.usach.dminute.entity.Usuario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/bff")
public class BffController {

	@Autowired
	@Qualifier("actaController")
	private ActaController actaController;
	
	@Autowired
	@Qualifier("proyectoController")
	private ProyectoController proyectoController;
	
	@Autowired
	@Qualifier("usuarioController")
	private UsuarioController usuarioController;
	
	@Autowired
	@Qualifier("elementoDialogoController")
	private ElementoDialogoController elementoDialogoController;
	
	@Autowired
	@Qualifier("temaController")
	private TemaController temaController;
	
	@GetMapping(value = "/listarMinutaProyecto/{proyectoid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ListarActaDialogica listarMinutaProyectoById(@PathVariable(value = "proyectoid") Long proyectoid, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("BffController.listarMinutaProyectoById.INIT");
			log.info("BffController.listarMinutaProyectoById.ProyectoId:" + proyectoid.toString());
		}
		
		ListarActaDialogica retorno = new ListarActaDialogica();
		
		ProyectoDto proyectoDto = proyectoController.proyectoById(proyectoid, request);
		
		if(log.isInfoEnabled()) {
			log.info("BffController.listarMinutaProyectoById.proyectoDto:" + proyectoDto.toString());
		}
		
		if (proyectoDto != null){
			retorno.setProyectoDto(proyectoDto);
			
			retorno.setListaActa(actaController.listarActaProyecto(proyectoid));
			
			if(log.isInfoEnabled()) {
				log.info("BffController.listarMinutaProyectoById.retorno:" + retorno.toString());
			}
			
			if (retorno.getListaActa().size()>0) {
				ActaDto actaDto = actaController.getActa(retorno.getListaActa().get(0).getActaId());
				List<ProyectoUsuariosDto> listaRetorno = new ArrayList<ProyectoUsuariosDto>();
				for (ProyectoUsuariosDto usuario : retorno.getProyectoDto().getUsuariosNuevoProyecto()) {
	    			boolean bandera = true;
					for (UsuarioActaDto usuarioActa : actaDto.getUsuarioActa()) {
						if (usuario.getUsername().equalsIgnoreCase(usuarioActa.getUsername())) {
							bandera = false;
							break;
						}
					}
					if (bandera){
						listaRetorno.add(usuario);
					}
				}
				retorno.getProyectoDto().setUsuariosNuevoProyecto(listaRetorno);
				retorno.setActaDto(actaDto);
			}
		}
			
		if(log.isInfoEnabled()) {
			log.info("BffController.listarMinutaProyectoById.retorno:" + retorno.toString());
			log.info("BffController.listarMinutaProyectoById.FIN");
		}
			
		return retorno;
	}
	
    @PostMapping(value="/listaUsuarioFiltro", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listaUsuarioFiltro(@RequestBody EntradaLista entradaLista, HttpServletRequest request){
    	if(log.isInfoEnabled()) {
			log.info("BffController.listaUsuarioFiltro.INIT");
			log.info("BffController.listaUsuarioFiltro.entradaLista:" + entradaLista.toString());
		}
    	List<Usuario> listaRespuesta = usuarioController.listUser();
    	List<Usuario> listaRetorno = new ArrayList<Usuario>();
    	if (entradaLista.getTipo().equalsIgnoreCase("PROY")){
    		ProyectoDto proyectoDto = proyectoController.proyectoById(entradaLista.getNumero(), request);
    		for (Usuario usuario : listaRespuesta) {
    			boolean bandera = true;
				for (ProyectoUsuariosDto usuarioPry : proyectoDto.getUsuariosNuevoProyecto()) {
					if (usuario.getUsername().equalsIgnoreCase(usuarioPry.getUsername())) {
						bandera = false;
						break;
					}
				}
				if (bandera){
					listaRetorno.add(usuario);
				}
			}
    	}	
    	else{
    		listaRetorno = listaRespuesta; 
    	}
    	
    	if(log.isInfoEnabled()) {
			log.info("BffController.listaUsuarioFiltro.retorno:" + listaRetorno.toString());
			log.info("BffController.listaUsuarioFiltro.FIN");
		}	
    	return listaRetorno;
    }
    
    @GetMapping(value="/estadoElemento", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstadoElemento> estadoElemento(){
    	if(log.isInfoEnabled()) {
			log.info("BffController.estadoElemento.INIT");
		}
    	List<EstadoElemento> listaRetorno = new ArrayList<EstadoElemento>();
    	EstadoElemento estadoElemento = new EstadoElemento();
    	estadoElemento.setEstado("TODO");
    	estadoElemento.setDetalle("PENDIENTE POR ASIGNAR");
    	listaRetorno.add(estadoElemento);
    	estadoElemento = new EstadoElemento();
    	estadoElemento.setEstado("DOING");
    	estadoElemento.setDetalle("ASIGNADO");
    	listaRetorno.add(estadoElemento);
    	estadoElemento = new EstadoElemento();
    	estadoElemento.setEstado("DONE");
    	estadoElemento.setDetalle("COMPLETADO");
    	listaRetorno.add(estadoElemento);
    	estadoElemento = new EstadoElemento();
    	estadoElemento.setEstado("DELE");
    	estadoElemento.setDetalle("ELIMINADO");
    	listaRetorno.add(estadoElemento);
    	
    	if(log.isInfoEnabled()) {
			log.info("BffController.estadoElemento.retorno:" + listaRetorno.toString());
			log.info("BffController.estadoElemento.FIN");
		}	
    	return listaRetorno;
    }
    
    @GetMapping(value="/listaActaFiltroElemento/{elementoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActaDto listaActaFiltroElemento(@PathVariable(value = "elementoId") Long elementoId){
    	if(log.isInfoEnabled()) {
			log.info("BffController.listaActaFiltroElemento.INIT");
			log.info("BffController.listaActaFiltroElemento.actaid:" + elementoId);
		}
    	ElementoDialogoDto elementoDialogoDto = elementoDialogoController.getElementoDialogoTema(elementoId);
    	TemaDto temaDto = temaController.getTema(elementoDialogoDto.getTemaId());
    	ActaDto actaDto = actaController.getActaId(temaDto.getActaId());
    	List<TemaDto> listaTema = new ArrayList<TemaDto>();
    	List<ElementoDialogoDto> listaElemento = new ArrayList<ElementoDialogoDto>();
    	listaElemento.add(elementoDialogoDto);
    	temaDto.setElementoDialogoDto(listaElemento);
    	listaTema.add(temaDto);
    	actaDto.setTemaActa(listaTema);

    	if(log.isInfoEnabled()) {
			log.info("BffController.listaActaFiltroElemento.retorno:" + actaDto.toString());
			log.info("BffController.listaActaFiltroElemento.FIN");
		}	
    	return actaDto;
    }
	
}
