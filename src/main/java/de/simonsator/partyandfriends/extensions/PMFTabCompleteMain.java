package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.api.PAFExtension;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 25.01.17
 */
public class PMFTabCompleteMain extends PAFExtension implements Listener {
	@Override
	public void onEnable() {
		try {
			Configuration config = new PMFTCConfig(new File(getDataFolder(), "config.yml"), this).getCreatedConfiguration();
			if (config.getBoolean("Use.FriendTabComplete"))
				ProxyServer.getInstance().getPluginManager().registerListener(this, new FriendTabComplete());
			if (config.getBoolean("Use.PartyTabComplete"))
				ProxyServer.getInstance().getPluginManager().registerListener(this, new PartyMemberTabComplete());
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
