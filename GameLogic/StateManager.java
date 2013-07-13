package me.ItsDanniey1.Conversion.GameLogic;

import org.bukkit.ChatColor;

import me.ItsDanniey1.Conversion.GameLogic.Utils;

public class StateManager {

	private static GameState STATE = GameState.WAITING;

	public static GameState getState() {
		return STATE;
	}

	public static void setState(GameState gs) {
		
		STATE = gs;

		switch (gs) {
		
		case WAITING:
			break;
		case WARMUP:
			break;
		case IN_PROGRESS:
			break;
		case ENDED:
			break;
		}
	}

}
