package com.tj.edu.training.shinsunyoung.controller;

import com.tj.edu.training.shinsunyoung.model.Article;
import com.tj.edu.training.shinsunyoung.model.dto.ArticleListViewResponse;
import com.tj.edu.training.shinsunyoung.model.dto.ArticleResponse;
import com.tj.edu.training.shinsunyoung.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model){

        List<ArticleListViewResponse> articleResponseList  = articleService.getArticleAll().stream()

                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articleResponseList);

//        model.addAttribute("articles", articleService.getArticleAll());
        return "articleList";
    }


//    @GetMapping("/new-article")
//    public String newArticles(Model model){
//        return "newArticle";
//    }


    @GetMapping("/new-article")
    public String newArticles(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("article", new ArticleResponse());
        }
        else{
            Article article = articleService.getArticle(id);
            model.addAttribute("article", new ArticleResponse(article));
        }
        return "newArticle";
    }



    @GetMapping("/viewArticle/{id}")
    public String getArticles(@PathVariable Long id, Model model){
        Article article = articleService.getArticle(id);
        model.addAttribute("article", new ArticleResponse(article));
        return "viewArticle";
    }


}
