package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 25.01.17
 */
public class PMFTCConfig extends ConfigurationCreator {
	protected PMFTCConfig(File file, Plugin pPlugin) throws IOException {
		super(file, pPlugin);
		readFile();
		loadDefaultValues();
		saveFile();
	}

	private void loadDefaultValues() {
		set("Use.FriendTabComplete", true);
		set("Use.PartyTabComplete", true);
	}

}
