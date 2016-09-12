package com.rayzr522.webserver;

import javax.swing.LookAndFeel;

public class SharpLookAndFeel extends LookAndFeel {

	@Override
	public String getName() {
		return "Sharp";
	}

	@Override
	public String getID() {
		return "Sharp";
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public boolean isNativeLookAndFeel() {
		return false;
	}

	@Override
	public boolean isSupportedLookAndFeel() {
		return false;
	}

}
