package com.hcentive.utils.batcher;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides and interface to define tasks. These tasks are executed
 * on an input list in batches. Use full for performing repetitive tasks on
 * large lists.
 * 
 * @author Ankit Khattar
 * 
 */
public class Batcher {
	private static final Logger log = LoggerFactory.getLogger(Batcher.class);

	public static <T> void execute(int batchSize, List<T> inputData, BatchTask<T> task) {
		if (batchSize == 0) {
			throw new IllegalArgumentException("Batch size must be greater than 0");
		}
		if (inputData == null || inputData.size() == 0) {
			log.debug("No data to process");
			return;
		}
		int offset = 0;
		while (offset + batchSize < inputData.size()) {
			log.debug("Batch range " + offset + "-" + (offset + batchSize - 1));
			task.execute(inputData.subList(offset, offset + batchSize));
			offset += batchSize;
		}
		log.debug("Batch range " + offset + "-" + (inputData.size() - 1));
		task.execute(inputData.subList(offset, inputData.size()));
	}

	public interface BatchTask<T> {
		public void execute(List<T> input);
	}
}
