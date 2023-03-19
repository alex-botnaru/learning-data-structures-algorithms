package com.abotnaru.problems.neetcode.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class TwitterTest {

	@Test
	void testTwitterClass() {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);

		List<Integer> newsFeed = twitter.getNewsFeed(1);
		assertNotNull(newsFeed);
		assertEquals(1, newsFeed.size());
		assertEquals(5, newsFeed.get(0));

		twitter.follow(1, 2);
		twitter.postTweet(2, 6);

		newsFeed = twitter.getNewsFeed(1);
		assertNotNull(newsFeed);
		assertEquals(2, newsFeed.size());
		assertEquals(6, newsFeed.get(0));
		assertEquals(5, newsFeed.get(1));

		twitter.unfollow(1, 2);
		newsFeed = twitter.getNewsFeed(1);
		assertNotNull(newsFeed);
		assertEquals(1, newsFeed.size());
		assertEquals(5, newsFeed.get(0));
	}

}
