class Twitter {
    public class Tweet {
        public int tweetId;
        public int userId;

        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    public List<Tweet> tweetsToUserMap;
    public Map<Integer,List<Integer>> userToFollowersMap;
    public Map<Integer, List<Integer>> userToTweetsMap;

    public Twitter() {
        // tweets to userMapping
        this.tweetsToUserMap = new ArrayList<>();

        // store userId -> List of followers
        this.userToFollowersMap = new LinkedHashMap<>();

        // tweets from each user - userId -> List of tweets
        this.userToTweetsMap = new LinkedHashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // if (!userToTweetsMap.containsKey(userId)) {
        //     List<Integer> tweetIds = new ArrayList<>();
        //     tweetIds.add(tweetId);

        //     this.userToTweetsMap.put(userId, tweetIds);
        // } else {
        //     List<Integer> tweets = userToTweetsMap.get(userId);
        //     tweets.add(tweetId);

        //     this.userToTweetsMap.put(userId, tweets);
        // }

        // Add to global tweets
        this.tweetsToUserMap.add(new Tweet(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        int count = 0;

        for (int i = this.tweetsToUserMap.size() - 1; i >= 0 && count < 10; i--) {
            // check if a specific tweet is from user or the accounts his followes
            if (checkIfTheAccountIsFollowedByUser(userId, this.tweetsToUserMap.get(i))) {
                tweets.add(tweetsToUserMap.get(i).tweetId);
                count++;
            }
        }

        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!this.userToFollowersMap.containsKey(followerId)) {
            List<Integer> followers = new ArrayList<>();
            followers.add(followeeId);

            this.userToFollowersMap.put(followerId, followers);
        } else {
            List<Integer> followers = this.userToFollowersMap.get(followerId);

            // check If follower already exist
            int idx = followers.indexOf(followeeId);

            if (idx != -1) {
                return;
            }

            followers.add(followeeId);

            this.userToFollowersMap.put(followerId, followers);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!this.userToFollowersMap.containsKey(followerId)) {
            return;
        }

        List<Integer> followers = this.userToFollowersMap.get(followerId);

        if (followers == null || followers.size() == 0) {
            return;
        }

        int idx = followers.indexOf(followeeId);
        
        if (idx != -1) {
            followers.remove(idx);
            this.userToFollowersMap.put(followerId, followers);
        }
    }

    private boolean checkIfTheAccountIsFollowedByUser(int userId, Tweet tweet) {
        // check if the tweet is made by user
        if (tweet.userId == userId) {
            return true;
        }

        // check if the user follows that account or not
        List<Integer> followers = this.userToFollowersMap.get(userId);

        if (followers == null || followers.size() == 0) {
            return false;
        }

        if (followers.indexOf(tweet.userId) != -1) {
            return true;
        }

        return false;
    }
}
