package com.cache;

import java.util.Date;
import java.util.HashMap;

public class App {
	
	private CacheHolder cacheHolder = new CacheHolder();
	
	private class CacheHolder {
		private int autoKey = 0;
		private HashMap<Integer, Cache> mCache = new HashMap<>();

		public void add(String data) {
			mCache.put(autoKey, new Cache(data));
			autoKey++;
		}
		
		public String get(int key) {
			return mCache.get(key).toString();
		}
		
		private class Cache {
			private String data;
			private Date timestamp;
			
			public Cache(String data) {
				super();
				this.data = data;
				this.timestamp = new Date();
			}

			@Override
			public String toString() {
				return "Cache [data=" + data + ", timestamp=" + timestamp + "]";
			}
		}
	}
	
	public void add(String data) {
		cacheHolder.add(data);
	}
	
	public String get(int key) {
		return cacheHolder.get(key).toString();
	}
	

}
