package com.cashwu.javaaop.services;

import com.cashwu.javaaop.Comment;
import com.cashwu.javaaop.ToLog;
import com.cashwu.javaaop.ToLogBefore;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * @author cash.wu
 * @since 2024/04/17
 */
@Service
public class CommentService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment " + comment);

        return "success";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        logger.info("Delete comment " + comment);

        return "OK";
    }

    @ToLogBefore
    public String updateComment(Comment comment) {
        logger.info("update comment " + comment);

        return "Success ~~";
    }
}
