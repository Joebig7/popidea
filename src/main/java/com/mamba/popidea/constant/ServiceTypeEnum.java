package com.mamba.popidea.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 14:16
 * @description 业务状态类型
 */
public final class ServiceTypeEnum {

    public enum UserStatus {
        // 0-禁用 1正常
        DISABLE(0),
        NORMAL(1);

        private int status;

        UserStatus(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }


    public enum QuestionStatus {
        DISABLE(0),
        NORMAL(1),
        DELETE(2);

        QuestionStatus(Integer status) {
            this.status = status;
        }

        public Integer status;

        public Integer getStatus() {
            return status;
        }
    }

    public enum AnswerStatus {
        DISABLE(0),
        NORMAL(1),
        DELETE(2);

        private Integer status;

        AnswerStatus(Integer status) {
            this.status = status;

        }

        public Integer getStatus() {
            return status;
        }
    }

    public enum ColumnStatus {
        DISABLE(0),
        NORMAL(1),
        DELETE(2);

        ColumnStatus(Integer status) {
            this.status = status;
        }

        public Integer status;

        public Integer getStatus() {
            return status;
        }
    }

    public enum TagStatus {
        //0-默认 1-用户新添加 2-禁用
        DEFAULT(0),
        NEW(1),
        DISABLE(2);

        public int status;

        TagStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public enum ArticleStatus {
        //0-未审核 1-正常  2-禁用
        DISABLED(0),
        NORMAL(1),
        DISABLE(2);

        public int status;

        ArticleStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public enum CommentStatus {
        DISABLED(0),
        NORMAL(1);

        private Integer type;

        CommentStatus(Integer type) {
            this.type = type;
        }

        public int getStatus() {
            return type;
        }

    }

    public enum CommentType {
        TO_ANSWER(0, "COMMENT_TO_ANSWER"),
        TO_ARTICLE(1, "COMMENT_TO_ARTICLE");

        private Integer type;
        private String key;

        CommentType(Integer type, String key) {
            this.type = type;
            this.key = key;
        }

        public int getStatus() {
            return type;
        }

        public static String getKey(Integer type) {
            List<CommentType> result = Stream
                    .of(CommentType.values())
                    .filter(commentType -> type.equals(commentType.getStatus()))
                    .collect(Collectors.toList());
            return result.get(0).key;
        }

    }

    public enum ThumbType {
        TO_ANSWER(0, "THUMB_TO_ANSWER"),
        TO_ARTICLE(1, "THUMB_TO_ARTICLE"),
        TO_COMMENT(2, "THUMB_TO_COMMENT");

        private Integer type;
        private String key;

        ThumbType(Integer type, String key) {
            this.type = type;
            this.key = key;
        }

        public int getStatus() {
            return type;
        }

        public static String getKey(Integer type) {
            List<ThumbType> result = Stream
                    .of(ThumbType.values())
                    .filter(thumbType -> type.equals(thumbType.getStatus()))
                    .collect(Collectors.toList());
            return result.get(0).key;
        }
    }

    public enum ThumbStatus {
        UNMODIFIED(0),
        UP(1),
        DOWN(2),
        CANCLE_UP(3),
        CANCLE_DOWN(4);

        private Integer status;

        ThumbStatus(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }

    public enum AttentionType {
        ATTENTION_TO_ANSWER(0, "ATTENTION_TO_ANSWER"),
        ATTENTION_TO_COLUMN(1, "ATTENTION_TO_ARTICLE"),
        ATTENTION_TO_USER(2, "ATTENTION_TO_COMMENT");

        private Integer type;
        private String key;

        AttentionType(Integer type, String key) {
            this.type = type;
            this.key = key;
        }

        public int getStatus() {
            return type;
        }

        public static String getKey(Integer type) {
            List<ThumbType> result = Stream
                    .of(ThumbType.values())
                    .filter(thumbType -> type.equals(thumbType.getStatus()))
                    .collect(Collectors.toList());
            return result.get(0).key;
        }
    }


    public enum AttentionStatus {
        CANCLE_FOLLOW(0),
        FOLLOWER(1);

        private Integer status;

        AttentionStatus(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }

    public enum FavType {
        FAV_ANSWER(0),
        FAV_ARTICLE(1);
        private Integer type;

        FavType(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }
    }

}