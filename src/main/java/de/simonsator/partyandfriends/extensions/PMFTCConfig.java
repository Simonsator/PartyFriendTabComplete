package de.simonsator.partyandfriends.extensions;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 25.01.17
 */
public class PMFTCConfig extends ConfigurationCreator {
	protected PMFTCConfig(File file) throws IOException {
		super(file);
		readFile();
		loadDefaultValues();
		saveFile();
	}

	private void loadDefaultValues() {
		set("Use.FriendTabComplete", true);
		set("Use.PartyTabComplete", true);
	}

	@Override
	public void reloadConfiguration() throws IOException {

	}
}
