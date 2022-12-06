package ru.corruptzero.lynkhidr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.corruptzero.lynkhidr.domain.entity.Link;
import ru.corruptzero.lynkhidr.service.CoderService;
import ru.corruptzero.lynkhidr.service.impl.LinkService;

@RequiredArgsConstructor
@Controller
@Slf4j
public class LinkController {

    private final LinkService service;

    private final CoderService coderService;

    @GetMapping("/{shortUrlCode}")
    public String redirectToUrl(@PathVariable String shortUrlCode) {
        log.info("Got shortUrl: " + shortUrlCode);
        Long linkId = coderService.decode(shortUrlCode);
        log.info("Got linkId: " + linkId);
        Link link = service.getById(linkId);
        String targetUrl = link.getUrl();
        log.info("Got url: " + linkId);
        if (!targetUrl.startsWith("http://") && !targetUrl.startsWith("https://")) {
            targetUrl = "http://" + targetUrl;
        }
        return "redirect:" + targetUrl;
    }

    @GetMapping("/")
    public String getPage() {
        return "index";
    }

    @PostMapping("/")
    public String createLink(@RequestParam String linkUrl, Model model) {
        Long linkId = service.save(linkUrl);
        String shortUrlCode = coderService.encode(linkId);
        model.addAttribute("shortUrlCode", shortUrlCode);
        return "index";
    }
}
