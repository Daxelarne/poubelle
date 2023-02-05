package daxelarne.knightworld.poubelle;

import static org.bukkit.Bukkit.getPlayer;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	private FileConfiguration config;
	private String poubelleName="§2§lPoubelle";
	private int poubelleSize=0;

	//Au démarrage
    @Override
    public void onEnable() {
    	super.onEnable();
    	this.getLogger().log(Level.INFO, "Chargement...");
    	
    	//On créer la config si elle n'existe pas
    	saveDefaultConfig();
    	//On récupère la config
        config = getConfig();
        
        //On initialise les champs
        poubelleSize=config.getInt("poubelleRows")*9;
        //Limite à des tailles maximales définis par java
        if(poubelleSize > 54) poubelleSize=54;
        if(poubelleSize < 0) poubelleSize=0;
        
        poubelleName=config.getString("poubelleName");
    	
    	this.getLogger().log(Level.INFO, "Chargé !");
    }
    
    //Capte les commandes serveurs
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
    	//Si la commande est poubelle
    	if(command.getName().equals("poubelle")) {
    		
    		//On récupère le joueur qui à tappé la commande
    		Player joueur = getPlayer(sender.getName());
    		
    		//On créé une poubelle
    		Poubelle poubelle = new Poubelle(poubelleSize, poubelleName);
    		
    		//On lui affiche la poubelle
    		poubelle.openInv(joueur);
    	}
   
    	return true;
    }

}
