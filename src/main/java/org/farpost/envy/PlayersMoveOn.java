package org.farpost.envy;

import org.farpost.geometry.*;

import static java.lang.Thread.sleep;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayersMoveOn implements Runnable {

	private final Iterable<? extends Player> players;
	private final List<PlayersEventObserver> observers = new CopyOnWriteArrayList<PlayersEventObserver>();

	public PlayersMoveOn(List<Player> players) {
		this.players = players;
	}

	public void run() {
		try {
			while ( true ) {
				for ( Player player : players ) {
					synchronized ( player ) {
						Point location = player.getLocation();
						MovementStrategy strategy = player.getMovementStrategy();
						final Point newLocation = strategy.calculateNextPoint(location);
						if ( newLocation.getX() < 10 || newLocation.getY() < 10 ) {
							continue;
						}
						player.setLocation(newLocation);
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
