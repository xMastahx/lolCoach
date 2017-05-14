package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		champions.add("Draven");
		lenguages.add("English");
		Tyler1.setChampions(champions);
		Tyler1.setDivision("Challenger");
		Tyler1.setEmail("bestdravenna@gmail.com");
		Tyler1.setLenguages(lenguages);
		Tyler1.setLocation("NA");
		Tyler1.setSummonerName("Tyler1");
		Tyler1.setTier("I");
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
			return playerMap.values();
	}

	@Override
	public Player getPlayer(String id) {
		return playerMap.get(id);
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
		
	}
	
}


