package ru.corruptzero.lynkhidr.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.corruptzero.lynkhidr.domain.entity.Link;
import ru.corruptzero.lynkhidr.repository.LinkRepository;

@RequiredArgsConstructor
@Service
public class LinkService {

    private final LinkRepository repository;

    public Long save(String linkUrl) {
        Link link = Link.builder().url(linkUrl).build();
        return repository.save(link).getId();
    }

    public Link getById(Long linkId) {
        return repository.getById(linkId);
    }
}
