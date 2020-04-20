package github.sijoonlee.thirdapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myListData = getApplicationContext().getResources().getStringArray(R.array.animalsArray);

//        ArrayAdapter<CharSequence> adapterAnimals = ArrayAdapter.createFromResource(this,
//                R.array.animalsArray,
//                android.R.layout.simple_list_item_1);
//        Toast.makeText(getApplicationContext(), adapterAnimals.toString(), Toast.LENGTH_SHORT).show();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewAnimalList);
        MyAdapter adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
