package com.example.BookShop.dao;

import com.example.BookShop.entity.genre.GenreEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface GenreRepository extends JpaRepository<GenreEntity,Integer> {

    List<GenreEntity> findAllByOrderByParentIdAsc();
}
