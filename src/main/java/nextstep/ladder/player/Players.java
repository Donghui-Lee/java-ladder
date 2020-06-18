package nextstep.ladder.player;

import java.util.Collections;
import java.util.List;

import nextstep.ladder.util.CustomCollectionUtils;

public class Players {

	private final List<Player> players;

	private Players(List<Player> players) {
		this.players = players;
	}

	public static Players ofPlayers(List<Player> players) {
		validatePlayerNumIsLargerThanZero(players);
		validatePlayerNameDistinct(players);
		return new Players(players);
	}

	private static void validatePlayerNumIsLargerThanZero(List<Player> players) {
		if (CustomCollectionUtils.isNull(players) || CustomCollectionUtils.isEmpty(players)) {
			throw new IllegalArgumentException(
				"Players count should be larger than one. Otherwise, you can't play this game XD");
		}
	}

	private static void validatePlayerNameDistinct(List<Player> players) {
		if (getDistinctNameCount(players) != players.size()) {
			throw new IllegalArgumentException("please double check whether player name is not distinct.");
		}
	}

	public int getSize() {
		return players.size();
	}

	public static Long getDistinctNameCount(List<Player> players) {
		return players.stream()
			.map(Player::getName)
			.distinct()
			.count();
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public void printPlayers() {
		players.forEach(
			player -> System.out.printf("%-6s", player.getName())
		);
		System.out.println();
	}
}
