package edu.orangecoastcollege.cs273.mpaulding.ocmusicevents;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;


public class EventListActivity extends ListActivity {

    private Context context = this;
    private ListView eventsListView;
    private ArrayList<MusicEvent> allMusicEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        eventsListView = (ListView) findViewById(R.id.eventsListView);

        try {
            allMusicEvents = JSONLoader.loadJSONFromAsset(context, "MusicEvents.json");
        }
        catch (IOException ex)
        {
            Log.e("OC Music Events", "Error loading JSON data." + ex.getMessage());
        }

       setListAdapter(new MusicEventAdapter(this, R.layout.music_event_list_item, allMusicEvents));


        //setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        MusicEvent selectedEvent = allMusicEvents.get(pos);
        detailsIntent.putExtra("Title", selectedEvent.getTitle());
        detailsIntent.putExtra("Date", selectedEvent.getDate());
        detailsIntent.putExtra("Day", selectedEvent.getDay());
        detailsIntent.putExtra("Time", selectedEvent.getTime());
        detailsIntent.putExtra("Location", selectedEvent.getLocation());
        detailsIntent.putExtra("Address1", selectedEvent.getAddress1());
        detailsIntent.putExtra("Address2", selectedEvent.getAddress2());
        detailsIntent.putExtra("ImageName", selectedEvent.getImageName());
        startActivity(detailsIntent);
    }
}
