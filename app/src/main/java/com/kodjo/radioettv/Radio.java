package com.kodjo.radioettv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Radio extends AppCompatActivity {
    private ListView listeView ;
    private SearchView searchView ;
    String[] monListe = {   "Rfi",
                            "Radio Mali",
                            "Radio JEKAFO",
                            "Radio Chaine 2",
                            "Radio Kledu",
                            "Radio Energie"
    } ;
    String[] urlRadio ={
            "https://rfimonde64k.ice.infomaniak.ch/rfimonde-64.mp3",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        listeView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);
        //Modifier le  bouton Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Listes Radio");
        //
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monListe);
        listeView.setAdapter(myAdapter);
        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 : demarrerRadio(position);break;
                    case 1 : demarrerRadio(position);break;
                    case 2 : demarrerRadio(position);break;
                    case 3 : demarrerRadio(position);break;
                    case 4 : demarrerRadio(position);break;
                    case 5 : demarrerRadio(position);break;
                    case 6 : demarrerRadio(position);break;
                    case 7 : demarrerRadio(position);break;
                    case 8 : demarrerRadio(position);break;
                    case 9 : demarrerRadio(position);break;
                    case 10 : demarrerRadio(position);break;
                    case 11 : demarrerRadio(position);break;
                    case 12 : demarrerRadio(position);break;
                    case 13 : demarrerRadio(position);break;
                    case 14 : demarrerRadio(position);break;
                    case 15 : demarrerRadio(position);break;
                    case 16 : demarrerRadio(position);break;
                   // case 0 : startActivity(new Intent(getApplicationContext(), RFI.class));
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
    //Recuperer le nom de liste en fonction de position
    public String getNomListe(String liste[], int posit){
        return liste[posit] ;
    }
    //Demarrer Radio methode
    public void demarrerRadio(int posit){
        Intent intent = new Intent(getApplicationContext(), RadioItem.class);
        intent.putExtra("nom",getNomListe(monListe, posit));

        startActivity(intent);
    }

}