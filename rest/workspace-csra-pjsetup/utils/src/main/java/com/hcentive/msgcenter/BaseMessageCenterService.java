package com.hcentive.msgcenter;

import java.util.List;

import com.hcentive.msgcenter.domain.MessageCenter;

/**
 * @author rohit.bansal
 * 
 * 
 * 
 */
public interface BaseMessageCenterService {

	/**
	 * Populate messages in {@code MessageCenter} from specific web-services
	 * implementation
	 * 
	 * @param userProfileId
	 *            Mandatory field for fetching messages of any particular
	 *            category
	 * 
	 */
	public void populateMessages(Long userProfileId);

	/**
	 * Fetch messages from {@code MessageCenter} on the basis of
	 * {@code MessageFetchType} that could be either archived or default
	 * category for a particular user or specific message-by-id.
	 * 
	 * @param userProfileId
	 *            Mandatory field for fetching messages of any particular
	 *            category
	 * @param args
	 *            Any additional metadata information for the messages being
	 *            fetched
	 * 
	 */
	public List<MessageCenter> fetchMessages(Long userProfileId, MessageFetchType messageFetchType, String... args);

	/**
	 * Update message in {@code MessageCenter} based on the
	 * {@code MessageUpdateType} that could be one of READ, UNREAD, ARCHIVE, etc
	 * 
	 * @param userProfileId
	 *            Mandatory field for updating messages of any particular
	 *            category
	 * @param args
	 *            Any additional metadata information for the messages being
	 *            updated
	 * 
	 */
	public void updateMessages(Long userProfileId, List<Long> messageIds, MessageUpdateType messageUpdateType, String... args);

}
