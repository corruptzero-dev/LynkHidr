package ru.corruptzero.lynkhidr.service;

public interface CoderService {
    String encode(Long value);

    Long decode(String value);
}
