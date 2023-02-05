package daxelarne.knightworld.poubelle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Poubelle {
	//Inventaire (vide) de la poubelle
	private final Inventory inv;
	
	//Création d'un inventaire en fonction des parametres de la config
	public Poubelle(int taille, String nom) {
		inv = Bukkit.createInventory(null, taille, nom);		
	}
	
	//Ouverture de la poubelle
	public void openInv(Player joueur) {
		joueur.openInventory(inv);
	}

}
