package com.commentapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.commentapp.entity.UserEntity;
import com.commentapp.service.CommentService;
@SessionAttributes({"credLogin","comments"})
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public ModelAndView SaveComment(@ModelAttribute("comments") UserEntity comments) {
		ModelAndView modelAndView = new ModelAndView();
		commentService.saveComment(comments);
		modelAndView.setViewName("comments");
		List<UserEntity> allComments = commentService.showAllComments();
		modelAndView.addObject("allComments", allComments);
		return modelAndView;
	}
	
	@RequestMapping(value = "/filter")
	public ModelAndView filterComments(@ModelAttribute("comments") UserEntity comment) {
		System.out.println("comobj: "+comment);
		ModelAndView modelAndView = new ModelAndView();
		List<UserEntity> myComments = commentService.findCommentsByCred(comment.getCred());
		System.out.println("comms: "+myComments);
		modelAndView.setViewName("comments");
		modelAndView.addObject("myComments", myComments);
		return modelAndView;
	}
}
