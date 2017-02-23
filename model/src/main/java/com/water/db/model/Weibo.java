package com.water.db.model;

import java.io.Serializable;
import java.util.Date;

public class Weibo implements Serializable {
    private String id;

    private String user_id;

    private String text;

    private Integer reposts_count;

    private Integer comments_count;

    private Integer attitudes_count;

    private String video_id;

    private String pic_ids;

    private String src_tid;

    private String visible;

    private String source;

    private String geo;

    private Date timeline;

    private Date last_updatime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(Integer reposts_count) {
        this.reposts_count = reposts_count;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }

    public Integer getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(Integer attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id == null ? null : video_id.trim();
    }

    public String getPic_ids() {
        return pic_ids;
    }

    public void setPic_ids(String pic_ids) {
        this.pic_ids = pic_ids == null ? null : pic_ids.trim();
    }

    public String getSrc_tid() {
        return src_tid;
    }

    public void setSrc_tid(String src_tid) {
        this.src_tid = src_tid == null ? null : src_tid.trim();
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo == null ? null : geo.trim();
    }

    public Date getTimeline() {
        return timeline;
    }

    public void setTimeline(Date timeline) {
        this.timeline = timeline;
    }

    public Date getLast_updatime() {
        return last_updatime;
    }

    public void setLast_updatime(Date last_updatime) {
        this.last_updatime = last_updatime;
    }
}