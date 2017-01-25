package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayerManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * @author Simonsator
 * @version 1.0.0 25.01.17
 */
public class FriendTabComplete implements Listener {
	@EventHandler
	public void friendTabComplete(TabCompleteEvent pEvent) {
		OnlinePAFPlayer player = PAFPlayerManager.getInstance().getPlayer((ProxiedPlayer) pEvent.getSender());
		String partialPlayerName = pEvent.getCursor().toLowerCase();
		int lastSpaceIndex = partialPlayerName.lastIndexOf(' ');
		if (lastSpaceIndex >= 0)
			partialPlayerName = partialPlayerName.substring(lastSpaceIndex + 1);
		for (PAFPlayer p : player.getFriends())
			if (p.getName().toLowerCase().startsWith(partialPlayerName))
				if (!pEvent.getSuggestions().contains(p.getName()))
					pEvent.getSuggestions().add(p.getName());
	}

}
