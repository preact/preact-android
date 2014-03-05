package com.preact.preactandroidtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.preact.preactandroid.EventLogger;
import com.preact.preactandroid.model.AccountModel;
import com.preact.preactandroid.model.ActionLinkModel;
import com.preact.preactandroid.model.EventDataModel;
import com.preact.preactandroid.model.EventModel;
import com.preact.preactandroid.model.PersonModel;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private EventLogger logger = null;
	private PersonModel user = null;
	
	static private final String TAG = "PreactAndroidTest";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		logger = new EventLogger("PROJECT_CODE", "API_SECRET");
		
		user = new PersonModel();
        user.setEmail("cgooley@preact.com");
        user.setName("Christopher Gooley");
        user.setCreated_at("1367259292.74");
        user.setUid("cgooley");
        
        /**
         * Register Button
         */
		final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Resgistered");
		        
				EventModel event = new EventModel();
				event.setName("registered");
				
				EventDataModel eventData = new EventDataModel(event, user);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        /**
         * Upgrade Button
         */
		final Button upgradeButton = (Button) findViewById(R.id.upgrade_button);
        upgradeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Upgraded");
		        
		        PersonModel eventUser = new PersonModel(user);
		        
		        Map<String, Object> properties = new HashMap<String, Object>();
		        properties.put("is_paying", true);
		        properties.put("subscription_level", 2);
		        properties.put("subscription_level_name", "Pro");
		        
		        eventUser.setProperties(properties);
		        
				EventModel event = new EventModel();
				event.setName("upgraded");
				
				EventDataModel eventData = new EventDataModel(event, eventUser);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        /**
         * Purchase Button
         */
		final Button purchaseButton = (Button) findViewById(R.id.purchase_button);
        purchaseButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Purchased Item");
		        
				EventModel event = new EventModel();
				event.setName("purchased:item");
				event.setNote("Georgia Tech Hoodie");
				event.setRevenue(3995f);
				
		        Map<String, Object> extras = new HashMap<String, Object>();
		        extras.put("color", "blue");
		        extras.put("size", "L");
		        
		        event.setExtras(extras);
		        
				EventDataModel eventData = new EventDataModel(event, user);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        /**
         * View Item Button
         */
		final Button viewItemButton = (Button) findViewById(R.id.item_view_button);
        viewItemButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Viewed Item");
		        
				EventModel event = new EventModel();
				event.setName("viewed:item");
				event.setNote("Test Item");
				
		        Random rand = new Random();
		        int randomNum = rand.nextInt((9999 - 1999) + 1) + 1999;
		        
		        event.setTarget_id("sku_" + Integer.toString(randomNum));
				
		        Map<String, Object> extras = new HashMap<String, Object>();
		        extras.put("color", "Test Color");
		        extras.put("category", "Test");
	        		
		        event.setExtras(extras);
		        
				EventDataModel eventData = new EventDataModel(event, user);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        /**
         * View Item w/ Account Button
         */
		final Button viewItemAccountButton = (Button) findViewById(R.id.item_view_account_button);
        viewItemAccountButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Viewed Item");
		        
				EventModel event = new EventModel();
				event.setName("viewed:item");
				
		        Random rand = new Random();
		        int randomNum = rand.nextInt((9999 - 1999) + 1) + 1999;
		        
		        event.setTarget_id("sku_" + Integer.toString(randomNum));
		        
		        AccountModel acct = new AccountModel();
		        acct.setId("51bfacbcc825616984000001");
		        acct.setName("Preact-dev");	        
		        	        
		        event.setAccount(acct);
		        
				EventDataModel eventData = new EventDataModel(event, user);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        /**
         * View Item w/ Links Button
         */
		final Button viewItemLinksButton = (Button) findViewById(R.id.item_view_links_button);
        viewItemLinksButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
		        Log.d(TAG, "User Viewed Item");
		        
				EventModel event = new EventModel();
				event.setName("viewed:item");
				
		        Random rand = new Random();
		        int randomNum = rand.nextInt((9999 - 1999) + 1) + 1999;
		        
		        event.setTarget_id("sku_" + Integer.toString(randomNum));
		        
		        List<ActionLinkModel> linksList = new ArrayList<ActionLinkModel>();
		        linksList.add(new ActionLinkModel("item", "http://blah.com/2352342"));
		        
		        ActionLinkModel[] links = new ActionLinkModel[linksList.size()];
		        linksList.toArray(links);
		        
		        event.setLinks(links);
				
				EventDataModel eventData = new EventDataModel(event, user);
				Log.d(TAG, eventData.getJSONString());
				
				try {
					logger.logEvent(eventData.getJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
