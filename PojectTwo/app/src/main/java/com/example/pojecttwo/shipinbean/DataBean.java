package com.example.pojecttwo.shipinbean;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public class DataBean {
    /**
     * id : 1578919905
     * itemId : 6825960242983999755
     * itemType : 2
     * createTime : 1589292717
     * duration : 11.471
     * feeds_text : 这是什么神操作？
     * authorId : 2739619955737415
     * activityIcon : https://sf1-nhcdn-tos.pstatp.com/obj/p1056/88c5ea2b90134313b99cf2f9a87e9ca1
     * activityText : 专业团队
     * width : 544
     * height : 672
     * url : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/6825960242983999755.mp4
     * cover : https://p1-ppx.byteimg.com/img/mosaic-legacy/308d30000b2f98fed5dae~544x672_q80.jpeg
     * author : {"id":1864,"userId":2739619955737415,"name":"灵魂修养寓言师","avatar":"https://p1-ppx.byteimg.com/img/tos-cn-i-0000/d9e6dc8d881247388aca4c44a5831426~200x200.jpeg","description":"知足上进，真诚无价！ 淡定从容，睿智有趣。","likeCount":0,"topCommentCount":0,"followCount":0,"followerCount":2,"qqOpenId":null,"expires_time":0,"score":0,"historyCount":0,"commentCount":0,"favoriteCount":0,"feedCount":0,"hasFollow":false}
     * topComment : null
     * ugc : {"likeCount":8829,"shareCount":870,"commentCount":1343,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}
     */

    private int id;
    private long itemId;
    private int itemType;
    private int createTime;
    private double duration;
    private String feeds_text;
    private long authorId;
    private String activityIcon;
    private String activityText;
    private int width;
    private int height;
    private String url;
    private String cover;
    private AuthorBean author;
    private Object topComment;
    private UgcBean ugc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getFeeds_text() {
        return feeds_text;
    }

    public void setFeeds_text(String feeds_text) {
        this.feeds_text = feeds_text;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getActivityIcon() {
        return activityIcon;
    }

    public void setActivityIcon(String activityIcon) {
        this.activityIcon = activityIcon;
    }

    public String getActivityText() {
        return activityText;
    }

    public void setActivityText(String activityText) {
        this.activityText = activityText;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public Object getTopComment() {
        return topComment;
    }

    public void setTopComment(Object topComment) {
        this.topComment = topComment;
    }

    public UgcBean getUgc() {
        return ugc;
    }

    public void setUgc(UgcBean ugc) {
        this.ugc = ugc;
    }

    public static class AuthorBean {
        /**
         * id : 1864
         * userId : 2739619955737415
         * name : 灵魂修养寓言师
         * avatar : https://p1-ppx.byteimg.com/img/tos-cn-i-0000/d9e6dc8d881247388aca4c44a5831426~200x200.jpeg
         * description : 知足上进，真诚无价！ 淡定从容，睿智有趣。
         * likeCount : 0
         * topCommentCount : 0
         * followCount : 0
         * followerCount : 2
         * qqOpenId : null
         * expires_time : 0
         * score : 0
         * historyCount : 0
         * commentCount : 0
         * favoriteCount : 0
         * feedCount : 0
         * hasFollow : false
         */

        private int id;
        private long userId;
        private String name;
        private String avatar;
        private String description;
        private int likeCount;
        private int topCommentCount;
        private int followCount;
        private int followerCount;
        private Object qqOpenId;
        private int expires_time;
        private int score;
        private int historyCount;
        private int commentCount;
        private int favoriteCount;
        private int feedCount;
        private boolean hasFollow;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getTopCommentCount() {
            return topCommentCount;
        }

        public void setTopCommentCount(int topCommentCount) {
            this.topCommentCount = topCommentCount;
        }

        public int getFollowCount() {
            return followCount;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public int getFollowerCount() {
            return followerCount;
        }

        public void setFollowerCount(int followerCount) {
            this.followerCount = followerCount;
        }

        public Object getQqOpenId() {
            return qqOpenId;
        }

        public void setQqOpenId(Object qqOpenId) {
            this.qqOpenId = qqOpenId;
        }

        public int getExpires_time() {
            return expires_time;
        }

        public void setExpires_time(int expires_time) {
            this.expires_time = expires_time;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getHistoryCount() {
            return historyCount;
        }

        public void setHistoryCount(int historyCount) {
            this.historyCount = historyCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(int favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public int getFeedCount() {
            return feedCount;
        }

        public void setFeedCount(int feedCount) {
            this.feedCount = feedCount;
        }

        public boolean isHasFollow() {
            return hasFollow;
        }

        public void setHasFollow(boolean hasFollow) {
            this.hasFollow = hasFollow;
        }
    }

    public static class UgcBean {
        /**
         * likeCount : 8829
         * shareCount : 870
         * commentCount : 1343
         * hasFavorite : false
         * hasLiked : false
         * hasdiss : false
         * hasDissed : false
         */

        private int likeCount;
        private int shareCount;
        private int commentCount;
        private boolean hasFavorite;
        private boolean hasLiked;
        private boolean hasdiss;
        private boolean hasDissed;

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public boolean isHasFavorite() {
            return hasFavorite;
        }

        public void setHasFavorite(boolean hasFavorite) {
            this.hasFavorite = hasFavorite;
        }

        public boolean isHasLiked() {
            return hasLiked;
        }

        public void setHasLiked(boolean hasLiked) {
            this.hasLiked = hasLiked;
        }

        public boolean isHasdiss() {
            return hasdiss;
        }

        public void setHasdiss(boolean hasdiss) {
            this.hasdiss = hasdiss;
        }

        public boolean isHasDissed() {
            return hasDissed;
        }

        public void setHasDissed(boolean hasDissed) {
            this.hasDissed = hasDissed;
        }
    }
}
