package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayerManager;
import de.simonsator.partyandfriends.api.party.PartyManager;
import de.simonsator.partyandfriends.api.party.PlayerParty;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * @author Simonsator
 * @version 1.0.0 25.01.17
 */
public class PartyMemberTabComplete implements Listener {
	@EventHandler
	public void partyTabComplete(TabCompleteEvent pEvent) {
		OnlinePAFPlayer player = PAFPlayerManager.getInstance().getPlayer((ProxiedPlayer) pEvent.getSender());
		PlayerParty party = PartyManager.getInstance().getParty(player);
		if (party == null) return;
		String partialPlayerName = pEvent.getCursor().toLowerCase();
		int lastSpaceIndex = partialPlayerName.lastIndexOf(' ');
		if (lastSpaceIndex >= 0)
			partialPlayerName = partialPlayerName.substring(lastSpaceIndex + 1);
		for (PAFPlayer p : party.getAllPlayers())
			if (!p.equals(player))
				if (p.getName().toLowerCase().startsWith(partialPlayerName))
					if (!pEvent.getSuggestions().contains(p.getName()))
						pEvent.getSuggestions().add(p.getName());
	}

}
