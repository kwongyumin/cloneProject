package com.clone.cloneproject.controller;


import com.clone.cloneproject.domain.Comments;
import com.clone.cloneproject.dto.CommentsRequestDto;
import com.clone.cloneproject.service.CommnetsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentsController {

    private final CommnetsService commnetsService;



    public CommentsController( CommnetsService commnetsService) {
        this.commnetsService = commnetsService;
    }

    //등록
    @PostMapping("/comments/{commentid}")
    public Comments getComments(@PathVariable Long commentid,@RequestBody CommentsRequestDto requestDto, @AuthenticationPrincipal User user) throws Exception {
        return commnetsService.postComment(commentid,requestDto,user);
    }

    //수정
    @PutMapping("/comments/{commnetid}")
    public Long updateComment(@PathVariable Long commnetid, @RequestBody CommentsRequestDto requestDto){
        return commnetsService.updateComment(commnetid, requestDto);
    }

    //삭제
    @DeleteMapping("/comments/{commentid}")
    public void deleteComment(@PathVariable Long commentid){
        commnetsService.deleteComments(commentid);
    }




}