package com.mamba.popidea.constant;

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

        TagStatus(int status){
            this.status=status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}