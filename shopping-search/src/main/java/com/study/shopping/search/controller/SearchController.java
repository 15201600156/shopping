package com.study.shopping.search.controller;

import com.study.shopping.common.vo.search.SearchParam;
import com.study.shopping.common.vo.search.SearchResult;
import com.study.shopping.search.service.impl.MallSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 商城检索
 */
@Controller
public class SearchController {

    @Autowired
    MallSearchServiceImpl mallSearchService;

    @GetMapping("/list.html")
    public String listPage(SearchParam param, Model model, HttpServletRequest request) {

        param.set_queryString(request.getQueryString());
        SearchResult result = mallSearchService.search(param);
        model.addAttribute("result", result);
        return "list";
    }
}
