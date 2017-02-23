package com.water.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeiboCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeiboCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(String value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(String value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(String value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(String value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLike(String value) {
            addCriterion("user_id like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotLike(String value) {
            addCriterion("user_id not like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<String> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<String> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andReposts_countIsNull() {
            addCriterion("reposts_count is null");
            return (Criteria) this;
        }

        public Criteria andReposts_countIsNotNull() {
            addCriterion("reposts_count is not null");
            return (Criteria) this;
        }

        public Criteria andReposts_countEqualTo(Integer value) {
            addCriterion("reposts_count =", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countNotEqualTo(Integer value) {
            addCriterion("reposts_count <>", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countGreaterThan(Integer value) {
            addCriterion("reposts_count >", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("reposts_count >=", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countLessThan(Integer value) {
            addCriterion("reposts_count <", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countLessThanOrEqualTo(Integer value) {
            addCriterion("reposts_count <=", value, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countIn(List<Integer> values) {
            addCriterion("reposts_count in", values, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countNotIn(List<Integer> values) {
            addCriterion("reposts_count not in", values, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count between", value1, value2, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andReposts_countNotBetween(Integer value1, Integer value2) {
            addCriterion("reposts_count not between", value1, value2, "reposts_count");
            return (Criteria) this;
        }

        public Criteria andComments_countIsNull() {
            addCriterion("comments_count is null");
            return (Criteria) this;
        }

        public Criteria andComments_countIsNotNull() {
            addCriterion("comments_count is not null");
            return (Criteria) this;
        }

        public Criteria andComments_countEqualTo(Integer value) {
            addCriterion("comments_count =", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countNotEqualTo(Integer value) {
            addCriterion("comments_count <>", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countGreaterThan(Integer value) {
            addCriterion("comments_count >", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("comments_count >=", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countLessThan(Integer value) {
            addCriterion("comments_count <", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countLessThanOrEqualTo(Integer value) {
            addCriterion("comments_count <=", value, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countIn(List<Integer> values) {
            addCriterion("comments_count in", values, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countNotIn(List<Integer> values) {
            addCriterion("comments_count not in", values, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countBetween(Integer value1, Integer value2) {
            addCriterion("comments_count between", value1, value2, "comments_count");
            return (Criteria) this;
        }

        public Criteria andComments_countNotBetween(Integer value1, Integer value2) {
            addCriterion("comments_count not between", value1, value2, "comments_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countIsNull() {
            addCriterion("attitudes_count is null");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countIsNotNull() {
            addCriterion("attitudes_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countEqualTo(Integer value) {
            addCriterion("attitudes_count =", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countNotEqualTo(Integer value) {
            addCriterion("attitudes_count <>", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countGreaterThan(Integer value) {
            addCriterion("attitudes_count >", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("attitudes_count >=", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countLessThan(Integer value) {
            addCriterion("attitudes_count <", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countLessThanOrEqualTo(Integer value) {
            addCriterion("attitudes_count <=", value, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countIn(List<Integer> values) {
            addCriterion("attitudes_count in", values, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countNotIn(List<Integer> values) {
            addCriterion("attitudes_count not in", values, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countBetween(Integer value1, Integer value2) {
            addCriterion("attitudes_count between", value1, value2, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andAttitudes_countNotBetween(Integer value1, Integer value2) {
            addCriterion("attitudes_count not between", value1, value2, "attitudes_count");
            return (Criteria) this;
        }

        public Criteria andVideo_idIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideo_idIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_idEqualTo(String value) {
            addCriterion("video_id =", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotEqualTo(String value) {
            addCriterion("video_id <>", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idGreaterThan(String value) {
            addCriterion("video_id >", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idGreaterThanOrEqualTo(String value) {
            addCriterion("video_id >=", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLessThan(String value) {
            addCriterion("video_id <", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLessThanOrEqualTo(String value) {
            addCriterion("video_id <=", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLike(String value) {
            addCriterion("video_id like", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotLike(String value) {
            addCriterion("video_id not like", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idIn(List<String> values) {
            addCriterion("video_id in", values, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotIn(List<String> values) {
            addCriterion("video_id not in", values, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idBetween(String value1, String value2) {
            addCriterion("video_id between", value1, value2, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotBetween(String value1, String value2) {
            addCriterion("video_id not between", value1, value2, "video_id");
            return (Criteria) this;
        }

        public Criteria andPic_idsIsNull() {
            addCriterion("pic_ids is null");
            return (Criteria) this;
        }

        public Criteria andPic_idsIsNotNull() {
            addCriterion("pic_ids is not null");
            return (Criteria) this;
        }

        public Criteria andPic_idsEqualTo(String value) {
            addCriterion("pic_ids =", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsNotEqualTo(String value) {
            addCriterion("pic_ids <>", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsGreaterThan(String value) {
            addCriterion("pic_ids >", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsGreaterThanOrEqualTo(String value) {
            addCriterion("pic_ids >=", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsLessThan(String value) {
            addCriterion("pic_ids <", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsLessThanOrEqualTo(String value) {
            addCriterion("pic_ids <=", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsLike(String value) {
            addCriterion("pic_ids like", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsNotLike(String value) {
            addCriterion("pic_ids not like", value, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsIn(List<String> values) {
            addCriterion("pic_ids in", values, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsNotIn(List<String> values) {
            addCriterion("pic_ids not in", values, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsBetween(String value1, String value2) {
            addCriterion("pic_ids between", value1, value2, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andPic_idsNotBetween(String value1, String value2) {
            addCriterion("pic_ids not between", value1, value2, "pic_ids");
            return (Criteria) this;
        }

        public Criteria andSrc_tidIsNull() {
            addCriterion("src_tid is null");
            return (Criteria) this;
        }

        public Criteria andSrc_tidIsNotNull() {
            addCriterion("src_tid is not null");
            return (Criteria) this;
        }

        public Criteria andSrc_tidEqualTo(String value) {
            addCriterion("src_tid =", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidNotEqualTo(String value) {
            addCriterion("src_tid <>", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidGreaterThan(String value) {
            addCriterion("src_tid >", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidGreaterThanOrEqualTo(String value) {
            addCriterion("src_tid >=", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidLessThan(String value) {
            addCriterion("src_tid <", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidLessThanOrEqualTo(String value) {
            addCriterion("src_tid <=", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidLike(String value) {
            addCriterion("src_tid like", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidNotLike(String value) {
            addCriterion("src_tid not like", value, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidIn(List<String> values) {
            addCriterion("src_tid in", values, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidNotIn(List<String> values) {
            addCriterion("src_tid not in", values, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidBetween(String value1, String value2) {
            addCriterion("src_tid between", value1, value2, "src_tid");
            return (Criteria) this;
        }

        public Criteria andSrc_tidNotBetween(String value1, String value2) {
            addCriterion("src_tid not between", value1, value2, "src_tid");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNull() {
            addCriterion("visible is null");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNotNull() {
            addCriterion("visible is not null");
            return (Criteria) this;
        }

        public Criteria andVisibleEqualTo(String value) {
            addCriterion("visible =", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotEqualTo(String value) {
            addCriterion("visible <>", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThan(String value) {
            addCriterion("visible >", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThanOrEqualTo(String value) {
            addCriterion("visible >=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThan(String value) {
            addCriterion("visible <", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThanOrEqualTo(String value) {
            addCriterion("visible <=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLike(String value) {
            addCriterion("visible like", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotLike(String value) {
            addCriterion("visible not like", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleIn(List<String> values) {
            addCriterion("visible in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotIn(List<String> values) {
            addCriterion("visible not in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleBetween(String value1, String value2) {
            addCriterion("visible between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotBetween(String value1, String value2) {
            addCriterion("visible not between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andGeoIsNull() {
            addCriterion("geo is null");
            return (Criteria) this;
        }

        public Criteria andGeoIsNotNull() {
            addCriterion("geo is not null");
            return (Criteria) this;
        }

        public Criteria andGeoEqualTo(String value) {
            addCriterion("geo =", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotEqualTo(String value) {
            addCriterion("geo <>", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoGreaterThan(String value) {
            addCriterion("geo >", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoGreaterThanOrEqualTo(String value) {
            addCriterion("geo >=", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLessThan(String value) {
            addCriterion("geo <", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLessThanOrEqualTo(String value) {
            addCriterion("geo <=", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoLike(String value) {
            addCriterion("geo like", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotLike(String value) {
            addCriterion("geo not like", value, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoIn(List<String> values) {
            addCriterion("geo in", values, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotIn(List<String> values) {
            addCriterion("geo not in", values, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoBetween(String value1, String value2) {
            addCriterion("geo between", value1, value2, "geo");
            return (Criteria) this;
        }

        public Criteria andGeoNotBetween(String value1, String value2) {
            addCriterion("geo not between", value1, value2, "geo");
            return (Criteria) this;
        }

        public Criteria andTimelineIsNull() {
            addCriterion("timeline is null");
            return (Criteria) this;
        }

        public Criteria andTimelineIsNotNull() {
            addCriterion("timeline is not null");
            return (Criteria) this;
        }

        public Criteria andTimelineEqualTo(Date value) {
            addCriterion("timeline =", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotEqualTo(Date value) {
            addCriterion("timeline <>", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineGreaterThan(Date value) {
            addCriterion("timeline >", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineGreaterThanOrEqualTo(Date value) {
            addCriterion("timeline >=", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineLessThan(Date value) {
            addCriterion("timeline <", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineLessThanOrEqualTo(Date value) {
            addCriterion("timeline <=", value, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineIn(List<Date> values) {
            addCriterion("timeline in", values, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotIn(List<Date> values) {
            addCriterion("timeline not in", values, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineBetween(Date value1, Date value2) {
            addCriterion("timeline between", value1, value2, "timeline");
            return (Criteria) this;
        }

        public Criteria andTimelineNotBetween(Date value1, Date value2) {
            addCriterion("timeline not between", value1, value2, "timeline");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeIsNull() {
            addCriterion("last_updatime is null");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeIsNotNull() {
            addCriterion("last_updatime is not null");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeEqualTo(Date value) {
            addCriterion("last_updatime =", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeNotEqualTo(Date value) {
            addCriterion("last_updatime <>", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeGreaterThan(Date value) {
            addCriterion("last_updatime >", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updatime >=", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeLessThan(Date value) {
            addCriterion("last_updatime <", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeLessThanOrEqualTo(Date value) {
            addCriterion("last_updatime <=", value, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeIn(List<Date> values) {
            addCriterion("last_updatime in", values, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeNotIn(List<Date> values) {
            addCriterion("last_updatime not in", values, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeBetween(Date value1, Date value2) {
            addCriterion("last_updatime between", value1, value2, "last_updatime");
            return (Criteria) this;
        }

        public Criteria andLast_updatimeNotBetween(Date value1, Date value2) {
            addCriterion("last_updatime not between", value1, value2, "last_updatime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}