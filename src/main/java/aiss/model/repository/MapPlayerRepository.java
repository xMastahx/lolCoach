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
		
		Player Mastah = new Player();
		List<String> Mastahchampions = new ArrayList<String>();
		List<String> Mastahlenguages = new ArrayList<String>();
		List<String> Mastahroles = new ArrayList<String>();
		Mastahchampions.add("Lulu");
		Mastahlenguages.add("Spanish");
		Mastahroles.add("Support");
		Mastah.setChampions(Mastahchampions);
		Mastah.setDivision("V");
		Mastah.setEmail("mastah@gmail.com");
		Mastah.setLenguages(Mastahlenguages);
		Mastah.setLocation("EUW");
		Mastah.setSummonerName("Mastah");
		Mastah.setTier("Platinum");
		Mastah.setPassword("mastah");
		Mastah.setRoles(Mastahroles);
		addPlayer(Mastah);
		
		Player Faker = new Player();
		List<String> Fakerchampions = new ArrayList<String>();
		List<String> Fakerlenguages = new ArrayList<String>();
		List<String> Fakerroles = new ArrayList<String>();
		Fakerchampions.add("Orianna");
		Fakerlenguages.add("Korean");
		Fakerroles.add("Mid");
		Faker.setChampions(Fakerchampions);
		Faker.setDivision("I");
		Faker.setEmail("Faker@gmail.com");
		Faker.setLenguages(Fakerlenguages);
		Faker.setLocation("KOREA");
		Faker.setSummonerName("Faker");
		Faker.setTier("Challenger");
		Faker.setPassword("Faker");
		Faker.setRoles(Fakerroles);
		addPlayer(Faker);
		
		Player Tyler1 = new Player();
		List<String> Tyler1champions = new ArrayList<String>();
		List<String> Tyler1lenguages = new ArrayList<String>();
		List<String> Tyler1roles = new ArrayList<String>();
		Tyler1champions.add("Draven");
		Tyler1lenguages.add("English");
		Tyler1roles.add("Marksman");
		Tyler1.setChampions(Tyler1champions);
		Tyler1.setDivision("I");
		Tyler1.setEmail("bestdravenna@gmail.com");
		Tyler1.setLenguages(Tyler1lenguages);
		Tyler1.setLocation("NA");
		Tyler1.setSummonerName("Tyler1");
		Tyler1.setTier("Challenger");
		Tyler1.setPassword("tyler");
		Tyler1.setRoles(Tyler1roles);
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
		return playerMap.get(id);
	}
	
	public Player getPlayerCopy(String id){
		Player playerCopy = new Player (playerMap.get(id));
		return playerCopy;
	}
	
	public Collection<Player> getCopyAllPlayers(){
		Set<String> keySet = playerMap.keySet();
		Map<String, Player> copyPlayers = new HashMap<String,Player>();
		for (String s : keySet){
			Player playerCopy = getPlayerCopy(s);
			copyPlayers.put(s, playerCopy);
		}
		return copyPlayers.values();
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


