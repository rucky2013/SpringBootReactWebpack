package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ChatDao;
import com.model.Chat;

@Service
public class ChatService {

	@Autowired
	ChatDao chatDao;

	/**
	 * 
	 * @param chat
	 * @return
	 */
	public Chat create(Chat chat) {
		chat.setCreateDate(LocalDateTime.now());
		chat.setLastUpdateDate(LocalDateTime.now());
		chat.setCurrentUserCount(0);
		chat.setTotalUserCount(0);
		chat.setEnabled(true);
		return chatDao.save(chat);
	}

	/**
	 * 
	 * @param topRightLat
	 * @param topRightLng
	 * @param bottomLeftLat
	 * @param bottomLeftLng
	 * @return
	 */
	public List<Chat> getChatsInBounds(double topRightLat, double topRightLng, double bottomLeftLat,
			double bottomLeftLng) {
		return chatDao.getChatsInBounds(topRightLat, topRightLng, bottomLeftLat, bottomLeftLng);
	}
}
