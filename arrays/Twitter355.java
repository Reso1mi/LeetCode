import java.util.*;
public class Twitter355{
    public static void main(String[] args) {
        Twitter  tw=new Twitter();
        tw.postTweet(1,3);
        tw.getNewsFeed(1);
    }
}

class Twitter {
    //全局时间戳
    private  int timeStamp=0;
    //Tweet是有序链表,按照时间戳来排序
    private  Map<Integer,Tweet> userTweetMap=new HashMap<>();
    //followMap
    private  Map<Integer,Set<Integer>> userFollowMap=new HashMap<>();;

    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        Tweet oldHead=userTweetMap.get(userId);
        userTweetMap.compute(userId,(k,v)->new Tweet(tweetId,++timeStamp)).next=oldHead;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((t1,t2)->t2.time-t1.time);
        List<Integer> feed=new ArrayList<>();
        follow(userId,userId);
        userFollowMap.get(userId).forEach(followerId->Optional.ofNullable(userTweetMap.get(followerId)).ifPresent(tw->pq.offer(tw)));
        int count=0;
        while(!pq.isEmpty() && count<10){
            Tweet tw=pq.poll();
            feed.add(tw.twId);
            if(tw.next!=null){
                pq.offer(tw.next);
            }
            count++;
        }
        return feed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(userFollowMap.get(followerId)).ifPresent(set->set.remove(followeeId));
    }
}

class Tweet{
    int twId;
    int time;
    Tweet next;
    public Tweet(int twId,int time){
        this.twId=twId;
        this.time=time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */