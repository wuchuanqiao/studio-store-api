package com.studio.tc.store.api.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuanqiao.wu on 2015/3/1.
 */

public class ApiQuery implements Serializable {
    private long version;
    private Limit limit;
    private Set<Expression> andExpressions;
    private Set<Expression> orExpressions;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<Expression> getAndExpressions() {
        return andExpressions;
    }

    public void setAndExpressions(Set<Expression> andExpressions) {
        this.andExpressions = andExpressions;
    }

    public Set<Expression> getOrExpressions() {
        return orExpressions;
    }

    public void setOrExpressions(Set<Expression> orExpressions) {
        this.orExpressions = orExpressions;
    }

    public static enum Operation {
        EQUAL, LIKE, IN, OUT
    }

    private ApiQuery(long version) {
        this.version = version;
    }

    public static ApiQuery news(long version) {
        return new ApiQuery(version);
    }

    public ApiQuery and(String key, Object value, Operation... operation) {
        if (andExpressions == null) {
            andExpressions = new HashSet<Expression>();
        }
        andExpressions.add(new Expression(key, value, operation));
        return this;
    }

    public ApiQuery or(String key, Object value, Operation... operation) {
        if (orExpressions == null) {
            orExpressions = new HashSet<Expression>();
        }
        orExpressions.add(new Expression(key, value, operation));
        return this;
    }

    public ApiQuery limit(int offset, int count) {
        this.limit = new Limit(offset, count);
        return this;
    }

    private class Limit {
        private int offset;
        private int count;

        public Limit(int offset, int count) {
            this.offset = offset;
            this.count = count;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public class Expression {
        private String key;
        private Object value;
        private Operation[] operations;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Operation[] getOperations() {
            return operations;
        }

        public void setOperations(Operation[] operations) {
            this.operations = operations;
        }

        public Expression(String key, Object value, Operation... operations) {
            this.key = key;
            this.value = value;
            this.operations = operations;
        }
    }
}
