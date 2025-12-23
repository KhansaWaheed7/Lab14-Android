package com.example.lab14;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();

        itemList.add(new ItemModel("Apple", "Fresh red apples from local farms"));
        itemList.add(new ItemModel("Banana", "Naturally ripened bananas, high in energy"));
        itemList.add(new ItemModel("Orange", "Citrus fruit rich in Vitamin C"));
        itemList.add(new ItemModel("Mango", "Sweet and juicy tropical mangoes"));
        itemList.add(new ItemModel("Grapes", "Seedless green grapes, fresh and crunchy"));
        itemList.add(new ItemModel("Pineapple", "Tropical pineapple with tangy taste"));
        itemList.add(new ItemModel("Strawberry", "Fresh strawberries picked daily"));
        itemList.add(new ItemModel("Watermelon", "Refreshing fruit with high water content"));
        itemList.add(new ItemModel("Peach", "Soft and sweet peaches"));
        itemList.add(new ItemModel("Cherry", "Small, red and delicious cherries"));
        itemList.add(new ItemModel("Kiwi", "Exotic fruit rich in nutrients"));
        itemList.add(new ItemModel("Blueberry", "Antioxidant-rich blueberries"));
        itemList.add(new ItemModel("Papaya", "Healthy fruit good for digestion"));
        itemList.add(new ItemModel("Pomegranate", "Fresh red seeds full of iron"));
        itemList.add(new ItemModel("Guava", "Vitamin-rich tropical fruit"));

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}
