package net.engio.mbassy.spring.boot.hooks;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.spring.boot.event.MBassadorEvent;

public class MBassadorShutdownHook extends Thread{
	
	private MBassador<MBassadorEvent> mbassador;
	
	public MBassadorShutdownHook(MBassador<MBassadorEvent> mbassador) {
		this.mbassador = mbassador;
	}
	
	@Override
	public void run() {
		mbassador.shutdown();
	}
	
}
