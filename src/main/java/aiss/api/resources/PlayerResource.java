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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Path("/players")
public class PlayerResource {
	
	public static final List<String> CHAMP_POOL = new ArrayList<String>
	(Arrays.asList("Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", 
			"Aurelion Sol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Camille", 
			"Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr.Mundo", "Draven", "Ekko", 
			"Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank",
			"Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", 
			"Ivern", "Janna", "Jarvan IV", "Jax", "Jayce", "Jhin", "Jinx", "Kalista", "Karma", 
			"Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kindred", "Kled", 
			"Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", 
			"Malphite", "Malzahar", "Maokai", "Master yi", "Miss Fortune", "Mordekaiser", 
			"Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", 
			"Orianna", "Pantheon", "Poppy", "Quinn", "Rakan", "Rammus", "Rek'Sai", "Renekton", 
			"Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", 
			"Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Tahm Kench", 
			"Taliyah", "Talon", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twitch", 
			"Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear"
			,"Warwick", "Wukong", "Xayah", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", 
			"Zilean", "Zyra"));
	
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
		Player player = repository.getPlayer(playerId);
			if (player == null){
				throw new NotFoundException("El jugador con ID "+ playerId + " no fué encontrado");
			}
		return player;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Player player) {
			if(player.getSummonerName() == null || "".equals(player.getSummonerName())){
				throw new BadRequestException("El nombre de invocador no debe ser nulo o vacío");
			}
			
			if(player.getPassword() == null || "".equals(player.getPassword())){
				throw new BadRequestException("La contraseña no debe ser nula o vacía");
			}
			
			if(player.getTier() == null || "".equals(player.getTier())){
				throw new BadRequestException("El tier no debe ser nulo o vacío");
			}
			
			if(player.getLocation() == null || "".equals(player.getLocation())){
				throw new BadRequestException("La localización no debe ser nula o vacía");
			}
			
			if(player.getDivision() == null || "".equals(player.getDivision())){
				throw new BadRequestException("La división no debe ser nula o vacía");
			}
			
			
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
