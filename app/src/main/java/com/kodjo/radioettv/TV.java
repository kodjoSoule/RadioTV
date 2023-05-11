package com.kodjo.radioettv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class TV extends AppCompatActivity {
    private ListView listeView ;
    private SearchView searchView ;
    String[] monListe = { "Ortm 1", "Ortm 2","France 24", "Tv5 monde" } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v);
        listeView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);
        //Modifier le  bouton Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Listes TV");
        //
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monListe);
        listeView.setAdapter(myAdapter);
        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //case 0 : startActivity(new Intent(getApplicationContext(), RFI.class));
                }
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}