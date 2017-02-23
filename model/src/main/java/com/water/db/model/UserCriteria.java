package com.water.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCriteria() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andHightSchoolIsNull() {
            addCriterion("hight_school is null");
            return (Criteria) this;
        }

        public Criteria andHightSchoolIsNotNull() {
            addCriterion("hight_school is not null");
            return (Criteria) this;
        }

        public Criteria andHightSchoolEqualTo(String value) {
            addCriterion("hight_school =", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolNotEqualTo(String value) {
            addCriterion("hight_school <>", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolGreaterThan(String value) {
            addCriterion("hight_school >", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("hight_school >=", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolLessThan(String value) {
            addCriterion("hight_school <", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolLessThanOrEqualTo(String value) {
            addCriterion("hight_school <=", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolLike(String value) {
            addCriterion("hight_school like", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolNotLike(String value) {
            addCriterion("hight_school not like", value, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolIn(List<String> values) {
            addCriterion("hight_school in", values, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolNotIn(List<String> values) {
            addCriterion("hight_school not in", values, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolBetween(String value1, String value2) {
            addCriterion("hight_school between", value1, value2, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andHightSchoolNotBetween(String value1, String value2) {
            addCriterion("hight_school not between", value1, value2, "hightSchool");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNull() {
            addCriterion("university is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNotNull() {
            addCriterion("university is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityEqualTo(String value) {
            addCriterion("university =", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotEqualTo(String value) {
            addCriterion("university <>", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThan(String value) {
            addCriterion("university >", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThanOrEqualTo(String value) {
            addCriterion("university >=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThan(String value) {
            addCriterion("university <", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThanOrEqualTo(String value) {
            addCriterion("university <=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLike(String value) {
            addCriterion("university like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotLike(String value) {
            addCriterion("university not like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityIn(List<String> values) {
            addCriterion("university in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotIn(List<String> values) {
            addCriterion("university not in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityBetween(String value1, String value2) {
            addCriterion("university between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotBetween(String value1, String value2) {
            addCriterion("university not between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIsNull() {
            addCriterion("origin_address is null");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIsNotNull() {
            addCriterion("origin_address is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAddressEqualTo(String value) {
            addCriterion("origin_address =", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotEqualTo(String value) {
            addCriterion("origin_address <>", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressGreaterThan(String value) {
            addCriterion("origin_address >", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("origin_address >=", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLessThan(String value) {
            addCriterion("origin_address <", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLessThanOrEqualTo(String value) {
            addCriterion("origin_address <=", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLike(String value) {
            addCriterion("origin_address like", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotLike(String value) {
            addCriterion("origin_address not like", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIn(List<String> values) {
            addCriterion("origin_address in", values, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotIn(List<String> values) {
            addCriterion("origin_address not in", values, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressBetween(String value1, String value2) {
            addCriterion("origin_address between", value1, value2, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotBetween(String value1, String value2) {
            addCriterion("origin_address not between", value1, value2, "originAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressIsNull() {
            addCriterion("now_address is null");
            return (Criteria) this;
        }

        public Criteria andNowAddressIsNotNull() {
            addCriterion("now_address is not null");
            return (Criteria) this;
        }

        public Criteria andNowAddressEqualTo(String value) {
            addCriterion("now_address =", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotEqualTo(String value) {
            addCriterion("now_address <>", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThan(String value) {
            addCriterion("now_address >", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThanOrEqualTo(String value) {
            addCriterion("now_address >=", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThan(String value) {
            addCriterion("now_address <", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThanOrEqualTo(String value) {
            addCriterion("now_address <=", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLike(String value) {
            addCriterion("now_address like", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotLike(String value) {
            addCriterion("now_address not like", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressIn(List<String> values) {
            addCriterion("now_address in", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotIn(List<String> values) {
            addCriterion("now_address not in", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressBetween(String value1, String value2) {
            addCriterion("now_address between", value1, value2, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotBetween(String value1, String value2) {
            addCriterion("now_address not between", value1, value2, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusIsNull() {
            addCriterion("emotion_status is null");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusIsNotNull() {
            addCriterion("emotion_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusEqualTo(Integer value) {
            addCriterion("emotion_status =", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusNotEqualTo(Integer value) {
            addCriterion("emotion_status <>", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusGreaterThan(Integer value) {
            addCriterion("emotion_status >", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("emotion_status >=", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusLessThan(Integer value) {
            addCriterion("emotion_status <", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("emotion_status <=", value, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusIn(List<Integer> values) {
            addCriterion("emotion_status in", values, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusNotIn(List<Integer> values) {
            addCriterion("emotion_status not in", values, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusBetween(Integer value1, Integer value2) {
            addCriterion("emotion_status between", value1, value2, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andEmotionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("emotion_status not between", value1, value2, "emotionStatus");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNull() {
            addCriterion("header_img is null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIsNotNull() {
            addCriterion("header_img is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderImgEqualTo(Integer value) {
            addCriterion("header_img =", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotEqualTo(Integer value) {
            addCriterion("header_img <>", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThan(Integer value) {
            addCriterion("header_img >", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgGreaterThanOrEqualTo(Integer value) {
            addCriterion("header_img >=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThan(Integer value) {
            addCriterion("header_img <", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgLessThanOrEqualTo(Integer value) {
            addCriterion("header_img <=", value, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgIn(List<Integer> values) {
            addCriterion("header_img in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotIn(List<Integer> values) {
            addCriterion("header_img not in", values, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgBetween(Integer value1, Integer value2) {
            addCriterion("header_img between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andHeaderImgNotBetween(Integer value1, Integer value2) {
            addCriterion("header_img not between", value1, value2, "headerImg");
            return (Criteria) this;
        }

        public Criteria andQuestionOneIsNull() {
            addCriterion("question_one is null");
            return (Criteria) this;
        }

        public Criteria andQuestionOneIsNotNull() {
            addCriterion("question_one is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionOneEqualTo(String value) {
            addCriterion("question_one =", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneNotEqualTo(String value) {
            addCriterion("question_one <>", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneGreaterThan(String value) {
            addCriterion("question_one >", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneGreaterThanOrEqualTo(String value) {
            addCriterion("question_one >=", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneLessThan(String value) {
            addCriterion("question_one <", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneLessThanOrEqualTo(String value) {
            addCriterion("question_one <=", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneLike(String value) {
            addCriterion("question_one like", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneNotLike(String value) {
            addCriterion("question_one not like", value, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneIn(List<String> values) {
            addCriterion("question_one in", values, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneNotIn(List<String> values) {
            addCriterion("question_one not in", values, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneBetween(String value1, String value2) {
            addCriterion("question_one between", value1, value2, "questionOne");
            return (Criteria) this;
        }

        public Criteria andQuestionOneNotBetween(String value1, String value2) {
            addCriterion("question_one not between", value1, value2, "questionOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIsNull() {
            addCriterion("answer_one is null");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIsNotNull() {
            addCriterion("answer_one is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerOneEqualTo(String value) {
            addCriterion("answer_one =", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotEqualTo(String value) {
            addCriterion("answer_one <>", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneGreaterThan(String value) {
            addCriterion("answer_one >", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneGreaterThanOrEqualTo(String value) {
            addCriterion("answer_one >=", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLessThan(String value) {
            addCriterion("answer_one <", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLessThanOrEqualTo(String value) {
            addCriterion("answer_one <=", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLike(String value) {
            addCriterion("answer_one like", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotLike(String value) {
            addCriterion("answer_one not like", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIn(List<String> values) {
            addCriterion("answer_one in", values, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotIn(List<String> values) {
            addCriterion("answer_one not in", values, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneBetween(String value1, String value2) {
            addCriterion("answer_one between", value1, value2, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotBetween(String value1, String value2) {
            addCriterion("answer_one not between", value1, value2, "answerOne");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoIsNull() {
            addCriterion("question_two is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoIsNotNull() {
            addCriterion("question_two is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoEqualTo(String value) {
            addCriterion("question_two =", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoNotEqualTo(String value) {
            addCriterion("question_two <>", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoGreaterThan(String value) {
            addCriterion("question_two >", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoGreaterThanOrEqualTo(String value) {
            addCriterion("question_two >=", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoLessThan(String value) {
            addCriterion("question_two <", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoLessThanOrEqualTo(String value) {
            addCriterion("question_two <=", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoLike(String value) {
            addCriterion("question_two like", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoNotLike(String value) {
            addCriterion("question_two not like", value, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoIn(List<String> values) {
            addCriterion("question_two in", values, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoNotIn(List<String> values) {
            addCriterion("question_two not in", values, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoBetween(String value1, String value2) {
            addCriterion("question_two between", value1, value2, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andQuestionTwoNotBetween(String value1, String value2) {
            addCriterion("question_two not between", value1, value2, "questionTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIsNull() {
            addCriterion("answer_two is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIsNotNull() {
            addCriterion("answer_two is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoEqualTo(String value) {
            addCriterion("answer_two =", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotEqualTo(String value) {
            addCriterion("answer_two <>", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoGreaterThan(String value) {
            addCriterion("answer_two >", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoGreaterThanOrEqualTo(String value) {
            addCriterion("answer_two >=", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLessThan(String value) {
            addCriterion("answer_two <", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLessThanOrEqualTo(String value) {
            addCriterion("answer_two <=", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLike(String value) {
            addCriterion("answer_two like", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotLike(String value) {
            addCriterion("answer_two not like", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIn(List<String> values) {
            addCriterion("answer_two in", values, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotIn(List<String> values) {
            addCriterion("answer_two not in", values, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoBetween(String value1, String value2) {
            addCriterion("answer_two between", value1, value2, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotBetween(String value1, String value2) {
            addCriterion("answer_two not between", value1, value2, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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