package com.cashwu.javaaop;

import com.cashwu.javaaop.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("demo text");
        comment.setAuthor("cash");

        //        String value = commentService.publishComment(comment);
        //        logger.info("-- value : " + value + " --");

        //        commentService.deleteComment(comment);

        //        String value = commentService.updateComment(comment);
        //        logger.info("-- value : " + value + " --");

        commentService.deleteComment(comment);
    }

}
