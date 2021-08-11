package com.learn.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        final ListView listNotes = findViewById(R.id.list_notes);
        final List<NoteInfo> listOfNotes = DataManager.getInstance().getNotes();
        final ArrayAdapter<NoteInfo>  adapterNotes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfNotes);

        listNotes.setAdapter(adapterNotes);
    }
}