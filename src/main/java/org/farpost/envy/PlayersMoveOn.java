package org.farpost.envy;

import org.farpost.geometry.*;

import static java.lang.Thread.sleep;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayersMoveOn implements Runnable {

	private final Iterable<? extends Player> players;
	private final List<PlayersEventObserver> observers = new CopyOnWriteArrayList<PlayersEventObserver>();

	public PlayersMoveOn(Iterable<? extends Player> players) {
		this.players = players;
	}

	public void run() {
		try {
			while ( true ) {
				for ( Player player : players ) {
					synchronized ( player ) {
						Point location = player.getLocation();
						org.farpost.geometry.Vector speedVector = player.getSpeedVector();
						Point newLocation = speedVector.calculateEndPoint(location);
						if ( newLocation.getX() < 10 || newLocation.getY() < 10 ) {
							continue;
						}
						player.move(newLocation);
					}
				}

				notifyObservers();
				sleep(50);
			}
		} catch ( InterruptedException e ) {
			System.out.println("Stopping thread");
		}
	}

	public void registerObserver(PlayersEventObserver observer) {
		observers.add(observer);
	}

	private void notifyObservers() {
		for ( PlayersEventObserver observer : observers ) {
			observer.playersChangePosition();
		}
	}
}
