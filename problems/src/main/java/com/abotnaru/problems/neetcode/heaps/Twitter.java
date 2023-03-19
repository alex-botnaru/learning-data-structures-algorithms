package com.abotnaru.problems.neetcode.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	private TwitterService service = new TwitterService();

	public void postTweet(int userId, int tweetId) {
		service.postTweet(userId, tweetId);
	}

	public List<Integer> getNewsFeed(int userId) {
		return service.getNewsFeed(userId);
	}

	public void follow(int followerId, int followeeId) {
		service.follow(followerId, followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		service.unfollow(followerId, followeeId);
	}

	// ==== Helper classes ===

	private static class User {
		int id;
		List<Tweet> tweets = new ArrayList<>();
		Set<Integer> followers = new HashSet<>();

		public User(int id) {
			this.id = id;
			followers.add(this.id);
		}

	}

	private static class Tweet {
		int id;
		int timestamp;

		public Tweet(int id, int timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}
	}

	private static class TwitterService {
		public static int GLOBAL_TIME = 0;
		private Map<Integer, User> userMap = new HashMap<>();

		void addUser(int id) {
			if (!userMap.containsKey(id)) {
				userMap.put(id, new User(id));
			}
		}

		void postTweet(int userId, int tweetId) {
			addUser(userId);
			userMap.get(userId).tweets.add(new Tweet(tweetId, GLOBAL_TIME));
			GLOBAL_TIME++;
		}

		void follow(int followerId, int followeeId) {
			addUser(followerId);
			addUser(followeeId);
			userMap.get(followerId).followers.add(followeeId);
		}

		void unfollow(int followerId, int followeeId) {
			userMap.get(followerId).followers.remove(followeeId);
		}

		List<Integer> getNewsFeed(int userId) {
			List<Integer> result = new ArrayList<>();
			PriorityQueue<Tweet> minHeap = new PriorityQueue<>((t1, t2) -> t1.timestamp - t2.timestamp);

			for (int id : userMap.get(userId).followers) {
				User user = userMap.get(id);
				for (Tweet tweet : user.tweets) {
					minHeap.offer(tweet);
					if (minHeap.size() > 10) {
						minHeap.poll();
					}
				}
			}

			while (!minHeap.isEmpty()) {
				result.add(minHeap.poll().id);
			}

			Collections.reverse(result);
			return result;
		}
	}

}
