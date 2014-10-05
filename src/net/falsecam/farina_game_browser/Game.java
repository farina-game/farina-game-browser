package net.falsecam.farina_game_browser;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Query.SortDirection;

@PersistenceCapable
public class Game {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	@Persistent
	private Date lastUpdate;

	@Persistent
	private String name;

	@Persistent
	private String host;

	@Persistent
	private String port;

	public Game(String name, String host, String port) {
		this.name = name;
		this.host = host;
		this.port = port;
	}

	/**
	 * stores the game
	 * 
	 * @return the key for the game
	 */
	public String store() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		int counter = 1;
		String origname = name;
		while (true) {
			Query q = pm.newQuery(Game.class, "name == '" + name + "'");

			@SuppressWarnings("unchecked")
			List<Game> results = (List<Game>) q.execute();
			if (results.size() > 0) {
				counter++;
				name = origname + "(" + counter + ")";
			} else {
				break;
			}
		}

		lastUpdate = new Date();
		try {
			pm.makePersistent(this);
		} finally {
			pm.close();
		}
		return key;
	}

	/**
	 * 
	 * @return stored games as game list ordered by name ascending.
	 */
	public static List<Game> getGames() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Game.class);
		q.setOrdering("name asc");
		List<Game> results = (List<Game>) q.execute();
		return results;
	}

	public String getName() {
		return name;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

}
