package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreMapper genreMapper;
	@Autowired
	private GenreRepository genreRepository;
	
	
	public GenreDTO save(GenreDTO dto) {
		GenreEntity entity = genreMapper.dto2Entity(dto);
		GenreEntity savedEntity = genreRepository.save(entity);
		GenreDTO result = genreMapper.entity2Dto(savedEntity);
		return result;
	}

	public List<GenreDTO> getAll() {
		List<GenreEntity> entities = genreRepository.findAll();
		List<GenreDTO> result = genreMapper.entityList2DtoList(entities);

		return result;
	}

	public GenreDTO get(Long id){
		Optional<GenreEntity> genre = genreRepository.findById(id);
		return genreMapper.entity2Dto(genre.get());
	}

}
