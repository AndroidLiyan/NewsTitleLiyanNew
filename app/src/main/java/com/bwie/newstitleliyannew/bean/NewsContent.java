package com.bwie.newstitleliyannew.bean;

import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class NewsContent {

    /**
     * postid : CDJE3Q5L0001875M
     * hasCover : false
     * hasHead : 1
     * replyCount : 150663
     * ltitle : 金正男遇刺预言朝鲜崩溃? 专家:可能为时尚早
     * hasImg : 1
     * digest : 金正男的死，让朝鲜再次成为爆款话题。到底谁杀了金正男？舆论言之凿凿。但事实上，这出离奇刺杀案的幕后主使和细节，可能成为一些国家的高度机密，像MH370一样，沉入
     * hasIcon : false
     * docid : CDJE3Q5L0001875M
     * title : 金正男遇刺预言朝鲜崩溃? 专家:可能为时尚早
     * order : 1
     * priority : 102
     * lmodify : 2017-02-19 11:21:15
     * boardid : news2_bbs
     * ads : [{"title":"太原\"三国城\"荒废20年 建造耗资6000万","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/b206f7f3a1864882b87714cc9639ce5120170219104443.jpeg","subtitle":"","url":"00AP0001|2236218"},{"title":"特朗普举行\u201c让美国再次伟大\u201d集会","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/a22265fa54d1402996e76423504778be20170219105700.jpeg","subtitle":"","url":"00AO0001|2236221"},{"title":"探访四川\"熊猫奶爸\"：每天搬100斤竹子","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/92787e9110a14671a27ced59907ec42d20170219090552.jpeg","subtitle":"","url":"00AP0001|2236185"},{"title":"总统只是副业!特朗普高尔夫俱乐部开业","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/d1bea507091f4214a7c6bff09ccee0c820170219090423.jpeg","subtitle":"","url":"00AO0001|2236187"},{"title":"摩苏尔收复在望 伊什叶派民兵整装备战","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/b022fbff52624e45ae8ace07c1fed0ca20170219083435.jpeg","subtitle":"","url":"00AO0001|2236183"}]
     * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
     * url_3w : http://news.163.com/17/0218/22/CDJE3Q5L0001875M.html
     * template : normal1
     * votecount : 146257
     * alias : Top News
     * cid : C1348646712614
     * url : http://3g.163.com/news/17/0218/22/CDJE3Q5L0001875M.html
     * hasAD : 1
     * source : 侠客岛
     * ename : androidnews
     * subtitle :
     * imgsrc : http://cms-bucket.nosdn.127.net/89007f9ade804eb3a9c1af8e335a847f20170218222340.png
     * tname : 头条
     * ptime : 2017-02-18 22:24:03
     * skipID : 00AP0001|2236171
     * skipType : photoset
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/163a15e3854b49809a491ed6a873879020170219081618.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/05b511ba662a4aea9ea1362ef3c9fae420170219081618.jpeg"}]
     * photosetID : 00AP0001|2236171
     * imgsum : 9
     */

    private String postid;
    private boolean hasCover;
    private int hasHead;
    private int replyCount;
    private String ltitle;
    private int hasImg;
    private String digest;
    private boolean hasIcon;
    private String docid;
    private String title;
    private int order;
    private int priority;
    private String lmodify;
    private String boardid;
    private String topic_background;
    private String url_3w;
    private String template;
    private int votecount;
    private String alias;
    private String cid;
    private String url;
    private int hasAD;
    private String source;
    private String ename;
    private String subtitle;
    private String imgsrc;
    private String tname;
    private String ptime;
    private String skipID;
    private String skipType;
    private String photosetID;
    private int imgsum;
    private List<AdsBean> ads;
    private List<ImgextraBean> imgextra;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public int getHasHead() {
        return hasHead;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public int getHasImg() {
        return hasImg;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getTopic_background() {
        return topic_background;
    }

    public void setTopic_background(String topic_background) {
        this.topic_background = topic_background;
    }

    public String getUrl_3w() {
        return url_3w;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHasAD() {
        return hasAD;
    }

    public void setHasAD(int hasAD) {
        this.hasAD = hasAD;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getSkipID() {
        return skipID;
    }

    public void setSkipID(String skipID) {
        this.skipID = skipID;
    }

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public String getPhotosetID() {
        return photosetID;
    }

    public void setPhotosetID(String photosetID) {
        this.photosetID = photosetID;
    }

    public int getImgsum() {
        return imgsum;
    }

    public void setImgsum(int imgsum) {
        this.imgsum = imgsum;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public static class AdsBean {
        /**
         * title : 太原"三国城"荒废20年 建造耗资6000万
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/b206f7f3a1864882b87714cc9639ce5120170219104443.jpeg
         * subtitle :
         * url : 00AP0001|2236218
         */

        private String title;
        private String tag;
        private String imgsrc;
        private String subtitle;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImgextraBean {
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/163a15e3854b49809a491ed6a873879020170219081618.jpeg
         */

        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
