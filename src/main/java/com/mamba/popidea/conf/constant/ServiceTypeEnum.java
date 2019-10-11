package com.mamba.popidea.conf.constant;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 14:16
 * @description 业务状态类型
 */
public final class ServiceTypeEnum {


    public enum CommentStatus {
        COMMENT_TO_QUESTION(0),
        COMMENT_TO_ARTICLE(1),
        COMMENT_TO_USER(2);

        private Integer type;

        CommentStatus(Integer type) {
            this.type = type;
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

}