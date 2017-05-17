package aiss.model.repository;

import java.util.Collection;

import aiss.model.Player;


public interface PlayerRepository {
	
	
	// Plater
	public void addPlayer(Player p);
	public Collection<Player> getAllPlayers();
	public Player getPlayer(String id);
	public Player getPlayerCopy(String id);
	public Collection<Player> getCopyAllPlayers();
	public void updatePlayer(Player s);
	public void deletePlayer(String id);	


	}
