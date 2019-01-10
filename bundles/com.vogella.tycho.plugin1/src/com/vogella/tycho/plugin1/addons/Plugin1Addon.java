
package com.vogella.tycho.plugin1.addons;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.event.Event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@SuppressWarnings("restriction")
public class Plugin1Addon {

	@Getter
	@Setter
	private String test = "value";

	@Inject
	@Optional
	public void applicationStarted(@EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event,
			@Optional InterfaceOfComplexFrameworkClass complexFrameworkClass) {
		if (complexFrameworkClass != null) {
			System.out.println("App startet: " + complexFrameworkClass.getFoo() + " " + getTest());
		}
	}
}
