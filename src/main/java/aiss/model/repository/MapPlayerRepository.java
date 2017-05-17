package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.ls.LSOutput;

import aiss.model.Player;



public class MapPlayerRepository implements PlayerRepository{

	Map<String, Player> playerMap;
	private static MapPlayerRepository instance=null;
	private int index=0;			
	
	
	public static MapPlayerRepository getInstance() {
		
		if (instance==null) {
			instance = new MapPlayerRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		playerMap = new HashMap<String,Player>();
		
		Player Tyler1 = new Player();
		List<String> champions = new ArrayList<String>();
		List<String> lenguages = new ArrayList<String>();
		List<String> roles = new ArrayList<String>();
		champions.add("Draven");
		lenguages.add("English");
		Tyler1.setChampions(champions);
		Tyler1.setDivision("I");
		Tyler1.setEmail("bestdravenna@gmail.com");
		Tyler1.setLenguages(lenguages);
		Tyler1.setLocation("NA");
		Tyler1.setSummonerName("Tyler1");
		Tyler1.setTier("Challenger");
		Tyler1.setPassword("tyler");
		Tyler1.setRoles(roles);
		addPlayer(Tyler1);
	
	}
	
	// Player related operations
	@Override
	public void addPlayer(Player p) {
		String id = "p" + index++;	
		p.setId(id);
		playerMap.put(id,p);
	}
	
	@Override
	public Collection<Player> getAllPlayers() {
		Collection<Player> res = new HashSet<Player>(playerMap.values());
		return res;
	}

	@Override
	public Player getPlayer(String id) {
		Player displayedPlayer = new Player(playerMap.get(id));
		return displayedPlayer;
	}

	@Override
	public void deletePlayer(String id) {	
		playerMap.remove(id);
	}

	@Override
	public void updatePlayer(Player p) {
		Player player = playerMap.get(p.getId());
		player.setSummonerName(p.getSummonerName());
		player.setChampions(p.getChampions());
		player.setLocation(p.getLocation());
		player.setDivision(p.getDivision());
		player.setTier(p.getTier());
		player.setLenguages(p.getLenguages());
		player.setEmail(p.getEmail());
		player.setRoles(p.getRoles());
	}
	
}


