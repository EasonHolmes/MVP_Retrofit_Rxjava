package com.cui.mrr.entity;

import java.util.List;

/**
 * Created by cuiyang on 16/6/20.
 */
public class ListEntity {


    /**
     * error : false
     * results : [{"_id":"5760b303421aa940e70aa911","createdAt":"2016-06-15T09:44:35.925Z","desc":"直接看图，，不用看描述。","publishedAt":"2016-06-15T11:55:46.992Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/mw690/692a6bbcgw1f4fz6g6wppj20ms0xp13n.jpg","used":true,"who":"龙龙童鞋"},{"_id":"5760b2ee421aa940eb4e0f81","createdAt":"2016-06-15T09:44:14.179Z","desc":"直接看图，，不用看描述。","publishedAt":"2016-06-16T12:19:00.930Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/mw690/692a6bbcgw1f4fz7s830fj20gg0o00y5.jpg","used":true,"who":"龙龙童鞋"},{"_id":"5760a606421aa940f1b54acf","createdAt":"2016-06-15T08:49:10.942Z","desc":"本田翼","publishedAt":"2016-06-17T12:04:39.386Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f4vmdn2f5nj20kq0rm755.jpg","used":true,"who":"代码家"},{"_id":"575e0824421aa9296bddf5a4","createdAt":"2016-06-13T09:11:00.530Z","desc":"直接看图，，不用看描述。","publishedAt":"2016-06-14T11:52:47.320Z","source":"web","type":"福利","url":"http://ww3.sinaimg.cn/mw690/81309c56jw1f4sx4ybttdj20ku0vd0ym.jpg","used":true,"who":"龙龙童鞋"},{"_id":"575cd951421aa90d6d6a3367","createdAt":"2016-06-12T11:38:57.849Z","desc":"6.12","publishedAt":"2016-06-20T12:31:26.789Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f4saelbb4oj20zk0qoage.jpg","used":true,"who":"代码家"},{"_id":"575cbba1421aa96b24382520","createdAt":"2016-06-12T09:32:17.746Z","desc":"跟上一个是一个系列的。","publishedAt":"2016-06-13T11:38:17.247Z","source":"web","type":"福利","url":"http://ww4.sinaimg.cn/mw690/9844520fjw1f4fqrpw1fvj21911wlb2b.jpg","used":true,"who":"龙龙童鞋"},{"_id":"575cbb83421aa96b20caface","createdAt":"2016-06-12T09:31:47.329Z","desc":"直接看图，，不用看描述。","publishedAt":"2016-06-12T12:04:04.308Z","source":"web","type":"福利","url":"http://ww4.sinaimg.cn/mw690/9844520fjw1f4fqribdg1j21911w0kjn.jpg","used":true,"who":"龙龙童鞋"},{"_id":"5757975b421aa90eca080dd5","createdAt":"2016-06-08T11:56:11.8Z","desc":"6.8","publishedAt":"2016-06-08T12:39:36.270Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f4nog8tjfrj20eg0mgab7.jpg","used":true,"who":"daimajia"},{"_id":"575640bf421aa9759750aee4","createdAt":"2016-06-07T11:34:23.596Z","desc":"隐藏福利","publishedAt":"2016-06-07T11:43:18.947Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f4mi70ns1bj20i20vedkh.jpg","used":true,"who":"代码家"},{"_id":"575446dd421aa948eea75a32","createdAt":"2016-06-05T23:35:57.64Z","desc":"怎么会有一只狗","publishedAt":"2016-06-06T12:24:22.149Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f4kron1wqaj20ia0rf436.jpg","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 5760b303421aa940e70aa911
     * createdAt : 2016-06-15T09:44:35.925Z
     * desc : 直接看图，，不用看描述。
     * publishedAt : 2016-06-15T11:55:46.992Z
     * source : web
     * type : 福利
     * url : http://ww1.sinaimg.cn/mw690/692a6bbcgw1f4fz6g6wppj20ms0xp13n.jpg
     * used : true
     * who : 龙龙童鞋
     */

    private List<ResultsEntity> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public  class ResultsEntity {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
