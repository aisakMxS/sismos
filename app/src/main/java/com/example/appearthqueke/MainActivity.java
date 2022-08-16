package com.example.appearthqueke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appearthqueke.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Earthquake> eqList = new ArrayList<>();
        eqList.add(new Earthquake("001", "Carchi - Tulcan", 5.0, 15082022, 100.5, 154.8 ));
        eqList.add(new Earthquake("002", "Guayas - Guayaquil", 5.0, 15082022, 100.5, 154.8 ));
        eqList.add(new Earthquake("003", "Chimborazo - Alausi", 5.0, 15082022, 100.5, 154.8 ));
        eqList.add(new Earthquake("004", "Carchi - Tulcan", 3.0, 15082022, 100.5, 154.8 ));
        eqList.add(new Earthquake("005", "Carchi - Tulcan", 2.0, 15082022, 100.5, 154.8 ));

        EqAdapter adapter = new EqAdapter();

        adapter.setOnItemClickListener(earthquake ->{
            //Toast.makeText(MainActivity.this, earthquake.getPlace(),
            //Toast.LENGTH_SHORT).show()
            abrir_eq_detalle(earthquake);
                });



        binding.eqRecycler.setAdapter(adapter);
        adapter.submitList(eqList);

        if(eqList.isEmpty()){
            binding.emptyView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyView.setVisibility(View.GONE);
        }

    }

    private void abrir_eq_detalle (Earthquake earthquake){
        Intent intent = new Intent(this, EqDetalle.class);
        intent.putExtra(EqDetalle.DT_EARTHQUAKE_KEY,earthquake);
        startActivity(intent);
    }
}