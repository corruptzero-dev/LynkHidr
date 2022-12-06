package ru.corruptzero.lynkhidr.service.impl;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.corruptzero.lynkhidr.service.CoderService;

@Service
@ConditionalOnProperty(name = "app.coder.method", havingValue = "hashed", matchIfMissing = true)
public class CoderServiceImpl implements CoderService {
    @Autowired
    private Hashids hashids;

    @Override
    public String encode(Long value) {
        return hashids.encode(value);
    }

    @Override
    public Long decode(String value) {
        return hashids.decode(value)[0];
    }
}
