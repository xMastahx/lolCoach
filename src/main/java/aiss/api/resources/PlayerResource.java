package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import aiss.model.Player;
import aiss.model.repository.MapPlayerRepository;
import aiss.model.repository.PlayerRepository;

import java.net.URI;
import java.util.Collection;
import java.util.List;


@Path("/players")
public class PlayerResource {

	public static PlayerResource _instance=null;
	PlayerRepository repository;
	
	private PlayerResource(){
		repository=MapPlayerRepository.getInstance();
	}
	
	public static PlayerResource getInstance()
	{
		if(_instance==null)
			_instance=new PlayerResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Player> getAll()
	{
		return repository.getAllPlayers();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Player get(@PathParam("id") String playerId)
	{
		
		return null;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Player player) {
		return null;
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Player player) {
		return null;
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String player) {
		return null;
	}
	
}
