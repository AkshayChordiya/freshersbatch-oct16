package com.hibernate.chat.persist;

/**
 * Singleton
 * @author chordiya_ak
 *
 */
public class PersistanceFactory {
	
	private static PersistanceFactory sPersistanceFactory;

	public static PersistanceFactory getInstance() {
		if (sPersistanceFactory == null) {
			sPersistanceFactory = new PersistanceFactory();
		}
		return sPersistanceFactory;
	}
	
	public Persistance getPersistance(PersistanceType type) {
		switch (type) {
		case INMEMORY:
			return new InMemoryPersistance();
		case HIBERNATE:
			return new HibernatePersistance();
		default:
			return null;
		}
	}
}