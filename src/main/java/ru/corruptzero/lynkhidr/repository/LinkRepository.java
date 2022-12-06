package ru.corruptzero.lynkhidr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.corruptzero.lynkhidr.domain.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
