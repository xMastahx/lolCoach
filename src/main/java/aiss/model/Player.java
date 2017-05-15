package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String id;
	private String summonerName;
	private List<String> champions;
	private String location;
	private String tier;
	private String division;
	private List<String> lenguages;
	private String email;
	private String password;
	private List<String> roles;

	public Player() {
	}

	public Player(String summonerName, String password, String tier, String location,
			String division) {
		this.id = null;
		this.summonerName = summonerName;
		this.champions = new ArrayList<String>();
		this.location = location;
		this.tier = tier;
		this.division = division;
		this.lenguages = new ArrayList<String>();
		this.email = null;
		this.password = password;
		this.roles = new ArrayList<String>();
	}
	
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public List<String> getChampions() {
		List<String> res = new ArrayList<String>(this.champions);
		return res;
	}
	
	public void setChampions(List<String> champions){
		this.champions = champions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	public List<String> getLenguages() {
		List<String> res = new ArrayList<String>(this.lenguages);
		return res;
	}
	
	public void setLenguages(List<String> lenguages){
		this.lenguages = lenguages;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public List<String> getRoles(){
		List <String> res = new ArrayList<String>(this.roles);
		return res;
	}
	
	public void setRoles(List<String> roles){
		this.roles = roles;
	}
}
