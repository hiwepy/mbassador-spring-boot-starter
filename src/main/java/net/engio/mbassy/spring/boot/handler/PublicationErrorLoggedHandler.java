package net.engio.mbassy.spring.boot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;

public class PublicationErrorLoggedHandler implements IPublicationErrorHandler {

	private static final Logger LOG = LoggerFactory.getLogger(PublicationErrorLoggedHandler.class);

	private final boolean printStackTrace;

	public PublicationErrorLoggedHandler() {
		this(false);
	}

	public PublicationErrorLoggedHandler(boolean printStackTrace) {
		this.printStackTrace = printStackTrace;
	}

	@Override
	public void handleError(PublicationError error) {

		// Logger the error itself
		LOG.error(error.toString());

		// Logger the stacktrace from the cause.
		if (printStackTrace && error.getCause() != null) {
			LOG.error(error.toString());
			error.getCause().printStackTrace();
		}

	}

}
