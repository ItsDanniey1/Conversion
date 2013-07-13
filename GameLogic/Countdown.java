package me.ItsDanniey1.Conversion.GameLogic;

import me.ItsDanniey1.Conversion.GameLogic.EndCount;
import me.ItsDanniey1.Conversion.Conversion;

import me.ItsDanniey1.Conversion.GameLogic.GameState;
import me.ItsDanniey1.Conversion.GameLogic.StateManager;
import me.ItsDanniey1.Conversion.GameLogic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Countdown implements Runnable {

	public static Conversion plugin;

	private static int taskID;
	private int tick = 0;

	@Override
	public void run() {

		if (tick == 0) {
			Conversion.prepGame();

			GameManager.cancelTask();
		}

		if (tick <= 9) {
			Utils.broadcast(ChatColor.YELLOW + "Game starting in "
					+ ChatColor.GREEN + (10 - tick) + " seconds");
		}

		if (tick == 10) {
			StateManager.setState(GameState.IN_PROGRESS);
			Conversion.startGame();
			Utils.broadcast(ChatColor.GREEN + "Game has STARTED!");
		}


		if (tick == 310) {
			//Restock.finishGame();
			
			EndCount cd = new EndCount();
			cd.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(Conversion.plugin, cd, 0L, 20L));
				}
		tick++;

	}

	public void setTaskID(int i) {
		this.taskID = i;
	}

	public static void cancelTask() {
		Bukkit.getServer().getScheduler().cancelTask(taskID);
	}

}
